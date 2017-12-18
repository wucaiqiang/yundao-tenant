package com.yundao.tenant.service.cc.product;

import com.yundao.core.exception.BaseException;

/**
 * 产品预约咨询服务接口
 *
 * @author jan
 * @create 2017-09-18 PM8:39
 **/
public interface ProductConsultService {

    /**
     * 插入
     *
     * @param customerId 客户id
     * @param productId  产品id
     */
    void insert(Long customerId, Long productId) throws BaseException;

}
