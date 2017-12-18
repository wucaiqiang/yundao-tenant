package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductCommission;
import com.yundao.tenant.model.base.product.BaseProductCommissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductCommissionMapper {
    int countByExample(BaseProductCommissionExample example);

    int deleteByExample(BaseProductCommissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductCommission record);

    int insertSelective(BaseProductCommission record);

    List<BaseProductCommission> selectByExample(BaseProductCommissionExample example);

    BaseProductCommission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductCommission record, @Param("example") BaseProductCommissionExample example);

    BaseProductCommission selectOne(BaseProductCommissionExample example);

    int updateByExample(@Param("record") BaseProductCommission record, @Param("example") BaseProductCommissionExample example);

    int updateByPrimaryKeySelective(BaseProductCommission record);

    int updateByPrimaryKey(BaseProductCommission record);
}