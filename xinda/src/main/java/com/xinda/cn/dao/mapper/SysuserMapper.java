package com.xinda.cn.dao.mapper;

import com.xinda.cn.model.xinda.Sysuser;
import com.xinda.cn.model.xinda.SysuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysuserMapper {
    long countByExample(SysuserExample example);

    int deleteByExample(SysuserExample example);

    int deleteByPrimaryKey(String id);

    int insert(Sysuser record);

    int insertSelective(Sysuser record);

    List<Sysuser> selectByExampleWithBLOBs(SysuserExample example);

    List<Sysuser> selectByExample(SysuserExample example);

    Sysuser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Sysuser record, @Param("example") SysuserExample example);

    int updateByExampleWithBLOBs(@Param("record") Sysuser record, @Param("example") SysuserExample example);

    int updateByExample(@Param("record") Sysuser record, @Param("example") SysuserExample example);

    int updateByPrimaryKeySelective(Sysuser record);

    int updateByPrimaryKeyWithBLOBs(Sysuser record);
    
}