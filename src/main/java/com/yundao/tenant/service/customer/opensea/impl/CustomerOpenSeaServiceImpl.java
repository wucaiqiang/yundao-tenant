
package com.yundao.tenant.service.customer.opensea.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaAppPageReqDto;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaAppPageResDto;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaPageReqDto;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaPageResDto;
import com.yundao.tenant.dto.sys.sale.SaleConfResDto;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.enums.common.SexEnum;
import com.yundao.tenant.enums.customer.CustomerBelongTypeEnum;
import com.yundao.tenant.enums.customer.CustomerLevelEnum;
import com.yundao.tenant.enums.customer.CustomerSourceType;
import com.yundao.tenant.enums.customer.CustomerStatusEnum;
import com.yundao.tenant.mapper.base.customer.BaseUserCustomerMapper;
import com.yundao.tenant.mapper.customer.opensea.CustomerOpenSeaMapper;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.model.base.customer.BaseUserCustomerExample;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.customer.opensea.CustomerOpenSeaService;
import com.yundao.tenant.service.customer.pool.impl.CustomerPoolServiceImpl;
import com.yundao.tenant.service.region.RegionService;
import com.yundao.tenant.service.sys.SysConfigService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.util.DateUtil;
import com.yundao.tenant.util.LocalBeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Function: Reason: Date: 2017年9月18日 下午7:59:28
 *
 * @author 欧阳利
 */
@Service
public class CustomerOpenSeaServiceImpl extends AbstractService implements CustomerOpenSeaService {

	private static Log log = LogFactory.getLog(CustomerPoolServiceImpl.class);

	@Autowired
	private CustomerOpenSeaMapper customerOpenSeaMapper;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RegionService regionService;

	@Autowired
	private UserService userService;

	@Autowired
	private SysConfigService sysConfigService;

	@Autowired
	BaseUserCustomerMapper baseUserCustomerMapper;

	/**
	 * app获取分页数据
	 */
	public Result<PaginationSupport<CustomerOpenSeaAppPageResDto>> getAppPage(CustomerOpenSeaAppPageReqDto dto,
			Integer permission) throws BaseException {
		Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
		PaginationSupport<CustomerOpenSeaAppPageResDto> page = PaginationSupport.newDefault(paramMap);
		userService.setPermissionCondition(paramMap, permission);
		if (DataObjectPermissionEnum.DEPARTMENT.getValue().equals(permission)
				&& BooleanUtils.isBlank(paramMap.get("userIds").toString())) {
			return Result.newSuccessResult(page);
		}

		// 查询总记录数
		int count = customerOpenSeaMapper.selectAppCustomerPageCount(paramMap);
		// 查询记录
		if (count > 0) {
			List<CustomerOpenSeaAppPageResDto> datas = customerOpenSeaMapper.selectAppCustomerPage(paramMap);
			page.setDatas(datas);
		}

		page.setTotalCount(count);
		return Result.newSuccessResult(page);
	}

	/**
	 * 领取公海客户 receiveCustomer:
	 *
	 * @param customerId
	 * @return
	 * @throws BaseException
	 * @author: 欧阳利
	 * @description:
	 */
	public Result<Integer> doReceiveCustomer(Long customerId) throws BaseException {
		// 检查是否已经被领取
		BaseUserCustomerExample example = new BaseUserCustomerExample();
		example.createCriteria().andCustomerIdEqualTo(customerId);
		BaseUserCustomer baseUserCustomer = baseUserCustomerMapper.selectOne(example);
		if (baseUserCustomer != null) {
			return Result.newFailureResult(CodeConstant.CODE_1200135);
		}

		SaleConfResDto saleConf = sysConfigService.getSaleConf().getResult();

		if (saleConf != null && saleConf.getOpensea() != null && saleConf.getOpensea().getTakeLimitEnable() != null
				&& saleConf.getOpensea().getTakeLimitEnable().equals(YesOrNoEnum.YES.getValue())) {
			// 开启了领取限制
			// 查询被领取的客户是否超过限制
			int count = customerOpenSeaMapper.selectReceiveCustomerCount(this.getHeaderUserId());
			if (count >= saleConf.getOpensea().getTakeLimitCount()) {
				return Result.newFailureResult(CodeConstant.CODE_1200136);
			}
		}

		// 领取客户
		BaseUserCustomer record = new BaseUserCustomer();
		record.setCreateDate(new Date());
		record.setCreateUserId(this.getHeaderUserId());
		record.setTenantId(this.getHeaderTenantId());
		record.setCustomerId(customerId);
		record.setUserId(this.getHeaderUserId());
		record.setDistributionDate(new Date());
		record.setDistributionUserId(this.getHeaderUserId());
		record.setIsDelete(0);
		record.setSourceType(CustomerSourceType.RECEIVE.getValue());
		baseUserCustomerMapper.insert(record);
		customerService.doSetBelongType(customerId, CustomerBelongTypeEnum.PRIVATE.getValue());

		return Result.newSuccessResult(1);
	}

