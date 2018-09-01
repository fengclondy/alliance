package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.DiscountRule;
import com.ai.aso.common.db.model.DiscountRuleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DiscountRuleMapper {
    int countByExample(DiscountRuleExample example);

    int deleteByExample(DiscountRuleExample example);

    int deleteByPrimaryKey(String ruleId);

    int insert(DiscountRule record);

    int insertSelective(DiscountRule record);

    List<DiscountRule> selectByExample(DiscountRuleExample example);

    DiscountRule selectByPrimaryKey(String ruleId);

    int updateByExampleSelective(@Param("record") DiscountRule record, @Param("example") DiscountRuleExample example);

    int updateByExample(@Param("record") DiscountRule record, @Param("example") DiscountRuleExample example);

    int updateByPrimaryKeySelective(DiscountRule record);

    int updateByPrimaryKey(DiscountRule record);
}