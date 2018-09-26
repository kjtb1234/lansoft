package com.cn.dao;

import com.cn.pojo.TbAboutUs;
import com.cn.pojo.TbAboutUsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAboutUsMapper {
    int countByExample(TbAboutUsExample example);

    int deleteByExample(TbAboutUsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbAboutUs record);

    int insertSelective(TbAboutUs record);

    List<TbAboutUs> selectByExample(TbAboutUsExample example);

    TbAboutUs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbAboutUs record, @Param("example") TbAboutUsExample example);

    int updateByExample(@Param("record") TbAboutUs record, @Param("example") TbAboutUsExample example);

    int updateByPrimaryKeySelective(TbAboutUs record);

    int updateByPrimaryKey(TbAboutUs record);

	List<TbAboutUs> getAboutusLists();
}