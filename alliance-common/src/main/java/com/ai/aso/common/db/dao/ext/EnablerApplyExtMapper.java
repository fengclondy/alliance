/**
 * 
 */
package com.ai.aso.common.db.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/** 
 * @ClassName: EnablerApplyExtMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-10-28 上午10:39:02
 *
 */

public interface EnablerApplyExtMapper {
	public List getIps(@Param("custId") String custId);
	
	public List getAllIps();
}
