package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseUbsResource;
import com.yundao.tenant.model.base.BaseUbsResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUbsResourceMapper {
    int countByExample(BaseUbsResourceExample example);

    int deleteByExample(BaseUbsResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUbsResource record);

    int insertSelective(BaseUbsResource record);

    List<BaseUbsResource> selectByExample(BaseUbsResourceExample example);

    BaseUbsResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUbsResource record, @Param("example") BaseUbsResourceExample example);

    BaseUbsResource selectOne(BaseUbsResourceExample example);

    int updateByExample(@Param("record") BaseUbsResource record, @Param("example") BaseUbsResourceExample example);

    int updateByPrimaryKeySelective(BaseUbsResource record);

    int updateByPrimaryKey(BaseUbsResource record);
}