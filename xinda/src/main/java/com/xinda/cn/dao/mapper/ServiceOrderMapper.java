package com.xinda.cn.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xinda.cn.model.xinda.ServiceOrder;
import com.xinda.cn.model.xinda.ServiceOrderExample;
import com.xinda.cn.vo.SOrder;
@Mapper
public interface ServiceOrderMapper {
    long countByExample(ServiceOrderExample example);

    int deleteByExample(ServiceOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(ServiceOrder record);

    int insertSelective(ServiceOrder record);

    List<SOrder> selectByExample(ServiceOrderExample example);

    ServiceOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ServiceOrder record, @Param("example") ServiceOrderExample example);

    int updateByExample(@Param("record") ServiceOrder record, @Param("example") ServiceOrderExample example);

    int updateByPrimaryKeySelective(ServiceOrder record);

    int updateByPrimaryKey(ServiceOrder record);
    //***************服务商模块*********************
    //1.根据服务商名称模糊查找
    List<SOrder> selectByName(@Param("example")ServiceOrderExample example,@Param("service_name")String service_name);
    //2.根据服务商名称模糊查找返回的记录数
    int getCount( @Param("service_name")String service_name);
    //3.

}