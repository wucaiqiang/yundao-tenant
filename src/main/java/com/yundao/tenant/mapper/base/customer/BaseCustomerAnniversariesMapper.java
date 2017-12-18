package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerAnniversaries;
import com.yundao.tenant.model.base.customer.BaseCustomerAnniversariesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerAnniversariesMapper {
    int countByExample(BaseCustomerAnniversariesExample example);

    int deleteByExample(BaseCustomerAnniversariesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerAnniversaries record);

    int insertSelective(BaseCustomerAnniversaries record);

    List<BaseCustomerAnniversaries> selectByExample(BaseCustomerAnniversariesExample example);

    BaseCustomerAnniversaries selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerAnniversaries record, @Param("example") BaseCustomerAnniversariesExample example);

    BaseCustomerAnniversaries selectOne(BaseCustomerAnniversariesExample example);

    int updateByExample(@Param("record") BaseCustomerAnniversaries record, @Param("example") BaseCustomerAnniversariesExample example);

    int updateByPrimaryKeySelective(BaseCustomerAnniversaries record);

    int updateByPrimaryKey(BaseCustomerAnniversaries record);
}