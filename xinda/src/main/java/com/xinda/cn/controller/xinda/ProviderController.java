package com.xinda.cn.controller.xinda;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.Provider;
import com.xinda.cn.service.ProviderService;


@Controller
public class ProviderController {
	@Resource // 初始化对象
	ProviderService providerService;
	
//	@RequestMapping("/showprovider") // 显示服务商信息
//	public String showProvider(Map<String, Object> map) {
//		List<Provider> prolist = providerService.selectProvider();
//		map.put("prolist", prolist);
//		System.out.println(prolist);
//		return "service_setting";
//	}


}
