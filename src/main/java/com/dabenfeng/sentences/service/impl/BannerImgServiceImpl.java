package com.dabenfeng.sentences.service.impl;

import com.dabenfeng.sentences.dao.BannerImgMapper;
import com.dabenfeng.sentences.entity.BannerImg;
import com.dabenfeng.sentences.service.BannerImgService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerImgServiceImpl implements BannerImgService {
    @Autowired
    private BannerImgMapper bannerImgMapper;
    public Integer insertBannerImg(BannerImg bannerImg){
        return bannerImgMapper.insertBannerImg(bannerImg);
    };


    public Integer updateBannerImg(BannerImg bannerImg){
        return bannerImgMapper.updateBannerImg(bannerImg);
    };


    public Integer updateImg(BannerImg bannerImg){
        return bannerImgMapper.updateImg(bannerImg);
    };

    public List<BannerImg> getAllBannerImg(){
        return bannerImgMapper.getAllBannerImg();
    }

    @Override
    public List<BannerImg> getAllRecommend() {
        return bannerImgMapper.getAllRecommend();
    }


}
