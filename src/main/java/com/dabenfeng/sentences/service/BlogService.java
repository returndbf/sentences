package com.dabenfeng.sentences.service;

import com.dabenfeng.sentences.entity.Blog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogService {
    public Integer insertBlog(Blog blog);

    public Integer checkUserTodayBlogsCount(Blog blog);

    public List<Blog> selectBlogsByUserId(int UserId);

    public List<Blog> selectBlogsByMonth(Blog blog);

    public List<Blog> selectAllBlogs();
}
