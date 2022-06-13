package com.dabenfeng.sentences.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
@Component
public class UploadUtils {
    String token ="";
    public static void main(String[] args) {
        System.out.println(new UploadUtils().getToken());
    }
    public final static String IMG_PATH_PREFIX = "static/IMG";
    public static File upload(){
        String fileDirPath = ClassUtils.getDefaultClassLoader().getResource("static/IMG").getPath();

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

    public static String uploadImg(MultipartFile imgFile){
            // 拿到文件名
            String filename = imgFile.getOriginalFilename();
            //uuid
            String uuid = UUID.randomUUID().toString().replace("-","");
            //newFilename
            String newFileName = uuid.substring(0,10)+filename;
            // 存放上传图片的文件夹
            File fileDir = UploadUtils.upload();
            // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
            System.out.println(fileDir.getAbsolutePath());
            try {
                //添加上传时间
                //object.setUploadTime(getTimeUtils.getCurrentTime());
                // 构建真实的文件路径
                File newFile = new File(fileDir.getAbsolutePath() + File.separator + newFileName);
                //压缩图片
                //Thumbnails.of(imgFile.getInputStream()).scale(1f).outputQuality(1f).outputFormat("jpg").toFile(newFile);
                System.out.println(newFile.getAbsolutePath());
                // 上传图片到 -》 “绝对路径”
                imgFile.transferTo(newFile);
                //图片路径添加到数据库
                //bannerImgService.updateImg(new BannerImg().setImg("/IMG/"+newFileName).setId(bannerImg.getId()));
                return newFileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "添加失败";
        }
        public String getToken(){
        String url = "https://pic.guokm.cn/api/v1/tokens";
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
            map.add("email","1668959325@qq.com");
            map.add("password","qxf990919");
            String trans = restTemplate.postForObject(url,new HttpEntity<>(map,headers),String.class);
            JSONObject resObject = JSONObject.parseObject(trans);
            boolean status = resObject.getBoolean("status");
            if(status==true){
                String data = resObject.getString("data");
                JSONObject dataObject = JSONObject.parseObject(data);
                String token = dataObject.getString("token");
                this.token= token;
                return token;
            }
            return "get token fail";
        }
        //上传到叁猫的图床
        public String uploadToSanMaoPic(MultipartFile file) throws IOException {
        if(token.equals("")){
            getToken();
        }

            String url = "https://pic.guokm.cn/api/v1/upload";
           // FileSystemResource resource = new FileSystemResource((File) file);
            ByteArrayResource fileAsResource = new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }

                @Override
                public long contentLength() {
                    return file.getSize();
                }
            };
            MultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
            map.add("image",fileAsResource);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization",token);
//            HttpEntity<MultiValueMap<String, String>> request =
//                    new HttpEntity<MultiValueMap<String, String>>(map, httpHeaders);
            RestTemplate restTemplate = new RestTemplate();
            String trans = restTemplate.postForObject(url,new HttpEntity<>(map,httpHeaders),String.class);
            return  trans;
        }

}