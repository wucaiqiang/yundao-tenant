package com.yundao.tenant.service.finance.receipt.impl;

import com.yundao.core.code.Result;
import com.yundao.core.enums.NumberEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.RegularUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.finance.receipt.DeclarationForReceiptResDto;
import com.yundao.tenant.dto.finance.receipt.ReceiptRecordAddReqDto;
import com.yundao.tenant.dto.finance.receipt.ReceiptRecordDelReqDto;
import com.yundao.tenant.dto.finance.receipt.plan.ReceiptPlanRecordListDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.mapper.base.finance.BaseReceiptPlanMapper;
import com.yundao.tenant.mapper.base.finance.BaseReceiptRecordMapper;
import com.yundao.tenant.mapper.finance.receipt.ReceiptRecordMapper;
import com.yundao.tenant.model.base.finance.BaseReceiptPlan;
import com.yundao.tenant.model.base.finance.BaseReceiptRecord;
import com.yundao.tenant.model.base.finance.BaseReceiptRecordExample;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.finance.receipt.ReceiptRecordService;
import com.yundao.tenant.service.sale.declaration.DeclarationService;
import com.yundao.tenant.util.DateUtil;
import com.yundao.tenant.util.SymbolStrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 回款记录服务实现
 *
 * @author jan
 * @create 2017-10-12 13:41
 **/
@Service
public class ReceiptRecordServiceImpl extends AbstractService implements ReceiptRecordService {

    private static Log log = LogFactory.getLog(ReceiptRecordServiceImpl.class);

    @Autowired
    private ReceiptRecordMapper receiptRecordMapper;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private BaseReceiptRecordMapper baseReceiptRecordMapper;

    @Autowired
    private BaseReceiptPlanMapper baseReceiptPlanMapper;

    @Autowired
    private DeclarationService declarationService;

    @Override
    public Result<Long> insert(ReceiptRecordAddReqDto dto) throws BaseException {
        String logPrefix = "回款记录||插入||";
        log.info("%s 入参 %s ", logPrefix, JsonUtils.objectToJson(dto));

        BaseReceiptPlan receiptPlan = baseReceiptPlanMapper.selectByPrimaryKey(dto.getReceiptPlanId());
        if (receiptPlan == null)
            throw new BaseException(CodeConstant.CODE_1220129);

        dto.setPayDate(DateUtil.repair(dto.getPayDate()));
        Date payDate = DateUtil.parse(dto.getPayDate());
        int compareVal = payDate.compareTo(new Date());
        if (compareVal == 1)
            throw new BaseException(CodeConstant.CODE_1220144);

        dto.setInvoicedDate(DateUtil.repair(dto.getInvoicedDate()));
        checkArgsForAddOrUpdate(dto);

        BaseReceiptRecord model = new BaseReceiptRecord();
        super.initialModel(model);
        model.setAmount(dto.getAmount());
        model.setPayDate(payDate);
        if (BooleanUtils.isNotBlank(dto.getInvoicedDate()))
            model.setInvoicedDate(DateUtil.parse(dto.getInvoicedDate()));
        model.setPayUnit(dto.getPayUnit());
        model.setBankName(dto.getBankName());
        model.setPayAccount(dto.getPayAccount());
        Integer isInvoiced = dto.getIsInvoiced() == null ? 0 : dto.getIsInvoiced();
        model.setIsInvoiced(isInvoiced != NumberEnum.ONE.getValue() ? 0 : isInvoiced);
        model.setRemark(dto.getRemark());
        model.setReceiptPlanId(dto.getReceiptPlanId());
        baseReceiptRecordMapper.insertSelective(model);
        log.info("%s 完成", logPrefix);
        return Result.newSuccessResult(model.getId());
    }

    private void checkArgsForAddOrUpdate(ReceiptRecordAddReqDto dto) throws BaseException {
        if (dto.getIsInvoiced() != null && dto.getIsInvoiced() == NumberEnum.ONE.getValue()) {
            if (BooleanUtils.isBlank(dto.getInvoicedDate()))
                throw new BaseException(CodeConstant.CODE_1220136);
        }
        if (BooleanUtils.isNotBlank(dto.getPayAccount())) {
            if (!RegularUtils.isMatch(dto.getPayAccount(), RegularUtils.Regular.NUMBER))
                throw new BaseException(CodeConstant.CODE_1220135);
        }
    }

    @Override
    public Double getActualReceiptAmount(Long receiptPlanId) throws BaseException {
        return receiptRecordMapper.selectActualReceiptAmount(receiptPlanId);
    }

    @Override
    public List<ReceiptPlanRecordListDto> getReceiptRecordListForPlanDetail(Long receiptPlanId) throws BaseException {
        List<ReceiptPlanRecordListDto> list = receiptRecordMapper.selectForReceiptPlan(receiptPlanId);
        if (BooleanUtils.isEmpty(list))
            return list;
        for (ReceiptPlanRecordListDto item : list) {
            item.setIsInvoicedText(dictionaryService.toText(DicCode.DIC_RECEIPT_RECORD_IS_INVOICED, item.getIsInvoiced()));
        }
        return list;
    }

    @Override
    public Result<List<DeclarationForReceiptResDto>> getCanReceiptDeclarations(Long productId) throws BaseException {
        if (productId == null)
            throw new BaseException(CodeConstant.CODE_1200041);
        return Result.newSuccessResult(declarationService.getCanReceiptDeclarations(productId));
    }

    @Override
    public Result<PermissionResultDto> delete(ReceiptRecordDelReqDto dto) throws BaseException {
        String logPrefix = "回款记录||删除||";
        log.info("%s 入参 %s", logPrefix, JsonUtils.objectToJson(dto));

        List<Long> ids = SymbolStrUtils.toLongWithTypeCheck(dto.getIds());
        if (BooleanUtils.isEmpty(ids))
            throw new BaseException(CodeConstant.CODE_1220140);
        BaseReceiptRecordExample example = new BaseReceiptRecordExample();
        example.createCriteria().andIdIn(ids);
        List<BaseReceiptRecord> records = baseReceiptRecordMapper.selectByExample(example);
        log.info("%s records %s", logPrefix, JsonUtils.objectToJson(records));
        if (BooleanUtils.isEmpty(records))
            throw new BaseException(CodeConstant.CODE_1220140);

        for (BaseReceiptRecord record : records) {
            super.updateModel(record);
            record.setIsDelete(DeleteEnum.DELETED.getValue());
            baseReceiptRecordMapper.updateByPrimaryKeySelective(record);
        }
        log.info("%s 完成", logPrefix);
        return Result.newSuccessResult(null);
    }
}
