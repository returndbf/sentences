package com.dabenfeng.sentences.dao;

import com.dabenfeng.sentences.entity.BannerImg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BannerImgMapper {
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into BannerImg (name,title,description,upload_time,update_time) values (#{name},#{title},#{description},#{uploadTime},#{updateTime})")
    public Integer insertBannerImg(BannerImg bannerImg);

    @Update("update BannerImg set name=#{name},title=#{title},description = #{description},update_time=#{updateTime} where id = #{id}")
    public Integer updateBannerImg(BannerImg bannerImg);

    @Update("update BannerImg set img=#{img} where id= #{id}")
    public Integer uploadImg(BannerImg bannerImg);


}
