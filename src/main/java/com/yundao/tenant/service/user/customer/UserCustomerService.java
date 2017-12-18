

package com.yundao.tenant.service.user.customer;


import java.util.List;
import java.util.Map;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.user.customer.UserCustomerReqDto;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;

/**
 * Function:
 * Reason:
 * Date:     2017年8月9日 下午3:59:11
 *
 * @author wucq
 */
public interface UserCustomerService {

	Integer insert(BaseUserCustomer record)throws BaseException;
	
    BaseUserCustomer select(UserCustomerReqDto reqDto) throws BaseException;

    Map<Long, BaseUserCustomer> getUserByCustomer(List<Long> customerId);

    /**
     * 获取客户的理财师id集合
     *
     * @param customerId
     * @return
     */
    Long getUserIdByCustomer(Long customerId);

    /**
     * 获取数据
     *
     * @param customerId 客户id
     */
    BaseUserCustomer getByCustomerId(Long customerId) throws BaseException;
    
    
    
}

