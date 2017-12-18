package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerTag;
import com.yundao.tenant.model.base.customer.BaseCustomerTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerTagMapper {
    int countByExample(BaseCustomerTagExample example);

    int deleteByExample(BaseCustomerTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerTag record);

    int insertSelective(BaseCustomerTag record);

    List<BaseCustomerTag> selectByExample(BaseCustomerTagExample example);

    BaseCustomerTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerTag record, @Param("example") BaseCustomerTagExample example);

    BaseCustomerTag selectOne(BaseCustomerTagExample example);

    int updateByExample(@Param("record") BaseCustomerTag record, @Param("example") BaseCustomerTagExample example);

    int updateByPrimaryKeySelective(BaseCustomerTag record);

    int updateByPrimaryKey(BaseCustomerTag record);
}