package com.xinda.cn.controller.xinda;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.BusinessOrderExample;

import com.xinda.cn.service.OperatorService;



@Controller
public class OperaterController {
	@Resource 
    OperatorService operatorService;
	
	
	@RequestMapping("/oplogin")
	public String op_login() {
		
		return "operator_product";
	}
	//
	@RequestMapping("/findOperByno")
	public String findOperByno(Map<String,Object> map,
			@RequestParam(defaultValue="0")int pageStart,
			@RequestParam(defaultValue="5")Integer pageSize,
			@RequestParam(defaultValue="")String no) {  
		System.out.println("11111111111");
		List<BusinessOrder> findoper=operatorService.selectOperByno(pageStart, pageSize, no);
		long n=0;
		if(no.trim()==null || no.trim().equals("")) {
			n=operatorService.count();
		}else {
			n=operatorService.searchOperatorCount(no);
		}
		map.put("oper", findoper);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("count",n);
		map.put("no", no);
       System.out.println("findOperByno查询产品名字后count======"+n);
       System.out.println("查询产品======"+findoper);
		return "operator_orderform";//redirect:..prolist.html
	}
}
