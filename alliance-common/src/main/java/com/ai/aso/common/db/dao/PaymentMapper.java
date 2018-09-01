package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.Payment;
import com.ai.aso.common.db.model.PaymentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaymentMapper {
    int countByExample(PaymentExample example);

    int deleteByExample(PaymentExample example);

    int deleteByPrimaryKey(String paymentId);

    int insert(Payment record);

    int insertSelective(Payment record);

    List<Payment> selectByExample(PaymentExample example);

    Payment selectByPrimaryKey(String paymentId);

    int updateByExampleSelective(@Param("record") Payment record, @Param("example") PaymentExample example);

    int updateByExample(@Param("record") Payment record, @Param("example") PaymentExample example);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}