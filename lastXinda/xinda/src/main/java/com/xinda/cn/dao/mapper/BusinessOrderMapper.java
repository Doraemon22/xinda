package com.xinda.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.model.xinda.BusinessOrderKey;
import com.xinda.cn.model.xinda.EUser;
import com.xinda.cn.model.xinda.ServiceOrder;
import com.xinda.cn.vo.EOrder;
import com.xinda.cn.vo.EOrderComment;
@Mapper
public interface BusinessOrderMapper {
    long countByExample(BusinessOrderExample example);

    int deleteByExample(BusinessOrderExample example);

   // int deleteByPrimaryKey(BusinessOrderKey key);
    int deleteByPrimaryKey(String id);//MyOrder  e

    int insert(BusinessOrder record);

    int insertSelective(BusinessOrder record);

    List<BusinessOrder> selectByExample(BusinessOrderExample example);

    BusinessOrder selectByPrimaryKey(BusinessOrderKey key);

    int updateByExampleSelective(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByExample(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByPrimaryKeySelective(BusinessOrder record);

    int updateByPrimaryKey(BusinessOrder record);
    
    //****************运营商模块************
    List<BusinessOrder> selectOperByno(BusinessOrderExample businessOrderExample);

	long searchCount(String operno);
	BusinessOrder selectByBusinessOrderPrimaryKey(String id);
	EUser selectUserByPrimaryKey(String id);//无

	int sumPrice1();

	List<BusinessOrder> timeByExample(BusinessOrderExample businessOrderExample);

	String sumPrice(int time);

	List<BusinessOrder> timetwoByExample(BusinessOrderExample businessOrderExample);

	List<BusinessOrder> timethreeByExample(BusinessOrderExample businessOrderExample);
	
  	ServiceOrder selectByServiceOrderPrimaryKey(String id);
//MyOrder  e
	List<EOrder> showEOrder(@Param("example") BusinessOrderExample businessOrderExample,@Param("e_id")String e_id);
	List<EOrder> findEOrder(@Param("business_no") String business_no,@Param("e_id")String e_id, @Param("start") String start,@Param("end")  String end);
	long searchOrderCount(@Param("eorderid") String eorderid,@Param("e_id")String e_id);
	List<EOrder> selectEorderByNumber(@Param("example")BusinessOrderExample businessOrderExample, @Param("example")String number);
//顾客订单评价系列
	long count(@Param("id")String id);

	List<EOrderComment> showEOrderPro(@Param("id")String id);
//评价完的
	List<EOrderComment> showEOrderProCommented(@Param("id")String id);
	
    List<BusinessOrder> selectByExample2(String id);
    
    int updateCommentStatus(@Param("id")String id);
  //----付款-----------------------
	BusinessOrder selectByPrimaryKeyId(@Param("id")String id);

	int updateBuyStatus(@Param("id")String id);
	//BusinessOrder findByOrderid(String id);


}