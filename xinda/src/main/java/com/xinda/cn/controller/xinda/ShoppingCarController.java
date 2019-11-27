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

import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.Cart;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.service.CarService;
import com.xinda.cn.vo.ECart;
@Controller
public class ShoppingCarController {
	@Resource
    CarService carService;
	
	/**
	 * 添加产品到购物车
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public Map<String, Object> shop(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Cart> CartList = carService.showCartPro();
		Cart car = new Cart();
		long cartId=carService.count()+1;
		car.setId(Long.toString(cartId));//购物车id
		car.seteId(request.getParameter("eid"));//用户id
		car.setProductId((request.getParameter("id")));//产品id
    	car.setNum("1");//默认加入购物车数量为1
    	Product pro= carService.findPrice(request.getParameter("id"));//获取单价写入购物车表的总价
    	car.setTotalPrice(Integer.toString(pro.getMapketPrice()));
		int i = carService.addProIntoCart(car);
		map.put("code", i);
		map.put("CartList", CartList);
		return map;
	}
	/**
	 * 删除购物车
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/e_delete", method = RequestMethod.POST)
	public Map<String, Object> e_delete(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("id" + request.getParameter("id"));
		int i = carService.deleteByCartId(request.getParameter("id"));//购物车id
		System.out.println("======" + i);
		if (i == 1)
			map.put("msg", "success");
		else
			map.put("msg", "false");
		return map;
	}
	/**
	 * 购物车页面
	 * @param map
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/showCart")
	public String e_shoppingcar(Map<String, Object> map,
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "2") Integer pageSize) {
		List<ECart> cartList = carService.showCartProList(pageStart, pageSize);
		long count = 0;
		count = carService.count();
		map.put("count", count);
		map.put("cartList", cartList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		return "e-commerce_shoping-car";
	}
	/**
	 * 加减按钮更改产品的数量
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value= "addMinusProNumInCart" ,method = RequestMethod.POST)
	public Map<String, Object> addMinusProNumInCart(String pnum,String money,String cartid)
	{
		//Cart car = carService.selectCarInfoByPrimaryKeyId(cartid);
		int code=carService.updateCarInfoById(cartid,pnum,money);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code",code);
		return map;
	}


}
