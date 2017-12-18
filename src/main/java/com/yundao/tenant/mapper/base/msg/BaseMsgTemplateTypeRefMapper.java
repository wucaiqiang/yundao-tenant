package com.yundao.tenant.mapper.base.msg;

import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeRef;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMsgTemplateTypeRefMapper {
    int countByExample(BaseMsgTemplateTypeRefExample example);

    int deleteByExample(BaseMsgTemplateTypeRefExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseMsgTemplateTypeRef record);

    int insertSelective(BaseMsgTemplateTypeRef record);

    List<BaseMsgTemplateTypeRef> selectByExample(BaseMsgTemplateTypeRefExample example);

    BaseMsgTemplateTypeRef selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseMsgTemplateTypeRef record, @Param("example") BaseMsgTemplateTypeRefExample example);

    BaseMsgTemplateTypeRef selectOne(BaseMsgTemplateTypeRefExample example);

    int updateByExample(@Param("record") BaseMsgTemplateTypeRef record, @Param("example") BaseMsgTemplateTypeRefExample example);

    int updateByPrimaryKeySelective(BaseMsgTemplateTypeRef record);

    int updateByPrimaryKey(BaseMsgTemplateTypeRef record);
}