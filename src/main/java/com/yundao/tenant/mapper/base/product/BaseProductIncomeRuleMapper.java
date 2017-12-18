package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductIncomeRule;
import com.yundao.tenant.model.base.product.BaseProductIncomeRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductIncomeRuleMapper {
    int countByExample(BaseProductIncomeRuleExample example);

    int deleteByExample(BaseProductIncomeRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductIncomeRule record);

    int insertSelective(BaseProductIncomeRule record);

    List<BaseProductIncomeRule> selectByExample(BaseProductIncomeRuleExample example);

    BaseProductIncomeRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductIncomeRule record, @Param("example") BaseProductIncomeRuleExample example);

    BaseProductIncomeRule selectOne(BaseProductIncomeRuleExample example);

    int updateByExample(@Param("record") BaseProductIncomeRule record, @Param("example") BaseProductIncomeRuleExample example);

    int updateByPrimaryKeySelective(BaseProductIncomeRule record);

    int updateByPrimaryKey(BaseProductIncomeRule record);
}