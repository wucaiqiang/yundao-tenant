package com.yundao.tenant.service.bo;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseFieldType;

/**
 * 业务对象字段类型服务接口
 *
 * @author jan
 * @create 2017-07-06 PM8:42
 **/
public interface FieldTypeService {

    /**
     * 获取字段类型
     *
     * @param code
     */
    BaseFieldType getByCode(String code) throws BaseException;

}
