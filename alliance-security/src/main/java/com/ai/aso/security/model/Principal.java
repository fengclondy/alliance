package com.ai.aso.security.model;

import java.io.Serializable;
import java.util.List;

public class Principal implements Serializable {

	private static final long serialVersionUID = -2806741648855337855L;

	// 登录ID
	private String accId;

	// 用户名称
	private String userName;

	// 用户登录使用的用户名
	private String loginName;

	// 用户昵称
	private String nickName;

	// 用户密码
	private String password;

	// 用户加密盐
	private String hashSalt;
	//登录者IP
	private String ip;
	// 主机IP
	private List<String> hostIp;

	// 用户状态：0 关闭；1 在用；2 锁定
	private Short state;

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashSalt() {
		return hashSalt;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setHashSalt(String hashSalt) {
		this.hashSalt = hashSalt;
	}

	public List<String> getHostIp() {
		return hostIp;
	}

	public void setHostIp(List<String> hostIp) {
		this.hostIp = hostIp;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}
}
