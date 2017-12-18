package com.yundao.tenant.service.operation.visit;

import com.yundao.core.exception.BaseException;

/**
 * 回访管理
 *
 * @author 欧阳利
 *         2017年8月25日
 */
public interface CustomerVisitService {

    /**
     * 客户发送消息回访
     *
     * @param id 回访id
     * @throws BaseException
     */
    void visitCustomerSendMessage(Long id) throws BaseException;


    /**
     * 创建下次回访记录
     *
     * @param messageId
     * @throws BaseException
     */
    void doNextVisitCustomerSendMessage() throws Exception;
}
