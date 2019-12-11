package com.xinda.cn.controller.xinda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xinda.cn.model.xinda.ProductExample;
import com.xinda.cn.service.ProductService;
import com.xinda.cn.vo.Epro;
@Controller
public class EProductController {
	@Resource 
    ProductService productService;
	@Resource   
	ProductExample productExample;

/**
 * 所有的产品图片显示
 * @param id  产品id
 * @return
 * @throws Exception
 */
	@RequestMapping(value = "/proImgShow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> proImgShow(String id) throws Exception {
		byte[] imageContent;
		// 根据id获取当前产品的信息
		Epro pro= productService.findProById(id);
		imageContent = pro.getImg();
		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	/**
	 * 电子商务  分页展示全部产品  product,provider表
	 * @param map  存产品
	 * @param pageStart  开始
	 * @param pageSize  分页大小
	 * @return
	 */
	@RequestMapping("/ePageProlist")
	public String productList(Map<String,Object> map,
			@RequestParam(defaultValue="0")int pageStart,
			@RequestParam(defaultValue="4")Integer pageSize) {
		List<Epro> showPagepro=productService.showPageEpro(pageStart, pageSize);
		long n=0;
		n=productService.count();
			map.put("epro", showPagepro);
			map.put("count",n);
			map.put("pageStart", pageStart);
			map.put("pageSize", pageSize);
		return "e-commerce_product";
	}

	/**
	 * 通过产品名称模糊查询
	 * @param map
	 * @param pageStart
	 * @param pageSize
	 * @param name  产品名称
	 * @return
	 */
	@RequestMapping("/findProByname")
	public String findProByname(Map<String,Object> map,
			@RequestParam(defaultValue="0")int pageStart,
			@RequestParam(defaultValue="4")Integer pageSize,
			@RequestParam(defaultValue="")String name) {  
		List<Epro> findpro=productService.selectEproByname(pageStart, pageSize, name);
		//List<Epro> findpro2=productService.selectEproByProviderName(pageStart, pageSize, name);
		long n=0;
		if(name.trim()==null || name.trim().equals("")) {
			n=productService.count();
		}else {
			n=productService.searchProductCount(name);  
		}
		map.put("epro", findpro);
		//map.put("epro", findpro2);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("count",n);
		map.put("name", name);
//       System.out.println("findProByname查询产品名字后count======"+n);
//       System.out.println("查询产品======"+findpro);
//       System.out.println("查询产品名称======"+name);
       //System.out.println("查询公司名称======"+sname);
		return "e-commerce_product";//redirect:..prolist.html
	}
	
	//4.epage   通过服务商名称模糊查询   没成功。。。
	@RequestMapping("/findProByProviderName")
	public String findProByname2(Map<String,Object> map,
			@RequestParam(defaultValue="0")int pageStart,
			@RequestParam(defaultValue="4")Integer pageSize,
			@RequestParam(defaultValue="")String name) {  
		List<Epro> findpro2=productService.selectEproByProviderName(pageStart, pageSize, name);
		long n=0;
		if(name.trim()==null || name.trim().equals("")) {
			n=productService.count();
		}else {
			n=productService.searchProductCountByProvider(name);
		}
		map.put("epro", findpro2);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("count",n);
		map.put("name", name);
//       System.out.println("findProByProviderName查询产品名字后count======"+n);
//       System.out.println("查询产品服务商名称======"+name);
       //System.out.println("查询公司名称======"+sname);
		return "e-commerce_product";//redirect:..prolist.html
	}
	//-------升降未成功
		@ResponseBody
		@RequestMapping(value = "/priceDesc", method = RequestMethod.POST)
		public Map<String,Object> priceDesc(Map<String,Object> map,
				@RequestParam(defaultValue="0")int pageStart,
				@RequestParam(defaultValue="4")Integer pageSize) {
			List<Epro> priceDescPro=productService.showPriceDescPro(pageStart, pageSize);
			System.out.println("降序产品======="+priceDescPro);
			long n=0;
			n=productService.count();
			Map<String,Object> map2=new HashMap<String,Object>();
				map2.put("epro", priceDescPro);
				map.put("count",n);
				map.put("pageStart", pageStart);
				map.put("pageSize", pageSize);                                                                                                                                                                                                                                                                                                                                                             
			return map2; 
		}

		@ResponseBody
		@RequestMapping(value = "/priceAsc", method = RequestMethod.POST)
		public Map<String,Object> priceAsc(Map<String,Object> map,
				@RequestParam(defaultValue="0")int pageStart,
				@RequestParam(defaultValue="4")Integer pageSize) {
			List<Epro> priceAscPro=productService.showPriceAscPro(pageStart, pageSize);
			System.out.println("升序产品======="+priceAscPro);
			long n=0;
			n=productService.count();
			Map<String,Object> map2=new HashMap<String,Object>();
				map2.put("epro", priceAscPro);
				map.put("count",n);
				map.put("pageStart", pageStart);
				map.put("pageSize", pageSize);
			return map2;
		}

}
