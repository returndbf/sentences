package com.dabenfeng.sentences.dao;

import com.dabenfeng.sentences.entity.BannerImg;
import org.apache.ibatis.annotations.*;
import org.springframework.boot.Banner;

import java.util.List;

@Mapper
public interface BannerImgMapper {
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into BannerImg (name,title,description,upload_time,update_time,type) values (#{name},#{title},#{description},#{uploadTime},#{updateTime},#{type})")
    public Integer insertBannerImg(BannerImg bannerImg);

    @Update("update BannerImg set name=#{name},title=#{title},description = #{description},update_time=#{updateTime} where id = #{id}")
    public Integer updateBannerImg(BannerImg bannerImg);

    @Update("update BannerImg set img=#{img} where id= #{id}")
    public Integer updateImg(BannerImg bannerImg);

    @Select("select * from BannerImg where type = 0")
    public List<BannerImg> getAllBannerImg();

    @Select("select * from BannerImg where type = 1")
    public List<BannerImg> getAllRecommend();



}
