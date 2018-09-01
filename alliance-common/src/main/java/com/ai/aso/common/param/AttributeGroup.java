package com.ai.aso.common.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttributeGroup implements Serializable {

	private static final long serialVersionUID = 5276374966287549131L;
	
	private static final Logger log = LoggerFactory.getLogger(AttributeGroup.class);

	/**
	 * 属性组定义
	 */
	private Map<String, Attribute> attrGroup = new LinkedHashMap<>();
	/**
	 * 属性组定义
	 */
	private List<Attribute> attrList = new ArrayList<Attribute>();
	

	public void addAttr(String attrCode, String attrName) {
		Attribute attr = new Attribute();
		attr.setAttrCode(attrCode);
		attr.setAttrName(attrName);
		this.attrGroup.put(attrCode, attr);
		this.attrList.add(attr);
	}

	public String getName(String attrCode) {
		Attribute attr = this.attrGroup.get(attrCode);
		
		if (attr == null) {
			log.debug("未找到静态属性中code:" + attrCode);
			return "";
		} else {
			return attr.getAttrName();
		}
	}

	public Attribute getAttr(String attrCode) {
		return this.attrGroup.get(attrCode);
	}
	
	public List<Attribute> getAttrList(){
		return this.attrList;
	}

	public Set<String> keySet() {
		return this.attrGroup.keySet();
	}

	public boolean isEmpty() {
		return this.attrGroup.isEmpty();
	}

	public boolean containsKey(String key) {
		return this.attrGroup.containsKey(key);
	}

	public void clear() {
		this.attrGroup.clear();
	}

	public int size() {
		return this.attrGroup.size();
	}

}
