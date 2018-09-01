package com.ai.aso.manager.security;

import com.ai.aso.base.constants.SysConstants;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.bo.ResourcesBo;
import com.ai.aso.common.db.dao.LoginAcctMapper;
import com.ai.aso.common.db.dao.LoginNameMapper;
import com.ai.aso.common.db.model.LoginAcct;
import com.ai.aso.common.db.model.LoginName;
import com.ai.aso.common.db.model.LoginNameExample;
import com.ai.aso.common.db.model.User;
import com.ai.aso.common.service.ResourcesService;
import com.ai.aso.common.service.UserService;
import com.ai.aso.security.model.Principal;
import com.ai.aso.security.shiro.AbstractRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManagerRealm extends AbstractRealm {

	Logger LOG = LoggerFactory.getLogger(ManagerRealm.class);

	@Autowired
	private LoginAcctMapper loginAcctMapper;
	@Autowired
	private LoginNameMapper loginNameMapper;
	@Autowired
	private UserService userService;

	private ResourcesService resourcesService;

	@Override
	protected Set<String> findRoles(String userId) {
//		return securityPermService.findRoles(userId);
		//未启用策略，暂时留空
		return new HashSet<String>();
	}

	@Override
	protected Set<String> findPermissions(String userId) {
		Set<String> perm = new HashSet<>();
		List<ResourcesBo> boList = resourcesService.findResourcesByAcctId(userId);
		for (ResourcesBo bo : boList) {
			if (null != bo && StringUtil.isNotEmpty(bo.getAccessPerm())) {
				perm.add(bo.getAccessPerm());
			}
		}
		return perm;
	}

	@Override
	protected Principal findUser(String username) {
		Principal user = null;
		
		LoginNameExample lne = new LoginNameExample();
		lne.createCriteria().andLoginNameEqualTo(username).andSystemCodeEqualTo(GlobalParamSet.getString(SysConstants.SUB_SYS_MAN_CODE));
		List<LoginName> nameList = loginNameMapper.selectByExample(lne);
		
		if(null != nameList && nameList.size() > 0) {
			LoginAcct acct = loginAcctMapper.selectByPrimaryKey(nameList.get(0).getAcctId());
			if(null != acct) {
				User temp = userService.findUserByAcctId(acct.getAcctId());
				user = new Principal();
				user.setAccId(acct.getAcctId());
				user.setUserName(acct.getUsername());
				user.setPassword(acct.getPassword());
				user.setHashSalt(acct.getPwSalt());
				user.setState(acct.getState());
				user.setLoginName(username);
				user.setNickName(temp.getUserName());
			}
		}

		return user;
	}

	public void setResourcesService(ResourcesService resourcesService) {
		this.resourcesService = resourcesService;
	}

	public ResourcesService getResourcesService() {
		return resourcesService;
	}
	
}
