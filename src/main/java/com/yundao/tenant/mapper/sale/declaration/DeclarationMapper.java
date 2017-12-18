package com.yundao.tenant.mapper.sale.declaration;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.finance.knotcommission.DeclarationAuditKnot;
import com.yundao.tenant.dto.finance.knotcommission.DeclarationKnot;
import com.yundao.tenant.dto.finance.receipt.DeclarationForReceiptResDto;
import com.yundao.tenant.dto.finance.receipt.plan.ReceiptPlanDeclarationDto;
import com.yundao.tenant.dto.report.AfpReportDto;
import com.yundao.tenant.dto.report.ProductReportDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationForProDetailResDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationResDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUserDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUserReqDto;
import com.yundao.tenant.dto.sale.declaration.ProductDeclarationAmountDto;
import com.yundao.tenant.dto.sale.declaration.ProductDeclarationDto;
import com.yundao.tenant.model.sale.DeclarationModel;

public interface DeclarationMapper {

    public List<ProductDeclarationDto> getProductDeclarationDtos(@Param("declarationIds") List<Long> declarationIds);


    public List<DeclarationModel> queryPageInfo(Map<String, Object> params) throws SQLException;

    public Integer queryPageCount(Map<String, Object> params) throws SQLException;

    public List<DeclarationModel> selectSearchPage(Map<String, Object> params) throws SQLException;

    public Integer selectSearchPageCount(Map<String, Object> params) throws SQLException;

    DeclarationResDto selectByPrimaryKey(Long id);

    List<DeclarationForProDetailResDto> selectPageForProDetail(Map<String, Object> params) throws BaseException;

    int selectPageForProDetailCount(Map<String, Object> params) throws BaseException;

    /**
     * 查询审核通过并没有作废的报单总金额 getProductDeclarationAmountDtos:
     *
     * @param productIds
     * @return
     * @author: 欧阳利
     * @description:
     */
    List<ProductDeclarationAmountDto> getProductDeclarationAmountDtos(@Param("productIds") List<Long> productIds);

    /**
     * 查询有报单的理财师id getFpDeclarationByProductId:
     *
     * @param productId
     * @return
     * @author: 欧阳利
     * @description:
     */
    List<Long> getFpDeclarationByProductId(@Param("productId") Long productId);

    /**
     * 报单总额
     * selectDeclarationTotal:
     *
     * @return
     * @author: wucq
     * @description:
     */
    Double selectDeclarationTotal(@Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

    List<ProductReportDto> selectTotalByProductIds(@Param("productIds") String productIds);

    List<AfpReportDto> selectDeclarationRank(@Param("beginDate") Date beginDate, @Param("endDate") Date endDate, @Param("limit") Integer limit);

    /**
     * 获取能够关联到回款计划的订单
     *
     * @param productId 产品id
     */
    List<DeclarationForReceiptResDto> selectCanReceiptDeclarations(@Param("productId") Long productId) throws BaseException;

    /**
     * 获取结佣的报单
     *
     * @param params
     * @return
     */
    List<DeclarationKnot> queryPageKnotInfo(Map<String, Object> params);

    Integer queryPageKnotCount(Map<String, Object> params) throws SQLException;

    /**
     * 获取回款计划关联的报单
     *
     * @param receiptPlanId 回款计划id
     */
    List<ReceiptPlanDeclarationDto> selectReceiptPlanDeclarations(@Param("receiptPlanId") Long receiptPlanId) throws BaseException;

    /**
     * 查询审核的分页信息
     *
     * @param params
     * @return
     */
    List<DeclarationAuditKnot> queryPageAuditKnotInfo(Map<String, Object> params);

    /**
     * 分配查询个数
     * @param params
     * @return
     */
    int queryPageAuditKnotCount(Map<String, Object> params);
    
    
    
    List<DeclarationUserDto> selectDeclarationUserDots(DeclarationUserReqDto reqDto);
}
