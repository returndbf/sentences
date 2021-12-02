//package com.dabenfeng.sentences.config.shiro;
//
//import com.dabenfeng.sentences.entity.User;
//import com.dabenfeng.sentences.service.UserService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class UserRealm extends AuthorizingRealm {
//    @Autowired
//    private UserService userService;
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("授权");
//        //String username = principalCollection.getPrimaryPrincipal().toString();
//        //User user = UserService.queryByName(username);
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        Subject subject = SecurityUtils.getSubject();
//        System.out.println(subject);
//        User user = (User)subject.getPrincipal();
//        //User dbUser = userService.findById(user.getId());
//        List<String> pers = userService.findMenuByUser(user.getId());
//        List<String> roles = userService.findRoleByUser(user.getId());
//        System.out.println(pers);
//        System.out.println(roles);
//        info.addStringPermissions(pers);
//        info.addRoles(roles);
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//
//        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
//        User user = userService.findByUsername(token.getUsername());
//        if(user==null) {
//            return null;
//        }
//        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
//    }
//}
