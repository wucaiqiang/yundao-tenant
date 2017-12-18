package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcQuestion;
import com.yundao.tenant.model.base.cc.BaseCcQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcQuestionMapper {
    int countByExample(BaseCcQuestionExample example);

    int deleteByExample(BaseCcQuestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcQuestion record);

    int insertSelective(BaseCcQuestion record);

    List<BaseCcQuestion> selectByExample(BaseCcQuestionExample example);

    BaseCcQuestion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcQuestion record, @Param("example") BaseCcQuestionExample example);

    BaseCcQuestion selectOne(BaseCcQuestionExample example);

    int updateByExample(@Param("record") BaseCcQuestion record, @Param("example") BaseCcQuestionExample example);

    int updateByPrimaryKeySelective(BaseCcQuestion record);

    int updateByPrimaryKey(BaseCcQuestion record);
}