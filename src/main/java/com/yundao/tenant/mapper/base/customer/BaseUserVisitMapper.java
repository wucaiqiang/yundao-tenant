package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseUserVisit;
import com.yundao.tenant.model.base.customer.BaseUserVisitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserVisitMapper {
    int countByExample(BaseUserVisitExample example);

    int deleteByExample(BaseUserVisitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUserVisit record);

    int insertSelective(BaseUserVisit record);

    List<BaseUserVisit> selectByExample(BaseUserVisitExample example);

    BaseUserVisit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUserVisit record, @Param("example") BaseUserVisitExample example);

    BaseUserVisit selectOne(BaseUserVisitExample example);

    int updateByExample(@Param("record") BaseUserVisit record, @Param("example") BaseUserVisitExample example);

    int updateByPrimaryKeySelective(BaseUserVisit record);

    int updateByPrimaryKey(BaseUserVisit record);
}