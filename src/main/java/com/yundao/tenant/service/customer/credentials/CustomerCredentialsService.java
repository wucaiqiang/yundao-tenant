

package com.yundao.tenant.service.customer.credentials;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customer.credentials.CustomerCredentialsDto;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentials;

/**
 * Function:
 * Reason:
 * Date:     2017年8月10日 下午2:32:31
 *
 * @author wucq
 */
public interface CustomerCredentialsService {
    public CustomerCredentialsDto selectByCustomerId(Long customerId) throws BaseException;

    public int update(BaseCustomerCredentials baseCustomerCredentials) throws BaseException;

    public int insert(BaseCustomerCredentials baseCustomerCredentials) throws BaseException;

    /**
     * 插入客户与证件关系
     *
     * @param customerId    客户id
     * @param credentialsId 证件id
     */
    Long insertRel(Long customerId, Long credentialsId) throws BaseException;
}

