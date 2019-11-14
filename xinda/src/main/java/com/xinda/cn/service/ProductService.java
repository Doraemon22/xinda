package com.xinda.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.ProductExample;
import com.xinda.cn.vo.Epro;

public interface ProductService {

	int addProduct(Product pro);

	long count();

	long searchProductCount(String proname);
	
	long searchProductCountByProvider(String sname);
	
    List<Product> selectByExample(ProductExample example);
    
    List<Epro> selectByExample2();

	List<Epro> selectEproByname(int pageStart, Integer pageSize, String name);

	List<Epro> showPageEpro(int pageStart, Integer pageSize);

	List<Epro> selectEproByProviderName(int pageStart, Integer pageSize, String name);
	
	List<Epro> showPriceDescPro(int pageStart, Integer pageSize);//按价格升序显示产品

	List<Epro> showPriceAscPro(int pageStart, Integer pageSize);
	//==服务商===============
	//1.根据服务名称模糊查询    
	List<Product> selectSproByName(int pageStart,int pageSize,String name);
	//2.返回查询记录总数
	public long getCount(String name);
	//总数据
	//long countByExample();
	//3.根据产品id删除
	int deleteByProKey(String id);
	//4.根据服务产品id获取记录
	List<Product> getProById(String id);

	


	

}
