package com.ai.aso.common.component;

import java.util.List;

import com.ai.aso.common.bo.RolePrivilegeBo;

public interface RolePrivilegeComp {
	
	public List<RolePrivilegeBo> finRolePrivilegeByRid(Integer roleId);

}
