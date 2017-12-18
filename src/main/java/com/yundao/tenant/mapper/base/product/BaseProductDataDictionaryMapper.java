package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductDataDictionary;
import com.yundao.tenant.model.base.product.BaseProductDataDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductDataDictionaryMapper {
    int countByExample(BaseProductDataDictionaryExample example);

    int deleteByExample(BaseProductDataDictionaryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductDataDictionary record);

    int insertSelective(BaseProductDataDictionary record);

    List<BaseProductDataDictionary> selectByExample(BaseProductDataDictionaryExample example);

    BaseProductDataDictionary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductDataDictionary record, @Param("example") BaseProductDataDictionaryExample example);

    BaseProductDataDictionary selectOne(BaseProductDataDictionaryExample example);

    int updateByExample(@Param("record") BaseProductDataDictionary record, @Param("example") BaseProductDataDictionaryExample example);

    int updateByPrimaryKeySelective(BaseProductDataDictionary record);

    int updateByPrimaryKey(BaseProductDataDictionary record);
}