package com.dabenfeng.sentences.entity;

import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

@Component
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
   //final Result successResult=new Result(Code.SUCCESSCODE,Code.SUCCESSMSG,);
    //默认成功方法
    public Result successResult(T data){
        return new Result<>((Integer) Code.SUCCESSCODE.getValue(),(String)Code.SUCCESSMSG.getValue(),data);
    }
    //默认失败方法
    public Result failResult(){
        return new Result<>((Integer) Code.FAILCODE.getValue(),(String)Code.FAILMSG.getValue(),null);
    }
    //失败原因
    public Result failResult(String message){
        return new Result<>((Integer) Code.FAILCODE.getValue(),message,null);
    }

    public static void main(String[] args) {

        Random random = new Random();
        int randNum=random.nextInt(100)+1;
        System.out.println(randNum);
    }

}
