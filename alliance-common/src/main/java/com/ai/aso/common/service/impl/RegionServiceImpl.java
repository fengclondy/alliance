package com.ai.aso.common.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.RegionMapper;
import com.ai.aso.common.db.model.Region;
import com.ai.aso.common.db.model.RegionExample;
import com.ai.aso.common.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService{
	
	@Autowired
	private RegionMapper regionMapper;

	@Override
	public Region findRegionByRegionId(Integer regionId) {
		if (null == regionId) {
			return null;
		}
		
		return regionMapper.selectByPrimaryKey(regionId);
	}

	@Override
	public List<Region> findEnabledRegionList() {
		RegionExample example = new RegionExample();
		example.createCriteria().andStateEqualTo(GlobalParamSet.getShort(BizConstants.SYS_GLOBAL_STATE_ENABLE));
		return regionMapper.selectByExample(example);
	}

	@Override
	public Region findRegionByRegionCode(String regionCode) {
		RegionExample example = new RegionExample();
		example.createCriteria()
		.andStateEqualTo(GlobalParamSet.getShort(BizConstants.SYS_GLOBAL_STATE_ENABLE))
		.andRegionCodeEqualTo(regionCode);
		
		List<Region> rList = regionMapper.selectByExample(example);
		
		assert (rList != null && rList.size() == 1) : "未匹配到区域代码！" ;
		return rList.get(0);
	}

	@Override
	public HashMap<String,String> loadRegionMap() {
		RegionExample example = new RegionExample();
		example.createCriteria().andStateEqualTo((short)1);//此处必须用1 不要从数据库获取
		List<Region> rList = regionMapper.selectByExample(example);
		HashMap<String,String> map = new HashMap<String,String>();
		for( Region r : rList )
		{
			map.put(String.valueOf(r.getRegionId()), r.getRegionCode());
			map.put(r.getRegionCode(), String.valueOf(r.getRegionId()));
		}
		return map;
	}

	@Override
	public Region findRegionByFpsRegionCode(String fpsRegionCode) {
		RegionExample example = new RegionExample();
		example.createCriteria()
				.andStateEqualTo(GlobalParamSet.getShort(BizConstants.SYS_GLOBAL_STATE_ENABLE))
				.andFpsRegionCodeEqualTo(fpsRegionCode);

		List<Region> rList = regionMapper.selectByExample(example);

		if (rList == null && rList.size() == 0) {
			return null;
		}
		return rList.get(0);
	}

}
