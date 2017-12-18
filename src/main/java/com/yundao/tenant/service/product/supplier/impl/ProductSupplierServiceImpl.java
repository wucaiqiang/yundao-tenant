package com.yundao.tenant.service.product.supplier.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.product.add.ProductQuotationDto;
import com.yundao.tenant.dto.product.add.ProductSupplierDto;
import com.yundao.tenant.dto.product.supplier.ProductQuotationDetailDto;
import com.yundao.tenant.dto.product.supplier.ProductQuotationUpdateDto;
import com.yundao.tenant.dto.product.supplier.ProductSupplierQuotationDetailDto;
import com.yundao.tenant.dto.product.supplier.ProductSupplierQuotationDto;
import com.yundao.tenant.mapper.base.product.BaseProductSupplierMapper;
import com.yundao.tenant.model.base.product.BaseProductSupplier;
import com.yundao.tenant.model.base.product.BaseProductSupplierExample;
import com.yundao.tenant.model.base.product.BaseProductSupplierQuotation;
import com.yundao.tenant.model.base.product.BaseSupplier;
import com.yundao.tenant.service.product.supplier.ProductSupplierQuotationService;
import com.yundao.tenant.service.product.supplier.ProductSupplierService;
import com.yundao.tenant.service.product.supplier.SupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 产品供应商管理
 *
 * @author 欧阳利
 *         2017年7月6日
 */
@Service
public class ProductSupplierServiceImpl extends AbstractService implements ProductSupplierService {

    @Autowired
    SupplierService supplierService;
    @Autowired
    BaseProductSupplierMapper baseProductSupplierMapper;
    @Autowired
    ProductSupplierQuotationService productSupplierQuotationService;

    /**
     * 添加产品供应商
     *
     * @param supplierDtos
     * @param productId
     * @throws BaseException
     * @throws Exception
     */
    public void saveProductSupplierQuotation(List<ProductSupplierDto> supplierDtos, Long productId) throws BaseException, Exception {
        if (BooleanUtils.isEmpty(supplierDtos)) {
            return;
        }
        for (ProductSupplierDto dto : supplierDtos) {
            // 添加产品供应商
            BaseProductSupplier productSupplier = saveProductSupplier(dto.getSupplierName(), productId, dto.getRemark());

            // 添加产品供应商报价
            productSupplierQuotationService.addProductQuotation(dto.getProductQuotationDtos(), productSupplier.getId());
        }
    }


    /**
     * 添加产品供应商
     *
     * @param supplierName
     * @param productId
     * @return
     * @throws BaseException
     * @throws Exception
     */
    private BaseProductSupplier saveProductSupplier(String supplierName, Long productId, String remark) throws BaseException, Exception {
        //添加供应商
        BaseSupplier record = new BaseSupplier();
        record.setName(supplierName);
        supplierService.saveOrIfExistSelect(record);

        // 添加产品供应商
        BaseProductSupplier productSupplier = new BaseProductSupplier();
        productSupplier.setCreateDate(new Date());
        productSupplier.setCreateUserId(this.getHeaderUserId());
        productSupplier.setTenantId(this.getHeaderTenantId());
        productSupplier.setIsDelete(0);
        productSupplier.setProductId(productId);
        productSupplier.setSupplierId(record.getId());
        productSupplier.setRemark(remark);
        baseProductSupplierMapper.insert(productSupplier);
        return productSupplier;
    }


    /**
     * 对象转换
     *
     * @param request
     * @return
     * @throws BaseException
     */
    public List<ProductSupplierDto> getProductSupplierDto(String supplierDtos) throws BaseException {
        if (BooleanUtils.isBlank(supplierDtos)) {
            return null;
        }
        JavaType javaType = JsonUtils.getCollectionType(List.class, ProductSupplierDto.class);
        List<ProductSupplierDto> list = JsonUtils.jsonToObject(supplierDtos, javaType);
        return list;
    }


    /**
     * 对象转换
     *
     * @param request
     * @return
     * @throws BaseException
     */
    public List<ProductSupplierQuotationDto> getProductSupplierUpdateDto(String supplierDtos) throws BaseException {
        if (BooleanUtils.isBlank(supplierDtos)) {
            return null;
        }
        JavaType javaType = JsonUtils.getCollectionType(List.class, ProductSupplierQuotationDto.class);
        List<ProductSupplierQuotationDto> list = JsonUtils.jsonToObject(supplierDtos, javaType);
        return list;
    }


