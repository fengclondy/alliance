package com.ai.aso.manager.web.viewService;

import com.ai.aso.manager.web.vo.MenuVo;

import java.util.List;


public interface MenuViewService {
	
	/**
	 * 根据用户id获取可展示的菜单列表
	 * @param acctId
	 * @return
	 */
	public List<MenuVo> findShownMenuByAcctId(String acctId);

	/**
	 * 获取所有的菜单列表资源
	 * @return
	 */
	public List<MenuVo> findAllMenu();

}
