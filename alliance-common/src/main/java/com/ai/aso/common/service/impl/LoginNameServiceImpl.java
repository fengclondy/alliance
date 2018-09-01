package com.ai.aso.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.base.constants.SysConstants;
import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.db.dao.LoginNameMapper;
import com.ai.aso.common.db.model.LoginName;
import com.ai.aso.common.db.model.LoginNameExample;
import com.ai.aso.common.exception.BizExInfoEnum;
import com.ai.aso.common.service.LoginNameService;

@Service
public class LoginNameServiceImpl implements LoginNameService {
	
	@Autowired
	private LoginNameMapper loginNameMapper;

	@Override
	public String findAcctIdFromMan(String loginName) {
		LoginNameExample lne = new LoginNameExample();
		lne.createCriteria().andLoginNameEqualTo(loginName).andSystemCodeEqualTo(GlobalParamSet.getString(SysConstants.SUB_SYS_MAN_CODE));
		List<LoginName> nameList = loginNameMapper.selectByExample(lne);
		if (null != nameList && nameList.size() > 0) {
			return nameList.get(0).getAcctId();
		} else {
			throw new BusinessException(BizExInfoEnum.LOGINACCT_NOT_FOUND);
		}
	}

	@Override
	public String findAcctIdFromPor(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

}
