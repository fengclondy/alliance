package com.ai.aso.common.bo;

import java.util.ArrayList;
import java.util.List;

import com.ai.aso.common.db.model.User;

public class SysUserInfoBo{

	private User user;
	
	private LoginAcctInfo loginAcctInfo;
	
	private String stateStr;
	
	private String regionStr;

	public static List<SysUserInfoBo> getBoList(List<User> userList){
		List<SysUserInfoBo> boList = new ArrayList<SysUserInfoBo>();
		if(null != userList){
			for(User item : userList){
				SysUserInfoBo sysUserInfoBo = new SysUserInfoBo();
				sysUserInfoBo.setUser(item);
				boList.add(sysUserInfoBo);
			}
			if(boList.size() > 0){
				return boList;
			}
		}
		return null;
	}
	
	public User getUser() {
		return user;
	}

	public String getStateStr() {
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}

	public String getRegionStr() {
		return regionStr;
	}

	public void setRegionStr(String regionStr) {
		this.regionStr = regionStr;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoginAcctInfo getLoginAcctInfo() {
		return loginAcctInfo;
	}

	public void setLoginAcctInfo(LoginAcctInfo loginAcctInfo) {
		this.loginAcctInfo = loginAcctInfo;
	}    
}
