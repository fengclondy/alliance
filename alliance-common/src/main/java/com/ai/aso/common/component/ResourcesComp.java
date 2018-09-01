package com.ai.aso.common.component;

import java.util.List;

import com.ai.aso.common.bo.ResourcesBo;

public interface ResourcesComp {
	
	/**
	 * 根据source id获取source信息
	 * @param resourcesId
	 * @return
	 */
	public ResourcesBo findResourcesById(Integer resourcesId);
	
	/**
	 * 根据url获取source信息
	 * @param url
	 * @return
	 */
	public ResourcesBo findResourcesByUrl(String url);

	/**
	 * 根据管理者id获取source信息列表
	 * @param acctId
	 * @return
	 */
	public List<ResourcesBo> findResourcesByAcctId(String acctId);
	
	/**
	 * 
	 * @param sysCode
	 * @return
	 */
	public List<ResourcesBo> findAllBySysCode(String sysCode);

	/**
	 * 根据用户id获取可展示source信息列表
	 * @param acctId
	 * @param sourType
	 * @return
	 */
	public List<ResourcesBo> findResourcesByAcctIdAndSourType(String acctId, int sourType);
}
