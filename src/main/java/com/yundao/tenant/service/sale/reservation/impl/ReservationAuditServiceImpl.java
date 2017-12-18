package com.yundao.tenant.service.sale.reservation.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.MsgConstant;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.sale.reservation.audit.ReservationAuditPageReqDto;
import com.yundao.tenant.dto.sale.reservation.audit.ReservationAuditPageResDto;
import com.yundao.tenant.dto.sale.reservation.audit.ReservationAuditReqDto;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.enums.sale.reservation.ReservationStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.base.sale.BaseReservationMapper;
import com.yundao.tenant.mapper.sale.reservation.ReservationAuditMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.sale.BaseReservation;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.sale.reservation.ReservationAuditService;
import com.yundao.tenant.service.workflow.WorkflowServie;
import com.yundao.tenant.util.DateUtil;
import com.yundao.tenant.util.DoubleUtils;
import com.yundao.tenant.util.LocalBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预约审批服务实现
 *
 * @author jan
 * @create 2017-08-24 PM3:23
 **/
@Service
public class ReservationAuditServiceImpl extends AbstractService implements ReservationAuditService {

    private static Log log = LogFactory.getLog(ReservationAuditServiceImpl.class);

    @Autowired
    private ReservationAuditMapper reservationAuditMapper;

    @Autowired
    private BaseReservationMapper baseReservationMapper;

    @Autowired
    private BaseProductMapper baseProductMapper;

    @Autowired
    private BaseCustomerMapper baseCustomerMapper;

    @Autowired
    private WorkflowServie workflowServie;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private MsgMessageService msgMessageService;

    @Override
    public Result<PaginationSupport<ReservationAuditPageResDto>> getPage(ReservationAuditPageReqDto dto) throws BaseException {
        String logProfix = "预约审批||获取分页数据||";
        log.info("%s开始 查询参数：%s", logProfix, JsonUtils.objectToJson(dto));
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        PaginationSupport<ReservationAuditPageResDto> page = PaginationSupport.newDefault(paramMap);
        List<ReservationAuditPageResDto> dtos = reservationAuditMapper.selectAuditPage(paramMap);
        int count = reservationAuditMapper.selectAuditPageCount(paramMap);

        this.setText(dtos);
        page.setDatas(dtos);
        page.setTotalCount(count);
        return Result.newSuccessResult(page);
    }

    @Override
    public Result<Boolean> doAudit(ReservationAuditReqDto dto) throws BaseException {
        String logPrefix = "预约审批||审批操作||";
        log.info("%s开始 参数:%s", logPrefix, JsonUtils.objectToJson(dto));
        BaseReservation reservation = baseReservationMapper.selectByPrimaryKey(dto.getId());
        if (reservation == null)
            throw new BaseException(CodeConstant.CODE_1220054);
        log.info("%s预约数据 %s", logPrefix, JsonUtils.objectToJson(reservation));
        if (!ReservationStatusEnum.APPROVALING.getValue().equals(reservation.getStatus())) {
            log.info("%s状态值有误：只有“审批中”才能进行 通过、驳回、取消审批", logPrefix);
            throw new BaseException(CodeConstant.CODE_1220055);
        }

        Boolean isCancel = false;
        if (WorkflowActionEnum.REJECT.getValue().equals(dto.getAction())) {
            //驳回
            if (BooleanUtils.isEmpty(dto.getReason()))
                throw new BaseException(CodeConstant.CODE_1220057);
            if (dto.getReason().length() > 200)
                throw new BaseException(CodeConstant.CODE_1220075);
            reservation.setReason(dto.getReason());
            reservation.setStatus(ReservationStatusEnum.REJECT.getValue());
            reservation.setAuditStatus(ReservationStatusEnum.REJECT.getValue());

        } else if (WorkflowActionEnum.CANCEL.getValue().equals(dto.getAction())) {
            //取消
            if (BooleanUtils.isEmpty(dto.getReason()))
                throw new BaseException(CodeConstant.CODE_1220058);
            if (dto.getReason().length() > 200)
                throw new BaseException(CodeConstant.CODE_1220075);
            reservation.setReason(dto.getReason());
            reservation.setStatus(ReservationStatusEnum.CANCEL.getValue());
            isCancel = true;
            reservation.setAuditStatus(ReservationStatusEnum.CANCEL.getValue());
        } else if (WorkflowActionEnum.PASS.getValue().equals(dto.getAction())) {
            reservation.setStatus(ReservationStatusEnum.PASS.getValue());
            reservation.setAuditStatus(ReservationStatusEnum.PASS.getValue());
        }

        super.updateModel(reservation);
        reservation.setOperationDate(new Date());
        baseReservationMapper.updateByPrimaryKeySelective(reservation);

        if (WorkflowActionEnum.PASS.getValue().equals(dto.getAction()) || WorkflowActionEnum.REJECT.getValue().equals
                (dto.getAction())) {
            //上报消息动态
            this.doSendMsgForAudit(reservation, dto.getAction());
        }

        String taskId = workflowServie.getTODOTaskId(dto.getId(), BusinessTypeCode.RESERVATION,isCancel).getResult();
        //调用工作流
        workflowServie.complete(taskId, dto.getAction(), dto.getReason());
        log.info("%s更新预约数据完成", logPrefix);
        return Result.newSuccessResult(true);
    }

    private void doSendMsgForAudit(BaseReservation dto, Integer action) throws BaseException {
        String logPrefix = "预约审批||审批通过或驳回上报消息动态||";
        log.info("%s dto %s,action %s", logPrefix, JsonUtils.objectToJson(dto), action);
        if (dto.getProductId() == null)
            throw new BaseException(CodeConstant.CODE_1200042);
        BaseProduct product = baseProductMapper.selectByPrimaryKey(dto.getProductId());
        if (product == null)
            throw new BaseException(CodeConstant.CODE_1200042);

        if (dto.getCustomerId() == null)
            throw new BaseException(CodeConstant.CODE_1200084);
        BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(dto.getCustomerId());
        if (customer == null)
            throw new BaseException(CodeConstant.CODE_1200084);
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put(MsgConstant.USER_ID, dto.getUserId());
        msgMap.put(MsgConstant.CUSTOMER_ID, customer.getId());
        msgMap.put("createUserName", super.getRealName());
        msgMap.put("reservationId", dto.getId());
        msgMap.put("customerName", customer.getName());
        msgMap.put("productName", product.getName());
        msgMap.put("reservationAmount", DoubleUtils.toWholeString(dto.getReservationAmount()));
        msgMap.put("estimatePayDate", DateUtil.formatExactDay(dto.getEstimatePayDate()));
        msgMap.put("reason", dto.getReason());
        log.info("%s msgMap %s", logPrefix, JsonUtils.objectToJson(msgMap));
        String code = WorkflowActionEnum.PASS.getValue().equals(action) ? MsgMessageCodeEnum.RESERVATION_APPROVED.getCode() : MsgMessageCodeEnum.RESERVATION_REJECT.getCode();
        msgMessageService.processSendMessage(code, msgMap);
        log.info("%s 完成");
    }

    private void setText(List<ReservationAuditPageResDto> dtos) throws BaseException {
        for (ReservationAuditPageResDto dto : dtos) {
            dto.setStatusText(dictionaryService.toText(DicCode.DIC_RESERVATION_STATUS, dto.getStatus().toString()));
            dto.setCanAudit(ReservationStatusEnum.canAudit(dto.getStatus()));
            if (dto.getDisardId() != null)
                dto.setStatusText(dto.getStatusText() + "(已作废)");
        }
    }
}
