package com.xinda.cn.controller.xinda;

import java.io.File;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
//	@Resource
//	ModelAndView ModelAndView;
	
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
			return "redirect:/findSproByName";
		}else {
			model.addAttribute("message","不好意思哈，插入失败！");
			return "error";
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
		//删除服务商产品
		@RequestMapping("/deleteSproById")
		public String deleteByPrimaryKey(String id) {
			int i=productService.deleteByProKey(id);
			System.out.println("删除"+id);			
			
			if(i==1) {
				System.out.println(i);
				return "redirect:/findSproByName";
				// ModelAndView modelAndView = new ModelAndView("/service_product");
				 //return new ModelAndView "redirect:/service_product.html";
			}
			//return new ModelAndView "redirect:/error.html";
			return "error";
		}
		//按id查询要修改的服务商产品信息
//		@ResponseBody
//		@RequestMapping("/updateSproQ")
//		public Map<String,Object> updateSproQ(String id) {
//			Product product=productService.selectSproById(id);
//			System.out.println("编辑"+id);
//			Map<String,Object> map=new HashMap<String,Object>();
//			map.put("product", product);
//			//返回重定向的页面
//			return map;
//		}
		
		@RequestMapping("/updateSproQ")
		public String updateSproQ(String id,Model model){
			Product product=productService.selectSproById(id);
			System.out.println("查找修改"+id);
		    model.addAttribute("product",product);
			return "update_product";
		}
		
		//修改产品信息
		@RequestMapping("/updateSpro")
		public String updateSpro(Map<String,Object> map,Product product,Model model) {
			
			int i=productService.updateSproById(product);
			System.out.println("修改"+i);
			if(i==1) {
				return "redirect:/findSproByName";
			}else {
				model.addAttribute("message","不好意思哈，插入失败！");
				return "error";
			}
		}
}
