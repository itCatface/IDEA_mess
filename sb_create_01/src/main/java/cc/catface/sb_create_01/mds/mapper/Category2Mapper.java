package cc.catface.sb_create_01.mds.mapper;

import cc.catface.sb_create_01.mds.pojo.Category2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Mapper
public interface Category2Mapper {

    @Select("select * from category_")
    List<Category2> findAll();

}
