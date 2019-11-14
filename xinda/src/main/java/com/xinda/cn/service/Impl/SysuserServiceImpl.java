package com.xinda.cn.service.Impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xinda.cn.dao.mapper.SysuserMapper;
import com.xinda.cn.model.xinda.Sysuser;
import com.xinda.cn.model.xinda.SysuserExample;
import com.xinda.cn.service.SysuserService;

@Service
public class SysuserServiceImpl implements SysuserService {
	@Resource
	SysuserMapper sysuserMapper;
	
    /**
     * 登录
     */
	@Override
	public List<Sysuser> login(String cellphone) {
		SysuserExample sysuserExample=new SysuserExample();
		SysuserExample.Criteria criteria=sysuserExample.createCriteria();
		criteria.andCellphoneEqualTo(cellphone);
		return sysuserMapper.selectByExample(sysuserExample);
	}
    
	/**
	 * 找回密码
	 */
	@Override
	public int findpassword(Sysuser sysuser) {
		SysuserExample sysuserExample=new SysuserExample();
		return sysuserMapper.updateByExample(sysuser, sysuserExample);
	}
    
	/**
	 * 注册
	 */
	@Override
	public int insert(Sysuser record) {
		return sysuserMapper.insert(record);
	}

}
