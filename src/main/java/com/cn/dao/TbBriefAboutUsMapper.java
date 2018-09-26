package com.cn.dao;

import com.cn.pojo.TbBriefAboutUs;
import com.cn.pojo.TbBriefAboutUsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBriefAboutUsMapper {
    int countByExample(TbBriefAboutUsExample example);

    int deleteByExample(TbBriefAboutUsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbBriefAboutUs record);

    int insertSelective(TbBriefAboutUs record);

    List<TbBriefAboutUs> selectByExampleWithBLOBs(TbBriefAboutUsExample example);

    List<TbBriefAboutUs> selectByExample(TbBriefAboutUsExample example);

    TbBriefAboutUs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbBriefAboutUs record, @Param("example") TbBriefAboutUsExample example);

    int updateByExampleWithBLOBs(@Param("record") TbBriefAboutUs record, @Param("example") TbBriefAboutUsExample example);

    int updateByExample(@Param("record") TbBriefAboutUs record, @Param("example") TbBriefAboutUsExample example);

    int updateByPrimaryKeySelective(TbBriefAboutUs record);

    int updateByPrimaryKeyWithBLOBs(TbBriefAboutUs record);

    int updateByPrimaryKey(TbBriefAboutUs record);

	List<TbBriefAboutUs> getBriefaboutusLists();
}