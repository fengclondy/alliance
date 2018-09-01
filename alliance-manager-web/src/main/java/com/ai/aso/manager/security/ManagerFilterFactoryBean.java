package com.ai.aso.manager.security;

import com.ai.aso.base.constants.SysConstants;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.bo.ResourcesBo;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.service.ResourcesService;
import com.ai.aso.security.model.AccessStrategy;
import com.ai.aso.security.shiro.AbstractShiroFilterFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ManagerFilterFactoryBean extends AbstractShiroFilterFactoryBean {

	Logger LOG = LoggerFactory.getLogger(ManagerFilterFactoryBean.class);

	private ResourcesService resourcesService;

	/**
	 * 获取url鉴权信息
	 */
	@Override
	protected List<AccessStrategy> findAllAccessStrategy() {
		List<ResourcesBo> urlReList = resourcesService.findAllBySysCode(GlobalParamSet.getString(SysConstants.SUB_SYS_MAN_CODE));
		List<AccessStrategy> acStayList = new ArrayList<AccessStrategy>();
		for (ResourcesBo urlRe : urlReList) {
			AccessStrategy acStay = new AccessStrategy();
			acStay.setUrl(urlRe.getSourUrl());
			if (urlRe.getIsAuthen() == GlobalParamSet.getShort(BizConstants.RESOURCE_NEED_AUTH)) {
				LOG.debug("Url[{" + urlRe.getSourUrl() + "}]设置相关安全策略");
				acStay.setAuthc(urlRe.getAccessAuthc());
				acStay.setRole(urlRe.getAccessRole());
				acStay.setPermission(urlRe.getAccessPerm());
			} else {
				LOG.debug("Url[{" + urlRe.getSourUrl() + "}]设置匿名安全策略");
				acStay.setAuthc("none");
			}
			acStayList.add(acStay);
		}
		return acStayList;
	}

	public ResourcesService getResourcesService() {
		return resourcesService;
	}

	public void setResourcesService(ResourcesService resourcesService) {
		this.resourcesService = resourcesService;
	}
	
}
