package com.yundao.tenant.service.field;

import java.util.List;
import java.util.Map;

import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FieldValueValidateFailResultDto;

public interface FieldValueValidateService {
    public List<FieldValueValidateFailResultDto> validateFieldValue(List<FieldDto> list,Map<String, String> allParams)throws  Exception;
}
