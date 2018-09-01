package com.ai.aso.common.component.impl;

import java.util.ArrayList;
import java.util.List;

import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.exception.BizValidException;
import com.ai.aso.common.sequence.SequenceFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.bo.LoginAcctInfo;
import com.ai.aso.common.bo.PermissionBo;
import com.ai.aso.common.component.LoginAcctComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.AcctRoleMapper;
import com.ai.aso.common.db.dao.BlacklistMapper;
import com.ai.aso.common.db.dao.LoginAcctMapper;
import com.ai.aso.common.db.dao.LoginNameMapper;
import com.ai.aso.common.db.dao.ResourcesMapper;
import com.ai.aso.common.db.dao.RoleMapper;
import com.ai.aso.common.db.dao.RolePrivilegeMapper;
import com.ai.aso.common.db.dao.ext.AcctRoleExtMapper;
import com.ai.aso.common.db.dao.ext.LoginNameExtMapper;
import com.ai.aso.common.db.model.AcctRole;
import com.ai.aso.common.db.model.AcctRoleExample;
import com.ai.aso.common.db.model.Blacklist;
import com.ai.aso.common.db.model.BlacklistExample;
import com.ai.aso.common.db.model.LoginAcct;
import com.ai.aso.common.db.model.LoginAcctExample;
import com.ai.aso.common.db.model.LoginIp;
import com.ai.aso.common.db.model.LoginName;
import com.ai.aso.common.db.model.LoginNameExample;
import com.ai.aso.common.db.model.Resources;
import com.ai.aso.common.db.model.ResourcesExample;
import com.ai.aso.common.db.model.Role;
import com.ai.aso.common.db.model.RoleExample;
import com.ai.aso.common.db.model.RolePrivilege;
import com.ai.aso.common.db.model.RolePrivilegeExample;
import com.ai.aso.common.exception.BizValidException;
import com.ai.aso.security.model.HashPassword;
import com.ai.aso.security.utils.HashPasswordHelper;

@Component
public class LoginAcctCompImpl implements LoginAcctComp {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(LoginAcctCompImpl.class);
	
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private LoginAcctMapper loginAcctMapper;
	@Autowired
	private LoginNameMapper loginNameMapper;
	@Autowired
	private LoginNameExtMapper loginNameExtMapper;
	@Autowired
	private AcctRoleMapper acctRoleMapper;
	@Autowired
	private AcctRoleExtMapper acctRoleExtMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private BlacklistMapper blacklistMapper;
	@Autowired
	private ResourcesMapper resourcesMapper;
	@Autowired
	private RolePrivilegeMapper rolePrivilegeMapper;
	
	/* 进行用户新增的持久化操作，该操作所使用的参数数据正确性应由调用者进行保证
	 * 即调用者应确保提供正确的数据
	 * 1.查看账号是否在排除列表中
	 * 2.校验登录名是否已经存在
	 * 3.生成登录账号的acct_id
	 * 4.加密密码，进行登录账号名列表的设置、登录IP列表的设置、角色列表的设置
	 * 5.进行登录账号表插入
	 * 6.从参数中获取到进行账号登录名称表插入操作所需的数据类型，并进行插入操作
	 * 7.从参数中获取到角色列表信息并执行插入操作
	 */
	@Override
	public String addUserAcct(LoginAcctInfo loginAcctInfo) {
		
		if(inExcludeList(loginAcctInfo.getLoginAcct().getUsername())){
			BizValidException commonValidException = new BizValidException();
			throw commonValidException;
		}
		acctExist(loginAcctInfo.getLoginAcct());
		String acctSequence = null;
		try{
			acctSequence = sequenceFactory.next(BizConstants.SEQUENCENAME_ACCT);
		}catch(Exception e){
			BizValidException commonValidException = new BizValidException();
			throw commonValidException;
		}
		loginAcctInfo.getLoginAcct().setAcctId(acctSequence);
		
		encryptPassword(loginAcctInfo.getLoginAcct());
		loginNameListExist(loginAcctInfo);
		loginIpExist(loginAcctInfo);
		List<AcctRole> acctRoleList = getAcctRoleList(loginAcctInfo);
		
		loginAcctMapper.insertSelective(loginAcctInfo.getLoginAcct());
		loginNameExtMapper.insertBatch(loginAcctInfo.getLoginNameList());
		acctRoleExtMapper.insertBatch(acctRoleList);
		return acctSequence;
	}
	
