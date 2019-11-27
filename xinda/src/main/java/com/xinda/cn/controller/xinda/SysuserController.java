package com.xinda.cn.controller.xinda;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
import com.xinda.cn.util.MD5Util;

@Controller
public class SysuserController {
	@Resource
	SysuserService sysuserService;
	/**
	 * 登录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request)throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5Util md5 = new MD5Util();
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		int code1 = 0;
		String cellphone = request.getParameter("cellphone");
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			List<Sysuser> loginList = sysuserService.login(cellphone);
			Sysuser password = loginList.get(0);
			if (password.getPassword().equals(md5.EncoderByMd5(request.getParameter("password")))) {
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
/**
 * 找回密码
 * @param request
 * @return
 */
	@ResponseBody
	@RequestMapping(value = "/findpassword", method = RequestMethod.POST)
	public Map<String, Object> findpassword(HttpServletRequest request)throws NoSuchAlgorithmException, UnsupportedEncodingException {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
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
				sysuserService.findPassword(request,sysuser,cellphone);
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

}
