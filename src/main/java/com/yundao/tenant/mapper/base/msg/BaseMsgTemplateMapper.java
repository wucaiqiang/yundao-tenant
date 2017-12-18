package com.yundao.tenant.mapper.base.msg;

import com.yundao.tenant.model.base.msg.BaseMsgTemplate;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMsgTemplateMapper {
    int countByExample(BaseMsgTemplateExample example);

    int deleteByExample(BaseMsgTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseMsgTemplate record);

    int insertSelective(BaseMsgTemplate record);

    List<BaseMsgTemplate> selectByExample(BaseMsgTemplateExample example);

    BaseMsgTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseMsgTemplate record, @Param("example") BaseMsgTemplateExample example);

    BaseMsgTemplate selectOne(BaseMsgTemplateExample example);

    int updateByExample(@Param("record") BaseMsgTemplate record, @Param("example") BaseMsgTemplateExample example);

    int updateByPrimaryKeySelective(BaseMsgTemplate record);

    int updateByPrimaryKey(BaseMsgTemplate record);
}