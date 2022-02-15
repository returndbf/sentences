package com.dabenfeng.sentences.controller;

import com.dabenfeng.sentences.entity.BannerImg;
import com.dabenfeng.sentences.entity.Result;
import com.dabenfeng.sentences.service.BannerImgService;
import com.dabenfeng.sentences.service.impl.BannerImgServiceImpl;
import com.dabenfeng.sentences.utils.GetTimeUtils;
import com.dabenfeng.sentences.utils.UploadUtils;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class BannerImgController {
    @Resource
    private Result result;
    @Autowired
    private BannerImgServiceImpl bannerImgService;
    @Autowired
    private GetTimeUtils getTimeUtils;
    @RequestMapping("upload")
    @Transactional
    public Result upload( BannerImg bannerImg, MultipartFile imgFile, HttpServletRequest request, HttpSession session) {
        try {
            //获取时间
            bannerImg.setUploadTime(getTimeUtils.getCurrentTime());
            //添加img对象
            bannerImgService.insertBannerImg(bannerImg);
            //获取添加后的id
            int id = bannerImg.getId();
            //获取返回的文件名
            String newFileName = UploadUtils.uploadImg(imgFile);
            //图片路径添加到数据库
            bannerImgService.updateImg(new BannerImg().setImg("/IMG/"+newFileName).setId(id));
            return result.successResult("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.failResult();
    }

    @RequestMapping("getBannerImg")
    public Result<List> getBannerImg(){
        List list  = bannerImgService.getAllBannerImg();
        return list.size()!=0? result.successResult(list):result.failResult("查询失败或没有数据");
    }

    @RequestMapping("getAllRecommend")
    public Result<List> getAllRecommend(){
        List list  = bannerImgService.getAllRecommend();
        return list.size()!=0? result.successResult(list):result.failResult("查询失败或没有数据");
    }

    @RequestMapping("updateImg")
    public Result<String> updateImg(BannerImg bannerImg,MultipartFile imgFile){
        try {
            //获取时间
            bannerImg.setUploadTime(getTimeUtils.getCurrentTime());
            //获取返回的文件名
            String newFileName=UploadUtils.uploadImg(imgFile);
            //图片路径添加到数据库
            bannerImgService.updateImg(new BannerImg().setImg("/IMG/"+newFileName).setId(bannerImg.getId()));
            return result.successResult("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.failResult();
    }
    
    
    @RequestMapping("getpath")
    public String getpath(HttpServletRequest request){
        return ClassUtils.getDefaultClassLoader().getResource("static/IMG").getPath();
        //return request.getSession().getServletContext().getRealPath("")+"/WEB-INF/classes/static";
    }

}