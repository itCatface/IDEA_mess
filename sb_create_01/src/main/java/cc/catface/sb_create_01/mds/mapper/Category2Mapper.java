package cc.catface.sb_create_01.mds.mapper;

import cc.catface.sb_create_01.mds.pojo.Category2;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Mapper
@Repository
public interface Category2Mapper {

    @Select("select * from category_")
    List<Category2> findAll();

    @Insert(" insert into category_ ( name ) values (#{name}) ")
    public int save(Category2 category);

    @Delete(" delete from category_ where id= #{id} ")
    public void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    public Category2 get(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    public int update(Category2 category);
}
