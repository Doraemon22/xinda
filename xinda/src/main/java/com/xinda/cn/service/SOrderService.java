package com.xinda.cn.service;

import java.util.List;

import com.xinda.cn.model.xinda.ServiceOrder;
import com.xinda.cn.vo.SOrder;

public interface SOrderService {
	//实现mapper的功能
	List<SOrder> selectSOrder(int pageStart,int pageSize);
	//添加一个获取记录总数的函数不需要Mapper接口的方法一致
	public long getCount();
	//按业务订单号模糊查询返回的记录数
	int getCount(String serviceName);
	//订单页分页+按照业务订单号模糊查询
	List<SOrder> selectByName(int pageStart,int pageSize,String serviceName);
	//详情
	ServiceOrder selectByPrimaryKey(String id);
}
