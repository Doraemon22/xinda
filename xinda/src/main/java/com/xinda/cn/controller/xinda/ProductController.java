package com.xinda.cn.controller.xinda;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.ProductExample;
import com.xinda.cn.service.ProductService;
import com.xinda.cn.vo.Epro;
@Controller
public class ProductController {
	@Resource // 初始化对象
    ProductService productService;
	@Resource   
	ProductExample productExample;
	
//	//电子商务  展示所有商品  没公司
//	@RequestMapping("/eLogin")
//	public String productList(Map<String,Object> map) {
//		List<Product> proList=productService.selectByExample(productExample);
//		map.put("epro", proList);
//		System.out.println("proList======="+proList);
//		return "e-commerce_product";
//	}

	//添加服务商产品
	@RequestMapping("/addProduct")
	public String showProduct(Map<String,Object> map,Product pro,Model model) {
		int i=productService.addProduct(pro);
		if(i==1) {
			return "service_product";//redirect:..service_product2.html   service_product2
		}else {
			model.addAttribute("message","不好意思哈，插入失败！");
			return "error2";
		}
	}
	
	
		//  服务商 产品展示
		@RequestMapping("/proshow")
		public String proshow(Map<String,Object> map) {
			List<Product> pproList=productService.selectByExample(productExample);
			map.put("ppro",pproList);
			System.out.println("pproList======="+pproList);
			return "service_product";
		}
		//按服务名称模糊查询
		@RequestMapping("/findSproByName")
		public String fenye(Map<String, Object> map,
				@RequestParam(defaultValue = "0") int pageStart,
				@RequestParam(defaultValue = "2") int pageSize,
				@RequestParam(defaultValue="")String name) {
			List<Product> product = productService.selectSproByName(pageStart,pageSize,name);
			long count=0;
			if(name.trim().equals("")||name.trim()==null)
				count=productService.count();
			else
				count=productService.getCount(name);
			map.put("count", count);
			map.put("product", product);
			map.put("pageStart", pageStart);
			map.put("pageSize", pageSize);
			map.put("name", name);
			return "service_product";
		}
		//待完成
		@RequestMapping("/deleteSproById")
		public String deleteByPrimaryKey(String id) {
			int i=productService.deleteByProKey(id);
			if(i==1) {
				return "service_product";
			}
			return "error";
			
		}
}
