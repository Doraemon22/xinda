package com.xinda.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.ProductExample;
import com.xinda.cn.vo.Epro;
@Mapper
public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExampleWithBLOBs(ProductExample example);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExampleWithBLOBs(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
    
    long searchCount(@Param("name")String name);//模糊查询还回记录数 
	
	long searchCountProvider(@Param("sname")String sname);//模糊查询还回记录数 
	//电子商务模块
    List<Epro> selectByExample2();

	List<Epro> selectEproByname(@Param("productExample")ProductExample productExample, @Param("name") String name);//map 产品模糊分页查询

	List<Epro> showPageEpro(@Param("productExample")ProductExample productExample);//map 产品分页显示
	List<Epro> showPriceDescPro(@Param("productExample")ProductExample productExample);
	List<Epro> showPriceAscPro(@Param("productExample")ProductExample productExample);

	List<Epro> selectEproByProviderName(@Param("productExample")ProductExample productExample, @Param("sname") String name);//map 产品模糊分页查询
	//服务商模块
	//1.按服务名称模糊查询+分页
	List<Product> selectSproByName(@Param("pexample") ProductExample pexample,@Param("name") String name);
	//2.根据服务商名称模糊查找返回的记录数
	long getCount(String name);
	//3.按主键id查询服务产品进行删除
	int deleteByProKey(String id);  //xml没写
	//4.根据id查询要修改的服务商产品
		Product selectSproById(String id);
	//5.修改服务商产品
	int updateSproById(Product record);

	
}