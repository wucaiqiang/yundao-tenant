package com.yundao.tenant.service.cms.article;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.cms.article.*;
import com.yundao.tenant.dto.common.PermissionResultDto;

/**
 * 文章服务接口
 *
 * @author jan
 * @create 2017-10-21 09:52
 **/
public interface ArticleService {

    /**
     * 获取分页数据
     */
    Result<PaginationSupport<ArticlePageResDto>> getPage(ArticlePageReqDto dto) throws BaseException;

    /**
     * 删除
     */
    Result<PermissionResultDto> delete(ArticleDeleteReqDto dto) throws BaseException;

    /**
     * 新增
     * @param dto
     * @return
     */
    Result<Long> add(ArticleAddReqDto dto) throws BaseException;

    /**
     * 修改
     * @param dto
     * @return
     */
    Result<Long> update(ArticleUpdateReqDto dto) throws BaseException;

    /**
     * 获取单个详情
     * @param id
     * @return
     */
    Result<ArticleDetailResDto> get(Long id) throws BaseException;
}
