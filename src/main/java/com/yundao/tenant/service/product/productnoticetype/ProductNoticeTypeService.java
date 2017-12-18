package com.yundao.tenant.service.product.productnoticetype;

import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.model.base.product.BaseProductNoticeType;

import java.util.List;


public interface ProductNoticeTypeService{


    public Result<Long> add(BaseProductNoticeType productNoticeType) throws Exception;


    public Result<Integer> update(BaseProductNoticeType productNoticeType) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseProductNoticeType> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseProductNoticeType>> getPage(BaseProductNoticeType baseProductNoticeType, AbstractBasePageDto pageDto) throws Exception;

    Result<List<BaseProductNoticeType>> getAll() throws Exception;
}
