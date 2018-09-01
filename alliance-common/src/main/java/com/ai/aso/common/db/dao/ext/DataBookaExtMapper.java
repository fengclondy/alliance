/**
 * 
 */
package com.ai.aso.common.db.dao.ext;

import org.apache.ibatis.annotations.Param;

/** 
 * @ClassName: DataBookaExtMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-10-8 下午1:00:04
 *
 */

public interface DataBookaExtMapper {
	
	public void updateDataBooka(@Param("cont_id") String cont_id, @Param("ver_") int ver_, @Param("amount") long amount);
	public int updateDataBookaTotal(@Param("cont_id") String cont_id, @Param("ver_") int ver_, @Param("amount") long amount);
	public int updateDataBookaBalance(@Param("cont_id") String cont_id, @Param("ver_") int ver_, @Param("amount") long amount);
	
	public int updateDataBookaReduce(@Param("cont_id") String cont_id, @Param("amount") long amount);
	
	public int addDataBookaTotal(@Param("cont_id") String cont_id, @Param("ver_") int ver_, @Param("amount") long amount);
	public int addDataBookaBalance(@Param("cont_id") String cont_id, @Param("ver_") int ver_, @Param("amount") long amount);
	
}	
