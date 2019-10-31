package com.dt.cn.service.lmpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.cn.dao.mapper.SysUserMapper;
import com.dt.cn.model.sysUser.SysUser;
import com.dt.cn.model.sysUser.SysUserExample;
import com.dt.cn.service.SysUserService;

@Service  //声明服务层
public class SysUserServicelmpl implements SysUserService {
	@Resource //对象初始化  一般在业务层访问dao
	SysUserMapper sysUserMapper;

	public List<SysUser> getSystemUserById(Integer id) {
		System.out.println("查询用户" + id);
		//实例化，对象初始化 int i=0;
		SysUserExample sysUserExample = new SysUserExample();
		//内部了实例化，初始化
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andIdEqualTo(id);
		return null;
	}

	@Override
	public int insert(SysUser record) {
		return sysUserMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		List<SysUser> userList = getSystemUserById(id);
		int i = 0;
		if (userList.size() != 0) {

			i = sysUserMapper.deleteByPrimaryKey(id);
		}
		return i;
	}

	@Override
	public SysUser selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(SysUser record) {
		// TODO Auto-generated method stub
		return sysUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public SysUser selectSysUser(Map<String,String> map) {
		// TODO Auto-generated method stub
		return sysUserMapper.selectSysUser(map);
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<SysUser> selectByExample(int pageStart,
			int pageSize,String username) {
		//对象初始化
		SysUserExample sysUserExample=new SysUserExample();
		//去掉重复记录
		sysUserExample.setDistinct(true);
		//设置起始位置
		sysUserExample.setPageStart(pageStart);
		//设置页面大小
		sysUserExample.setPageSize(pageSize);
		// TODO Auto-generated method stub
		return sysUserMapper.selectByExample(sysUserExample,username);
	}

	/**
	 * 获取总记录数
	 */
	@Override
	public long getCount() {
		//countByExample()的参数是SysUserExample类型，必须初始化yigeSysUserExample的对象
		SysUserExample sysUserExample=new SysUserExample();
		// TODO Auto-generated method stub
		return sysUserMapper.countByExample(sysUserExample);
	}

	@Override
	public int getCount(String username) {
		// TODO Auto-generated method stub
		return sysUserMapper.getCount(username);
	}
	//8.把先参数传到SysUserExample，在到映射器
	@Override
	public List<SysUser> seletByName(int pageStart, int pageSize, String username) {
		SysUserExample sysUserExample=new SysUserExample();
		sysUserExample.setPageStart(pageStart);
		sysUserExample.setPageSize(pageSize);
		sysUserExample.setUsername(username);
		return sysUserMapper.selectByName(sysUserExample);
	}

	@Override
	public int updateImg(SysUser sysUser) {
		// TODO Auto-generated method stub
		return sysUserMapper.updateByPrimaryKey(sysUser);
	}

}
