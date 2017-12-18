package com.yundao.tenant.service.customercenter;


import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customercenter.consult.ConsultFPReqDto;
import com.yundao.tenant.dto.customercenter.consult.ConsultProductReqDto;

/**
 * 预约服务接口
 *
 * @author jan
 * @create 2017-09-07 AM11:45
 **/
public interface ConsultService {

    /**
     * 预约产品
     */
    Result<Long> addForProduct(ConsultProductReqDto dto) throws BaseException;

    /**
     * 预约理财师
     */
    Result<Long> addForFP(ConsultFPReqDto dto) throws BaseException;

}
