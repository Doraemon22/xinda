package com.xinda.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xinda.cn.model.xinda.BusinessOrder;
import com.xinda.cn.model.xinda.BusinessOrderExample;
import com.xinda.cn.model.xinda.BusinessOrderKey;
import com.xinda.cn.vo.EOrder;
@Mapper
public interface BusinessOrderMapper {
    long countByExample(BusinessOrderExample example);

    int deleteByExample(BusinessOrderExample example);

    int deleteByPrimaryKey(BusinessOrderKey key);

    int insert(BusinessOrder record);

    int insertSelective(BusinessOrder record);

    List<BusinessOrder> selectByExample(BusinessOrderExample example);

    BusinessOrder selectByPrimaryKey(BusinessOrderKey key);

    int updateByExampleSelective(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByExample(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByPrimaryKeySelective(BusinessOrder record);

    int updateByPrimaryKey(BusinessOrder record);
    //****************运营商模块************
    //1.按业务订单号模糊查询+分页
    List<BusinessOrder> selectOperByno(BusinessOrderExample businessOrderExample);
    //2.根据业务订单号模糊查找返回的记录数
	long searchCount(String operno);

	List<EOrder> showEOrder(@Param("example") BusinessOrderExample businessOrderExample);

	List<EOrder> selectEorderByNumber(@Param("example")BusinessOrderExample businessOrderExample, @Param("example")String number);
}