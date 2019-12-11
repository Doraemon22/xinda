package com.xinda.cn.service;

import java.util.List;

import com.xinda.cn.model.xinda.BusinessOrder;

public interface EPayService {

	long count();

	List<BusinessOrder> showBPro(String id);

	int addProIntoBusinessOrder(BusinessOrder b);

	int updateByExample(BusinessOrder businessOrder);

	BusinessOrder selectByPrimaryKeyId(String id);

	int updateBuyStatus(String id);

}
