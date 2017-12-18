package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseSmsAssistantContent;
import com.yundao.tenant.model.base.BaseSmsAssistantContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSmsAssistantContentMapper {
    int countByExample(BaseSmsAssistantContentExample example);

    int deleteByExample(BaseSmsAssistantContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSmsAssistantContent record);

    int insertSelective(BaseSmsAssistantContent record);

    List<BaseSmsAssistantContent> selectByExample(BaseSmsAssistantContentExample example);

    BaseSmsAssistantContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSmsAssistantContent record, @Param("example") BaseSmsAssistantContentExample example);

    BaseSmsAssistantContent selectOne(BaseSmsAssistantContentExample example);

    int updateByExample(@Param("record") BaseSmsAssistantContent record, @Param("example") BaseSmsAssistantContentExample example);

    int updateByPrimaryKeySelective(BaseSmsAssistantContent record);

    int updateByPrimaryKey(BaseSmsAssistantContent record);
}