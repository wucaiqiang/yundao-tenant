package com.yundao.tenant.service.roadshow.impl;

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
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.roadshow.RoadshowAddReqDto;
import com.yundao.tenant.dto.roadshow.RoadshowDetailResDto;
import com.yundao.tenant.dto.roadshow.RoadshowReqDto;
import com.yundao.tenant.dto.roadshow.RoadshowResDto;
import com.yundao.tenant.dto.roadshow.RoadshowUpdateReqDto;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnResDto;
import com.yundao.tenant.dto.roadshowcolumnrel.RoadshowColumnRelReqDto;
import com.yundao.tenant.dto.roadshowproductrel.RoadshowProductRelReqDto;
import com.yundao.tenant.dto.video.VideoDetailResDto;
import com.yundao.tenant.dto.video.VideoDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.base.roadshow.BaseRoadshowColumnMapper;
import com.yundao.tenant.mapper.base.roadshow.BaseRoadshowColumnRelMapper;
import com.yundao.tenant.mapper.base.roadshow.BaseRoadshowMapper;
import com.yundao.tenant.mapper.base.roadshow.BaseRoadshowProductRelMapper;
import com.yundao.tenant.mapper.roadshow.RoadshowColumnMapper;
import com.yundao.tenant.mapper.roadshow.RoadshowMapper;
import com.yundao.tenant.model.base.platform.BasePlatform;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductExample;
import com.yundao.tenant.model.base.roadshow.BaseRoadshow;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumn;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnExample;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnRel;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnRelExample;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowExample;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowProductRel;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowProductRelExample;
import com.yundao.tenant.model.base.video.BaseVideoTranscode;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.platform.PlatformService;
import com.yundao.tenant.service.roadshow.RoadshowService;
import com.yundao.tenant.service.roadshowcolumnrel.RoadshowColumnRelService;
import com.yundao.tenant.service.roadshowproductrel.RoadshowProductRelService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.video.VideoService;
import com.yundao.tenant.service.videotranscode.VideoTranscodeService;

@Service
public class RoadshowServiceImpl extends AbstractService implements RoadshowService {

	@Autowired
	private BaseRoadshowMapper baseRoadshowMapper;
	@Autowired
	private RoadshowMapper roadshowMapper;
	@Autowired
	private RoadshowColumnRelService roadshowColumnRelService;
	@Autowired
	private BaseRoadshowColumnRelMapper baseRoadshowColumnRelMapper;
	@Autowired
	private BaseRoadshowProductRelMapper baseRoadshowProductRelMapper;
	@Autowired
	private RoadshowProductRelService roadshowProductRelService;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private PlatformService platformService;
	@Autowired
	private BaseRoadshowColumnMapper baseRoadshowColumnMapper;
	@Autowired
	private RoadshowColumnMapper roadshowColumnMapper;
	@Autowired
	private BaseProductMapper baseProductMapper;
	@Autowired
	private VideoService videoService;
	@Autowired
	private VideoTranscodeService videoTranscodeService;
	@Autowired
	private DictionaryService dictionaryService;

	public Result<Long> add(RoadshowAddReqDto reqDto) throws Exception {
		BaseRoadshow model = new BaseRoadshow();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setUpdateUserId(this.getHeaderUserId());
		model.setUpdateDate(new Date());
		model.setTenantId(super.getHeaderTenantId());
		model.setId(null);
		int count = baseRoadshowMapper.insertSelective(model);
		if (StringUtils.isNotBlank(reqDto.getColumnIds())) {
			String[] columnIds = reqDto.getColumnIds().split(",");
			for (int i = 0; i < columnIds.length; i++) {
				RoadshowColumnRelReqDto relReqDto = new RoadshowColumnRelReqDto();
				relReqDto.setColumnId(NumberUtils.toLong(columnIds[i]));
				relReqDto.setRoadshowId(model.getId());
				roadshowColumnRelService.add(relReqDto);// 添加与栏目的关联关系
			}

		}
		if (reqDto.getProductId() != null) {
			RoadshowProductRelReqDto productRelReqDto = new RoadshowProductRelReqDto();
			productRelReqDto.setProductId(reqDto.getProductId());
			productRelReqDto.setRoadshowId(model.getId());
			roadshowProductRelService.add(productRelReqDto);// 添加与产品的关联关系
		}

		return Result.newSuccessResult(model.getId());
	}

