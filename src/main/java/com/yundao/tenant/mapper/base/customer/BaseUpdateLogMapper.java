package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseUpdateLog;
import com.yundao.tenant.model.base.customer.BaseUpdateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUpdateLogMapper {
    int countByExample(BaseUpdateLogExample example);

    int deleteByExample(BaseUpdateLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUpdateLog record);

    int insertSelective(BaseUpdateLog record);

    List<BaseUpdateLog> selectByExample(BaseUpdateLogExample example);

    BaseUpdateLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUpdateLog record, @Param("example") BaseUpdateLogExample example);

    BaseUpdateLog selectOne(BaseUpdateLogExample example);

    int updateByExample(@Param("record") BaseUpdateLog record, @Param("example") BaseUpdateLogExample example);

    int updateByPrimaryKeySelective(BaseUpdateLog record);

    int updateByPrimaryKey(BaseUpdateLog record);
}