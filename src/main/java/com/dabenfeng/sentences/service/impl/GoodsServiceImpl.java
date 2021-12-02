package com.dabenfeng.sentences.service.impl;

import com.dabenfeng.sentences.dao.GoodsMapper;
import com.dabenfeng.sentences.entity.Goods;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl {
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
    };
}
