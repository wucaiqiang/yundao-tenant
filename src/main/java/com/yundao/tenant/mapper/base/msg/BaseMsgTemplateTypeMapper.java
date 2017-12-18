package com.yundao.tenant.mapper.base.msg;

import com.yundao.tenant.model.base.msg.BaseMsgTemplateType;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMsgTemplateTypeMapper {
    int countByExample(BaseMsgTemplateTypeExample example);

    int deleteByExample(BaseMsgTemplateTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseMsgTemplateType record);

    int insertSelective(BaseMsgTemplateType record);

    List<BaseMsgTemplateType> selectByExample(BaseMsgTemplateTypeExample example);

    BaseMsgTemplateType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseMsgTemplateType record, @Param("example") BaseMsgTemplateTypeExample example);

    BaseMsgTemplateType selectOne(BaseMsgTemplateTypeExample example);

    int updateByExample(@Param("record") BaseMsgTemplateType record, @Param("example") BaseMsgTemplateTypeExample example);

    int updateByPrimaryKeySelective(BaseMsgTemplateType record);

    int updateByPrimaryKey(BaseMsgTemplateType record);
}