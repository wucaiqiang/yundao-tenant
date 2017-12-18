package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcQuestionAnswer;
import com.yundao.tenant.model.base.cc.BaseCcQuestionAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcQuestionAnswerMapper {
    int countByExample(BaseCcQuestionAnswerExample example);

    int deleteByExample(BaseCcQuestionAnswerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcQuestionAnswer record);

    int insertSelective(BaseCcQuestionAnswer record);

    List<BaseCcQuestionAnswer> selectByExample(BaseCcQuestionAnswerExample example);

    BaseCcQuestionAnswer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcQuestionAnswer record, @Param("example") BaseCcQuestionAnswerExample example);

    BaseCcQuestionAnswer selectOne(BaseCcQuestionAnswerExample example);

    int updateByExample(@Param("record") BaseCcQuestionAnswer record, @Param("example") BaseCcQuestionAnswerExample example);

    int updateByPrimaryKeySelective(BaseCcQuestionAnswer record);

    int updateByPrimaryKey(BaseCcQuestionAnswer record);
}