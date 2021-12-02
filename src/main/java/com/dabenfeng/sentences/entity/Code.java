package com.dabenfeng.sentences.entity;

import javax.sound.midi.Soundbank;

public enum Code {
    SUCCESSCODE(1),
    FAILCODE(0),
    SUCCESSMSG("成功"),
    FAILMSG("失败");
    private  Object value;

    Code(Object value) {
        this.value = value;
    }
    public Object getValue(){
        return value;
    }
    public void setValue(Object value){
        this.value=value;
    }

    public static void main(String[] args) {
        System.out.println((Code.SUCCESSCODE.getValue()) instanceof Integer);
    }
}
