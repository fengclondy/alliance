package com.ai.aso.common.bo;

public class MenuBo {

	/**
	 * 菜单ID
	 */
	private int menuId;

	/**
	 * 菜单上级ID
	 */
	private int pmenuId;

	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 菜单图标
	 */
	private String menuIcon;

	/**
	 * 菜单Url
	 */
	private String menuUrl;

	/**
	 * 显示顺序
	 */
	private int showSeq;
	
    private String systemCode;
    
    private String accessPerm;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getPmenuId() {
		return pmenuId;
	}

	public void setPmenuId(int pmenuId) {
		this.pmenuId = pmenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public int getShowSeq() {
		return showSeq;
	}

	public void setShowSeq(int showSeq) {
		this.showSeq = showSeq;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getAccessPerm() {
		return accessPerm;
	}

	public void setAccessPerm(String accessPerm) {
		this.accessPerm = accessPerm;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

}
