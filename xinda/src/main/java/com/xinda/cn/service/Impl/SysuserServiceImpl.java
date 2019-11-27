package com.xinda.cn.service.Impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import com.xinda.cn.dao.mapper.SysuserMapper;
import com.xinda.cn.model.xinda.Sysuser;
import com.xinda.cn.model.xinda.SysuserExample;
import com.xinda.cn.service.SysuserService;
import com.xinda.cn.util.MD5Util;

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

	@Override
	public int findPassword(HttpServletRequest request, Sysuser sysuser, String cellphone) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		 MD5Util md5 = new MD5Util();
			if(request.getParameter("password").equals("")==false){
				sysuser.setPassword(md5.EncoderByMd5(request.getParameter("password1")));
			}
			SysuserExample sysuserExample=new SysuserExample();
			return sysuserMapper.findPasswordByCellphone(sysuser, sysuserExample,cellphone);
	}

}
