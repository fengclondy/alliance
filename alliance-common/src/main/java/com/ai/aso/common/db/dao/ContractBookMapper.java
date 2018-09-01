package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.ContractBook;
import com.ai.aso.common.db.model.ContractBookExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ContractBookMapper {
    int countByExample(ContractBookExample example);

    int deleteByExample(ContractBookExample example);

    int deleteByPrimaryKey(String bookId);

    int insert(ContractBook record);

    int insertSelective(ContractBook record);

    List<ContractBook> selectByExample(ContractBookExample example);

    ContractBook selectByPrimaryKey(String bookId);

    int updateByExampleSelective(@Param("record") ContractBook record, @Param("example") ContractBookExample example);

    int updateByExample(@Param("record") ContractBook record, @Param("example") ContractBookExample example);

    int updateByPrimaryKeySelective(ContractBook record);

    int updateByPrimaryKey(ContractBook record);
}