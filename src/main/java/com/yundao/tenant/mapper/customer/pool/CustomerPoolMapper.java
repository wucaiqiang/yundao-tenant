package com.yundao.tenant.mapper.customer.pool;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customer.pool.CustomerPassPayDto;
import com.yundao.tenant.dto.customer.pool.CustomerPoolPageResDto;

public interface CustomerPoolMapper {

    /**
     * 客户分页列表
     */
    List<CustomerPoolPageResDto> selectCustomerPage(Map<String, Object> parmas) throws BaseException;

    /**
     * 客户分页列表总条数
     */
    Integer selectCustomerPageCount(Map<String, Object> parmas) throws BaseException;
    
    
    /**
     * 查询客户审核通过并且没有作废的报单
     * getCustomerPassPayDto:
     * @author: 欧阳利
     * @param customerIds
     * @return
     * @description:
     */
    List<CustomerPassPayDto> getCustomerPassPayDtos(@Param("customerIds") List<Long> customerIds);

}