	public Result<Long> update(RoadshowUpdateReqDto reqDto) throws Exception {
		BaseRoadshow model = baseRoadshowMapper.selectByPrimaryKey(reqDto.getId());
		if (model == null) {
			throw new BaseException(Code1200000.CODE_1200190);
		}
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseRoadshowMapper.updateByPrimaryKey(model);
		roadshowColumnRelService.updateByColumnIdsAndRoadShowId(reqDto.getColumnIds(), reqDto.getId());// 修改关联关系

		RoadshowProductRelReqDto relReqDto = new RoadshowProductRelReqDto();
		relReqDto.setProductId(reqDto.getProductId());
		relReqDto.setRoadshowId(model.getId());
		roadshowProductRelService.updateByProductIdAndRoadShowId(relReqDto);// 修改与产品的关联关系

		return Result.newSuccessResult(model.getId());
	}

	public Result<Integer> delete(String ids) throws Exception {
		if (StringUtils.isBlank(ids)) {
			throw new BaseException(Code1200000.CODE_1200176);
		}
		String[] idArr = ids.split(",");
		List<Long> idList = new ArrayList<>();
		for (int i = 0; i < idArr.length; i++) {
			idList.add(NumberUtils.toLong(idArr[i]));
		}
		BaseRoadshowExample example = new BaseRoadshowExample();
		example.createCriteria().andIdIn(idList);
		BaseRoadshow updateRoadshow = new BaseRoadshow();
		updateRoadshow.setIsDelete(DeleteEnum.DELETED.getValue());
		super.updateModel(updateRoadshow);
		int count = baseRoadshowMapper.updateByExampleSelective(updateRoadshow, example);// 删除路演表数据

		BaseRoadshowColumnRelExample columnRelExample = new BaseRoadshowColumnRelExample();
		columnRelExample.createCriteria().andRoadshowIdIn(idList);
		baseRoadshowColumnRelMapper.deleteByExample(columnRelExample);// 删除与栏目的关联关系

		BaseRoadshowProductRelExample productRelExample = new BaseRoadshowProductRelExample();
		productRelExample.createCriteria().andRoadshowIdIn(idList);
		baseRoadshowProductRelMapper.deleteByExample(productRelExample);// 删除与产品的关联关系

		return Result.newSuccessResult(count);
	}

	@Override
	public Result<List<RoadshowResDto>> getByProductId(Long productId) throws Exception {
		if (productId == null) {
			throw new BaseException(CodeConstant.CODE_1200041);
		}

		BaseRoadshowProductRelExample example = new BaseRoadshowProductRelExample();
		example.createCriteria().andProductIdEqualTo(productId);
		List<BaseRoadshowProductRel> productRels = baseRoadshowProductRelMapper.selectByExample(example);
		if (productRels != null && !productRels.isEmpty()) {
			List<Long> ids = new ArrayList<>();
			for (BaseRoadshowProductRel rel : productRels) {
				ids.add(rel.getRoadshowId());
			}
			BaseRoadshowExample roadshowExample = new BaseRoadshowExample();
			roadshowExample.createCriteria().andIdIn(ids);
			List<BaseRoadshow> roadshows = baseRoadshowMapper.selectByExample(roadshowExample);
			if (roadshows != null && !roadshows.isEmpty()) {
				List<RoadshowResDto> resDtos = new ArrayList<>();

				for (BaseRoadshow baseRoadshow : roadshows) {
					RoadshowResDto dto = new RoadshowResDto();
					BeanUtils.copyProperties(baseRoadshow, dto);

					if (dto.getUpdateUserId() != null) {
						dto.setUpdateUserName(userDetailService.getUserRealName(dto.getUpdateUserId()));
					}
					if (dto.getStatus() != null) {
						dto.setStatusText(dictionaryService.toText(DicCode.DIC_ROADSHOW_STATUS, dto.getStatus()));
					}
					// 路演平台
					if (dto.getPlatformId() != null) {
						BasePlatform platform = platformService.getById(dto.getPlatformId());
						if (platform != null) {
							dto.setPlatformName(platform.getName());
							dto.setPlatformCode(platform.getCode());
						}
					}
					// 路演栏目
					List<BaseRoadshowColumn> columns = this.getRoadshowColumn(dto.getId());
					if (columns != null && !columns.isEmpty()) {
						StringBuilder builder = new StringBuilder();
						for (BaseRoadshowColumn column : columns) {
							if (builder.length() > 0) {
								builder.append(",");
							}
							builder.append(column.getName());
						}
						dto.setColumnNames(builder.toString());
					}
					// 路演产品
					List<BaseProduct> products = this.getProduct(dto.getId());
					if (products != null && !products.isEmpty()) {
						BaseProduct product = products.get(0);
						dto.setProductName(product.getName());
						dto.setProductId(product.getId());
						dto.setIssuedStatus(product.getIssuedStatus());
						dto.setIssuedStatusText(ProductIssuedStatusEnum.getEnumName(product.getIssuedStatus()));
						dto.setWxContent(product.getWxContent());
					}
					// 查询视频及转码信息
					Result<VideoDto> video = videoService.get(dto.getVideoId());
					if (video.getResult() != null) {
						VideoDetailResDto videoDetailResDto = new VideoDetailResDto();
						BeanUtils.copyProperties(video.getResult(), videoDetailResDto);
						Result<List<BaseVideoTranscode>> tResult = videoTranscodeService.getByVideoId(dto.getVideoId());
						if (tResult.getResult() != null) {
							videoDetailResDto.setBaseVideoTranscodes(tResult.getResult());
						}
						dto.setVideo(videoDetailResDto);
					}
					resDtos.add(dto);
				}
				return Result.newSuccessResult(resDtos);
			}
		}
		return Result.newSuccessResult(null);

	}

