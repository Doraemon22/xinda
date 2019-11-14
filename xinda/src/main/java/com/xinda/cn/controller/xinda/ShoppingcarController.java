package com.xinda.cn.controller.xinda;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.service.CarService;
import com.xinda.cn.service.ProductService;
import com.xinda.cn.vo.Epro;
@Controller
public class ShoppingcarController {
	@Resource
    CarService carService;
	@Resource
    ProductService productService;
	//添加产品到购物车
	@RequestMapping("/addcar")
	public String addcar(Map<String,Object> map,Product pro,Model model) {
		List<Epro> proList=productService.selectByExample2();
		map.put("epro", proList);
		int i=carService.addcar(pro);
		if(i==1) {
			return "service_product";//e-commerce_shoping-car
		}else {
			model.addAttribute("message","不好意思哈，插入失败！");
			return "error";
		}
	}
}
