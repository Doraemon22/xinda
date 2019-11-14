package com.xinda.cn.controller.xinda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinda.cn.model.xinda.Sysuser;
import com.xinda.cn.service.SysuserService;
@Controller
public class EUserLoginController {
	@Resource
	SysuserService sysuserService;
	
	@ResponseBody
	@RequestMapping(value = "/elogin", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity====" + request.getParameter("cellphone"));
		System.out.println("getCommodity====" + request.getParameter("password"));
		int code1 = 0;
		String cellphone = request.getParameter("cellphone");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(imgcode + "=====" + code + "===");
		if (imgcode.toUpperCase().equals(code)) {
			List<Sysuser> loginList = sysuserService.login(cellphone);
			Sysuser password = loginList.get(0);
			if (password.getPassword().equals(request.getParameter("password"))) {
				code1 = 1;
				map.put("code", code1);
//				map.put("cellphone", eLogin.findphone(request));
//				map.put("id", customerLogin.findid(request));
			} else {
				map.put("code", code1);
			}
		} else {
			map.put("code", code1);
		}
		return map;
	}

}
