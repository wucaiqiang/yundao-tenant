package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerCredentials;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentialsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerCredentialsMapper {
    int countByExample(BaseCustomerCredentialsExample example);

    int deleteByExample(BaseCustomerCredentialsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerCredentials record);

    int insertSelective(BaseCustomerCredentials record);

    List<BaseCustomerCredentials> selectByExample(BaseCustomerCredentialsExample example);

    BaseCustomerCredentials selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerCredentials record, @Param("example") BaseCustomerCredentialsExample example);

    BaseCustomerCredentials selectOne(BaseCustomerCredentialsExample example);

    int updateByExample(@Param("record") BaseCustomerCredentials record, @Param("example") BaseCustomerCredentialsExample example);

    int updateByPrimaryKeySelective(BaseCustomerCredentials record);

    int updateByPrimaryKey(BaseCustomerCredentials record);
}