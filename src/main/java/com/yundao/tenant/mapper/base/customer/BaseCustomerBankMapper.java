package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerBank;
import com.yundao.tenant.model.base.customer.BaseCustomerBankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerBankMapper {
    int countByExample(BaseCustomerBankExample example);

    int deleteByExample(BaseCustomerBankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerBank record);

    int insertSelective(BaseCustomerBank record);

    List<BaseCustomerBank> selectByExample(BaseCustomerBankExample example);

    BaseCustomerBank selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerBank record, @Param("example") BaseCustomerBankExample example);

    BaseCustomerBank selectOne(BaseCustomerBankExample example);

    int updateByExample(@Param("record") BaseCustomerBank record, @Param("example") BaseCustomerBankExample example);

    int updateByPrimaryKeySelective(BaseCustomerBank record);

    int updateByPrimaryKey(BaseCustomerBank record);
}