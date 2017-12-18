package com.yundao.tenant.mapper.base.cms.article;

import com.yundao.tenant.model.base.cms.article.BaseArticle;
import com.yundao.tenant.model.base.cms.article.BaseArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseArticleMapper {
    int countByExample(BaseArticleExample example);

    int deleteByExample(BaseArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseArticle record);

    int insertSelective(BaseArticle record);

    List<BaseArticle> selectByExample(BaseArticleExample example);

    BaseArticle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseArticle record, @Param("example") BaseArticleExample example);

    BaseArticle selectOne(BaseArticleExample example);

    int updateByExample(@Param("record") BaseArticle record, @Param("example") BaseArticleExample example);

    int updateByPrimaryKeySelective(BaseArticle record);

    int updateByPrimaryKey(BaseArticle record);
}