package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.CustBill;
import com.ai.aso.common.db.model.CustBillExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CustBillMapper {
    int countByExample(CustBillExample example);

    int deleteByExample(CustBillExample example);

    int deleteByPrimaryKey(Long billId);

    int insert(CustBill record);

    int insertSelective(CustBill record);

    List<CustBill> selectByExample(CustBillExample example);

    CustBill selectByPrimaryKey(Long billId);

    int updateByExampleSelective(@Param("record") CustBill record, @Param("example") CustBillExample example);

    int updateByExample(@Param("record") CustBill record, @Param("example") CustBillExample example);

    int updateByPrimaryKeySelective(CustBill record);

    int updateByPrimaryKey(CustBill record);
}