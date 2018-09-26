package com.cn.dao;

import com.cn.pojo.TbCallUs;
import com.cn.pojo.TbCallUsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCallUsMapper {
    int countByExample(TbCallUsExample example);

    int deleteByExample(TbCallUsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbCallUs record);

    int insertSelective(TbCallUs record);

    List<TbCallUs> selectByExample(TbCallUsExample example);

    TbCallUs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbCallUs record, @Param("example") TbCallUsExample example);

    int updateByExample(@Param("record") TbCallUs record, @Param("example") TbCallUsExample example);

    int updateByPrimaryKeySelective(TbCallUs record);

    int updateByPrimaryKey(TbCallUs record);

	List<TbCallUs> getCallusLists();

}