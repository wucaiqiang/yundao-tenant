package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseResource;
import com.yundao.tenant.model.base.BaseResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseResourceMapper {
    int countByExample(BaseResourceExample example);

    int deleteByExample(BaseResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseResource record);

    int insertSelective(BaseResource record);

    List<BaseResource> selectByExample(BaseResourceExample example);

    BaseResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseResource record, @Param("example") BaseResourceExample example);

    BaseResource selectOne(BaseResourceExample example);

    int updateByExample(@Param("record") BaseResource record, @Param("example") BaseResourceExample example);

    int updateByPrimaryKeySelective(BaseResource record);

    int updateByPrimaryKey(BaseResource record);
}