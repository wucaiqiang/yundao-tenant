package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseUserCustomerFocus;
import com.yundao.tenant.model.base.customer.BaseUserCustomerFocusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserCustomerFocusMapper {
    int countByExample(BaseUserCustomerFocusExample example);

    int deleteByExample(BaseUserCustomerFocusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUserCustomerFocus record);

    int insertSelective(BaseUserCustomerFocus record);

    List<BaseUserCustomerFocus> selectByExample(BaseUserCustomerFocusExample example);

    BaseUserCustomerFocus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUserCustomerFocus record, @Param("example") BaseUserCustomerFocusExample example);

    BaseUserCustomerFocus selectOne(BaseUserCustomerFocusExample example);

    int updateByExample(@Param("record") BaseUserCustomerFocus record, @Param("example") BaseUserCustomerFocusExample example);

    int updateByPrimaryKeySelective(BaseUserCustomerFocus record);

    int updateByPrimaryKey(BaseUserCustomerFocus record);
}