package com.dabenfeng.sentences.entity;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Goods {
    private  int id;

    private String name;

    private String title;

    private String type;

    private BigDecimal price;

    private String description;

    private int collection;

    private String img;

    private String uploadTime;

    private String updateTime;

    private int del_flag;

}
