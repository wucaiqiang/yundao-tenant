package com.yundao.tenant.service.sale.declaration.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.sale.declaration.audit.DeclarationAuditPageReqDto;
import com.yundao.tenant.dto.sale.declaration.audit.DeclarationAuditPageResDto;
import com.yundao.tenant.dto.sale.declaration.audit.DeclarationAuditReqDto;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.enums.sale.declaration.DeclarationAttachTypeEnum;
import com.yundao.tenant.enums.sale.declaration.DeclarationAuditAlertEnum;
import com.yundao.tenant.enums.sale.declaration.DeclarationStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.BaseUserDetailMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationAttachMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationMapper;
import com.yundao.tenant.mapper.sale.declaration.DeclarationAuditMapper;
import com.yundao.tenant.model.base.BaseUserDetail;
import com.yundao.tenant.model.base.BaseUserDetailExample;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseCustomerBank;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentials;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationAttach;
import com.yundao.tenant.model.base.sale.BaseDeclarationAttachExample;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.sale.declaration.DeclarationAuditService;
import com.yundao.tenant.service.sale.declaration.DeclarationBankRelService;
import com.yundao.tenant.service.sale.declaration.DeclarationCredentialsRelService;
import com.yundao.tenant.service.workflow.WorkflowServie;
import com.yundao.tenant.util.LocalBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 报单审核服务实现
 *
 * @author jan
 * @create 2017-08-27 PM3:01
 **/
@Service
public class DeclarationAuditServiceImpl extends AbstractService implements DeclarationAuditService {

    private static Log log = LogFactory.getLog(DeclarationAuditServiceImpl.class);

    @Autowired
    private DeclarationAuditMapper declarationAuditMapper;

    @Autowired
    private BaseDeclarationMapper baseDeclarationMapper;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private WorkflowServie workflowServie;

    @Autowired
    private BaseDeclarationAttachMapper baseDeclarationAttachMapper;

    @Autowired
    private DeclarationCredentialsRelService declarationCredentialsRelService;

    @Autowired
    private DeclarationBankRelService declarationBankRelService;

    @Autowired
    private BaseProductMapper baseProductMapper;

    @Autowired
    private BaseCustomerMapper baseCustomerMapper;

    @Autowired
    private MsgMessageService msgMessageService;

    @Autowired
    private BaseUserDetailMapper baseUserDetailMapper;

    @Override
    public Result<PaginationSupport<DeclarationAuditPageResDto>> getPage(DeclarationAuditPageReqDto dto) throws BaseException {
        log.info("报单审核||获取分页数据||开始 查询参数：%s", JsonUtils.objectToJson(dto));
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        PaginationSupport<DeclarationAuditPageResDto> page = PaginationSupport.newDefault(paramMap);
        List<DeclarationAuditPageResDto> dtos = declarationAuditMapper.selectAuditPage(paramMap);
        int count = declarationAuditMapper.selectAuditPageCount(paramMap);
        this.setText(dtos);
        page.setDatas(dtos);
        page.setTotalCount(count);
        return Result.newSuccessResult(page);
    }

