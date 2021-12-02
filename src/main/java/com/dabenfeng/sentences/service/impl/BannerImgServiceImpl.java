package com.dabenfeng.sentences.service.impl;

import com.dabenfeng.sentences.dao.BannerImgMapper;
import com.dabenfeng.sentences.entity.BannerImg;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerImgServiceImpl {
    @Autowired
    private BannerImgMapper bannerImgMapper;
    public Integer insertBannerImg(BannerImg bannerImg){
        return bannerImgMapper.insertBannerImg(bannerImg);
    };


    public Integer updateBannerImg(BannerImg bannerImg){
        return bannerImgMapper.updateBannerImg(bannerImg);
    };


    public Integer uploadImg(BannerImg bannerImg){
        return bannerImgMapper.uploadImg(bannerImg);
    };
}
