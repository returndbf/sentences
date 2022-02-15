package com.dabenfeng.sentences.service.impl;

import com.dabenfeng.sentences.dao.BlogMapper;
import com.dabenfeng.sentences.entity.Blog;
import com.dabenfeng.sentences.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public Integer insertBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public Integer checkUserTodayBlogsCount(Blog blog) {
        return blogMapper.checkUserTodayBlogsCount(blog);
    }

    @Override
    public List<Blog> selectBlogsByUserId(int UserId) {
        return blogMapper.selectBlogsByUserId(UserId);
    }

    @Override
    public List<Blog> selectBlogsByMonth(Blog blog) {
        return blogMapper.selectBlogsByMonth(blog);
    }
}
