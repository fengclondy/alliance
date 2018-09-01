package com.ai.aso.common.db.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ai.aso.common.bo.DataRecBo;
@Mapper
public interface DataRecExtMapper {
	
	int updateBillMonth(@Param("billMonth") String billMonth, @Param("billState") Integer billState,
                        @Param("billId") String[] billId);

	public void batchInsert(List<DataRecBo> list);
	
	public Long getRemaining(@Param("contId") String contId);
	
	public int dataRecUpdateState(@Param("rec_no") String rec_no, @Param("state") int state);
	
	public int crmResultUpdate(DataRecBo bo);
	
	public int updateVer(@Param("ver") int ver, @Param("recNo") String recNo);
	List<String>  getDataCustGroupByCust(List<String> custIds);
	
	int updateBillMonthByCust(@Param("billMonth") String billMonth, @Param("billState") Integer billState,
                              @Param("contId") String contId, @Param("billBatch") String[] billBatch);
}
