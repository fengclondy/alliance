package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.ContractOper;
import com.ai.aso.common.db.model.ContractOperExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ContractOperMapper {
    int countByExample(ContractOperExample example);

    int deleteByExample(ContractOperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContractOper record);

    int insertSelective(ContractOper record);

    List<ContractOper> selectByExample(ContractOperExample example);

    ContractOper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContractOper record, @Param("example") ContractOperExample example);

    int updateByExample(@Param("record") ContractOper record, @Param("example") ContractOperExample example);

    int updateByPrimaryKeySelective(ContractOper record);

    int updateByPrimaryKey(ContractOper record);
}