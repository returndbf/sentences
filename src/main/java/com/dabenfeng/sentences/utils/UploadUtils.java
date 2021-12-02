package com.dabenfeng.sentences.utils;

import org.springframework.util.ClassUtils;

import java.io.File;

public class UploadUtils {
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
}