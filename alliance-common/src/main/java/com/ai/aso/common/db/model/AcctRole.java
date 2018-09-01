package com.ai.aso.common.db.model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="B_ACCT_ROLE")
public class AcctRole {

    private String acctId;

    private Integer roleId;
    @Id
    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}