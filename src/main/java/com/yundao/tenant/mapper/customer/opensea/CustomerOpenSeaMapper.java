package com.yundao.tenant.mapper.customer.opensea;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaAppPageResDto;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaPageResDto;

public interface CustomerOpenSeaMapper {

    /**
     * 客户公海分页列表
     */
    List<CustomerOpenSeaPageResDto> selectCustomerPage(Map<String, Object> parmas) throws BaseException;

    /**
     * 客户公海分页列表总条数
     */
    Integer selectCustomerPageCount(Map<String, Object> parmas) throws BaseException;
    
    
    
    
    
    /**
     * App客户公海分页列表
     */
    List<CustomerOpenSeaAppPageResDto> selectAppCustomerPage(Map<String, Object> parmas) throws BaseException;

    /**
     * App客户公海分页列表总条数
     */
    Integer selectAppCustomerPageCount(Map<String, Object> parmas) throws BaseException;
    
    
    
    
    
    /**
     * 查询用户领取的客户的个数
     * selectReceiveCustomerCount:
     * @author: 欧阳利
     * @param userId
     * @return
     * @description:
     */
    Integer selectReceiveCustomerCount(@Param("userId")Long userId);
}
