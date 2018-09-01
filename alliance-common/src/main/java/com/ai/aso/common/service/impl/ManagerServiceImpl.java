/**
 * 用户信息管理，主要负责用户扩展信息的维护
 * */

package com.ai.aso.common.service.impl;

import com.ai.aso.common.db.dao.UserMapper;
import com.ai.aso.common.db.model.Role;
import com.ai.aso.common.db.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.bo.LoginAcctInfo;
import com.ai.aso.common.bo.SysUserInfoBo;
import com.ai.aso.common.component.LoginAcctComp;
import com.ai.aso.common.component.ManagerComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.model.User;
import com.ai.aso.common.exception.BizValidException;
import com.ai.aso.common.service.ManagerService;
import com.ai.aso.common.sequence.SequenceFactory;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerComp sysUserComponent;
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private LoginAcctComp loginAcctComp;
	@Autowired
	private UserMapper userMapper;
	
	/** 提供新增管理员用户的业务逻辑
	 * 1.从SysUserInfo中获取账户信息模型
	 * 2.执行账户新增逻辑，并获取账户ID
	 * 2.生成用户信息的user_id
	 * 3.调用component进行新增管理员操作
	 */
	@Override
	public String ceateManager(SysUserInfoBo userInfo) {
		//获取登录账户信息模型
		LoginAcctInfo loginAcctInfo = userInfo.getLoginAcctInfo();
		//调用账户新增逻辑进行账户新增
		String acctSequence = loginAcctComp.addUserAcct(loginAcctInfo);
		userInfo.getUser().setAcctId(acctSequence);
		String userSequence = sequenceFactory.next(BizConstants.SEQUENCENAME_USER);
		if(!StringUtil.isEmpty(userSequence)){
			userInfo.getUser().setUserId(userSequence);
		}else{
			BizValidException bizValidException = new BizValidException();
			throw bizValidException;
		}
		sysUserComponent.createSysUser(userInfo);
		return userSequence;
	}

	/* 更新用户信息
	 * 
	 * 1.判断是否进行了用户状态修改
	 * 2.如果进行了用户状态修改，则要考虑如何更新账户信息
	 * 3.进行用户信息修改
	 */
	@Override
	public String modifyManager(SysUserInfoBo userInfo) {
		//如果用户状态发生了变化，则需要修改账号状态
		if(!userInfo.getUser().getState().equals(userInfo.getUser().getState())){
			LoginAcctInfo loginAcctInfo = userInfo.getLoginAcctInfo();
			if(null == loginAcctInfo){
				loginAcctInfo = new LoginAcctInfo();
				userInfo.setLoginAcctInfo(loginAcctInfo);
			}
			loginAcctInfo.getLoginAcct().setAcctId(userInfo.getUser().getAcctId());
			loginAcctInfo.getLoginAcct().setState(userInfo.getUser().getState());
			loginAcctComp.modifyLoginAcct(loginAcctInfo.getLoginAcct());
		}
		return sysUserComponent.modifySysUser(userInfo.getUser());
	}

	@Override
	public SysUserInfoBo findManagerByAccId(String accId) {
		UserExample example = new UserExample();
		example.createCriteria().andAcctIdEqualTo(accId);
		List<User> users = userMapper.selectByExample(example);

		SysUserInfoBo bo = SysUserInfoBo.getBoList(users).get(0);
		
		List<Role> roleList = loginAcctComp.findGrantedRole(accId);
		bo.setLoginAcctInfo(new LoginAcctInfo());
		bo.getLoginAcctInfo().setRoleList(roleList);
		
		return bo;
	}

}
