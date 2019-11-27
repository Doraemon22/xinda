package com.xinda.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.ServiceJudge;
import com.xinda.cn.vo.EOrderComment;

public interface EOrderCommentService {

	List<EOrderComment> showEOrderPro(String id);

	long count(String id);


	Product findProByProid(String proId);



	List<EOrderComment> showEOrderProCommented(String id);
//	int updateComment(HttpServletRequest request);
//	int updateComment2(HttpServletRequest request);

//评论
	long count();

	BusinessOrder findByOrderid(String id);

	int addOrderIntoserviceJudge(ServiceJudge serviceJudge);
//更改评价状态
	int updateCommentStatus(String id);



}
