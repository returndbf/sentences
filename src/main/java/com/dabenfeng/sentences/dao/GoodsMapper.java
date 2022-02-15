package com.dabenfeng.sentences.dao;

import com.dabenfeng.sentences.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    //新增
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into Goods (name,title,type,price,description,collection,upload_time,update_time,del_flag) values(#{name},#{title},#{type},#{price},#{description},#{collection},#{uploadTime},#{updateTime},0)")
    public Integer insertGoods(Goods goods);
    //收藏
    @Update("update Goods set collection=collection+1 where id=#{id}")
    public Integer collectionGoods(Integer id);
    //删除
    @Update("update Goods set del_flag = 1 where id= #{id}")
    public Integer delGoods(Integer id);
    //添加图片
    @Update("update Goods set img = #{img} where id= #{id}")
    public Integer uploadImg(Goods goods);
    //根据类型查询所有
    @Select("select * from Goods where type = #{type}")
    public List<Goods> getGoodsByType(String type);
    //根据id查询商品
    @Select("select * from Goods where id = #{id}")
    public Goods selectById(Integer id);

}