	/**对请求中的密码进行加密
	 *
	 * @param loginAcct
	 */
	private void encryptPassword(LoginAcct loginAcct){
		log.debug("重置密码的明文密码为：" + loginAcct.getPassword());
		
		HashPasswordHelper passwordHelper = new HashPasswordHelper();
		HashPassword newPassword = new HashPassword();
		newPassword.setPlaintext(loginAcct.getPassword());
		newPassword.setPrivateSalt(HashPasswordHelper.generatePrivateSalt());
		newPassword.setPublicSalt(loginAcct.getAcctId());
		newPassword = (HashPassword)passwordHelper.encryptPassword(newPassword);
		loginAcct.setPassword(newPassword.getCiphertext());
		loginAcct.setPwSalt(newPassword.getPrivateSalt());
	}
	
	/**
	 * 判断登录名是否在排除列表中
	 * @param userName 登录名
	 * @returnTODOboolean
	 */
	public boolean inExcludeList(String userName){
		List<String> excludeList = findLoginNameExcludeList();
		if(null != excludeList && excludeList.size() > 0){
			for(String item : excludeList){
				if(item.equals(userName)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 校验登录名是否已经存在
	 * @param loginAcct
	 * @returnTODOboolean
	 */
	public boolean acctExist(LoginAcct loginAcct){
		// 去数据库中查找登录账号是否存在
		List<LoginName> loginNameList = findLoginName(loginAcct.getUsername());
		if (null != loginNameList && loginNameList.size() > 0) {
			BizValidException commonValidException = new BizValidException();
			throw commonValidException;
		}
		return false;
	}
	
	/**
	 * 判断要插入的账号信息是否包含登录名列表
	 * 包含则设置下每条登录名信息的账号ID
	 * 不包含则利用登录账号名创建一条登录名信息
	 * @param loginAcctInfo
	 * @returnTODOboolean
	 */
	public boolean loginNameListExist(LoginAcctInfo loginAcctInfo){
		if (null != loginAcctInfo.getLoginNameList()) {
			for (LoginName item : loginAcctInfo.getLoginNameList()) {
				item.setAcctId(loginAcctInfo.getLoginAcct().getAcctId());
			}
		} else {
			List<LoginName> loginNameList = new ArrayList<LoginName>();
			LoginName loginName = new LoginName();
			loginName.setAcctId(loginAcctInfo.getLoginAcct().getAcctId());
			loginName.setLoginName(loginAcctInfo.getLoginAcct().getUsername());
			loginNameList.add(loginName);
			loginName.setSystemCode(loginAcctInfo.getLoginAcct().getSystemCode());
			loginAcctInfo.setLoginNameList(loginNameList);
		}
		return true;
	}
	
	/**
	 * 判断要插入的账号信息是否包含登录限制IP列表
	 * @param loginAcctInfo
	 * @returnTODOboolean
	 */
	public boolean loginIpExist(LoginAcctInfo loginAcctInfo){
		if (null != loginAcctInfo.getLoginIpList()) {
			for (LoginIp item : loginAcctInfo.getLoginIpList()) {
				item.setAcctId(loginAcctInfo.getLoginAcct().getAcctId());
			}
		}
		return true;
	}
	
	/**判断要插入的账号信息是否包含角色列表
	 * 如果含有角色列表，则利用角色列表生成账号角色关系列表
	 * 如果没有则生成默认角色
	 * @param loginAcctInfo
	 * @returnTODOList<AcctRole>
	 */
	public List<AcctRole> getAcctRoleList(LoginAcctInfo loginAcctInfo){
		List<AcctRole> acctRoleList = new ArrayList<AcctRole>();
		if (null != loginAcctInfo.getRoleList()) {
			for (Role item : loginAcctInfo.getRoleList()) {
				AcctRole acctRole = new AcctRole();
				acctRole.setAcctId(loginAcctInfo.getLoginAcct().getAcctId());
				acctRole.setRoleId(item.getRoleId());
				acctRoleList.add(acctRole);
			}
		} else {
			AcctRole defaultRole = new AcctRole();
			defaultRole.setAcctId(loginAcctInfo.getLoginAcct().getAcctId());
			defaultRole.setRoleId(GlobalParamSet.getInteger(BizConstants.CITY_ROLE_ID));
			acctRoleList.add(defaultRole);
		}
		return acctRoleList;
	}

	
	/* 修改登录账号信息
	 * 
	 */
	@Override
	public Integer modifyLoginAcct(LoginAcct loginAcct) {
		return loginAcctMapper.updateByPrimaryKeySelective(loginAcct);
	}

	
	/** 
	 * 获取账号登录账号信息
	 * 1.获取账号主要信息
	 * 2.判断是否需要扩展信息
	 * 3。需要扩展信息则查询扩展信息，并组装进返回类型中
	 */
	@Override
	public LoginAcctInfo findLoginAcctInfo(LoginAcct loginAcct, boolean needExtInfo) {
		
		LoginAcctInfo loginAcctInfo = new LoginAcctInfo();
		LoginAcctExample LoginAcctExample = new LoginAcctExample();
		LoginAcctExample.Criteria criteria = LoginAcctExample.createCriteria();
		if(!StringUtil.isEmpty(loginAcct.getAcctId())){
			criteria.andAcctIdEqualTo(loginAcct.getAcctId());
		}
		if(!StringUtil.isEmpty(loginAcct.getUsername())){
			criteria.andUsernameEqualTo(loginAcct.getUsername());
		}
		if(null != loginAcct.getState()){
			criteria.andStateEqualTo(loginAcct.getState());
		}else{
			criteria.andStateEqualTo(Short.valueOf("1"));
		}
		List<LoginAcct> loginAcctList = loginAcctMapper.selectByExample(LoginAcctExample);
		if(null != loginAcctList && loginAcctList.size() > 0){
			loginAcctInfo.setLoginAcct(loginAcctList.get(0));
		}
		if(needExtInfo){
			//如果需要扩展信息则执行其他查询
		}
		return loginAcctInfo;
	}

	/** 
	 * 根据账号ID获取对应的未授予的角色列表
	 * @param acctId 账号ID
	 * 1.根据账号ID获取账号角色关系列表
	 * 2.查询角色表，获取角色ID不在角色关系列表中的角色
	 */
	@Override
	public List<Role> findUnGrantRole(String acctId) {
		AcctRoleExample example = new AcctRoleExample();
		example.createCriteria().andAcctIdEqualTo(acctId);
		List<AcctRole> acctRoleList = acctRoleMapper.selectByExample(example);
		
		if(null != acctRoleList && acctRoleList.size() > 0){
			List<Integer> roleIdList = new ArrayList<Integer>();
			for(AcctRole item : acctRoleList){
				roleIdList.add(item.getRoleId());
			}
			RoleExample roleExample = new RoleExample();
			roleExample.createCriteria().andRoleIdNotIn(roleIdList);
			
			return roleMapper.selectByExample(roleExample);
		}
		return null;
	}

	/** 
	 * 根据账号ID获取对应的未授予的角色列表
	 * @param acctId 账号ID
	 * 1.根据账号ID获取账号角色关系列表
	 * 2.查询角色表，获取角色ID在角色关系列表中的角色
	 */
	@Override
	public List<Role> findGrantedRole(String acctId) {
		AcctRoleExample example = new AcctRoleExample();
		example.createCriteria().andAcctIdEqualTo(acctId);
		List<AcctRole> acctRoleList = acctRoleMapper.selectByExample(example);
		
		if(null != acctRoleList && acctRoleList.size() > 0){
			List<Integer> roleIdList = new ArrayList<Integer>();
			for(AcctRole item : acctRoleList){
				roleIdList.add(item.getRoleId());
			}
			RoleExample roleExample = new RoleExample();
			roleExample.createCriteria().andRoleIdIn(roleIdList);
			
			return roleMapper.selectByExample(roleExample);
		}
		return null;
	}

	/**
	 * 为账号进行角色授权
	 * @param acctId 账号ID
	 * @param roleIdList 角色ID列表
	 * 1.删除角色关系表中与账号ID关联的所有角色信息
	 * 2.利用账号ID和角色ID列表生成账号角色关系映射列表
	 * 3.执行账号角色关系表的批量插入
	 */
	@Override
	public Integer grantRole(String acctId, List<Integer> roleIdList) {
		acctRoleMapper.deleteByPrimaryKey(acctId, null);
		Integer returnValue = 0;
		List<AcctRole> acctRoleList = new ArrayList<AcctRole>();
		if (null != roleIdList && roleIdList.size() > 0) {
			for (Integer item : roleIdList) {
				AcctRole acctRole = new AcctRole();
				acctRole.setAcctId(acctId);
				acctRole.setRoleId(item);
				acctRoleList.add(acctRole);
			}
			returnValue = acctRoleExtMapper.insertBatch(acctRoleList);
		}
		return returnValue;
	}

	/** 
	 * 根据账号的登录名来获取对应的账号所具有的全部登录名列表
	 * @param username 登录名
	 */
	@Override
	public List<LoginName> findLoginName(String username) {
		LoginNameExample example = new LoginNameExample();
		example.createCriteria().andLoginNameEqualTo(username);
		return loginNameMapper.selectByExample(example);
	}

	/** 
	 * 修改密码，密码均已经被加密
	 * @param acctId 账号ID
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * 1.根据登录账号判断账号是否存在，如果不存在抛出异常交给统一异常处理
	 * 2.进行账号信息的更新
	 */
	@Override
	public Integer modifyPassWord(String acctId, String oldPwd, String newPwd) {
		LoginAcct loginAcct = new LoginAcct();
		loginAcct.setAcctId(acctId);
		loginAcct.setPassword(oldPwd);
		encryptPassword(loginAcct);
		LoginAcct oriLoginAcct = loginAcctMapper.selectByPrimaryKey(acctId);
		if(null != oriLoginAcct){
			if(!oriLoginAcct.getPassword().equals(loginAcct.getPassword())){
				BizValidException commonValidException = new BizValidException();
				throw commonValidException;
			}
			loginAcct.setPassword(newPwd);
			encryptPassword(loginAcct);
			return loginAcctMapper.updateByPrimaryKeySelective(loginAcct);
		}
		return null;
	}

	/** 
	 * 重置密码
	 * @param acctId 账号ID
	 * @param resetPwd 重置密码
	 */
	@Override
	public Integer resetPassWord(String acctId, String resetPwd) {
		LoginAcct loginAcct = new LoginAcct();
		loginAcct.setAcctId(acctId);
		LoginAcct oriLoginAcct = loginAcctMapper.selectByPrimaryKey(acctId);
		if(null != oriLoginAcct){
			if("".equals(resetPwd) || null == resetPwd)
			{
				oriLoginAcct.setPassword(GlobalParamSet.getString("PASSWORD.DEFAULT"));
			}else{
				oriLoginAcct.setPassword(resetPwd);
			}
			encryptPassword(oriLoginAcct);
			loginAcct.setPassword(oriLoginAcct.getPassword());
			loginAcct.setPwSalt(oriLoginAcct.getPwSalt());
			return loginAcctMapper.updateByPrimaryKeySelective(loginAcct);
		}
		return null;
	}

	@Override
	public List<LoginName> findLoginNameById(String acctId) {
		LoginNameExample example = new LoginNameExample();
		example.createCriteria().andAcctIdEqualTo(acctId);
		return loginNameMapper.selectByExample(example);
	}

	/** 
	 * 获取不可作为登录账号名使用的列表
	 * 1.调用dao方法从数据库中获取记录
	 * 2.对获取到的记录进行切割，并组装成列表
	 */
	@Override
	public List<String> findLoginNameExcludeList() {
		BlacklistExample example = new BlacklistExample();
		BlacklistExample.Criteria criteria = example.createCriteria();
		criteria.andBlacklistKeyEqualTo(GlobalParamSet.getString("ACCT_BALCKLIST"));
		List<Blacklist> blackLists = blacklistMapper.selectByExample(example);
		if(null != blackLists && blackLists.size() > 0){
			String itemListStr = blackLists.get(0).getBlacklistValue();
			if(!StringUtil.isEmpty(itemListStr)){
				//进行切割
				String[] itemArray = itemListStr.trim().split(",");
				List<String> itemList = new ArrayList<String>();
				for(String item : itemArray){
					if(StringUtil.isEmpty(item)){
						itemList.add(item);
					}
				}
				return itemList;
			}
		}
		return null;
	}

	/** 
	 * 根据账号ID禁用账号
	 * 1.拼装数据库操作条件
	 * 2.设置账号状态为锁定
	 */
	@Override
	public int disableLoginAcct(String acctId) {
		LoginAcct loginAcct = new LoginAcct();
		loginAcct.setAcctId(acctId);
		loginAcct.setState(GlobalParamSet.getShort(BizConstants.ACCT_STATE_LOCKED));
		return loginAcctMapper.updateByPrimaryKeySelective(loginAcct);
	}

	/**
	 * 进行用户新增的持久化操作，该操作所使用的参数数据正确性应由调用者进行保证
	 * 即调用者应确保提供正确的数据
	 * 1.查看账号是否在排除列表中
	 * 2.校验登录名是否已经存在
	 * 3.进行登录账号名列表的设置、登录IP列表的设置、角色列表的设置
	 * 4.进行登录账号表插入
	 * 5.从参数中获取到进行账号登录名称表插入操作所需的数据类型，并进行插入操作
	 * 6.从参数中获取到角色列表信息并执行插入操作
	 */
	@Override
	public String addDefaultUserAcct(LoginAcctInfo loginAcctInfo) {
		
		if(inExcludeList(loginAcctInfo.getLoginAcct().getUsername())){
			BizValidException commonValidException = new BizValidException();
			throw commonValidException;
		}
		acctExist(loginAcctInfo.getLoginAcct());
		
		loginNameListExist(loginAcctInfo);
		loginIpExist(loginAcctInfo);
		List<AcctRole> acctRoleList = getAcctRoleList(loginAcctInfo);
		
		loginAcctMapper.insertSelective(loginAcctInfo.getLoginAcct());
		loginNameExtMapper.insertBatch(loginAcctInfo.getLoginNameList());
		acctRoleExtMapper.insertBatch(acctRoleList);
		return "";
	}

	/**
	 * 根据登录名获取登录账号信息
	 * @param userName 登录名
	 * @param needExtInfo 是否获取扩展信息
	 * @returnTODOLoginAcctInfo
	 */
	@Override
	public LoginAcctInfo findLoginAcctInfo(String userName, boolean needExtInfo) {
		LoginAcct loginAcct = new LoginAcct();
		loginAcct.setUsername(userName);
		loginAcct.setState(Short.valueOf("1"));
		return findLoginAcctInfo(loginAcct, needExtInfo);
	}

	/**
	 * 获取账号所具有的权限
	 * @param acctId
	 * @return PermissionBo
	 * 1.根据账号ID获取已经具有的角色列表
	 * 2.根据角色ID列表获取资源列表
	 */
	@Override
	public PermissionBo findPermissionBo(String acctId) {
		PermissionBo permissionBo = new PermissionBo();
		List<Role> roleList = findGrantedRole(acctId);
		permissionBo.setRoleList(roleList);
		if(null != roleList && roleList.size() > 0){
			List<Integer> roleIdList = new ArrayList<Integer>();
			for(Role role : roleList){
				roleIdList.add(role.getRoleId());
			}
			RolePrivilegeExample rolePrivilegeExample = new RolePrivilegeExample();
			rolePrivilegeExample.setDistinct(true);
			rolePrivilegeExample.createCriteria().andRoleIdIn(roleIdList);
			List<RolePrivilege> rolePrivilegeList = rolePrivilegeMapper.selectByExample(rolePrivilegeExample);
			if(null != rolePrivilegeList && rolePrivilegeList.size() > 0){
				List<Integer> sourceIdList = new ArrayList<Integer>();
				for(RolePrivilege rolePrivilege : rolePrivilegeList){
					sourceIdList.add(rolePrivilege.getSourceId());
				}
				ResourcesExample resourcesExample = new ResourcesExample();
				resourcesExample.createCriteria().andSourceIdIn(sourceIdList);
				List<Resources> resourcesList = resourcesMapper.selectByExample(resourcesExample);
				permissionBo.setResourcesList(resourcesList);
			}
		}
		return permissionBo;
	}
}
