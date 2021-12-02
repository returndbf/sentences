//package com.dabenfeng.sentences;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class GetController {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @GetMapping("getSentence")
//    public String getSentence(String username ,String password){
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        try {
//            subject.login(token);
//        }catch (UnknownAccountException e){
//            return "username fail";
//        }catch (IncorrectCredentialsException e){
//            return "password fail";
//        }
//        return "success";
//    }
//
//    @GetMapping("redisTest")
//    public String redisTest(){
//        stringRedisTemplate.opsForValue().set("qq","ww");
//        return stringRedisTemplate.opsForValue().get("qq");
//    }
//}
