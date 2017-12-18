
package com.yundao.tenant.service.platform.impl;

import com.esotericsoftware.minlog.Log;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.CommonConstant;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.platform.PlatformDto;
import com.yundao.tenant.dto.platform.PositionDto;
import com.yundao.tenant.dto.tenant.DomainNameModel;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.mapper.base.platform.BasePlatformMapper;
import com.yundao.tenant.mapper.base.platform.BasePlatformPositionRefMapper;
import com.yundao.tenant.mapper.base.platform.BasePositionMapper;
import com.yundao.tenant.model.base.platform.*;
import com.yundao.tenant.service.platform.PlatformService;
import com.yundao.tenant.util.HttpUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Function: Reason: Date: 2017年10月20日 下午2:04:13
 *
 * @author 欧阳利
 */
@Service
public class PlatformServiceImpl extends AbstractService implements PlatformService {

	@Autowired
	private BasePlatformMapper basePlatformMapper;
	@Autowired
	private BasePlatformPositionRefMapper basePlatformPositionRefMapper;
	@Autowired
	private BasePositionMapper basePositionMapper;

	public List<PlatformDto> getAllPlatformDto() throws Exception {
		BasePlatformExample example = new BasePlatformExample();
		example.createCriteria().andIsDeleteEqualTo(0);
		// example.setOrderByClause(orderByClause);
		List<BasePlatform> list = basePlatformMapper.selectByExample(example);
		List<PlatformDto> dtos = new ArrayList<PlatformDto>();
		if (!BooleanUtils.isEmpty(list)) {
			StringBuilder platformArr = new StringBuilder();
			for (BasePlatform base : list) {
				PlatformDto dto = new PlatformDto();
				BeanUtils.copyProperties(base, dto);
				platformArr.append(CommonConstant.COMMA).append(base.getCode());
				dtos.add(dto);
			}

			if (platformArr.length() > 0) {
				Map<String, Object> params = new HashMap<>();
				params.put("platformCodes", platformArr.substring(1));
				params.put("tenantId", super.getHeaderTenantId());
				Log.info("请求平台url请求参数：" + params);
				Result<List<DomainNameModel>> result = HttpUtils.get(ScmUrlConstant.GET_DOMAIN_BYTP, params,
						new BaseTypeReference<Result<List<DomainNameModel>>>() {
						});
				Log.info("请求平台url返回：" + JsonUtils.objectToJson(result));
				if (result.getSuccess() && result.getResult() != null) {
					for (PlatformDto dto : dtos) {
						List<DomainNameModel> domainNameModels = result.getResult();
						for (DomainNameModel domainNameModel : domainNameModels) {
							if (dto.getCode().equals(domainNameModel.getPlatformCode())) {
								dto.setUrl(domainNameModel.getUrl());
							}
						}
					}
				}
			}
		}
		return dtos;
	}

	public List<PositionDto> getPositionDtoByPlatform(Long platformId) throws Exception {
		BasePlatformPositionRefExample example = new BasePlatformPositionRefExample();
		example.createCriteria().andPlatformIdEqualTo(platformId);
		List<BasePlatformPositionRef> list = basePlatformPositionRefMapper.selectByExample(example);

		List<PositionDto> dtos = new ArrayList<PositionDto>();
		if (BooleanUtils.isEmpty(list)) {
			return dtos;
		}
		List<Long> positionIds = new ArrayList<Long>();
		for (BasePlatformPositionRef base : list) {
			positionIds.add(base.getPositionId());
		}

		BasePositionExample positionExample = new BasePositionExample();
		positionExample.createCriteria().andIdIn(positionIds);
		List<BasePosition> positionList = basePositionMapper.selectByExample(positionExample);
		if (!BooleanUtils.isEmpty(positionList)) {
			for (BasePosition base : positionList) {
				PositionDto dto = new PositionDto();
				BeanUtils.copyProperties(base, dto);
				dtos.add(dto);
			}
		}
		return dtos;
	}

	@Override
	public BasePlatform getById(Long id) throws BaseException {
		return basePlatformMapper.selectByPrimaryKey(id);
	}

	@Override
	public BasePlatform get(String code) throws BaseException {
		BasePlatformExample example = new BasePlatformExample();
		example.createCriteria().andCodeEqualTo(code).andIsEnabledEqualTo(EnabledEnum.ENABLED.getValue());
		return basePlatformMapper.selectOne(example);

	}

	@Override
	public Long getId(String code) throws BaseException {
		BasePlatform platform = this.get(code);
		if (platform == null)
			return null;
		return platform.getId();
	}
}
