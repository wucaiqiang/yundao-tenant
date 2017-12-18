
package com.yundao.tenant.controller.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.enums.NumberEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.RequestUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.common.FailListDto;
import com.yundao.tenant.dto.common.PassListDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.field.DateRangeFieldDto;
import com.yundao.tenant.dto.field.FieldDetailAndValueDto;
import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FieldValueDto;
import com.yundao.tenant.dto.field.FieldValueValidateFailResultDto;
import com.yundao.tenant.dto.field.FiledSelectDto;
import com.yundao.tenant.dto.field.ValuesDto;
import com.yundao.tenant.dto.product.FundDto;
import com.yundao.tenant.dto.product.ProductBaseQueryReqDto;
import com.yundao.tenant.dto.product.ProductBaseResDto;
import com.yundao.tenant.dto.product.ProductBaseUpdateReqDto;
import com.yundao.tenant.dto.product.ProductManagerListReqDto;
import com.yundao.tenant.dto.product.ProductManagerListResDto;
import com.yundao.tenant.dto.product.ProductReservationDeclarationReportDto;
import com.yundao.tenant.dto.product.ProductSaleUpdateReqDto;
import com.yundao.tenant.dto.product.ProductSelectOptionDto;
import com.yundao.tenant.dto.product.ProductSelectionForDeclaration;
import com.yundao.tenant.dto.product.ProductSelectionForReceiptPlanDto;
import com.yundao.tenant.dto.product.add.ProductAddListDto;
import com.yundao.tenant.dto.product.add.ProductAddReqDto;
import com.yundao.tenant.dto.product.add.ProductFieldDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListReqDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionRuleDetailDto;
import com.yundao.tenant.dto.product.detail.ProductDetailDto;
import com.yundao.tenant.dto.product.detail.ProductPartDetailDto;
import com.yundao.tenant.dto.product.income.IncomeRuleDetailDto;
import com.yundao.tenant.dto.report.ProductReportDto;
import com.yundao.tenant.dto.roadshow.RoadshowResDto;
import com.yundao.tenant.dto.select.SelectConfigDto;
import com.yundao.tenant.dto.user.UserInfoDto;
import com.yundao.tenant.enums.PlatformEnum;
import com.yundao.tenant.enums.bo.ProductTableFieldEnum;
import com.yundao.tenant.enums.product.FieldEnum;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.enums.product.ProductManagerActionEnum;
import com.yundao.tenant.enums.product.examine.ProductExamineStatusEnum;
import com.yundao.tenant.model.base.BaseFieldGroup;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductExamine;
import com.yundao.tenant.model.base.product.BaseProductSale;
import com.yundao.tenant.model.productnotice.ProductNoticeModel;
import com.yundao.tenant.service.field.FieldSelectService;
import com.yundao.tenant.service.field.FieldValueService;
import com.yundao.tenant.service.field.FieldValueValidateService;
import com.yundao.tenant.service.fieldgroup.FieldGroupService;
import com.yundao.tenant.service.product.ProductCenterService;
import com.yundao.tenant.service.product.ProductSelectService;
import com.yundao.tenant.service.product.ProductService;
import com.yundao.tenant.service.product.ProductStatusService;
import com.yundao.tenant.service.product.attach.ProductAttachService;
import com.yundao.tenant.service.product.commission.ProductCommissionRuleService;
import com.yundao.tenant.service.product.examine.ProductExamineService;
import com.yundao.tenant.service.product.income.ProductIncomeRuleService;
import com.yundao.tenant.service.product.productnotice.ProductNoticeService;
import com.yundao.tenant.service.product.sale.ProductSaleService;
import com.yundao.tenant.service.product.supplier.ProductSupplierService;
import com.yundao.tenant.service.roadshow.RoadshowService;
import com.yundao.tenant.service.sale.declaration.DeclarationService;
import com.yundao.tenant.service.sale.reservation.ReservationService;
import com.yundao.tenant.service.select.SelectConfigService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.NumberUtil;
import com.yundao.tenant.util.field.FieldUtils;
import com.yundao.tenant.util.field.ProductPropertyUtils;
import com.yundao.tenant.util.field.PropertyUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 产品基本信息管理
 *
 * @author 欧阳利 2017年7月5日
 */
