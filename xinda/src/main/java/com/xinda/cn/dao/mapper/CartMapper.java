package com.xinda.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xinda.cn.model.xinda.Cart;
import com.xinda.cn.model.xinda.CartExample;
import com.xinda.cn.vo.ECart;
@Mapper
public interface CartMapper {
    long countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(CartExample example);

    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);
    
    //
    List<ECart> showCartProList(@Param("example")CartExample cartExample);

	int updateCarInfoById(String cartid, String pnum, String money);
	
	 int deleteByPrimaryKey(String id);
	 
	 Cart selectByPrimaryKey(@Param("id")String id);
}