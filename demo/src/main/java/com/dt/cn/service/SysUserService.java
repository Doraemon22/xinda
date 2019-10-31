package com.dt.cn.service;

import java.util.List;
import java.util.Map;

import com.dt.cn.model.sysUser.SysUser;
import com.dt.cn.model.sysUser.SysUserExample;

public interface SysUserService {
	//实现mapper的功能
	
	List<SysUser> getSystemUserById(Integer id);

	int  insert(SysUser record);

	int deleteByPrimaryKey(Integer id);

	SysUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(SysUser record);

	SysUser selectSysUser(Map<String,String> map);
	List<SysUser> selectByExample(int pageStart ,int pageSize,String username);
	//添加一个获取记录总数的函数不需要Mapper接口的方法名一致
	public long  getCount();
	int getCount(String username);
	//7.三个参数页面用到
	List<SysUser>  seletByName(int pageStart ,int pageSize,String username);
	
	int updateImg(SysUser sysUser);
	
}
