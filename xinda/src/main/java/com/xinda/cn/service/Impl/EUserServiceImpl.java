package com.xinda.cn.service.Impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.EUserMapper;
import com.xinda.cn.model.xinda.EUser;
import com.xinda.cn.model.xinda.EUserExample;
import com.xinda.cn.service.EUserService;
import com.xinda.cn.util.MD5Util;
@Service
public class EUserServiceImpl implements EUserService{
@Resource
     EUserMapper eUserMapper;
//1.帐户设置
	@Override
	public EUser setInfoshow(String eid) {
		return eUserMapper.selectByPrimaryKey(eid);
	}
	@Override
	public void updateHeadImg(EUser eUser)  throws Exception {
		eUserMapper.saveUserImg(eUser);
	}
	  //更新信息
	@Override
	public int updateInfo(HttpServletRequest request,String id) {//,EUser eUser
	    EUser eUser=new EUser();
		if(request.getParameter("name").equals("")==false){
			eUser.setName(request.getParameter("name"));
		}
		if(request.getParameter("email").equals("")==false){
			eUser.setEmail(request.getParameter("email"));
		}
		if(request.getParameter("sex").equals("")==false){
			eUser.setSex(request.getParameter("sex"));
		}
		EUserExample eUserExample=new EUserExample();
		EUserExample.Criteria criteria=eUserExample.createCriteria();
		int n = eUserMapper.updateByExampleSelective(eUser, eUserExample,id);//updateByPrimaryKey(eUser)  改了updateByExampleSelective xml
		return n;
	}
	//更改密码系列
	@Override
	public int updataPassword(HttpServletRequest request, String id) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5Util md5 = new MD5Util();
		   EUser eUser=new EUser();
			if(request.getParameter("new2password").equals("")==false){
				 eUser.setPassword(md5.EncoderByMd5(request.getParameter("new1password")));
			}
			EUserExample eUserExample = new EUserExample();
			return eUserMapper.updateByExampleSelective(eUser, eUserExample,id);
	}
	//找回密码
	@Override
	public int findPassword(HttpServletRequest request,EUser eUser,String cellphone)throws NoSuchAlgorithmException, UnsupportedEncodingException {
		   MD5Util md5 = new MD5Util();
			if(request.getParameter("password").equals("")==false){
				 eUser.setPassword(md5.EncoderByMd5(request.getParameter("password1")));
			}
			EUserExample eUserExample = new EUserExample();
			return eUserMapper.findPasswordByCellphone(eUser, eUserExample,cellphone);
	}
	//注册
	@Override
	public int insert(EUser eUser) {
		return eUserMapper.insert(eUser);
	}

	@Override
	public String findPassword(HttpServletRequest request) {
		EUserExample eUserExample=new EUserExample();
		EUserExample.Criteria criteria=eUserExample.createCriteria();
		criteria.andIdEqualTo(request.getParameter("id"));
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<EUser> list=eUserMapper.selectByExample(eUserExample);
		String p= list.get(0).getPassword();
		if (p.equals("")) {
			return "passwordfalse";
		} else {
			return p;
		}
	}

	//登录
	@Override
	public List<EUser> login(String cellphone) {
		EUserExample eUserExample=new EUserExample();
		EUserExample.Criteria criteria=eUserExample.createCriteria();
		criteria.andCellphoneEqualTo(cellphone);
		return eUserMapper.selectByExample(eUserExample);
	}

	//找电商 的手机号和id
	@Override
	public String findCellphone(HttpServletRequest request) {
		EUserExample eUserExample=new EUserExample();
		EUserExample.Criteria criteria=eUserExample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<EUser> list=eUserMapper.selectByExample(eUserExample);
		String cellphone = list.get(0).getCellphone();
		return cellphone;
	}
	@Override
	public String findEid(HttpServletRequest request) {
		EUserExample eUserExample=new EUserExample();
		EUserExample.Criteria criteria=eUserExample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<EUser> list=eUserMapper.selectByExample(eUserExample);
		String id = list.get(0).getId();
		return id;
	}
	@Override
	public String findEname(HttpServletRequest request) {
		EUserExample eUserExample=new EUserExample();
		EUserExample.Criteria criteria=eUserExample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<EUser> list=eUserMapper.selectByExample(eUserExample);
		String name = list.get(0).getName();
		return name;
	}
	@Override
	public String findEsex(HttpServletRequest request) {
		EUserExample eUserExample=new EUserExample();
		EUserExample.Criteria criteria=eUserExample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<EUser> list=eUserMapper.selectByExample(eUserExample);
		String sex = list.get(0).getSex();
		return sex;
	}
	@Override
	public String findEemail(HttpServletRequest request) {
		EUserExample eUserExample=new EUserExample();
		EUserExample.Criteria criteria=eUserExample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<EUser> list=eUserMapper.selectByExample(eUserExample);
		String email = list.get(0).getEmail();
		return email;
	}
	//记录数
	@Override
	public long count() {
		EUserExample example=new EUserExample();
		return eUserMapper.countByExample(example);
	}
	@Override
	public long searchUserCount(String name) {
		return eUserMapper.countByeUser(name);
	}






}
