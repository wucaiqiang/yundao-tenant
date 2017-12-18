package com.yundao.tenant.service.product.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.field.FieldConfigDto;
import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.field.FiledSelectDto;
import com.yundao.tenant.dto.field.SelectConfigStringValueDto;
import com.yundao.tenant.dto.product.ProductActionDto;
import com.yundao.tenant.dto.product.ProductBaseQueryReqDto;
import com.yundao.tenant.dto.product.ProductBaseResDto;
import com.yundao.tenant.dto.product.ProductManagerListReqDto;
import com.yundao.tenant.dto.product.ProductManagerListResDto;
import com.yundao.tenant.dto.product.ProductReservationDeclarationReportDto;
import com.yundao.tenant.dto.product.ProductSelectOptionDto;
import com.yundao.tenant.dto.product.ProductSelectionForDeclaration;
import com.yundao.tenant.dto.product.ProductSelectionForReceiptPlanDto;
import com.yundao.tenant.dto.product.add.ProductCommissionRuleDto;
import com.yundao.tenant.dto.product.add.ProductIncomeRuleDto;
import com.yundao.tenant.dto.report.ProductReportDto;
import com.yundao.tenant.dto.sale.declaration.ProductDeclarationAmountDto;
import com.yundao.tenant.dto.sale.reservation.ProductReservationAmountDto;
import com.yundao.tenant.dto.select.SelectConfigDto;
import com.yundao.tenant.enums.bo.BusinessObjectEnum;
import com.yundao.tenant.enums.bo.ProductTableFieldEnum;
import com.yundao.tenant.enums.product.DeclarationModelEnum;
import com.yundao.tenant.enums.product.FieldEnum;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.enums.product.ProductManagerActionEnum;
import com.yundao.tenant.enums.product.examine.ProductExamineStatusEnum;
import com.yundao.tenant.mapper.base.product.BaseProductFocusMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.base.product.BaseProductSaleMapper;
import com.yundao.tenant.mapper.product.ProductCommissionRuleMapper;
import com.yundao.tenant.mapper.product.ProductIncomeRuleMapper;
import com.yundao.tenant.mapper.product.ProductSelectMapper;
import com.yundao.tenant.mapper.sale.declaration.DeclarationMapper;
import com.yundao.tenant.mapper.sale.reservation.ReservationMapper;
import com.yundao.tenant.model.base.BaseFieldGroup;
import com.yundao.tenant.model.base.BaseUserDetail;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductExample;
import com.yundao.tenant.model.base.product.BaseProductFocusExample;
import com.yundao.tenant.model.base.product.BaseProductSale;
import com.yundao.tenant.model.base.product.BaseProductSaleExample;
import com.yundao.tenant.service.customercenter.ProductH5SelectService;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.field.FieldSelectService;
import com.yundao.tenant.service.fieldgroup.FieldGroupService;
import com.yundao.tenant.service.product.ProductSelectService;
import com.yundao.tenant.service.sale.declaration.DeclarationService;
import com.yundao.tenant.service.sale.reservation.ReservationService;
import com.yundao.tenant.service.select.SelectConfigService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.util.CalendarUtils;
import com.yundao.tenant.util.SymbolStrUtils;

@Service
public class ProductSelectServiceImpl extends AbstractService implements ProductSelectService {

	@Autowired
	BaseProductMapper baseProductMapper;

	@Autowired
	BaseProductSaleMapper baseProductSaleMapper;
	@Autowired
	ProductIncomeRuleMapper productIncomeRuleMapper;
	@Autowired
	ProductCommissionRuleMapper productCommissionRuleMapper;
	@Autowired
	ProductSelectMapper productSelectMapper;

	@Autowired
	UserDetailService userDetailService;

	@Autowired
	FieldGroupService fieldGroupService;

	@Autowired
	FieldSelectService fieldSelectService;

	@Autowired
	BaseProductFocusMapper baseProductFocusMapper;
	@Autowired
	private SelectConfigService selectConfigService;
	@Autowired
	ReservationMapper reservationMapper;

	@Autowired
	DeclarationMapper declarationMapper;
	@Autowired
	ReservationService reservationService;
	@Autowired
	DeclarationService declarationService;

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private ProductH5SelectService productH5SelectService;

	/**
	 * 通过产品id查询超信息
	 *
	 * @param productId
	 * @return
	 * @throws BaseException
	 */
	public BaseProduct getBaseProduct(Long productId) throws BaseException {
		if (productId == null) {
			return null;
		}
		BaseProduct product = baseProductMapper.selectByPrimaryKey(productId);
		return product;
	}

	@Override
	public List<BaseProduct> getByIds(String ids) throws BaseException {
		List<Long> idList = SymbolStrUtils.toLong(ids);
		BaseProductExample example = new BaseProductExample();
		example.createCriteria().andIdIn(idList);
		return baseProductMapper.selectByExample(example);
	}

