

package com.yundao.tenant.service.user.customer;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customer.CustomerMultiIdReqDto;
import com.yundao.tenant.dto.user.customer.UserCustomerFocusReqDto;
import com.yundao.tenant.model.base.customer.BaseUserCustomerFocus;

import java.util.List;

/**
 * Function:
 * Reason:
 * Date:     2017年8月9日 下午2:16:20
 *
 * @author wucq
 */
public interface UserCustomerFocusService {

    List<BaseUserCustomerFocus> select(UserCustomerFocusReqDto reqDto) throws BaseException;

    /**
     * 批量关注
     */
    Result<Boolean> doFocus(CustomerMultiIdReqDto dto) throws BaseException;

    /**
     * 取消关注
     *
     * @param customerId 客户id
     */
    Result<Boolean> doUnFocus(Long customerId) throws BaseException;
}

