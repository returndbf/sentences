package com.dabenfeng.sentences.service;

import com.dabenfeng.sentences.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    public User findByUsername(String username);

    public User findById(int id);

    public List<String> findRoleByUser(int userId);

    public List<String> findMenuByUser(int userId);
}
