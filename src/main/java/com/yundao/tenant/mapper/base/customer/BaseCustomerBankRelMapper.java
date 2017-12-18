package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerBankRel;
import com.yundao.tenant.model.base.customer.BaseCustomerBankRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerBankRelMapper {
    int countByExample(BaseCustomerBankRelExample example);

    int deleteByExample(BaseCustomerBankRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerBankRel record);

    int insertSelective(BaseCustomerBankRel record);

    List<BaseCustomerBankRel> selectByExample(BaseCustomerBankRelExample example);

    BaseCustomerBankRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerBankRel record, @Param("example") BaseCustomerBankRelExample example);

    BaseCustomerBankRel selectOne(BaseCustomerBankRelExample example);

    int updateByExample(@Param("record") BaseCustomerBankRel record, @Param("example") BaseCustomerBankRelExample example);

    int updateByPrimaryKeySelective(BaseCustomerBankRel record);

    int updateByPrimaryKey(BaseCustomerBankRel record);
}