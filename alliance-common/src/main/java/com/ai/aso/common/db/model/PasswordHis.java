package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity(name = "B_PASSWORD_HIS")
public class PasswordHis {
    private Long id;

    private String acctId;

    private String password;

    private String pwSalt;

    private Date effDate;

    private Date expDate;

    private String remarks;
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPwSalt() {
        return pwSalt;
    }

    public void setPwSalt(String pwSalt) {
        this.pwSalt = pwSalt == null ? null : pwSalt.trim();
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}