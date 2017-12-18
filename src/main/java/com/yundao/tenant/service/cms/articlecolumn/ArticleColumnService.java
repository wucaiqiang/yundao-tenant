package com.yundao.tenant.service.cms.articlecolumn;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.cms.articlecolumn.*;
import com.yundao.tenant.model.base.cms.article.BaseArticleColumn;

import java.util.List;


public interface ArticleColumnService {


    public Result<Long> add(ArticleColumnReqDto reqDto) throws Exception;


    public Result<Integer> update(ArticleColumnUPReqDto reqDto) throws Exception;


    public Result<Integer> delete(String ids) throws Exception;


    public Result<BaseArticleColumn> get(Long id) throws Exception;

    public Result<PaginationSupport<ArticleColumnPageResDto>> getPage(ArticleColumnPageReqDto articleColumnReqDto, AbstractBasePageDto pageDto) throws Exception;

    Result<Integer> updateStatus(Long id, Integer status) throws BaseException;

    /**
     * 文章栏目下拉数据
     *
     * @param platformId 平台id
     */
    Result<List<ArticleColumnSelectDto>> getSelectOption(Long platformId) throws BaseException;

    List<BaseArticleColumn> getList(String platformCode, Integer count) throws BaseException;
}
