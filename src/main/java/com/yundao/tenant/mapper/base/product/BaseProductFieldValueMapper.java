package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductFieldValue;
import com.yundao.tenant.model.base.product.BaseProductFieldValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductFieldValueMapper {
    int countByExample(BaseProductFieldValueExample example);

    int deleteByExample(BaseProductFieldValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductFieldValue record);

    int insertSelective(BaseProductFieldValue record);

    List<BaseProductFieldValue> selectByExampleWithBLOBs(BaseProductFieldValueExample example);

    List<BaseProductFieldValue> selectByExample(BaseProductFieldValueExample example);

    BaseProductFieldValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductFieldValue record, @Param("example") BaseProductFieldValueExample example);

    int updateByExampleWithBLOBs(@Param("record") BaseProductFieldValue record, @Param("example") BaseProductFieldValueExample example);

    BaseProductFieldValue selectOne(BaseProductFieldValueExample example);

    int updateByExample(@Param("record") BaseProductFieldValue record, @Param("example") BaseProductFieldValueExample example);

    int updateByPrimaryKeySelective(BaseProductFieldValue record);

    int updateByPrimaryKeyWithBLOBs(BaseProductFieldValue record);

    int updateByPrimaryKey(BaseProductFieldValue record);
}