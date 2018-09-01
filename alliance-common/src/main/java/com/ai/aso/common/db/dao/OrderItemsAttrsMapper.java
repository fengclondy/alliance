package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.OrderItemsAttrs;
import com.ai.aso.common.db.model.OrderItemsAttrsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemsAttrsMapper {
    int countByExample(OrderItemsAttrsExample example);

    int deleteByExample(OrderItemsAttrsExample example);

    int deleteByPrimaryKey(@Param("attrCode") String attrCode, @Param("itemId") Long itemId);

    int insert(OrderItemsAttrs record);

    int insertSelective(OrderItemsAttrs record);

    List<OrderItemsAttrs> selectByExample(OrderItemsAttrsExample example);

    OrderItemsAttrs selectByPrimaryKey(@Param("attrCode") String attrCode, @Param("itemId") Long itemId);

    int updateByExampleSelective(@Param("record") OrderItemsAttrs record, @Param("example") OrderItemsAttrsExample example);

    int updateByExample(@Param("record") OrderItemsAttrs record, @Param("example") OrderItemsAttrsExample example);

    int updateByPrimaryKeySelective(OrderItemsAttrs record);

    int updateByPrimaryKey(OrderItemsAttrs record);
}