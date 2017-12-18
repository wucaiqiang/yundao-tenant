package com.yundao.tenant.service.bo.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.mapper.base.BaseFieldTypeMapper;
import com.yundao.tenant.model.base.BaseFieldType;
import com.yundao.tenant.model.base.BaseFieldTypeExample;
import com.yundao.tenant.service.bo.FieldTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务对象字段类型服务
 *
 * @author jan
 * @create 2017-07-06 PM8:44
 **/
@Service
public class FieldTypeServiceImpl implements FieldTypeService {

    @Autowired
    private BaseFieldTypeMapper baseFieldTypeMapper;

    @Override
    public BaseFieldType getByCode(String code) throws BaseException {
        BaseFieldTypeExample example = new BaseFieldTypeExample();
        example.createCriteria().andCodeEqualTo(code);
        return baseFieldTypeMapper.selectOne(example);
    }
}
