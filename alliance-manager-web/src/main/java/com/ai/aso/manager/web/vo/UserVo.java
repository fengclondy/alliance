package com.ai.aso.manager.web.vo;

import com.ai.aso.common.db.model.User;

import java.io.Serializable;

public class UserVo implements Serializable {

	private static final long serialVersionUID = 7963471744500380249L;

	private String userId;

	private String acctId;

	private String userName;

	private String mobile;

	private String email;

	private String phone;

	private String regionId;

	private String regionName;

	private Short state;

	private String stateName;

	private String username;

	private String systemCode;

	private String roleId;

	private String roleName;

	public User toUser() {
		User user = new User();
		user.setAcctId(acctId);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPhone(phone);
		user.setRegionId(regionId);
		user.setState(state);
		user.setUserId(userId);
		user.setUserName(userName);
		return user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
