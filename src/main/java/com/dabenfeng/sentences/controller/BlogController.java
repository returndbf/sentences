package com.dabenfeng.sentences.controller;

import com.alibaba.fastjson.JSONObject;
import com.dabenfeng.sentences.entity.Blog;
import com.dabenfeng.sentences.entity.Result;
import com.dabenfeng.sentences.service.impl.BlogServiceImpl;
import com.dabenfeng.sentences.utils.GetTimeUtils;
import com.dabenfeng.sentences.utils.UploadUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private Result result;
    @Resource
    private GetTimeUtils getTimeUtils;
    @Resource
    private UploadUtils uploadUtils;
    @RequestMapping("insertBlog")
    public Result<String> insertBlog(Blog blog,@RequestBody(required = false) MultipartFile file){
        //System.out.println(blog);
        int days = getUserTodayBlogs(blog);
        if(days >= 2){
            return result.failResult("今日日志已上限");
        }
        String imgUrl = "";
        if(file !=null){
           try {
               String uploadResult = uploadUtils.uploadToSanMaoPic(file);
               JSONObject object = JSONObject.parseObject(uploadResult);
               String dataStr = object.getObject("data",String.class);
               JSONObject data = JSONObject.parseObject(dataStr);
               String url = data.getString("url");
               imgUrl = url;
               //System.out.println(url);
               //return result.successResult("上传成功",url);
               blog.setImg(imgUrl);
           } catch (IOException e) {
               e.printStackTrace();
               return result.failResult("图片上传失败");
           }
       }
        String currentTime = getTimeUtils.getCurrentTime();
        int currentMonth = getTimeUtils.getCurrentMonth();
        int currentYear = getTimeUtils.getCurrentYear();
        blog.setUploadYear(currentYear);
        blog.setUploadTime(currentTime);
        blog.setUploadMonth(currentMonth);
        int row =  blogService.insertBlog(blog);
        if(row>0){
            return  result.successResult("添加成功");
        }else{
            return result.failResult("添加失败");
        }
    }
    @RequestMapping("uploadImgToSanMao")
    public Object uploadImgToSanMao(MultipartFile file){
        try {
            return uploadUtils.uploadToSanMaoPic(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.failResult();
    }

    public int getUserTodayBlogs(Blog blog){
        String currentDay = getTimeUtils.getCurrentTime().substring(0,10);
        blog.setUploadTime(currentDay);//将今天的时间进行setter，为了查询
        int days = blogService.checkUserTodayBlogsCount(blog);
        return days;
    }
    @RequestMapping("checkUserTodayBlogsCount")
    public Result<Integer> checkUserTodayBlogsCount(Blog blog){
       int days = getUserTodayBlogs(blog);
        if(days >= 2){
            return result.successResult("今日日志已上限",false);
        }else{
            return result.successResult("今日可写日志",true);
        }


    }

    public List<Blog> selectBlogsByUserId(int UserId){
        return null;
    };

    @RequestMapping("selectBlogsByMonth")
    public Result<List<Blog>> selectBlogsByMonth(Blog blog){
        List<Blog> blogList = blogService.selectBlogsByMonth(blog);
        if(blogList.size()!=0){
            return result.successResult("获取"+blog.getUploadMonth()+"月日志成功",blogList);
        }else{
            return result.successResult("当月暂无日志",null);
        }
    }
}
