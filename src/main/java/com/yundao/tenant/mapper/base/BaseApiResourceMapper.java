package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseApiResource;
import com.yundao.tenant.model.base.BaseApiResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseApiResourceMapper {
    int countByExample(BaseApiResourceExample example);

    int deleteByExample(BaseApiResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseApiResource record);

    int insertSelective(BaseApiResource record);

    List<BaseApiResource> selectByExample(BaseApiResourceExample example);

    BaseApiResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseApiResource record, @Param("example") BaseApiResourceExample example);

    BaseApiResource selectOne(BaseApiResourceExample example);

    int updateByExample(@Param("record") BaseApiResource record, @Param("example") BaseApiResourceExample example);

    int updateByPrimaryKeySelective(BaseApiResource record);

    int updateByPrimaryKey(BaseApiResource record);
}