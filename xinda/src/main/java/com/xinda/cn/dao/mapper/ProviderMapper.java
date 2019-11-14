package com.xinda.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xinda.cn.model.xinda.Provider;
import com.xinda.cn.model.xinda.ProviderExample;
@Mapper
public interface ProviderMapper {
    long countByExample(ProviderExample example);

    int deleteByExample(ProviderExample example);

    int deleteByPrimaryKey(String id);

    int insert(Provider record);

    int insertSelective(Provider record);

    List<Provider> selectByExampleWithBLOBs(ProviderExample example);

    List<Provider> selectByExample(ProviderExample example);

    Provider selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Provider record, @Param("example") ProviderExample example);

    int updateByExampleWithBLOBs(@Param("record") Provider record, @Param("example") ProviderExample example);

    int updateByExample(@Param("record") Provider record, @Param("example") ProviderExample example);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKeyWithBLOBs(Provider record);

    int updateByPrimaryKey(Provider record);
}