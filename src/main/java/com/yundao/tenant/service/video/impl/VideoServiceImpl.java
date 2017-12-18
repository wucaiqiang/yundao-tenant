package com.yundao.tenant.service.video.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JavaType;
import com.qcloud.Utilities.Base64;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.common.FailListDto;
import com.yundao.tenant.dto.common.PassListDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.tenant.TenantDto;
import com.yundao.tenant.dto.tencent.ClassAddDto;
import com.yundao.tenant.dto.tencent.TransCode;
import com.yundao.tenant.dto.tencent.VideoBasicInfo;
import com.yundao.tenant.dto.tencent.VideoDetailDto;
import com.yundao.tenant.dto.tencent.VideoMetaData;
import com.yundao.tenant.dto.tencent.VideoTransCodeInfo;
import com.yundao.tenant.dto.tencent.VodBaseDto;
import com.yundao.tenant.dto.tencent.VodTaskDto;
import com.yundao.tenant.dto.video.FileHandleDto;
import com.yundao.tenant.dto.video.VideoAddReqDto;
import com.yundao.tenant.dto.video.VideoDto;
import com.yundao.tenant.dto.video.VideoQueryDto;
import com.yundao.tenant.dto.video.VideoReqDto;
import com.yundao.tenant.dto.video.VideoUpdateReqDto;
import com.yundao.tenant.dto.videocategory.VideoCategoryReqDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.video.VideoDefinitionEnum;
import com.yundao.tenant.enums.video.VideoHandleTypeEnum;
import com.yundao.tenant.enums.video.VideoStatusEnum;
import com.yundao.tenant.mapper.base.BaseUserDetailMapper;
import com.yundao.tenant.mapper.base.roadshow.BaseRoadshowMapper;
import com.yundao.tenant.mapper.base.video.BaseVideoMapper;
import com.yundao.tenant.mapper.base.video.BaseVideoTranscodeMapper;
import com.yundao.tenant.mapper.video.VideoMapper;
import com.yundao.tenant.model.base.roadshow.BaseRoadshow;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowExample;
import com.yundao.tenant.model.base.video.BaseVideo;
import com.yundao.tenant.model.base.video.BaseVideoCategory;
import com.yundao.tenant.model.base.video.BaseVideoExample;
import com.yundao.tenant.model.base.video.BaseVideoTranscode;
import com.yundao.tenant.model.base.video.BaseVideoTranscodeExample;
import com.yundao.tenant.service.tencent.TencentService;
import com.yundao.tenant.service.user.TenantService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.video.VideoService;
import com.yundao.tenant.service.videocategory.VideoCategoryService;
import com.yundao.tenant.util.HttpUtils;

@Service
public class VideoServiceImpl extends AbstractService implements VideoService {

	private Log logger = LogFactory.getLog(VideoServiceImpl.class);

	private int signValidDuration = 20;// 上传视频签名有效时间，单位为秒
	private String HMAC_ALGORITHM = "HmacSHA1";// 签名使用的算法
	private String CONTENT_CHARSET = "UTF-8";// 默认编码格式
	@Autowired
	private BaseVideoMapper baseVideoMapper;
	@Autowired
	private VideoMapper videoMapper;
	@Autowired
	private BaseVideoTranscodeMapper baseVideoTranscodeMapper;
	@Autowired
	private VideoCategoryService videoCategoryService;
	@Autowired
	private TenantService tenantService;
	@Autowired
	private TencentService tencentService;// 调用腾讯接口的服务
	@Autowired
	private BaseUserDetailMapper baseUserDetailMapper;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private BaseRoadshowMapper baseRoadshowMapper;

