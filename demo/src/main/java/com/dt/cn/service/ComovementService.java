package com.dt.cn.service;

import java.util.List;
import com.dt.cn.model.sysUser.Comovement;

//4.业务层接口
public interface ComovementService {

	List<Comovement> findPorvince();
	List<Comovement> findCity(String pr_name);
	List<Comovement> findCounty(String ci_name);
}
