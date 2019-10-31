package com.dt.cn.controller.sysUser;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.cn.model.sysUser.Comovement;
import com.dt.cn.service.ComovementService;
//6.控制层业务处理
@Controller
public class ComovementController {
	@Resource
	ComovementService comovementService;
	
	@RequestMapping("/findprovince")
	public String findPorvince(Map<String,Object> map) {
		List<Comovement> province=comovementService.findPorvince();
		map.put("province", province);
		
		return "comovement";
	}
	
	@RequestMapping("/fi")
	public String fi(Map<String,Object> map) {
		
		
		return "comovement";
	}

	@RequestMapping("/findcity")
	@ResponseBody
	public Object findCity(String pr_name ) {
		System.out.println("1111111111");
		List<Comovement> city=comovementService.findCity(pr_name);
		return city;
	}

	@RequestMapping("/findcounty")
	@ResponseBody
	public Object findCounty(String ci_name ) {
		List<Comovement> county=comovementService.findCounty(ci_name);
		return county;
	}

}
