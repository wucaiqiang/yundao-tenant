package com.yundao.tenant.mapper.customer.customerinvesttype;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.customer.customerinvesttype.CustomerInvestTypeDto;

public interface CustomerInvestTypeMapper{
   List<CustomerInvestTypeDto> selectByCustomerId(@Param("customerId") Long customerId);
}
