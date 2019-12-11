package com.xinda.cn.service.Impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xinda.cn.dao.mapper.ProviderMapper;
import com.xinda.cn.model.xinda.Provider;
import com.xinda.cn.model.xinda.ProviderExample;
import com.xinda.cn.service.ProviderService;
import com.xinda.cn.util.MD5Util;


@Service

public class ProviderServiceImpl implements ProviderService {
	@Resource
	ProviderMapper providerMapper;
	/**
     * 登录
     */
	@Override
	public List<Provider> login(String cellphone) {
		ProviderExample providerExample=new ProviderExample();
		ProviderExample.Criteria criteria=providerExample.createCriteria();
		criteria.andCellphoneEqualTo(cellphone);
		return providerMapper.selectByExample(providerExample);
	}
	
	/**
	 * 注册
	 */
	@Override
	public int insert(Provider record) {
		return providerMapper.insert(record);
	}

	/**
	 * 找回密码
	 */
	@Override
	public int findpassword(HttpServletRequest request, Provider provider, String cellphone)throws NoSuchAlgorithmException, UnsupportedEncodingException {
		  MD5Util md5 = new MD5Util();
		  if(request.getParameter("password").equals("")==false){
			  provider.setPassword(md5.EncoderByMd5(request.getParameter("password1")));
			}
		ProviderExample providerExample=new ProviderExample();
		return providerMapper.findPasswordByCellphone(provider, providerExample,cellphone);
	}

	//服务商信息
	@Override
	public Provider showProInfo(String pid) {
		/*
		 * ProviderExample providerExample = new ProviderExample();
		 * ProviderExample.Criteria criteria = providerExample.createCriteria();
		 * criteria.andIdEqualTo(pid);
		 */
		return providerMapper.selectByPrimaryKey(pid);
	}

	//根据电话号取id
	@Override
	public String findCellphone(HttpServletRequest request) {
		ProviderExample providerexample=new ProviderExample();
		ProviderExample.Criteria criteria=providerexample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<Provider> list=providerMapper.selectByExample(providerexample);
		String cellphone=list.get(0).getCellphone();
		return cellphone;
	}

	@Override
	public String findpid(HttpServletRequest request) {
		ProviderExample providerexample=new ProviderExample();
		ProviderExample.Criteria criteria=providerexample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<Provider> list=providerMapper.selectByExample(providerexample);
		String id=list.get(0).getId();
		return id;
	}

	//显示服务商信息
	@Override
	public String findsname(HttpServletRequest request) {
		ProviderExample providerexample=new ProviderExample();
		ProviderExample.Criteria criteria=providerexample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<Provider> list=providerMapper.selectByExample(providerexample);
		String sname=list.get(0).getSname();
		return sname;
	}

	@Override
	public String findregionId(HttpServletRequest request) {
		ProviderExample providerexample=new ProviderExample();
		ProviderExample.Criteria criteria=providerexample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<Provider> list=providerMapper.selectByExample(providerexample);
		String regionId=list.get(0).getRegionId();
		return regionId;
	}

	@Override
	public String findcellphone(HttpServletRequest request) {
		ProviderExample providerexample=new ProviderExample();
		ProviderExample.Criteria criteria=providerexample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<Provider> list=providerMapper.selectByExample(providerexample);
		String cellphone=list.get(0).getCellphone();
		return cellphone;
	}

	@Override
	public String findweixin(HttpServletRequest request) {
		ProviderExample providerexample=new ProviderExample();
		ProviderExample.Criteria criteria=providerexample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<Provider> list=providerMapper.selectByExample(providerexample);
		String weixin=list.get(0).getWeixin();
		return weixin;
	}

	@Override
	public String findqq(HttpServletRequest request) {
		ProviderExample providerexample=new ProviderExample();
		ProviderExample.Criteria criteria=providerexample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<Provider> list=providerMapper.selectByExample(providerexample);
		String qq=list.get(0).getQq();
		return qq;
	}

	@Override
	public String findemall(HttpServletRequest request) {
		ProviderExample providerexample=new ProviderExample();
		ProviderExample.Criteria criteria=providerexample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<Provider> list=providerMapper.selectByExample(providerexample);
		String emall=list.get(0).getEmall();
		return emall;
	}

	@Override
	public String findproviderInfo(HttpServletRequest request) {
		ProviderExample providerexample=new ProviderExample();
		ProviderExample.Criteria criteria=providerexample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		List<Provider> list=providerMapper.selectByExample(providerexample);
		String providerInfo=list.get(0).getProviderInfo();
		return providerInfo;
	}

	@Override
	public int updateByProvId(Provider prov) {
		// TODO Auto-generated method stub
		return providerMapper.updateByProvId(prov);
	}

	@Override
	public void updataImg(Provider provider)throws Exception {
		providerMapper.saveUserImg(provider);
	}

	@Override
	public Provider selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return providerMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateserinformation(HttpServletRequest request) {
		Provider provider=new Provider();
		provider.setId(request.getParameter("id"));
		provider.setSname(request.getParameter("sname"));
		provider.setRegionId(request.getParameter("regionId"));
		provider.setCellphone(request.getParameter("cellphone"));
		provider.setWeixin(request.getParameter("weixin"));
		provider.setQq(request.getParameter("qq"));
		provider.setEmall(request.getParameter("emall"));
		ProviderExample providerexample=new ProviderExample();
		ProviderExample.Criteria criteria=providerexample.createCriteria();
		System.out.println("000000000"+request.getParameter("id"));
		criteria.andIdEqualTo(request.getParameter("id"));
		int n=providerMapper.updateByExampleSelective(provider, providerexample);
		return n;
	}

//	@Override
//	public void saveUserImg(Provider provider) throws Exception {
//		int i=providerMapper.saveUserImg(provider);
//		if(i!=1) {
//			throw new Exception("上传图片失败");
//		}
//		
//	}

	@Override
	public String getIdByCellPhone(String cellphone) {
		// TODO Auto-generated method stub
		return providerMapper.getIdByCellPhone(cellphone);
	}

	@Override
	public long count() {
		ProviderExample providerexample=new ProviderExample();
		return providerMapper.countByExample(providerexample);
	}

	//运营商    查找服务商
		@Override
		public List<Provider> selectByServicename(int pageStart, Integer pageSize, String serviceName) {
			ProviderExample providerExample=new ProviderExample();
			providerExample.setDistinct(true);
			providerExample.setPageStart(pageStart);    
			providerExample.setPageSize(pageSize);
			return providerMapper.oselectByServicename(providerExample, serviceName);
		}

		@Override
		public long searchServiceNameCount(String serviceName) {
			return providerMapper.searchServiceNameCount(serviceName);
		}
	



//	@Override
//	public String findworkTime(HttpServletRequest request) {
//		ProviderExample providerexample=new ProviderExample();
//		ProviderExample.Criteria criteria=providerexample.createCriteria();
//		criteria.andCellphoneEqualTo(request.getParameter("workTime"));
//		List<Provider> list=providerMapper.selectByExample(providerexample);
//		String workTime=list.get(0).getWorkTime();
//		return workTime;
//	}

	
    

    

}
