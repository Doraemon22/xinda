package com.xinda.cn.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xinda.cn.model.xinda.Provider;

public interface ProviderService {
	
	//登录
	public List<Provider> login(String cellphone);
	//注册
	int insert(Provider record);
	//找回密码
	public int findpassword(HttpServletRequest request, Provider provider, String cellphone)throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
	//服务商设置
	Provider showProInfo(String pid);
	//修改服务商信息

	public int updateserinformation(HttpServletRequest request);
	//根据电话号匹配相应的id
	String findCellphone(HttpServletRequest request);
	String findpid(HttpServletRequest request);

	String findsname(HttpServletRequest request);
	String findregionId(HttpServletRequest request);
	String findcellphone(HttpServletRequest request);
	String findweixin(HttpServletRequest request);
	String findqq(HttpServletRequest request);
	String findemall(HttpServletRequest request);
	
	//店铺里的服务商信息显示
	String findproviderInfo(HttpServletRequest request);
//	String findworkTime(HttpServletRequest request);
	
	int updateByProvId(Provider record);
	
	//上传头像
	void updataImg(Provider provider)throws Exception;
	Provider selectByPrimaryKey(String id);
	
//	public void saveUserImg(Provider provider) throws Exception;
	
	String getIdByCellPhone(String cellphone);
	long count();
	
	//运营商    查找服务商
		public List<Provider> selectByServicename(int pageStart, Integer pageSize, String serviceName);
		//运营  查找服务商还回记录数
		public long searchServiceNameCount(String serviceName);
	
}


