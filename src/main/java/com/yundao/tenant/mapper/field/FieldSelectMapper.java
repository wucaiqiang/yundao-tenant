package com.yundao.tenant.mapper.field;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.field.FiledSelectDetailDto;

public interface FieldSelectMapper {
	List<FiledSelectDetailDto> getFiledSelectDetails(@Param("fieldNames")List<String> fieldNames);
}
