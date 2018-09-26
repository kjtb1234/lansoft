package com.cn.dao;

import com.cn.pojo.TbCoreTeam;
import com.cn.pojo.TbCoreTeamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCoreTeamMapper {
    int countByExample(TbCoreTeamExample example);

    int deleteByExample(TbCoreTeamExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbCoreTeam record);

    int insertSelective(TbCoreTeam record);

    List<TbCoreTeam> selectByExample(TbCoreTeamExample example);

    TbCoreTeam selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbCoreTeam record, @Param("example") TbCoreTeamExample example);

    int updateByExample(@Param("record") TbCoreTeam record, @Param("example") TbCoreTeamExample example);

    int updateByPrimaryKeySelective(TbCoreTeam record);

    int updateByPrimaryKey(TbCoreTeam record);

	List<TbCoreTeam> getCoreteamLists();
}