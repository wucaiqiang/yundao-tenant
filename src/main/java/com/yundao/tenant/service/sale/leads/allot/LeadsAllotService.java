package com.yundao.tenant.service.sale.leads.allot;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.sale.leads.LeadsAllotReqDto;
import com.yundao.tenant.dto.sale.leads.LeadsAllotToFpReqDto;
import com.yundao.tenant.dto.sale.leads.LeadsRemindResDto;
import com.yundao.tenant.model.base.sale.BaseLeads;

import java.util.List;

/**
 * 线索分配服务接口
 *
 * @author jan
 * @create 2017-09-09 PM6:31
 **/
public interface LeadsAllotService {


    /**
     * 尝试分配线索给客户
     */
    Result<List<LeadsRemindResDto>> doTryAllot(LeadsAllotReqDto dto) throws BaseException;

    /**
     * 分配线索给客户
     */
    Result<Boolean> doAllot(LeadsAllotReqDto dto) throws BaseException;

    /**
     * 分配给理财师
     */
    Result<Boolean> doAllotToFp(LeadsAllotToFpReqDto dto) throws BaseException;

    /**
     * 获取未分配线索
     *
     * @param customerId 客户id
     */
    Result<List<LeadsRemindResDto>> getUnAllots(Long customerId) throws BaseException;

    /**
     * 客户分配时，设置客户的所有线索isAllotedFp值为1
     *
     * @throws BaseException
     */
    void updateIsAllotedFp(Long customerId) throws BaseException;

    /**
     * 获取线索
     *
     * @param id 线索id
     */
    BaseLeads getById(Long id) throws BaseException;

}
