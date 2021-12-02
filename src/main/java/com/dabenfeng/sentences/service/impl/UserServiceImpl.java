package com.dabenfeng.sentences.service.impl;

import com.dabenfeng.sentences.dao.UserMapper;
import com.dabenfeng.sentences.entity.User;
import com.dabenfeng.sentences.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public List<String> findRoleByUser(int userId) {
        return userMapper.findRoleByUser(userId);
    }

    @Override
    public List<String> findMenuByUser(int userId) {
        return userMapper.findMenuByUser(userId);
    }

}
