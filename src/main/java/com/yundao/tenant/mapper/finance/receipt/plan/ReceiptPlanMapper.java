package com.yundao.tenant.mapper.finance.receipt.plan;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.finance.receipt.plan.ReceiptPlanPageResDto;

import java.util.List;
import java.util.Map;

public interface ReceiptPlanMapper {

    List<ReceiptPlanPageResDto> selectReceiptPlanPage(Map<String, Object> parmas) throws BaseException;

    int selectReceiptPlanPageCount(Map<String, Object> parmas) throws BaseException;

}
