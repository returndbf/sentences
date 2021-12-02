package com.dabenfeng.sentences.controller;

import com.dabenfeng.sentences.entity.BannerImg;
import com.dabenfeng.sentences.entity.Result;
import com.dabenfeng.sentences.service.BannerImgService;
import com.dabenfeng.sentences.service.impl.BannerImgServiceImpl;
import com.dabenfeng.sentences.utils.UploadUtils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class ImgController {
    @Resource
    private Result result;
    @Autowired
    private BannerImgServiceImpl bannerImgService;
    @RequestMapping("upload")
    public Result upload( MultipartFile imgFile, HttpServletRequest request, HttpSession session) {
        // 拿到文件名
        String filename = imgFile.getOriginalFilename();
        //uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        //newFilename
        String newFileName = uuid.substring(0,10)+filename;
        // 存放上传图片的文件夹
        File fileDir = UploadUtils.upload();
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        System.out.println(fileDir.getAbsolutePath());
        try {
            // 构建真实的文件路径
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + newFileName);
            //压缩图片
            Thumbnails.of(imgFile.getInputStream()).scale(1f).outputQuality(1f).outputFormat("jpg").toFile(newFile);
            System.out.println(newFile.getAbsolutePath());
            // 上传图片到 -》 “绝对路径”
            //imgFile.transferTo(newFile);
            bannerImgService.uploadImg(new BannerImg().setImg("/IMG/"+newFileName).setId(Integer.parseInt(request.getParameter("id"))));
            return result.successResult("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.failResult();
    }

    @RequestMapping("insertImg")
    public Result<String> insertBannerImg(BannerImg bannerImg){
        int row = bannerImgService.insertBannerImg(bannerImg);
        if(row!=0){

            return result.successResult("添加成功");
        }
        return result.failResult("添加失败");
    }
}