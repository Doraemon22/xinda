package com.xinda.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.BusinessOrderMapper;
import com.xinda.cn.dao.mapper.ProductMapper;
import com.xinda.cn.dao.mapper.ServiceJudgeMapper;
import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.ServiceJudge;
import com.xinda.cn.model.xinda.ServiceJudgeExample;
import com.xinda.cn.service.EOrderCommentService;
import com.xinda.cn.vo.EOrderComment;

@Service
public class EOrderCommentServiceImpl implements EOrderCommentService{
	@Resource 
	BusinessOrderMapper businessOrderMapper;
	@Resource 
	ProductMapper productMapper;
	@Resource 
	ServiceJudgeMapper serviceJudgeMapper;

	
	@Override
	public List<EOrderComment> showEOrderPro(String id) {
		return businessOrderMapper.showEOrderPro(id);
	}
	@Override
	public List<EOrderComment> showEOrderProCommented(String id) {
		return businessOrderMapper.showEOrderProCommented(id);
	}
	
	@Override
	public long count(String id) {
		return businessOrderMapper.count(id);
	}


	@Override
	public Product findProByProid(String proId) {
	return productMapper.selectByPrimaryKey(proId);
	
	}
//添加评论   no successful
//	@Override
//	public int updateComment(HttpServletRequest request) {  //service_judge
//		if(request.getParameter("content").equals("") == false) {//评价内容
//			ServiceJudge serviceJudge = new ServiceJudge();
//			serviceJudge.setContent(request.getParameter("content"));//评价写入评价表
//			ServiceJudgeExample serviceJudgeExample = new ServiceJudgeExample();
//			ServiceJudgeExample.Criteria criteria = serviceJudgeExample.createCriteria();
//			criteria.andEIdEqualTo(request.getParameter("id"));
//			  System.out.println("eid========service"+request.getParameter("id"));
//			criteria.andOrderIdEqualTo(request.getParameter("orderid"));//业务订单
//			return serviceJudgeMapper.updateByExampleSelective(serviceJudge, serviceJudgeExample);
//	}
//		return 0;
//
//	}
//	@Override
//	public int updateComment2(HttpServletRequest request) {
//		if(request.getParameter("content").equals("") == false) {//评价内容
//			BusinessOrder businessOrder = new BusinessOrder();
//			businessOrder.setCommentStatus(1);//更改订单表的评价状态
//			BusinessOrderExample businessOrderExample = new BusinessOrderExample();
//			BusinessOrderExample.Criteria criteria = businessOrderExample.createCriteria();
//			criteria.andEIdEqualTo(request.getParameter("eid"));
//			criteria.andBusinessNoEqualTo(request.getParameter("orderid"));//业务订单
//			return businessOrderMapper.updateByExampleSelective(businessOrder, businessOrderExample);
//	}
//		return 0;
//	}
//	
	
	
	//加评论
	
	@Override
	public long count() {
		return serviceJudgeMapper.countByExample(null);
	}
	@Override
	public BusinessOrder findByOrderid(String id) {
		return businessOrderMapper.selectByPrimaryKeyId(id);
	}
	@Override
	public int addOrderIntoserviceJudge(ServiceJudge serviceJudge) {
		return serviceJudgeMapper.insert(serviceJudge);
	}
	@Override
	public int updateCommentStatus(String id) {
		// TODO Auto-generated method stub
		return businessOrderMapper.updateCommentStatus(id);
	}


}
