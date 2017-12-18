package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcQuestionOption;
import com.yundao.tenant.model.base.cc.BaseCcQuestionOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcQuestionOptionMapper {
    int countByExample(BaseCcQuestionOptionExample example);

    int deleteByExample(BaseCcQuestionOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcQuestionOption record);

    int insertSelective(BaseCcQuestionOption record);

    List<BaseCcQuestionOption> selectByExample(BaseCcQuestionOptionExample example);

    BaseCcQuestionOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcQuestionOption record, @Param("example") BaseCcQuestionOptionExample example);

    BaseCcQuestionOption selectOne(BaseCcQuestionOptionExample example);

    int updateByExample(@Param("record") BaseCcQuestionOption record, @Param("example") BaseCcQuestionOptionExample example);

    int updateByPrimaryKeySelective(BaseCcQuestionOption record);

    int updateByPrimaryKey(BaseCcQuestionOption record);
}