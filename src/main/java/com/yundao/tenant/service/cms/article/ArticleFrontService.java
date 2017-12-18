package com.yundao.tenant.service.cms.article;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.cms.article.ArticleCodeDto;
import com.yundao.tenant.dto.cms.article.column.ArticleColumnFrontListResDto;
import com.yundao.tenant.dto.cms.article.front.*;

import java.util.List;

/**
 * 前端文章服务接口
 *
 * @author jan
 * @create 2017-10-19 09:09
 **/
public interface ArticleFrontService {

    /**
     * 获取首页文章列表
     */
    Result<List<ArticleFrontHomeResDto>> getHomeList(ArticleFrontHomeListReqDto dto) throws BaseException;

    /**
     * 增加浏览量
     */
    Result<Boolean> doPageViewPlus(ArticleCodeDto dto) throws BaseException;

    /**
     * 获取前端文章列表
     */
    Result<PaginationSupport<ArticleFrontPageResDto>> getPage(ArticleFrontPageReqDto dto) throws BaseException;

    /**
     * 获取栏目列表
     */
    Result<List<ArticleColumnFrontListResDto>> getColumns() throws BaseException;

    /**
     * 获取文章详情
     */
    Result<ArticleFrontDetailDto> get(ArticleFrontDetailReqDto dto) throws BaseException;

    /**
     * 获取文章栏目详情
     */
    Result<ArticleFrontColumnDetailDto> getColumnDetail(ArticleFrontColumnDetailReqDto dto) throws BaseException;
}
