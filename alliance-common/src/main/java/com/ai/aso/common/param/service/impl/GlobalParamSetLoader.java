package com.ai.aso.common.param.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.db.dao.GlobalParamMapper;
import com.ai.aso.common.db.model.GlobalParam;
import com.ai.aso.common.db.model.GlobalParamExample;
import com.ai.aso.common.param.service.ParamLoader;

@Service("globalParamSetLoader")
public class GlobalParamSetLoader implements ParamLoader {

	@Autowired
	private GlobalParamMapper globalParamMapper;
	
	@Override
	public void init() {
		List<GlobalParam> gpList = globalParamMapper.selectByExample(new GlobalParamExample());
		for(GlobalParam gp : gpList) {
			GlobalParamSet.getInstance().put(gp.getParamKey(), gp.getParamVal());
		}
		GlobalParam record = new GlobalParam();
		record.setIsReload(IS_LOADED);
		
		GlobalParamExample example = new GlobalParamExample();
		example.clear();
		
		globalParamMapper.updateByExampleSelective(record, example);
	}

	@Override
	public void reload(String key) {
		GlobalParam gp = globalParamMapper.selectByPrimaryKey(key);
		GlobalParamSet.getInstance().put(key, gp.getParamVal());
		
		GlobalParam gp2 = new GlobalParam();
		gp2.setIsReload(IS_LOADED);
		gp2.setParamKey(gp.getParamKey());
		globalParamMapper.updateByPrimaryKeySelective(gp2);
	}

	@Override
	public void reloadAll() {
		List<GlobalParam> gpList = globalParamMapper.selectByExample(new GlobalParamExample());
		GlobalParamSet.getInstance().clear();
		for(GlobalParam gp : gpList) {
			GlobalParamSet.getInstance().put(gp.getParamKey(), gp.getParamVal());
		}
		GlobalParam gp = new GlobalParam();
		gp.setIsReload(IS_LOADED);
		globalParamMapper.updateByExampleSelective(gp, new GlobalParamExample());
	}

}
