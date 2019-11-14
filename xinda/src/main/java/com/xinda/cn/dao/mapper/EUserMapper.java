package com.xinda.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xinda.cn.model.xinda.EUser;
import com.xinda.cn.model.xinda.EUserExample;
@Mapper
public interface EUserMapper {
    long countByExample(EUserExample example);

    int deleteByExample(EUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(EUser record);

    int insertSelective(EUser record);

    List<EUser> selectByExample(EUserExample example);

    EUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EUser record, @Param("example") EUserExample example);

    int updateByExample(@Param("record") EUser record, @Param("example") EUserExample example);

    int updateByPrimaryKeySelective(EUser record);

    int updateByPrimaryKey(EUser record);
}