package com.yundao.tenant.service.sale.leads;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.sale.leads.LeadsAddReqDto;
import com.yundao.tenant.dto.sale.leads.LeadsForCustomerDetailReqDto;
import com.yundao.tenant.dto.sale.leads.LeadsForCustomerDetailResDto;
import com.yundao.tenant.dto.sale.leads.LeadsPageReqDto;
import com.yundao.tenant.dto.sale.leads.LeadsPageResDto;
import com.yundao.tenant.dto.sale.leads.LeadsUpdateStatusReqDto;

/**
 * 销售线索服务接口
 *
 * @author jan
 * @create 2017-09-06 PM8:00
 **/
public interface LeadsService {

    /**
     * 获取分页数据
     */
    Result<PaginationSupport<LeadsPageResDto>> getPage(LeadsPageReqDto dto, Integer permission) throws BaseException;

    /**
     * 获取客户详情页面销售线索
     */
    Result<PaginationSupport<LeadsForCustomerDetailResDto>> getPageForCustomerDetail(LeadsForCustomerDetailReqDto dto, Integer permission)
            throws BaseException;

    /**
     * 获取客户详情页面销售线索总条数
     */
    Integer getPageForCustomerDetailCount(LeadsForCustomerDetailReqDto dto, Integer permission) throws BaseException;

    /**
     * 添加线索
     *
     * @param mobile 客户手机号码
     * @param dto    线索dto
     * @return 返回新添加的线索id
     */
    Result<Long> add(String mobile, LeadsAddReqDto dto) throws BaseException;

    /**
     * 添加线索
     *
     * @param customerId 客户id
     * @param dto        线索dto
     * @return 返回新添加的线索id
     */
    Result<Long> add(Long customerId, LeadsAddReqDto dto) throws BaseException;

    /**
     * 更改线索状态
     */
    Result<Long> updateStatus(LeadsUpdateStatusReqDto dto) throws BaseException;

    /**
     * 检查是否能分配给客服回访
     */
    Boolean checkCanBeAllotToCs(Integer isOnceInvalid, Integer isAllotedCs) throws BaseException;

    /**
     * 检查是否能分配给理财师
     */
    Boolean checkCanBeAllotToFp(Integer isOnceInvalid, Integer isAllotedFp) throws BaseException;
    
    
    /**
     * 查询有预约理财师的客户id集合
     * getHasConsultFpCustomerIds:
     * @author: 欧阳利
     * @param customerIds
     * @return
     * @throws BaseException
     * @description:
     */
    List<Long> getHasConsultFpCustomerIds(List<Long> customerIds)throws BaseException;

}
