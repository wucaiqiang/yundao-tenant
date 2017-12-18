package com.yundao.tenant.mapper.base.cms.article;

import com.yundao.tenant.model.base.cms.article.BaseArticleColumnRel;
import com.yundao.tenant.model.base.cms.article.BaseArticleColumnRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseArticleColumnRelMapper {
    int countByExample(BaseArticleColumnRelExample example);

    int deleteByExample(BaseArticleColumnRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseArticleColumnRel record);

    int insertSelective(BaseArticleColumnRel record);

    List<BaseArticleColumnRel> selectByExample(BaseArticleColumnRelExample example);

    BaseArticleColumnRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseArticleColumnRel record, @Param("example") BaseArticleColumnRelExample example);

    BaseArticleColumnRel selectOne(BaseArticleColumnRelExample example);

    int updateByExample(@Param("record") BaseArticleColumnRel record, @Param("example") BaseArticleColumnRelExample example);

    int updateByPrimaryKeySelective(BaseArticleColumnRel record);

    int updateByPrimaryKey(BaseArticleColumnRel record);
}