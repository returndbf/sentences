//package com.dabenfeng.sentences.exception;
//
//import org.apache.shiro.authz.AuthorizationException;
//import org.apache.shiro.authz.UnauthorizedException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
////解决无权限不跳转指定页面
//@ControllerAdvice
//public class PermsException {
//        @ResponseBody
//        @ExceptionHandler(UnauthorizedException.class)
//        public String handleShiroException(Exception ex) {
//            return "无权限";
//        }
//
//        @ResponseBody
//        @ExceptionHandler(AuthorizationException.class)
//        public String AuthorizationException(Exception ex) {
//            return "权限认证失败";
//
//    }
//
//}
