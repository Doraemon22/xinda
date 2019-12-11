package com.xinda.cn.controller.xinda;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.xinda.cn.model.xinda.EUser;
import com.xinda.cn.service.EUserService;
import com.xinda.cn.util.MD5Util;



@Controller
public class ESettingController {
	@Resource
	EUserService eUserService;
	/**
	 * 上传头像
	 * @param file
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/saveUserImg")
	public String saveUserImg(MultipartFile file,String id) {
		Map<Object,Object> result = new HashMap<Object,Object>();
		try {
		// 获取客户端传图图片的输入流
		InputStream ins = file.getInputStream();
		byte[] buffer=new byte[1024];//60k
		int len=0;
		 // 字节输出流
		 ByteArrayOutputStream bos=new ByteArrayOutputStream();
		while((len=ins.read(buffer))!=-1){
			bos.write(buffer,0,len);
		 }
		 bos.flush();
		byte data[] = bos.toByteArray();
		// 调用接口对图片进行存储
		EUser eUser = new EUser();
		eUser.setId(id);
		eUser.setHeadImg(data);
		eUserService.updateHeadImg(eUser);
		result.put("code",1);
		result.put("msg", "保存头像成功");
		} catch (Exception e) {
			result.put("code",0);
			result.put("msg", "保存头像失败");
			return "uploaderror";
		 }		
		return "e-commerce_set";	
	}
	/**
	 * 头像展示
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/imgshow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(HttpServletRequest request) throws Exception {
		byte[] imageContent;
		// 根据id获取当前用户的信息
		EUser eUser = eUserService.setInfoshow(request.getParameter("id"));
		imageContent = eUser.getHeadImg();
		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	/**
	 * 更改密码
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public Map<String, Object> password(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5Util md5 = new MD5Util();
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("new1password").length() == 0 || request.getParameter("new2password").length() == 0) {
			map.put("msg", "请输入新密码！");
		} else {
			if (md5.EncoderByMd5(request.getParameter("oldpassword")).equals(eUserService.findPassword(request))) {// 旧密码与数据库里的匹配
				if (md5.EncoderByMd5(request.getParameter("new1password")).equals(md5.EncoderByMd5(request.getParameter("new2password")))) {
					//2次密码输入一致
					EUser eUser2 = eUserService.setInfoshow(request.getParameter("id"));
					String id=eUser2.getId();
					map.put("id",id);
					int msg = eUserService.updataPassword(request,id);
					if (msg == 1) {
						map.put("msg", "修改密码成功");
					} else {
						map.put("msg", "修改密码失败");
					}
				} else {
					map.put("msg", "两次输入的新密码不匹配");
				}
			} else {
				map.put("msg", "旧密码不正确");
			}
		}
		return map;
	}
	/**
	 * 展示用户信息
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public Map<String, Object> editEUserInfo(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		EUser eUser2 = eUserService.setInfoshow(request.getParameter("id"));
		String id=eUser2.getId();
		map.put("id",id);
		int n = eUserService.updateInfo(request,id);
		if (n == 1) {
			map.put("msg", "修改信息成功");
		} else {
			map.put("msg", "修改信息失败");
		}
		return map;
	}


}
