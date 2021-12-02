package com.dabenfeng.sentences.service;

import com.dabenfeng.sentences.entity.Sentence;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface RainbowFartService {
    //获取所有彩虹屁对象
    public PageInfo<Sentence> getAllRainbowFart(Integer page, Integer pageSize);

    //获取所有彩虹屁句子
    public PageInfo<String> getAllRainbowFartSentence(Integer page, Integer pageSize);

    //添加彩虹屁对象
    public Integer insertRainbowFartSentence(Sentence sentence);

    //删除彩虹屁，del_flag=1为删除
    public Integer deleteRainbowFartSentence(Sentence sentence);

    //根据id获取彩虹屁对象
    public Sentence getRainbowFartObjById(int id);

    //根据id获取彩虹屁句子
    public String getRainbowFartById(int id);

    //随机获取一条彩虹屁句子
    public String getRandomRainbowFartSentence();

    //随机获取一条彩虹屁对象
    public Sentence getRandomRainbowFart();

}
