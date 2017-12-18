package com.yundao.tenant.service.product;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.product.FundDto;
import com.yundao.tenant.dto.product.ProductBaseUpdateReqDto;
import com.yundao.tenant.dto.product.add.ProductAddListDto;
import com.yundao.tenant.dto.product.add.ProductAddReqDto;
import com.yundao.tenant.model.base.product.BaseProduct;

import java.util.List;
import java.util.Map;


/**
 * 产品管理
 *
 * @author 欧阳利
 *         2017年7月5日
 */
public interface ProductService {

    /**
     * 数据校验
     *
     * @param dto
     * @return
     * @throws BaseException
     */
    Result<Boolean> checkProductAddListDto(ProductAddListDto dto, Integer isScale, Double productScale) throws BaseException;


    /**
     * 获取添加的集合
     *
     * @return
     */
    ProductAddListDto getProductAddListDto(ProductAddReqDto productAddReqDto) throws Exception;


    /**
     * 添加产品
     *
     * @param productAddReqDto
     * @return
     * @throws BaseException
     */
    public Result<Long> saveProduct(ProductAddReqDto productAddReqDto, Map<String, String> params, List<FieldDto> list, ProductAddListDto productAddListDto) throws BaseException, Exception;


    /**
     * 修改产品基本信息
     *
     * @param updateReqDto
     * @param params
     * @param list
     * @return
     * @throws BaseException
     * @throws Exception
     */
    public Result<Integer> updateBaseProduct(ProductBaseUpdateReqDto updateReqDto, Map<String, String> params, List<FieldDto> list) throws Exception;

    /**
     * 删除产品信息
     *
     * @param ids
     * @return
     * @throws Exception
     */
    public Result<Integer> delete(List<Long> ids) throws Exception;

    /**
     * 关注产品
     *
     * @param ids
     * @return
     * @throws Exception
     */
    public Result<Integer> doFocusProduct(List<Long> ids) throws Exception;

    /**
     * 取消产品关注
     *
     * @param ids
     * @return
     * @throws Exception
     */
    public Result<Integer> doCancelFocusProduct(List<Long> ids) throws Exception;

    /**
     * 获取cp
     *
     * @param id 产品id
     */
    BaseProduct get(Long id) throws BaseException;

    /**
     * 检查是否存在，如果不存在直接返回
     *
     * @param id 产品id
     */
    void checkNotNullAndTerminal(Long id) throws BaseException;

    /**
     * 从基金导入
     */
    Result<Long> doImportFormFund(FundDto dto) throws BaseException;
}
