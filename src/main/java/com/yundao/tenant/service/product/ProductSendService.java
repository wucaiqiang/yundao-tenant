package com.yundao.tenant.service.product;

import com.yundao.core.exception.BaseException;

public interface ProductSendService {
	/**
	 * 产品上线
	 */
    void productOnLine(Long productId)throws BaseException;
    
    /**
     * 添加产品附件
     * @param productId
     */
    void addProductAttach(Long productId,Long attachId,String SourceName,String url)throws BaseException;
    
    /**
     * 待审核产品
     * @param productId
     */
    void auditProduct(Long productId,Long submitUserId,String code)throws BaseException;
}
