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
public class SysuserController {
	@Resource
	SysuserService sysuserService;
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
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
			} else {
				map.put("code", code1);
			}
		} else {
			map.put("code", code1);
		}
		return map;
	}


	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Object> register(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		String id=request.getParameter("id");
		String cellphone = request.getParameter("cellphone");
		String password = request.getParameter("password");
		int code1=0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
		Sysuser sysuser = new Sysuser();
		sysuser.setId(id);
		sysuser.setCellphone(cellphone);
		sysuser.setPassword(password);
		sysuserService.insert(sysuser);
			code1 = 1;
			map.put("code", code1);
		} else {
			map.put("code", code1);
		}
		System.out.println(imgcode + "=====" + code + "===");
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/findpassword", method = RequestMethod.POST)
	public Map<String, Object> findpassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity====" + request.getParameter("cellphone"));
		String cellphone = request.getParameter("cellphone");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			List<Sysuser> loginList = sysuserService.login(cellphone);
			Sysuser password = loginList.get(0);
			Sysuser sysuser = new Sysuser();
			sysuser.setId(password.getId());
			sysuser.setCellphone(password.getCellphone());
			sysuser.setPassword(request.getParameter("password"));
			sysuser.setHeadImg(password.getHeadImg());
			sysuser.setEmail(password.getEmail());
			sysuser.setUserName(password.getUserName());
			sysuser.setStatus(password.getStatus());
			sysuser.setRegisterTime(password.getRegisterTime());
			if (request.getParameter("password").equals(request.getParameter("password1"))) {
				sysuserService.findpassword(sysuser);
				code1 = 1;
				map.put("code", code1);
			} else {
				map.put("code", code1);
			}
		} else {
			map.put("code", code1);
		}
		System.out.println(imgcode + "=====" + code + "===");
		return map;
	}

}
