package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseCloudFile;
import com.yundao.tenant.model.base.BaseCloudFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCloudFileMapper {
    int countByExample(BaseCloudFileExample example);

    int deleteByExample(BaseCloudFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCloudFile record);

    int insertSelective(BaseCloudFile record);

    List<BaseCloudFile> selectByExample(BaseCloudFileExample example);

    BaseCloudFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCloudFile record, @Param("example") BaseCloudFileExample example);

    BaseCloudFile selectOne(BaseCloudFileExample example);

    int updateByExample(@Param("record") BaseCloudFile record, @Param("example") BaseCloudFileExample example);

    int updateByPrimaryKeySelective(BaseCloudFile record);

    int updateByPrimaryKey(BaseCloudFile record);
}