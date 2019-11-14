package com.xinda.cn.controller.xinda;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.xinda.cn.model.xinda.ProductExample;
import com.xinda.cn.service.EOrderService;
import com.xinda.cn.vo.EOrder;

@Controller
public class EMyOrderController {
	@Resource 
    EOrderService eOrderService;
	@Resource   
	ProductExample productExample;
	//1.电子商务  订单显示
	@RequestMapping("/findOrderByNumber")
	public String findOrderByNumber(Map<String,Object> map,
			@RequestParam(defaultValue="0")int pageStart,
			@RequestParam(defaultValue="2")Integer pageSize) {
		List<EOrder> showMyOrder=eOrderService.showEOrder(pageStart, pageSize);
		System.out.println("订单页面show======="+showMyOrder);
		long n=0;
			n=eOrderService.count();
			map.put("order", showMyOrder);
			map.put("count",n);
			map.put("pageStart", pageStart);
			map.put("pageSize", pageSize);
		return "e-commerce_order";
	}
	
//	@RequestMapping("/findOrderByNumber")
//	public String findOrderByNumber(Map<String,Object> map,
//			@RequestParam(defaultValue="0")int pageStart,
//			@RequestParam(defaultValue="2")Integer pageSize,
//			@RequestParam(defaultValue="")String number) {  
//		List<EOrder> findorder=eOrderService.selectEorderByNumber(pageStart, pageSize, number);
//		long n=0;
//		n=eOrderService.count();
//		map.put("findorder", findorder);
//		map.put("pageStart", pageStart);
//		map.put("pageSize", pageSize);
//		map.put("count",n);
//		map.put("number", number);
//       System.out.println("查询订单======"+findorder);
//       System.out.println("查询订单号======"+number);
//		return "e-commerce_order";//redirect:..prolist.html
//	}
}
