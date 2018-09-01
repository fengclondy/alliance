package com.ai.aso.manager.web.vo;

import com.ai.aso.base.constants.SysConstants;
import com.ai.aso.common.param.AttributeSet;
import com.ai.aso.common.bo.MenuBo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1685624958948218719L;

	private Integer menuId;

    private Integer pmenuId;

    private String menuName;
    
    private String menuIcon;

    private String menuUrl;
    
    private Integer showSeq;
    
    private String systemCode;
    
    private String systemCodeName;
    
    private String accessPerm;
    
    public void fromMenuBo(MenuBo bo) {
		this.menuId = bo.getMenuId();
		this.pmenuId = bo.getPmenuId();
		this.menuName = bo.getMenuName();
		this.menuIcon = bo.getMenuIcon();
		this.menuUrl = bo.getMenuUrl();
		this.showSeq = bo.getShowSeq();
		this.systemCode = bo.getSystemCode();
		this.accessPerm = bo.getAccessPerm();
		this.systemCodeName = AttributeSet.getAttrGroup(SysConstants.SUB_SYS_CODE).getName(bo.getSystemCode());
	}
	
	public static List<MenuVo> fromMenuBo(List<MenuBo> boList) {
		List<MenuVo> voList = null;
		if (null != boList) {
			voList = new ArrayList<MenuVo>();
			for (MenuBo bo : boList) {
				MenuVo vo = new MenuVo();
				vo.fromMenuBo(bo);
				voList.add(vo);
			}
		}
		
		return voList;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getPmenuId() {
		return pmenuId;
	}

	public void setPmenuId(Integer pmenuId) {
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

	public Integer getShowSeq() {
		return showSeq;
	}

	public void setShowSeq(Integer showSeq) {
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

	public String getSystemCodeName() {
		return systemCodeName;
	}

	public void setSystemCodeName(String systemCodeName) {
		this.systemCodeName = systemCodeName;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	

}
