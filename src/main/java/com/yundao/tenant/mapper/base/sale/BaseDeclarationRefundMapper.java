package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseDeclarationRefund;
import com.yundao.tenant.model.base.sale.BaseDeclarationRefundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDeclarationRefundMapper {
    int countByExample(BaseDeclarationRefundExample example);

    int deleteByExample(BaseDeclarationRefundExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDeclarationRefund record);

    int insertSelective(BaseDeclarationRefund record);

    List<BaseDeclarationRefund> selectByExample(BaseDeclarationRefundExample example);

    BaseDeclarationRefund selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDeclarationRefund record, @Param("example") BaseDeclarationRefundExample example);

    BaseDeclarationRefund selectOne(BaseDeclarationRefundExample example);

    int updateByExample(@Param("record") BaseDeclarationRefund record, @Param("example") BaseDeclarationRefundExample example);

    int updateByPrimaryKeySelective(BaseDeclarationRefund record);

    int updateByPrimaryKey(BaseDeclarationRefund record);
}