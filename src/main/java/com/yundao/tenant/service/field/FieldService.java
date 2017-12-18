package com.yundao.tenant.service.field;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseField;

import java.util.List;

/**
 * 字段服务接口
 *
 * @author jan
 * @create 2017-07-12 PM8:59
 **/
public interface FieldService {

    /**
     * 添加字段
     *
     * @param name          名称
     * @param fieldTypecode 字段类型编码
     */
    Long add(String name, String fieldTypecode) throws BaseException;

    /**
     * 更新名称
     *
     * @param id   id
     * @param name 名称
     */
    long updateName(Long id, String name) throws BaseException;

    /**
     * 根据多个id获取列表
     *
     * @param ids id列表
     */
    List<BaseField> getsByIds(List<Long> ids) throws BaseException;
}
