package com.cn.dao;

import com.cn.pojo.TbMainDirection;
import com.cn.pojo.TbMainDirectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMainDirectionMapper {
    int countByExample(TbMainDirectionExample example);

    int deleteByExample(TbMainDirectionExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbMainDirection record);

    int insertSelective(TbMainDirection record);

    List<TbMainDirection> selectByExample(TbMainDirectionExample example);

    TbMainDirection selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbMainDirection record, @Param("example") TbMainDirectionExample example);

    int updateByExample(@Param("record") TbMainDirection record, @Param("example") TbMainDirectionExample example);

    int updateByPrimaryKeySelective(TbMainDirection record);

    int updateByPrimaryKey(TbMainDirection record);

	List<TbMainDirection> getMainDirectionLists();
}