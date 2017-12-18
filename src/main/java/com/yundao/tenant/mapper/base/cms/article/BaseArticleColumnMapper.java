package com.yundao.tenant.mapper.base.cms.article;

import com.yundao.tenant.model.base.cms.article.BaseArticleColumn;
import com.yundao.tenant.model.base.cms.article.BaseArticleColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseArticleColumnMapper {
    int countByExample(BaseArticleColumnExample example);

    int deleteByExample(BaseArticleColumnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseArticleColumn record);

    int insertSelective(BaseArticleColumn record);

    List<BaseArticleColumn> selectByExample(BaseArticleColumnExample example);

    BaseArticleColumn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseArticleColumn record, @Param("example") BaseArticleColumnExample example);

    BaseArticleColumn selectOne(BaseArticleColumnExample example);

    int updateByExample(@Param("record") BaseArticleColumn record, @Param("example") BaseArticleColumnExample example);

    int updateByPrimaryKeySelective(BaseArticleColumn record);

    int updateByPrimaryKey(BaseArticleColumn record);
}