package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.DiscountAttrs;
import com.ai.aso.common.db.model.DiscountAttrsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DiscountAttrsMapper {
    int countByExample(DiscountAttrsExample example);

    int deleteByExample(DiscountAttrsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DiscountAttrs record);

    int insertSelective(DiscountAttrs record);

    List<DiscountAttrs> selectByExample(DiscountAttrsExample example);

    DiscountAttrs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DiscountAttrs record, @Param("example") DiscountAttrsExample example);

    int updateByExample(@Param("record") DiscountAttrs record, @Param("example") DiscountAttrsExample example);

    int updateByPrimaryKeySelective(DiscountAttrs record);

    int updateByPrimaryKey(DiscountAttrs record);
}