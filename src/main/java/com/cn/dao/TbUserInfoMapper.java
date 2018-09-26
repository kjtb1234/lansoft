package com.cn.dao;

import com.cn.pojo.TbUserInfo;
import com.cn.pojo.TbUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserInfoMapper {
    int countByExample(TbUserInfoExample example);

    int deleteByExample(TbUserInfoExample example);

    int insert(TbUserInfo record);

    int insertSelective(TbUserInfo record);

    List<TbUserInfo> selectByExample(TbUserInfoExample example);

    int updateByExampleSelective(@Param("record") TbUserInfo record, @Param("example") TbUserInfoExample example);

    int updateByExample(@Param("record") TbUserInfo record, @Param("example") TbUserInfoExample example);

	List<TbUserInfo> getUserinfoLists();

	TbUserInfo selectByPrimaryKey(String id);

	int updateByPrimaryKey(TbUserInfo tb);

	int deleteByPrimaryKey(String id);

	TbUserInfo validateLogin(String telphone);

	TbUserInfo selectByPhoneAndPass(@Param("record")TbUserInfo record);
}