package com.xinda.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.CartMapper;
import com.xinda.cn.dao.mapper.ProductMapper;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.model.xinda.Cart;
import com.xinda.cn.model.xinda.CartExample;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.service.CarService;
import com.xinda.cn.service.ProductService;
import com.xinda.cn.vo.ECart;
@Service
public class CarServiceImpl implements CarService{
	@Resource
	ProductMapper productMapper;
	@Resource
	CartMapper  cartMapper;
	@Resource
    ProductService productService;
	@Override
	public List<Cart> showCartPro() {
		return cartMapper.selectByExample(null);
	}
	
	@Override
	public int addProIntoCart(Cart car) {
		return cartMapper.insert(car);
	}
	//为了cartId
	@Override
	public long count() {
		CartExample cartExample=new CartExample();
		return cartMapper.countByExample(cartExample);
	}
	
	@Override
	public List<ECart> showCartProList(int pageStart, int  pageSize) {
		CartExample cartExample=new CartExample();
		cartExample.setPageSize(pageSize);
		cartExample.setPageStart(pageStart);
		return cartMapper.showCartProList(cartExample);
	}

	@Override
	public int deleteByCartId(String id) {
		return cartMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Product findPrice(String pid) {
		return productMapper.selectByPrimaryKey(pid);
	}

	@Override
	public Cart selectCarInfoByPrimaryKeyId(String cartid) {
		return cartMapper.selectByPrimaryKey(cartid);
	}

	@Override
	public int updateCarInfoById(String cartid, String pnum, String money) {
		return cartMapper.updateCarInfoById(cartid,pnum,money);
	}








}
