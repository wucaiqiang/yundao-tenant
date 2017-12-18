package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseBusinessObject;
import com.yundao.tenant.model.base.BaseBusinessObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseBusinessObjectMapper {
    int countByExample(BaseBusinessObjectExample example);

    int deleteByExample(BaseBusinessObjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseBusinessObject record);

    int insertSelective(BaseBusinessObject record);

    List<BaseBusinessObject> selectByExample(BaseBusinessObjectExample example);

    BaseBusinessObject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseBusinessObject record, @Param("example") BaseBusinessObjectExample example);

    BaseBusinessObject selectOne(BaseBusinessObjectExample example);

    int updateByExample(@Param("record") BaseBusinessObject record, @Param("example") BaseBusinessObjectExample example);

    int updateByPrimaryKeySelective(BaseBusinessObject record);

    int updateByPrimaryKey(BaseBusinessObject record);
}