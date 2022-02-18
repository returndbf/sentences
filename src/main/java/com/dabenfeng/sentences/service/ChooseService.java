package com.dabenfeng.sentences.service;

import com.dabenfeng.sentences.entity.Choose;


import java.util.List;

public interface ChooseService {
    public String getRandomChoose();

    public List<Choose> getAllChoose();


    public List<Choose> getChooseByPrefix(String prefix);

    public List<Choose> getAllChooseByPrefix(String prefix);


    public List<String> getAllPrefix();


    public Integer insertChoose(Choose choose);

    public Integer delChoose(int id);
}
