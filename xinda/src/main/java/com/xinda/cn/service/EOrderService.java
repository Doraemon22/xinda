package com.xinda.cn.service;

import java.util.List;

import com.xinda.cn.vo.EOrder;

public interface EOrderService {

	List<EOrder> showEOrder(int pageStart, Integer pageSize);

	long count();

	List<EOrder> selectEorderByNumber(int pageStart, Integer pageSize, String number);



}
