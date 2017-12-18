package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerFollowUp;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerFollowUpMapper {
    int countByExample(BaseCustomerFollowUpExample example);

    int deleteByExample(BaseCustomerFollowUpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerFollowUp record);

    int insertSelective(BaseCustomerFollowUp record);

    List<BaseCustomerFollowUp> selectByExample(BaseCustomerFollowUpExample example);

    BaseCustomerFollowUp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerFollowUp record, @Param("example") BaseCustomerFollowUpExample example);

    BaseCustomerFollowUp selectOne(BaseCustomerFollowUpExample example);

    int updateByExample(@Param("record") BaseCustomerFollowUp record, @Param("example") BaseCustomerFollowUpExample example);

    int updateByPrimaryKeySelective(BaseCustomerFollowUp record);

    int updateByPrimaryKey(BaseCustomerFollowUp record);
}