package com.xinda.cn.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xinda.cn.model.xinda.EUser;

public interface EUserService {
//账户设置
	EUser setInfoshow(String eid);
	int updateInfo(HttpServletRequest request, String id);//, EUser eUser
	  //密码部分
	int updataPassword(HttpServletRequest request, String id) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	String findPassword(HttpServletRequest request);

//登录
	List<EUser> login(String cellphone);
	String findCellphone(HttpServletRequest request);
	String findEid(HttpServletRequest request);
	//登录时取这些值用于在更改页面信息显示
	String findEname(HttpServletRequest request);
	String findEsex(HttpServletRequest request);
	String findEemail(HttpServletRequest request);
//上传头像
	void updateHeadImg(EUser eUser)   throws Exception;
//注册
	int  insert(EUser eUser);
//找回密码
     int findPassword(HttpServletRequest request,EUser eUser,String cellphone)  throws NoSuchAlgorithmException, UnsupportedEncodingException;
  //记录数
	long count();
	//运营用户界面
	long searchUserCount(String name);





	



	

}
