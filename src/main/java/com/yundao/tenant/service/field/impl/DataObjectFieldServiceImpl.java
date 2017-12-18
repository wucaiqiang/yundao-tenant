package com.yundao.tenant.service.field.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.dto.field.DataObjectFieldDto;
import com.yundao.tenant.mapper.field.DataObjectFieldMapper;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.field.DataObjectFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据对象字段服务实现
 *
 * @author jan
 * @create 2017-07-13 PM3:25
 **/
@Service
public class DataObjectFieldServiceImpl extends AbstractService implements DataObjectFieldService {

    private static Log log = LogFactory.getLog(DataObjectFieldServiceImpl.class);

    @Autowired
    private DataObjectFieldMapper dataObjectFieldMapper;

    @Override
    public List<DataObjectFieldDto> getByCodes(List<String> codes) throws BaseException {
        return dataObjectFieldMapper.selectByCodes(codes);
    }
}
