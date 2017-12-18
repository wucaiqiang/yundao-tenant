package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerInvestType;
import com.yundao.tenant.model.base.customer.BaseCustomerInvestTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerInvestTypeMapper {
    int countByExample(BaseCustomerInvestTypeExample example);

    int deleteByExample(BaseCustomerInvestTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerInvestType record);

    int insertSelective(BaseCustomerInvestType record);

    List<BaseCustomerInvestType> selectByExample(BaseCustomerInvestTypeExample example);

    BaseCustomerInvestType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerInvestType record, @Param("example") BaseCustomerInvestTypeExample example);

    BaseCustomerInvestType selectOne(BaseCustomerInvestTypeExample example);

    int updateByExample(@Param("record") BaseCustomerInvestType record, @Param("example") BaseCustomerInvestTypeExample example);

    int updateByPrimaryKeySelective(BaseCustomerInvestType record);

    int updateByPrimaryKey(BaseCustomerInvestType record);
}