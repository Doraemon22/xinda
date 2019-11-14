package com.xinda.cn.controller.xinda;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinda.cn.model.xinda.Product;

@Controller
public class XindaController {

	//@ModelAttribute("model") 
	//电子商务
	@RequestMapping("/redirect")
	public String jumpPage(HttpServletRequest  request) {
	     System.out.println("重定向页面===："+request.getParameter("page"));
			return request.getParameter("page");
	}
	//电子商务===============
	@RequestMapping("/hi")
	public ModelAndView page() {
		return  new ModelAndView("redirect:/findProByname");
	}
	//pic
//		@RequestMapping("/upload")
//		public String upload(Product pro,HttpServletRequest request,Model model) throws Exception{
//		  //保存数据库的路径
//		  String sqlPath = null; 
//		  //定义文件保存的本地路径
//	      String localPath="E:\\File\\";
//	      //定义 文件名
//	      String filename=null;  
//	      if(!pro.getFile().isEmpty()){  
//	          //生成uuid作为文件名称  
//	          String uuid = UUID.randomUUID().toString().replaceAll("-","");  
//	          //获得文件类型（可以判断如果不是图片，禁止上传）  
//	          String contentType=pro.getFile().getContentType();  
//	          //获得文件后缀名 
//	          String suffixName=contentType.substring(contentType.indexOf("/")+1);
//	          //得到 文件名
//	          filename=uuid+"."+suffixName; 
//	          //文件保存路径
//	          pro.getFile().transferTo(new File(localPath+filename));  
//	      }
//	      //把图片的相对路径保存至数据库
//	      sqlPath = "/images/"+filename;
//	      System.out.println(sqlPath);
//	      pro.setImg(sqlPath);
//	      productService.addProduct(pro);
//	      model.addAttribute("pro", pro);
//		  return "service_product";
//		}
}
