package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductIncome;
import com.yundao.tenant.model.base.product.BaseProductIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductIncomeMapper {
    int countByExample(BaseProductIncomeExample example);

    int deleteByExample(BaseProductIncomeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductIncome record);

    int insertSelective(BaseProductIncome record);

    List<BaseProductIncome> selectByExample(BaseProductIncomeExample example);

    BaseProductIncome selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductIncome record, @Param("example") BaseProductIncomeExample example);

    BaseProductIncome selectOne(BaseProductIncomeExample example);

    int updateByExample(@Param("record") BaseProductIncome record, @Param("example") BaseProductIncomeExample example);

    int updateByPrimaryKeySelective(BaseProductIncome record);

    int updateByPrimaryKey(BaseProductIncome record);
}