package com.dabenfeng.sentences.dao;

import com.dabenfeng.sentences.entity.Sentence;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DissSentenceMapper {
    //获取怼人数据
    @Select("select * from Diss_sentences ")
    public List<Sentence> getAllDissSentenceObj();
    //获取所有怼人句子
    @Select("select sentence from Diss_sentences where del_flag=0")
    public List<String> getAllDissSentence();
    //添加怼人句子
    @Insert("insert into Diss_sentences (sentence,author,adder,add_time,del_flag) VALUES(#{sentence},#{author},#{adder},#{addTime},0) ")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public Integer insertDissSentence(Sentence sentence);
    //删除怼人句子，del_flag=1为删除
    @Update("update Diss_sentences set del_flag = 1,delete_time = #{deleteTime} where id = #{id}")
    public Integer deleteDissSentence(Sentence sentence);
    //根据id查询怼人句子对象，不检查是否删除
    @Select("select * from Diss_sentences where id = #{id}")
    public Sentence getDissSentenceObjById(int id);
    //根据id查询怼人句子，不检查是否删除
    @Select("select sentence from Diss_sentences where id = #{id}")
    public String getDissSentenceById(int id);
//    //随机获取一条怼人句子
//    @Select("SELECT sentence FROM `Diss_sentences` WHERE id >= (SELECT floor(RAND() * (SELECT MAX(id) FROM `Diss_sentences`))) and del_flag=0\n" +
//            "            ORDER BY id LIMIT 1 ;")
//    public String getRandomDissSentence();
//    //随机获取一条怼人句子对象
//    @Select("SELECT * FROM `Diss_sentences` WHERE id >= (SELECT floor(RAND() * (SELECT MAX(id) FROM `Diss_sentences`))) and del_flag=0\n" +
//            "            ORDER BY id LIMIT 1 ;")
//    public Sentence getRandomDissSentenceObj();
}
