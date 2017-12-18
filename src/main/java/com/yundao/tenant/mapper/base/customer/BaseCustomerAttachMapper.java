package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerAttach;
import com.yundao.tenant.model.base.customer.BaseCustomerAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerAttachMapper {
    int countByExample(BaseCustomerAttachExample example);

    int deleteByExample(BaseCustomerAttachExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerAttach record);

    int insertSelective(BaseCustomerAttach record);

    List<BaseCustomerAttach> selectByExample(BaseCustomerAttachExample example);

    BaseCustomerAttach selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerAttach record, @Param("example") BaseCustomerAttachExample example);

    BaseCustomerAttach selectOne(BaseCustomerAttachExample example);

    int updateByExample(@Param("record") BaseCustomerAttach record, @Param("example") BaseCustomerAttachExample example);

    int updateByPrimaryKeySelective(BaseCustomerAttach record);

    int updateByPrimaryKey(BaseCustomerAttach record);
}