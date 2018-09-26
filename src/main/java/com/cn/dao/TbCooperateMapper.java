package com.cn.dao;

import com.cn.pojo.TbCooperate;
import com.cn.pojo.TbCooperateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCooperateMapper {
    int countByExample(TbCooperateExample example);

    int deleteByExample(TbCooperateExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbCooperate record);

    int insertSelective(TbCooperate record);

    List<TbCooperate> selectByExample(TbCooperateExample example);

    TbCooperate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbCooperate record, @Param("example") TbCooperateExample example);

    int updateByExample(@Param("record") TbCooperate record, @Param("example") TbCooperateExample example);

    int updateByPrimaryKeySelective(TbCooperate record);

    int updateByPrimaryKey(TbCooperate record);

	List<TbCooperate> getCooperateLists();
}