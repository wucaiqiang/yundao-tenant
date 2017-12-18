package com.yundao.tenant.service.bo;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.bo.ObjectFieldDetailResDto;
import com.yundao.tenant.dto.bo.ObjectFieldPageReqDto;
import com.yundao.tenant.dto.bo.ObjectFieldPageResDto;
import com.yundao.tenant.dto.bo.ObjectFieldSimpleResDto;
import com.yundao.tenant.model.base.BaseBusinessObject;

import java.util.List;


/**
 * 业务对象字段服务接口
 *
 * @author gjl
 * @create 2017-07-04 AM10:19
 **/
public interface BusinessObjectService {
    /**
     * 通过code获取业务对象
     * @param code
     * @return
     * @throws BaseException
     */
    public BaseBusinessObject getBusinessObjectByCode(String code) throws BaseException;
}
