package com.xinda.cn.service;

import java.util.List;

import org.springframework.expression.spel.ast.Operator;

import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.model.xinda.EUser;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.ProductExample;
import com.xinda.cn.model.xinda.ServiceOrder;
import com.xinda.cn.vo.OUser;

public interface OperatorService {

	List<BusinessOrder> selectOperByno(int pageStart, Integer pageSize, String no);

	long count();

	long searchOperatorCount(String no);

	BusinessOrder selectByBusinessOrderPrimaryKey(String id);

	EUser selectUserByPrimaryKey(String id);

	List<BusinessOrder> selectByfeiyongExample(int pageStart, int pageSize, String name);

	long getCount(String name, int i);

	int price1();

	String price(int i);

	List<BusinessOrder> timeByExample(int pageStart, int pageSize, String name);

	List<BusinessOrder> timetwoByExample(int pageStart, int pageSize, String name);

	List<BusinessOrder> timethreeByExample(int pageStart, int pageSize, String name);

	ServiceOrder selectByServiceOrderPrimaryKey(String id);
}
