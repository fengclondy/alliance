package com.ai.aso.common.component.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.bo.ResourcesBo;
import com.ai.aso.common.bo.RolePrivilegeBo;
import com.ai.aso.common.component.AcctRoleComp;
import com.ai.aso.common.component.ResourcesComp;
import com.ai.aso.common.component.RolePrivilegeComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.ResourcesMapper;
import com.ai.aso.common.db.model.AcctRole;
import com.ai.aso.common.db.model.Resources;
import com.ai.aso.common.db.model.ResourcesExample;
import com.ai.aso.common.db.model.ResourcesExample.Criteria;

@Component
public class ResourcesCompImpl implements ResourcesComp {
	
	private static final Logger log = LoggerFactory.getLogger(ResourcesCompImpl.class);

	@Autowired
	private ResourcesMapper resourcesMapper;
	@Autowired
	private AcctRoleComp acctRoleComponent;
	@Autowired
	private RolePrivilegeComp rolePrivilegeComp;
	
	@Override
	public ResourcesBo findResourcesById(Integer resourcesId) {
		// TODO Auto-generated method stub
		Resources res = resourcesMapper.selectByPrimaryKey(resourcesId);
		
		ResourcesBo bo = new ResourcesBo();
		bo.fromResources(res);
		return bo;
	}

	@Override
	public ResourcesBo findResourcesByUrl(String url) {
		ResourcesExample example = new ResourcesExample();
		example.createCriteria().andSourUrlEqualTo(url).andStateEqualTo(GlobalParamSet.getShort(BizConstants.SYS_GLOBAL_STATE_ENABLE));
		
		List<Resources> list = resourcesMapper.selectByExample(example);
		
		if (null != list && list.size() > 0) {
			ResourcesBo bo = new ResourcesBo();
			bo.fromResources(list.get(0));
			return bo;
		}
		return null;
	}

	@Override
	public List<ResourcesBo> findResourcesByAcctId(String acctId) {
		List<ResourcesBo> boList = new ArrayList<ResourcesBo>();
		
		//根据登录用户ID获取用户角色列表
		List<AcctRole> arList = acctRoleComponent.selectByUid(acctId);
		if (null != arList) {
			for (AcctRole ar : arList) {
				if (null != ar && null != ar.getRoleId()) {
					Integer roleId = ar.getRoleId();
					//根据角色ID获取角色资源信息
					List<RolePrivilegeBo> rpList = rolePrivilegeComp.finRolePrivilegeByRid(roleId);
					
					if (null != rpList) {
						//转换资源信息
						List<Integer> vals = new ArrayList<Integer>();
						for (RolePrivilegeBo rp : rpList) {
							if (null != rp && null != rp.getSourceId()) {
								vals.add(rp.getSourceId());
//								Resources res = resourcesMapper.selectByPrimaryKey(rp.getSourceId());
//								ResourcesBo bo = new ResourcesBo();
//								bo.fromResources(res);
//								boList.add(bo);
							}
						}
						
						if (vals.size() > 0) {
							ResourcesExample example = new ResourcesExample();
							example.createCriteria().andSourceIdIn(vals);
							List<Resources> resourcesList = resourcesMapper.selectByExample(example);
							boList.addAll(ResourcesBo.fromResources(resourcesList));
						}
					}
				}
			}
		}
		
		return boList;
	}

	/**
	 * 获取某子系统资源列表
	 */
	@Override
	public List<ResourcesBo> findAllBySysCode(String sysCode) {
		ResourcesExample reEx = new ResourcesExample();
		Criteria ca = reEx.createCriteria();
		// 如果没有传入子系统编码，则忽略子系统编码条件
		if (sysCode == null || "".equals(sysCode)) {
			log.warn("没有传入子系统编码，查询所有资源!");
		} else {
			ca.andSystemCodeEqualTo(sysCode);
		}
		// 仅查询状态正常的Url资源
		ca.andStateEqualTo(GlobalParamSet.getShort(BizConstants.SYS_GLOBAL_STATE_ENABLE));
		// 查询数据库
		List<Resources> resources = resourcesMapper.selectByExample(reEx);
		if (log.isDebugEnabled()) {
			if (resources == null || resources.isEmpty()) {
				log.debug("resources is null");
			}
		}

		// 处理生成BO对象列表
		return ResourcesBo.fromResources(resources);
	}

	@Override
	public List<ResourcesBo> findResourcesByAcctIdAndSourType(String acctId, int sourType) {
		List<ResourcesBo> boList = new ArrayList<ResourcesBo>();
		
		//根据登录用户ID获取用户角色列表
		List<AcctRole> arList = acctRoleComponent.selectByUid(acctId);
		if (null != arList) {
			for (AcctRole ar : arList) {
				if (null != ar && null != ar.getRoleId()) {
					Integer roleId = ar.getRoleId();
					//根据角色ID获取角色资源信息
					List<RolePrivilegeBo> rpBoList = rolePrivilegeComp.finRolePrivilegeByRid(roleId);
					
					if (null != rpBoList) {
						//转换资源信息
						List<Integer> vals = new ArrayList<Integer>();
						for (RolePrivilegeBo rp : rpBoList) {
							if (null != rp && null != rp.getSourceId()) {
								vals.add(rp.getSourceId());
//								ResourcesExample example = new ResourcesExample();
//								example.createCriteria()
//								.andSourTypeEqualTo(sourType)
//								.andSourceIdEqualTo(rp.getSourceId());
//
//								List<Resources> resList = resourcesMapper.selectByExample(example);
//								if (null != resList && resList.size() > 0) {
//									ResourcesBo bo = new ResourcesBo();
//									bo.fromResources(resList.get(0));
//									boList.add(bo);
//								}
							}
						}
						
						if (vals.size() > 0) {
							ResourcesExample example = new ResourcesExample();
							example.createCriteria().andSourTypeEqualTo(sourType).andSourceIdIn(vals);
							List<Resources> resList = resourcesMapper.selectByExample(example);
							boList.addAll(ResourcesBo.fromResources(resList));
						}
					}
				}
			}
		}
		
		return boList;
	}

}
