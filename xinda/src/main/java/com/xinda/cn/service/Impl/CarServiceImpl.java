package com.xinda.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.CartMapper;
import com.xinda.cn.dao.mapper.ProductMapper;
import com.xinda.cn.model.xinda.Cart;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.service.CarService;
import com.xinda.cn.service.ProductService;
import com.xinda.cn.vo.Epro;
@Service
public class CarServiceImpl implements CarService{
	@Resource
	ProductMapper productMapper;
	@Resource
	CartMapper  cartMapper;
	@Resource
    ProductService productService;
	@Override
	public int addcar(Product pro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Cart record) {
		List<Epro> proList=productService.selectByExample2();
		record=(Cart) proList;
		return cartMapper.insert(record);
	}

}
