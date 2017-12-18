package com.yundao.tenant.mapper.select;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.field.DataObjectFieldDto;
import com.yundao.tenant.dto.select.SelectConfigDto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SelectConfigMapper {

    /**
     * 获取所有选项数据
     */
    List<SelectConfigDto> selectList() throws BaseException;
    List<SelectConfigDto> selectByFieldCodeAndValue(@Param("fieldCode") String fieldCode,@Param("value") Integer value) throws BaseException;

}
