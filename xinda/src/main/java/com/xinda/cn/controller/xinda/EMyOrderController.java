package com.xinda.cn.controller.xinda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.ProductExample;
import com.xinda.cn.service.EOrderService;
import com.xinda.cn.service.EPayService;
import com.xinda.cn.vo.EOrder;
import com.xinda.cn.vo.Epro;

@Controller
public class EMyOrderController {
	@Resource 
    EOrderService eOrderService;
	@Resource   
	ProductExample productExample;
	@Resource
    EPayService ePayService;
	/**
	 * 订单页面去付款,此时不生成新的订单，只跳转到支付页面
	 * 之后点击支付，去改变付款状态  2
	 * @param id  订单id
	 * @return   code为1只为跳到支付页面
	 */
	@ResponseBody
	@RequestMapping(value= "payOrder" ,method = RequestMethod.POST)//
	public Map<String, Object> pay()//HttpServletRequest request
	{
		//String id=request.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		//int code = ePayService.updateBuyStatus(id);//返回值为1，跳到付款页面
		map.put("code",1);
		return map;
	}
	/**
	 * 删除我的订单
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteMyOrder", method = RequestMethod.POST)
	public Map<String, Object> deleteMyOrder(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("deleteMyOrder=="+request);
		int a = eOrderService.delectMyOrder(request);
		System.out.println(a);
		if (a ==1) {//=1
			map.put("msg", "删除成功");
		} else {
			map.put("msg", "删除失败");
		}
		return map;

	}
	
	/**
	 * 电子商务  订单显示
	 * @param request
	 * @param map
	 * @param eorderid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value= "/OrderShow")//,method = RequestMethod.POST
	public ModelAndView OrderShow(HttpServletRequest request,Map<String,Object> map,
			@RequestParam(defaultValue="")String eorderid) {
		String e=(String) request.getSession().getAttribute("eeid");	//eid
		System.out.println("eorderid"+eorderid);
	//	List<Epro> eOderPro=eOrderService.showMyOrderPro(request.getParameter("id"));//电子商务用户的id
		List<EOrder> showMyOrder=eOrderService.showEOrder(e);//request.getParameter("id")
		
		System.out.println("订单页面show======="+showMyOrder);
			map.put("showMyOrder", showMyOrder);
			return new ModelAndView("e-commerce_order.html");
	}
	/**
	 * 订单查询，未成功。。。
	 * @param request
	 * @param eorderid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value= "/findOrderByNumber")//,method = RequestMethod.POST    ModelAndView
	public Map<String,Object> findOrderByNumber(HttpServletRequest request,
			@RequestParam(defaultValue="")String eorderid) {
	//	String e=(String) request.getSession().getAttribute("eeid");	//eid为空  why？
		System.out.println(request.getParameter("startTime"));
		System.out.println(request.getParameter("endTime"));
		System.out.println(request.getParameter("eorderid"));
		System.out.println("web里存的eid===="+request.getParameter("eid"));
		String e=(String) request.getSession().getAttribute("eeid");	//eid
		System.out.println("java里存的eid===="+request.getParameter("e"));
//		String startTime=request.getParameter("startTime");
//		String startTime=request.getParameter("endTime");
		List<EOrder> findMyOrder=eOrderService.findEOrder(eorderid,request.getParameter("eid"),request.getParameter("startTime"),request.getParameter("endTime"));
		System.out.println("订单页面find======="+findMyOrder);
		Map<String,Object> map=new HashMap<String,Object>();
		long n=0;
		if(eorderid.trim()==null || eorderid.trim().equals("")) {
		n=eOrderService.count();
		System.out.println("n=1==========="+n);
	}else {
		n=eOrderService.searchOrderCount(eorderid,e);
		System.out.println("n=2==========="+n);
	}
			map.put("showMyOrder", findMyOrder);
			map.put("count",n);
			return map;
	}

}
