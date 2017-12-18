package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcQuestionScore;
import com.yundao.tenant.model.base.cc.BaseCcQuestionScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcQuestionScoreMapper {
    int countByExample(BaseCcQuestionScoreExample example);

    int deleteByExample(BaseCcQuestionScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcQuestionScore record);

    int insertSelective(BaseCcQuestionScore record);

    List<BaseCcQuestionScore> selectByExample(BaseCcQuestionScoreExample example);

    BaseCcQuestionScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcQuestionScore record, @Param("example") BaseCcQuestionScoreExample example);

    BaseCcQuestionScore selectOne(BaseCcQuestionScoreExample example);

    int updateByExample(@Param("record") BaseCcQuestionScore record, @Param("example") BaseCcQuestionScoreExample example);

    int updateByPrimaryKeySelective(BaseCcQuestionScore record);

    int updateByPrimaryKey(BaseCcQuestionScore record);
}