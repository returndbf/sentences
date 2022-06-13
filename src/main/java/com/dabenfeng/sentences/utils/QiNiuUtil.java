package com.dabenfeng.sentences.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

/**
 * @Author KasonZzz
 * @Description //TODO 七牛云工具类
 * @Date 9:46 2020/7/29
 */
@Component
public class QiNiuUtil {
    public static void main(String[] args) {
       //new QiNiuUtil().uploadImg();
//        File file = new File("C:\\Users\\16689\\Desktop\\b5335c9ac0bb1ef799b31e6370a812c.jpg");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getName());
//        System.out.println(file.getPath());
    }

    public String uploadImg(MultipartFile multipartFile){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        /** 七牛云AK */
         String accessKey = "OobFYyeKpQ9_lhO96eWPBsHdCxEDUhLkVxHBicB_";
        /** 七牛云密钥 */
        String secretKey = "-4CTgA3QtzholhdvSs5Fu24VU4WAjLI8nw7QR-Uu";
         /** 仓库名 */
         String bucket = "diary-upload";

         String uuid = UUID.randomUUID().toString().substring(0,10);
        try {
            //key是文件名
            String key = uuid+multipartFile.getOriginalFilename();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(multipartFile.getBytes(),key,upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return "https://node.dabenfeng.top/"+putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return null;
    }

}

