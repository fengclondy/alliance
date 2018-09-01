package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.DataBookaStub;
import com.ai.aso.common.db.model.DataBookaStubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataBookaStubMapper {
    int countByExample(DataBookaStubExample example);

    int deleteByExample(DataBookaStubExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DataBookaStub record);

    int insertSelective(DataBookaStub record);

    List<DataBookaStub> selectByExample(DataBookaStubExample example);

    DataBookaStub selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DataBookaStub record, @Param("example") DataBookaStubExample example);

    int updateByExample(@Param("record") DataBookaStub record, @Param("example") DataBookaStubExample example);

    int updateByPrimaryKeySelective(DataBookaStub record);

    int updateByPrimaryKey(DataBookaStub record);
}