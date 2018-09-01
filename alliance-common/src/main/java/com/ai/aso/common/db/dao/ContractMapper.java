package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ContractMapper {
    int countByExample(ContractExample example);

    int deleteByExample(ContractExample example);

    int deleteByPrimaryKey(String contId);

    int insert(Contract record);

    int insertSelective(Contract record);

    List<Contract> selectByExample(ContractExample example);

    Contract selectByPrimaryKey(String contId);

    int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
}