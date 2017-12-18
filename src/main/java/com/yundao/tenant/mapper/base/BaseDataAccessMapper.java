package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseDataAccess;
import com.yundao.tenant.model.base.BaseDataAccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDataAccessMapper {
    int countByExample(BaseDataAccessExample example);

    int deleteByExample(BaseDataAccessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDataAccess record);

    int insertSelective(BaseDataAccess record);

    List<BaseDataAccess> selectByExample(BaseDataAccessExample example);

    BaseDataAccess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDataAccess record, @Param("example") BaseDataAccessExample example);

    BaseDataAccess selectOne(BaseDataAccessExample example);

    int updateByExample(@Param("record") BaseDataAccess record, @Param("example") BaseDataAccessExample example);

    int updateByPrimaryKeySelective(BaseDataAccess record);

    int updateByPrimaryKey(BaseDataAccess record);
}