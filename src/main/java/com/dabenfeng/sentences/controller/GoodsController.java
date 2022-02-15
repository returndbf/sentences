package com.dabenfeng.sentences.controller;

import com.dabenfeng.sentences.entity.BannerImg;
import com.dabenfeng.sentences.entity.Goods;
import com.dabenfeng.sentences.entity.Result;
import com.dabenfeng.sentences.entity.Sentence;
import com.dabenfeng.sentences.service.impl.GoodsServiceImpl;
import com.dabenfeng.sentences.utils.GetTimeUtils;
import com.dabenfeng.sentences.utils.UploadUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
@RestController
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;
    @Resource
    private Result result;
    @Autowired
    private GetTimeUtils getTimeUtils;
    @RequestMapping("getGoodsByType")
    public Result<List> getGoodsByType(String type, @RequestParam(value="page",defaultValue="1")Integer page, @RequestParam(value="pageSize",defaultValue="5")Integer pageSize){
        //分页容器
        PageInfo<Goods> pageInfo = goodsService.getGoodsByType(type,page,pageSize);
        //获取真正的数据
        List<Goods> Goods = pageInfo.getList();
        if (Goods.size() > 0) {
            return result.successResult(Goods);
        } else {
            return result.failResult();
        }
    }

    @RequestMapping("insertGoods")
    public Result<Goods> insertGoods(Goods goods, MultipartFile imgFile){
        try {
            //获取时间
            goods.setUploadTime(getTimeUtils.getCurrentTime());
            //添加img对象
            goodsService.insertGoods(goods);
            //获取添加后的id
            int id = goods.getId();
            //获取返回的文件名
            String newFileName = UploadUtils.uploadImg(imgFile);
            //goods对象添加img路径
            goods.setImg("/IMG/"+newFileName);
            //img路径添加到数据库
            goodsService.uploadImg(goods);
            return result.successResult(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.failResult();
    }

    @RequestMapping("selectById")
    public Result<Goods> selectById(Integer id){
        Goods goods = goodsService.selectById(id);
       return goods !=null?result.successResult(goods):result.failResult();
    }
}
