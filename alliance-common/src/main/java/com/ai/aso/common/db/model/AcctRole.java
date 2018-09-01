package com.ai.aso.common.db.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity(name="B_ACCT_ROLE")
public class AcctRole {
    @Id
    private String acctId;

    private Integer roleId;

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