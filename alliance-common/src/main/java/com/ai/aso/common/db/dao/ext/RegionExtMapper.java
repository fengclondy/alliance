package com.ai.aso.common.db.dao.ext;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RegionExtMapper {
	
	List<Integer> selectRegionId();
	
}