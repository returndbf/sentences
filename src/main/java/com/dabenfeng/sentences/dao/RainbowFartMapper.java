package com.dabenfeng.sentences.dao;

import com.dabenfeng.sentences.entity.Sentence;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RainbowFartMapper {
    //获取所有彩虹屁对象
    @Select("select * from Rainbow_fart ")
    public List<Sentence> getAllRainbowFart();
    //获取所有彩虹屁句子
    @Select("select sentence from Rainbow_fart where del_flag=0")
    public List<String> getAllRainbowFartSentence();
    //添加彩虹屁对象
    @Insert("insert into Rainbow_fart (sentence,author,adder,add_time,del_flag) VALUES(#{sentence},#{author},#{adder},#{addTime},0) ")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public Integer insertRainbowFartSentence(Sentence sentence);
    //删除彩虹屁，del_flag=1为删除
    @Update("update Rainbow_fart set del_flag = 1,delete_time = #{deleteTime} where id = #{id}")
    public Integer deleteRainbowFartSentence(Sentence sentence);
    //根据id获取彩虹屁对象,不检查是否删除
    @Select("select * from Rainbow_fart where id = #{id}")
    public Sentence getRainbowFartObjById(int id);
    //根据id获取彩虹屁句子，不检查是否删除
    @Select("select sentence from Rainbow_fart where id = #{id}")
    public String getRainbowFartById(int id);
//    //随机获取一条彩虹屁句子
//    @Select("select sentence from Rainbow_fart as R\n" +
//            "JOIN (select floor(RAND() * (SELECT MAX(id) FROM `Rainbow_fart`)) as id) as D\n" +
//            "where R.id>=D.id\n" +
//            " ORDER BY R.id LIMIT 1")
//    public String getRandomRainbowFartSentence();
//    //随机获取一条彩虹屁对象
//    @Select("SELECT * FROM `Rainbow_fart` WHERE id >= (SELECT floor(RAND() * (SELECT MAX(id) FROM `Rainbow_fart`))) and del_flag=0\n" +
//            "            ORDER BY id LIMIT 1 ;")
//    public Sentence getRandomRainbowFart();

}
