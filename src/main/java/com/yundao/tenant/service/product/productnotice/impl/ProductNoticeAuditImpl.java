

package com.yundao.tenant.service.product.productnotice.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.enums.ProcessDefineKeyEnum;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.productnotice.NoticeStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.product.productnotice.ProductNoticeMapper;
import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRel;
import com.yundao.tenant.service.product.productnotice.ProductNoticeAudit;
import com.yundao.tenant.service.workflow.WorkflowBusinessRelService;
import com.yundao.tenant.service.workflow.WorkflowServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 * Reason:
 * Date:     2017年9月25日 上午10:56:36
 *
 * @author 欧阳利
 */
@Service
public class ProductNoticeAuditImpl implements ProductNoticeAudit {

    @Autowired
    WorkflowBusinessRelService workflowBusinessRelService;

    @Autowired
    WorkflowServie workflowServie;

    @Autowired
    private ProductNoticeMapper productNoticeMapper;

    /**
     * 任务处理
     * doTaskApplyAndAudit:
     *
     * @param noticeId
     * @param reason
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    public void doTaskApplyAndAudit(Long noticeId, Integer nextStatus, String reason) throws BaseException {
        if (nextStatus.equals(NoticeStatusEnum.STATUS_2.getStatus())) {
            Boolean isApply = isApplyRelease(noticeId);
            if (isApply) {
                doApplyRelease(noticeId);
            } else {
                doAgainSubmit(noticeId);
            }
        } else if (nextStatus.equals(NoticeStatusEnum.STATUS_3.getStatus())) {
            doPass(noticeId);
        } else if (nextStatus.equals(NoticeStatusEnum.STATUS_4.getStatus())) {
            doReject(noticeId, reason);
        } else if (nextStatus.equals(NoticeStatusEnum.STATUS_5.getStatus())) {
            doCancel(noticeId, reason);
        }
    }


    /**
     * 是否申请发布
     * isApplyRelease:
     *
     * @return
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    public boolean isApplyRelease(Long noticeId) throws BaseException {
        List<BaseWorkflowBusinessRel> list = workflowBusinessRelService
                .getBusinessNos(noticeId, ProcessDefineKeyEnum.PRODUCT_NOTICE.getKey(), YesOrNoEnum.NO.getValue());
        return BooleanUtils.isEmpty(list);
    }

    /**
     * 申请发布
     * doApplyRelease:
     *
     * @author: 欧阳利
     * @description:
     */
    @Override
    public void doApplyRelease(Long noticeId) throws BaseException {
        workflowServie.start(noticeId, ProcessDefineKeyEnum.PRODUCT_NOTICE.getKey(), BusinessTypeCode.PRODUCT_NOTICE);
    }

    /**
     * 重新提交
     * doAgainSubmit:
     *
     * @author: 欧阳利
     * @description:
     */
    @Override
    public void doAgainSubmit(Long noticeId) throws BaseException {
        // 重置审批时间
        productNoticeMapper.resetAuditDate(noticeId);
        // 完成任务
        String taskId = workflowServie.getTODOTaskId(noticeId, BusinessTypeCode.PRODUCT_NOTICE, false).getResult();
        workflowServie.complete(taskId, WorkflowActionEnum.RESUBMIT.getValue());


    }


    /**
     * 驳回
     * doRejectSubmit:
     *
     * @author: 欧阳利
     * @description:
     */
    @Override
    public void doReject(Long noticeId, String reason) throws BaseException {
        String taskId = workflowServie.getTODOTaskId(noticeId, BusinessTypeCode.PRODUCT_NOTICE, false).getResult();
        workflowServie.complete(taskId, WorkflowActionEnum.REJECT.getValue(), reason);
    }

    /**
     * 通过
     * doPass:
     *
     * @author: 欧阳利
     * @description:
     */
    @Override
    public void doPass(Long noticeId) throws BaseException {
        String taskId = workflowServie.getTODOTaskId(noticeId, BusinessTypeCode.PRODUCT_NOTICE, false).getResult();
        workflowServie.complete(taskId, WorkflowActionEnum.PASS.getValue());
    }

    /**
     * 取消
     * doCancel:
     *
     * @author: 欧阳利
     * @description:
     */
    @Override
    public void doCancel(Long noticeId, String reason) throws BaseException {
        String taskId = workflowServie.getTODOTaskId(noticeId, BusinessTypeCode.PRODUCT_NOTICE, true).getResult();
        workflowServie.complete(taskId, WorkflowActionEnum.CANCEL.getValue(), reason);
    }

}

