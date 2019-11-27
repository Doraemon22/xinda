package com.xinda.cn.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xinda.cn.model.xinda.Sysuser;

public interface SysuserService {
	//登录
	public List<Sysuser> login(String cellphone);
    //找回密码
	public int findPassword(HttpServletRequest request, Sysuser sysuser, String cellphone) throws NoSuchAlgorithmException, UnsupportedEncodingException;



}
