package com.xinda.cn.service;

import java.util.List;

import org.springframework.expression.spel.ast.Operator;

import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.BusinessOrderExample;

public interface OperatorService {
	//1.按业务订单号模糊查询+分页
	List<BusinessOrder> selectOperByno(int pageStart, Integer pageSize, String no);
    //似乎没用到
	long count();
	//2.根据业务订单号模糊查找返回的记录数
	long searchOperatorCount(String no);

}
