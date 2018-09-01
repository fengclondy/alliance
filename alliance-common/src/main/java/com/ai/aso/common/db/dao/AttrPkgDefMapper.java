package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.AttrPkgDef;
import com.ai.aso.common.db.model.AttrPkgDefExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttrPkgDefMapper {
    int countByExample(AttrPkgDefExample example);

    int deleteByExample(AttrPkgDefExample example);

    int deleteByPrimaryKey(String attrPkgCode);

    int insert(AttrPkgDef record);

    int insertSelective(AttrPkgDef record);

    List<AttrPkgDef> selectByExample(AttrPkgDefExample example);

    AttrPkgDef selectByPrimaryKey(String attrPkgCode);

    int updateByExampleSelective(@Param("record") AttrPkgDef record, @Param("example") AttrPkgDefExample example);

    int updateByExample(@Param("record") AttrPkgDef record, @Param("example") AttrPkgDefExample example);

    int updateByPrimaryKeySelective(AttrPkgDef record);

    int updateByPrimaryKey(AttrPkgDef record);
}