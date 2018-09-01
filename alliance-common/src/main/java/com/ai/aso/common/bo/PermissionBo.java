package com.ai.aso.common.bo;

import java.util.List;

import com.ai.aso.common.db.model.Resources;
import com.ai.aso.common.db.model.Role;

public class PermissionBo {
	
	private List<Role> roleList;
	
	private List<Resources> resourcesList;

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Resources> getResourcesList() {
		return resourcesList;
	}

	public void setResourcesList(List<Resources> resourcesList) {
		this.resourcesList = resourcesList;
	}
	
}