    @Override
    public Result<Boolean> doAudit(DeclarationAuditReqDto dto) throws BaseException {
        String logPrefix = "报单审核||审核操作||";
        log.info("%s开始 参数:%s", logPrefix, JsonUtils.objectToJson(dto));
        BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(dto.getId());
        if (declaration == null)
            throw new BaseException(CodeConstant.CODE_1220062);

        if (WorkflowActionEnum.PASS.getValue().equals(dto.getAction()))
            this.checkInfoForAudit(declaration);

        log.info("%s报单数据 %s", logPrefix, JsonUtils.objectToJson(declaration));
        if (!DeclarationStatusEnum.APPROVALING.getValue().equals(declaration.getAuditStatus())) {
            log.info("%s状态值有误：只有“审核中”才能进行 通过、驳回、取消审核", logPrefix);
            throw new BaseException(CodeConstant.CODE_1220055);
        }

        Boolean isCancel = false;
        if (WorkflowActionEnum.REJECT.getValue().equals(dto.getAction())) {
            //拒绝
            if (BooleanUtils.isEmpty(dto.getReason()))
                throw new BaseException(CodeConstant.CODE_1220057);
            declaration.setReason(dto.getReason());
            declaration.setAuditStatus(DeclarationStatusEnum.REJECT.getValue());
            declaration.setStatus(DeclarationStatusEnum.REJECT.getValue());

        } else if (WorkflowActionEnum.CANCEL.getValue().equals(dto.getAction())) {
            //取消
            if (BooleanUtils.isEmpty(dto.getReason()))
                throw new BaseException(CodeConstant.CODE_1220058);
            declaration.setReason(dto.getReason());
            declaration.setAuditStatus(DeclarationStatusEnum.CANCEL.getValue());
            declaration.setStatus(DeclarationStatusEnum.CANCEL.getValue());
            isCancel = true;
        } else if (WorkflowActionEnum.PASS.getValue().equals(dto.getAction())) {
            declaration.setAuditStatus(DeclarationStatusEnum.PASS.getValue());
            declaration.setStatus(DeclarationStatusEnum.PASS.getValue());
        }
        super.updateModel(declaration);
        declaration.setOperationDate(new Date());
        baseDeclarationMapper.updateByPrimaryKeySelective(declaration);
        log.info("%s更新报单数据完成", logPrefix);

        //发送消息
        sendMessage(dto, declaration);

        String taskId = workflowServie.getTODOTaskId(dto.getId(), BusinessTypeCode.DECLARATION,isCancel).getResult();
        //调用工作流
        workflowServie.complete(taskId, dto.getAction(), dto.getReason());
        return Result.newSuccessResult(true);
    }

