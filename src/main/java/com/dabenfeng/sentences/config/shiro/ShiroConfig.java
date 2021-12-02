//package com.dabenfeng.sentences.config.shiro;
//
//import org.apache.shiro.mgt.DefaultSecurityManager;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//public class ShiroConfig {
//    /*
//    * 创建ShiroFilterFactoryBean
//    * */
//    @Bean(name="shiroFilterFactoryBean")
//    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager());
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        //filterChainDefinitionMap.put("/rainbowFart/randomRainbowFartSentence","authc");
//        //shiroFilterFactoryBean.setLoginUrl("/getSentence");
//        //shiroFilterFactoryBean.setUnauthorizedUrl("/getSentence");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    /*
//    * 创建DefaultWebSecurityManager
//    * */
//    @Bean(name="securityManager")
//    public DefaultWebSecurityManager securityManager(){
//        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
//        defaultSecurityManager.setRealm(userRealm());
//        return defaultSecurityManager;
//    }
//    /*
//    *
//    * 创建Realm
//    * */
//    @Bean(name="userRealm")
//    public UserRealm userRealm(){
//        return new UserRealm();
//    }
//}
