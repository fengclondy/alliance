package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.AttrDef;
import com.ai.aso.common.db.model.AttrDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttrDefMapper {
    int countByExample(AttrDefExample example);

    int deleteByExample(AttrDefExample example);

    int deleteByPrimaryKey(Integer attrId);

    int insert(AttrDef record);

    int insertSelective(AttrDef record);

    List<AttrDef> selectByExample(AttrDefExample example);

    AttrDef selectByPrimaryKey(Integer attrId);

    int updateByExampleSelective(@Param("record") AttrDef record, @Param("example") AttrDefExample example);

    int updateByExample(@Param("record") AttrDef record, @Param("example") AttrDefExample example);

    int updateByPrimaryKeySelective(AttrDef record);

    int updateByPrimaryKey(AttrDef record);
}