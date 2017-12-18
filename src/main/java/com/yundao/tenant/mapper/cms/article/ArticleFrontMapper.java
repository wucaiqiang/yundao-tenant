package com.yundao.tenant.mapper.cms.article;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.cms.article.front.ArticleFrontHomeListResDto;
import com.yundao.tenant.dto.cms.article.front.ArticleFrontPageResDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jan
 * @create 2017-10-19 11:35
 **/
public interface ArticleFrontMapper {

    /**
     * 获取首页文章列表
     *
     * @param columnId 栏目id
     * @param count    获取条数
     */
    List<ArticleFrontHomeListResDto> selectHomeArticles(@Param("columnId") Long columnId, @Param("count") Integer
            count, @Param("platformCode") String platformCode) throws BaseException;

    /**
     * 获取分页
     */
    List<ArticleFrontPageResDto> selectPage(Map<String, Object> parmas) throws BaseException;

    /**
     * 获取分页总条数
     */
    Integer selectPageCount(Map<String, Object> parmas) throws BaseException;
}
