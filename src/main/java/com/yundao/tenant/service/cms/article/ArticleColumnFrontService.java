package com.yundao.tenant.service.cms.article;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.cms.article.BaseArticleColumn;

/**
 * 文章服务栏目接口
 *
 * @author jan
 * @create 2017-10-28 16:22
 **/
public interface ArticleColumnFrontService {

    BaseArticleColumn get(String code, String platformCode) throws BaseException;

}
