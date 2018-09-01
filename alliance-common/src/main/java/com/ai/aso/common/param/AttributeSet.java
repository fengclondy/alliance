package com.ai.aso.common.param;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttributeSet implements Serializable {

	private static AttributeSet singletonAttrSet = null;

	private static final long serialVersionUID = 4314426059974617663L;
	
	private static final Logger log = LoggerFactory.getLogger(AttributeSet.class);

	/**
	 * 属性集
	 */
	private Map<String, AttributeGroup> attrSet;

	private AttributeSet() {
		this.attrSet = new HashMap<String, AttributeGroup>();
	}

	/**
	 * 获取单例方法
	 * 
	 * @return
	 */
	public static AttributeSet getInstance() {
		if (singletonAttrSet == null) {
			singletonAttrSet = new AttributeSet();
		}
		return singletonAttrSet;
	}

	public static AttributeGroup getAttrGroup(String groupKey) {
		AttributeGroup ag = AttributeSet.getInstance().get(groupKey);
		return ag;
	}

	public AttributeGroup put(String groupKey, AttributeGroup groupValue) {
		return this.attrSet.put(groupKey, groupValue);
	}

	public AttributeGroup get(String groupKey) {
		return this.attrSet.get(groupKey);
	}

	public AttributeGroup remove(String groupKey) {
		return this.attrSet.remove(groupKey);
	}

	public boolean containsKey(String groupKey) {
		return this.attrSet.containsKey(groupKey);
	}

	public boolean isEmpty() {
		return this.attrSet.isEmpty();
	}

	public void clear() {
		this.attrSet.clear();
	}

	public static void main(String[] args) {
		AttributeSet.getAttrGroup("");
	}

}
