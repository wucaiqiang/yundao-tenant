package com.yundao.tenant.mapper.customer.customer;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customer.customer.CustomerDistributionResDto;
import com.yundao.tenant.dto.customer.customer.CustomerSelectionResDto;
import com.yundao.tenant.dto.customer.customer.MyCustomerPageResDto;
import com.yundao.tenant.dto.customer.v2.CustomerV2PageResDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {

    List<CustomerV2PageResDto> selectPage(Map<String, Object> parmas) throws BaseException;

    Integer selectPageCount(Map<String, Object> parmas) throws BaseException;

    /**
     * 我的客户分页列表
     */
    @Deprecated
    List<MyCustomerPageResDto> selectMyCustomerPage(Map<String, Object> parmas) throws BaseException;

    /**
     * 我的客户分页列表总条数
     */
    @Deprecated
    Integer selectMyCustomerPageCount(Map<String, Object> parmas) throws BaseException;

    /**
     * 获取客户下拉选项数据
     */
    List<CustomerSelectionResDto> selectCustomerSelection(Map<String, Object> parmas) throws BaseException;

    /**
     * 筛选有正在审批的额度预约的客户
     *
     * @param customerIds 客户id
     */
    List<CustomerDistributionResDto> selectAuditingReservationCustomerIds(@Param("customerIds") List<Long> customerIds) throws BaseException;

    /**
     * 筛选有正在审批报单的客户
     *
     * @param customerIds 客户id
     */
    List<CustomerDistributionResDto> selectAuditingDelcarationCustomerIds(@Param("customerIds") List<Long> customerIds) throws BaseException;

}