    /**
     * 修改产品供应商报价
     *
     * @param productId
     * @param list
     * @return
     * @throws BaseException
     */
    public Result<Integer> updateSupplierQuotation(Long productId, List<ProductSupplierQuotationDto> list) throws Exception {
        if (BooleanUtils.isEmpty(list)) {
            // 删除所有供应商报价
            return deleteAllSupplierQuotation(productId);
        }

        // 查询所有产品供应商
        List<BaseProductSupplier> allProductSuppliers = selectAllProductSupplier(productId);
        for (ProductSupplierQuotationDto dto : list) {
            if (dto.getId() != null) {
                // 修改备注和供应商id
                BaseSupplier record = new BaseSupplier();
                record.setName(dto.getSupplierName());
                supplierService.saveOrIfExistSelect(record);
                Long supplierId = record.getId();
                updateSpplierAndRemark(dto.getId(), supplierId, dto.getRemark());
                // 修改存在的(只修改报价)
                productSupplierQuotationService.updateProductQuotation(dto.getProductQuotationDtos(), dto.getId());
            } else {
                // 添加产品供应商
                BaseProductSupplier productSupplier = saveProductSupplier(dto.getSupplierName(), productId, dto.getRemark());

                // 添加供应商报价
                productSupplierQuotationService.saveProductQuotation(dto.getProductQuotationDtos(), productSupplier.getId());
            }
        }

        // 删除不存在的
        List<Long> needDeleteProductSupplierIds = getNeedDeleteProductSupplierIds(allProductSuppliers, list);
        deleteProductSupplier(needDeleteProductSupplierIds);

        return Result.newSuccessResult(list.size());
    }

    /**
     * 修改备注
     */
    private void updateSpplierAndRemark(Long id, Long supplierId, String remark) {
        BaseProductSupplier record = new BaseProductSupplier();
        record.setRemark(remark);
        record.setSupplierId(supplierId);
        record.setUpdateDate(new Date());
        record.setCreateUserId(this.getHeaderUserId());
        BaseProductSupplierExample example = new BaseProductSupplierExample();
        example.createCriteria().andIdEqualTo(id);
        baseProductSupplierMapper.updateByExampleSelective(record, example);
    }


    /**
     * 获取需要删除的产品供应商id
     *
     * @param allProductSuppliers
     * @param list
     * @return
     */
    private List<Long> getNeedDeleteProductSupplierIds(List<BaseProductSupplier> allProductSuppliers, List<ProductSupplierQuotationDto> list) {
        if (BooleanUtils.isEmpty(allProductSuppliers)) {
            return null;
        }
        List<Long> allIds = new ArrayList<Long>();
        for (BaseProductSupplier all : allProductSuppliers) {
            allIds.add(all.getId());
        }

        if (BooleanUtils.isEmpty(allProductSuppliers)) {
            return allIds;
        }


        List<Long> currentIds = new ArrayList<Long>();
        for (ProductSupplierQuotationDto dto : list) {
            if (dto.getId() != null) {
                currentIds.add(dto.getId());
            }
        }

        List<Long> deleteIds = new ArrayList<Long>();
        for (Long id : allIds) {
            if (!currentIds.contains(id)) {
                deleteIds.add(id);
            }
        }
        return deleteIds;
    }


    /**
     * 查询一个产品的所有供应商
     *
     * @param productId
     * @return
     */
    private List<BaseProductSupplier> selectAllProductSupplier(Long productId) {
        if (productId == null) {
            return null;
        }
        // 查询所有产品供应商
        BaseProductSupplierExample example = new BaseProductSupplierExample();
        example.createCriteria().andProductIdEqualTo(productId);
        List<BaseProductSupplier> productSuppliers = baseProductSupplierMapper.selectByExample(example);
        return productSuppliers;
    }


    /**
     * 某个删除供应商报价
     *
     * @param productId
     * @return
     */
    private Result<Integer> deleteAllSupplierQuotation(Long productId) throws BaseException {
        if (productId == null) {
            return Result.newSuccessResult(0);
        }
        // 查询所有产品供应商
        List<BaseProductSupplier> productSuppliers = selectAllProductSupplier(productId);
        if (BooleanUtils.isEmpty(productSuppliers)) {
            return Result.newSuccessResult(0);
        }
        List<Long> productSuppliersIds = new ArrayList<Long>();
        for (BaseProductSupplier productSupplier : productSuppliers) {
            productSuppliersIds.add(productSupplier.getId());
        }
        // 删除产品供应商
        Result<Integer> result = deleteProductSupplier(productSuppliersIds);

        // 删除产品供应商报价
        productSupplierQuotationService.deleteProductQuotation(productSuppliersIds);
        return result;
    }


