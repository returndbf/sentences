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

    private BigDecimal price;

    private String description;

    private int collection;

    private String img;

    private String upload_time;

    private String update_time;

    private int del_flag;

}