@RestController
@RequestMapping("/product")
@ResponseBody
@Api("产品管理")
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	FieldSelectService fieldSelectService;
	@Autowired
	FieldValueValidateService fieldValueValidateService;
	@Autowired
	ProductSaleService productSaleService;
	@Autowired
	ProductExamineService productExamineService;
	@Autowired
	ProductStatusService productStatusService;
	@Autowired
	FieldGroupService fieldGroupService;
	@Autowired
	UserService userService;
	@Autowired
	ProductSelectService productSelectService;
	@Autowired
	ProductAttachService productAttachService;
	@Autowired
	FieldValueService fieldValueService;
	@Autowired
	ProductCommissionRuleService productCommissionRuleService;
	@Autowired
	ProductIncomeRuleService productIncomeRuleService;
	@Autowired
	ProductSupplierService productSupplierService;
	@Autowired
	private ProductNoticeService productNoticeService;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private SelectConfigService selectConfigService;
	@Autowired
	private ReservationService reservationService;

	@Autowired
	private DeclarationService declarationService;

	@Autowired
	private ProductCenterService productCenterService;
	@Autowired
	private RoadshowService roadshowService;

	/**
	 * 取消关注
	 *
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "用户取消关注产品")
	@RequestMapping(value = "/cancel_focus", method = RequestMethod.POST)
	public Result<PermissionResultDto> cancelFocusProduct(@RequestParam String ids) throws Exception {
		if (BooleanUtils.isEmpty(ids)) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}
		PermissionResultDto dto = new PermissionResultDto();
		List<FailListDto> failList = new ArrayList<FailListDto>();
		List<PassListDto> passList = new ArrayList<PassListDto>();
		dto.setFailList(failList);
		dto.setPassList(passList);
		String[] productIds = ids.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String productId : productIds) {
			Long id = Long.parseLong(productId);
			// 检查是否存在
			BaseProduct baseProduct = productSelectService.getBaseProduct(id);
			if (baseProduct == null) {
				FailListDto failListDto = new FailListDto();
				failListDto.setCode(CodeConstant.CODE_1200042);
				failListDto.setId(id);
				failList.add(failListDto);
				continue;
			}
			idList.add(id);
		}
		if (!BooleanUtils.isEmpty(failList)) {
			return Result.newFailureResult(1, dto);
		}
		productService.doCancelFocusProduct(idList);
		return Result.newSuccessResult(dto);
	}

	@ApiOperation(value = "用户关注产品")
	@RequestMapping(value = "/focus", method = RequestMethod.POST)
	public Result<PermissionResultDto> focusProduct(@RequestParam String ids) throws Exception {
		if (BooleanUtils.isEmpty(ids)) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}
		PermissionResultDto dto = new PermissionResultDto();
		List<FailListDto> failList = new ArrayList<FailListDto>();
		List<PassListDto> passList = new ArrayList<PassListDto>();
		dto.setFailList(failList);
		dto.setPassList(passList);
		String[] productIds = ids.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String productId : productIds) {
			Long id = Long.parseLong(productId);
			// 检查是否存在
			BaseProduct baseProduct = productSelectService.getBaseProduct(id);
			if (baseProduct == null) {
				FailListDto failListDto = new FailListDto();
				failListDto.setCode(CodeConstant.CODE_1200042);
				failListDto.setId(id);
				failList.add(failListDto);
				continue;
			}
			idList.add(id);
		}
		if (!BooleanUtils.isEmpty(failList)) {
			return Result.newFailureResult(1, dto);
		}
		productService.doFocusProduct(idList);
		return Result.newSuccessResult(dto);
	}

	/**
	 * 获取产品的字段
	 *
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "通产品类型查询字段")
	@RequestMapping(value = "/get_fields", method = RequestMethod.GET)
	public Result<ProductFieldDto> getFields(@RequestParam Long typeId) throws Exception {
		if (typeId == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200044);
		}
		boolean isExist = fieldGroupService.checkFieldGroupExist(typeId);
		if (!isExist) {
			return Result.newFailureResult(CodeConstant.CODE_1200045);
		}
		ProductFieldDto productFieldDto = new ProductFieldDto();
		List<FieldDto> list = fieldSelectService.getProductFieldByTypeId(typeId);
		productFieldDto.setProductFieldDtos(ProductPropertyUtils.getProductProperty(list));
		productFieldDto.setProductSaleFieldDtos(ProductPropertyUtils.getProductSaleProperty(list));
		return Result.newSuccessResult(productFieldDto);
	}

	/**
	 * 添加产品信息
	 *
	 * @param productAddReqDto
	 * @param request
	 * @return
	 * @throws BaseException
	 * @throws Exception
	 */
	@ApiOperation(value = "添加产品信息")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<Long> add(@ModelAttribute ProductAddReqDto productAddReqDto, HttpServletRequest request)
			throws BaseException, Exception {
		Map<String, String> params = RequestUtils.getParameterMap(request);
		String saleDate = params.get(ProductTableFieldEnum.SALE_DATE.getPropertyName());
		DateRangeFieldDto dateRange = FieldUtils.getDateRangeField(saleDate);
		productAddReqDto.setSaleStartDate(dateRange.getStartDate());
		productAddReqDto.setSaleEndDate(dateRange.getEndDate());

		// 校验产品规模和是否规模
		if (productAddReqDto.getIsScale() != null) {
			if (productAddReqDto.getIsScale().equals(1) && productAddReqDto.getProductScale() == null) {
				throw new BaseException(CodeConstant.CODE_1200034, "产品规模不能为空");
			}
		}

		// 检查产品类型
		if (productAddReqDto.getTypeId() == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200044);
		}
		boolean isExist = fieldGroupService.checkFieldGroupExist(productAddReqDto.getTypeId());
		if (!isExist) {
			return Result.newFailureResult(CodeConstant.CODE_1200045);
		}

		// 获取数据 并检查数据
		ProductAddListDto productAddListDto = productService.getProductAddListDto(productAddReqDto);
		Result<Boolean> isCheck = productService.checkProductAddListDto(productAddListDto,
				productAddReqDto.getIsScale(), productAddReqDto.getProductScale());
		if (!isCheck.getSuccess()) {
			return Result.newFailureResult(isCheck.getCode(), isCheck.getMessage(), null);
		}

		// 检查对接人和产品助理
		if (productAddReqDto.getAssistantId() != null) {
			boolean userExist = userService.checkUserExist(productAddReqDto.getAssistantId());
			if (!userExist) {
				return Result.newFailureResult(CodeConstant.CODE_1200018, "选择的产品助理不存在", null);
			}
			boolean isEnable = userService.checkUserIsEnable(productAddReqDto.getAssistantId());
			if (!isEnable) {
				return Result.newFailureResult(CodeConstant.CODE_1200022, "选择的产品助理已被停用", null);
			}
		}
		if (productAddReqDto.getReceiverId() != null) {
			boolean userExist = userService.checkUserExist(productAddReqDto.getReceiverId());
			if (!userExist) {
				return Result.newFailureResult(CodeConstant.CODE_1200018, "选择的产品对接人不存在", null);
			}
			boolean isEnable = userService.checkUserIsEnable(productAddReqDto.getReceiverId());
			if (!isEnable) {
				return Result.newFailureResult(CodeConstant.CODE_1200022, "选择的产品对接人已被停用", null);
			}
		}

		// 校验扩展字段
		List<FieldDto> list = fieldSelectService.getProductFieldByTypeId(productAddReqDto.getTypeId());
		List<FieldValueValidateFailResultDto> validateResult = fieldValueValidateService.validateFieldValue(list,
				params);
		if (!BooleanUtils.isEmpty(validateResult)) {
			throw new BaseException(CodeConstant.CODE_1200034, validateResult.get(0).getMessage());
		}

		// 添加产品
		return productService.saveProduct(productAddReqDto, params, list, productAddListDto);
	}

	/**
	 * 修改产品基本信息
	 *
	 * @return
	 */
	@ApiOperation(value = "修改产品信息")
	@RequestMapping(value = "/base/update", method = RequestMethod.POST)
	public Result<Integer> updateBaseInfo(@ModelAttribute ProductBaseUpdateReqDto updateReqDto,
			HttpServletRequest request) throws Exception {
		if (updateReqDto.getId() == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}

		// 审核中产品不能修改
		boolean isApprovaling = productExamineService.checkProductIsApprovaling(updateReqDto.getId());
		if (isApprovaling) {
			return Result.newFailureResult(CodeConstant.CODE_1200093);
		}

		Map<String, String> params = RequestUtils.getParameterMap(request);
		// 检查产品类别
		boolean isExist = fieldGroupService.checkFieldGroupExist(updateReqDto.getTypeId());
		if (!isExist) {
			return Result.newFailureResult(CodeConstant.CODE_1200045);
		}

		// 检查对接人和产品助理
		if (updateReqDto.getAssistantId() != null) {
			boolean userExist = userService.checkUserExist(updateReqDto.getAssistantId());
			if (!userExist) {
				return Result.newFailureResult(CodeConstant.CODE_1200018, "选择的产品助理不存在", null);
			}
			boolean isEnable = userService.checkUserIsEnable(updateReqDto.getAssistantId());
			if (!isEnable) {
				return Result.newFailureResult(CodeConstant.CODE_1200022, "选择的产品助理已被停用", null);
			}
		}
		if (updateReqDto.getReceiverId() != null) {
			boolean userExist = userService.checkUserExist(updateReqDto.getReceiverId());
			if (!userExist) {
				return Result.newFailureResult(CodeConstant.CODE_1200018, "选择的产品对接人不存在", null);
			}
			boolean isEnable = userService.checkUserIsEnable(updateReqDto.getReceiverId());
			if (!isEnable) {
				return Result.newFailureResult(CodeConstant.CODE_1200022, "选择的产品对接人已被停用", null);
			}
		}

		// 校验扩展字段
		List<FieldDto> list = fieldSelectService.getProductFieldByTypeId(updateReqDto.getTypeId());
		ProductTableFieldEnum.removeProductSale(list);
		List<FieldValueValidateFailResultDto> validateResult = fieldValueValidateService.validateFieldValue(list,
				params);
		if (!BooleanUtils.isEmpty(validateResult)) {
			throw new BaseException(CodeConstant.CODE_1200034, validateResult.get(0).getMessage());
		}
		// 修改产品
		return productService.updateBaseProduct(updateReqDto, params, list);
	}

	/**
	 * 修改产品销售信息
	 *
	 * @return
	 */
	@ApiOperation(value = "修改产品销售信息")
	@RequestMapping(value = "/sale/update", method = RequestMethod.POST)
	public Result<Integer> updateSale(@ModelAttribute ProductSaleUpdateReqDto updateReqDto, HttpServletRequest request)
			throws Exception {
		Map<String, String> params = RequestUtils.getParameterMap(request);
		String saleDate = params.get(ProductTableFieldEnum.SALE_DATE.getPropertyName());
		DateRangeFieldDto dateRange = FieldUtils.getDateRangeField(saleDate);
		updateReqDto.setSaleStartDate(dateRange.getStartDate());
		updateReqDto.setSaleEndDate(dateRange.getEndDate());
		if (updateReqDto.getId() == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}
		// 审核中的产品不能修改
		boolean isApprovaling = productExamineService.checkProductIsApprovaling(updateReqDto.getId());
		if (isApprovaling) {
			return Result.newFailureResult(CodeConstant.CODE_1200093);
		}
		// 产品是否存在
		BaseProduct baseProduct = productSelectService.getBaseProduct(updateReqDto.getId());
		if (baseProduct == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200042);
		}

		// 数据校验
		List<FieldDto> list = fieldSelectService.getProductFieldByTypeId(baseProduct.getTypeId());
		list = ProductPropertyUtils.getProductSaleProperty(list);
		List<FieldValueValidateFailResultDto> validateResult = fieldValueValidateService.validateFieldValue(list,
				params);
		if (!BooleanUtils.isEmpty(validateResult)) {
			throw new BaseException(CodeConstant.CODE_1200034, validateResult.get(0).getMessage());
		}

		// 校验产品规模和是否规模
		if (updateReqDto.getIsScale() != null) {
			if (updateReqDto.getIsScale().equals(1) && updateReqDto.getProductScale() == null) {
				throw new BaseException(CodeConstant.CODE_1200034, "产品规模不能为空");
			}
		}

		return productSaleService.updateProductSale(updateReqDto);
	}

	/**
	 * 获取产品管理拉下选择的查询条件
	 *
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "获取产品管理拉下选择的查询条件")
	@RequestMapping(value = "/get_manager_List_select_value", method = RequestMethod.GET)
	public Result<List<FiledSelectDto>> getProductManagetrListSelectValue() throws Exception {
		return productSelectService.getProductManagetrListSelectValue();
	}

	/**
	 * 分页产品产品管理列表
	 *
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = "/get_manager_List", method = RequestMethod.GET)
	@ApiOperation(value = "分页产品产品管理列表", notes = "分页查询产品管理列表")
	public Result<PaginationSupport<ProductManagerListResDto>> getManagerList(
			@ModelAttribute ProductManagerListReqDto reqDto) throws BaseException {
		return productSelectService.getManagerList(reqDto);
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
	public Result<PaginationSupport<ProductBaseResDto>> getList(@ModelAttribute ProductBaseQueryReqDto reqDto)
			throws BaseException {
		return productSelectService.getList(reqDto);
	}

	@RequestMapping(value = "/get_direct_model_reservation_list", method = RequestMethod.GET)
	@ApiOperation(value = "获取可直接报单或有我客户成功预约的产品列表信息", notes = "获取可直接报单或有我客户成功预约的产品列表信息")
	public Result<PaginationSupport<ProductBaseResDto>> getDirectModelOrHadReservationList(
			@ModelAttribute ProductBaseQueryReqDto reqDto) throws BaseException {
		return productSelectService.getDirectModelOrHadReservationList(reqDto);
	}

	@RequestMapping(value = "/get_reservation_declaration_total", method = RequestMethod.GET)
	@ApiOperation(value = "查询产品额度预约与报单的总额", notes = "查询产品额度预约与报单的总额")
	public Result<List<ProductReservationDeclarationReportDto>> getReserationDeclarationTotal(
			@RequestParam String productIds) throws BaseException {
		return productSelectService.getReserationDeclarationTotal(productIds);
	}

	@RequestMapping(value = "/app/get_recommended_list", method = RequestMethod.GET)
	@ApiOperation(value = "app获取推荐产品", notes = "app获取推荐产品")
	public Result<List<ProductBaseResDto>> getReCommendedListForApp(@RequestParam(defaultValue = "3") Integer limit)
			throws BaseException {
		return productSelectService.getReCommendedList(limit, PlatformEnum.APP_TO_B.getCode(),
				"index_recommend_product_app");
	}

	/**
	 * 获取产品下拉选择列表(默认显示10条)
	 *
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/get_select_option_list", method = RequestMethod.GET)
	@ApiOperation(value = "获取产品下拉选择列表(默认显示20条)", notes = "分页查询产品管理列表")
	public Result<List<ProductSelectOptionDto>> getProductSelectOPtionDtos(@RequestParam String name, Integer count)
			throws BaseException {
		if (count == null) {
			count = 20;
		}
		return productSelectService.getProductSelectOptionDtos(name, count);
	}

	@RequestMapping(value = "/get_select_option_selling", method = RequestMethod.GET)
	@ApiOperation(value = "获取产品下拉选择列表(默认显示20条)", notes = "分页查询产品管理列表")
	public Result<List<ProductSelectOptionDto>> getProductSelectSelling(@RequestParam(required = false) String name,
			Integer count) throws BaseException {
		if (count == null) {
			count = 20;
		}
		return productSelectService.getSelectionForSale(name, count);
	}

	@RequestMapping(value = "/get_select_option_for_declaration", method = RequestMethod.GET)
	@ApiOperation(value = "获取产品下拉选择列表forDeclaration(默认显示20条)", notes = "分页查询产品管理列表")
	public Result<List<ProductSelectionForDeclaration>> getProductSelectForDeclaration(
			@RequestParam(required = false) String name, Integer count) throws BaseException {
		if (count == null) {
			count = 20;
		}
		return productSelectService.getProductSelectForDeclaration(name, count);
	}

	@RequestMapping(value = "/get_by_ids", method = RequestMethod.GET)
	@ApiOperation(value = "根据多个id获取")
	public Result<List<BaseProduct>> getByIds(@RequestParam String ids) throws BaseException {
		if (BooleanUtils.isEmpty(ids))
			throw new BaseException(CodeConstant.CODE_1200000);
		return Result.newSuccessResult(productSelectService.getByIds(ids));
	}

	/**
	 * 获取产品下拉选择列表(默认显示20条)
	 */
	@RequestMapping(value = "/get_select_option_list_by_typeId", method = RequestMethod.GET)
	@ApiOperation(value = "获取产品下拉选择列表(默认显示20条)", notes = "分页查询产品管理列表")
	public Result<List<ProductSelectOptionDto>> getProductSelectOPtionDtos(@RequestParam Long typeId,
			@RequestParam Integer count) throws BaseException {
		if (typeId == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200044);
		}
		return productSelectService.getProductSelectOptionDtosByTypeId(typeId, count);
	}

	/**
	 * 添加回款计划，产品下拉选项(默认显示20条)
	 */
	@RequestMapping(value = "/get_select_option_for_receipt", method = RequestMethod.GET)
	@ApiOperation(value = "添加回款计划，产品下拉选项(默认显示20条)", notes = "分页查询产品管理列表")
	public Result<List<ProductSelectionForReceiptPlanDto>> getSelectOptionForReceipt(String name) throws BaseException {
		return productSelectService.getForReceiptPlan(name);
	}

	/**
	 * 查询产品基本信息
	 */
	@RequestMapping(value = "/get_base_by_id", method = RequestMethod.GET)
	public Result<BaseProduct> getBaseProduct(@RequestParam Long id) throws BaseException {
		BaseProduct baseProduct = productSelectService.getBaseProduct(id);
		if (baseProduct == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200042);
		}
		return Result.newSuccessResult(baseProduct);
	}

	/**
	 * 修改产品状态
	 *
	 * @param productId
	 * @param productManagerAction
	 * @return
	 */
	@RequestMapping(value = "/update_status", method = RequestMethod.POST)
	public Result<Integer> updateProductStatus(@RequestParam Long productId, @RequestParam Integer declaractionModel,
			@RequestParam Integer productManagerAction, @RequestParam(required = false) String reason)
			throws BaseException {
		if (productId == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}
		// 检查产品是否存在
		BaseProduct baseProduct = productSelectService.getBaseProduct(productId);
		if (baseProduct == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200042);
		}

		// 检查状态是否正确
		BaseProductExamine baseProductExamine = productExamineService.getCurrentBaseProductExamine(productId);
		Integer examineStatus = ProductExamineStatusEnum.INITIAL.getValue();
		if (baseProductExamine != null) {
			examineStatus = baseProductExamine.getStatus();
		}
		boolean isCorrect = ProductManagerActionEnum.checkActionIsCorrect(examineStatus, baseProduct.getIssuedStatus(),
				productManagerAction);
		if (!isCorrect) {
			return Result.newFailureResult(CodeConstant.CODE_1200043);
		}

		// 修改产品状态
		return productStatusService.updateProductStatus(productId, productManagerAction, declaractionModel, reason);

	}

	@ApiOperation(value = "通过产品id查询产品详情", notes = "通过产品id查询产品详情")
	@RequestMapping(value = "/get_detail_by_id", method = RequestMethod.GET)
	public Result<ProductDetailDto> getProductDetailDto(@RequestParam Long id) throws Exception {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}
		// 产品是否存在
		BaseProduct baseProduct = productSelectService.getBaseProduct(id);
		if (baseProduct == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200042);
		}
		ProductDetailDto productDetailDto = new ProductDetailDto();
		productDetailDto.setCreateUserId(baseProduct.getCreateUserId());
		productDetailDto.setIssuedStatus(baseProduct.getIssuedStatus());
		productDetailDto.setIssuedStatusText(ProductIssuedStatusEnum.getEnumName(baseProduct.getIssuedStatus()));

		BaseProductExamine baseProductExamine = productExamineService.getCurrentBaseProductExamine(id);
		Integer examineStatus = ProductExamineStatusEnum.INITIAL.getValue();
		if (baseProductExamine != null) {
			examineStatus = baseProductExamine.getStatus();
		}
		productDetailDto.setExamineStatus(examineStatus);
		productDetailDto
				.setExamineStatusText(ProductExamineStatusEnum.getEnumName(productDetailDto.getExamineStatus()));

		// 产品销售信息
		BaseProductSale baseProductSale = productSelectService.selectBaseProductSaleByProductId(id);

		// 查询产品的字段
		List<FieldDto> fieldDtos = fieldSelectService.getProductFieldByTypeId(baseProduct.getTypeId());
		// 对象转换
		List<FieldDetailDto> productFieldDtos = ProductPropertyUtils.getProductFieldDtos(fieldDtos);
		List<FieldDetailDto> productSaleFieldDtos = ProductPropertyUtils.getProductSaleFieldDtos(fieldDtos);
		productDetailDto.setProductFieldDtos(productFieldDtos);
		productDetailDto.setProductSaleFieldDtos(productSaleFieldDtos);

		// 合并数据
		ProductPropertyUtils.mergeProductField(productFieldDtos, baseProduct);
		ProductPropertyUtils.mergeProductSaleField(productSaleFieldDtos, baseProductSale);
		ProductPropertyUtils.setNumberDecima(productFieldDtos);
		ProductPropertyUtils.setNumberDecima(productSaleFieldDtos);
		fieldValueService.setImageFieldValue(productSaleFieldDtos);
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
		productDetailDto.setAttachDtos(productAttachService.getAll(id));

		// 设置收益
		productDetailDto.setIncomeDtos(productIncomeRuleService.getIncomeRuleDetailDtos(id));

		// 设置报价
		productDetailDto.setSupplierDtos(productSupplierService.getProductSupplierQuotationDetailDtos(id));

		// 设置佣金
		productDetailDto.setCommissionDtos(productCommissionRuleService.getCommissionRuleDetailDtos(id));

		// 是否关注
		productDetailDto.setIsFocus(productSelectService.checkCurrentUserIsFocus(id) ? 1 : 0);

		return Result.newSuccessResult(productDetailDto);
	}

	@ApiOperation(value = "通过产品id查询产品详情", notes = "通过产品id查询产品详情")
	@RequestMapping(value = "/app/get_detail_by_id", method = RequestMethod.GET)
	public Result<ProductPartDetailDto> getProductDetailForApp(@RequestParam Long id) throws Exception {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}
		// 产品是否存在
		BaseProduct baseProduct = productSelectService.getBaseProduct(id);
		if (baseProduct == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200042);
		}
		ProductPartDetailDto productDetailDto = new ProductPartDetailDto();
		productDetailDto.setCreateUserId(baseProduct.getCreateUserId());
		productDetailDto.setIssuedStatusText(ProductIssuedStatusEnum.getEnumName(baseProduct.getIssuedStatus()));
		// 产品销售信息
		BaseProductSale baseProductSale = productSelectService.selectBaseProductSaleByProductId(id);

		// 查询产品的字段
		List<FieldDto> fieldDtos = fieldSelectService.getProductFieldByTypeId(baseProduct.getTypeId());

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

		// 设置认购费与管理费
		List<String> fieldCodes = new ArrayList<>();
		fieldCodes.add(FieldEnum.PRO_BUY_FEE.getCode());
		fieldCodes.add(FieldEnum.PRO_MANAGE_FEE.getCode());

		List<FieldDetailAndValueDto> fAndValueDtos = fieldValueService
				.getFieldValuesByProductIdAndFieldCode(baseProduct.getId(), fieldCodes);

		if (fAndValueDtos != null && !fAndValueDtos.isEmpty()) {
			for (FieldDetailAndValueDto dto : fAndValueDtos) {
				if (FieldEnum.PRO_BUY_FEE.getCode().equals(dto.getCode())) {
					List<ValuesDto> values = dto.getValues();
					if (values != null) {
						ValuesDto valuesDto = values.get(0);
						productDetailDto
								.setProBuyFee(NumberUtil.trimDoubleZero(valuesDto.getValue()) + valuesDto.getNumUnit());// 认购费
					}
				} else if (FieldEnum.PRO_MANAGE_FEE.getCode().equals(dto.getCode())) {
					List<ValuesDto> values = dto.getValues();
					if (values != null) {
						ValuesDto valuesDto = values.get(0);
						productDetailDto.setProManageFee(
								NumberUtil.trimDoubleZero(valuesDto.getValue()) + valuesDto.getNumUnit());// 管理费
					}
				}

			}
		}

		// 设置币种
		if (baseProductSale.getCurrencyCode() != null) {
			SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
					FieldEnum.CURRENCY_CODE.getCode(), Integer.parseInt(baseProductSale.getCurrencyCode()));
			if (selectConfigDto != null) {
				productDetailDto.setCurrencyCodeText(selectConfigDto.getLabel());
			}
		}

		// 设置收益
		List<IncomeRuleDetailDto> incomeRuleDetailDtos = productIncomeRuleService.getIncomeRuleDetailDtos(id);

		// 设置佣金
		List<ProductCommissionRuleDetailDto> commissionRuleDetailDtos = productCommissionRuleService
				.getCommissionRuleDetailDtos(id);
		// 设置附件信息
		ProductAttachListReqDto reqDto = new ProductAttachListReqDto();
		reqDto.setProductId(id);
		productDetailDto.setAttachDtos(productAttachService.getAll(id));
		// 设置产品公告
		Result<List<ProductNoticeModel>> noticeResult = productNoticeService.getList(id, NumberEnum.ONE.getValue());

		BeanUtils.copyProperties(baseProduct, productDetailDto);

		// 设置产品类型
		if (productDetailDto.getTypeId() != null) {
			Result<BaseFieldGroup> fieldGroupResult = fieldGroupService.get(productDetailDto.getTypeId());
			if (fieldGroupResult != null && fieldGroupResult.getResult() != null) {
				BaseFieldGroup fieldGroup = fieldGroupResult.getResult();
				productDetailDto.setTypeName(fieldGroup.getName());// 产品类型中文名
			}
		}
		// 设置投资标的，发行通道
		if (productDetailDto.getIssuedChannel() != null) {
			SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
					FieldEnum.ISSUED_CHANNEL.getCode(), Integer.parseInt(productDetailDto.getIssuedChannel()));
			if (selectConfigDto != null) {
				productDetailDto.setIssuedChannelText(selectConfigDto.getLabel());
			}
		}
		if (productDetailDto.getInvestDomain() != null) {
			SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
					FieldEnum.INVEST_DOMAIN.getCode(), Integer.parseInt(productDetailDto.getInvestDomain()));
			if (selectConfigDto != null) {
				productDetailDto.setInvestDomainText(selectConfigDto.getLabel());
			}
		}
		productDetailDto.setIncomeDtos(incomeRuleDetailDtos);
		productDetailDto.setCommissionDtos(commissionRuleDetailDtos);
		productDetailDto.setProductSale(baseProductSale);
		if (noticeResult != null && noticeResult.getResult() != null) {
			productDetailDto.setNoticeModels(noticeResult.getResult());
		}

		if (productDetailDto.getReceiverId() != null) {
			UserInfoDto userInfoDto = userService.getUserInfo(productDetailDto.getReceiverId());
			if (userInfoDto != null) {
				productDetailDto.setReceiverMobile(userInfoDto.getMobile());
			}
			productDetailDto.setReceiverName(userDetailService.getUserRealName(productDetailDto.getReceiverId()));
		}
		if (productDetailDto.getAssistantId() != null) {
			productDetailDto.setAssistantName(userDetailService.getUserRealName(productDetailDto.getAssistantId()));
		}

		BaseProductExamine productExamine = productExamineService.getCurrentBaseProductExamine(id);
		if (productExamine != null) {
			productDetailDto.setAuditStatus(productExamine.getStatus());
		}
		// 设置产品等级和风险等级
		List<FiledSelectDto> filedSelectDtos = productCenterService.getlevelAndRiskLevelSelect();
		productDetailDto.setLevelText(FiledSelectDto.getSelectLableName(filedSelectDtos,
				ProductTableFieldEnum.LEVEL.getPropertyName(), productDetailDto.getLevel()));
		productDetailDto.setRiskLevelText(FiledSelectDto.getSelectLableName(filedSelectDtos,
				ProductTableFieldEnum.RISK_LEVEL.getPropertyName(), productDetailDto.getRiskLevel()));

		List<ProductReportDto> dReportDtos = reservationService.getNumByProductIds(String.valueOf(baseProduct.getId()));
		if (dReportDtos != null && !dReportDtos.isEmpty()) {
			ProductReportDto reportDto = dReportDtos.get(0);
			productDetailDto.setReservationNum(reportDto.getNum());
		}

		// 设置路演信息
		Result<List<RoadshowResDto>> roadshowResult = roadshowService.getByProductId(productDetailDto.getId());
		if (roadshowResult.getResult() != null && !roadshowResult.getResult().isEmpty()) {
			productDetailDto.setRoadshows(roadshowResult.getResult());
		}
		return Result.newSuccessResult(productDetailDto);
	}

	/**
	 * 删除产品
	 *
	 * @param ids
	 * @return
	 * @throws BaseException
	 */
	@ApiOperation(value = "删除产品", notes = "删除产品")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Result<PermissionResultDto> delete(@RequestParam String ids) throws Exception {
		if (BooleanUtils.isEmpty(ids)) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}
		PermissionResultDto dto = new PermissionResultDto();
		List<FailListDto> failList = new ArrayList<FailListDto>();
		List<PassListDto> passList = new ArrayList<PassListDto>();
		dto.setFailList(failList);
		dto.setPassList(passList);
		String[] productIds = ids.split(",");
		List<Long> idList = new ArrayList<Long>();

		List<Long> hasReservationPrductIds = reservationService.getHasReservationProductIds(ids);

		List<Long> hasDeclarationPrductIds = declarationService.getHasDeclarationProductIds(ids);

		for (String productId : productIds) {
			Long id = Long.parseLong(productId);
			// 检查是否存在
			BaseProduct baseProduct = productSelectService.getBaseProduct(id);
			if (baseProduct == null) {
				FailListDto failListDto = new FailListDto();
				failListDto.setCode(CodeConstant.CODE_1200042);
				failListDto.setId(id);
				failList.add(failListDto);
				continue;
			}
			// 仅处于未上线状态、且没有预约和报单记录的产品才可删除
			if (!ProductIssuedStatusEnum.NOT_ON_LINE.getValue().equals(baseProduct.getIssuedStatus())) {
				FailListDto failListDto = new FailListDto();
				failListDto.setCode(CodeConstant.CODE_1200075);
				failListDto.setId(id);
				failListDto.setName(baseProduct.getName());
				failList.add(failListDto);
				continue;
			}

			// 有预约的产品不能删除
			if (hasReservationPrductIds.contains(id)) {
				FailListDto failListDto = new FailListDto();
				failListDto.setCode(CodeConstant.CODE_1200138);
				failListDto.setId(id);
				failListDto.setName(baseProduct.getName());
				failList.add(failListDto);
				continue;
			}

			// 有保单的产品不能删除
			if (hasDeclarationPrductIds.contains(id)) {
				FailListDto failListDto = new FailListDto();
				failListDto.setCode(CodeConstant.CODE_1200139);
				failListDto.setId(id);
				failListDto.setName(baseProduct.getName());
				failList.add(failListDto);
				continue;
			}

			PassListDto passListDto = new PassListDto();
			passListDto.setId(baseProduct.getId());
			passListDto.setName(baseProduct.getName());
			passList.add(passListDto);
			idList.add(baseProduct.getId());
		}
		if (!BooleanUtils.isEmpty(failList)) {
			return Result.newSuccessResult(dto);
		}
		productService.delete(idList);
		return Result.newSuccessResult(dto);
	}

	@RequestMapping(value = "/import_from_fund", method = RequestMethod.POST)
	@ApiOperation("从基金导入")
	public Result<Long> importFromFund(@RequestParam String jsonData) throws BaseException {
		FundDto dto = JsonUtils.jsonToObject(jsonData, new BaseTypeReference<FundDto>() {
		});
		return productService.doImportFormFund(dto);
	}
}
