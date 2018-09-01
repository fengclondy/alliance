package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity(name = "B_DATA_BOOKA_STUB")
public class DataBookaStub {
    private Long id;

    private String bookId;

    private String recNo;

    private Integer backType;

    private Long amount;

    private Date backDate;
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public String getRecNo() {
        return recNo;
    }

    public void setRecNo(String recNo) {
        this.recNo = recNo == null ? null : recNo.trim();
    }

    public Integer getBackType() {
        return backType;
    }

    public void setBackType(Integer backType) {
        this.backType = backType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }
}