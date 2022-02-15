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
public class UserClockData {
    private  int id;
    private int userId;
    private String clockData;
}
