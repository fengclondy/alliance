package com.ai.aso.common.db.dao;

import java.util.List;

import com.ai.aso.common.db.model.ContractSynchronize;
import com.ai.aso.common.db.model.ContractSynchronizeExample;
import org.apache.ibatis.annotations.Param;

public interface ContractSynchronizeMapper {
    int countByExample(ContractSynchronizeExample example);

    int deleteByExample(ContractSynchronizeExample example);

    int deleteByPrimaryKey(String contId);

    int insert(ContractSynchronize record);

    int insertSelective(ContractSynchronize record);

    List<ContractSynchronize> selectByExample(ContractSynchronizeExample example);

    ContractSynchronize selectByPrimaryKey(String contId);

    int updateByExampleSelective(@Param("record") ContractSynchronize record, @Param("example") ContractSynchronizeExample example);

    int updateByExample(@Param("record") ContractSynchronize record, @Param("example") ContractSynchronizeExample example);

    int updateByPrimaryKeySelective(ContractSynchronize record);

    int updateByPrimaryKey(ContractSynchronize record);
}