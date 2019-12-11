package com.xinda.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.BusinessOrderMapper;
import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.service.EPayService;
@Service
public class EPayServiceImpl implements EPayService {
	@Resource
	BusinessOrderMapper  businessOrderMapper;
	@Resource   
	BusinessOrderExample businessOrderExample;
	
//订单数目
	@Override
	public long count() {
		return businessOrderMapper.countByExample(businessOrderExample);
	}
//显示要付钱的订单信息
	@Override
	public List<BusinessOrder> showBPro(String id) {
		return businessOrderMapper.selectByExample2(id);//
	}
	//把付钱的产品插入订单
	@Override
	public int addProIntoBusinessOrder(BusinessOrder b) {
		return businessOrderMapper.insert(b);
	}
	//查找订单
	@Override
	public BusinessOrder selectByPrimaryKeyId(String id) {
		return businessOrderMapper.selectByPrimaryKeyId(id);//参数加了注解
	}
	//更新
	@Override
	public int updateByExample(BusinessOrder businessOrder) {
		BusinessOrderExample businessOrderExample = new BusinessOrderExample();
		BusinessOrderExample.Criteria criteria = businessOrderExample.createCriteria();
		criteria.andIdEqualTo(businessOrder.getId());
		return businessOrderMapper.updateByExample(businessOrder, businessOrderExample);
	}
	//更新付款状态为2
	@Override
	public int updateBuyStatus(String id) {
		return businessOrderMapper.updateBuyStatus(id);
	}

}