    @Override
    public Result<PaginationSupport<CustomerOpenSeaPageResDto>> getPage(CustomerOpenSeaPageReqDto dto, Integer permission)
            throws
            BaseException {
        log.begin(dto);
        if (BooleanUtils.isNotEmpty(dto.getMobile()))
            dto.setMobile(BaseContactUtils.encrypt(dto.getMobile()));
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        if (StringUtils.isNotBlank(dto.getTagNames())) {
            String[] tags = dto.getTagNames().split(",");
            paramMap.put("tagNames", Arrays.asList(tags));
        }
        PaginationSupport<CustomerOpenSeaPageResDto> page = PaginationSupport.newDefault(paramMap);

        userService.setPermissionCondition(paramMap, permission);
        if (DataObjectPermissionEnum.DEPARTMENT.getValue().equals(permission) && BooleanUtils.isBlank(paramMap.get("userIds").toString())) {
            return Result.newSuccessResult(page);
        }

        this.convertBirthday(paramMap, dto);

        //根据不同权限，设置查询条件
        Integer count = customerOpenSeaMapper.selectCustomerPageCount(paramMap);
        if (count > 0) {
            List<CustomerOpenSeaPageResDto> dtos = customerOpenSeaMapper.selectCustomerPage(paramMap);
            this.setText(dtos);
            page.setDatas(dtos);
        }
        page.setTotalCount(count);
        return Result.newSuccessResult(page);
    }

    private void convertBirthday(Map<String, Object> paramMap, CustomerOpenSeaPageReqDto dto) throws BaseException {
        if (BooleanUtils.isNotBlank(dto.getBirthDayBegin())) {
            paramMap.put("birthdayBeginMonth", DateUtil.getMonth(dto.getBirthDayBegin()));
            paramMap.put("birthdayBeginDay", DateUtil.getDay(dto.getBirthDayBegin()));
        }
        if (BooleanUtils.isNotBlank(dto.getBirthDayEnd())) {
            paramMap.put("birthdayEndMonth", DateUtil.getMonth(dto.getBirthDayEnd()));
            paramMap.put("birthdayEndDay", DateUtil.getDay(dto.getBirthDayEnd()));
        }
    }


    /**
     * 设置文本
     */
    private void setText(List<CustomerOpenSeaPageResDto> dtos) throws BaseException {
        for (CustomerOpenSeaPageResDto dto : dtos) {
            dto.setLevelText(CustomerLevelEnum.getEnumName(dto.getLevel()));
            dto.setSexText(SexEnum.getEnumName(dto.getSex()));
            dto.setStatusText(CustomerStatusEnum.getEnumName(dto.getStatus()));
            dto.setIsDealText(dto.getDealDate() != null ? "是" : "否");
            dto.setMobile(BaseContactUtils.decrypt(dto.getMobile()));
            if (BooleanUtils.isNotEmpty(dto.getProvinceCode()))
                dto.setProvinceText(regionService.toText(dto.getProvinceCode()));
            if (BooleanUtils.isNotEmpty(dto.getCityCode()))
                dto.setCityText(regionService.toText(dto.getCityCode()));
        }
    }

}
