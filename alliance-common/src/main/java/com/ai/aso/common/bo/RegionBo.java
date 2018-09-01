package com.ai.aso.common.bo;

import java.util.ArrayList;
import java.util.List;

import com.ai.aso.common.db.model.Region;

public class RegionBo {

	private Region region;

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public static List<RegionBo> fromRegion(List<Region> regionList) {
		List<RegionBo> boList = null;
		if(null != regionList) {
			boList = new ArrayList<RegionBo>();
			for (Region region : regionList) {
				RegionBo bo = new RegionBo();
				bo.setRegion(region);
				boList.add(bo);
			}
		}
		
		return boList;
	}
	
}
