package com.ai.aso.common.component;

import java.util.List;

import com.ai.aso.common.bo.MenuBo;

public interface MenuComp {

	/**
	 * 获取某子系统的菜单资源
	 * 
	 * @param sysCode
	 * @return
	 */
	public List<MenuBo> findAllMenuBySysCode(String sysCode);

	public List<MenuBo> findShownMenuByAcctId(String acctId);

}
