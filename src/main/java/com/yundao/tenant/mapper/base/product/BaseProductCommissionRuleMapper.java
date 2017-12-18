package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductCommissionRule;
import com.yundao.tenant.model.base.product.BaseProductCommissionRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductCommissionRuleMapper {
    int countByExample(BaseProductCommissionRuleExample example);

    int deleteByExample(BaseProductCommissionRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductCommissionRule record);

    int insertSelective(BaseProductCommissionRule record);

    List<BaseProductCommissionRule> selectByExample(BaseProductCommissionRuleExample example);

    BaseProductCommissionRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductCommissionRule record, @Param("example") BaseProductCommissionRuleExample example);

    BaseProductCommissionRule selectOne(BaseProductCommissionRuleExample example);

    int updateByExample(@Param("record") BaseProductCommissionRule record, @Param("example") BaseProductCommissionRuleExample example);

    int updateByPrimaryKeySelective(BaseProductCommissionRule record);

    int updateByPrimaryKey(BaseProductCommissionRule record);
}