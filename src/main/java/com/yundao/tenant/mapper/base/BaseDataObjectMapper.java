package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseDataObject;
import com.yundao.tenant.model.base.BaseDataObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDataObjectMapper {
    int countByExample(BaseDataObjectExample example);

    int deleteByExample(BaseDataObjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDataObject record);

    int insertSelective(BaseDataObject record);

    List<BaseDataObject> selectByExample(BaseDataObjectExample example);

    BaseDataObject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDataObject record, @Param("example") BaseDataObjectExample example);

    BaseDataObject selectOne(BaseDataObjectExample example);

    int updateByExample(@Param("record") BaseDataObject record, @Param("example") BaseDataObjectExample example);

    int updateByPrimaryKeySelective(BaseDataObject record);

    int updateByPrimaryKey(BaseDataObject record);
}