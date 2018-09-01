package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.ContractOff;
import com.ai.aso.common.db.model.ContractOffExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ContractOffMapper {
    int countByExample(ContractOffExample example);

    int deleteByExample(ContractOffExample example);

    int deleteByPrimaryKey(@Param("contId") String contId, @Param("dataType") Integer dataType);

    int insert(ContractOff record);

    int insertSelective(ContractOff record);

    List<ContractOff> selectByExample(ContractOffExample example);

    ContractOff selectByPrimaryKey(@Param("contId") String contId, @Param("dataType") Integer dataType);

    int updateByExampleSelective(@Param("record") ContractOff record, @Param("example") ContractOffExample example);

    int updateByExample(@Param("record") ContractOff record, @Param("example") ContractOffExample example);

    int updateByPrimaryKeySelective(ContractOff record);

    int updateByPrimaryKey(ContractOff record);
}