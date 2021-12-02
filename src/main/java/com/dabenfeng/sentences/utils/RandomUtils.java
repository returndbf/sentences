package com.dabenfeng.sentences.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomUtils {
    public int getRandomNum(int size){
        Random rand=new Random();
        int RandNum=rand.nextInt(size);
        return RandNum;
    }
}
