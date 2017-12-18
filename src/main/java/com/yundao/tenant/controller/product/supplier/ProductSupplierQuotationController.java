package com.yundao.tenant.controller.product.supplier;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.product.supplier.ProductSupplierQuotationDetailDto;
import com.yundao.tenant.dto.product.supplier.ProductSupplierQuotationDto;
import com.yundao.tenant.dto.product.supplier.SupplierQuotationUpdateReqDto;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductSale;
import com.yundao.tenant.service.product.ProductSelectService;
import com.yundao.tenant.service.product.examine.ProductExamineService;
import com.yundao.tenant.service.product.supplier.ProductSupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/supplier_quotation")
@ResponseBody
@Api("产品供应商管理")
public class ProductSupplierQuotationController {

    @Autowired
    ProductSupplierService productSupplierService;
    @Autowired
    ProductSelectService productSelectService;
    @Autowired
    ProductExamineService productExamineService;

    /**
     * 修改产品供应商报价
     *
     * @param productId
     * @param supplierQuotationDto List<ProductSupplierQuotationDto>
     * @return
     */
    @ApiOperation(value = "修改产品供应商")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Integer> updateSupplierQuotation(@ModelAttribute SupplierQuotationUpdateReqDto reqDto) throws Exception {
        if (reqDto.getProductId() == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200041);
        }

        // 审核中的产品不能修改
        boolean isApprovaling = productExamineService.checkProductIsApprovaling(reqDto.getProductId());
        if (isApprovaling) {
            return Result.newFailureResult(CodeConstant.CODE_1200093);
        }

        BaseProduct baseProduct = productSelectService.getBaseProduct(reqDto.getProductId());
        if (baseProduct == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200042);
        }
        BaseProductSale baseProductSale = productSelectService.selectBaseProductSaleByProductId(reqDto.getProductId());
        if (baseProductSale == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200042);
        }

        // 检查是否有权限修改
        List<ProductSupplierQuotationDto> list = productSupplierService.getProductSupplierUpdateDto(reqDto.getSupplierDtos());

        // 校验报价
        Result<Boolean> quoResult = productSupplierService.checkProductSupplierforUpdate(list, baseProductSale.getIsScale(), baseProductSale.getProductScale());
        if (!quoResult.getSuccess()) {
            return Result.newFailureResult(quoResult.getCode());
        }

        // 修改数据
        return productSupplierService.updateSupplierQuotation(reqDto.getProductId(), list);
    }

    @ApiOperation(value = "根据产品id，获取供应商报价信息")
    @RequestMapping(value = "/get_by_product_id", method = RequestMethod.GET)
    public Result<List<ProductSupplierQuotationDetailDto>> getByProductId(@RequestParam Long productId) throws BaseException {
        if (productId == null)
            throw new BaseException(CodeConstant.CODE_1200041);
        return Result.newSuccessResult(productSupplierService.getProductSupplierQuotationDetailDtos(productId));
    }
}
