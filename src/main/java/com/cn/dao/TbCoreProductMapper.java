package com.cn.dao;

import com.cn.pojo.TbCoreProduct;
import com.cn.pojo.TbCoreProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCoreProductMapper {
    int countByExample(TbCoreProductExample example);

    int deleteByExample(TbCoreProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbCoreProduct record);

    int insertSelective(TbCoreProduct record);

    List<TbCoreProduct> selectByExampleWithBLOBs(TbCoreProductExample example);

    List<TbCoreProduct> selectByExample(TbCoreProductExample example);

    TbCoreProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbCoreProduct record, @Param("example") TbCoreProductExample example);

    int updateByExampleWithBLOBs(@Param("record") TbCoreProduct record, @Param("example") TbCoreProductExample example);

    int updateByExample(@Param("record") TbCoreProduct record, @Param("example") TbCoreProductExample example);

    int updateByPrimaryKeySelective(TbCoreProduct record);

    int updateByPrimaryKeyWithBLOBs(TbCoreProduct record);

    int updateByPrimaryKey(TbCoreProduct record);

	List<TbCoreProduct> getCoreproductLists();
}