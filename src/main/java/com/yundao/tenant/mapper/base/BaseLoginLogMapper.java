package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseLoginLog;
import com.yundao.tenant.model.base.BaseLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseLoginLogMapper {
    int countByExample(BaseLoginLogExample example);

    int deleteByExample(BaseLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseLoginLog record);

    int insertSelective(BaseLoginLog record);

    List<BaseLoginLog> selectByExample(BaseLoginLogExample example);

    BaseLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseLoginLog record, @Param("example") BaseLoginLogExample example);

    BaseLoginLog selectOne(BaseLoginLogExample example);

    int updateByExample(@Param("record") BaseLoginLog record, @Param("example") BaseLoginLogExample example);

    int updateByPrimaryKeySelective(BaseLoginLog record);

    int updateByPrimaryKey(BaseLoginLog record);
}