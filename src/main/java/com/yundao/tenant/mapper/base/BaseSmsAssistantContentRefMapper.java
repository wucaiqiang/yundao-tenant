package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseSmsAssistantContentRef;
import com.yundao.tenant.model.base.BaseSmsAssistantContentRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSmsAssistantContentRefMapper {
    int countByExample(BaseSmsAssistantContentRefExample example);

    int deleteByExample(BaseSmsAssistantContentRefExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSmsAssistantContentRef record);

    int insertSelective(BaseSmsAssistantContentRef record);

    List<BaseSmsAssistantContentRef> selectByExample(BaseSmsAssistantContentRefExample example);

    BaseSmsAssistantContentRef selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSmsAssistantContentRef record, @Param("example") BaseSmsAssistantContentRefExample example);

    BaseSmsAssistantContentRef selectOne(BaseSmsAssistantContentRefExample example);

    int updateByExample(@Param("record") BaseSmsAssistantContentRef record, @Param("example") BaseSmsAssistantContentRefExample example);

    int updateByPrimaryKeySelective(BaseSmsAssistantContentRef record);

    int updateByPrimaryKey(BaseSmsAssistantContentRef record);
}