package com.dabenfeng.sentences.controller;

import com.dabenfeng.sentences.entity.Code;
import com.dabenfeng.sentences.entity.Result;
import com.dabenfeng.sentences.entity.Sentence;
import com.dabenfeng.sentences.service.impl.RainbowFartServiceImpl;
import com.dabenfeng.sentences.utils.GetTimeUtils;
import com.github.pagehelper.PageInfo;
//import org.apache.shiro.authz.annotation.RequiresAuthentication;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rainbowFart")
public class RainbowFactController {
    @Autowired
    private RainbowFartServiceImpl rainbowFartService;
    @Autowired
    private Result result;
    @Autowired
    private GetTimeUtils getTimeUtils;
    //获取全部彩虹屁对象

    @GetMapping("RainbowFart")
    public Result getAllRainbowFart(@RequestParam(value="page",defaultValue="1")Integer page, @RequestParam(value="pageSize",defaultValue="5")Integer pageSize) {
        //分页容器
        PageInfo<Sentence> pageInfo = rainbowFartService.getAllRainbowFart(page,pageSize);
        //获取真正的数据
        List<Sentence> rainbowFartsObj = pageInfo.getList();
        if (rainbowFartsObj.size() > 0) {
            return result.successResult(rainbowFartsObj);
        } else {
            return result.failResult();
        }
    }
    //获取全部彩虹屁句子
    @GetMapping("rainbowFartSentence")
    public Result getAllRainbowFartSentence(@RequestParam(value="page",defaultValue="1")Integer page, @RequestParam(value="pageSize",defaultValue="5")Integer pageSize) {
        //分页容器
        PageInfo<String> pageInfo = rainbowFartService.getAllRainbowFartSentence(page,pageSize);
        //获取真正的数据
        List<String> rainbowFarts = pageInfo.getList();
        if (rainbowFarts.size() > 0) {
            return result.successResult(rainbowFarts);
        } else {
            return result.failResult();
        }

    }
    //添加彩虹屁
   // @RequiresRoles("admin")
   // @RequiresPermissions("add")
    @PostMapping("rainbowFartSentence/rainbowFart")
    public Result insertRainbowFartSentence(Sentence sentence) {
        //句子添加时间
        sentence.setAddTime(getTimeUtils.getCurrentTime());
        //获取添加受影响行数
        Integer res = rainbowFartService.insertRainbowFartSentence(sentence);
        //获取添加完毕的对象,id为数据库id
        Sentence addedSentence = rainbowFartService.getRainbowFartObjById(sentence.getId());
        if (addedSentence != null && res > 0) {
            return result.successResult(addedSentence);
        } else {
            return result.failResult();
        }
    }
    //删除
    //@RequiresRoles("admin")
    //@RequiresPermissions("delete")
    @PutMapping("rainbowFartSentence/{id}")
    public Result deleteRainbowFartSentence(@PathVariable("id") Integer id) {
        //获取要修改的句子
        Sentence deletedSentence = rainbowFartService.getRainbowFartObjById(id);
        //句子删除时间
        deletedSentence.setDeleteTime(getTimeUtils.getCurrentTime());
        if (deletedSentence.getDelFlag() == 0) {
            if (rainbowFartService.deleteRainbowFartSentence(deletedSentence) > 0) {
                return result.successResult(rainbowFartService.getRainbowFartObjById(deletedSentence.getId()));
            } else {
                return result.failResult();
            }
        } else {
            return result.failResult("已经为删除状态");
        }
    }

    @GetMapping("rainbowFartObjById/{id}")
    public Result getRainbowFartObjById(@PathVariable("id") Integer id) {
        Sentence sentenceObj = rainbowFartService.getRainbowFartObjById(id);
        if (sentenceObj != null) {
            return result.successResult(sentenceObj);
        } else {
            return result.failResult();
        }
    }

    @GetMapping("rainbowFartById/{id}")
    public Result getRainbowFartById(@PathVariable("id") Integer id) {
        String sentence = rainbowFartService.getRainbowFartById(id);
        if (sentence != null) {
            return result.successResult(sentence);
        } else {
            return result.failResult();
        }
    }
    //@RequiresRoles("admin")
    @GetMapping("randomRainbowFartSentence")
    public Result getRandomRainbowFartSentence(){
        String sentence=null;
        sentence=rainbowFartService.getRandomRainbowFartSentence();
        if(sentence!=null){
            return result.successResult(sentence);
        }else{
            return result.failResult();
        }
    }

    @GetMapping("randomRainbowFart")
    public Result getRandomRainbowFart(){
        Sentence sentenceObj = null;
        sentenceObj=rainbowFartService.getRandomRainbowFart();
        if(sentenceObj!=null){
            return result.successResult(sentenceObj);
        }else{
            return result.failResult();
        }
    }

}
