package com.ai.aso.manager.security;

import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.base.utils.WebUtil;
import com.ai.aso.common.service.RegionService;
import com.ai.aso.common.service.UserLogService;
import com.ai.aso.common.service.UserService;
import com.ai.aso.manager.web.quick.dao.QuickUserMapper;
import com.ai.aso.manager.web.viewService.MenuViewService;
import com.ai.aso.manager.web.vo.MenuVo;
import com.ai.aso.manager.web.vo.UserVo;
import com.ai.aso.security.model.Principal;
import com.ai.aso.security.shiro.AbstractAuthenticationFilter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ManagerAuthenticationFilter extends AbstractAuthenticationFilter {
	
	Logger LOG = LoggerFactory.getLogger(ManagerAuthenticationFilter.class);
	
	@Autowired
	private MenuViewService menuService;
	@Autowired
	private QuickUserMapper quickUserMapper;
	@Autowired
	private RegionService regionService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserLogService userLogService;

	@Override
	protected void doLoginSuccess(ServletRequest request) {
		// 处理登录用户扩展信息
		LOG.debug("处理登录成功时的一些必要工作！");
		
		Subject subject = SecurityUtils.getSubject();
		Principal principal = (Principal) subject.getPrincipals().getPrimaryPrincipal();
		String ip=WebUtil.getIpAddr((HttpServletRequest)request);
		//记录登录日志
		userLogService.loginManagerSuccess(principal.getAccId(), principal.getLoginName(), principal.getNickName(), ip);
		
		//导航栏菜单
		List<MenuVo> rs = menuService.findShownMenuByAcctId(principal.getAccId());
		subject.getSession().setAttribute("menus", rs);
		
		//首页
		MenuVo indexMenu = null;//find first-class menu
        for (MenuVo vo : rs) { if (vo.getPmenuId().intValue() == 0) { indexMenu = vo;break; } }
        
        if (null != indexMenu && StringUtil.isNotEmpty(indexMenu.getMenuUrl())) {
    		subject.getSession().setAttribute("index", indexMenu.getMenuUrl());
    	} else {
    		//find second-class menu
    		for (MenuVo childMenu : rs) {
    			if (childMenu.getPmenuId().intValue() == indexMenu.getMenuId().intValue()) {
    				subject.getSession().setAttribute("index", childMenu.getMenuUrl());break;
    			}
    		}
    	}

		//追加系统管理者登录后的信息
        //用户，角色，地区信息
		UserVo user = quickUserMapper.selectUserByAcctId(principal.getAccId());
		subject.getSession().setAttribute("user", user);
//		
//		acctRole
//		subject.getSession().setAttribute("userRole", bo.getLoginAcctInfo().getRoleList().get(0));
//		
//		User user = userService.findUserByAcctId(principal.getAccId());
//		Region region = regionService.findRegionByRegionId(Integer.parseInt(user.getRegionId()));
//		
//		subject.getSession().setAttribute("region", region);
		

	}
}
