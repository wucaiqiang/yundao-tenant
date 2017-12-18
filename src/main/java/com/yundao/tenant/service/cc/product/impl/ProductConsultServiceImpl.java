package com.yundao.tenant.service.cc.product.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.mapper.base.cc.BaseCcProductConsultMapper;
import com.yundao.tenant.model.base.cc.BaseCcProductConsult;
import com.yundao.tenant.service.cc.product.ProductConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 产品预约咨询服务实现
 *
 * @author jan
 * @create 2017-09-18 PM8:40
 **/
@Service
public class ProductConsultServiceImpl extends AbstractService implements ProductConsultService {

    @Autowired
    private BaseCcProductConsultMapper baseCcProductConsultMapper;

    @Override
    public void insert(Long customerId, Long productId) throws BaseException {
        BaseCcProductConsult model = new BaseCcProductConsult();
        super.initialModel(model);
        model.setConsultDate(new Date());
        model.setCustomerId(customerId);
        model.setProductId(productId);
        baseCcProductConsultMapper.insertSelective(model);
    }
}