    private Result<Integer> deleteProductSupplier(List<Long> productSupplierIds) throws BaseException {
        if (BooleanUtils.isEmpty(productSupplierIds)) {
            return Result.newSuccessResult(0);
        }
        BaseProductSupplier record = new BaseProductSupplier();
        record.setIsDelete(1);
        record.setUpdateDate(new Date());
        record.setUpdateUserId(this.getHeaderUserId());
        BaseProductSupplierExample example = new BaseProductSupplierExample();
        example.createCriteria().andIdIn(productSupplierIds);
        int count = baseProductSupplierMapper.updateByExampleSelective(record, example);

        productSupplierQuotationService.deleteProductQuotation(productSupplierIds);
        return Result.newSuccessResult(count);
    }


    /**
     * 通过产品id查询产品报价信息
     *
     * @param productId
     * @return
     * @throws Exception
     */
    public List<ProductSupplierQuotationDetailDto> getProductSupplierQuotationDetailDtos(Long productId) throws
            BaseException {
        // 查询产品供应商
        BaseProductSupplierExample example = new BaseProductSupplierExample();
        example.createCriteria().andProductIdEqualTo(productId);
        List<BaseProductSupplier> baseProductSuppliers = baseProductSupplierMapper.selectByExample(example);
        if (BooleanUtils.isEmpty(baseProductSuppliers)) {
            return null;
        }
        List<ProductSupplierQuotationDetailDto> ProductSupplierQuotations = new ArrayList<ProductSupplierQuotationDetailDto>();
        List<Long> supplierIds = new ArrayList<Long>();
        List<Long> productSupplierIds = new ArrayList<Long>();
        for (BaseProductSupplier base : baseProductSuppliers) {
            ProductSupplierQuotationDetailDto dto = new ProductSupplierQuotationDetailDto();
            BeanUtils.copyProperties(base, dto);
            ProductSupplierQuotations.add(dto);
            supplierIds.add(base.getSupplierId());
            productSupplierIds.add(base.getId());
        }

        // 查询供应商并设置供应商名称
        List<BaseSupplier> baseSuppliers = supplierService.getBaseSuppliers(supplierIds);
        if (!BooleanUtils.isEmpty(baseSuppliers)) {
            for (ProductSupplierQuotationDetailDto dto : ProductSupplierQuotations) {
                for (BaseSupplier base : baseSuppliers) {
                    if (base.getId().equals(dto.getSupplierId())) {
                        dto.setSupplierName(base.getName());
                        break;
                    }
                }
            }
        }

        // 查询供应商报价详细信息
        List<BaseProductSupplierQuotation> supplierQuotations = productSupplierQuotationService.getBaseProductSupplierQuotations(productSupplierIds);
        if (BooleanUtils.isEmpty(supplierQuotations)) {
            return ProductSupplierQuotations;
        }
        List<ProductQuotationDetailDto> productQuotationDtos = new ArrayList<ProductQuotationDetailDto>();
        for (BaseProductSupplierQuotation base : supplierQuotations) {
            ProductQuotationDetailDto dto = new ProductQuotationDetailDto();
            BeanUtils.copyProperties(base, dto);
            productQuotationDtos.add(dto);
        }


        // 整合数据
        for (ProductSupplierQuotationDetailDto dto : ProductSupplierQuotations) {
            if (dto.getProductQuotationDtos() == null) {
                dto.setProductQuotationDtos(new ArrayList<ProductQuotationDetailDto>());
            }
            for (ProductQuotationDetailDto detailDto : productQuotationDtos) {
                if (dto.getId().equals(detailDto.getProductSupplierId())) {
                    dto.getProductQuotationDtos().add(detailDto);
                }
            }
        }

        return ProductSupplierQuotations;
    }

