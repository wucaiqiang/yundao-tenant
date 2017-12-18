package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.model.base.customer.BaseUserCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserCustomerMapper {
    int countByExample(BaseUserCustomerExample example);

    int deleteByExample(BaseUserCustomerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUserCustomer record);

    int insertSelective(BaseUserCustomer record);

    List<BaseUserCustomer> selectByExample(BaseUserCustomerExample example);

    BaseUserCustomer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUserCustomer record, @Param("example") BaseUserCustomerExample example);

    BaseUserCustomer selectOne(BaseUserCustomerExample example);

    int updateByExample(@Param("record") BaseUserCustomer record, @Param("example") BaseUserCustomerExample example);

    int updateByPrimaryKeySelective(BaseUserCustomer record);

    int updateByPrimaryKey(BaseUserCustomer record);
}