package com.dabenfeng.sentences.entity;

import org.springframework.core.style.ToStringCreator;

public class Sentence {
    private int id;
    private String sentence;
    private String author;
    private String addTime;
    private String deleteTime;
    private int delFlag;
    private String adder;


    public Sentence(int id, String sentence, String author, String addTime, String deleteTime, int delFlag,String adder) {
        this.id = id;
        this.sentence = sentence;
        this.author = author;
        this.addTime = addTime;
        this.deleteTime = deleteTime;
        this.delFlag = delFlag;
        this.adder=adder;
    }

    public Sentence(){

    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }


    public String getAdder() {
        return adder;
    }

    public void setAdder(String adder) {
        this.adder = adder;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "id=" + id +
                ", sentence='" + sentence + '\'' +
                ", author='" + author + '\'' +
                ", addTime='" + addTime + '\'' +
                ", deleteTime='" + deleteTime + '\'' +
                ", delFlag=" + delFlag +
                ", adder='" + adder + '\'' +
                '}';
    }
}
