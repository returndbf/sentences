package com.dabenfeng.sentences.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain = true)
@Slf4j
public class Blog {
    private  int id;
    private  int userId;
    private String title;
    private String content;
    private String img;
    private String uploadTime;
    private String updateTime;
    private int uploadMonth;
    private int uploadYear;
    private String weather;
    private String weatherIcon;
    private int delFlag;

}
