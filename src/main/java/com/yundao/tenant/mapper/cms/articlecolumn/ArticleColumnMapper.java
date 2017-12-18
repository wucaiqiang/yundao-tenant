package com.yundao.tenant.mapper.cms.articlecolumn;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.cms.articlecolumn.ArticleColumnPageResDto;
import com.yundao.tenant.model.base.cms.article.BaseArticleColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleColumnMapper{

    int queryPageCount(Map<String, Object> params);

    List<ArticleColumnPageResDto> queryPageInfo(Map<String, Object> params);

    List<BaseArticleColumn> selectList(@Param("platformCode") String platformCode, @Param("count") Integer count) throws
            BaseException;
}
