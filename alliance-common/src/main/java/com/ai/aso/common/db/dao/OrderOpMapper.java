package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.OrderOp;
import com.ai.aso.common.db.model.OrderOpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderOpMapper {
    int countByExample(OrderOpExample example);

    int deleteByExample(OrderOpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderOp record);

    int insertSelective(OrderOp record);

    List<OrderOp> selectByExample(OrderOpExample example);

    OrderOp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderOp record, @Param("example") OrderOpExample example);

    int updateByExample(@Param("record") OrderOp record, @Param("example") OrderOpExample example);

    int updateByPrimaryKeySelective(OrderOp record);

    int updateByPrimaryKey(OrderOp record);
}