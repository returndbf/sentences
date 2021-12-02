package com.dabenfeng.sentences.service.impl;

import com.dabenfeng.sentences.dao.RainbowFartMapper;
import com.dabenfeng.sentences.entity.Sentence;
import com.dabenfeng.sentences.service.RainbowFartService;
import com.dabenfeng.sentences.utils.RandomUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class RainbowFartServiceImpl implements RainbowFartService {
    @Resource
    private RainbowFartMapper rainbowSentenceMapper;
    @Resource
    private RandomUtils randomUtils;
    @Override
    public PageInfo<Sentence> getAllRainbowFart(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Sentence> sentencesObj=rainbowSentenceMapper.getAllRainbowFart();
        PageInfo pageInfo = new PageInfo(sentencesObj);
        return pageInfo;
    }


    @Override
    public PageInfo<String> getAllRainbowFartSentence(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<String> sentences=rainbowSentenceMapper.getAllRainbowFartSentence();
        PageInfo pageInfo = new PageInfo(sentences);
        return pageInfo;
    }

    @Override
    public Integer insertRainbowFartSentence(Sentence sentence) {
        return rainbowSentenceMapper.insertRainbowFartSentence(sentence);
    }

    @Override
    public Integer deleteRainbowFartSentence(Sentence sentence) {
        return rainbowSentenceMapper.deleteRainbowFartSentence(sentence);
    }

    @Override
    public Sentence getRainbowFartObjById(int id) {
        return rainbowSentenceMapper.getRainbowFartObjById(id);
    }

    @Override
    public String getRainbowFartById(int id) {
        return rainbowSentenceMapper.getRainbowFartById(id);
    }

    @Override
    public String getRandomRainbowFartSentence() {
        List<String> sentences =rainbowSentenceMapper.getAllRainbowFartSentence();
        //根据list长度获取随机数
        int randNum = randomUtils.getRandomNum(sentences.size());
        String sentence = sentences.get(randNum);
        return sentence;
    }

    @Override
    public Sentence getRandomRainbowFart() {
        List<Sentence> sentencesObj =rainbowSentenceMapper.getAllRainbowFart();
        //根据list长度获取随机数
        int randNum = randomUtils.getRandomNum(sentencesObj.size());
        Sentence sentence = sentencesObj.get(randNum);
        return sentence;
    }


}
