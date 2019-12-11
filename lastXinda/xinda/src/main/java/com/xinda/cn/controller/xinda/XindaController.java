package com.xinda.cn.controller.xinda;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class XindaController {

	//@ModelAttribute("model") 
	//电子商务
	@RequestMapping("/redirect")
	public String jumpPage(HttpServletRequest  request) {
			return request.getParameter("page");
	}
	//电子商务===============
	@RequestMapping("/hi")
	public ModelAndView page() {
		return  new ModelAndView("redirect:/findProByname");
	}

}
