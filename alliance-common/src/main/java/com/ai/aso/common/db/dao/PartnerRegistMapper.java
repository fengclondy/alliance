package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.PartnerRegist;
import com.ai.aso.common.db.model.PartnerRegistExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PartnerRegistMapper {
    int countByExample(PartnerRegistExample example);

    int deleteByExample(PartnerRegistExample example);

    int deleteByPrimaryKey(String registId);

    int insert(PartnerRegist record);

    int insertSelective(PartnerRegist record);

    List<PartnerRegist> selectByExample(PartnerRegistExample example);

    PartnerRegist selectByPrimaryKey(String registId);

    int updateByExampleSelective(@Param("record") PartnerRegist record, @Param("example") PartnerRegistExample example);

    int updateByExample(@Param("record") PartnerRegist record, @Param("example") PartnerRegistExample example);

    int updateByPrimaryKeySelective(PartnerRegist record);

    int updateByPrimaryKey(PartnerRegist record);
}