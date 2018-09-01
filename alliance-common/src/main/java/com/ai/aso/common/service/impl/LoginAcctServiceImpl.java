package com.ai.aso.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.RandomUtil;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.AcctRoleMapper;
import com.ai.aso.common.db.dao.LoginAcctMapper;
import com.ai.aso.common.db.dao.LoginNameMapper;
import com.ai.aso.common.db.model.AcctRole;
import com.ai.aso.common.db.model.AcctRoleExample;
import com.ai.aso.common.db.model.LoginAcct;
import com.ai.aso.common.db.model.LoginAcctExample;
import com.ai.aso.common.db.model.LoginName;
import com.ai.aso.common.db.model.LoginNameExample;
import com.ai.aso.common.exception.BizExInfoEnum;
import com.ai.aso.common.exception.BizValidException;
import com.ai.aso.common.service.LoginAcctService;
import com.ai.aso.common.utils.DateTimeUtil;
import com.ai.aso.security.model.HashPassword;
import com.ai.aso.security.utils.HashPasswordHelper;
import com.ai.aso.common.sequence.SequenceFactory;

@Service
public class LoginAcctServiceImpl implements LoginAcctService {
	
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private LoginAcctMapper loginAcctMapper;
	@Autowired
	private LoginNameMapper loginNameMapper;
	@Autowired
	private AcctRoleMapper acctRoleMapper;

	@Override
	@Transactional
	public String addManagerAcct(String loginName,String roleId) {
		 roleId = String.valueOf(GlobalParamSet.getInteger(BizConstants.CITY_ROLE_ID));
		String systemCode = GlobalParamSet.getString(BizConstants.SUB_SYS_MAN_CODE);
		return addAcct(loginName, Integer.parseInt(roleId), systemCode);
	}

	@Override
	@Transactional
	public String addCustAcct(String loginName) {
		Integer roleId = GlobalParamSet.getInteger(BizConstants.PARTNER_ROLE_ID);
		String systemCode = GlobalParamSet.getString(BizConstants.SUB_SYS_PAR_CODE);
		return addAcct(loginName, roleId, systemCode);
	}
	
	private String addAcct(String loginCode, Integer roleId, String systemCode){
		validLoginNameExist(loginCode, systemCode);
		
		//1. 新增login acct表信息
		LoginAcct loginAcct = new LoginAcct();
		loginAcct.setAcctId(sequenceFactory.next(BizConstants.SEQUENCENAME_ACCT));
		loginAcct.setCreateDate(new Date());
		loginAcct.setExpDate(DateTimeUtil.getDefaultExpDate());
		loginAcct.setEffDate(new Date());
		loginAcct.setModiDate(new Date());
		loginAcct.setPassword(GlobalParamSet.getString(BizConstants.PASSWORD_DEFAULT));
		encryptPassword(loginAcct);
		loginAcct.setPwMdate(DateTimeUtil.addDay(new Date(), 100));
		loginAcct.setState(GlobalParamSet.getShort(BizConstants.ACCT_STATE_ENABLED));
		loginAcct.setSystemCode(systemCode);
		loginAcct.setUsername(loginCode);
		loginAcctMapper.insertSelective(loginAcct);
		
		//2. 新增登陆账号表
		LoginName loginName = new LoginName();
		loginName.setAcctId(loginAcct.getAcctId());
		loginName.setLoginName(loginCode);
		loginName.setSystemCode(systemCode);
		loginNameMapper.insertSelective(loginName);
		
		//3. 新增账号角色表
		AcctRole acctRole = new AcctRole();
		acctRole.setAcctId(loginAcct.getAcctId());
		acctRole.setRoleId(roleId);
		acctRoleMapper.insertSelective(acctRole);
		
		return loginAcct.getAcctId();
	}
	
	private void validLoginNameExist(String loginCode, String systemCode) {
		LoginAcctExample lae = new LoginAcctExample();
		lae.createCriteria().andUsernameEqualTo(loginCode).andSystemCodeEqualTo(systemCode);
		
		List<LoginAcct> list = loginAcctMapper.selectByExample(lae);
		if (null != list && list.size() > 0) {
			throw new BizValidException(BizExInfoEnum.USER_EXISTS_WARN);
		}
	}
	
	/**
	 * 对请求中的密码进行加密
	 */
//	public void encryptPassword(LoginAcct loginAcct){
//		HashPasswordHelper passwordHelper = new HashPasswordHelper();
//		HashPassword newPassword = new HashPassword();
//		newPassword.setPlaintext(loginAcct.getPassword());
//		newPassword.setPrivateSalt(HashPasswordHelper.generatePrivateSalt());
//		newPassword.setPublicSalt(loginAcct.getAcctId());
//		newPassword = (HashPassword)passwordHelper.encryptPassword(newPassword);
//		loginAcct.setPassword(newPassword.getCiphertext());
//		loginAcct.setPwSalt(newPassword.getPrivateSalt());
//	}
	
