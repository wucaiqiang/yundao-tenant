package com.yundao.tenant.mapper.base.aa;

import com.yundao.tenant.model.base.aa.BaseAaQuestionAnswer;
import com.yundao.tenant.model.base.aa.BaseAaQuestionAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseAaQuestionAnswerMapper {
    int countByExample(BaseAaQuestionAnswerExample example);

    int deleteByExample(BaseAaQuestionAnswerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseAaQuestionAnswer record);

    int insertSelective(BaseAaQuestionAnswer record);

    List<BaseAaQuestionAnswer> selectByExample(BaseAaQuestionAnswerExample example);

    BaseAaQuestionAnswer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseAaQuestionAnswer record, @Param("example") BaseAaQuestionAnswerExample example);

    BaseAaQuestionAnswer selectOne(BaseAaQuestionAnswerExample example);

    int updateByExample(@Param("record") BaseAaQuestionAnswer record, @Param("example") BaseAaQuestionAnswerExample example);

    int updateByPrimaryKeySelective(BaseAaQuestionAnswer record);

    int updateByPrimaryKey(BaseAaQuestionAnswer record);
}