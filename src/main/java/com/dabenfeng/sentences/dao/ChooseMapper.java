package com.dabenfeng.sentences.dao;

import com.dabenfeng.sentences.entity.Choose;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ChooseMapper {
    @Select("SELECT concat (prefix,content) FROM `choose_content` where del_flag = 0 ORDER BY RAND() LIMIT 1")
    public String getRandomChoose();

    @Select("select * from choose_content where prefix = #{prefix} and del_flag = 0")
    public List<Choose> getChooseByPrefix(String prefix);

    @Select("select distinct prefix from choose_content")
    public List<String> getAllPrefix();

    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into choose_content (prefix,content,del_flag) values  (#{prefix},#{content},0)")
    public Integer insertChoose(Choose choose);

    @Update("update  choose_content set del_flag = 1 where id = #{id} ")
    public Integer delChoose(int id);
}
