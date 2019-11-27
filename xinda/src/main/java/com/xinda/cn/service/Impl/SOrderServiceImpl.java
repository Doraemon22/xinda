package com.xinda.cn.service.Impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xinda.cn.dao.mapper.ServiceOrderMapper;
import com.xinda.cn.model.xinda.ServiceOrder;
import com.xinda.cn.model.xinda.ServiceOrderExample;
import com.xinda.cn.service.SOrderService;
import com.xinda.cn.vo.SOrder;

@Service
public class SOrderServiceImpl implements SOrderService {
	@Resource
	   ServiceOrderMapper serviceOrderMapper;

	//1.服务商订单页  产品订单分页
	@Override
	public List<SOrder> selectSOrder(int pageStart, int pageSize) {
		ServiceOrderExample example=new ServiceOrderExample();
		example.setDistinct(true);
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		return serviceOrderMapper.selectByExample(example);
	}
	//2.获取总的记录数
	@Override
	public long getCount() {
		ServiceOrderExample example=new ServiceOrderExample();
		return serviceOrderMapper.countByExample(example);
	}
	//3.返回查询记录总数
	@Override
	public int getCount(String serviceName) {
		return serviceOrderMapper.getCount(serviceName);
	}
	//4.根据服务名称模糊查询+分页
	@Override
	public List<SOrder> selectByName(int pageStart, int pageSize, String serviceName) {
		ServiceOrderExample example=new ServiceOrderExample();
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		example.setService_name(serviceName);
		return serviceOrderMapper.selectByName(example,serviceName);
	}
	@Override
	public ServiceOrder selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return serviceOrderMapper.selectByPrimaryKey(id);
	}
	
	
	

}
