package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.bo.ResourcesBo;

public interface ResourcesService {
	
	public ResourcesBo selectByRid(Integer resourcesId);
	
	public ResourcesBo findResourcesByUrl(String url);

	public List<ResourcesBo> findAllBySysCode(String sysCode);

	public List<ResourcesBo> findResourcesByAcctId(String acctId);
}
