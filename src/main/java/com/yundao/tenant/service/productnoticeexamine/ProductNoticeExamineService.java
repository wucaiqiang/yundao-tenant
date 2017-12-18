package com.yundao.tenant.service.productnoticeexamine;

import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeExaminePageReqDto;
import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeExamineResDto;
import com.yundao.tenant.model.base.product.BaseProductNoticeExamine;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;


public interface ProductNoticeExamineService{


    public Result<Integer> add(BaseProductNoticeExamine productNoticeExamine) throws Exception;


    public Result<Integer> update(BaseProductNoticeExamine productNoticeExamine) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseProductNoticeExamine> get(Long id) throws Exception;

    public Result<PaginationSupport<ProductNoticeExamineResDto>> getPage(ProductNoticeExaminePageReqDto baseProductNoticeExamine) throws Exception;

}
