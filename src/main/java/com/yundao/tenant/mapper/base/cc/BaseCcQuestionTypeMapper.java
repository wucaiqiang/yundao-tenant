package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcQuestionType;
import com.yundao.tenant.model.base.cc.BaseCcQuestionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcQuestionTypeMapper {
    int countByExample(BaseCcQuestionTypeExample example);

    int deleteByExample(BaseCcQuestionTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcQuestionType record);

    int insertSelective(BaseCcQuestionType record);

    List<BaseCcQuestionType> selectByExample(BaseCcQuestionTypeExample example);

    BaseCcQuestionType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcQuestionType record, @Param("example") BaseCcQuestionTypeExample example);

    BaseCcQuestionType selectOne(BaseCcQuestionTypeExample example);

    int updateByExample(@Param("record") BaseCcQuestionType record, @Param("example") BaseCcQuestionTypeExample example);

    int updateByPrimaryKeySelective(BaseCcQuestionType record);

    int updateByPrimaryKey(BaseCcQuestionType record);
}