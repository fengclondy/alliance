package com.ai.aso.security.model;

import java.io.Serializable;

public class AccessStrategy implements Serializable {

	private static final long serialVersionUID = -3914960933549861260L;

	/**
	 * 访问URL
	 */
	private String url;

	/**
	 * 其它过滤器配置
	 */
	private String authc;

	/**
	 * 角色校验配置
	 */
	private String role;

	/**
	 * 权限校验配置
	 */
	private String permission;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthc() {
		return authc;
	}

	public void setAuthc(String authc) {
		this.authc = authc;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
