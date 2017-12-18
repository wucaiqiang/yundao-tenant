package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseUserStaff;
import com.yundao.tenant.model.base.BaseUserStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserStaffMapper {
    int countByExample(BaseUserStaffExample example);

    int deleteByExample(BaseUserStaffExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUserStaff record);

    int insertSelective(BaseUserStaff record);

    List<BaseUserStaff> selectByExample(BaseUserStaffExample example);

    BaseUserStaff selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUserStaff record, @Param("example") BaseUserStaffExample example);

    BaseUserStaff selectOne(BaseUserStaffExample example);

    int updateByExample(@Param("record") BaseUserStaff record, @Param("example") BaseUserStaffExample example);

    int updateByPrimaryKeySelective(BaseUserStaff record);

    int updateByPrimaryKey(BaseUserStaff record);
}