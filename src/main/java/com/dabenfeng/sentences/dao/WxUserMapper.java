package com.dabenfeng.sentences.dao;

import com.dabenfeng.sentences.entity.UserClockData;
import com.dabenfeng.sentences.entity.WxUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WxUserMapper {
    @Select("select * from WxUser where open_id = #{openId}")
    public WxUser getWxUserByOpenId(String openId);


    @Insert("insert into WxUser (open_id) values (#{openId})")
    public Integer insertWxUser(String openId);

    @Insert("insert into clock (user_id,clock_data) values(#{userId},#{clockData})")
    public Integer userClock(UserClockData userClockData);

    @Select("SELECT count(clock_data) from clock where user_id = #{userId} ")
    public Integer userClockCount(int userId);

    @Select("select clock_data from clock where user_id = #{userId} order by clock_data  desc limit 1 ")
    public String userClockToday(int userId);




}
