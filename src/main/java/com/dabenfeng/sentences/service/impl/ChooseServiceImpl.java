package com.dabenfeng.sentences.service.impl;

import com.dabenfeng.sentences.dao.ChooseMapper;
import com.dabenfeng.sentences.entity.Choose;
import com.dabenfeng.sentences.service.ChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChooseServiceImpl implements ChooseService {
    @Autowired
    private  ChooseMapper chooseMapper;
    @Override
    public String getRandomChoose() {
        return chooseMapper.getRandomChoose();
    }

    @Override
    public List<Choose> getAllChoose() {
        return chooseMapper.getAllChoose();
    }

    @Override
    public List<Choose> getChooseByPrefix(String prefix) {
        return chooseMapper.getChooseByPrefix(prefix);
    }

    @Override
    public List<Choose> getAllChooseByPrefix(String prefix) {
        return chooseMapper.getAllChooseByPrefix(prefix);
    }

    @Override
    public List<String> getAllPrefix() {
        return chooseMapper.getAllPrefix();
    }

    @Override
    public Integer insertChoose(Choose choose) {
        return chooseMapper.insertChoose(choose);
    }

    @Override
    public Integer delChoose(int id) {
        return chooseMapper.delChoose(id);
    }
}
