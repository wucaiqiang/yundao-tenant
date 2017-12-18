package com.yundao.tenant.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.product.attach.ProductAttachAddReqDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListReqDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListResDto;
import com.yundao.tenant.dto.product.attach.ProductAttachUpdateReqDto;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductAttach;
import com.yundao.tenant.service.product.ProductSelectService;
import com.yundao.tenant.service.product.attach.ProductAttachService;
import com.yundao.tenant.service.product.examine.ProductExamineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 产品附件管理
 * 
 * @author 欧阳利 2017年7月11日
 */
@RestController
@RequestMapping("/product/attach")
@ResponseBody
@Api("产品附件管理")
public class ProductAttachController {
	private static Log log = LogFactory.getLog(ProductAttachController.class);

	@Autowired
	ProductAttachService productAttachService;
	@Autowired
	ProductSelectService productSelectService;
	@Autowired
	ProductExamineService productExamineService;

	/**
	 * 添加产品附件
	 * 
	 * @return
	 */
	@ApiOperation(value = "添加产品附件")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<Long> add(@ModelAttribute ProductAttachAddReqDto reqDto) throws Exception {
		log.info("添加产品附件:", reqDto);
		if (reqDto == null || reqDto.getProductId() == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}

		// 检查产品是否存在
		BaseProduct baseProduct = productSelectService.getBaseProduct(reqDto.getProductId());
		if (baseProduct == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200042);
		}

		// 审核中的产品不能修改
		boolean isApprovaling = productExamineService.checkProductIsApprovaling(reqDto.getProductId());
		if (isApprovaling) {
			return Result.newFailureResult(CodeConstant.CODE_1200093);
		}

		return productAttachService.saveProductAttach(reqDto);
	}

	@ApiOperation(value = "修改产品附件")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<Long> update(@ModelAttribute ProductAttachUpdateReqDto reqDto) throws Exception {
		log.info("添加产品附件:", reqDto);
		return productAttachService.update(reqDto);
	}

	/**
	 * 删除产品附件
	 * 
	 * @return
	 */
	@ApiOperation(value = "删除产品附件")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Result<Integer> delete(@RequestParam Long id) throws Exception {
		log.info("删除产品附件Id:", id);
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200049);
		}
		// 检查是否是否存在
		BaseProductAttach base = productAttachService.getBaseProductAttach(id);
		if (base == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200080);
		}

		// 审核中的产品不能修改
		boolean isApprovaling = productExamineService.checkProductIsApprovaling(base.getProductId());
		if (isApprovaling) {
			return Result.newFailureResult(CodeConstant.CODE_1200093);
		}

		return productAttachService.delete(id);
	}

	/**
	 * 产品附件列表
	 * 
	 * @return
	 */
	@ApiOperation(value = "分页产品附件")
	@RequestMapping(value = "/gets", method = RequestMethod.GET)
	public Result<PaginationSupport<ProductAttachListResDto>> gets(@ModelAttribute ProductAttachListReqDto ReqDto)
			throws Exception {
		log.info("附件产品附件:", ReqDto);
		return productAttachService.gets(ReqDto);
	}

	/**
	 * 产品附件列表
	 * 
	 * @return
	 */
	@ApiOperation(value = "分页产品附件")
	@RequestMapping(value = "/get_all", method = RequestMethod.GET)
	public Result<List<ProductAttachListResDto>> getAll(@RequestParam Long productId) throws Exception {
		log.info("附件产品附件:", productId);
		return Result.newSuccessResult(productAttachService.getAll(productId));
	}

}
