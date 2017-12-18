package com.yundao.tenant.mapper.sale.leads;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.sale.leads.LeadsForCustomerDetailResDto;
import com.yundao.tenant.dto.sale.leads.LeadsPageResDto;
import com.yundao.tenant.dto.sale.leads.LeadsRemindResDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jan
 * @create 2017-09-07 AM8:22
 **/
public interface LeadsMapper {

    /**
     * 获取分页数据
     */
    List<LeadsPageResDto> selectPage(Map<String, Object> paramMap) throws BaseException;

    /**
     * 获取分页总条数
     */
    int selectPageCount(Map<String, Object> paramMap) throws BaseException;

    /**
     * 获取客户详情页面销售线索
     */
    List<LeadsForCustomerDetailResDto> selectPageForCustomerDetail(Map<String, Object> paramMap) throws BaseException;

    /**
     * 获取客户详情页面销售线索总条数
     */
    int selectPageForCustomerDetailCount(Map<String, Object> paramMap) throws BaseException;

    /**
     * 获取分未配线索
     *
     * @param customerId 客户id
     */
    List<LeadsRemindResDto> selectRemindUnAllot(@Param("customerId") Long customerId) throws BaseException;

    /**
     * 获取已分配线索
     */
    List<LeadsRemindResDto> selectRemindAlloted(Map<String, Object> paramMap) throws BaseException;
    
    /**
     * 查询已有的客户id集合中有预约理财师的客户id集合
     * getHasConsultFpCustomerIds:
     * @author: 欧阳利
     * @param customerIds
     * @return
     * @description:
     */
    public List<Long> getHasConsultFpCustomerIds(@Param("customerIds")List<Long> customerIds);
}
