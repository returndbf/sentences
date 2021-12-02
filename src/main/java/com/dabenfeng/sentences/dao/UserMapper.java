package com.dabenfeng.sentences.dao;

import com.dabenfeng.sentences.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from Users where username= #{username}")
    public User findByUsername(String username);

    @Select("select * from Users where id= #{id}")
    public User findById(int id);

    @Select("select role_name from Role where id in ( select role_id from User_Role where user_id =user_id) ")
    public List<String> findRoleByUser(int userId);

    @Select(" select permission from Menu where id in (select menu_id  from Role_Menu where role_id in(select role_id from User_Role where user_id =#{user_id}))")
    public List<String> findMenuByUser(int userId);


}
