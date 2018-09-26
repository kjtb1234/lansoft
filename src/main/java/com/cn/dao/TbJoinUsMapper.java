package com.cn.dao;

import com.cn.pojo.TbJoinUs;
import com.cn.pojo.TbJoinUsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbJoinUsMapper {
    int countByExample(TbJoinUsExample example);

    int deleteByExample(TbJoinUsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbJoinUs record);

    int insertSelective(TbJoinUs record);

    List<TbJoinUs> selectByExample(TbJoinUsExample example);

    TbJoinUs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbJoinUs record, @Param("example") TbJoinUsExample example);

    int updateByExample(@Param("record") TbJoinUs record, @Param("example") TbJoinUsExample example);

    int updateByPrimaryKeySelective(TbJoinUs record);

    int updateByPrimaryKey(TbJoinUs record);

	List<TbJoinUs> getJoinusLists();
}