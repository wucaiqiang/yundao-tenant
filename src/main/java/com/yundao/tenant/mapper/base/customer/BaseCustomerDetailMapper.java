package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerDetail;
import com.yundao.tenant.model.base.customer.BaseCustomerDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerDetailMapper {
    int countByExample(BaseCustomerDetailExample example);

    int deleteByExample(BaseCustomerDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerDetail record);

    int insertSelective(BaseCustomerDetail record);

    List<BaseCustomerDetail> selectByExample(BaseCustomerDetailExample example);

    BaseCustomerDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerDetail record, @Param("example") BaseCustomerDetailExample example);

    BaseCustomerDetail selectOne(BaseCustomerDetailExample example);

    int updateByExample(@Param("record") BaseCustomerDetail record, @Param("example") BaseCustomerDetailExample example);

    int updateByPrimaryKeySelective(BaseCustomerDetail record);

    int updateByPrimaryKey(BaseCustomerDetail record);
}