package com.yundao.tenant.controller.customercenter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FieldValueDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListReqDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListResDto;
import com.yundao.tenant.dto.product.h5.NoticeAttachDto;
import com.yundao.tenant.dto.product.h5.NoticeDetailDto;
import com.yundao.tenant.dto.product.h5.ProductH5BaseQueryReqDto;
import com.yundao.tenant.dto.product.h5.ProductH5BaseResDto;
import com.yundao.tenant.dto.product.h5.ProductH5DetailDto;
import com.yundao.tenant.dto.roadshow.RoadshowResDto;
import com.yundao.tenant.enums.bo.ProductTableFieldEnum;
import com.yundao.tenant.enums.product.ProductAttachShowTypeEnum;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductNotice;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttach;
import com.yundao.tenant.model.base.product.BaseProductSale;
import com.yundao.tenant.service.customercenter.ProductH5SelectService;
import com.yundao.tenant.service.field.FieldSelectService;
import com.yundao.tenant.service.field.FieldValueService;
import com.yundao.tenant.service.fieldgroup.FieldGroupService;
import com.yundao.tenant.service.product.ProductSelectService;
import com.yundao.tenant.service.product.attach.ProductAttachService;
import com.yundao.tenant.service.product.income.ProductIncomeRuleService;
import com.yundao.tenant.service.product.productnotice.ProductNoticeService;
import com.yundao.tenant.service.product.productnoticeattach.ProductNoticeAttachService;
import com.yundao.tenant.service.roadshow.RoadshowService;
import com.yundao.tenant.util.field.ProductPropertyUtils;
import com.yundao.tenant.util.field.PropertyUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product/h5")
@ResponseBody
@Api("H5产品管理")
public class ProductH5Controller {

	@Autowired
	private ProductSelectService productSelectService;

	@Autowired
	private ProductH5SelectService productH5SelectService;

	@Autowired
	private FieldSelectService fieldSelectService;

	@Autowired
	private FieldValueService fieldValueService;

	@Autowired
	private FieldGroupService fieldGroupService;

	@Autowired
	private ProductIncomeRuleService productIncomeRuleService;

	@Autowired
	private ProductNoticeService productNoticeService;

	@Autowired
	private ProductNoticeAttachService productNoticeAttachService;

	@Autowired
	ProductAttachService productAttachService;
	@Autowired
	private RoadshowService roadshowService;

	@ApiOperation(value = "首页热门产品")
	@RequestMapping(value = "/get_index_hot_product", method = RequestMethod.GET)
	public Result<List<ProductH5BaseResDto>> getHotProduct(@RequestParam String platformCode,
			@RequestParam Integer count) throws BaseException {
		if (BooleanUtils.isBlank(platformCode)) {
			Result.newSuccessResult(CodeConstant.CODE_1200166);
		}
		ProductH5BaseQueryReqDto reqDto = new ProductH5BaseQueryReqDto();
		reqDto.setPlatformCode(platformCode);
		reqDto.setPositionCode("index_hot_product");
		reqDto.setPageSize(count);
		return productH5SelectService.getHotList(reqDto);
	}

