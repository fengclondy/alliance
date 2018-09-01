package com.ai.aso.common.bo;

import java.util.List;

import com.ai.aso.common.db.model.AcctRole;
import com.ai.aso.common.db.model.LoginAcct;
import com.ai.aso.common.db.model.LoginIp;
import com.ai.aso.common.db.model.LoginName;
import com.ai.aso.common.db.model.Role;

public class LoginAcctInfo {
	
	private LoginAcct loginAcct;
	
	private List<LoginName> loginNameList;
    
    private List<LoginIp> loginIpList;
    
    private List<Role> roleList;
    
    public LoginAcctInfo(){
    	loginAcct = new LoginAcct();
    }

	public LoginAcct getLoginAcct() {
		return loginAcct;
	}

	public void setLoginAcct(LoginAcct loginAcct) {
		this.loginAcct = loginAcct;
	}

	public List<LoginName> getLoginNameList() {
		return loginNameList;
	}

	public void setLoginNameList(List<LoginName> loginNameList) {
		this.loginNameList = loginNameList;
	}

	public List<LoginIp> getLoginIpList() {
		return loginIpList;
	}

	public void setLoginIpList(List<LoginIp> loginIpList) {
		this.loginIpList = loginIpList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
