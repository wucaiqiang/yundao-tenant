package com.yundao.tenant.service.select;

import java.util.List;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.select.SelectConfigDto;
import com.yundao.tenant.model.base.BaseSelectConfig;

/**
 * 选项服务接口
 *
 * @author jan
 * @create 2017-07-16 PM6:00
 **/
public interface SelectConfigService {

    /**
     * 获取所有选项数据
     */
    List<SelectConfigDto> gets() throws BaseException;
    BaseSelectConfig getByFieldIdAndValue(Long fieldId,Integer value)throws BaseException;
    SelectConfigDto getByFieldCodeAndValue(String fieldCode,Integer value)throws BaseException;
}
