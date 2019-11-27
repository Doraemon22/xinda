package com.xinda.cn.service;

import java.util.List;

import com.xinda.cn.model.xinda.Cart;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.vo.ECart;

public interface CarService {
	
	List<Cart> showCartPro();
	int addProIntoCart(Cart car);
	long count();
	List<ECart> showCartProList(int pageStart, int pageSize);
	int deleteByCartId(String id);
	Product findPrice(String pid);
	Cart selectCarInfoByPrimaryKeyId(String cartid);
	int updateCarInfoById(String cartid, String pnum, String money);

}
