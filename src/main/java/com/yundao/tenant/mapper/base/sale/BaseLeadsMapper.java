package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseLeads;
import com.yundao.tenant.model.base.sale.BaseLeadsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseLeadsMapper {
    int countByExample(BaseLeadsExample example);

    int deleteByExample(BaseLeadsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseLeads record);

    int insertSelective(BaseLeads record);

    List<BaseLeads> selectByExample(BaseLeadsExample example);

    BaseLeads selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseLeads record, @Param("example") BaseLeadsExample example);

    BaseLeads selectOne(BaseLeadsExample example);

    int updateByExample(@Param("record") BaseLeads record, @Param("example") BaseLeadsExample example);

    int updateByPrimaryKeySelective(BaseLeads record);

    int updateByPrimaryKey(BaseLeads record);
}