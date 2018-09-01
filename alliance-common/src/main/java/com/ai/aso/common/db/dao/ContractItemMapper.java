package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.ContractItem;
import com.ai.aso.common.db.model.ContractItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ContractItemMapper {
    int countByExample(ContractItemExample example);

    int deleteByExample(ContractItemExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(ContractItem record);

    int insertSelective(ContractItem record);

    List<ContractItem> selectByExample(ContractItemExample example);

    ContractItem selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") ContractItem record, @Param("example") ContractItemExample example);

    int updateByExample(@Param("record") ContractItem record, @Param("example") ContractItemExample example);

    int updateByPrimaryKeySelective(ContractItem record);

    int updateByPrimaryKey(ContractItem record);
}