package com.xinda.cn.controller.xinda;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.service.EPayService;
import com.xinda.cn.service.ProductService;

@Controller
public class EPayController {
	@Resource
    EPayService ePayService;
	@Resource
    ProductService productService;

	/**
	 * 支付页面 的订单详情
	 * @param map
	 * @param id  订单id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value= "payInfo")//,method = RequestMethod.POST
	public ModelAndView payInfo(Map<String,Object> map,String id)//,HttpServletRequest request
	{    
		//String id2=request.getParameter("id");
		List<BusinessOrder> bPro = ePayService.showBPro(id);
		System.out.println("payInfo  id2"+id+"payInfo  id"+id);
		map.put("bPro",bPro);
		return new ModelAndView( "e-commerce_pay");
	}
	/**
	 * 点击立即购买后，付款后，改变付款状态为2
	 * @param id   订单id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value= "pay" ,method = RequestMethod.POST)//
	public Map<String, Object> pay(String id,HttpServletRequest request)//,Integer way
	{
		String way=request.getParameter("payWay");
		Map<String, Object> map = new HashMap<String, Object>();
		BusinessOrder businessOrder = ePayService.selectByPrimaryKeyId(id);
		businessOrder.setStatus("2");
		System.out.println("支付way是"+way);
		businessOrder.setPayType(Integer.parseInt(way));//要变换一下
		int code = ePayService.updateByExample(businessOrder);
		map.put("code",code);
		return map;
	}
	/**
	 * 点击立即购买后，生成订单，但是没有付款，付款状态为1
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/toPay", method = RequestMethod.POST)
	public Map<String, Object> toPay(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BusinessOrder> bPro = ePayService.showBPro(request.getParameter("id"));
		Product  pro = productService.getToPayProById(request.getParameter("id"));//产品id
		System.out.println("toPay=========="+pro);
		BusinessOrder b = new BusinessOrder();
		long bId=ePayService.count()+1;
		b.setBusinessNo(Long.toString(bId));//订单id
		b.setId(Long.toString(bId));
		b.seteId(request.getParameter("eid"));//用户id
		b.setProductId((request.getParameter("id")));//产品id
		//根据产品id得到价格
		pro.getMapketPrice();
		b.setUnitPrice(	pro.getMapketPrice());
	    b.setTotalPrice(pro.getMapketPrice());
	    //订单info
		pro.getInfo();
	    b.setOrderInfo(pro.getInfo());
	    int buyNum=1;
		b.setBuyNum(buyNum);          //购买数量默认为1个
		b.setCommentStatus(0);      
		b.setStatus("1");//还没支付
		b.setCreateTime(new Date());
		int i = ePayService.addProIntoBusinessOrder(b);
		map.put("code", i);
		map.put("id",bId);
		map.put("bPro", bPro);
		return map;
	}


}
