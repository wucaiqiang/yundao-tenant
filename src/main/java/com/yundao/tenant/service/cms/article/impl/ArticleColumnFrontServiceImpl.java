package com.yundao.tenant.service.cms.article.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.mapper.base.cms.article.BaseArticleColumnMapper;
import com.yundao.tenant.model.base.cms.article.BaseArticleColumn;
import com.yundao.tenant.model.base.cms.article.BaseArticleColumnExample;
import com.yundao.tenant.service.cms.article.ArticleColumnFrontService;
import com.yundao.tenant.service.platform.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章栏目服务实现
 *
 * @author jan
 * @create 2017-10-28 16:23
 **/
@Service
public class ArticleColumnFrontServiceImpl implements ArticleColumnFrontService {

    private static Log log = LogFactory.getLog(ArticleColumnFrontServiceImpl.class);

    @Autowired
    private BaseArticleColumnMapper baseArticleColumnMapper;

    @Autowired
    private PlatformService platformService;

    @Override
    public BaseArticleColumn get(String code, String platformCode) throws BaseException {
        String logPrefix = "前端文章栏目||获取单个栏目||";
        log.info("%s code：%s platformCode：%s", logPrefix, code, platformCode);

        Long platformId = platformService.getId(platformCode);
        log.info("%s platformId %s", logPrefix, platformId);

        BaseArticleColumnExample example = new BaseArticleColumnExample();
        example.createCriteria().andStatusEqualTo(EnabledEnum.ENABLED.getValue()).andPlatformIdEqualTo(platformId)
                .andCodeEqualTo(code);
        BaseArticleColumn articleColumn = baseArticleColumnMapper.selectOne(example);
        return articleColumn;
    }
}
