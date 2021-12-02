package com.dabenfeng.sentences.dao;

import com.dabenfeng.sentences.entity.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GoodsMapper {
    //新增
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into Goods (name,title,price,description,collection,upload_time,update_time,del_flag) values(#{name},#{title},#{price},#{description},#{collection},#{uploadTime},#{updateTime},0)")
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

}
