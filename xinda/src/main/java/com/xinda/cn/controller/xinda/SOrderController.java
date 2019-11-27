package com.xinda.cn.controller.xinda;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xinda.cn.model.xinda.ServiceOrder;
import com.xinda.cn.model.xinda.ServiceOrderExample;
import com.xinda.cn.service.SOrderService;
import com.xinda.cn.vo.SOrder;

@Controller
public class SOrderController {
	@Resource 
	  SOrderService sOrderService;
	@Resource 
	  ServiceOrderExample example;
	
//	@RequestMapping("/sorderfenye")
//	//@RequestParam 必须是基本数据类型，不赋初始值，容易报错，用此注解赋默认值
//	public String fenye(Model model,
//		@RequestParam(defaultValue="0",required=false) int pageStart,
//		@RequestParam(defaultValue="3",required=false) int pageSize) {
//		List<SOrder> sysUserList=sOrderService.selectSOrder(pageStart,pageSize);
//		long count=sOrderService.getCount(); 
//		model.addAttribute("count", count);
//	    model.addAttribute("sysUserList", sysUserList);
//	    model.addAttribute("pageStart", pageStart);
//	    model.addAttribute("pageSize", pageSize);
//		return "service_orderform";
//	}
	
	//订单页按服务名称模糊分页查询
	@RequestMapping("/findSOrdByName")
	public String fenyelike(Map<String,Object> map,
		@RequestParam(defaultValue="0") int pageStart,
		@RequestParam(defaultValue="3") Integer pageSize,
	    @RequestParam(defaultValue="") String serviceName){
		List<SOrder> sysUserList=sOrderService.selectByName(pageStart,pageSize,serviceName);
	    long count=0;
	    if(serviceName.trim().equals("")||serviceName.trim()==null) 
	    	count=sOrderService.getCount();
	    else
	    	count=sOrderService.getCount(serviceName);
	    //向页面传参
	    map.put("count", count);
		map.put("sysUserList", sysUserList);
	    map.put("pageStart", pageStart);
	    map.put("pageSize",pageSize);
	    map.put("serviceName", serviceName);
	    
	    System.out.println(sysUserList);
	    return "service_orderform";
	}
	
	@RequestMapping("/showSordInfo")
	public String showSordInfo(String id,Model model){
		ServiceOrder sorder=sOrderService.selectByPrimaryKey(id);
		model.addAttribute("sorder", sorder);
		return "sorder_info";
		
	}

}

