package com.yundao.tenant.mapper.base.aa;

import com.yundao.tenant.model.base.aa.BaseAaQuestionScore;
import com.yundao.tenant.model.base.aa.BaseAaQuestionScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseAaQuestionScoreMapper {
    int countByExample(BaseAaQuestionScoreExample example);

    int deleteByExample(BaseAaQuestionScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseAaQuestionScore record);

    int insertSelective(BaseAaQuestionScore record);

    List<BaseAaQuestionScore> selectByExample(BaseAaQuestionScoreExample example);

    BaseAaQuestionScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseAaQuestionScore record, @Param("example") BaseAaQuestionScoreExample example);

    BaseAaQuestionScore selectOne(BaseAaQuestionScoreExample example);

    int updateByExample(@Param("record") BaseAaQuestionScore record, @Param("example") BaseAaQuestionScoreExample example);

    int updateByPrimaryKeySelective(BaseAaQuestionScore record);

    int updateByPrimaryKey(BaseAaQuestionScore record);
}