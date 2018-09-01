package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.GoodsCatalog;
import com.ai.aso.common.db.model.GoodsCatalogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface GoodsCatalogMapper {
    int countByExample(GoodsCatalogExample example);

    int deleteByExample(GoodsCatalogExample example);

    int deleteByPrimaryKey(String catalogId);

    int insert(GoodsCatalog record);

    int insertSelective(GoodsCatalog record);

    List<GoodsCatalog> selectByExample(GoodsCatalogExample example);

    GoodsCatalog selectByPrimaryKey(String catalogId);

    int updateByExampleSelective(@Param("record") GoodsCatalog record, @Param("example") GoodsCatalogExample example);

    int updateByExample(@Param("record") GoodsCatalog record, @Param("example") GoodsCatalogExample example);

    int updateByPrimaryKeySelective(GoodsCatalog record);

    int updateByPrimaryKey(GoodsCatalog record);
}