	/**
	 * 检查产品是否存在
	 *
	 * @param productId
	 * @return
	 * @throws BaseException
	 */
	public boolean checkProductExist(Long productId) throws BaseException {
		BaseProduct product = baseProductMapper.selectByPrimaryKey(productId);
		return product != null;
	}

	/**
	 * 获取产品下拉选择列表(默认显示20条)
	 *
	 * @param name
	 * @return
	 */
	public Result<List<ProductSelectOptionDto>> getProductSelectOptionDtos(String name, Integer count)
			throws BaseException {
		List<ProductSelectOptionDto> list = productSelectMapper.getProductSelectOptionDtos(name, "all", count);
		if (BooleanUtils.isNotEmpty(list)) {
			for (ProductSelectOptionDto item : list) {
				item.setIssuedStatusText(
						dictionaryService.toText(DicCode.DIC_PRODUCT_ISSUED_STATUS, item.getIssuedStatus()));
			}
		}
		return Result.newSuccessResult(list);
	}

	@Override
	public Result<List<ProductSelectOptionDto>> getSelectionForSale(String name, Integer count) throws BaseException {
		// 只获取正在销售的产品
		List<ProductSelectOptionDto> list = productSelectMapper.getProductSelectOptionDtos(name, "selling", count);
		// 业务逻辑处理
		for (ProductSelectOptionDto dto : list) {
			if (ProductIssuedStatusEnum.CLEAR_OUT.getValue().equals(dto.getIssuedStatus())
					|| ProductIssuedStatusEnum.SURVIVING.getValue().equals(dto.getIssuedStatus())
					|| ProductIssuedStatusEnum.RAISE_END.getValue().equals(dto.getIssuedStatus())) {
				dto.setCanReservation(false);
				dto.setNotCanReservationTitle("该产品为募集结束状态，不可预约");
				continue;
			}
			if (DeclarationModelEnum.DECLARATION.getValue().equals(dto.getDeclarationModel())) {
				dto.setCanReservation(false);
				dto.setNotCanReservationTitle("该产品募集中可直接报单，请在我的报单中直接报单");
				continue;
			}
			dto.setCanReservation(true);
		}

		return Result.newSuccessResult(list);
	}

	/**
	 * 产品下拉列表查询 getProductSelectForDeclaration:
	 *
	 * @param name
	 * @param count
	 * @return
	 * @throws BaseException
	 * @author: 欧阳利
	 * @description:
	 */
	@Override
	public Result<List<ProductSelectionForDeclaration>> getProductSelectForDeclaration(String name, Integer count)
			throws BaseException {
		List<ProductSelectionForDeclaration> list = productSelectMapper.getProductSelectForDeclaration(name, count);
		return Result.newSuccessResult(list);
	}

	/**
	 * 获取产品下拉选择列表(默认显示20条)
	 *
	 * @param count
	 * @return
	 */
	public Result<List<ProductSelectOptionDto>> getProductSelectOptionDtosByTypeId(Long typeId, Integer count)
			throws BaseException {
		if (count == null) {
			count = 20;
		}
		List<ProductSelectOptionDto> list = productSelectMapper.getProductSelectOptionDtosByTypeId(typeId, count);
		return Result.newSuccessResult(list);
	}