	/**
	 * 对请求中的密码进行加密
	 */
	public void encryptPassword(LoginAcct loginAcct){
		if (loginAcct.getPwSalt() == null) loginAcct.setPwSalt(HashPasswordHelper.generatePrivateSalt());
		
		HashPasswordHelper passwordHelper = new HashPasswordHelper();
		HashPassword newPassword = new HashPassword();
		newPassword.setPlaintext(loginAcct.getPassword());
		newPassword.setPrivateSalt(loginAcct.getPwSalt());
		newPassword.setPublicSalt(loginAcct.getAcctId());
		newPassword = (HashPassword)passwordHelper.encryptPassword(newPassword);
		loginAcct.setPassword(newPassword.getCiphertext());
	}

	@Override
	public String addCustEnablerAcct(String loginName) {
		Integer roleId = GlobalParamSet.getInteger(BizConstants.ENBALER_ROLE_ID);
		String systemCode = GlobalParamSet.getString(BizConstants.SUB_SYS_ENABLER_CODE);
		return addAcct(loginName, roleId, systemCode);
	}

	@Override
	public String resetPassword(String acctId) {
		//构造随机明文密码（数字+字母）6位
		String password = RandomUtil.createRandom(RandomUtil.MIX_ALL, 12);
		
		LoginAcct loginAcct = new LoginAcct();
		loginAcct.setAcctId(acctId);
		LoginAcct oriLoginAcct = loginAcctMapper.selectByPrimaryKey(acctId);
		if(null != oriLoginAcct){
			oriLoginAcct.setPassword(password);
			encryptPassword(oriLoginAcct);
			loginAcct.setPassword(oriLoginAcct.getPassword());
			loginAcct.setPwSalt(oriLoginAcct.getPwSalt());
			loginAcctMapper.updateByPrimaryKeySelective(loginAcct);
			
			return password;
		} else {
			throw new BizValidException(BizExInfoEnum.LOGINACCT_NOT_FOUND);
		}
	}
	
	@Override
	public String resetDefaultPassword(String acctId) {

		String password = GlobalParamSet.getString("PASSWORD.DEFAULT");
		
		LoginAcct loginAcct = new LoginAcct();
		loginAcct.setAcctId(acctId);
		LoginAcct oriLoginAcct = loginAcctMapper.selectByPrimaryKey(acctId);
		if(null != oriLoginAcct){
			oriLoginAcct.setPassword(password);
			encryptPassword(oriLoginAcct);
			loginAcct.setPassword(oriLoginAcct.getPassword());
			loginAcct.setPwSalt(oriLoginAcct.getPwSalt());
			loginAcctMapper.updateByPrimaryKeySelective(loginAcct);
			
			return password;
		} else {
			throw new BizValidException(BizExInfoEnum.LOGINACCT_NOT_FOUND);
		}
	}

	@Override
	public void removeCustEnablerApply(String acctId) {
		removeAcct(acctId);
	}
	
	private void removeAcct(String acctId) {
		//1. 删除登录名表
		LoginNameExample lne = new LoginNameExample();
		lne.createCriteria().andAcctIdEqualTo(acctId);
		loginNameMapper.deleteByExample(lne);
		//2. 删除账户角色表
		AcctRoleExample are = new AcctRoleExample();
		are.createCriteria().andAcctIdEqualTo(acctId);
		acctRoleMapper.deleteByExample(are);
		//3. 删除账户表
		loginAcctMapper.deleteByPrimaryKey(acctId);
	}

	@Override
	public void resetPassword(String acctId, String pwd) {
		LoginAcct loginAcct = new LoginAcct();
		loginAcct.setAcctId(acctId);
		LoginAcct oriLoginAcct = loginAcctMapper.selectByPrimaryKey(acctId);
		if(null != oriLoginAcct){
			oriLoginAcct.setPassword(pwd);
			encryptPassword(oriLoginAcct);
			loginAcct.setPassword(oriLoginAcct.getPassword());
			loginAcct.setPwSalt(oriLoginAcct.getPwSalt());
			loginAcctMapper.updateByPrimaryKeySelective(loginAcct);
		} else {
			throw new BizValidException(BizExInfoEnum.LOGINACCT_NOT_FOUND);
		}
	}
}
