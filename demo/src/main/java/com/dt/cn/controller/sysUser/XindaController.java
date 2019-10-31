package com.dt.cn.controller.sysUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class XindaController  {
	@RequestMapping("/servcielogin")
	public String login() {
		return "service_login";
	}
	
	@RequestMapping("/hi")
	public ModelAndView fenye() {		
		return new ModelAndView("redirect:/fenyelike");
	}
}
