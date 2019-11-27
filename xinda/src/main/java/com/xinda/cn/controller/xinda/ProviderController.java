package com.xinda.cn.controller.xinda;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xinda.cn.model.xinda.Provider;
import com.xinda.cn.service.ProviderService;
import com.xinda.cn.util.MD5Util;

@Controller
public class ProviderController {
	@Resource // 初始化对象
	ProviderService providerService;
	
//	@ResponseBody
//    @RequestMapping(value = "/servicelogin", method = RequestMethod.POST)
//    public Map<String, Object> login(String imgcode, String cellphone, String password, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        String code = (String) session.getAttribute("code");
//        int code1 = 0;
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (imgcode.toUpperCase().equals(code) && cellphone != null) {
//            Provider provider = providerService.selectByPrimaryKey(providerService.getIdByCellPhone(cellphone));
//            System.out.println(provider);
//            if (provider.getPassword().equals(password)) {
//                code1 = 1;
//                map.put("code", code1);
//                map.put("providerId", provider.getId());
//                request.getSession().setAttribute("providerId", providerService.getIdByCellPhone(cellphone));
//                System.out.println(provider.getId());
//            } else {
//                map.put("code", code1);
//            }
//        } else {
//            map.put("code", code1);
//        }
//        return map;
//    }

	/**
	 *  登录  根据用户输入 的手机号到数据库里匹配密码
	 * @param imgcode
	 * @param cellphone
	 * @param password
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/prologin", method = RequestMethod.POST)
		 public Map<String, Object> login(String imgcode, String cellphone, String password, HttpServletRequest request) {
		        HttpSession session = request.getSession();
		        String code = (String) session.getAttribute("code");
		        int code1 = 0;
		 Map<String, Object> map = new HashMap<String, Object>();
	        if (imgcode.toUpperCase().equals(code) && cellphone != null) {
	            Provider provider = providerService.selectByPrimaryKey(providerService.getIdByCellPhone(cellphone));
	            System.out.println(provider);
	            if (provider.getPassword().equals(password)) {
	            	code1 = 1;
					map.put("code", code1);
					map.put("providerId", provider.getId());
	                request.getSession().setAttribute("providerId", providerService.getIdByCellPhone(cellphone));
					map.put("cellphone",providerService.findCellphone(request));
					map.put("id",providerService.findpid(request));
					session.setAttribute("proid", providerService.findpid(request));
					
					map.put("sname",providerService.findsname(request));
					System.out.println("snames"+providerService.findsname(request));
					map.put("regionId",providerService.findregionId(request));
					map.put("cellphone",providerService.findcellphone(request));
					System.out.println("cellphone"+providerService.findcellphone(request));
					map.put("weixin",providerService.findweixin(request));
					
					map.put("qq",providerService.findqq(request));
					map.put("emall",providerService.findemall(request));
					map.put("providerInfo",providerService.findproviderInfo(request));
			//		map.put("pworkTime",providerService.findworkTime(request));
				map.put(cellphone, cellphone);
				} else {
					map.put("code", code1);
				}
			} else {
				map.put("code", code1);
			}
//		}
		return map;

	}

	/**
	 * 注册
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/serviceregister", method = RequestMethod.POST)
	public Map<String, Object> register(HttpServletRequest request)throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5Util md5 = new MD5Util();
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		String id = request.getParameter("id");
		String cellphone = request.getParameter("cellphone");
		String password = md5.EncoderByMd5(request.getParameter("password"));
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			Provider provider = new Provider();
			long pid=providerService.count()+1;
			provider.setId(Long.toString(pid));
			provider.setCellphone(cellphone);
			provider.setPassword(password);
			String cmbProvince = request.getParameter("cmbProvince");
			System.out.println(" cmbProvince===="+ request.getParameter("cmbProvince"));
			String cmbCity = request.getParameter("cmbCity");
			String cmbArea = request.getParameter("cmbArea");
			String regin = cmbProvince + cmbCity + cmbArea;
			provider.setRegionId(regin);
			providerService.insert(provider);
			code1 = 1;
			map.put("code", code1);
		} else {
			map.put("code", code1);
		}
		System.out.println(imgcode + "=====" + code + "===");
		return map;
	}

	/**
	 * 找回密码
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/servicefindpassword", method = RequestMethod.POST)
	public Map<String, Object> findpassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity====" + request.getParameter("cellphone"));
		String cellphone = request.getParameter("cellphone");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			List<Provider> loginList = providerService.login(cellphone);
			if (loginList != null && loginList.size() > 0) {
				Provider password = loginList.get(0);
				Provider provider = new Provider();
				provider.setId(password.getId());
				provider.setCellphone(password.getCellphone());
				provider.setPassword(request.getParameter("password"));
				if (request.getParameter("password").equals(request.getParameter("password1"))) {
					providerService.findpassword(provider);
					code1 = 1;
					map.put("code", code1);
				} else {
					map.put("code", code1);
				}
			} else {
				map.put("code", code1);
			}
		}
		System.out.println(imgcode + "=====" + code + "===");
		return map;
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/updateinfo", method = RequestMethod.POST)
//	public Map<String, Object> updateproInfo(HttpServletRequest request)
//			throws NoSuchAlgorithmException, UnsupportedEncodingException {
//		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println("updateinfo    id   ===="+request.getParameter("id"));
//		Provider pro=providerService.showProInfo(request.getParameter("id"));
//		System.out.println("====="+pro);
//		String id=pro.getId();  //没取到id?空指针异常？
//		map.put("id", id);
//		int n=providerService.updateproInfo(request,request.getParameter("id"));
//		if(n==1) {
//			map.put("msg", "修改成功");
//		}else {
//			map.put("msg", "修改失败");
//		}
//		return map;
//		
//	}	
	
	/**
	 * 修改服务商信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateinfo", method = RequestMethod.POST)
	public Map<String, Object> updateserviceprodiver(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Provider provider = new Provider();
		String cmbProvince = request.getParameter("cmbProvince");
		System.out.println(" ddddddddddddd"+ request.getParameter("cmbProvince"));
		String cmbCity = request.getParameter("cmbCity");
		String cmbArea = request.getParameter("cmbArea");
		String regin = cmbProvince + cmbCity + cmbArea;
		provider.setRegionId(regin);
		int a = providerService.updateserinformation(request);
		System.out.println("修改===="+a);
		if (a == 1) {			
			map.put("code", 1);
			map.put("status", "更改成功");

		} else {
			map.put("code", 2);
			map.put("status", "更改 失败");
		}

		return map;
	}

//	
//	@RequestMapping("/loadimg")
//	public String loadImg() {
//		return "upfile";
//	}

	/**
	 * 上传图片 （服务商设置里的）
	 * @param file
	 * @param id
	 * @return
	 */
	@RequestMapping("/saveUserImg2")
	public String saveUserImg(MultipartFile file,Provider provider,HttpServletRequest request) {
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		String cmbProvince = request.getParameter("cmbProvince");
		System.out.println(" ddddddddddddd"+ request.getParameter("cmbProvince"));
		String cmbCity = request.getParameter("cmbCity");
		String cmbArea = request.getParameter("cmbArea");
		String regin = cmbProvince + cmbCity + cmbArea;
		provider.setRegionId(regin);
		
		try {
			// 获取客户端传图图片的输入流
			InputStream ins = file.getInputStream();
			byte[] buffer = new byte[4096];// bit---byte---1k---1m
			int len = 0;
			// 字节输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while ((len = ins.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.flush();
			byte data[] = bos.toByteArray();
			System.out.println(data);

			provider.setProviderImg(data);
		//	providerService.updateByProvId(provider);
			providerService.updataImg(provider);
			result.put("code", 1);
			result.put("msg", "保存头像成功");
		} catch (Exception e) {
			result.put("code", 0);
			result.put("msg", "保存头像失败");
			return "service_setting";
		}
		return "redirect:/updateProInfoQ?id="+provider.getId();
	}

	/**
	 * 头像显示（服务商设置里的）
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/headImg2", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(HttpServletRequest request) throws Exception {

		byte[] imageContent;
		Provider provider= providerService.showProInfo(request.getParameter("id"));
		imageContent = provider.getProviderImg();
		// System.out.println("图片==="+produt.getImg());
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	
	/**
	 * 上传头像 （店铺营业执照）
	 * @param file
	 * @param provider
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveUserImg3")
	public String saveUserImg3(MultipartFile file,Provider provider) {
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		try {
			// 获取客户端传图图片的输入流
			InputStream ins = file.getInputStream();
			byte[] buffer = new byte[4096];// bit---byte---1k---1m
			int len = 0;
			// 字节输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while ((len = ins.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.flush();
			byte data[] = bos.toByteArray();
			System.out.println(data);

			provider.setProviderImg(data);
		//	providerService.updateByProvId(provider);
			providerService.updataImg(provider);
			result.put("code", 1);
			result.put("msg", "保存头像成功");
		} catch (Exception e) {
			result.put("code", 0);
			result.put("msg", "保存头像失败");
			return "service_store";
		}
		return "redirect:/updateProInfoQ3?id="+provider.getId();
	}

	/**
	 * 头像显示（店铺的营业执照）
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/headImg3", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg3(HttpServletRequest request) throws Exception {

		byte[] imageContent;
		Provider provider= providerService.showProInfo(request.getParameter("id"));
		imageContent = provider.getProviderImg();
		// System.out.println("图片==="+produt.getImg());
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	
	/**
	 * 店铺信息显示
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/providerInfo")
	public String selectByProvider(HttpServletRequest request, Model model) {
		String id = (String) request.getSession().getAttribute("providerId");
		Provider provider = providerService.selectByPrimaryKey(id);
		model.addAttribute("provider", provider);
		return "service_setting";

	}
	
	/**
	 * 修改店铺信息
	 * @param provider
	 * @return
	 */
	@RequestMapping("/updateProInfo")
	public String updateprovider(Provider provider) {
		int i = providerService.updateByProvId(provider);
		System.out.println("i="+i);
		if (i == 1) {
			return "redirect:/updateProInfoQ?id="+provider.getId();  //获取修改id的值传给providerupdateQ
		} else {
			return "error";
		}

	}

	/**
	 * 按主键查找要修改的店铺
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateProInfoQ")
	public String providerupdateQ(String id, Model model) throws Exception {
		Provider provider = providerService.selectByPrimaryKey(id);
		model.addAttribute("provider", provider);
		return "service_setting";
	}
	
	@RequestMapping("/updateProInfoQ3")
	public String providerupdateQ3(String id, Model model) throws Exception {
		Provider provider = providerService.selectByPrimaryKey(id);
		model.addAttribute("provider", provider);
		return "service_store";
	}

}
