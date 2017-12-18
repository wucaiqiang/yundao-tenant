package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerBackExamine;
import com.yundao.tenant.model.base.customer.BaseCustomerBackExamineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerBackExamineMapper {
    int countByExample(BaseCustomerBackExamineExample example);

    int deleteByExample(BaseCustomerBackExamineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerBackExamine record);

    int insertSelective(BaseCustomerBackExamine record);

    List<BaseCustomerBackExamine> selectByExample(BaseCustomerBackExamineExample example);

    BaseCustomerBackExamine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerBackExamine record, @Param("example") BaseCustomerBackExamineExample example);

    BaseCustomerBackExamine selectOne(BaseCustomerBackExamineExample example);

    int updateByExample(@Param("record") BaseCustomerBackExamine record, @Param("example") BaseCustomerBackExamineExample example);

    int updateByPrimaryKeySelective(BaseCustomerBackExamine record);

    int updateByPrimaryKey(BaseCustomerBackExamine record);
}