	public Result<RoadshowDetailResDto> get(Long id) throws Exception {
		BaseRoadshow model = baseRoadshowMapper.selectByPrimaryKey(id);
		RoadshowDetailResDto dto = new RoadshowDetailResDto();
		if (model != null) {
			BeanUtils.copyProperties(model, dto);
			if (dto.getPlatformId() != null) {
				BasePlatform platform = platformService.getById(dto.getPlatformId());
				if (platform != null) {
					dto.setPlatformName(platform.getName());
					dto.setPlatformCode(platform.getCode());
				}
			}
			if (dto.getUpdateUserId() != null) {
				dto.setUpdateUserName(userDetailService.getUserRealName(dto.getUpdateUserId()));
			}
			if (dto.getStatus() != null) {
				dto.setStatusText(dictionaryService.toText(DicCode.DIC_ROADSHOW_STATUS, dto.getStatus()));
			}
			List<BaseRoadshowColumn> columns = this.getRoadshowColumn(id);
			if (columns != null && !columns.isEmpty()) {
				StringBuilder builder = new StringBuilder();
				StringBuilder columnIds = new StringBuilder();
				for (BaseRoadshowColumn column : columns) {
					if (builder.length() > 0) {
						builder.append(",");
					}
					if (columnIds.length() > 0) {
						columnIds.append(",");
					}
					builder.append(column.getName());
					columnIds.append(column.getId());
				}
				dto.setColumnNames(builder.toString());
				dto.setColumnIds(columnIds.toString());
			}
			List<BaseProduct> products = this.getProduct(id);
			if (products != null && !products.isEmpty()) {
				BaseProduct product = products.get(0);
				dto.setProductName(product.getName());
				dto.setProductId(product.getId());
				dto.setIssuedStatus(product.getIssuedStatus());
				dto.setIssuedStatusText(ProductIssuedStatusEnum.getEnumName(product.getIssuedStatus()));
				dto.setWxContent(product.getWxContent());
			}
			// 查询视频及转码信息
			Result<VideoDto> videoResult = videoService.get(dto.getVideoId());
			if (videoResult.getResult() != null) {
				VideoDto video = videoResult.getResult();
				dto.setVideoName(video.getName());
				VideoDetailResDto videoDetailResDto = new VideoDetailResDto();
				BeanUtils.copyProperties(video, videoDetailResDto);
				Result<List<BaseVideoTranscode>> tResult = videoTranscodeService.getByVideoId(dto.getVideoId());
				if (tResult.getResult() != null) {
					videoDetailResDto.setBaseVideoTranscodes(tResult.getResult());
				}
				dto.setVideo(videoDetailResDto);
			}

		}
		return Result.newSuccessResult(dto);
	}

	public List<BaseProduct> getProduct(Long roadshowId) throws BaseException {
		if (roadshowId == null) {
			return null;
		}
		BaseRoadshowProductRelExample relExample = new BaseRoadshowProductRelExample();
		relExample.createCriteria().andRoadshowIdEqualTo(roadshowId);
		List<BaseRoadshowProductRel> productRels = baseRoadshowProductRelMapper.selectByExample(relExample);
		List<Long> productIds = new ArrayList<>();
		if (productRels != null && !productRels.isEmpty()) {
			for (BaseRoadshowProductRel rel : productRels) {
				productIds.add(rel.getProductId());
			}
		}
		if (productIds.isEmpty()) {
			return null;
		}
		BaseProductExample productExample = new BaseProductExample();
		productExample.createCriteria().andIdIn(productIds);
		List<BaseProduct> products = baseProductMapper.selectByExample(productExample);

		return products;

	}

