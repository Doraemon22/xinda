package com.xinda.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.BusinessOrderMapper;
import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.service.OperatorService;

@Service
public class OperatorServiceImpl implements OperatorService{
	@Resource
	BusinessOrderMapper businessOrderMapper;
	
	//1.运营商订单页 按业务订单号模糊查询+分页
	@Override
	public List<BusinessOrder> selectOperByno(int pageStart, Integer pageSize, String no) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		businessOrderExample.setDistinct(true);
		businessOrderExample.setPageStart(pageStart);    
		businessOrderExample.setPageSize(pageSize);
		businessOrderExample.setNo(no);
		return businessOrderMapper.selectOperByno(businessOrderExample);
	}
	//2.总产品记录数
	@Override
	public long count() {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		return businessOrderMapper.countByExample(businessOrderExample);
	}
	//3.查询后的产品记录数
	@Override
	public long searchOperatorCount(String operno) {
		// TODO Auto-generated method stub
		return businessOrderMapper.searchCount(operno);
	}



}
