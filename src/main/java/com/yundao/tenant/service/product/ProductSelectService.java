package com.yundao.tenant.service.product;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.field.FiledSelectDto;
import com.yundao.tenant.dto.product.ProductBaseQueryReqDto;
import com.yundao.tenant.dto.product.ProductBaseResDto;
import com.yundao.tenant.dto.product.ProductManagerListReqDto;
import com.yundao.tenant.dto.product.ProductManagerListResDto;
import com.yundao.tenant.dto.product.ProductReservationDeclarationReportDto;
import com.yundao.tenant.dto.product.ProductSelectOptionDto;
import com.yundao.tenant.dto.product.ProductSelectionForDeclaration;
import com.yundao.tenant.dto.product.ProductSelectionForReceiptPlanDto;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductSale;

public interface ProductSelectService {
    /**
     * 获取产品管理列表查询的下拉选项的条件
     *
     * @return
     * @throws Exception
     */
    public Result<List<FiledSelectDto>> getProductManagetrListSelectValue() throws Exception;

    /**
     * 查询产品管理列表
     *
     * @param reqDto
     * @return
     * @throws BaseException
     */
    public Result<PaginationSupport<ProductManagerListResDto>> getManagerList(ProductManagerListReqDto reqDto) throws BaseException;

    /**
     * get:
     *
     * @param reqDto
     * @return
     * @throws BaseException
     * @author: wucq
     * @description:
     */
    public Result<PaginationSupport<ProductBaseResDto>> getList(ProductBaseQueryReqDto reqDto) throws BaseException;
    /**
     * 获取可直接报单或有我客户成功预约的产品列表信息
     * getDirectModelOrHadReservationList:
     * @author: wucq
     * @param reqDto
     * @return
     * @throws BaseException
     * @description:
     */
    public Result<PaginationSupport<ProductBaseResDto>> getDirectModelOrHadReservationList(ProductBaseQueryReqDto reqDto) throws BaseException;
    
    public Result<List<ProductReservationDeclarationReportDto>> getReserationDeclarationTotal(String productIds) throws BaseException;

    /**
     * 获取推荐产品
     * getReCommendedList:
     *
     * @param limit
     * @return
     * @throws BaseException
     * @author: wucq
     * @description:
     */
    public Result<List<ProductBaseResDto>> getReCommendedList(Integer limit,String platformCode,String positionCode) throws BaseException;


    /**
     * 获取产品下拉选择列表(默认显示10条)
     *
     * @param name
     * @return
     */
    public Result<List<ProductSelectOptionDto>> getProductSelectOptionDtos(String name, Integer count) throws BaseException;

    /**
     * 销售管理模块 产品下拉选项
     *
     * @param name 产品名称
     */
    Result<List<ProductSelectOptionDto>> getSelectionForSale(String name, Integer count) throws BaseException;

    
    /**
     * 产品下拉列表查询
     * getProductSelectForDeclaration:
     * @author: 欧阳利
     * @param name
     * @param count
     * @return
     * @throws BaseException
     * @description:
     */
    Result<List<ProductSelectionForDeclaration>> getProductSelectForDeclaration(String name, Integer count)throws BaseException;
    
    /**
     * 获取产品下拉选择列表(默认显示10条)
     *
     * @param typeId
     * @param count
     * @return
     */
    public Result<List<ProductSelectOptionDto>> getProductSelectOptionDtosByTypeId(Long typeId, Integer count) throws BaseException;

    /**
     * 检查产品是否存在
     *
     * @param productId
     * @return
     * @throws BaseException
     */
    public boolean checkProductExist(Long productId) throws BaseException;


    /**
     * 通过产品id查询超信息
     *
     * @param productId
     * @return
     * @throws BaseException
     */
    public BaseProduct getBaseProduct(Long productId) throws BaseException;

    /**
     * 根据多个id获取
     *
     * @param ids 多个以逗号分隔的id
     */
    List<BaseProduct> getByIds(String ids) throws BaseException;

    /**
     * 通过产品id获取产品销售信息
     *
     * @param productId
     * @return
     */
    public BaseProductSale selectBaseProductSaleByProductId(Long productId) throws BaseException;

    /**
     * 设置对接人和助理的名称
     *
     * @param productFieldDtos
     * @throws BaseException
     */
    public void setReceiverAndAssistantName(List<FieldDetailDto> productFieldDtos) throws BaseException;

    /**
     * 检查当前用户是否关注
     *
     * @param productId
     * @return
     * @throws BaseException
     */
    public boolean checkCurrentUserIsFocus(Long productId) throws BaseException;

    /**
     * 添加回款计划，产品下拉选项
     *
     * @param name 产品名称
     */
    Result<List<ProductSelectionForReceiptPlanDto>> getForReceiptPlan(String name) throws BaseException;
}
