package com.dt.cn.dao.mapper;

import com.dt.cn.model.sysUser.SysUser;
import com.dt.cn.model.sysUser.SysUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper //相当于dao
public interface SysUserMapper {
	//下列方法与SysUserMapper.xml的id相对应
    long countByExample(SysUserExample example);    
    //5.匹配按名字模糊查询的方法与映射器相对应
    List<SysUser> selectByName(SysUserExample example);
    //6.模糊查询总记录数
    int getCount(@Param("username")String username);
    
    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(@Param("example")SysUserExample example,@Param("username") String username);

    SysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectSysUser(Map<String, String> map);
}