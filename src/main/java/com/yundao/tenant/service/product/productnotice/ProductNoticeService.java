package com.yundao.tenant.service.product.productnotice;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.productnotice.ProductNoticePageReqDto;
import com.yundao.tenant.dto.productnotice.ProductNoticeReqDto;
import com.yundao.tenant.model.base.product.BaseProductNotice;
import com.yundao.tenant.model.productnotice.ProductNoticeModel;


public interface ProductNoticeService{


    public Result<Integer> add(ProductNoticeReqDto productNotice) throws Exception;


    public Result<Integer> update(ProductNoticeReqDto productNotice) throws Exception;


    public Result<PermissionResultDto> delete(String ids) throws Exception;


    public Result<BaseProductNotice> get(Long id) throws BaseException;

    public Result<PaginationSupport<ProductNoticeModel>> getPage(ProductNoticePageReqDto baseProductNotice, AbstractBasePageDto pageDto) throws Exception;
    public Result<List<ProductNoticeModel>> getList(Long productId,Integer isSend) throws Exception;

    Result<Integer> processFlow(Long id, Integer status, String reason) throws BaseException;

    Result<Long> processQrtzNotice() throws Exception;

    Result<List<BaseProductNotice>> getIds(String ids);
}
