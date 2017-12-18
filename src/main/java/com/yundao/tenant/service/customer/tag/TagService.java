package com.yundao.tenant.service.customer.tag;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.customer.tag.TagReqDto;
import com.yundao.tenant.model.base.customer.BaseTag;

import java.util.List;

public interface TagService {

    public Result<Integer> add(TagReqDto reqDto) throws Exception;

    public Result<Integer> update(TagReqDto reqDto) throws Exception;

    public Result<Integer> delete(Long id) throws Exception;

    public Result<BaseTag> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseTag>> getPage(TagReqDto tagReqDto) throws Exception;

    Result<List<BaseTag>> getTop(Integer limit) throws Exception;

    Result<List<BaseTag>> getAll() throws Exception;

    Result<Boolean> processSetCustomerTag(Long customerId, String tags) throws Exception;

    Result<List<BaseTag>> getCustomerTag(Long customerId) throws BaseException;

    /**
     * 根据名称，获取客户id集合
     *
     * @param tags 标签名称
     */
    List<Long> getCustomerIdLikeNames(List<String> tags) throws BaseException;
}

