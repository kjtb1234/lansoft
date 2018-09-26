package com.cn.dao;

import com.cn.pojo.TbSlogan;
import com.cn.pojo.TbSloganExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSloganMapper {
    int countByExample(TbSloganExample example);

    int deleteByExample(TbSloganExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbSlogan record);

    int insertSelective(TbSlogan record);

    List<TbSlogan> selectByExample(TbSloganExample example);

    TbSlogan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSlogan record, @Param("example") TbSloganExample example);

    int updateByExample(@Param("record") TbSlogan record, @Param("example") TbSloganExample example);

    int updateByPrimaryKeySelective(TbSlogan record);

    int updateByPrimaryKey(TbSlogan record);

	List<TbSlogan> getSloganLists();
}