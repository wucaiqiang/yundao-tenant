package com.yundao.tenant.mapper.field;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.field.DataObjectFieldDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataObjectFieldMapper {

    /**
     * 获取数据对象字段
     */
    List<DataObjectFieldDto> selectDataObjectFields() throws BaseException;

    /**
     * 根据code查询
     */
    List<DataObjectFieldDto> selectByCodes(@Param("codes") List<String> codes) throws BaseException;

}
