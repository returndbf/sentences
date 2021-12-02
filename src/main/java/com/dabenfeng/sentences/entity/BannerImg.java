package com.dabenfeng.sentences.entity;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain = true)
@Slf4j
public class BannerImg {
    private int id;
    private String name;
    private String title;
    private String description;
    private String uploadTime;
    private String updateTime;
    private String img;
}
