package com.ai.aso.common.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.base.constants.SysConstants;
import com.ai.aso.common.log.UnityLogService;
import com.ai.aso.common.log.model.UserLoginLog;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.service.UserLogService;
import com.ai.aso.common.sequence.SequenceFactory;

@Service
public class UserLogServiceImpl implements UserLogService {
	
	@Autowired
	private SequenceFactory sequenceFactory;
	@Autowired
	private UnityLogService unityLogService;

	@Override
	public void loginManagerSuccess(String acctId, String loginName, String nickname, String ip) {
		//登录成功记录日志
		UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setId(Long.parseLong(sequenceFactory.next(BizConstants.SEQ_KEY_LOGINLOG)));
        userLoginLog.setAcctId(acctId);
        userLoginLog.setLoginDate(new Date());
        userLoginLog.setLoginIp(null==ip ? "null" :ip);
        userLoginLog.setOperation("login");
        userLoginLog.setSystemCode(GlobalParamSet.getString(SysConstants.SUB_SYS_MAN_CODE));
        userLoginLog.setRemarks("成功");
        userLoginLog.setUsername(loginName);
        userLoginLog.setNickname(nickname);
        
        unityLogService.longinLogInsertSelective(userLoginLog);
	}

}
