package com.dabenfeng.sentences.service;

import com.dabenfeng.sentences.entity.BannerImg;
import org.apache.ibatis.annotations.Update;

public interface BannerImgService {
    public Integer insertBannerImg(BannerImg bannerImg);

    public Integer updateBannerImg(BannerImg bannerImg);

    public Integer uploadImg(BannerImg bannerImg);
}
