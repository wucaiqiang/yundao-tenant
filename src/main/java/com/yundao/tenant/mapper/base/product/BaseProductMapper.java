package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductMapper {
    int countByExample(BaseProductExample example);

    int deleteByExample(BaseProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProduct record);

    int insertSelective(BaseProduct record);

    List<BaseProduct> selectByExample(BaseProductExample example);

    BaseProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProduct record, @Param("example") BaseProductExample example);

    BaseProduct selectOne(BaseProductExample example);

    int updateByExample(@Param("record") BaseProduct record, @Param("example") BaseProductExample example);

    int updateByPrimaryKeySelective(BaseProduct record);

    int updateByPrimaryKey(BaseProduct record);
}