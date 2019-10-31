package com.dt.cn.controller.sysUser;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.dt.cn.model.sysUser.SysUser;
import com.dt.cn.service.SysUserService;

@Controller  //声明控制器
//@RequestMapping("/sysuser") //父级映射路径
public class SystemUserController {
	//层与层用接口交互
	@Resource //相当于创建对象
	SysUserService sysUserService ;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/sysuserlist") //子级路径
	public String getSystemUserByld(Model model,
			@RequestParam(value="xid",defaultValue="4",required=false)Integer sysid) {
		System.out.println("id=:"+sysid);
		List<SysUser> sysUserList = sysUserService.getSystemUserById(sysid);
		
		model.addAttribute("sysUserList", sysUserList);
		return "userlist";
	}
	/**
	 * 
	 * @param sysUser
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(SysUser sysUser) {
		int i=sysUserService.insert(sysUser);
		if(i==1)
			return "index";
		else 
			return "error";
	}
	
	@RequestMapping("/delete")
	public String deleteByPrimaryKey(@RequestParam(defaultValue="0",required=false)Integer id) {
		System.out.println("aaaaaaaaaaaaaaaa");
		int i=sysUserService.deleteByPrimaryKey(id);
		if(i==1)
			return "success";
		else
			return  "redirect:../delete.html";
	}
	@RequestMapping("/hello")
	public String hello(Map<String, Object> map) {
		
		return "index";
	}
	/**
	 * 按主键修改
	 * @param sysUser   
	 * @return
	 */
	
	
	@RequestMapping("/update")
	public String   updateQ(SysUser sysUser) {		
		int i=sysUserService.updateByPrimaryKey(sysUser);
		if(i==1)
			return "success";
		else
			return  "redirect:../update.html";
	}
	/**
	 * 按主键查询  异步请求
	 * @param id 主键
	 * @return  
	 */
	
	@ResponseBody
	@RequestMapping("/updateQ")
	public Map<String, Object>  updateQ(Integer id) {		
		SysUser sysUser = sysUserService.selectByPrimaryKey(id);
		System.out.println("sysid=:"+sysUser.getId());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("sysUser", sysUser);
		return map;
	}
	
	/**
	 * 登录 
	 * @param username  用户名
	 * @param password	密码 
	 * @return  成功跳转success.html，失败跳转index.html
	 */
	@RequestMapping("/selectSysUser")
	public String selectSysUser(String username,String password) {
		Map<String, String> map =new HashMap<String, String>();
		
		//trim()去掉字符串空格
		map.put("username", username.trim());
		map.put("password",password.trim());
		SysUser sysUser = sysUserService.selectSysUser(map);
		if(sysUser!=null)
			return "success";
		else 
			return "index";
	}
	
	
	/**
	 * 分页查询
	 * @param map  //向页面传参
	 * @param pageStart  为limit 函数，设起始值 
	 * @return
	 */
	@RequestMapping("/fenye1")
	//@RequestParam 参数是基本数据类型，不赋初始置，容易报错，用此注解赋默认值
	public String fenYe(Model model,
			@RequestParam(defaultValue="0")int pageStart,
			@RequestParam(defaultValue="3",required=false) int pageSize,
			String username){
		List<SysUser> sysUserList = sysUserService.selectByExample(pageStart,pageSize,username);
		model.addAttribute("sysUserList", sysUserList);
		model.addAttribute("pageStart", pageStart);
		long count=sysUserService.getCount();
		model.addAttribute("count", count);
		model.addAttribute("pageSize", pageSize);
		return "userlist1";
		
		
	}
	@RequestMapping("/fenye")
	//@RequestParam 参数是基本数据类型，不赋初始置，容易报错，用此注解赋默认值
	public String fenYe1(Map<String,Object> map,
			@RequestParam(defaultValue="0")int pageStart,
			@RequestParam(defaultValue="3") Integer pageSize,
			@RequestParam(defaultValue="")String username) {
		List<SysUser> sysUserList = sysUserService.selectByExample(pageStart,pageSize,username);
		long count=0;
		if(username.trim().equals("")||username.trim()==null)
			count=sysUserService.getCount();
		else 
			count=sysUserService.getCount(username);
		map.put("count", count);
		map.put("sysUserList", sysUserList);
		map.put("pageStart", pageStart);
		map.put("pageSize",pageSize);
		map.put("username", username);
		return  "userlist";
		}
	
	//9.接收页面信息传给业务层，并且把相应的参数传回页面
	@RequestMapping("/fenyelike")
	public String fenYeLike(Map<String,Object> map,
			@RequestParam(defaultValue="0")int pageStart,
			@RequestParam(defaultValue="3") Integer pageSize,
			@RequestParam(defaultValue="")String username) {
		List<SysUser> sysUserList = sysUserService.seletByName(pageStart,pageSize,username);
		long count=0;
		if(username.trim().equals("")||username.trim()==null)
			count=sysUserService.getCount();
		else 
			count=sysUserService.getCount(username);
		//向页面传参
		map.put("count", count);
		map.put("sysUserList", sysUserList);
		map.put("pageStart", pageStart);
		map.put("pageSize",pageSize);
		map.put("username", username);
		return  "e-commerce_product";
		}
	
	@RequestMapping("/loadimg")
	public String loadImg() {
		return "upfile";
	}
	
	@RequestMapping("/upfile")
	public String saveUserImg(MultipartFile file,Integer id) {
		
		Map<Object,Object> result = new HashMap<Object,Object>();
		try {
		// 获取客户端传图图片的输入流
		InputStream ins = file.getInputStream();
		byte[] buffer=new byte[4096];//bit---byte---1k---1m
		int len=0;
		 // 字节输出流
		 ByteArrayOutputStream bos=new ByteArrayOutputStream();
		while((len=ins.read(buffer))!=-1){
			bos.write(buffer,0,len);
		 }
		 bos.flush();
		 //toByteArray()把图片转成二进制
		byte data[] = bos.toByteArray();
		// 调用接口对图片进行存储
		SysUser user = new SysUser();
		 user.setId(id);
		user.setImg(data);
		
		sysUserService.updateImg(user);
						
		}catch(Exception e){
			//引发异常，指定跳转页
			return "error";
			}
		
		
	return "index";
	}
	@RequestMapping(value = "/headImg", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg( Integer id) throws Exception{

		byte[] imageContent ;
		// 根据id获取当前用户的信息
		SysUser sysUser=sysUserService.selectByPrimaryKey(id);
				        
		imageContent = sysUser.getImg();
		
				        
		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
}