package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerFollowUpAttach;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUpAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerFollowUpAttachMapper {
    int countByExample(BaseCustomerFollowUpAttachExample example);

    int deleteByExample(BaseCustomerFollowUpAttachExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerFollowUpAttach record);

    int insertSelective(BaseCustomerFollowUpAttach record);

    List<BaseCustomerFollowUpAttach> selectByExample(BaseCustomerFollowUpAttachExample example);

    BaseCustomerFollowUpAttach selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerFollowUpAttach record, @Param("example") BaseCustomerFollowUpAttachExample example);

    BaseCustomerFollowUpAttach selectOne(BaseCustomerFollowUpAttachExample example);

    int updateByExample(@Param("record") BaseCustomerFollowUpAttach record, @Param("example") BaseCustomerFollowUpAttachExample example);

    int updateByPrimaryKeySelective(BaseCustomerFollowUpAttach record);

    int updateByPrimaryKey(BaseCustomerFollowUpAttach record);
}