    private void sendMessage(DeclarationAuditReqDto dto, BaseDeclaration declaration) throws BaseException {
        if (WorkflowActionEnum.PASS.getValue().equals(dto.getAction()) || WorkflowActionEnum.REJECT.getValue().equals(dto.getAction())) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", declaration.getId());
            params.put("dealAmount", declaration.getDealAmount() + "万");
            params.put("dealTime", DateUtils.format(declaration.getPayDate(), DateUtils.YYYY_MM_DD));
            BaseProduct product = baseProductMapper.selectByPrimaryKey(declaration.getProductId());
            params.put("productName", product.getName());
            params.put("customerId", declaration.getCustomerId());
            BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(declaration.getCustomerId());
            params.put("customerName", customer.getName());
            BaseUserDetailExample example = new BaseUserDetailExample();
            example.createCriteria().andUserAccountIdEqualTo(super.getHeaderUserId());
            BaseUserDetail userDetail = baseUserDetailMapper.selectOne(example);
            params.put("audioName", userDetail.getRealName());
            params.put("userId", declaration.getUserId());
            String code = MsgMessageCodeEnum.DECLARATION_AUDIO_PASS.getCode();
            if (WorkflowActionEnum.REJECT.getValue().equals(dto.getAction())) {
                code = MsgMessageCodeEnum.DECLARATION_AUDIO_REJECT.getCode();
                params.put("reason", dto.getReason());
            }
            msgMessageService.processSendMessage(code, params);
        }
    }

    private void checkInfoForAudit(BaseDeclaration model) throws BaseException {
        List<Integer> alertList = new ArrayList<>();
        examineCredentials(model.getId(), alertList);
        examineDeclarationInfo(model, alertList);
        examineBank(model.getId(), alertList);
        examineAssets(model,alertList);

        if (BooleanUtils.isEmpty(alertList))
            return;
        String msg = "";
        int index = 1;
        int size = alertList.size();
        for (Integer alertId : alertList) {
            msg += DeclarationAuditAlertEnum.getName(alertId) + (index < size ? "、" : " ");
            index++;
        }
        throw new BaseException(CodeConstant.CODE_1220103, msg + "不能为空");
    }

    private void examineAssets(BaseDeclaration model, List<Integer> alertList) {
        //资产证明验证
        BaseDeclarationAttachExample attachExample1 = new BaseDeclarationAttachExample();
        attachExample1.createCriteria().andDeclarationIdEqualTo(model.getId())
                .andTypeEqualTo(DeclarationAttachTypeEnum.DECLARATION_ATTACHS.getType());
        List<BaseDeclarationAttach> declarationAttaches = baseDeclarationAttachMapper.selectByExample(attachExample1);
        if(declarationAttaches == null || declarationAttaches.isEmpty()){
            alertList.add(DeclarationAuditAlertEnum.ASSETS.getValue());
        }
    }

    /**
     * 检查银行卡
     *
     * @param id        报单id
     * @param alertList 结果列表
     */
    private void examineBank(Long id, List<Integer> alertList) throws BaseException {
        //银行
        BaseCustomerBank bank = declarationBankRelService.getCustomerBankByDeclarationId(id);
        if (bank == null) {
            alertList.add(DeclarationAuditAlertEnum.BANK_ACCOUNT.getValue());
            alertList.add(DeclarationAuditAlertEnum.BANK_NAME.getValue());
            alertList.add(DeclarationAuditAlertEnum.BANK_CARD.getValue());
        } else {
            if (BooleanUtils.isBlank(bank.getAccount()))
                alertList.add(DeclarationAuditAlertEnum.BANK_ACCOUNT.getValue());
            if (BooleanUtils.isBlank(bank.getBankName()))
                alertList.add(DeclarationAuditAlertEnum.BANK_NAME.getValue());
            if (BooleanUtils.isBlank(bank.getFront()) && BooleanUtils.isBlank(bank.getBack()))
                alertList.add(DeclarationAuditAlertEnum.BANK_CARD.getValue());
        }
    }

    /**
     * 检查报单资料
     *
     * @param model     报单数据
     * @param alertList 结果列表
     */
    private void examineDeclarationInfo(BaseDeclaration model, List<Integer> alertList) {
        //报单资料
        if (model.getDealAmount() == null)
            alertList.add(DeclarationAuditAlertEnum.DEAL_MONEY.getValue());
        if (model.getPayDate() == null)
            alertList.add(DeclarationAuditAlertEnum.PAY_DATE.getValue());

        BaseDeclarationAttachExample daExample = new BaseDeclarationAttachExample();
        daExample.createCriteria().andDeclarationIdEqualTo(model.getId()).andTypeEqualTo(DeclarationAttachTypeEnum
                .VOUCHER.getType());
        int count = baseDeclarationAttachMapper.countByExample(daExample);
        if (count == 0)
            alertList.add(DeclarationAuditAlertEnum.PAY_EVIDENCE.getValue());
    }

    /**
     * 检查客户证件
     *
     * @param id        报单id
     * @param alertList 结果列表
     */
    private void examineCredentials(Long id, List<Integer> alertList) throws BaseException {
        //客户证件
        BaseCustomerCredentials credentials = declarationCredentialsRelService.getCustomerCredentialsByDeclarationId
                (id);
        if (credentials == null) {
            alertList.add(DeclarationAuditAlertEnum.CREDENTIALS_TYPE.getValue());
            alertList.add(DeclarationAuditAlertEnum.CREDENTIALS_NUMBER.getValue());
            alertList.add(DeclarationAuditAlertEnum.IDCARD.getValue());
        } else {
            if (credentials.getType() == null)
                alertList.add(DeclarationAuditAlertEnum.CREDENTIALS_TYPE.getValue());
            if (BooleanUtils.isBlank(credentials.getNumber()))
                alertList.add(DeclarationAuditAlertEnum.CREDENTIALS_NUMBER.getValue());
            if (BooleanUtils.isBlank(credentials.getFront()) && BooleanUtils.isBlank(credentials.getBack()))
                alertList.add(DeclarationAuditAlertEnum.IDCARD.getValue());
        }
    }

    private void setText(List<DeclarationAuditPageResDto> dtos) throws BaseException {
        for (DeclarationAuditPageResDto dto : dtos) {
            dto.setStatusText(dictionaryService.toText(DicCode.DIC_DECLARATION_STATUS, dto.getStatus()));
            dto.setCanAudit(DeclarationStatusEnum.canAudit(dto.getStatus()));
            dto.setHasPayEvidenceText(dictionaryService.toText(DicCode.DIC_HAS_PAY_EVIDENCE, dto.getHasPayEvidence()));
            if(DeclarationStatusEnum.REFUND.getValue().equals(dto.getDeclarationStatus())){
                dto.setStatusText(dto.getStatusText() + "(已退款)");
            }else{
                if (dto.getDisardId() != null)
                    dto.setStatusText(dto.getStatusText() + "(已废弃)");
            }
        }
    }
}
