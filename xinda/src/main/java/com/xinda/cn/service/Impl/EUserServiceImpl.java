package com.xinda.cn.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.EUserMapper;
import com.xinda.cn.model.xinda.EUser;
import com.xinda.cn.service.EUserService;
@Service
public class EUserServiceImpl implements EUserService{
@Resource
     EUserMapper eUserMapper;
//1.帐户设置
	@Override
	public int set(EUser eUser) {
		return eUserMapper.updateByPrimaryKey(eUser);
	}
	@Override
	public EUser setshow(String eid) {
		return eUserMapper.selectByPrimaryKey(eid);
	}



}
