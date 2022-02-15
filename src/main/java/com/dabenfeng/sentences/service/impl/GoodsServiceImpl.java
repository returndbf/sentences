package com.dabenfeng.sentences.service.impl;

import com.dabenfeng.sentences.dao.GoodsMapper;
import com.dabenfeng.sentences.entity.Goods;
import com.dabenfeng.sentences.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    public Integer insertGoods(Goods goods){
        return goodsMapper.insertGoods(goods);
    };

    public Integer collectionGoods(Integer id){
        return goodsMapper.collectionGoods(id);
    };

    public Integer delGoods(Integer id){
        return goodsMapper.delGoods(id);
    };

    public Integer uploadImg(Goods goods){
        return goodsMapper.uploadImg(goods);
    }



    @Override
    public Goods selectById(Integer id) {
        return goodsMapper.selectById(id);
    }



    public PageInfo<Goods> getGoodsByType(String type,Integer page,Integer pageSize){
        PageHelper.startPage(page,pageSize);
        List<Goods> goods=goodsMapper.getGoodsByType(type);
        PageInfo pageInfo = new PageInfo(goods);
        return pageInfo;
    }
}
