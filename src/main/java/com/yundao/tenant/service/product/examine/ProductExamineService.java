package com.yundao.tenant.service.product.examine;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.product.examine.ProductAuditRecordResDto;
import com.yundao.tenant.dto.product.examine.ProductAuditReqDto;
import com.yundao.tenant.dto.product.examine.ProductExaminePageReqDto;
import com.yundao.tenant.dto.product.examine.ProductExaminePageResDto;
import com.yundao.tenant.model.base.product.BaseProductExamine;

/**
 * 产品审核服务接口
 *
 * @author jan
 * @create 2017-07-22 PM3:16
 **/
public interface ProductExamineService {

    /**
     * 获取产品审核分页数据
     */
    PaginationSupport<ProductExaminePageResDto> getPage(ProductExaminePageReqDto dto) throws BaseException;


    /**
     * 审核产品
     */
    Result<Long> doAudit(ProductAuditReqDto dto) throws BaseException;


    /**
     * 产品当前产品的审核信息
     *
     * @param productId
     * @return
     * @throws BaseException
     */
    BaseProductExamine getCurrentBaseProductExamine(Long productId) throws BaseException;

    /**
     * 检查产品是否审核中
     *
     * @param productId
     * @return
     * @throws BaseException
     */
    boolean checkProductIsApprovaling(Long productId) throws BaseException;
    
    
    /**
     * 查询产品的审核历史记录
     * getAuditDetail:
     * @author: 欧阳利
     * @param productId
     * @return
     * @throws BaseException
     * @description:
     */
    public Result<List<ProductAuditRecordResDto>> getAuditDetail(Long productId)throws BaseException;

}
