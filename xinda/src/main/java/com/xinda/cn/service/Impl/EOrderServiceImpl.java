package com.xinda.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.BusinessOrderMapper;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.service.EOrderService;
import com.xinda.cn.vo.EOrder;

@Service
public class EOrderServiceImpl implements EOrderService {
	@Resource
	BusinessOrderMapper  businessOrderMapper;
	@Resource   
	BusinessOrderExample businessOrderExample;
//1.看订单
	@Override
	public List<EOrder> showEOrder(int pageStart, Integer pageSize) {
		businessOrderExample.setDistinct(true);
		businessOrderExample.setPageStart(pageStart);    
		businessOrderExample.setPageSize(pageSize);
		return businessOrderMapper.showEOrder(businessOrderExample);
	}
//2.订单记录数
	@Override
	public long count() {
		return businessOrderMapper.countByExample(businessOrderExample);
	}
	@Override
	public List<EOrder> selectEorderByNumber(int pageStart, Integer pageSize, String number) {
		businessOrderExample.setDistinct(true);
		businessOrderExample.setPageStart(pageStart);    
		businessOrderExample.setPageSize(pageSize);
		return businessOrderMapper.selectEorderByNumber(businessOrderExample, number);
	}

}
