package com.dabenfeng.sentences.service;

import com.dabenfeng.sentences.entity.Sentence;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DissSentenceService {

    //获取怼人数据
    public PageInfo<Sentence> getAllDissSentenceObj(Integer page, Integer pageSize);

    //获取所有怼人句子
    public PageInfo<String> getAllDissSentence(Integer page, Integer pageSize);

    //添加怼人句子
    public Integer insertDissSentence(Sentence sentence);

    //删除怼人句子，del_flag=1为删除
    public Integer deleteDissSentence(Sentence sentence);

    //根据id查询怼人句子对象
    public Sentence getDissSentenceObjById(int id);

    //根据id查询怼人句子
    public String getDissSentenceById(int id);

    //随机获取一条怼人句子
    public String getRandomDissSentence();

    //随机获取一条怼人句子对象
    public Sentence getRandomDissSentenceObj();
}
