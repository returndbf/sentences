package com.dabenfeng.sentences.controller;

import com.dabenfeng.sentences.utils.QiNiuUtil;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class QiNiuUploadController {
    @Autowired
    private QiNiuUtil qiNiuUtil;
//    String bucketName ="dabenfeng";
//    Auth auth = Auth.create("OobFYyeKpQ9_lhO96eWPBsHdCxEDUhLkVxHBicB_", "-4CTgA3QtzholhdvSs5Fu24VU4WAjLI8nw7QR-Uu");
//    Configuration cfg = new Configuration(Zone.zone0());
//    UploadManager uploadManager = new UploadManager();

    /**
     * 获取凭证
     * @param bucketName 空间名称
     * @param key 如果需要覆盖上传则设置此参数
     * @return
     */
//    public String getUpToken(String bucketName,String key) {
//        return auth.uploadToken(bucketName);
//    }

    @PostMapping("upImgs")
    public Object uploadImgs(@RequestBody MultipartFile[] file)throws IOException {
        HashMap hashMap = qiNiuUtil.saveImage(file);
        return hashMap;
    }


}
