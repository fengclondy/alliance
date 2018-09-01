package com.ai.aso.common.component.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.bo.MenuBo;
import com.ai.aso.common.bo.ResourcesBo;
import com.ai.aso.common.component.MenuComp;
import com.ai.aso.common.component.ResourcesComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.utils.MySortList;

@Component
public class MenuCompImpl implements MenuComp {

	Logger logger = LoggerFactory.getLogger(MenuCompImpl.class);

	@Autowired
	private ResourcesComp resourcesComp;

	@Override
	public List<MenuBo> findAllMenuBySysCode(String sysCode) {
		List<ResourcesBo> resBoList = resourcesComp.findAllBySysCode(sysCode);

		// 处理生成BO对象列表
		List<MenuBo> menuList = null;
		if (null != resBoList) {
			menuList = new ArrayList<MenuBo>();
			for (ResourcesBo bo : resBoList) {
				MenuBo menu = new MenuBo();
				menu.setMenuId(bo.getSourceId());
				menu.setMenuName(bo.getMenuName());
				menu.setMenuIcon(bo.getMenuIcon());
				menu.setMenuUrl(bo.getSourUrl());
				menu.setPmenuId(bo.getParentId());
				menu.setShowSeq(bo.getShowSeq());
				menu.setAccessPerm(bo.getAccessPerm());
				menu.setSystemCode(bo.getSystemCode());
				menuList.add(menu);
			}
		
			MySortList<MenuBo> msList = new MySortList<MenuBo>();
			msList.sortByMethod(menuList, "getShowSeq", false);
		}
		
		return menuList;
	}

	@Override
	public List<MenuBo> findShownMenuByAcctId(String acctId) {
		List<ResourcesBo> boList = resourcesComp.findResourcesByAcctIdAndSourType(acctId, GlobalParamSet.getInteger(BizConstants.RESOURCES_TYPE_MENU));
		List<MenuBo> menuList = null;
		if (null != boList) {
			menuList = new ArrayList<MenuBo>();
			for (ResourcesBo bo : boList) {
				MenuBo menu = new MenuBo();
				menu.setMenuId(bo.getSourceId());
				menu.setMenuName(bo.getMenuName());
				menu.setMenuIcon(bo.getMenuIcon());
				menu.setMenuUrl(bo.getSourUrl());
				menu.setPmenuId(bo.getParentId());
				menu.setShowSeq(bo.getShowSeq());
				menu.setSystemCode(bo.getSystemCode());
				menuList.add(menu);
			}
		
			MySortList<MenuBo> msList = new MySortList<MenuBo>();
			msList.sortByMethod(menuList, "getShowSeq", false);
		}
		
		return menuList;
	}

}
