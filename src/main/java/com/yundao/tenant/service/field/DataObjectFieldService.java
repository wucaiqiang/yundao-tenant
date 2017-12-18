package com.yundao.tenant.service.field;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.field.DataObjectFieldDto;

import java.util.List;

/**
 * 数据对象字段服务接口
 *
 * @author jan
 * @create 2017-07-13 PM3:24
 **/
public interface DataObjectFieldService {

    /**
     * 根据code获取
     */
    List<DataObjectFieldDto> getByCodes(List<String> codes) throws BaseException;
}
