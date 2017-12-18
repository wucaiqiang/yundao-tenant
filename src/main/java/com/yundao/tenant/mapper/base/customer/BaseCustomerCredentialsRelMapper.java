package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerCredentialsRel;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentialsRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerCredentialsRelMapper {
    int countByExample(BaseCustomerCredentialsRelExample example);

    int deleteByExample(BaseCustomerCredentialsRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerCredentialsRel record);

    int insertSelective(BaseCustomerCredentialsRel record);

    List<BaseCustomerCredentialsRel> selectByExample(BaseCustomerCredentialsRelExample example);

    BaseCustomerCredentialsRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerCredentialsRel record, @Param("example") BaseCustomerCredentialsRelExample example);

    BaseCustomerCredentialsRel selectOne(BaseCustomerCredentialsRelExample example);

    int updateByExample(@Param("record") BaseCustomerCredentialsRel record, @Param("example") BaseCustomerCredentialsRelExample example);

    int updateByPrimaryKeySelective(BaseCustomerCredentialsRel record);

    int updateByPrimaryKey(BaseCustomerCredentialsRel record);
}