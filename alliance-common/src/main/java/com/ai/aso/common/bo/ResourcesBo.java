package com.ai.aso.common.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ai.aso.common.db.model.Resources;

public class ResourcesBo {

	private Integer sourceId;

    private Integer parentId;

    private String menuName;
    
    private String menuIcon;

    private String sourName;

    private String sourDesc;

    private Integer sourType;

    private Integer showSeq;

    private String methodName;

    private String sourUrl;

    private String systemCode;

    private String modelCode;

    private Short isAuthen;

    private String accessAuthc;

    private String accessRole;

    private String accessPerm;

    private Integer accessInterval;

    private Short state;

    private Date createDate;

    private Date modiDate;

    private String hostGroups;

    private String ext1;

    private String ext2;
	
	public void fromResources(Resources res) {
		this.accessAuthc = res.getAccessAuthc();
		this.accessInterval = res.getAccessInterval();
		this.accessPerm = res.getAccessPerm();
		this.accessRole = res.getAccessRole();
		this.createDate = res.getCreateDate();
		this.ext1 = res.getExt1();
		this.ext2 = res.getExt2();
		this.hostGroups = res.getHostGroups();
		this.isAuthen = res.getIsAuthen();
		this.menuName = res.getMenuName();
		this.methodName = res.getMethodName();
		this.modelCode = res.getMethodName();
		this.modiDate = res.getModiDate();
		this.parentId = res.getParentId();
		this.showSeq = res.getShowSeq();
		this.sourceId = res.getSourceId();
		this.sourDesc = res.getSourDesc();
		this.sourName = res.getSourName();
		this.sourType = res.getSourType();
		this.sourUrl = res.getSourUrl();
		this.state = res.getState();
		this.systemCode = res.getSystemCode();
		this.menuIcon = res.getMenuIcon();
	}
	
	public Resources toResources(){
		Resources res = new Resources();
		
		res.setAccessAuthc(this.accessAuthc);
		res.setAccessInterval(this.accessInterval);
		res.setAccessPerm(this.accessPerm);
		res.setAccessRole(this.accessRole);
		res.setCreateDate(this.createDate);
		res.setExt1(this.ext1);
		res.setExt2(this.ext2);
		res.setHostGroups(this.hostGroups);
		res.setIsAuthen(this.isAuthen);
		res.setMenuName(this.menuName);
		res.setMethodName(this.methodName);
		res.setMethodName(this.modelCode);
		res.setModiDate(this.modiDate);
		res.setParentId(this.parentId);
		res.setShowSeq(this.showSeq);
		res.setSourceId(this.sourceId);
		res.setSourDesc(this.sourDesc);
		res.setSourName(this.sourName);
		res.setSourType(this.sourType);
		res.setSourUrl(this.sourUrl);
		res.setState(this.state);
		res.setSystemCode(this.systemCode);
		res.setMenuIcon(this.menuIcon);
		return res;
	}
	
	public static List<ResourcesBo> fromResources(List<Resources> resList) {
		List<ResourcesBo> boList = null;
		if(null != resList) {
			boList = new ArrayList<ResourcesBo>();
			for (Resources res : resList) {
				ResourcesBo bo = new ResourcesBo();
				bo.fromResources(res);
				boList.add(bo);
			}
		}
		
		return boList;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getSourName() {
		return sourName;
	}

	public void setSourName(String sourName) {
		this.sourName = sourName;
	}

	public String getSourDesc() {
		return sourDesc;
	}

	public void setSourDesc(String sourDesc) {
		this.sourDesc = sourDesc;
	}

	public Integer getSourType() {
		return sourType;
	}

	public void setSourType(Integer sourType) {
		this.sourType = sourType;
	}

	public Integer getShowSeq() {
		return showSeq;
	}

	public void setShowSeq(Integer showSeq) {
		this.showSeq = showSeq;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getSourUrl() {
		return sourUrl;
	}

	public void setSourUrl(String sourUrl) {
		this.sourUrl = sourUrl;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public Short getIsAuthen() {
		return isAuthen;
	}

	public void setIsAuthen(Short isAuthen) {
		this.isAuthen = isAuthen;
	}

	public String getAccessAuthc() {
		return accessAuthc;
	}

	public void setAccessAuthc(String accessAuthc) {
		this.accessAuthc = accessAuthc;
	}

	public String getAccessRole() {
		return accessRole;
	}

	public void setAccessRole(String accessRole) {
		this.accessRole = accessRole;
	}

	public String getAccessPerm() {
		return accessPerm;
	}

	public void setAccessPerm(String accessPerm) {
		this.accessPerm = accessPerm;
	}

	public Integer getAccessInterval() {
		return accessInterval;
	}

	public void setAccessInterval(Integer accessInterval) {
		this.accessInterval = accessInterval;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModiDate() {
		return modiDate;
	}

	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}

	public String getHostGroups() {
		return hostGroups;
	}

	public void setHostGroups(String hostGroups) {
		this.hostGroups = hostGroups;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	
}
