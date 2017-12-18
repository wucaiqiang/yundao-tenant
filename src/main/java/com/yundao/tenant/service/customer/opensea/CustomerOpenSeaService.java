

package com.yundao.tenant.service.customer.opensea;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaAppPageReqDto;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaAppPageResDto;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaPageReqDto;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaPageResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月18日 下午7:58:34 
 * @author   欧阳利
 * @version   
 */
public interface CustomerOpenSeaService {
    /**
     * 获取分页数据
     */
    Result<PaginationSupport<CustomerOpenSeaPageResDto>> getPage(CustomerOpenSeaPageReqDto dto,Integer permission) throws BaseException;
    
    
    /**
     * app获取分页数据
     */
    Result<PaginationSupport<CustomerOpenSeaAppPageResDto>> getAppPage(CustomerOpenSeaAppPageReqDto dto,Integer permission) throws BaseException;
    
    
    /**
     * 领取公海客户
     * receiveCustomer:
     * @author: 欧阳利
     * @param customerId
     * @return
     * @throws BaseException
     * @description:
     */
    public Result<Integer> doReceiveCustomer(Long customerId) throws BaseException;
}

