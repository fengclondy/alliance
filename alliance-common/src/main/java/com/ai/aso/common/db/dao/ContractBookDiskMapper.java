package com.ai.aso.common.db.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ai.aso.common.db.model.ContractBookDisk;
import com.ai.aso.common.db.model.ContractBookDiskExample;
@Mapper
public interface ContractBookDiskMapper {
    int countByExample(ContractBookDiskExample example);

    int deleteByExample(ContractBookDiskExample example);

    int insert(ContractBookDisk record);

    int insertSelective(ContractBookDisk record);

    List<ContractBookDisk> selectByExample(ContractBookDiskExample example);

    int updateByExampleSelective(@Param("record") ContractBookDisk record, @Param("example") ContractBookDiskExample example);

    int updateByExample(@Param("record") ContractBookDisk record, @Param("example") ContractBookDiskExample example);
}