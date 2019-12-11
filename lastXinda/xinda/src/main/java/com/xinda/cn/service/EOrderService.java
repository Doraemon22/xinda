package com.xinda.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xinda.cn.vo.EOrder;
import com.xinda.cn.vo.Epro;

public interface EOrderService {

	List<EOrder> showEOrder(String id);

	long count();
	
	long searchOrderCount(String eorderid, String eid);

	List<EOrder> selectEorderByNumber(int pageStart, Integer pageSize, String number);

	int delectMyOrder(HttpServletRequest request);


	List<EOrder> findEOrder(String eorderid,String eid, String start, String end);



}