    /**
     * 检查产品供应商
     *
     * @param supplierDtos
     * @return
     * @throws Exception
     */
    public Result<Boolean> checkProductSupplierforAdd(List<ProductSupplierDto> supplierDtos, Integer isScale, Double productScale) throws BaseException {
        if (BooleanUtils.isEmpty(supplierDtos)) {
            return Result.newSuccessResult(true);
        }
        // 最多添加20个供应商
        if (supplierDtos.size() > 20) {
            return Result.newFailureResult(CodeConstant.CODE_1200055);
        }
        List<String> supplierNames = new ArrayList<String>();
        for (ProductSupplierDto supplierDto : supplierDtos) {
            // 在添加供应商时填入，输入长度上限为100
            if (BooleanUtils.isBlank(supplierDto.getSupplierName()) || supplierDto.getSupplierName().length() > 100) {
                return Result.newFailureResult(CodeConstant.CODE_1200056);
            }
            // 供应商的名称不能重复
            if (supplierNames.contains(supplierDto.getSupplierName().trim())) {
                return Result.newFailureResult(CodeConstant.CODE_1200086);
            }
            supplierNames.add(supplierDto.getSupplierName().trim());
            // 每个供应商最多添加20条报价
            if (BooleanUtils.isEmpty(supplierDto.getProductQuotationDtos()) || supplierDto.getProductQuotationDtos().size() > 20) {
                return Result.newFailureResult(CodeConstant.CODE_1200057);
            }

            // 非必填，输入内容为文本，输入长度上限为200
            if (!BooleanUtils.isBlank(supplierDto.getRemark()) && supplierDto.getRemark().length() > 100) {
                return Result.newFailureResult(CodeConstant.CODE_1200058);
            }

            if (!BooleanUtils.isEmpty(supplierDto.getProductQuotationDtos())) {
                boolean isFirst = true;
                Double saleMax = null;

                for (ProductQuotationDto dto : supplierDto.getProductQuotationDtos()) {
                    // 每只报价的最小值不能小于0
                    if (dto.getSaleMin() == null || dto.getSaleMin() < 0) {
                        return Result.newFailureResult(CodeConstant.CODE_1200067);
                    }
                    // 每只报价的最大值不能小于最小值
                    if (dto.getSaleMax() != null && dto.getSaleMax() < dto.getSaleMin()) {
                        return Result.newFailureResult(CodeConstant.CODE_1200068);
                    }

                    if (!isFirst) {
                        // 只有最后一只报价的最大值可以为空
                        if (saleMax == null) {
                            return Result.newFailureResult(CodeConstant.CODE_1200069);
                        }
                        // 下一只报价最小值必须大于上一只报价最大值
                        if (dto.getSaleMin() < saleMax) {
                            return Result.newFailureResult(CodeConstant.CODE_1200070);
                        }
                    }
                    saleMax = dto.getSaleMax();
                    isFirst = false;
                    // 检查报价范围是否大于产品规模
                    if (isScale != null && productScale != null && isScale == 1) {
                        if (dto.getSaleMin() > productScale) {
                            return Result.newFailureResult(CodeConstant.CODE_1200081);
                        }
                        if (saleMax != null && saleMax > productScale) {
                            return Result.newFailureResult(CodeConstant.CODE_1200081);
                        }
                    }
                }
            }
        }
        return Result.newSuccessResult(true);
    }

    /**
     * 检查产品供应商报价for update
     */
    public Result<Boolean> checkProductSupplierforUpdate(List<ProductSupplierQuotationDto> list, Integer isScale, Double productScale) throws BaseException {
        if (BooleanUtils.isEmpty(list)) {
            return Result.newSuccessResult(true);
        }
        List<ProductSupplierDto> supplierAddDtos = new ArrayList<ProductSupplierDto>();
        for (ProductSupplierQuotationDto updateDto : list) {
            // 转换报价
            ProductSupplierDto supplierAddDto = new ProductSupplierDto();
            BeanUtils.copyProperties(updateDto, supplierAddDto);
            supplierAddDtos.add(supplierAddDto);

            // 转换报价详情
            List<ProductQuotationUpdateDto> productQuotations = updateDto.getProductQuotationDtos();
            if (BooleanUtils.isEmpty(productQuotations)) {
                continue;
            }
            List<ProductQuotationDto> productQuotationDtos = new ArrayList<ProductQuotationDto>();
            supplierAddDto.setProductQuotationDtos(productQuotationDtos);
            for (ProductQuotationUpdateDto quotationDto : productQuotations) {
                ProductQuotationDto productQuotationDto = new ProductQuotationDto();
                BeanUtils.copyProperties(quotationDto, productQuotationDto);
                productQuotationDtos.add(productQuotationDto);
            }
        }
        return checkProductSupplierforAdd(supplierAddDtos, isScale, productScale);
    }

}
