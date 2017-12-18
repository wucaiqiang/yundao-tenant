package com.yundao.tenant.mapper.customer.customerfollowup;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUp;

import java.util.List;
import java.util.Map;

public interface CustomerFollowUpMapper {

    List<BaseCustomerFollowUp> selectPageByCustomerId(Map<String, Object> parmas) throws BaseException;

    Integer selectPageByCustomerIdCount(Map<String, Object> parmas) throws BaseException;

}
