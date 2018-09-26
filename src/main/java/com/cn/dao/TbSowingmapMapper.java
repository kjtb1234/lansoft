package com.cn.dao;

import com.cn.pojo.TbSowingmap;
import com.cn.pojo.TbSowingmapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSowingmapMapper {
    int countByExample(TbSowingmapExample example);

    int deleteByExample(TbSowingmapExample example);

    int deleteByPrimaryKey(String id);

    int insert(@Param("record")TbSowingmap record);

    int insertSelective(TbSowingmap record);

    List<TbSowingmap> selectByExample(TbSowingmapExample example);

    TbSowingmap selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSowingmap record, @Param("example") TbSowingmapExample example);

    int updateByExample(@Param("record") TbSowingmap record, @Param("example") TbSowingmapExample example);

    int updateByPrimaryKeySelective(TbSowingmap record);

    int updateByPrimaryKey(TbSowingmap record);

	List<TbSowingmap> getSowingmapLists();
}