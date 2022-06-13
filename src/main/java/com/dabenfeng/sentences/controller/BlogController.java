package com.dabenfeng.sentences.controller;

import com.alibaba.fastjson.JSONObject;
import com.dabenfeng.sentences.entity.Blog;
import com.dabenfeng.sentences.entity.Result;
import com.dabenfeng.sentences.service.impl.BlogServiceImpl;
import com.dabenfeng.sentences.utils.GetTimeUtils;
import com.dabenfeng.sentences.utils.QiNiuUtil;
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
    @Resource
    private QiNiuUtil qiNiuUtil;
    @RequestMapping("insertBlog")
    public Result<String> insertBlog(Blog blog,@RequestBody(required = false) MultipartFile file){
        int days = getUserTodayBlogs(blog);
        if(days >= 2){
            return result.failResult("今日日志已上限");
        }
        String imgUrl = "";
        if(file !=null){
           try {
               String uploadResult = qiNiuUtil.uploadImg(file);
               imgUrl = uploadResult;
               blog.setImg(imgUrl);
           } catch (Exception e) {
               e.printStackTrace();
               return result.failResult("图片上传失败");
           }
       }
        String currentTime = getTimeUtils.getCurrentTime();
        int currentMonth = getTimeUtils.getCurrentMonth();
        System.out.println(currentMonth+"currentMonth");
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
//    @RequestMapping("uploadImgToSanMao")
//    public Object uploadImgToSanMao(MultipartFile file){
//        try {
//            return uploadUtils.uploadToSanMaoPic(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result.failResult();
//    }

    @RequestMapping("uploadImgToQiNiu")
    public Object uploadImgToQiNiu(MultipartFile file){
        return qiNiuUtil.uploadImg(file);
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
    @RequestMapping("selectBlogsByUserId")
    public Result<List<Blog>> selectBlogsByUserId(int userId){
        List <Blog> userBlogs = blogService.selectBlogsByUserId(userId);
        if(userBlogs.size()>0&&userBlogs!=null){
            return result.successResult(userBlogs);
        }else{
            return result.successResult("没有日志",null);
        }

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

    @RequestMapping("selectAllBlogs")
    public Result<List<Blog>> selectAllBlogs(){
        List<Blog> allBlog = blogService.selectAllBlogs();
        if(allBlog.size()>0){
            return result.successResult(allBlog);
        }else{
            return  result.successResult("无数据或获取失败");
        }
    }
}
