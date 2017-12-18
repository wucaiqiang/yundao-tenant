package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseOperationLog;
import com.yundao.tenant.model.base.BaseOperationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseOperationLogMapper {
    int countByExample(BaseOperationLogExample example);

    int deleteByExample(BaseOperationLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseOperationLog record);

    int insertSelective(BaseOperationLog record);

    List<BaseOperationLog> selectByExample(BaseOperationLogExample example);

    BaseOperationLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseOperationLog record, @Param("example") BaseOperationLogExample example);

    BaseOperationLog selectOne(BaseOperationLogExample example);

    int updateByExample(@Param("record") BaseOperationLog record, @Param("example") BaseOperationLogExample example);

    int updateByPrimaryKeySelective(BaseOperationLog record);

    int updateByPrimaryKey(BaseOperationLog record);
}