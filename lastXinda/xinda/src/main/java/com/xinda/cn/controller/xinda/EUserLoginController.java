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

import com.xinda.cn.model.xinda.EUser;
import com.xinda.cn.service.EUserService;
import com.xinda.cn.util.MD5Util;
@Controller
public class EUserLoginController {
	@Resource
	EUserService eUserService;

	/**                 登录
	 * 根据用户输入 的手机号到数据库里匹配密码
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/elogin", method = RequestMethod.POST)
	public Map<String, Object> elogin(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5Util md5 = new MD5Util();
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		int code1 = 0;//匹配不成功还回0，显示信息输入错误
		String cellphone = request.getParameter("cellphone");//从页面获取的手机号
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			List<EUser> loginList = eUserService.login(cellphone);
			EUser password = loginList.get(0);//===
			if (password.getPassword().equals(md5.EncoderByMd5(request.getParameter("password")))) {
				code1 = 1;//匹配成功
				map.put("code", code1);//返回匹配成功，js里存一些数据
				map.put("cellphone", eUserService.findCellphone(request));
				map.put("id", eUserService.findEid(request));
				//取name，sex，email为了在更改电商用户信息上显示原来是数据
				map.put("name", eUserService.findEname(request));
				map.put("sex", eUserService.findEsex(request));
				map.put("email", eUserService.findEemail(request));
				session.setAttribute("eeid", eUserService.findEid(request));//java存eid
			    map.put("cellphone", cellphone);
			} else {
				map.put("code", code1);
			}
		} else {
			map.put("code", code1);
		}
		return map;
	}
	/**
	 * 注册
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@ResponseBody
	@RequestMapping(value = "/euserRegister", method = RequestMethod.POST)
	public Map<String, Object> register(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5Util md5 = new MD5Util();
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		String cellphone = request.getParameter("cellphone");
		String password = md5.EncoderByMd5(request.getParameter("password"));
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			EUser eUser = new EUser();
			long eid=eUserService.count()+1;
			eUser.setId(Long.toString(eid));
			eUser.setCellphone(cellphone);
			eUser.setPassword(password);
			String cmbProvince = request.getParameter("cmbProvince");
			String cmbCity = request.getParameter("cmbCity");
			String cmbArea = request.getParameter("cmbArea");
			String regin = cmbProvince + cmbCity + cmbArea;
			eUser.setRegionId(regin);
			eUserService.insert(eUser);
			code1 = 1;//注册成功
			map.put("code", code1);
		} else {
			map.put("code", code1);
		}
		return map;
	}
/**
 * 找回密码  2次输入密码一致且数据库有cellphone即可找回密码
 * @param request
 * @return
 * @throws UnsupportedEncodingException 
 * @throws NoSuchAlgorithmException 
 */
	@ResponseBody
	@RequestMapping(value = "/euserFindPassword", method = RequestMethod.POST)
	public Map<String, Object> findpassword(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		String cellphone = request.getParameter("cellphone");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			List<EUser> loginList = eUserService.login(cellphone);
			if (loginList != null && loginList.size() > 0) {
				EUser password = loginList.get(0);
				EUser eUser = new EUser();
				eUser.setId(password.getId());
				eUser.setCellphone(password.getCellphone());
				eUser.setPassword(request.getParameter("password"));
				if (request.getParameter("password").equals(request.getParameter("password1"))) {
					eUserService.findPassword(request,eUser,cellphone);
					code1 = 1;
					map.put("code", code1);
				} else {
					map.put("code", code1);
				}
			} else {
				map.put("code", code1);
			}
		}
		return map;
	}
}
