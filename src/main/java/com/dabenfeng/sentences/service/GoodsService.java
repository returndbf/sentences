package com.dabenfeng.sentences.service;

import com.dabenfeng.sentences.entity.Goods;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsService {
    public Integer insertGoods(Goods goods);
    //收藏

    public Integer collectionGoods(Integer id);
    //删除

    public Integer delGoods(Integer id);
    //添加图片

    public Integer uploadImg(Goods goods);

    public PageInfo<Goods> getGoodsByType(String type, Integer page, Integer pageSize);

    public Goods selectById(Integer id);
}
