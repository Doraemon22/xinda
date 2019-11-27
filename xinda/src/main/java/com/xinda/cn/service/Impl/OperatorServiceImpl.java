package com.xinda.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.BusinessOrderMapper;
import com.xinda.cn.dao.mapper.EUserMapper;
import com.xinda.cn.dao.mapper.ProductMapper;
import com.xinda.cn.dao.mapper.ServiceOrderMapper;
import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.model.xinda.EUser;
import com.xinda.cn.model.xinda.ServiceOrder;
import com.xinda.cn.service.OperatorService;
import com.xinda.cn.vo.OUser;

@Service
public class OperatorServiceImpl implements OperatorService{
	@Resource
	BusinessOrderMapper businessOrderMapper;
	@Resource
	ProductMapper productMapper;
	@Resource
	EUserMapper eUserMapper;
	@Resource
	ServiceOrderMapper serviceOrderMapper;
	@Override
	public List<BusinessOrder> selectOperByno(int pageStart, Integer pageSize, String no) {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		businessOrderExample.setDistinct(true);
		businessOrderExample.setPageStart(pageStart);
		businessOrderExample.setPageSize(pageSize);
		businessOrderExample.setNo(no);
		return businessOrderMapper.selectOperByno(businessOrderExample);
	}

	@Override
	public long count() {
		BusinessOrderExample businessOrderExample=new BusinessOrderExample();
		return businessOrderMapper.countByExample(businessOrderExample);
	}

	@Override
	public long searchOperatorCount(String operno) {
		// TODO Auto-generated method stub
		return businessOrderMapper.searchCount(operno);
	}

	@Override
	public BusinessOrder selectByBusinessOrderPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return businessOrderMapper.selectByBusinessOrderPrimaryKey(id);
	}

	@Override
	public EUser selectUserByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return eUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BusinessOrder> selectByfeiyongExample(int pageStart, int pageSize, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(String name, int i) {
		BusinessOrderExample businessOrderExample = new BusinessOrderExample();
		return businessOrderMapper.countByExample(businessOrderExample);
	}

	@Override
	public int price1() {
		// TODO Auto-generated method stub
		return businessOrderMapper.sumPrice1();
	}

	@Override
	public String price(int time) {
		// TODO Auto-generated method stub
		return businessOrderMapper.sumPrice(time);
	}

	@Override
	public List<BusinessOrder> timeByExample(int pageStart, int pageSize, String name) {
		BusinessOrderExample businessOrderExample = new BusinessOrderExample();
		businessOrderExample.setPageSize(pageSize);
		businessOrderExample.setPageStart(pageStart);
		businessOrderExample.setName(name); 
		return businessOrderMapper.timeByExample(businessOrderExample);
	}


	
	@Override
	public List<BusinessOrder> timetwoByExample(int pageStart, int pageSize, String name) {
		BusinessOrderExample businessOrderExample = new BusinessOrderExample();
		businessOrderExample.setPageSize(pageSize);
		businessOrderExample.setPageStart(pageStart);
		businessOrderExample.setName(name); 
		return businessOrderMapper.timetwoByExample(businessOrderExample);
	}
	@Override
	public List<BusinessOrder> timethreeByExample(int pageStart, int pageSize, String name) {
		BusinessOrderExample businessOrderExample = new BusinessOrderExample();
		businessOrderExample.setPageSize(pageSize);
		businessOrderExample.setPageStart(pageStart);
		businessOrderExample.setName(name); 
		return businessOrderMapper.timethreeByExample(businessOrderExample);}

	@Override
	public ServiceOrder selectByServiceOrderPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return serviceOrderMapper.selectByPrimaryKey(id);
	}

}
