package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseSmsTemplate;
import com.yundao.tenant.model.base.BaseSmsTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSmsTemplateMapper {
    int countByExample(BaseSmsTemplateExample example);

    int deleteByExample(BaseSmsTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSmsTemplate record);

    int insertSelective(BaseSmsTemplate record);

    List<BaseSmsTemplate> selectByExample(BaseSmsTemplateExample example);

    BaseSmsTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSmsTemplate record, @Param("example") BaseSmsTemplateExample example);

    BaseSmsTemplate selectOne(BaseSmsTemplateExample example);

    int updateByExample(@Param("record") BaseSmsTemplate record, @Param("example") BaseSmsTemplateExample example);

    int updateByPrimaryKeySelective(BaseSmsTemplate record);

    int updateByPrimaryKey(BaseSmsTemplate record);
}