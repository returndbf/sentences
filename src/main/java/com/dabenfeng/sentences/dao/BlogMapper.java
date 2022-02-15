package com.dabenfeng.sentences.dao;

import com.dabenfeng.sentences.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogMapper {
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into blogs (user_id,upload_time,upload_year,upload_month,title,content,img,weather,weather_icon,del_flag) values (#{userId},#{uploadTime},#{uploadYear},#{uploadMonth},#{title},#{content},#{img},#{weather},#{weatherIcon},0)")
    public Integer insertBlog(Blog blog);

    @Select("SELECT count(1) FROM blogs where upload_time like concat('%',#{uploadTime},'%') and user_id = #{userId}")
    public Integer checkUserTodayBlogsCount(Blog blog);

    @Select("select * from blogs where userId = #{userId} and del_flag =0")
    public List<Blog> selectBlogsByUserId(int UserId);

    @Select("select * from blogs where user_id = #{userId} and upload_month = #{uploadMonth} and upload_year = #{uploadYear} and del_flag =0")
    public List<Blog> selectBlogsByMonth(Blog blog);


}
