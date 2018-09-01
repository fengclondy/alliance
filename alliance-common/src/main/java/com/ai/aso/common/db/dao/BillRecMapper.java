package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.BillRec;
import com.ai.aso.common.db.model.BillRecExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BillRecMapper {
    int countByExample(BillRecExample example);

    int deleteByExample(BillRecExample example);

    int deleteByPrimaryKey(Long billRecId);

    int insert(BillRec record);

    int insertSelective(BillRec record);

    List<BillRec> selectByExample(BillRecExample example);

    BillRec selectByPrimaryKey(Long billRecId);

    int updateByExampleSelective(@Param("record") BillRec record, @Param("example") BillRecExample example);

    int updateByExample(@Param("record") BillRec record, @Param("example") BillRecExample example);

    int updateByPrimaryKeySelective(BillRec record);

    int updateByPrimaryKey(BillRec record);
}