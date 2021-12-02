package com.dabenfeng.sentences.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class GetTimeUtils {

//    public static void main(String[] args) {
//        GetTimeUtils a=new GetTimeUtils();
//        System.out.println(a.getCurrentTime());
//    }
    public  String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String  currentTime =df.format(new Date());
        return currentTime;
    }
}
