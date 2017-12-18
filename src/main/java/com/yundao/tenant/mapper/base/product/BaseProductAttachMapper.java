package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductAttach;
import com.yundao.tenant.model.base.product.BaseProductAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductAttachMapper {
    int countByExample(BaseProductAttachExample example);

    int deleteByExample(BaseProductAttachExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductAttach record);

    int insertSelective(BaseProductAttach record);

    List<BaseProductAttach> selectByExample(BaseProductAttachExample example);

    BaseProductAttach selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductAttach record, @Param("example") BaseProductAttachExample example);

    BaseProductAttach selectOne(BaseProductAttachExample example);

    int updateByExample(@Param("record") BaseProductAttach record, @Param("example") BaseProductAttachExample example);

    int updateByPrimaryKeySelective(BaseProductAttach record);

    int updateByPrimaryKey(BaseProductAttach record);
}