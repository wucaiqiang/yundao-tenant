package com.yundao.tenant.mapper.cms.article;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.cms.article.ArticleColumnRelInfoDto;
import com.yundao.tenant.dto.cms.article.ArticlePageResDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 文章
 *
 * @author jan
 * @create 2017-10-19 11:35
 **/
public interface ArticleMapper {

    /**
     * 获取分页
     */
    List<ArticlePageResDto> selectPage(Map<String, Object> parmas) throws BaseException;

    /**
     * 获取分页总条数
     */
    Integer selectPageCount(Map<String, Object> parmas) throws BaseException;

    /**
     * 获取每篇文章对应的目录信息
     *
     * @param articleIds 文章id集合
     */
    List<ArticleColumnRelInfoDto> selectArticleColumnRelInfo(@Param("articleIds") List<Long> articleIds) throws
            BaseException;
}
