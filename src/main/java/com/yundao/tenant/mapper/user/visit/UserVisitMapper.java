package com.yundao.tenant.mapper.user.visit;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customer.customer.CustomerDetailVisitPageResDto;
import com.yundao.tenant.dto.user.visit.UserVisitDetailForLeads;
import com.yundao.tenant.dto.user.visit.UserVisitPageResDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserVisitMapper {

    /**
     * 获取客户详情页回访数据
     */
    List<CustomerDetailVisitPageResDto> selectCustomerDetailVisitPage(Map<String, Object> params);

    /**
     * 获取客户详情页回访数据总条数
     */
    Integer selectCustomerDetailVisitPageCount(Map<String, Object> params);

    /**
     * 获取分页数据
     */
    List<UserVisitPageResDto> selectPage(Map<String, Object> params);

    /**
     * 获取分页数据总条数
     */
    Integer selectPageCount(Map<String, Object> params);

    /**
     * 获取销售线索列表页 回访详情
     *
     * @param leadsId 线索id
     */
    UserVisitDetailForLeads selectForLeads(@Param("leadsId") Long leadsId) throws BaseException;

}