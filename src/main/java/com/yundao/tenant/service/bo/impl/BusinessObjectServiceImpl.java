package com.yundao.tenant.service.bo.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.mapper.base.BaseBusinessObjectMapper;
import com.yundao.tenant.model.base.BaseBusinessObject;
import com.yundao.tenant.model.base.BaseBusinessObjectExample;
import com.yundao.tenant.service.bo.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gjl on 2017/7/6.
 */
@Service
public class BusinessObjectServiceImpl implements BusinessObjectService {

    private static Log log = LogFactory.getLog(BusinessObjectServiceImpl.class);

    @Autowired
    private BaseBusinessObjectMapper baseBusinessObjectMapper;
    /**
     * 根据编码获取业务对象
     *
     * @param code 业务对象编码
     */
    @Override
    public BaseBusinessObject getBusinessObjectByCode(String code) throws BaseException {
        log.begin(code);
        //根据业务对象模块 CODE 查询id
        BaseBusinessObjectExample businessObjectExample = new BaseBusinessObjectExample();
        businessObjectExample.createCriteria().andCodeEqualTo(code);
        BaseBusinessObject bussinessObject = baseBusinessObjectMapper.selectOne(businessObjectExample);
        log.info("bussinessObject:%s", JsonUtils.objectToJson(bussinessObject));
        return bussinessObject;
    }
}
