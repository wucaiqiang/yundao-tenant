package com.yundao.tenant.service.sale.declaration;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.finance.receipt.DeclarationForReceiptResDto;
import com.yundao.tenant.dto.finance.receipt.plan.ReceiptPlanDeclarationDto;
import com.yundao.tenant.dto.report.AfpReportDto;
import com.yundao.tenant.dto.report.ProductReportDto;
import com.yundao.tenant.dto.sale.declaration.*;
import com.yundao.tenant.dto.sale.declaration.apply.DeclarationApplyrReqDto;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationDiscard;
import com.yundao.tenant.model.sale.DeclarationModel;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface DeclarationService {

    /**
     * 查询有报单的产品id集合
     *
     * @param productIds
     * @return
     * @throws BaseException
     */
    List<Long> getHasDeclarationProductIds(String productIds) throws BaseException;
    
    /**
     * 判断某个预约是否有保单
     * hasDeclaration:
     * @author: 欧阳利
     * @param reservationId
     * @return
     * @throws BaseException
     * @description:
     */
    boolean hasDeclaration(Long reservationId)throws BaseException;


    public Result<Long> add(DeclarationReqDto reqDto) throws Exception;

    /**
     * 补入报单
     * patch:
     * @author: 欧阳利
     * @param reqDto
     * @return
     * @throws Exception
     * @description:
     */
    public Result<Long>  doPatch(DeclarationPatchReqDto reqDto) throws Exception;

    
    /**
     * 提交报单
     * submitDeclaration:
     *
     * @param reqDto
     * @return
     * @throws Exception
     * @author: 欧阳利
     * @description:
     */
    public Result<Long> doSubmitDeclaration(DeclarationReqDto reqDto) throws Exception;

    public Result<Integer> update(DeclarationReqDto reqDto) throws Exception;

    public Result<Boolean> updateForApp(Map<String, String> params) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<DeclarationResDto> get(Long id) throws Exception;

    public BaseDeclaration getBaseDeclaration(Long id) throws BaseException;

    public Result<PaginationSupport<DeclarationModel>> getPage(DeclarationPageReqDto declarationDto, AbstractBasePageDto pageDto) throws Exception;

    public Result<PaginationSupport<DeclarationModel>> searchForApp(DeclarationSearchReqDto declarationDto, AbstractBasePageDto pageDto) throws Exception;

    /**
     * 重新提交
     */
    Result<Long> doResubmit(DeclarationApplyrReqDto dto) throws BaseException;

    Result<Long> doResubmitForApp(DeclarationResubmitReqDto reqDto) throws BaseException;

    /**
     * 取消
     */
    Result<Long> doCancel(DeclarationApplyrReqDto dto) throws BaseException;

    /**
     * 修改身份资料
     *
     * @param dto 修改参数
     * @return
     */
    Result<Long> updateCredentials(DeclarationUpdateCredentialsDto dto) throws BaseException;

    /**
     * 修改合规文件
     *
     * @param dto
     * @return
     */
    Result<Long> updateCompliance(DeclarationUpdateComplianceDto dto) throws BaseException;

    /**
     * 修改银行卡信息
     *
     * @param dto
     * @return
     */
    Result<Long> updateBank(DeclarationUpdateBankDto dto) throws BaseException;

    /**
     * 修改认购信息
     *
     * @param dto
     * @return
     */
    Result<Long> updateSubscribe(DeclarationUpdateSubscribeDto dto) throws BaseException;

    /**
     * 预约作废
     *
     * @param dto
     * @return
     * @throws BaseException
     */
    Result<Long> doDiscard(DeclarationDiscardReqDto dto) throws BaseException;

    /**
     * 获取客户的订单数
     *
     * @param customerId
     * @return
     */
    Result<Integer> getCustomerCount(Long customerId) throws SQLException;

    /**
     * 通过报单id查询报单作废信息
     */
    public BaseDeclarationDiscard getBaseDeclarationDiscard(Long declarationId) throws BaseException;

    /**
     * 报单总额
     * getDeclarationTotal:
     *
     * @return
     * @throws BaseException
     * @author: wucq
     * @description:
     */
    public Result<Double> getDeclarationTotal(Date beginDate, Date endDate) throws BaseException;

    public List<ProductReportDto> getTotalByProductIds(String productIds) throws BaseException;

    /**
     * 理财师排名
     * getDeclarationRank:
     *
     * @param beginDate
     * @param endDate
     * @param limit
     * @return
     * @throws BaseException
     * @author: wucq
     * @description:
     */
    public Result<List<AfpReportDto>> getDeclarationRank(Date beginDate, Date endDate, Integer limit) throws BaseException;

    /**
     * 获取产品详情页面报单列表
     */
    Result<PaginationSupport<DeclarationForProDetailResDto>> getPageForProductDetail(Long productId) throws
            BaseException;

    /**
     * 获取能够关联到回款计划的订单
     *
     * @param productId 产品id
     */
    List<DeclarationForReceiptResDto> getCanReceiptDeclarations(Long productId) throws BaseException;

    /**
     * 获取回款计划关联的报单
     *
     * @param receiptPlanId 回款计划id
     */
    List<ReceiptPlanDeclarationDto> getReceiptPlanDeclarations(Long receiptPlanId) throws BaseException;

    /**
     * 提交报单
     * @param id
     * @return
     */
    Result<Long> processSubmit(Long id) throws BaseException;

    /**
     * 验证报单是否可以申请
     * @param id
     * @return
     */
    Result<Long> processValidate(Long id) throws BaseException;
    
    /**
     * 获取成单理财师信息
     * getDeclarationUserDto:
     * @author: 欧阳利
     * @return
     * @throws BaseException
     * @description:
     */
    public Result<List<DeclarationUserDto>> getDeclarationUserDtos(DeclarationUserReqDto reqDto)throws BaseException;
}
