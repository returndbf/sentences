package com.dabenfeng.sentences.controller;
import com.dabenfeng.sentences.entity.Result;
import com.dabenfeng.sentences.entity.UserClockData;
import com.dabenfeng.sentences.entity.WxUser;
import com.dabenfeng.sentences.service.impl.WxUserServiceImpl;
import com.dabenfeng.sentences.utils.GetTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;

import javax.annotation.Resource;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
@RestController
public class WxLoginController {
    @Autowired
    private Result result;
    @Autowired
    private GetTimeUtils getTimeUtils;
    @Resource
    private WxUserServiceImpl wxUserService;
    String url="https://api.weixin.qq.com/sns/jscode2session?appid=wx98034faf5d7a73bf&secret=403726a6805445f0af8730b667ba78fd&js_code={?}&grant_type=authorization_code";
    @RequestMapping("wxLogin")
    public Result<String> wxLogin(@RequestParam(required = true,value = "code") String code){
        RestTemplate restTemplate = new RestTemplate();
        String trans = restTemplate.getForObject(url,String.class,code);
        //trans = restTemplate.getForObject(url,String.class,code);
//        System.out.println(trans.openid);
//        JSONObject jsonObject = JSON.parseObject(returnContent);
        JSONObject object = JSONObject.parseObject(trans);
        String openid = object.getString("openid"); //小程序用户openid
        System.out.println(openid);
        return result.successResult(openid);
    }

    @RequestMapping("checkUserRegister")
    public Result<Boolean> checkUserRegister(String openId){
        Boolean isRegister = false;
        WxUser wxUser = wxUserService.getWxUserByOpenId(openId);
        if(wxUser!=null){
            isRegister = true;
            System.out.println(openId);

            return result.successResult("已经注册,返回id",wxUser.getId());
        }else{
            System.out.println(openId);
            int row = wxUserService.insertWxUser(openId);
            if(row!=0){
                wxUser=wxUserService.getWxUserByOpenId(openId);
                int id = wxUser.getId();
                return result.successResult("注册完成,返回id",id);
            }
        }
        System.out.println(isRegister);
        return result.failResult();
    }

    @RequestMapping("userClockToday")
    public Result<String> userClockToday(int userId){
        return userClockUtil(userId);
    }

    public Result<String> userClockUtil(int userId){
        String clockData = wxUserService.userClockToday(userId);//获取最后一天打卡日期
        if(clockData == null ){
            return result.successResult("没有打卡记录",false);
        }
        String currentTime = getTimeUtils.getCurrentTime();
        if(clockData.substring(0,10).equals(currentTime.substring(0,10))){
            return result.successResult("今日已经打卡",true);
        }else{
            return result.successResult("今日未打卡",false);
        }
    }

    @RequestMapping("userClock")
    @Transactional
    public Result<Integer> userClock(UserClockData userClockData){
        int userId = userClockData.getUserId();
        if((Boolean) userClockUtil(userId).getData() == true){
            return result.successResult("今日已经打卡");
        }
        //打卡
        String currentTime = getTimeUtils.getCurrentTime();
        userClockData.setClockData(currentTime);
        int row = wxUserService.userClock(userClockData);
        if(row!=0){
            //打卡天数
            int day = wxUserService.userClockCount(userClockData.getUserId());
            if(day>0){
                return result.successResult(day);
            }
        }else{
            return result.failResult("打卡失败");
        }
        return result.failResult();
    }
}
