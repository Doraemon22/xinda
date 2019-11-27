package com.xinda.cn.controller.xinda;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.ServiceJudge;
import com.xinda.cn.service.EOrderCommentService;
import com.xinda.cn.vo.EOrderComment;

@Controller
public class EOrderCommentController {
	@Resource 
	EOrderCommentService eOrderCommentService;
	//已评价
	@ResponseBody
	@RequestMapping(value= "commented",method = RequestMethod.POST)
	public Map<String,Object> commented(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String,Object> ();
		List<EOrderComment> eOderPro=eOrderCommentService.showEOrderProCommented(request.getParameter("id"));//电子商务用户的id
		System.out.println(eOderPro);

		map.put("eOderPro", eOderPro);
		return map;
	}

	/**
	 * 评论订单产品的图片，用前台的pid取图片   src(pid)-->headImg(String pid)-->findProByProid(pid)
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commentProImgShow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(String pid) throws Exception {
		byte[] imageContent;
		System.out.println("图片=id==" + pid);
		Product pro = eOrderCommentService.findProByProid(pid);//返回一条记录
		System.out.println("图片=pro==" + pro);
		imageContent = pro.getImg();
		System.out.println("图片===" + pro.getImg());
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}

//获取没评价的订单信息，进行页面渲染
	@ResponseBody
	@RequestMapping(value= "/ecomment",method = RequestMethod.POST)
	public Map<String,Object> eOderProShow(HttpServletRequest request) {
		System.out.println("ecomment");
		List<EOrderComment> eOderPro=eOrderCommentService.showEOrderPro(request.getParameter("id"));//电子商务用户的id
		System.out.println("订单产品======="+eOderPro);
		long eOderProCount=0;
		eOderProCount=eOrderCommentService.count(request.getParameter("id"));
		System.out.println("订单产品个数======="+eOderProCount);
		Map<String,Object> map=new HashMap<String,Object>();
			map.put("eOderPro", eOderPro);
			map.put("count",eOderProCount);
		return map;
	}
	

	  @ResponseBody
	  @RequestMapping(value= "saveComment",method = RequestMethod.POST) 
	  public Map<String,Object> saveComment(HttpServletRequest request) {
		  System.out.println("eid======用户==con====="+request.getParameter("id"));
		  System.out.println("orderid====订单====con====="+request.getParameter("orderid"));//有问题！！！
	  Map<String,Object> map = new HashMap<String, Object>();
	  
	  ServiceJudge serviceJudge=new ServiceJudge();
	  serviceJudge.setContent(request.getParameter("content"));
	  serviceJudge.setJudgeTime(new Date());
	  serviceJudge.seteId(request.getParameter("id"));
	  long n=eOrderCommentService.count()+1;
	  serviceJudge.setId(Long.toString(n));//serviceJudge  id
	  serviceJudge.setStatus(1);//更改状态为已评价   应该把bussinessOrder里的改为1
//	  BusinessOrder  businessOrder=eOrderCommentService.findByOrderid(request.getParameter("orderid"));
//	  businessOrder.setCommentStatus(1);
	  serviceJudge.setOrderId(request.getParameter("orderid"));
		int i = eOrderCommentService.addOrderIntoserviceJudge(serviceJudge);//把东东添加到数据库的表里****
		int j=eOrderCommentService.updateCommentStatus(request.getParameter("orderid"));//更改bussinessOrder状态为已评价
//	  int x = eOrderCommentService.updateComment(request);
//	  int y = eOrderCommentService.updateComment2(request);
	  if(i*j == 1)
	  {
		  map.put("msg", "评价成功");
	  }
	  else {
		  map.put("msg", "评价失败");
	  }
	  
	  return map;
	  
	  }
}
