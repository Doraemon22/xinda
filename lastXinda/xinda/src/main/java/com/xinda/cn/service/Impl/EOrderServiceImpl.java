package com.xinda.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.BusinessOrderMapper;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.service.EOrderService;
import com.xinda.cn.vo.EOrder;
import com.xinda.cn.vo.Epro;

@Service
public class EOrderServiceImpl implements EOrderService {
	@Resource
	BusinessOrderMapper  businessOrderMapper;
	@Resource   
	BusinessOrderExample businessOrderExample;
//1.查看订单
	@Override
	public List<EOrder> showEOrder(String id) {
		return businessOrderMapper.showEOrder(businessOrderExample,id);
	}

	@Override
	public List<EOrder> findEOrder(String eorderid, String eid,String start,String end) {
			return businessOrderMapper.findEOrder(eorderid,eid,start,end);
		}
//2.订单记录数
	@Override
	public long searchOrderCount(String eorderid,String eid) {
		return businessOrderMapper.searchOrderCount(eorderid,eid);
	}
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
	//删除订单
	@Override
	public int delectMyOrder(HttpServletRequest request) {
		return businessOrderMapper.deleteByPrimaryKey(request.getParameter("orderid"));
		}


}
