package com.yundao.tenant.service.product;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;

public interface ProductStatusService {

	/**
	 * 修改产品状态
	 * @param productId
	 * @param productManagerAction
	 * @return
	 * @throws BaseException
	 */
	 public Result<Integer> updateProductStatus(Long productId,Integer productManagerAction,Integer declaractionModel,String reason)throws BaseException;
}
