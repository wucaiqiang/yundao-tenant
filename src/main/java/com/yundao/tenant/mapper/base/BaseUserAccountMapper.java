package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseUserAccount;
import com.yundao.tenant.model.base.BaseUserAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserAccountMapper {
    int countByExample(BaseUserAccountExample example);

    int deleteByExample(BaseUserAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUserAccount record);

    int insertSelective(BaseUserAccount record);

    List<BaseUserAccount> selectByExample(BaseUserAccountExample example);

    BaseUserAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUserAccount record, @Param("example") BaseUserAccountExample example);

    BaseUserAccount selectOne(BaseUserAccountExample example);

    int updateByExample(@Param("record") BaseUserAccount record, @Param("example") BaseUserAccountExample example);

    int updateByPrimaryKeySelective(BaseUserAccount record);

    int updateByPrimaryKey(BaseUserAccount record);
}