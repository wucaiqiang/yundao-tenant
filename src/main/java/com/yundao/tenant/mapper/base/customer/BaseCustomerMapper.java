package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerMapper {
    int countByExample(BaseCustomerExample example);

    int deleteByExample(BaseCustomerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomer record);

    int insertSelective(BaseCustomer record);

    List<BaseCustomer> selectByExample(BaseCustomerExample example);

    BaseCustomer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomer record, @Param("example") BaseCustomerExample example);

    BaseCustomer selectOne(BaseCustomerExample example);

    int updateByExample(@Param("record") BaseCustomer record, @Param("example") BaseCustomerExample example);

    int updateByPrimaryKeySelective(BaseCustomer record);

    int updateByPrimaryKey(BaseCustomer record);
}