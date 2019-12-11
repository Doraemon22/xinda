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

    List<EUser> selectByExampleWithBLOBs(EUserExample example);

    List<EUser> selectByExample(EUserExample example);

    EUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EUser record, @Param("example") EUserExample example, @Param("id")String id);//更改了函数

    int updateByExampleWithBLOBs(@Param("record") EUser record, @Param("example") EUserExample example);

    int updateByExample(@Param("record") EUser record, @Param("example") EUserExample example);

    int updateByPrimaryKeySelective(EUser record);

    int updateByPrimaryKeyWithBLOBs(EUser record);

    int updateByPrimaryKey(EUser record);
    
//更新头像  
	int saveUserImg(EUser record);//, @Param("id")String id
//找回密码
	int findPasswordByCellphone(@Param("record") EUser record, @Param("example") EUserExample example, @Param("cellphone")String cellphone);
//运营
	long countByeUser(String name);

}