	@Override
	public Result<PermissionResultDto> doConvertVodFile(String ids) throws Exception {
		// 调用腾讯云进行转码处理
		if (StringUtils.isBlank(ids)) {
			throw new BaseException(Code1200000.CODE_1200173);
		}
		PermissionResultDto permissionResultDto = new PermissionResultDto();
		String[] idArr = ids.split(",");
		for (int i = 0; i < idArr.length; i++) {
			Long id = NumberUtils.toLong(idArr[i]);
			BaseVideo baseVideo = baseVideoMapper.selectByPrimaryKey(id);
			if (baseVideo == null) {
				FailListDto failListDto = new FailListDto();
				failListDto.setId(NumberUtils.toLong(idArr[i]));
				failListDto.setCode(Code1200000.CODE_1200187);
				permissionResultDto.getFailList().add(failListDto);

			} else {
				PassListDto pass = new PassListDto();
				pass.setId(baseVideo.getId());
				pass.setName(baseVideo.getName());
				permissionResultDto.getPassList().add(pass);
			}

		}

		if (!permissionResultDto.isSuccess()) {
			return Result.newSuccessResult(permissionResultDto);
		}

		Map<String, Object> tranMap = new HashMap<>();
		StringBuilder idBuilder = new StringBuilder();
		for (int i = 0; i < idArr.length; i++) {
			Long id = NumberUtils.toLong(idArr[i]);
			BaseVideo baseVideo = baseVideoMapper.selectByPrimaryKey(id);
			if (baseVideo == null || StringUtils.isBlank(baseVideo.getRefId())) {
				continue;
			}
			boolean isTranscode = doTranscodeFile(baseVideo.getRefId());
			if (!isTranscode) {
				VodTaskDto result = tencentService.convertVodFile(baseVideo.getRefId());

				if (result.getCode() == null || result.getCode() != 0) {
					tranMap.put(String.valueOf(id), result);
					if (idBuilder.length() > 0) {
						idBuilder.append(",");
					}
					idBuilder.append(idArr[i]);
				}
			}

		}
		if (!tranMap.isEmpty()) {
			logger.info("视频IDs为：" + idBuilder.toString() + ",压缩失败");
		}
		return Result.newSuccessResult(null);

	}

	@Override
	public Result<Boolean> doFileHandle(String fileHandleDtos) throws Exception {
		JavaType javaType = JsonUtils.getCollectionType(List.class, FileHandleDto.class);
		List<FileHandleDto> dtos = JsonUtils.jsonToObject(fileHandleDtos, javaType);
		if (dtos != null && !dtos.isEmpty()) {
			for (FileHandleDto dto : dtos) {
				if (StringUtils.isBlank(dto.getHandleType()) || StringUtils.isBlank(dto.getFileId())) {
					continue;
				}

				if (VideoHandleTypeEnum.UPLOAD.getValue().equals(dto.getHandleType())) {
					this.addFile(dto.getFileId());
				} else if (VideoHandleTypeEnum.TRANSCODE.getValue().equals(dto.getHandleType())) {
					this.doTranscodeFile(dto.getFileId());
				}
			}
		}
		return Result.newSuccessResult();

	}

	@Override
	public Result<Boolean> doGetTranscodeMsg() throws Exception {
		Map<String, List<String>> fileMap = tencentService.getPullEvent();
		if (fileMap == null || fileMap.isEmpty()) {
			return Result.newSuccessResult();
		}
		List<String> uploadFileFileIds = fileMap.get("uploadFile");// 上传文件ID
		List<String> transcodeFileIds = fileMap.get("transcode");// 转码文件ID
		if (uploadFileFileIds != null && !uploadFileFileIds.isEmpty()) {
			for (String fileId : uploadFileFileIds) {
				this.addFile(fileId);
			}
		}
		if (transcodeFileIds != null && !transcodeFileIds.isEmpty()) {
			for (String fileId : transcodeFileIds) {
				this.doTranscodeFile(fileId);
			}
		}
		return Result.newSuccessResult();

	}

