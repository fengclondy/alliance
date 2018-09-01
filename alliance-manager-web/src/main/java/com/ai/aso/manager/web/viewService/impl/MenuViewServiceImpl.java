package com.ai.aso.manager.web.viewService.impl;

import com.ai.aso.base.constants.SysConstants;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.bo.MenuBo;
import com.ai.aso.common.component.MenuComp;
import com.ai.aso.manager.interceptor.Log;
import com.ai.aso.manager.web.viewService.MenuViewService;
import com.ai.aso.manager.web.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuViewServiceImpl implements MenuViewService {

	@Autowired
	private MenuComp menuComp;

	@Override
	public List<MenuVo> findShownMenuByAcctId(String acctId) {
		
		List<MenuBo> boList = menuComp.findShownMenuByAcctId(acctId);
		return MenuVo.fromMenuBo(boList);
	}

	@Log(moduleName="系统管理模块",option="获取所有菜单")
	@Override
	public List<MenuVo> findAllMenu() {
		List<MenuBo> boList = menuComp.findAllMenuBySysCode(GlobalParamSet.getString(SysConstants.SUB_SYS_MAN_CODE));
		return MenuVo.fromMenuBo(boList);
	}
	
}
