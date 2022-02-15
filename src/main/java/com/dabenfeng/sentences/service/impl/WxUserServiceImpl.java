package com.dabenfeng.sentences.service.impl;

import com.dabenfeng.sentences.dao.WxUserMapper;
import com.dabenfeng.sentences.entity.UserClockData;
import com.dabenfeng.sentences.entity.WxUser;
import com.dabenfeng.sentences.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxUserServiceImpl implements WxUserService {
    @Autowired
    private WxUserMapper wxUserMapper;
    @Override
    public WxUser getWxUserByOpenId(String openId) {
        return wxUserMapper.getWxUserByOpenId(openId);
    }

    @Override
    public Integer insertWxUser(String openId) {
        return wxUserMapper.insertWxUser(openId);
    }

    @Override
    public Integer userClock(UserClockData userClockData) {
        return wxUserMapper.userClock(userClockData);
    }

    @Override
    public Integer userClockCount(int userId) {
        return wxUserMapper.userClockCount(userId);
    }

    @Override
    public String userClockToday(int userId) {
        return wxUserMapper.userClockToday(userId);
    }
}
