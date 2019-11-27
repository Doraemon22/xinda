package com.xinda.cn.controller.xinda;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.ProductExample;
import com.xinda.cn.model.xinda.Provider;
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
			long id=productService.countByProId()+1;
			pro.setId(Long.toString(id));
			int i=productService.addProduct(pro);
			if(i==1) {
		//		model.addAttribute("msg", attributeValue)
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
		public String fenye(HttpServletRequest request,Map<String, Object> map,
				@RequestParam(defaultValue = "0") int pageStart,
				@RequestParam(defaultValue = "4") int pageSize,
				@RequestParam(defaultValue="")String name) {
			String e=(String) request.getSession().getAttribute("proid");
			List<Product> product = productService.selectSproByName(pageStart,pageSize,name,e);
			System.out.println("find=="+product+"e"+e);
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
			map.put("msg", "操作成功！！");
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
		//运营服务商
		@RequestMapping("/updateSproQ")
		public String updateSproQ(String id,Model model){
			Product product=productService.selectSproById(id);
			System.out.println("查找修改"+id);
		    model.addAttribute("product",product);
			return "update_product";
		}
		//服务商
		@RequestMapping("/updateSproInfoQ")
		public String updateSproInfoQ(String id,Model model){
			Product product=productService.selectSproById(id);
			System.out.println("查找修改"+id);
		    model.addAttribute("product",product);
			return "update_product1";
		}
		
		//修改产品信息
		@RequestMapping("/updateSpro")
		public String updateSpro(Map<String,Object> map,Product product) {
			
			int i=productService.updateSproById(product);
			System.out.println("修改"+i);
			if(i==1) {
				map.put("msg", "修改成功");
				return "redirect:/findSproByName";
			}else {
				return "error";
			}
		}
		
		/**
		 * 上传图片 （主页添加图片的）
		 * @param file
		 * @param id
		 * @return
		 */
		@RequestMapping("/saveUserImg1")
		public String saveUserImg1(MultipartFile file,Product product) {
			Map<Object, Object> result = new HashMap<Object, Object>();			
			try {
				// 获取客户端传图图片的输入流
				InputStream ins = file.getInputStream();
				byte[] buffer = new byte[4096];// bit---byte---1k---1m
				int len = 0;
				// 字节输出流
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				while ((len = ins.read(buffer)) != -1) {
					bos.write(buffer, 0, len);
				}
				bos.flush();
				byte data[] = bos.toByteArray();
				System.out.println(data);

				product.setImg(data);
			//	providerService.updateByProvId(provider);
				productService.updataImg(product);
				result.put("code", 1);
				result.put("msg", "保存头像成功");
			} catch (Exception e) {
				result.put("code", 0);
				result.put("msg", "保存头像失败");
				return "service_product";
			}
			return "redirect:/updateSProInfoQ?id="+product.getId();
		}
}
