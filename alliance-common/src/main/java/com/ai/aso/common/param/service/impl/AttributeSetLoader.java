package com.ai.aso.common.param.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.param.AttributeGroup;
import com.ai.aso.common.param.AttributeSet;
import com.ai.aso.common.db.dao.AttrDefMapper;
import com.ai.aso.common.db.model.AttrDef;
import com.ai.aso.common.db.model.AttrDefExample;
import com.ai.aso.common.param.service.ParamLoader;

@Service("attributeSetLoader")
public class AttributeSetLoader implements ParamLoader {
	
	@Autowired
	private AttrDefMapper attrDefMapper;

	@Override
	public void init() {
		AttrDefExample exp = new AttrDefExample();
		exp.createCriteria().andStateEqualTo(new Short("1"));
		
		List<AttrDef> attrList = attrDefMapper.selectByExample(exp);
		for (AttrDef attr : attrList) {
			String pkgCode = attr.getAttrPkgCode();
			AttributeGroup group = AttributeSet.getAttrGroup(pkgCode);
			if (null == group) {
				AttributeSet.getInstance().put(pkgCode, new AttributeGroup());
				group = AttributeSet.getAttrGroup(pkgCode);
			}
			group.addAttr(attr.getAttrCode(), attr.getAttrName());
		}
	}

	@Override
	public void reload(String key) {
		AttrDefExample exp = new AttrDefExample();
		exp.createCriteria().andStateEqualTo(new Short("1"));
		
		List<AttrDef> attrList = attrDefMapper.selectByExample(exp);
		
		AttributeSet.getAttrGroup(key).clear();
		for (AttrDef attr : attrList) {
			String pkgCode = attr.getAttrPkgCode();
			AttributeGroup group = AttributeSet.getAttrGroup(pkgCode);
			if (null == group) {
				AttributeSet.getInstance().put(pkgCode, new AttributeGroup());
				group = AttributeSet.getAttrGroup(pkgCode);
			}
			group.addAttr(attr.getAttrCode(), attr.getAttrName());
		}
	}

	@Override
	public void reloadAll() {
		AttrDefExample exp = new AttrDefExample();
		exp.createCriteria().andStateEqualTo(new Short("1"));
		
		List<AttrDef> attrList = attrDefMapper.selectByExample(exp);
		
		AttributeSet.getInstance().clear();
		for (AttrDef attr : attrList) {
			String pkgCode = attr.getAttrPkgCode();
			AttributeGroup group = AttributeSet.getAttrGroup(pkgCode);
			if (null == group) {
				AttributeSet.getInstance().put(pkgCode, new AttributeGroup());
				group = AttributeSet.getAttrGroup(pkgCode);
			}
			group.addAttr(attr.getAttrCode(), attr.getAttrName());
		}
	}

}
