package com.ai.aso.common.bo;

import java.util.ArrayList;
import java.util.List;

import com.ai.aso.common.db.model.RolePrivilege;

public class RolePrivilegeBo {

    private Integer roleId;

    private Integer sourceId;
    
    public void fromRolePrivilege(RolePrivilege rp){
    	this.roleId = rp.getRoleId();
    	this.sourceId = rp.getSourceId();
    }
    
    public static List<RolePrivilegeBo> fromRolePrivilege(List<RolePrivilege> rpList){
    	List<RolePrivilegeBo> boList = null;
    	if (null != rpList) {
    		boList = new ArrayList<RolePrivilegeBo>();
    		
    		for (RolePrivilege rp : rpList) {
    			RolePrivilegeBo bo = new RolePrivilegeBo();
    			bo.fromRolePrivilege(rp);
    			boList.add(bo);
    		}
    	}
    	
    	return boList;
    }
    
    public RolePrivilege toRolePrivilege(){
    	RolePrivilege rp = new RolePrivilege();
    	rp.setRoleId(roleId);
    	rp.setSourceId(sourceId);
    	return rp;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }
	
}
