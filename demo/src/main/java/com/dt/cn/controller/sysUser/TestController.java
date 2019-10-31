package com.dt.cn.controller.sysUser;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dt.cn.model.sysUser.SysUser;
import com.dt.cn.model.sysUser.User;

@Controller
public class TestController {
	@RequestMapping("/testBinder")
	public String testBinder(Map<String, Object> map,User sysUser) {
		
		map.put("user", sysUser);
		
		return "test";
	}

}
