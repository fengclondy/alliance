package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.Cust;
import com.ai.aso.common.db.model.CustExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CustMapper {
    int countByExample(CustExample example);

    int deleteByExample(CustExample example);

    int deleteByPrimaryKey(String custId);

    int insert(Cust record);

    int insertSelective(Cust record);

    List<Cust> selectByExample(CustExample example);

    Cust selectByPrimaryKey(String custId);

    int updateByExampleSelective(@Param("record") Cust record, @Param("example") CustExample example);

    int updateByExample(@Param("record") Cust record, @Param("example") CustExample example);

    int updateByPrimaryKeySelective(Cust record);

    int updateByPrimaryKey(Cust record);
}