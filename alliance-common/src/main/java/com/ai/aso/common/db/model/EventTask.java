package com.ai.aso.common.db.model;

import java.util.Date;

public class EventTask {
    private Long taskId;

    private String taskGroup;

    private String taskName;

    private Integer eventType;

    private String objectId;

    private String eventParams;

    private String remarks;

    private String callObject;

    private String callMethod;

    private String callParams;

    private String reCode;

    private String reMesg;

    private Integer redoMax;

    private Integer redoCount;

    private Integer redoInterval;

    private Date callTime;

    private Date createTime;

    private Integer state;

    private Integer ver;

    private String ext1;

    private String ext2;

    private String ext3;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup == null ? null : taskGroup.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    public String getEventParams() {
        return eventParams;
    }

    public void setEventParams(String eventParams) {
        this.eventParams = eventParams == null ? null : eventParams.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getCallObject() {
        return callObject;
    }

    public void setCallObject(String callObject) {
        this.callObject = callObject == null ? null : callObject.trim();
    }

    public String getCallMethod() {
        return callMethod;
    }

    public void setCallMethod(String callMethod) {
        this.callMethod = callMethod == null ? null : callMethod.trim();
    }

    public String getCallParams() {
        return callParams;
    }

    public void setCallParams(String callParams) {
        this.callParams = callParams == null ? null : callParams.trim();
    }

    public String getReCode() {
        return reCode;
    }

    public void setReCode(String reCode) {
        this.reCode = reCode == null ? null : reCode.trim();
    }

    public String getReMesg() {
        return reMesg;
    }

    public void setReMesg(String reMesg) {
        this.reMesg = reMesg == null ? null : reMesg.trim();
    }

    public Integer getRedoMax() {
        return redoMax;
    }

    public void setRedoMax(Integer redoMax) {
        this.redoMax = redoMax;
    }

    public Integer getRedoCount() {
        return redoCount;
    }

    public void setRedoCount(Integer redoCount) {
        this.redoCount = redoCount;
    }

    public Integer getRedoInterval() {
        return redoInterval;
    }

    public void setRedoInterval(Integer redoInterval) {
        this.redoInterval = redoInterval;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }
}