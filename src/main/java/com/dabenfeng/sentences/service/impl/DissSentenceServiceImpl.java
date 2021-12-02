package com.dabenfeng.sentences.service.impl;

import com.dabenfeng.sentences.dao.DissSentenceMapper;
import com.dabenfeng.sentences.entity.Sentence;
import com.dabenfeng.sentences.service.DissSentenceService;
import com.dabenfeng.sentences.utils.RandomUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DissSentenceServiceImpl implements DissSentenceService {
    @Resource
    private DissSentenceMapper dissSentenceMapper;
    @Resource
    private RandomUtils randomUtils;
    @Override
    public PageInfo<Sentence> getAllDissSentenceObj(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Sentence> sentencesObj=dissSentenceMapper.getAllDissSentenceObj();
        PageInfo pageInfo = new PageInfo(sentencesObj);
        return pageInfo;
    }

    @Override
    public PageInfo<String> getAllDissSentence(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<String> sentencesObj=dissSentenceMapper.getAllDissSentence();
        PageInfo pageInfo = new PageInfo(sentencesObj);
        return pageInfo;
    }

    @Override
    public Integer insertDissSentence(Sentence sentence) {
        return dissSentenceMapper.insertDissSentence(sentence);
    }

    @Override
    public Integer deleteDissSentence(Sentence sentence) {
        return dissSentenceMapper.deleteDissSentence(sentence);
    }

    @Override
    public Sentence getDissSentenceObjById(int id) {
        return dissSentenceMapper.getDissSentenceObjById(id);
    }

    @Override
    public String getDissSentenceById(int id) {
        return dissSentenceMapper.getDissSentenceById(id);
    }

    @Override
    public String getRandomDissSentence() {
        List<String> sentences =dissSentenceMapper.getAllDissSentence();
        //根据list长度获取随机数
        int randNum = randomUtils.getRandomNum(sentences.size());
        String sentence = sentences.get(randNum);
        return sentence;
    }

    @Override
    public Sentence getRandomDissSentenceObj() {
        List<Sentence> sentences =dissSentenceMapper.getAllDissSentenceObj();
        //根据list长度获取随机数
        int randNum = randomUtils.getRandomNum(sentences.size());
        Sentence sentence = sentences.get(randNum);
        return sentence;
    }
}
