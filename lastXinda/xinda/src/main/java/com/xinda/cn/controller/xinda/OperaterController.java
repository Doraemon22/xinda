package com.xinda.cn.controller.xinda;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.model.xinda.EUser;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.Provider;
import com.xinda.cn.model.xinda.ServiceOrder;
import com.xinda.cn.service.EUserService;
import com.xinda.cn.service.OperatorService;
import com.xinda.cn.service.ProductService;
import com.xinda.cn.service.ProviderService;
import com.xinda.cn.vo.OUser;

@Controller
public class OperaterController {
	@Resource
	OperatorService operatorService;
	@Resource
	ProductService productService;
	@Resource
	ProviderService providerService;
	@Resource
	EUserService eUserService;
	@Resource
	BusinessOrderExample example;

	@RequestMapping("/oplogin")
	public String op_login() {

		return "operator_product";
	}

	//订单页   checked
	@RequestMapping("/findOperByno")
	public String findOperByno(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") Integer pageSize, @RequestParam(defaultValue = "") String no) {
		List<BusinessOrder> findoper = operatorService.selectOperByno(pageStart, pageSize, no);
		long n = 0;
		if (no.trim() == null || no.trim().equals("")) {
			n = operatorService.count();
		} else {
			n = operatorService.searchOperatorCount(no);
		}
		map.put("oper", findoper);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("count", n);
		map.put("no", no);
		return "operator_orderform";
	}
//checked
	@RequestMapping("/findOperByusername")
	public String findOperByusername(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") Integer pageSize, @RequestParam(defaultValue = "") String name) {
		List<OUser> findoper = productService.selectOuserByName(pageStart, pageSize, name);
		long n = 0;
		if (name.trim() == null || name.trim().equals("")) {
			n = eUserService.count();
		} else {
			n = eUserService.searchUserCount(name);
		}
		map.put("oper", findoper);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("count", n);
		map.put("name", name);
		return "operator_user";// redirect:..prolist.html
	}
//checked
	@RequestMapping("/findByServicename")
	public String findByServicename(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "") String serviceName) {
		List<Provider>  servicer=providerService.selectByServicename(pageStart, pageSize, serviceName);
		long n = 0;
		if (serviceName.trim() == null || serviceName.trim().equals("")) {
			n = providerService.count();
		} else {
			n = providerService.searchServiceNameCount(serviceName);
		}
		map.put("oper", servicer);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("count", n);
		map.put("serviceName", serviceName);
		return "operator_facilitator";// redirect:..prolist.html
	}
//checked
	@RequestMapping("/findOperByname")
	public String findOperByname(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") Integer pageSize, @RequestParam(defaultValue = "") String name) {
		List<Product> findoper = productService.selectOSproByName(pageStart, pageSize, name);
		long n = 0;
		if (name.trim() == null || name.trim().equals("")) {
			n = productService.count();
		} else {
			n = productService.searchProductCount(name);
		}
		map.put("oper1", findoper);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("count", n);
		map.put("name", name);
		return "operator_product";// redirect:..prolist.html
	}
//checked
	@RequestMapping("/deleteOSproById")
	public ModelAndView deleteSproById(Map<String, Object> map,
			@RequestParam(defaultValue = "0", required = false) String id) {
		int i = productService.deleteByProKey(id);
		if (i == 1) {
			return new ModelAndView("redirect:/findOperByname");
			// ModelAndView modelAndView = new ModelAndView("/service_product");
			// return new ModelAndView "redirect:/service_product.html";
		}
		// return new ModelAndView "redirect:/error.html";
		return new ModelAndView("redirect:/findOperByname");
	}

//checked
	@RequestMapping("/updateOSpro")
	public String updateSpro(Map<String,Object> map,Product product) {
		
		int i=productService.updateSproById(product);
		if(i==1) {
			map.put("msg", "修改成功");
			return "redirect:/findOperByname";
		}else {
			return "error";
		}
	}

//订单  点击详情    checked
	@RequestMapping("/showOper")
	public String showSordInfo(String id, Model model) {
		BusinessOrder border = operatorService.selectByBusinessOrderPrimaryKey(id);
		model.addAttribute("border", border);
		return "xiangqing";

	}
	
	@RequestMapping("/showServiceOrder")
	public String showServiceOrderInfo(String id, Model model) {
		ServiceOrder Sorder = operatorService.selectByServiceOrderPrimaryKey(id);
		model.addAttribute("sorder", Sorder);
		return "xiangqing2";

	}
	//checked
	@RequestMapping("/findByRecommendname")
	public String findByRecommendname(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") Integer pageSize, @RequestParam(defaultValue = "") String name) {
		List<Product> findoper = productService.selectOSproByName(pageStart, pageSize, name);
		long n = 0;
		if (name.trim() == null || name.trim().equals("")) {
			n = productService.count();
		} else {
			n = productService.searchProductCount(name);
		}
		map.put("oper", findoper);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("count", n);
		map.put("name", name);
		return "operator_recommend";// redirect:..prolist.html

	}

	@RequestMapping("/look")
	public String look(String id, Model model) {
		EUser User = operatorService.selectUserByPrimaryKey(id);
		model.addAttribute("user", User);
		return "look";
	}
	@ResponseBody
	@RequestMapping("/feiyong")
	public ModelAndView findserviceproductprivce(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,

			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String name) {
		List<BusinessOrder> expence = operatorService.selectByfeiyongExample(pageStart, pageSize, name);
		long pageCount = 0;
		pageCount = operatorService.getCount(name, -1);
		int price = operatorService.price1();
		map.put("expence", expence);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name", name);
		map.put("pageCount", pageCount);
		map.put("feiyong", "feiyong");
		map.put("price", price);
		return new ModelAndView("operator_expenses");
	}

	@RequestMapping("/qitian")
	public ModelAndView findQi(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,

			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String name) {
		List<BusinessOrder> expence = operatorService.timeByExample(pageStart, pageSize, name);
		long pageCount = 0;
		pageCount = operatorService.getCount(name, 7);
		String price = operatorService.price(7);
		map.put("expence", expence);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name", name);
		map.put("feiyong", "qitian");
		map.put("pageCount", pageCount);
		map.put("price", price);
		return new ModelAndView("operator_expenses");
	}

	@RequestMapping("/yiyue")
	public ModelAndView findYue(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,

			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String name) {
		List<BusinessOrder> expence = operatorService.timetwoByExample(pageStart, pageSize, name);
		long pageCount = 0;
		pageCount = operatorService.getCount(name, 30);
		String price = operatorService.price(30);
		map.put("expence", expence);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name", name);
		map.put("pageCount", pageCount);
		map.put("feiyong", "yiyue");
		map.put("price", price);
		return new ModelAndView("operator_expenses");
	}

	@RequestMapping("/jintian")
	public ModelAndView findTian(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String name) {
		List<BusinessOrder> expence = operatorService.timethreeByExample(pageStart, pageSize, name);
		long pageCount = 0;
		pageCount = operatorService.getCount(name, 0);
		String price = operatorService.price(0);
		map.put("expence", expence);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name", name);
		map.put("feiyong", "jintian");
		map.put("pageCount", pageCount);
		map.put("price", price);

		return new ModelAndView("operator_expenses");
	}

}
