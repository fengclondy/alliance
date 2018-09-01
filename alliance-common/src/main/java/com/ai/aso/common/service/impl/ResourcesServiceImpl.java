package com.ai.aso.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.bo.ResourcesBo;
import com.ai.aso.common.component.ResourcesComp;
import com.ai.aso.common.service.ResourcesService;

@Service
public class ResourcesServiceImpl implements ResourcesService {

	@Autowired
	private ResourcesComp resourcesComp;
	
	@Override
	public ResourcesBo selectByRid(Integer resourcesId) {
		return resourcesComp.findResourcesById(resourcesId);
	}
	
	@Override
	public ResourcesBo findResourcesByUrl(String url) {
		return resourcesComp.findResourcesByUrl(url);
	}

	@Override
	public List<ResourcesBo> findAllBySysCode(String sysCode) {
		return resourcesComp.findAllBySysCode(sysCode);
	}

	@Override
	public List<ResourcesBo> findResourcesByAcctId(String acctId) {
		return resourcesComp.findResourcesByAcctId(acctId);
	}

}