	/**
	 * 分页产品产品管理列表
	 *
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = "/get_List", method = RequestMethod.GET)
	@ApiOperation(value = "分页产品产品列表", notes = "分页查询产品列表")
	public Result<PaginationSupport<ProductH5BaseResDto>> getList(
			@Validated @ModelAttribute ProductH5BaseQueryReqDto reqDto, BindingResult bindingResult)
			throws BaseException {
		BindingResultHandler.handleByException(bindingResult);
		return productH5SelectService.getList(reqDto);
	}

	@ApiOperation(value = "通过产品id查询产品详情", notes = "通过产品id查询产品详情")
	@RequestMapping(value = "/get_detail_by_id", method = RequestMethod.GET)
	public Result<ProductH5DetailDto> getProductDetailDto(@RequestParam Long id) throws Exception {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}
		// 产品是否存在
		BaseProduct baseProduct = productSelectService.getBaseProduct(id);
		if (baseProduct == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200042);
		}
		ProductH5DetailDto productDetailDto = new ProductH5DetailDto();
		productDetailDto.setName(baseProduct.getName());
		productDetailDto.setTimeLimit(baseProduct.getTimeLimit());
		productDetailDto.setHighlight(baseProduct.getHighlight());
		productDetailDto.setBuyStartPoint(baseProduct.getBuyStartPoint());

		// 产品销售信息
		BaseProductSale baseProductSale = productSelectService.selectBaseProductSaleByProductId(id);
		// 查询产品的字段
		List<FieldDto> fieldDtos = fieldSelectService.getProductFieldByTypeId(baseProduct.getTypeId());

		// 删除部分字段
		fieldDtos = FieldDto.deleteNotContain(fieldDtos, ProductTableFieldEnum.getAppNotContainPropertyNames());

		// 对象转换
		List<FieldDetailDto> productFieldDtos = ProductPropertyUtils.getALlProductFieldDtos(fieldDtos);
		productDetailDto.setProductFieldDtos(productFieldDtos);

		// 合并数据
		ProductPropertyUtils.mergeProductField(productFieldDtos, baseProduct);
		ProductPropertyUtils.mergeProductSaleField(productFieldDtos, baseProductSale);
		ProductPropertyUtils.setNumberDecima(productFieldDtos);
		// 设置对接人和产品助理的名称
		productSelectService.setReceiverAndAssistantName(productFieldDtos);
		// 查询扩展字段
		List<FieldValueDto> fieldValueDtos = fieldValueService.getProductFieldValues(baseProduct.getTypeId(), id);
		PropertyUtils.setExtProperty(productFieldDtos, fieldValueDtos, null);
		fieldValueService.setImageFieldValue(productFieldDtos);
		// 设置产品类型
		productDetailDto.setId(id);
		productDetailDto.setTypeId(baseProduct.getTypeId());
		productDetailDto.setTypeIdText(fieldGroupService.getNameById(baseProduct.getTypeId()));
		// 设置附件信息
		ProductAttachListReqDto reqDto = new ProductAttachListReqDto();
		reqDto.setProductId(id);
		List<ProductAttachListResDto> attachListResDtos = productAttachService.getAll(id);
		if (attachListResDtos != null && !attachListResDtos.isEmpty()) {
			List<ProductAttachListResDto> outsideAttach = new ArrayList<>();
			for (ProductAttachListResDto attach : attachListResDtos) {
				if (attach.getShowType() != null && (attach.getShowType() == ProductAttachShowTypeEnum.ALL.getValue()
						|| attach.getShowType() == ProductAttachShowTypeEnum.OUTSIDE.getValue())) {
					// 过滤掉内部可见的附件
					outsideAttach.add(attach);
				}
			}
			productDetailDto.setAttachDtos(outsideAttach);
		}

		// 设置收益
		productDetailDto.setIncomeDtos(productIncomeRuleService.getIncomeRuleDetailDtos(id));

		// 设置产品公告
		productDetailDto.setNoticeDtos(productH5SelectService.getProductNoticeDtos(id));

		// 设置路演
		Result<List<RoadshowResDto>> roadshowResult = roadshowService.getByProductId(productDetailDto.getId());
		if (roadshowResult.getResult() != null && !roadshowResult.getResult().isEmpty()) {
			productDetailDto.setRoadshows(roadshowResult.getResult());
		}
		return Result.newSuccessResult(productDetailDto);
	}

	@ApiOperation(value = "查询公告详情", notes = "查询公告详情")
	@RequestMapping(value = "/notice/get", method = RequestMethod.GET)
	public Result<NoticeDetailDto> getNoticeDetail(@RequestParam Long id) throws Exception {
		Result<BaseProductNotice> result = productNoticeService.get(id);
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		BaseProductNotice base = result.getResult();
		NoticeDetailDto dto = new NoticeDetailDto();
		BeanUtils.copyProperties(base, dto);

		BaseProduct baseProduct = productSelectService.getBaseProduct(dto.getProductId());
		if (baseProduct == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200042);
		}
		dto.setProductName(baseProduct.getName());

		List<BaseProductNoticeAttach> list = productNoticeAttachService.gets(id);
		if (!BooleanUtils.isEmpty(list)) {
			List<NoticeAttachDto> attachDtos = new ArrayList<NoticeAttachDto>();
			dto.setAttachDtos(attachDtos);
			for (BaseProductNoticeAttach attachDto : list) {
				NoticeAttachDto noticeAttachDto = new NoticeAttachDto();
				BeanUtils.copyProperties(attachDto, noticeAttachDto);
				attachDtos.add(noticeAttachDto);
			}
		}

		return Result.newSuccessResult(dto);
	}
}
