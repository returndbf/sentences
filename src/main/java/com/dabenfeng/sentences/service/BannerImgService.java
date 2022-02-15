package com.dabenfeng.sentences.service;

import com.dabenfeng.sentences.entity.BannerImg;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BannerImgService {
    public Integer insertBannerImg(BannerImg bannerImg);

    public Integer updateBannerImg(BannerImg bannerImg);

    public Integer updateImg(BannerImg bannerImg);

    public List<BannerImg> getAllBannerImg();

   public List<BannerImg> getAllRecommend();
}
