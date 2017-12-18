package com.yundao.tenant.mapper.base.finance;

import com.yundao.tenant.model.base.finance.BaseReceiptPlan;
import com.yundao.tenant.model.base.finance.BaseReceiptPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseReceiptPlanMapper {
    int countByExample(BaseReceiptPlanExample example);

    int deleteByExample(BaseReceiptPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseReceiptPlan record);

    int insertSelective(BaseReceiptPlan record);

    List<BaseReceiptPlan> selectByExample(BaseReceiptPlanExample example);

    BaseReceiptPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseReceiptPlan record, @Param("example") BaseReceiptPlanExample example);

    BaseReceiptPlan selectOne(BaseReceiptPlanExample example);

    int updateByExample(@Param("record") BaseReceiptPlan record, @Param("example") BaseReceiptPlanExample example);

    int updateByPrimaryKeySelective(BaseReceiptPlan record);

    int updateByPrimaryKey(BaseReceiptPlan record);
}