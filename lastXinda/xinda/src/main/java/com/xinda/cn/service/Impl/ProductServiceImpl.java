package com.xinda.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.ProductMapper;
import com.xinda.cn.model.xinda.Product;
import com.xinda.cn.model.xinda.ProductExample;
import com.xinda.cn.service.ProductService;
import com.xinda.cn.vo.Epro;
import com.xinda.cn.vo.OUser;
@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	ProductMapper productMapper;
//	@Resource
//	ProviderMapper providerMapper;
	@Resource   
	ProductExample productExample;
//	@Resource
//	ProviderExample providerExample;
	
	//1服务商页 .添加服务产品
	@Override
	public int addProduct(Product pro) {
		return productMapper.insert(pro);
	}
	//2.电子商务页面的 分页显示产品
	@Override
	public List<Epro> showPageEpro(int pageStart, Integer pageSize) {
		productExample.setDistinct(true);
		productExample.setPageStart(pageStart);    
		productExample.setPageSize(pageSize);
		return productMapper.showPageEpro(productExample);//mapper，xml里要写个showPageEpro
	}
	//no successful
	@Override
	public List<Epro> showPriceDescPro(int pageStart, Integer pageSize) {
		productExample.setDistinct(true);
		productExample.setPageStart(pageStart);    
		productExample.setPageSize(pageSize);
		return productMapper.showPriceDescPro(productExample);
	}
	//no successful
	@Override
	public List<Epro> showPriceAscPro(int pageStart, Integer pageSize) {
		productExample.setDistinct(true);
		productExample.setPageStart(pageStart);    
		productExample.setPageSize(pageSize);
		return productMapper.showPriceAscPro(productExample);
	}
	//3.电子商务页面的 产品模糊分页查询
	@Override
	public List<Epro> selectEproByname(int pageStart, Integer pageSize, String name) {
		productExample.setDistinct(true);
		productExample.setPageStart(pageStart);    
		productExample.setPageSize(pageSize);
		return productMapper.selectEproByname(productExample, name);//mapper，xml里要写个selectEproByname
	}
	@Override
	public List<Epro> selectEproByProviderName(int pageStart, Integer pageSize, String name) {
		productExample.setDistinct(true);
		productExample.setPageStart(pageStart);    
		productExample.setPageSize(pageSize);
		return productMapper.selectEproByProviderName(productExample, name);//mapper，xml里要写个selectEproByname2
	}
    //4.总的产品记录数
	@Override
	public long count() {
		return productMapper.countByExample(productExample);
	}
	//5.查询后的产品记录数
	@Override
	public long searchProductCount(String proname) {
		return productMapper.searchCount(proname);
	}
	//6.根据服务商名字查询还回的产品记录数
	@Override
	public long searchProductCountByProvider(String sname) {
		return productMapper.searchCountProvider(sname);
	}
	@Override
	public List<Product> selectByExample(ProductExample example) {
	return productMapper.selectByExample(productExample);
	}
	@Override
	public List<Epro> selectByExample2() {
		return productMapper.selectByExample2();
	}
	//7.服务商产品分页+按服务名称模糊查询
		@Override
		public List<Product> selectSproByName(int pageStart, int pageSize, String name,String e) {
			ProductExample pexample=new ProductExample();
			pexample.setDistinct(true);
			pexample.setPageStart(pageStart);
			pexample.setPageSize(pageSize);
			return productMapper.selectSproByName(pexample,name,e);
		}
		//8.返回查询记录数
		@Override
		public long getCount(String name) {
			ProductExample pexample=new ProductExample();
			return productMapper.getCount(name);
		}
//		@Override
//		public long countByExample() {
//			ProductExample pexample=new ProductExample();
//			return productMapper.countByExample(pexample);
//		}
		//9.按照服务产品id删除
		@Override
		public int deleteByProKey(String id) {
			int i=0;
			List<Product> proList=getProById(id);
			if(proList.size()!=0) {
				return productMapper.deleteByProKey(id);
			}
			return i;
		}
		//10.按id查询出要删除的记录
		@Override
		public List<Product> getProById(String id) {
			System.out.println("查询"+id);
			ProductExample proexample=new ProductExample();
			ProductExample.Criteria criteria=proexample.createCriteria();
			criteria.andIdEqualTo(id);
			return productMapper.selectByExample(proexample);
		}
		//11.查询出要修改的产品
		@Override
		public Product selectSproById(String id) {
			// TODO Auto-generated method stub
			return productMapper.selectSproById(id);
		}
		//12.修改产品信息
		@Override
		public int updateSproById(Product pro) {
			// TODO Auto-generated method stub
			return productMapper.updateSproById(pro);
		}
//------------------------------------------------------------------------------------
	//img
	@Override
	public Epro findProById(String id ) {
		return productMapper.selectByPrimaryKey2(id);
	}
	//toPay
	@Override
	public Product getToPayProById(String id) {
		return productMapper.selectByPrimaryKey(id);
	}
	// -------------************---chi
		@Override
		public List<OUser> selectOuserByName(int pageStart, Integer pageSize, String name) {
			productExample.setDistinct(true);
			productExample.setPageStart(pageStart);    
			productExample.setPageSize(pageSize);
			return productMapper.selectOuserByName(productExample, name);
		}
	
		@Override
		public long countByProId() {
			ProductExample productExample=new ProductExample();
			return productMapper.countByExample(productExample);
		}
		@Override
		public void updataImg(Product product) throws Exception {
			productMapper.saveUserImg(product);
			
		}
		//运营
		@Override
		public List<Product> selectOSproByName(int pageStart, Integer pageSize, String name) {
			ProductExample pexample=new ProductExample();
			pexample.setDistinct(true);
			pexample.setPageStart(pageStart);
			pexample.setPageSize(pageSize);
			return productMapper.selectOSproByName(pexample,name);
		}
		

}
