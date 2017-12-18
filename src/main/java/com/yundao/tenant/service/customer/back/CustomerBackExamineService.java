package com.yundao.tenant.service.customer.back;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.customer.back.CustomerBackApplyReqDto;
import com.yundao.tenant.dto.customer.back.CustomerBackExamineListReqDto;
import com.yundao.tenant.dto.customer.back.CustomerBackExamineListResDto;
import com.yundao.tenant.dto.customer.back.CustomerBackExamineRejectReqDto;

/**
 * 客户回退服务接口
 *
 * @author jan
 * @create 2017-08-10 PM2:43
 **/
public interface CustomerBackExamineService {

    /**
     * 申请回退客户
     */
    Result<Boolean> doApply(CustomerBackApplyReqDto dto) throws BaseException;

    /**
     * 申请回退客户
     */
    Result<PermissionResultDto> doApplyV2(CustomerBackApplyReqDto dto) throws BaseException;

    /**
     * 审批通过
     *
     * @param id
     * @return
     * @throws BaseException
     */
    Result<Integer> doPass(Long id) throws BaseException;

    /**
     * 驳回
     *
     * @param dto
     * @return
     * @throws BaseException
     */
    Result<Integer> doReject(CustomerBackExamineRejectReqDto dto) throws BaseException;

    /**
     * 分页查询审核信息
     *
     * @param reqDto
     * @return
     * @throws BaseException
     */
    Result<PaginationSupport<CustomerBackExamineListResDto>> gets(CustomerBackExamineListReqDto reqDto) throws BaseException;

    /**
     * 检查客户申请是否在申请中
     *
     * @param id
     * @return
     */
    Result<Boolean> checkCustomerBackExaminIsApply(Long id) throws BaseException;
}
