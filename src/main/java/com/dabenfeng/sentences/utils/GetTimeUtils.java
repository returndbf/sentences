package com.dabenfeng.sentences.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
@Component
public class GetTimeUtils {

//    public static void main(String[] args) {
//        GetTimeUtils a=new GetTimeUtils();
//        System.out.println(a.getCurrentMonth());
//
//    }
    Calendar cal = Calendar.getInstance();
    public  String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String  currentTime =df.format(new Date());
        return currentTime;
    }

    public int getCurrentMonth(){
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    public int getCurrentYear(){
        int year = cal.get(Calendar.YEAR);
        return year;
    }
}
