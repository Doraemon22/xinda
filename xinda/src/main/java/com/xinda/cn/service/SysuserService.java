package com.xinda.cn.service;

import java.util.List;

import com.xinda.cn.model.xinda.Sysuser;

public interface SysuserService {
	//登录
	public List<Sysuser> login(String cellphone);
    //找回密码
	public int findpassword(Sysuser sysuser);
    //注册
	int insert(Sysuser record);

}
