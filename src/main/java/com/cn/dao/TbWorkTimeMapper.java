package com.cn.dao;

import com.cn.pojo.TbWorkTime;
import com.cn.pojo.TbWorkTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWorkTimeMapper {
    int countByExample(TbWorkTimeExample example);

    int deleteByExample(TbWorkTimeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbWorkTime record);

    int insertSelective(TbWorkTime record);

    List<TbWorkTime> selectByExampleWithBLOBs(TbWorkTimeExample example);

    List<TbWorkTime> selectByExample(TbWorkTimeExample example);

    TbWorkTime selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbWorkTime record, @Param("example") TbWorkTimeExample example);

    int updateByExampleWithBLOBs(@Param("record") TbWorkTime record, @Param("example") TbWorkTimeExample example);

    int updateByExample(@Param("record") TbWorkTime record, @Param("example") TbWorkTimeExample example);

    int updateByPrimaryKeySelective(TbWorkTime record);

    int updateByPrimaryKeyWithBLOBs(TbWorkTime record);

    int updateByPrimaryKey(TbWorkTime record);

	List<TbWorkTime> getWorktimeLists();
}