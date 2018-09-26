package com.cn.dao;

import com.cn.pojo.TbAttentionUs;
import com.cn.pojo.TbAttentionUsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAttentionUsMapper {
    int countByExample(TbAttentionUsExample example);

    int deleteByExample(TbAttentionUsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbAttentionUs record);

    int insertSelective(TbAttentionUs record);

    List<TbAttentionUs> selectByExample(TbAttentionUsExample example);

    TbAttentionUs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbAttentionUs record, @Param("example") TbAttentionUsExample example);

    int updateByExample(@Param("record") TbAttentionUs record, @Param("example") TbAttentionUsExample example);

    int updateByPrimaryKeySelective(TbAttentionUs record);

    int updateByPrimaryKey(TbAttentionUs record);

	List<TbAttentionUs> getAttentionusLists();
}