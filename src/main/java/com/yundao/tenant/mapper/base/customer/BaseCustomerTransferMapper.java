package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseCustomerTransfer;
import com.yundao.tenant.model.base.customer.BaseCustomerTransferExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCustomerTransferMapper {
    int countByExample(BaseCustomerTransferExample example);

    int deleteByExample(BaseCustomerTransferExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCustomerTransfer record);

    int insertSelective(BaseCustomerTransfer record);

    List<BaseCustomerTransfer> selectByExample(BaseCustomerTransferExample example);

    BaseCustomerTransfer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCustomerTransfer record, @Param("example") BaseCustomerTransferExample example);

    BaseCustomerTransfer selectOne(BaseCustomerTransferExample example);

    int updateByExample(@Param("record") BaseCustomerTransfer record, @Param("example") BaseCustomerTransferExample example);

    int updateByPrimaryKeySelective(BaseCustomerTransfer record);

    int updateByPrimaryKey(BaseCustomerTransfer record);
}