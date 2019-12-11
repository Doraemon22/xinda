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
