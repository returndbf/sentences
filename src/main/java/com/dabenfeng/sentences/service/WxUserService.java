package com.dabenfeng.sentences.service;

import com.dabenfeng.sentences.entity.UserClockData;
import com.dabenfeng.sentences.entity.WxUser;

public interface WxUserService {
    public WxUser getWxUserByOpenId(String openId);

    public Integer insertWxUser(String openId);

    public Integer userClock(UserClockData userClockData);

    public Integer userClockCount(int  userId);

    public String userClockToday(int userId);
}
