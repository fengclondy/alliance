package com.ai.aso.common.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.bo.RegionBo;
import com.ai.aso.common.component.RegionComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.RegionMapper;
import com.ai.aso.common.db.model.Region;
import com.ai.aso.common.db.model.RegionExample;

@Component
public class RegionCompImpl implements RegionComp {
	
	@Autowired
	private RegionMapper regionMapper;

	@Override
	public List<RegionBo> findAll() {
		RegionExample example = new RegionExample();
		example.createCriteria().andStateEqualTo(GlobalParamSet.getShort(BizConstants.SYS_GLOBAL_STATE_ENABLE));
		example.setOrderByClause("seq_id");
		List<Region> regionList = regionMapper.selectByExample(example);
		
		List<RegionBo> boList = RegionBo.fromRegion(regionList);
		
		return boList;
	}

}