	@Override
	public Result<String> doGetUploadSignature() throws Exception {
		// 获取腾讯云密钥信息
		String secretId = ConfigUtils.getValue("SecretId");
		String secretKey = ConfigUtils.getValue("SecretKey");

		if (StringUtils.isBlank(secretId) || StringUtils.isBlank(secretKey)) {
			logger.error("配置文件获取不到腾讯云密钥信息，请核对配置信息");
			return Result.newFailureResult();
		}
		// 查询当前租户在腾讯云是否已经存在目录，本地库中如果存在，代表在腾讯云那边已经存在的
		BaseVideoCategory videoCategory = videoCategoryService.getOne();
		// 获取租户code
		TenantDto tenant = tenantService.get();
		if (tenant == null || StringUtils.isBlank(tenant.getCode())) {
			throw new BaseException(CodeConstant.CODE_1200137);
		}
		String tenantCode = tenant.getCode();
		String refId = "";
		if (videoCategory == null) {
			// 调用腾讯云接口添加目录
			ClassAddDto classAddDto = tencentService.addClass(tenantCode);
			if (classAddDto == null || classAddDto.getCode() == null || classAddDto.getCode() != 0
					|| StringUtils.isBlank(classAddDto.getNewClassId())) {
				logger.info("调用腾讯云创建视频分类失败");
				return Result.newFailureResult();
			}

			VideoCategoryReqDto reqDto = new VideoCategoryReqDto();
			reqDto.setName(tenantCode);
			reqDto.setRefId(classAddDto.getNewClassId());
			videoCategoryService.add(reqDto);// 添加视频分类信息

			refId = classAddDto.getNewClassId();

		} else if (!videoCategory.getName().equals(tenantCode)) {
			// 修改腾讯云租户目录结构
			tencentService.updateClass(Integer.parseInt(videoCategory.getRefId()), tenantCode);// 修改腾讯云文件分类
			VideoCategoryReqDto reqDto = new VideoCategoryReqDto();
			reqDto.setId(videoCategory.getId());
			reqDto.setName(tenantCode);
			videoCategoryService.update(reqDto);

			refId = videoCategory.getRefId();
		} else {
			refId = videoCategory.getRefId();
		}
		long currentTime = System.currentTimeMillis() / 1000;
		int random = new Random().nextInt(java.lang.Integer.MAX_VALUE);// 随机数据
		long endTime = (currentTime + signValidDuration);// 过期时间
		String strSign = "";
		String contextStr = "";
		contextStr += "secretId=" + java.net.URLEncoder.encode(secretId, "utf8");
		contextStr += "&currentTimeStamp=" + currentTime;
		contextStr += "&expireTime=" + endTime;
		contextStr += "&random=" + random;
		contextStr += "&classId=" + refId;// 文件分类Id
		contextStr += "&procedure=" + java.net.URLEncoder.encode("QCVB_SimpleProcessFile(1,0,10,0)", "utf8");

		try {
			Mac mac = Mac.getInstance(HMAC_ALGORITHM);
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(CONTENT_CHARSET), mac.getAlgorithm());
			mac.init(secretKeySpec);

			byte[] hash = mac.doFinal(contextStr.getBytes(CONTENT_CHARSET));
			byte[] sigBuf = byteMerger(hash, contextStr.getBytes("utf8"));
			strSign = new String(new Base64().encode(sigBuf).getBytes());
			strSign = strSign.replace(" ", "").replace("\n", "").replace("\r", "");

		} catch (Exception e) {
			logger.error("生成上传文件签名出现异常，异常信息为：", e);
			throw e;
		}
		return Result.newSuccessResult(strSign);

	}

	public static byte[] byteMerger(byte[] byte1, byte[] byte2) {
		byte[] byte3 = new byte[byte1.length + byte2.length];
		System.arraycopy(byte1, 0, byte3, 0, byte1.length);
		System.arraycopy(byte2, 0, byte3, byte1.length, byte2.length);
		return byte3;
	}

	@Override
	public Result<Long> addSimple(VideoAddReqDto reqDto) throws BaseException {
		if (StringUtils.isBlank(reqDto.getFileId())) {
			throw new BaseException(Code1200000.CODE_1200173);
		}
		// 删除已经存在的fileId的数据
		Long resultId = null;
		BaseVideoExample example = new BaseVideoExample();
		example.createCriteria().andRefIdEqualTo(reqDto.getFileId());
		BaseVideo baseVideo = baseVideoMapper.selectOne(example);
		if (baseVideo == null) {
			BaseVideo model = new BaseVideo();
			model.setCreateDate(new Date());
			model.setCreateUserId(super.getHeaderUserId());
			model.setId(null);
			model.setTenantId(this.getHeaderTenantId());
			model.setRefId(reqDto.getFileId());
			model.setName(reqDto.getName());
			model.setSize(reqDto.getSize());
			model.setSourceUrl(reqDto.getSourceUrl());
			model.setCategory(reqDto.getCategory());
			model.setStatus(VideoStatusEnum.TRANSCODING.getValue());
			int count = baseVideoMapper.insertSelective(model);// 添加视频信息|
			resultId = model.getId();

			// 调用scm添加文件ID与租户的映射关系
			Map<String, Object> methodParams = new HashMap<String, Object>();
			methodParams.put("refFileId", reqDto.getFileId());
			methodParams.put("type", reqDto.getCategory());
			HttpUtils.post(ScmUrlConstant.VIDEO_TENANT_ADD, methodParams, new BaseTypeReference<Result<Long>>() {
			});
		} else {
			logger.info("文件ID：" + reqDto.getFileId() + "已经存在，不能重复添加，请核对！");
		}

		return Result.newSuccessResult(resultId);

	}

	private boolean doTranscodeFile(String fileId) throws Exception {
		logger.info("腾讯云文件ID为：" + fileId + ",转码后，进行本地同步操作开始");

		VideoDetailDto videoDetailDto = tencentService.getInfo(fileId);// 调用腾讯云获取文件信息
		if (videoDetailDto == null || videoDetailDto.getCode() == null || videoDetailDto.getCode() != 0) {
			logger.info("腾讯云文件ID为：" + fileId + ",获取不到腾讯云数据");
			return false;
		}

		BaseVideoExample example = new BaseVideoExample();
		example.createCriteria().andRefIdEqualTo(fileId);
		BaseVideo baseVideo = baseVideoMapper.selectOne(example);

		if (baseVideo == null) {
			logger.info("腾讯云文件ID为：" + fileId + ",本地找不到相关的视频信息");
			return false;
		}
		BaseVideo updateVideo = new BaseVideo();
		// 是否已经转码
		boolean isTranscode = false;

		if (videoDetailDto != null) {
			VideoBasicInfo basicInfo = videoDetailDto.getBasicInfo();
			if (basicInfo != null) {
				if (StringUtils.isNotBlank(basicInfo.getName())) {
					updateVideo.setFileName(basicInfo.getName());
				}
				if (StringUtils.isNotBlank(basicInfo.getType())) {
					updateVideo.setType(basicInfo.getType());
				}
				if (StringUtils.isNotBlank(basicInfo.getCoverUrl())) {
					updateVideo.setCoverUrl(basicInfo.getCoverUrl());
				}
				if (StringUtils.isNotBlank(basicInfo.getSourceVideoUrl())) {
					updateVideo.setSourceUrl(basicInfo.getSourceVideoUrl());
				}
				if (basicInfo.getDuration() != null && basicInfo.getDuration() > 0) {
					updateVideo.setDuration(basicInfo.getDuration());// 修改文件时长
				}
				if (StringUtils.isNotBlank(basicInfo.getSize())) {
					updateVideo.setSize(NumberUtils.toLong(basicInfo.getSize()));
				}
			} else {
				VideoMetaData metaData = videoDetailDto.getMetaData();
				if (metaData != null) {
					updateVideo.setDuration(metaData.getDuration());// 修改文件时长
				}
			}

			VideoTransCodeInfo transCodeInfo = videoDetailDto.getTranscodeInfo();
			if (transCodeInfo != null) {
				List<TransCode> transCodes = transCodeInfo.getTranscodeList();
				if (transCodes != null && !transCodes.isEmpty()) {

					// 删除历史转码记录
					BaseVideoTranscodeExample transcodeExample = new BaseVideoTranscodeExample();
					transcodeExample.createCriteria().andVideoIdEqualTo(baseVideo.getId());
					baseVideoTranscodeMapper.deleteByExample(transcodeExample);

					for (TransCode transCode : transCodes) {
						if (transCode.getDefinition() != null && NumberUtils
								.toInt(transCode.getDefinition()) == VideoDefinitionEnum.SOURCE.getValue()) {
							// 为0代表原文件
							continue;
						}
						BaseVideoTranscode transcodeModel = new BaseVideoTranscode();

						transcodeModel.setTenantId(this.getHeaderTenantId());
						transcodeModel.setVideoId(baseVideo.getId());
						transcodeModel.setSize(NumberUtils.toLong(transCode.getSize()));
						transcodeModel.setDefinition(NumberUtils.toInt(transCode.getDefinition()));
						transcodeModel.setMd5(transCode.getMd5());
						String url = transCode.getUrl();
						if (StringUtils.isNotBlank(url)) {
							int index_ = url.lastIndexOf(".");
							if (index_ != -1) {
								transcodeModel.setType(url.substring(index_ + 1));
							}
							transcodeModel.setUrl(url);
						}
						baseVideoTranscodeMapper.insertSelective(transcodeModel);// 添加视频转码后的视频信息
					}

					isTranscode = true;
				}
			}

		}
		if (isTranscode) {
			updateVideo.setStatus(VideoStatusEnum.NORMAL.getValue());// 修改文件转码状态
		}
		baseVideoMapper.updateByExampleSelective(updateVideo, example);
		logger.info("腾讯云文件ID为：" + fileId + ",转码后，进行本地同步操作结束");
		return isTranscode;
	}

	private Long addFile(String fileId) throws Exception {
		logger.info("腾讯云文件ID为：" + fileId + ",本地入库开始");
		// 调用腾讯云接口获取视频信息
		VideoDetailDto videoDetailDto = tencentService.getInfo(fileId);

		if (videoDetailDto == null || videoDetailDto.getCode() == null || videoDetailDto.getCode() != 0) {
			return null;
		}

		VideoBasicInfo basicInfo = videoDetailDto.getBasicInfo();
		VideoMetaData metaData = videoDetailDto.getMetaData();
		VideoTransCodeInfo transCodeInfo = videoDetailDto.getTranscodeInfo();

		BaseVideoExample example = new BaseVideoExample();
		example.createCriteria().andRefIdEqualTo(fileId);
		BaseVideo baseVideo = baseVideoMapper.selectOne(example);

		if (baseVideo == null) {
			logger.info("腾讯云同步文件，文件ID为：" + fileId + ",在当前租户查询不到数据，请核对！");
			return null;

		}
		if (baseVideo != null) {
			if (basicInfo != null) {
				baseVideo.setFileName(basicInfo.getName());
				baseVideo.setType(basicInfo.getType());
				baseVideo.setStatus(VideoStatusEnum.TRANSCODING.getValue());// 默认为0
				// 代表转码中
				baseVideo.setSize(
						StringUtils.isBlank(basicInfo.getSize()) ? 0 : NumberUtils.toLong(basicInfo.getSize()));
				baseVideo.setCoverUrl(basicInfo.getCoverUrl());
				baseVideo.setSourceUrl(basicInfo.getSourceVideoUrl());
				baseVideo.setDescription(basicInfo.getDescription());
				if (basicInfo.getDuration() != null && basicInfo.getDuration() > 0) {
					baseVideo.setDuration(metaData.getDuration());
				}
			}
			if (metaData != null && (baseVideo.getDuration() == null || baseVideo.getDuration() == 0)) {
				baseVideo.setDuration(metaData.getDuration());
			}

			int count = baseVideoMapper.updateByPrimaryKeySelective(baseVideo);// 修改视频信息
		}

		boolean isTranscode = false;// 判断该视频是否已经转码

		if (transCodeInfo != null) {

			List<TransCode> transCodes = transCodeInfo.getTranscodeList();
			if (transCodes != null && !transCodes.isEmpty()) {
				// 硬删除历史转码记录
				BaseVideoTranscodeExample transcodeExample = new BaseVideoTranscodeExample();
				transcodeExample.createCriteria().andVideoIdEqualTo(baseVideo.getId());
				baseVideoTranscodeMapper.deleteByExample(transcodeExample);

				for (TransCode transCode : transCodes) {
					if (transCode.getDefinition() != null
							&& NumberUtils.toInt(transCode.getDefinition()) == VideoDefinitionEnum.SOURCE.getValue()) {
						// 为0代表原文件
						continue;
					}
					BaseVideoTranscode transcodeModel = new BaseVideoTranscode();

					transcodeModel.setTenantId(this.getHeaderTenantId());
					transcodeModel.setVideoId(baseVideo.getId());
					transcodeModel.setSize(NumberUtils.toLong(transCode.getSize()));
					transcodeModel.setDefinition(NumberUtils.toInt(transCode.getDefinition()));
					transcodeModel.setMd5(transCode.getMd5());
					String url = transCode.getUrl();
					if (StringUtils.isNotBlank(url)) {
						int index_ = url.lastIndexOf(".");
						if (index_ != -1) {
							transcodeModel.setType(url.substring(index_ + 1));
						}
						transcodeModel.setUrl(url);
					}
					baseVideoTranscodeMapper.insertSelective(transcodeModel);// 添加视频转码后的视频信息

					isTranscode = true;
				}
			}
		}
		if (isTranscode) {
			logger.info("开始修改视频状态为转码成功");
			BaseVideo updateStatus = new BaseVideo();
			// 修改视频状态为已转码
			updateStatus.setId(baseVideo.getId());
			updateStatus.setStatus(VideoStatusEnum.NORMAL.getValue());
			int count = baseVideoMapper.updateByPrimaryKeySelective(updateStatus);// 修改视频信息
		} else {
			// 调用腾讯云进行转码处理
			tencentService.convertVodFile(fileId);
		}
		logger.info("腾讯云文件ID为：" + fileId + ",本地入库结束");
		return baseVideo.getId();
	}

	public Result<Long> update(VideoUpdateReqDto reqDto) throws Exception {
		if (reqDto.getId() == null) {
			throw new BaseException(Code1200000.CODE_1200173);
		}

		BaseVideo model = new BaseVideo();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseVideoMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(model.getId());
	}

	public Result<PermissionResultDto> delete(String ids) throws BaseException {
		if (StringUtils.isBlank(ids)) {
			throw new BaseException(Code1200000.CODE_1200173);
		}
		PermissionResultDto permissionResultDto = new PermissionResultDto();

		String[] idArr = ids.split(",");
		List<Long> deleteIdList = new ArrayList<>();
		for (int i = 0; i < idArr.length; i++) {
			BaseVideo baseVideo = baseVideoMapper.selectByPrimaryKey(NumberUtils.toLong(idArr[i]));
			if (baseVideo == null) {
				FailListDto fail = new FailListDto();
				fail.setId(NumberUtils.toLong(idArr[i]));
				fail.setName("");
				fail.setCode(Code1200000.CODE_1200187);
				permissionResultDto.getFailList().add(fail);
				continue;
			}
			// 查询是否关联路演，如果有关联则不能删除
			BaseRoadshowExample roadshowExample = new BaseRoadshowExample();
			roadshowExample.createCriteria().andVideoIdEqualTo(baseVideo.getId());
			BaseRoadshow baseRoadshow = baseRoadshowMapper.selectOne(roadshowExample);
			if (baseRoadshow != null) {
				FailListDto fail = new FailListDto();
				fail.setId(baseVideo.getId());
				fail.setName(baseVideo.getName());
				fail.setCode(Code1200000.CODE_1200186);
				permissionResultDto.getFailList().add(fail);
				continue;
			}
			PassListDto pass = new PassListDto();
			pass.setId(baseVideo.getId());
			pass.setName(baseVideo.getName());
			permissionResultDto.getPassList().add(pass);

			deleteIdList.add(baseVideo.getId());
		}
		if (!permissionResultDto.isSuccess()) {
			return Result.newSuccessResult(permissionResultDto);
		}

		// 删除本地数据
		BaseVideoTranscodeExample transcodeExample = new BaseVideoTranscodeExample();
		transcodeExample.createCriteria().andVideoIdIn(deleteIdList);
		BaseVideoTranscode updateTranscode = new BaseVideoTranscode();
		updateTranscode.setIsDelete(DeleteEnum.DELETED.getValue());
		super.updateModel(updateTranscode);
		baseVideoTranscodeMapper.updateByExampleSelective(updateTranscode, transcodeExample);// 删除转码信息

		BaseVideoExample example = new BaseVideoExample();
		example.createCriteria().andIdIn(deleteIdList);

		BaseVideo updateVideo = new BaseVideo();
		updateVideo.setIsDelete(DeleteEnum.DELETED.getValue());
		super.updateModel(updateVideo);
		int count = baseVideoMapper.updateByExampleSelective(updateVideo, example);// 删除视频信息

		// 删除腾讯云文件信息
		List<Long> idList = new ArrayList<>();
		List<Long> errorList = new ArrayList<>();
		for (int i = 0; i < idArr.length; i++) {

			BaseVideo baseVideo = baseVideoMapper.selectByPrimaryKey(NumberUtils.toLong(idArr[i]));

			try {
				VodBaseDto result = tencentService.delete(baseVideo.getRefId());
				if (result.getCode() != null && result.getCode() == 0) {
					// 代表调用腾讯云删除成功
					idList.add(NumberUtils.toLong(idArr[i]));
				} else {
					errorList.add(NumberUtils.toLong(idArr[i]));
					logger.info("本地视频ID为：" + idArr[i] + ",腾讯云文件ID为：" + baseVideo.getRefId() + ",调用腾讯云删除文件失败，失败信息为："
							+ JsonUtils.objectToJson(result));
				}
			} catch (Exception e) {
				logger.error("调用腾讯云删除文件出现异常，异常信息为：", e);
				errorList.add(NumberUtils.toLong(idArr[i]));
			}

		}

		if (idList.isEmpty()) {
			logger.info("视频IDs为：" + idArr.toString() + "腾讯云删除文件失败，请核对！");
		}
		if (!errorList.isEmpty()) {

			BaseVideoExample errorExample = new BaseVideoExample();
			errorExample.createCriteria().andIdIn(errorList);

			BaseVideo errorUpdateVideo = new BaseVideo();
			errorUpdateVideo.setIsDelete(DeleteEnum.REMOTE_UN_DELETE.getValue());
			super.updateModel(updateVideo);
			baseVideoMapper.updateByExampleSelective(updateVideo, example);// 删除视频信息
		}
		logger.info("腾讯文件删除成功：" + idList.size() + ",删除失败：" + errorList.size() + ",本地成功删除条数：" + count);

		if (count > 0) {
			return Result.newSuccessResult(null);
		}
		return Result.newFailureResult();
	}

	@Override
	public Result<VideoDetailDto> getTencentDate(String fileId) throws Exception {
		VideoDetailDto detailDto = tencentService.getInfo(fileId);
		return Result.newSuccessResult(detailDto);

	}

	@Override
	public void clearEventDate() throws Exception {
		tencentService.clearPullEvent();
	}

	public Result<VideoDto> get(Long id) throws BaseException {
		BaseVideo model = baseVideoMapper.selectByPrimaryKey(id);
		if (model == null) {
			return Result.newSuccessResult(null);
		}
		VideoDto dto = new VideoDto();
		BeanUtils.copyProperties(model, dto);
		if (dto.getStatus() != null) {
			VideoStatusEnum statusEnum = VideoStatusEnum.getEnum(dto.getStatus());
			if (statusEnum != null) {
				dto.setStatusText(statusEnum.getName());
			}
		}
		if (dto.getCreateUserId() != null) {
			dto.setCreateUserName(userDetailService.getUserRealName(dto.getCreateUserId()));
		}
		BaseVideoTranscodeExample example = new BaseVideoTranscodeExample();
		example.createCriteria().andVideoIdEqualTo(model.getId());
		List<BaseVideoTranscode> baseVideoTranscodes = baseVideoTranscodeMapper.selectByExample(example);
		if (baseVideoTranscodes != null && !baseVideoTranscodes.isEmpty()) {
			dto.setBaseVideoTranscodes(baseVideoTranscodes);
		}

		return Result.newSuccessResult(dto);
	}

	@Override
	public Result<BaseVideo> getByFileId(String fileId) throws Exception {
		BaseVideoExample example = new BaseVideoExample();
		example.createCriteria().andRefIdEqualTo(fileId);
		BaseVideo baseVideo = baseVideoMapper.selectOne(example);
		return Result.newSuccessResult(baseVideo);

	}

	public Result<PaginationSupport<VideoDto>> getPage(VideoReqDto videoReqDto) throws Exception {
		if (StringUtils.isBlank(videoReqDto.getOrderColumn())) {
			videoReqDto.setOrderColumn("createDate");
			videoReqDto.setSort("desc");// 默认列表按创建时间倒序
		}
		List<BaseVideo> list = videoMapper.selectPage(videoReqDto);
		int totalCount = videoMapper.selectCount(videoReqDto);
		List<VideoDto> videoDtos = new ArrayList<>();
		if (list != null && !list.isEmpty()) {
			list.forEach((v) -> {
				VideoDto dto = new VideoDto();
				BeanUtils.copyProperties(v, dto);
				if (v.getStatus() != null) {
					dto.setStatusText(VideoStatusEnum.getEnum(v.getStatus()) == null ? ""
							: VideoStatusEnum.getEnum(v.getStatus()).getName());
				}
				if (v.getCreateUserId() != null) {
					dto.setCreateUserName(userDetailService.getUserRealName(v.getCreateUserId()));
				}
				videoDtos.add(dto);
			});
		}
		PaginationSupport<VideoDto> result = videoReqDto.getPaginationSupport();
		result.setDatas(videoDtos);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	@Override
	public Result<List<VideoDto>> getsByName(VideoQueryDto queryDto) throws Exception {
		VideoReqDto videoReqDto = new VideoReqDto();
		BeanUtils.copyProperties(queryDto, videoReqDto);
		videoReqDto.setPageSize(Integer.MAX_VALUE);
		videoReqDto.setCurrentPage(1);
		List<BaseVideo> list = videoMapper.selectPage(videoReqDto);
		List<VideoDto> videoDtos = new ArrayList<>();
		if (list != null && !list.isEmpty()) {
			list.forEach((v) -> {
				VideoDto dto = new VideoDto();
				BeanUtils.copyProperties(v, dto);
				if (v.getStatus() != null) {
					dto.setStatusText(VideoStatusEnum.getEnum(v.getStatus()) == null ? ""
							: VideoStatusEnum.getEnum(v.getStatus()).getName());
				}
				if (v.getCreateUserId() != null) {
					dto.setCreateUserName(userDetailService.getUserRealName(v.getCreateUserId()));
				}
				videoDtos.add(dto);
			});
		}
		return Result.newSuccessResult(videoDtos);

	}

	@Override
	public List<VideoDto> getVideoList(List<Long> videoIds) throws BaseException {
		if (BooleanUtils.isEmpty(videoIds)) {
			return null;
		}
		List<VideoDto> list = new ArrayList<VideoDto>();
		for (Long id : videoIds) {
			VideoDto videoDto = get(id).getResult();
			if (videoDto != null) {
				list.add(videoDto);
			}

		}
		return list;
	}

	/**
	 * 通过文件id 查询视频信息
	 */
	public List<BaseVideo> getBaseVideos(List<String> fieldIds) throws BaseException {
		if (BooleanUtils.isEmpty(fieldIds)) {
			return null;
		}

		BaseVideoExample example = new BaseVideoExample();
		example.createCriteria().andRefIdIn(fieldIds);
		return baseVideoMapper.selectByExample(example);
	}
}
