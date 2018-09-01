package com.ai.aso.common.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.common.bo.PageBo;
import com.ai.aso.common.bo.SysUserPageBo;
import com.ai.aso.common.bo.SysUserInfoBo;
import com.ai.aso.common.component.ManagerComp;
import com.ai.aso.common.db.dao.UserMapper;
import com.ai.aso.common.db.model.User;
import com.ai.aso.common.db.model.UserExample;
import com.ai.aso.common.db.model.UserExample.Criteria;
import com.ai.aso.common.db.page.Page;
import com.ai.aso.common.db.page.PageHelper;
import com.ai.aso.common.exception.BizValidException;

@Component
public class ManagerCompImpl implements ManagerComp {
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 查询管理员分页数据
	 * @param user 查询条件
	 * @param pageBo 分页信息
	 * @returnTODOSysUserPageBo
	 * 1.判断是否需要分页，如果需要分页则启动分页插件
	 * 2.根据条件来查询管理员用户信息
	 * 3.将查询到的列表转换为前台所需数据模型
	 * 4.判断是否需要分页信息
	 */
	@Override
	public SysUserPageBo findSysUserList(User user, PageBo pageBo) {
		SysUserPageBo SysUserPageBo = new SysUserPageBo();
		if(null != pageBo){
			PageHelper.startPage(pageBo.getPageNo(), pageBo.getPageSize());
		}
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if(!"".equals(user.getUserName()) && user.getUserName() != null)
		{
			criteria.andUserNameEqualTo(user.getUserName());
		}
		if(!"".equals(user.getRegionId()) && user.getRegionId() != null)
		{
			criteria.andRegionIdEqualTo(user.getRegionId());
		}
		if(!"".equals(user.getState()) && user.getState() != null)
		{
			criteria.andStateEqualTo(user.getState());
		}
		
		List<User> userList = userMapper.selectByExample(example);
		List<SysUserInfoBo> sysUserInfoBoList = SysUserInfoBo.getBoList(userList);
		SysUserPageBo.setDataList(sysUserInfoBoList);
		if(null != pageBo){
			Long count = ((Page<User>)userList).getTotal();
			SysUserPageBo.setDataCount(count);
		}
		return SysUserPageBo;
	}

	/* 进行用户新增的持久化操作，该操作所使用的参数数据正确性应由调用者进行保证
	 * 即调用者应确保提供正确的数据
	 * 1.进行系统管理用户表插入
	 */
	@Override
	public Integer createSysUser(SysUserInfoBo userInfo) {
		Integer returnValue = userMapper.insertSelective(userInfo.getUser());
		return returnValue;
	}

	
	/* 进行用户修改操作，可用于用户信息修改、用户禁用等操作
	 * 1.获取用户的原信息,并判断要修改的用户是否存在
	 */
	@Override
	public String modifySysUser(User user) {
		User origUser = userMapper.selectByPrimaryKey(user.getUserId());
		if(null == origUser){
			BizValidException bizValidException = new BizValidException();
			throw bizValidException;
		}
		return String.valueOf(userMapper.updateByPrimaryKeySelective(user));
	}

}
