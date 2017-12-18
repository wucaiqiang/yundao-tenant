package com.yundao.tenant.service.field.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.mapper.base.BaseFieldMapper;
import com.yundao.tenant.model.base.BaseField;
import com.yundao.tenant.model.base.BaseFieldExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.field.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jan
 * @create 2017-07-12 PM9:01
 **/
@Service
public class FieldServiceImpl extends AbstractService implements FieldService {

    private static Log log = LogFactory.getLog(FieldService.class);

    @Autowired
    private BaseFieldMapper baseFieldsMapper;

    @Override
    public Long add(String name, String fieldTypecode) throws BaseException {
        log.begin(name, fieldTypecode);
        BaseField field = new BaseField();
        super.initialModel(field);
        field.setName(name);
        baseFieldsMapper.insertSelective(field);
        field.setCode(this.getCode(fieldTypecode, field.getId()));
        baseFieldsMapper.updateByPrimaryKeySelective(field);
        log.end();
        return field.getId();
    }

    @Override
    public long updateName(Long id, String name) throws BaseException {
        log.begin(id, name);
        BaseField field = baseFieldsMapper.selectByPrimaryKey(id);
        super.updateModel(field);
        field.setName(name);
        baseFieldsMapper.updateByPrimaryKeySelective(field);
        return id;
    }

    @Override
    public List<BaseField> getsByIds(List<Long> ids) throws BaseException {
        log.begin(ids);
        BaseFieldExample example = new BaseFieldExample();
        example.createCriteria().andIdIn(ids);
        List<BaseField> fields = baseFieldsMapper.selectByExample(example);
        log.end();
        return fields;
    }

    /**
     * 获取字段编码
     *
     * @param fieldTypeCode 字段类型编码
     * @param fieldId       字段id
     */
    private String getCode(String fieldTypeCode, Long fieldId) {
        return fieldTypeCode + "_field_" + fieldId;
    }
}
