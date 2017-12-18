package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRel;
import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseWorkflowBusinessRelMapper {
    int countByExample(BaseWorkflowBusinessRelExample example);

    int deleteByExample(BaseWorkflowBusinessRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseWorkflowBusinessRel record);

    int insertSelective(BaseWorkflowBusinessRel record);

    List<BaseWorkflowBusinessRel> selectByExample(BaseWorkflowBusinessRelExample example);

    BaseWorkflowBusinessRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseWorkflowBusinessRel record, @Param("example") BaseWorkflowBusinessRelExample example);

    BaseWorkflowBusinessRel selectOne(BaseWorkflowBusinessRelExample example);

    int updateByExample(@Param("record") BaseWorkflowBusinessRel record, @Param("example") BaseWorkflowBusinessRelExample example);

    int updateByPrimaryKeySelective(BaseWorkflowBusinessRel record);

    int updateByPrimaryKey(BaseWorkflowBusinessRel record);
}