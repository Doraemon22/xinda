package com.xinda.cn.controller.xinda;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinda.cn.model.xinda.EUser;
import com.xinda.cn.service.EUserService;

@Controller
public class EUserSetController {
	@Resource 
	   EUserService eUserService;
	//1.账户设置
	@ResponseBody 
	@RequestMapping("/esetShow")
	public Map<String, Object> showEUser(String eid) {
		EUser eUser=eUserService.setshow(eid);
		System.out.println("eid=:"+eUser.getId());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("eUser", eUser);
		return map;
	}
	@RequestMapping("/eset")
	public String editUser(EUser eUser) {
		int i=eUserService.set(eUser);
		System.out.println("Controller    eset===="+i);
		if(i==1) {
			return "e-commerce_set";
		}else {
			return "error";
		}
	}

}
