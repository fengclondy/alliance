package com.ai.aso.common.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.common.bo.RolePrivilegeBo;
import com.ai.aso.common.component.RolePrivilegeComp;
import com.ai.aso.common.db.dao.RolePrivilegeMapper;
import com.ai.aso.common.db.model.RolePrivilege;
import com.ai.aso.common.db.model.RolePrivilegeExample;

@Component
public class RolePrivilegeCompImpl implements RolePrivilegeComp {

	@Autowired
	private RolePrivilegeMapper rolePrivilegeMapper;

	@Override
	public List<RolePrivilegeBo> finRolePrivilegeByRid(Integer roleId) {
		RolePrivilegeExample example = new RolePrivilegeExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<RolePrivilege> rpList = rolePrivilegeMapper.selectByExample(example);
		
		return RolePrivilegeBo.fromRolePrivilege(rpList);
	}
	
}