	@Override
	public Result<List<ProductBaseResDto>> getReCommendedList(Integer limit, String platformCode, String positionCode)
			throws BaseException {
		// String issuedStatuses = ProductIssuedStatusEnum.PRE_SAISE.getValue()
		// + ","
		// + ProductIssuedStatusEnum.TO_RAISE.getValue();
		String issuedStatuses = "";

		Result<List<ProductBaseResDto>> datasResult = productH5SelectService.getReCommendedListForApp(limit,
				issuedStatuses, platformCode, positionCode);
		if (datasResult.getResult() == null || datasResult.getResult().isEmpty()) {
			return Result.newSuccessResult(null);
		}
		List<ProductBaseResDto> datas = datasResult.getResult();
		Map<Long, ProductBaseResDto> productMap = new HashMap<>();
		StringBuilder idBuider = new StringBuilder();

		if (datas != null && !datas.isEmpty()) {
			for (ProductBaseResDto dto : datas) {
				productMap.put(dto.getId(), dto);
				if (idBuider.length() > 0) {
					idBuider.append(",");
				}
				idBuider.append(dto.getId());
				// 设置投资标的，发行通道
				if (StringUtils.isNotBlank(dto.getIssuedChannel())) {
					SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
							FieldEnum.ISSUED_CHANNEL.getCode(), Integer.parseInt(dto.getIssuedChannel()));
					if (selectConfigDto != null) {
						dto.setIssuedChannelText(selectConfigDto.getLabel());
					}
				}
				if (StringUtils.isNotBlank(dto.getInvestDomain())) {
					SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
							FieldEnum.INVEST_DOMAIN.getCode(), Integer.parseInt(dto.getInvestDomain()));
					if (selectConfigDto != null) {
						dto.setInvestDomainText(selectConfigDto.getLabel());
					}
				}
				if (dto.getCurrencyCode() != null) {
					SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
							FieldEnum.CURRENCY_CODE.getCode(), dto.getCurrencyCode().intValue());
					if (selectConfigDto != null) {
						dto.setCurrencyCodeText(selectConfigDto.getLabel());
					}
				}
			}
		}
		if (idBuider.length() > 0) {
			// 设置收益
			List<ProductIncomeRuleDto> incomeList = productIncomeRuleMapper.selectList(idBuider.toString());
			if (incomeList != null && !incomeList.isEmpty()) {
				for (ProductIncomeRuleDto rule : incomeList) {
					if (rule.getProductId() == null) {
						continue;
					}
					if (productMap.containsKey(rule.getProductId())) {
						ProductBaseResDto productDto = productMap.get(rule.getProductId());
						List<ProductIncomeRuleDto> incomes = productDto.getPrIncomeRuleDtos();
						if (incomes == null) {
							incomes = new ArrayList<>();
							productDto.setPrIncomeRuleDtos(incomes);
						}
						incomes.add(rule);
					}
				}
			}

			List<ProductCommissionRuleDto> commissionRuleDtos = productCommissionRuleMapper
					.selectList(idBuider.toString());
			if (commissionRuleDtos != null && !commissionRuleDtos.isEmpty()) {
				for (ProductCommissionRuleDto rule : commissionRuleDtos) {
					if (rule.getProductId() == null) {
						continue;
					}
					if (productMap.containsKey(rule.getProductId())) {
						ProductBaseResDto productDto = productMap.get(rule.getProductId());
						List<ProductCommissionRuleDto> commissionRules = productDto.getCommissionRuleDtos();
						if (commissionRules == null) {
							commissionRules = new ArrayList<>();
							productDto.setCommissionRuleDtos(commissionRules);
						}
						commissionRules.add(rule);
					}
				}
			}

			// 查询产品预约总额
			List<ProductReportDto> reservationTotals = reservationService.getTotalByProductIds(idBuider.toString());
			if (reservationTotals != null && !reservationTotals.isEmpty()) {
				for (ProductReportDto reportDto : reservationTotals) {
					if (productMap.containsKey(reportDto.getProductId())) {
						ProductBaseResDto productDto = productMap.get(reportDto.getProductId());
						productDto.setReservationTotal(reportDto.getTotal());
					}
				}
			}
			// 查询产品报单总额
			List<ProductReportDto> declarationTotals = declarationService.getTotalByProductIds(idBuider.toString());
			if (declarationTotals != null && !declarationTotals.isEmpty()) {
				for (ProductReportDto reportDto : declarationTotals) {
					if (productMap.containsKey(reportDto.getProductId())) {
						ProductBaseResDto productDto = productMap.get(reportDto.getProductId());
						productDto.setDeclarationTotal(reportDto.getTotal());
					}
				}
			}

		}
		return Result.newSuccessResult(datas);

	}

	@Override
	public Result<List<ProductReservationDeclarationReportDto>> getReserationDeclarationTotal(String productIds)
			throws BaseException {
		if (StringUtils.isBlank(productIds)) {
			throw new BaseException(CodeConstant.CODE_1200041);
		}
		Map<Long, ProductReservationDeclarationReportDto> reportMap = new HashMap<>();
		String[] ids = productIds.split(",");
		for (int i = 0; i < ids.length; i++) {
			ProductReservationDeclarationReportDto reportDto = new ProductReservationDeclarationReportDto();
			reportDto.setProductId(NumberUtils.toLong(ids[i]));
			reportMap.put(NumberUtils.toLong(ids[i]), reportDto);
		}
		// 查询产品预约总额
		List<ProductReportDto> reservationTotals = reservationService.getTotalByProductIds(productIds);
		if (reservationTotals != null && !reservationTotals.isEmpty()) {
			for (ProductReportDto reportDto : reservationTotals) {
				if (reportMap.containsKey(reportDto.getProductId())) {
					ProductReservationDeclarationReportDto productDto = reportMap.get(reportDto.getProductId());
					productDto.setReservationTotal(reportDto.getTotal());
				}
			}
		}
		// 查询产品报单总额
		List<ProductReportDto> declarationTotals = declarationService.getTotalByProductIds(productIds);
		if (declarationTotals != null && !declarationTotals.isEmpty()) {
			for (ProductReportDto reportDto : declarationTotals) {
				if (reportMap.containsKey(reportDto.getProductId())) {
					ProductReservationDeclarationReportDto productDto = reportMap.get(reportDto.getProductId());
					productDto.setDeclarationTotal(reportDto.getTotal());
				}
			}
		}

		List<ProductReservationDeclarationReportDto> reportDtos = new ArrayList<>();
		if (!reportMap.isEmpty()) {
			reportMap.forEach((k, v) -> {
				reportDtos.add(v);
			});
		}
		return Result.newSuccessResult(reportDtos);

	}

	@Override
	public Result<PaginationSupport<ProductBaseResDto>> getDirectModelOrHadReservationList(
			ProductBaseQueryReqDto reqDto) throws BaseException {

		PaginationSupport<ProductBaseResDto> result = reqDto.getPaginationSupport();
		reqDto.setUserId(this.getHeaderUserId());//只查询与当前用户相关的数据

		int totalCount = productSelectMapper.selectDirectModelOrHadReservationListCount(reqDto);

		if (totalCount > 0) {
			List<ProductBaseResDto> datas = productSelectMapper.selectDirectModelOrHadReservationList(reqDto);
			Map<Long, ProductBaseResDto> productMap = new HashMap<>();
			StringBuilder idBuider = new StringBuilder();

			if (datas != null && !datas.isEmpty()) {
				for (ProductBaseResDto dto : datas) {
					productMap.put(dto.getId(), dto);
					if (idBuider.length() > 0) {
						idBuider.append(",");
					}
					idBuider.append(dto.getId());

					// 设置投资标的，发行通道
					if (StringUtils.isNotBlank(dto.getIssuedChannel())) {
						SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
								FieldEnum.ISSUED_CHANNEL.getCode(), Integer.parseInt(dto.getIssuedChannel()));
						if (selectConfigDto != null) {
							dto.setIssuedChannelText(selectConfigDto.getLabel());
						}
					}
					if (StringUtils.isNotBlank(dto.getInvestDomain())) {
						SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
								FieldEnum.INVEST_DOMAIN.getCode(), Integer.parseInt(dto.getInvestDomain()));
						if (selectConfigDto != null) {
							dto.setInvestDomainText(selectConfigDto.getLabel());
						}
					}
					if (dto.getCurrencyCode() != null) {
						SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
								FieldEnum.CURRENCY_CODE.getCode(), dto.getCurrencyCode().intValue());
						if (selectConfigDto != null) {
							dto.setCurrencyCodeText(selectConfigDto.getLabel());
						}
					}
				}
			}
			if (idBuider.length() > 0) {
				// 设置收益
				List<ProductIncomeRuleDto> incomeList = productIncomeRuleMapper.selectList(idBuider.toString());
				if (incomeList != null && !incomeList.isEmpty()) {
					for (ProductIncomeRuleDto rule : incomeList) {
						if (rule.getProductId() == null) {
							continue;
						}
						if (productMap.containsKey(rule.getProductId())) {
							ProductBaseResDto productDto = productMap.get(rule.getProductId());
							List<ProductIncomeRuleDto> incomes = productDto.getPrIncomeRuleDtos();
							if (incomes == null) {
								incomes = new ArrayList<>();
								productDto.setPrIncomeRuleDtos(incomes);
							}
							incomes.add(rule);
						}
					}
				}

				List<ProductCommissionRuleDto> commissionRuleDtos = productCommissionRuleMapper
						.selectList(idBuider.toString());
				if (commissionRuleDtos != null && !commissionRuleDtos.isEmpty()) {
					for (ProductCommissionRuleDto rule : commissionRuleDtos) {
						if (rule.getProductId() == null) {
							continue;
						}
						if (productMap.containsKey(rule.getProductId())) {
							ProductBaseResDto productDto = productMap.get(rule.getProductId());
							List<ProductCommissionRuleDto> commissionRules = productDto.getCommissionRuleDtos();
							if (commissionRules == null) {
								commissionRules = new ArrayList<>();
								productDto.setCommissionRuleDtos(commissionRules);
							}
							commissionRules.add(rule);
						}
					}
				}

				// 预约数
				List<ProductReportDto> reservationNums = reservationService.getNumByProductIds(idBuider.toString());
				if (reservationNums != null && !reservationNums.isEmpty()) {
					for (ProductReportDto reportDto : reservationNums) {
						if (productMap.containsKey(reportDto.getProductId())) {
							ProductBaseResDto productDto = productMap.get(reportDto.getProductId());
							productDto.setReservationNum(reportDto.getNum());
						}
					}
				}
				// 查询产品预约总额
				List<ProductReportDto> reservationTotals = reservationService.getTotalByProductIds(idBuider.toString());
				if (reservationTotals != null && !reservationTotals.isEmpty()) {
					for (ProductReportDto reportDto : reservationTotals) {
						if (productMap.containsKey(reportDto.getProductId())) {
							ProductBaseResDto productDto = productMap.get(reportDto.getProductId());
							productDto.setReservationTotal(reportDto.getTotal());
						}
					}
				}
				// 查询产品报单总额
				List<ProductReportDto> declarationTotals = declarationService.getTotalByProductIds(idBuider.toString());
				if (declarationTotals != null && !declarationTotals.isEmpty()) {
					for (ProductReportDto reportDto : declarationTotals) {
						if (productMap.containsKey(reportDto.getProductId())) {
							ProductBaseResDto productDto = productMap.get(reportDto.getProductId());
							productDto.setReservationTotal(reportDto.getTotal());
						}
					}
				}
			}
			result.setDatas(datas);
		}

		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);

	}

	@Override
	public Result<PaginationSupport<ProductBaseResDto>> getList(ProductBaseQueryReqDto reqDto) throws BaseException {
		PaginationSupport<ProductBaseResDto> result = reqDto.getPaginationSupport();

		int totalCount = productSelectMapper.selectListCount(reqDto);
		if (totalCount > 0) {
			List<ProductBaseResDto> datas = productSelectMapper.selectList(reqDto);
			Map<Long, ProductBaseResDto> productMap = new HashMap<>();
			StringBuilder idBuider = new StringBuilder();

			if (datas != null && !datas.isEmpty()) {
				for (ProductBaseResDto dto : datas) {
					productMap.put(dto.getId(), dto);
					if (idBuider.length() > 0) {
						idBuider.append(",");
					}
					idBuider.append(dto.getId());

					// 设置投资标的，发行通道
					if (StringUtils.isNotBlank(dto.getIssuedChannel())) {
						SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
								FieldEnum.ISSUED_CHANNEL.getCode(), Integer.parseInt(dto.getIssuedChannel()));
						if (selectConfigDto != null) {
							dto.setIssuedChannelText(selectConfigDto.getLabel());
						}
					}
					if (StringUtils.isNotBlank(dto.getInvestDomain())) {
						SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
								FieldEnum.INVEST_DOMAIN.getCode(), Integer.parseInt(dto.getInvestDomain()));
						if (selectConfigDto != null) {
							dto.setInvestDomainText(selectConfigDto.getLabel());
						}
					}
					if (dto.getCurrencyCode() != null) {
						SelectConfigDto selectConfigDto = selectConfigService.getByFieldCodeAndValue(
								FieldEnum.CURRENCY_CODE.getCode(), dto.getCurrencyCode().intValue());
						if (selectConfigDto != null) {
							dto.setCurrencyCodeText(selectConfigDto.getLabel());
						}
					}
				}
			}
			if (idBuider.length() > 0) {
				// 设置收益
				List<ProductIncomeRuleDto> incomeList = productIncomeRuleMapper.selectList(idBuider.toString());
				if (incomeList != null && !incomeList.isEmpty()) {
					for (ProductIncomeRuleDto rule : incomeList) {
						if (rule.getProductId() == null) {
							continue;
						}
						if (productMap.containsKey(rule.getProductId())) {
							ProductBaseResDto productDto = productMap.get(rule.getProductId());
							List<ProductIncomeRuleDto> incomes = productDto.getPrIncomeRuleDtos();
							if (incomes == null) {
								incomes = new ArrayList<>();
								productDto.setPrIncomeRuleDtos(incomes);
							}
							incomes.add(rule);
						}
					}
				}

				List<ProductCommissionRuleDto> commissionRuleDtos = productCommissionRuleMapper
						.selectList(idBuider.toString());
				if (commissionRuleDtos != null && !commissionRuleDtos.isEmpty()) {
					for (ProductCommissionRuleDto rule : commissionRuleDtos) {
						if (rule.getProductId() == null) {
							continue;
						}
						if (productMap.containsKey(rule.getProductId())) {
							ProductBaseResDto productDto = productMap.get(rule.getProductId());
							List<ProductCommissionRuleDto> commissionRules = productDto.getCommissionRuleDtos();
							if (commissionRules == null) {
								commissionRules = new ArrayList<>();
								productDto.setCommissionRuleDtos(commissionRules);
							}
							commissionRules.add(rule);
						}
					}
				}

				// 预约数
				List<ProductReportDto> reservationNums = reservationService.getNumByProductIds(idBuider.toString());
				if (reservationNums != null && !reservationNums.isEmpty()) {
					for (ProductReportDto reportDto : reservationNums) {
						if (productMap.containsKey(reportDto.getProductId())) {
							ProductBaseResDto productDto = productMap.get(reportDto.getProductId());
							productDto.setReservationNum(reportDto.getNum());
						}
					}
				}
				// 查询产品预约总额
				List<ProductReportDto> reservationTotals = reservationService.getTotalByProductIds(idBuider.toString());
				if (reservationTotals != null && !reservationTotals.isEmpty()) {
					for (ProductReportDto reportDto : reservationTotals) {
						if (productMap.containsKey(reportDto.getProductId())) {
							ProductBaseResDto productDto = productMap.get(reportDto.getProductId());
							productDto.setReservationTotal(reportDto.getTotal());
						}
					}
				}
				// 查询产品报单总额
				List<ProductReportDto> declarationTotals = declarationService.getTotalByProductIds(idBuider.toString());
				if (declarationTotals != null && !declarationTotals.isEmpty()) {
					for (ProductReportDto reportDto : declarationTotals) {
						if (productMap.containsKey(reportDto.getProductId())) {
							ProductBaseResDto productDto = productMap.get(reportDto.getProductId());
							productDto.setReservationTotal(reportDto.getTotal());
						}
					}
				}
			}
			result.setDatas(datas);
		}

		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);

	}

	/**
	 * 查询产品管理列表
	 *
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 */
	public Result<PaginationSupport<ProductManagerListResDto>> getManagerList(ProductManagerListReqDto reqDto)
			throws BaseException {
		PaginationSupport<ProductManagerListResDto> result = reqDto.getPaginationSupport();
		// 重置参数
		resetParam(reqDto);
		int totalCount = productSelectMapper.getManagerListCount(reqDto);
		if (totalCount > 0) {
			List<ProductManagerListResDto> datas = productSelectMapper.getManagerList(reqDto);
			result.setDatas(datas);
			resetManagerListReturnData(datas);
		}

		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	private void resetParam(ProductManagerListReqDto reqDto) {
		if (reqDto.getProductRange() != null && reqDto.getProductRange() == 1) {
			reqDto.setReceiverId(this.getHeaderUserId());
		}
		if (reqDto.getProductRange() != null && reqDto.getProductRange() == 2) {
			reqDto.setAssistantId(this.getHeaderUserId());
		}
		if (reqDto.getProductRange() != null && reqDto.getProductRange() == 3) {
			reqDto.setAssistantIdOrreceiverId(this.getHeaderUserId());
		}

		if (!BooleanUtils.isBlank(reqDto.getTypeIds())) {
			String[] typeIdList = reqDto.getTypeIds().split(",");
			if (!BooleanUtils.isEmpty(typeIdList)) {
				reqDto.setTypeIdList(typeIdList);
			}
		}

		if (!BooleanUtils.isBlank(reqDto.getExamineStatuss())) {
			String[] examineStatusList = reqDto.getExamineStatuss().split(",");
			if (!BooleanUtils.isEmpty(examineStatusList)) {
				reqDto.setExamineStatusList(examineStatusList);
			}
		}

		if (!BooleanUtils.isBlank(reqDto.getLevels())) {
			String[] levelList = reqDto.getLevels().split(",");
			if (!BooleanUtils.isEmpty(levelList)) {
				reqDto.setLevelList(levelList);
			}
		}

		if (!BooleanUtils.isBlank(reqDto.getRiskLevels())) {
			String[] riskLevelList = reqDto.getRiskLevels().split(",");
			if (!BooleanUtils.isEmpty(riskLevelList)) {
				reqDto.setRiskLevelList(riskLevelList);
			}
		}

		if (!BooleanUtils.isBlank(reqDto.getIssuedStatuss())) {
			String[] issuedStatusList = reqDto.getIssuedStatuss().split(",");
			if (!BooleanUtils.isEmpty(issuedStatusList)) {
				reqDto.setIssuedStatusList(issuedStatusList);
			}
		}
		if (reqDto.getCreateDateStart() != null) {
			reqDto.setCreateDateStart(CalendarUtils.getCurrentDayBeginTime(reqDto.getCreateDateStart()));
		}
		if (reqDto.getCreateDateEnd() != null) {
			reqDto.setCreateDateEnd(CalendarUtils.getCurrentDateEndTime(reqDto.getCreateDateEnd()));
		}
		if (reqDto.getOnLineTimeStart() != null) {
			reqDto.setOnLineTimeStart(CalendarUtils.getCurrentDayBeginTime(reqDto.getOnLineTimeStart()));
		}
		if (reqDto.getOnLineTimeEnd() != null) {
			reqDto.setOnLineTimeEnd(CalendarUtils.getCurrentDateEndTime(reqDto.getOnLineTimeEnd()));
		}

		// 设置排序
		resetParamOrderBy(reqDto);
	}

	/**
	 * 设置排序
	 *
	 * @param reqDto
	 */
	private void resetParamOrderBy(ProductManagerListReqDto reqDto) {
		if (reqDto == null) {
			return;
		}
		if (BooleanUtils.isBlank(reqDto.getOrderColumn())) {
			reqDto.setOrderColumn(" p.create_date");
			reqDto.setSort("desc");
			return;
		}

		if (BooleanUtils.isBlank(reqDto.getSort())) {
			reqDto.setSort("asc");
		} else if (reqDto.getSort().trim().equals("asc")) {
			reqDto.setSort("asc");
		} else if (reqDto.getSort().trim().equals("desc")) {
			reqDto.setSort("desc");
		} else {
			reqDto.setSort("asc");
		}

		if (reqDto.getOrderColumn().equals("levels")) {
			if (reqDto.getSort().trim().equals("asc")) {
				reqDto.setOrderColumn("IF(p.level='' OR p.level IS NULL,9999,p.level)");
			} else if (reqDto.getSort().trim().equals("desc")) {
				reqDto.setOrderColumn("IF(p.level='' OR p.level IS NULL,-9999,p.level)");
			}
		} else if (reqDto.getOrderColumn().equals("riskLevels")) {
			reqDto.setOrderColumn("p.risk_level");
		} else if (reqDto.getOrderColumn().equals("productScale")) {
			reqDto.setOrderColumn("ps.product_scale");
		} else if (reqDto.getOrderColumn().equals("createDate")) {
			reqDto.setOrderColumn(" p.create_date");
		} else if (reqDto.getOrderColumn().equals("onLineTime")) {
			reqDto.setOrderColumn("p.on_line_time");
		}

	}

	/**
	 * 重置查询产品管理列表返回结束数据
	 *
	 * @param datas
	 */
	private void resetManagerListReturnData(List<ProductManagerListResDto> datas) {
		// 重置用户信息
		resetManagerListReturnDataUserInfo(datas);

		// 设置状态文本
		for (ProductManagerListResDto dto : datas) {
			dto.setExamineStatusText(ProductExamineStatusEnum.getEnumName(dto.getExamineStatus()));
			dto.setIssuedStatusText(ProductIssuedStatusEnum.getEnumName(dto.getIssuedStatus()));
		}

		// 设置字段的文本信息
		List<FiledSelectDto> filedSelectDtos = getlevelAndRiskLevelSelect();
		for (ProductManagerListResDto dto : datas) {
			dto.setLevelText(FiledSelectDto.getSelectLableName(filedSelectDtos,
					ProductTableFieldEnum.LEVEL.getPropertyName(), dto.getLevel()));
			dto.setRiskLevelText(FiledSelectDto.getSelectLableName(filedSelectDtos,
					ProductTableFieldEnum.RISK_LEVEL.getPropertyName(), dto.getRiskLevel()));
		}

		// 设置操作信息
		List<Long> allProductIds = new ArrayList<Long>();
		for (ProductManagerListResDto dto : datas) {
			ProductActionDto actionDto = new ProductActionDto();
			actionDto.setExamineStatusText(dto.getExamineStatusText());
			actionDto.setIssuedStatusText(dto.getIssuedStatusText());
			if (ProductExamineStatusEnum.REJECT.getValue().equals(dto.getExamineStatus())
					|| ProductExamineStatusEnum.CANCEL.getValue().equals(dto.getExamineStatus())) {
				actionDto.setReason(dto.getReason());
			} else {
				actionDto.setReason(null);
				dto.setReason(null);
			}
			actionDto.setSelectDtos(
					ProductManagerActionEnum.getProductActionSelectDtos(dto.getExamineStatus(), dto.getIssuedStatus()));
			dto.setActionDto(actionDto);
			allProductIds.add(dto.getId());
		}

		// TODO 数据权限查询

		// 设置预约金额
		List<ProductReservationAmountDto> productAmounts = reservationMapper
				.getProductReservationAmountDtos(allProductIds);
		if (!BooleanUtils.isEmpty(productAmounts)) {
			for (ProductManagerListResDto dto : datas) {
				for (ProductReservationAmountDto amountDto : productAmounts) {
					if (dto.getId().equals(amountDto.getProductId())) {
						if (amountDto.getSumAmount() != null) {
							dto.setReservationAmount(SymbolStrUtils.doubleToString(amountDto.getSumAmount()));
						}

					}
				}
			}
		}

		// 设置报单金额
		List<ProductDeclarationAmountDto> declarationAmountDtos = declarationMapper
				.getProductDeclarationAmountDtos(allProductIds);
		if (!BooleanUtils.isEmpty(declarationAmountDtos)) {
			for (ProductManagerListResDto dto : datas) {
				for (ProductDeclarationAmountDto amountDto : declarationAmountDtos) {
					if (dto.getId().equals(amountDto.getProductId())) {
						if (amountDto.getSumAmount() != null) {
							dto.setDeclarationAmount(SymbolStrUtils.doubleToString(amountDto.getSumAmount()));
						}
					}
				}
			}
		}

	}

	/**
	 * 重置用户信息(对接人, 产品助理)
	 *
	 * @param datas
	 */
	private void resetManagerListReturnDataUserInfo(List<ProductManagerListResDto> datas) {
		// 设置产品助理和产品对接人姓名
		List<Long> userIds = new ArrayList<Long>();
		for (ProductManagerListResDto dto : datas) {
			if (!userIds.contains(dto.getReceiverId())) {
				userIds.add(dto.getReceiverId());
			}
			if (!userIds.contains(dto.getAssistantId())) {
				userIds.add(dto.getAssistantId());
			}
		}
		List<BaseUserDetail> userList = userDetailService.getUserDetail(userIds);
		for (ProductManagerListResDto dto : datas) {
			if (dto.getReceiverId() != null) {
				for (BaseUserDetail model : userList) {
					if (dto.getReceiverId().equals(model.getId())) {
						dto.setReceiverRealName(model.getRealName());
					}
				}
			}
			if (dto.getAssistantId() != null) {
				for (BaseUserDetail model : userList) {
					if (dto.getAssistantId().equals(model.getId())) {
						dto.setAssistantRealName(model.getRealName());
					}
				}
			}
		}

	}

	/**
	 * 获取产品管理列表查询的下拉选项的条件
	 *
	 * @return
	 * @throws Exception
	 */
	public Result<List<FiledSelectDto>> getProductManagetrListSelectValue() throws Exception {
		List<FiledSelectDto> list = new ArrayList<FiledSelectDto>();
		list.addAll(getlevelAndRiskLevelSelect());
		// 添加发行状态
		list.add(ProductIssuedStatusEnum.getFiledSelectDto());

		// 添加审核状态
		list.add(ProductExamineStatusEnum.getFiledSelectDto());

		// 添加产品类型
		List<BaseFieldGroup> productTypeList = fieldGroupService
				.getByBusinessCode(BusinessObjectEnum.PRODUCT.getCode());
		list.add(this.getProductTypeFiledSelects(productTypeList));
		return Result.newSuccessResult(list);
	}

	/**
	 * 获取等级和风险等级的下拉选项值
	 *
	 * @return
	 */
	private List<FiledSelectDto> getlevelAndRiskLevelSelect() {
		List<String> fieldNames = new ArrayList<String>();
		fieldNames.add(ProductTableFieldEnum.LEVEL.getFieldName());
		fieldNames.add(ProductTableFieldEnum.RISK_LEVEL.getFieldName());

		List<FiledSelectDto> list = fieldSelectService.getFiledSelectConfigs(fieldNames);
		ProductTableFieldEnum.resetFiledSelectPropertyName(list);
		return list;
	}

	/**
	 * 查询字段
	 *
	 * @param productTypeList
	 * @return
	 */
	private FiledSelectDto getProductTypeFiledSelects(List<BaseFieldGroup> productTypeList) {
		FiledSelectDto dto = new FiledSelectDto();
		if (!BooleanUtils.isEmpty(productTypeList)) {
			List<SelectConfigStringValueDto> fieldConfigDtos = new ArrayList<SelectConfigStringValueDto>();
			dto.setFieldConfigDtos(fieldConfigDtos);
			for (BaseFieldGroup group : productTypeList) {
				SelectConfigStringValueDto configDto = new SelectConfigStringValueDto();
				fieldConfigDtos.add(configDto);
				configDto.setLable(group.getName());
				configDto.setValue(group.getCode());
			}
		}
		dto.setLable("产品类型");
		dto.setName("typeCode");
		return dto;
	}

	/**
	 * 通过产品id获取产品销售信息
	 *
	 * @param productId
	 * @return
	 */
	public BaseProductSale selectBaseProductSaleByProductId(Long productId) throws BaseException {
		BaseProductSaleExample example = new BaseProductSaleExample();
		example.createCriteria().andProductIdEqualTo(productId);
		BaseProductSale BaseProductSale = baseProductSaleMapper.selectOne(example);
		return BaseProductSale;
	}

	/**
	 * 设置对接人和助理的名称
	 *
	 * @param productFieldDtos
	 * @throws BaseException
	 */
	public void setReceiverAndAssistantName(List<FieldDetailDto> productFieldDtos) throws BaseException {
		if (BooleanUtils.isEmpty(productFieldDtos)) {
			return;
		}
		for (FieldDetailDto dto : productFieldDtos) {
			if (dto.getName().equals(ProductTableFieldEnum.RECEIVER_ID.getPropertyName())) {
				FieldConfigDto fieldConfigDto = dto.getFieldConfigDto();
				if (fieldConfigDto != null && !BooleanUtils.isBlank(fieldConfigDto.getInitValue())) {
					Long receiverId = Long.parseLong(fieldConfigDto.getInitValue());
					fieldConfigDto.setInitValueText(userDetailService.getUserRealName(receiverId));
				}
			} else if (dto.getName().equals(ProductTableFieldEnum.ASSISTANT_ID.getPropertyName())) {
				FieldConfigDto fieldConfigDto = dto.getFieldConfigDto();
				if (fieldConfigDto != null && !BooleanUtils.isBlank(fieldConfigDto.getInitValue())) {
					Long assistantId = Long.parseLong(fieldConfigDto.getInitValue());
					fieldConfigDto.setInitValueText(userDetailService.getUserRealName(assistantId));
				}
			}
		}
	}

	/**
	 * 检查当前用户是否关注
	 *
	 * @param productId
	 * @return
	 * @throws BaseException
	 */
	public boolean checkCurrentUserIsFocus(Long productId) throws BaseException {
		BaseProductFocusExample example = new BaseProductFocusExample();
		example.createCriteria().andProductIdEqualTo(productId).andUserIdEqualTo(this.getHeaderUserId());
		int count = baseProductFocusMapper.countByExample(example);
		return count > 0;
	}

	@Override
	public Result<List<ProductSelectionForReceiptPlanDto>> getForReceiptPlan(String name) throws BaseException {
		return Result.newSuccessResult(productSelectMapper.selectForReceiptPlan(name));
	}

}
