package com.yundao.tenant.service.roadshowcolumn.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnAddReqDto;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnReqDto;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnResDto;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnUpdateReqDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.mapper.base.roadshow.BaseRoadshowColumnMapper;
import com.yundao.tenant.mapper.base.roadshow.BaseRoadshowColumnRelMapper;
import com.yundao.tenant.mapper.roadshow.RoadshowColumnMapper;
import com.yundao.tenant.model.base.platform.BasePlatform;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumn;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnExample;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnRelExample;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.platform.PlatformService;
import com.yundao.tenant.service.roadshowcolumn.RoadshowColumnService;
import com.yundao.tenant.service.user.UserDetailService;

@Service
public class RoadshowColumnServiceImpl extends AbstractService implements RoadshowColumnService {

	@Autowired
	private BaseRoadshowColumnMapper baseRoadshowColumnMapper;
	@Autowired
	private RoadshowColumnMapper roadshowColumnMapper;
	@Autowired
	private BaseRoadshowColumnRelMapper baseRoadshowColumnRelMapper;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private PlatformService platformService;
	@Autowired
	private DictionaryService dictionaryService;

	public Result<Long> add(RoadshowColumnAddReqDto reqDto) throws Exception {
		BaseRoadshowColumn model = new BaseRoadshowColumn();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setId(null);
		model.setTenantId(this.getHeaderTenantId());
		model.setUpdateUserId(super.getHeaderUserId());
		model.setUpdateDate(new Date());
		int count = baseRoadshowColumnMapper.insertSelective(model);
		return Result.newSuccessResult(model.getId());
	}

	public Result<Long> update(RoadshowColumnUpdateReqDto reqDto) throws Exception {
		BaseRoadshowColumn model = baseRoadshowColumnMapper.selectByPrimaryKey(reqDto.getId());
		if (model == null) {
			throw new BaseException(Code1200000.CODE_1200189);
		}
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseRoadshowColumnMapper.updateByPrimaryKey(model);
		return Result.newSuccessResult(model.getId());
	}

	public Result<Integer> delete(String ids) throws Exception {
		if (StringUtils.isBlank(ids)) {
			return Result.newSuccessResult(0);
		}
		String[] idArr = ids.split(",");
		List<Long> idList = new ArrayList<>();
		for (int i = 0; i < idArr.length; i++) {
			idList.add(NumberUtils.toLong(idArr[i]));
		}
		/**
		 * 删除栏目与路演的关联关系
		 */
		BaseRoadshowColumnRelExample relExample = new BaseRoadshowColumnRelExample();
		relExample.createCriteria().andColumnIdIn(idList);
		baseRoadshowColumnRelMapper.deleteByExample(relExample);

		/**
		 * 删除栏目表数据
		 */
		BaseRoadshowColumnExample example = new BaseRoadshowColumnExample();
		example.createCriteria().andIdIn(idList);
		BaseRoadshowColumn updateRoadshowColumn = new BaseRoadshowColumn();
		updateRoadshowColumn.setIsDelete(DeleteEnum.DELETED.getValue());
		super.updateModel(updateRoadshowColumn);
		int count = baseRoadshowColumnMapper.updateByExampleSelective(updateRoadshowColumn, example);

		return Result.newSuccessResult(count);
	}

	public Result<RoadshowColumnResDto> get(Long id) throws Exception {
		BaseRoadshowColumn model = baseRoadshowColumnMapper.selectByPrimaryKey(id);
		RoadshowColumnResDto dto = new RoadshowColumnResDto();
		if (model != null) {
			BeanUtils.copyProperties(model, dto);
			if (dto.getPlatformId() != null) {
				BasePlatform platform = platformService.getById(dto.getPlatformId());
				if (platform != null) {
					dto.setPlatformCode(platform.getCode());
					dto.setPlatformName(platform.getName());
				}
			}
			if (dto.getUpdateUserId() != null) {
				dto.setUpdateUserName(userDetailService.getUserRealName(dto.getUpdateUserId()));
			}
			if (dto.getStatus() != null) {
				dto.setStatusText(dictionaryService.toText(DicCode.DIC_ROADSHOW_COLUMN_STATUS, dto.getStatus()));
			}
		}
		return Result.newSuccessResult(dto);
	}

	@Override
	public Result<List<BaseRoadshowColumn>> getsByPlatformId(Long platformId) throws Exception {
		if (platformId == null) {
			return Result.newSuccessResult(null);
		}
		BaseRoadshowColumnExample example = new BaseRoadshowColumnExample();
		example.createCriteria().andPlatformIdEqualTo(platformId);
		List<BaseRoadshowColumn> columns = baseRoadshowColumnMapper.selectByExample(example);
		return Result.newSuccessResult(columns);

	}

	@Override
	public Result<List<BaseRoadshowColumn>> getsByPlatformCode(String platformCode) throws Exception {

		if (StringUtils.isBlank(platformCode)) {
			throw new BaseException(Code1200000.CODE_1200179);
		}
		BasePlatform platform = platformService.get(platformCode);

		if (platform == null) {
			throw new BaseException(Code1200000.CODE_1200180);
		}
		String orderByClause = "sequence asc,update_date desc";
		BaseRoadshowColumnExample example = new BaseRoadshowColumnExample();
		example.setOrderByClause(orderByClause);
		example.createCriteria().andPlatformIdEqualTo(platform.getId())
				.andStatusEqualTo(EnabledEnum.ENABLED.getValue());
		List<BaseRoadshowColumn> columns = baseRoadshowColumnMapper.selectByExample(example);
		return Result.newSuccessResult(columns);

	}

	public Result<PaginationSupport<RoadshowColumnResDto>> getPage(RoadshowColumnReqDto roadshowColumnReqDto)
			throws Exception {
		List<RoadshowColumnResDto> list = roadshowColumnMapper.selectPage(roadshowColumnReqDto);
		int totalCount = roadshowColumnMapper.selectCount(roadshowColumnReqDto);
		if (list != null && !list.isEmpty()) {
			for (RoadshowColumnResDto dto : list) {
				if (dto.getUpdateUserId() != null) {
					dto.setUpdateUserName(userDetailService.getUserRealName(dto.getUpdateUserId()));
				}
				if (dto.getStatus() != null) {
					dto.setStatusText(dictionaryService.toText(DicCode.DIC_ROADSHOW_COLUMN_STATUS, dto.getStatus()));
				}

			}
		}
		PaginationSupport<RoadshowColumnResDto> result = roadshowColumnReqDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

}
