package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseDataObjectAccess;
import com.yundao.tenant.model.base.BaseDataObjectAccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDataObjectAccessMapper {
    int countByExample(BaseDataObjectAccessExample example);

    int deleteByExample(BaseDataObjectAccessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDataObjectAccess record);

    int insertSelective(BaseDataObjectAccess record);

    List<BaseDataObjectAccess> selectByExample(BaseDataObjectAccessExample example);

    BaseDataObjectAccess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDataObjectAccess record, @Param("example") BaseDataObjectAccessExample example);

    BaseDataObjectAccess selectOne(BaseDataObjectAccessExample example);

    int updateByExample(@Param("record") BaseDataObjectAccess record, @Param("example") BaseDataObjectAccessExample example);

    int updateByPrimaryKeySelective(BaseDataObjectAccess record);

    int updateByPrimaryKey(BaseDataObjectAccess record);
}