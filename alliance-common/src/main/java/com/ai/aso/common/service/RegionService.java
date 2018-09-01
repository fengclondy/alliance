package com.ai.aso.common.service;

import java.util.HashMap;
import java.util.List;

import com.ai.aso.common.db.model.Region;

public interface RegionService {

	Region findRegionByRegionId(Integer regionId);

	List<Region> findEnabledRegionList();
	
	Region findRegionByRegionCode(String regionCode);
	
	HashMap<String,String> loadRegionMap();

	Region findRegionByFpsRegionCode(String fpsRegionCode);
}