	public List<BaseRoadshowColumn> getRoadshowColumn(Long roadshowId) throws BaseException {
		if (roadshowId == null) {
			return null;
		}
		BaseRoadshowColumnRelExample relExample = new BaseRoadshowColumnRelExample();
		relExample.createCriteria().andRoadshowIdEqualTo(roadshowId);
		List<BaseRoadshowColumnRel> rels = baseRoadshowColumnRelMapper.selectByExample(relExample);
		List<Long> columnIds = new ArrayList<>();
		if (rels != null && !rels.isEmpty()) {
			for (BaseRoadshowColumnRel rel : rels) {
				columnIds.add(rel.getColumnId());
			}
		}
		if (columnIds.isEmpty()) {
			return null;
		}
		BaseRoadshowColumnExample columnExample = new BaseRoadshowColumnExample();
		columnExample.createCriteria().andIdIn(columnIds);
		List<BaseRoadshowColumn> columns = baseRoadshowColumnMapper.selectByExample(columnExample);
		return columns;

	}

	public Result<PaginationSupport<RoadshowResDto>> getPage(RoadshowReqDto roadshowReqDto) throws Exception {
		if (StringUtils.isNotBlank(roadshowReqDto.getColumnNames())) {
			String[] columnNames = roadshowReqDto.getColumnNames().split(",");
			List<String> columnNameList = new ArrayList<>();
			for (int i = 0; i < columnNames.length; i++) {
				columnNameList.add(columnNames[i]);
			}
			List<RoadshowColumnResDto> resDtos = roadshowColumnMapper.selectListByNames(columnNameList);
			if (resDtos != null && !resDtos.isEmpty()) {
				StringBuilder columnIds = new StringBuilder();
				for (RoadshowColumnResDto resDto : resDtos) {
					if (columnIds.length() > 0) {
						columnIds.append(",");
					}
					columnIds.append(resDto.getId());
				}
				roadshowReqDto.setColumnIds(columnIds.toString());
			}
		}
		List<RoadshowResDto> list = roadshowMapper.selectPage(roadshowReqDto);
		int totalCount = roadshowMapper.selectCount(roadshowReqDto);
		if (list != null && !list.isEmpty()) {
			for (RoadshowResDto dto : list) {
				if (dto.getUpdateUserId() != null) {
					dto.setUpdateUserName(userDetailService.getUserRealName(dto.getUpdateUserId()));
				}
				if (dto.getStatus() != null) {
					dto.setStatusText(dictionaryService.toText(DicCode.DIC_ROADSHOW_STATUS, dto.getStatus()));
				}
				// 路演平台
				if (dto.getPlatformId() != null) {
					BasePlatform platform = platformService.getById(dto.getPlatformId());
					if (platform != null) {
						dto.setPlatformName(platform.getName());
						dto.setPlatformCode(platform.getCode());
					}
				}
				// 路演栏目
				List<BaseRoadshowColumn> columns = this.getRoadshowColumn(dto.getId());
				if (columns != null && !columns.isEmpty()) {
					StringBuilder builder = new StringBuilder();
					for (BaseRoadshowColumn column : columns) {
						if (builder.length() > 0) {
							builder.append(",");
						}
						builder.append(column.getName());
					}
					dto.setColumnNames(builder.toString());
				}
				// 路演产品
				List<BaseProduct> products = this.getProduct(dto.getId());
				if (products != null && !products.isEmpty()) {
					BaseProduct product = products.get(0);
					dto.setProductName(product.getName());
					dto.setProductId(product.getId());
					dto.setIssuedStatus(product.getIssuedStatus());
					dto.setIssuedStatusText(ProductIssuedStatusEnum.getEnumName(product.getIssuedStatus()));
					dto.setWxContent(product.getWxContent());
				}
				// 查询视频及转码信息
				Result<VideoDto> video = videoService.get(dto.getVideoId());
				if (video.getResult() != null) {
					VideoDetailResDto videoDetailResDto = new VideoDetailResDto();
					BeanUtils.copyProperties(video.getResult(), videoDetailResDto);
					Result<List<BaseVideoTranscode>> tResult = videoTranscodeService.getByVideoId(dto.getVideoId());
					if (tResult.getResult() != null) {
						videoDetailResDto.setBaseVideoTranscodes(tResult.getResult());
					}
					dto.setVideo(videoDetailResDto);
				}
			}
		}
		PaginationSupport<RoadshowResDto> result = roadshowReqDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

}
