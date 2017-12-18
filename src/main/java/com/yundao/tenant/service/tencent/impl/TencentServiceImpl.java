
package com.yundao.tenant.service.tencent.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.QcloudApiModuleCenter;
import com.qcloud.Module.Vod;
import com.yundao.core.code.Result;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.TencentConstant;
import com.yundao.tenant.dto.tencent.ClassAddDto;
import com.yundao.tenant.dto.tencent.EventMessageContentDateDto;
import com.yundao.tenant.dto.tencent.EventMessageContentDto;
import com.yundao.tenant.dto.tencent.EventMessageDto;
import com.yundao.tenant.dto.tencent.EventUploadFileDateDto;
import com.yundao.tenant.dto.tencent.VideoDetailDto;
import com.yundao.tenant.dto.tencent.VideoEventDto;
import com.yundao.tenant.dto.tencent.VodBaseDto;
import com.yundao.tenant.dto.tencent.VodTaskDto;
import com.yundao.tenant.model.base.video.BaseVideo;
import com.yundao.tenant.service.tencent.TencentService;
import com.yundao.tenant.service.video.VideoService;

/**
 * Function: Reason: Date: 2017年11月3日 下午3:15:54
 * 
 * @author wucq
 * @version
 */
@Service
public class TencentServiceImpl extends AbstractService implements TencentService {
	private Log logger = LogFactory.getLog(TencentServiceImpl.class);

	private QcloudApiModuleCenter moduleCenter = null;
	@Autowired
	private VideoService videoService;

	public TencentServiceImpl() {
		String SecretId = ConfigUtils.getValue("SecretId");
		String SecretKey = ConfigUtils.getValue("SecretKey");
		logger.info("SecretId:" + SecretId + ",SecretKey:" + SecretKey);
		TreeMap<String, Object> vodConfig = new TreeMap<String, Object>();
		vodConfig.put(TencentConstant.KEY_SECRET_ID, SecretId);
		vodConfig.put(TencentConstant.KEY_SECRET_KEY, SecretKey);
		vodConfig.put(TencentConstant.KEY_REQUEST_METHOD, "GET");
		moduleCenter = new QcloudApiModuleCenter(new Vod(), vodConfig);
	}

	@Override
	public void clearPullEvent() throws Exception {

		String response = moduleCenter.call(TencentConstant.MODULE_GET_PULL_EVENT, null);
		VideoEventDto result = JsonUtils.jsonToObject(response, VideoEventDto.class);
		logger.info("租户ID:" + this.getHeaderTenantId() + ",调用腾讯云获取事件通知信息为：" + JsonUtils.objectToJson(result));

		if (result != null) {
			List<EventMessageDto> eventMessageDtos = result.getEventList();
			if (eventMessageDtos != null && !eventMessageDtos.isEmpty()) {
				List<String> msgHandles = new ArrayList<>();
				for (EventMessageDto messageDto : eventMessageDtos) {
					msgHandles.add(messageDto.getMsgHandle());// 待确认的消息ID
					// 确认消息已消费
					this.confirmEvent(msgHandles);
				}
			}

		}
	}

	@Override
	public Map<String, List<String>> getPullEvent() throws Exception {

		Map<String, List<String>> resultMap = new HashMap<>();

		Set<String> transcodeFileIds = new HashSet<>();
		Set<String> uploadFileIds = new HashSet<>();

		String response = moduleCenter.call(TencentConstant.MODULE_GET_PULL_EVENT, null);

		VideoEventDto result = JsonUtils.jsonToObject(response, VideoEventDto.class);
		logger.info("租户ID" + this.getHeaderTenantId() + ",调用腾讯云获取事件通知信息为：" + JsonUtils.objectToJson(result));

		if (result != null) {
			List<EventMessageDto> eventMessageDtos = result.getEventList();
			if (eventMessageDtos != null && !eventMessageDtos.isEmpty()) {
				List<String> msgHandles = new ArrayList<>();
				for (EventMessageDto messageDto : eventMessageDtos) {
					EventMessageContentDto messageContentDto = messageDto.getEventContent();
					if (messageContentDto != null) {
						if (StringUtils.isNotBlank(messageContentDto.getEventType())
								&& (messageContentDto.getEventType().equals("TranscodeComplete")
										|| messageContentDto.getEventType().equals("NewFileUpload"))) {
							// 目前只处理视频转码类型的事件通知消息
							Object data = messageContentDto.getData();
							if (data == null) {
								continue;
							}
							String json = JsonUtils.objectToJson(data);

							//
							if (messageContentDto.getEventType().equals("TranscodeComplete")) {
								// 视频转码完成
								EventMessageContentDateDto contentDateDto = JsonUtils.jsonToObject(json,
										EventMessageContentDateDto.class);
								boolean canHandle = this.doCheckIsCancelHandle(contentDateDto.getFileId());// 判断是否有权限操作
								if (!canHandle) {
									continue;
								}
								transcodeFileIds.add(contentDateDto.getFileId());// 添加转码成功后的文件Id
								msgHandles.add(messageDto.getMsgHandle());// 待确认的消息ID
							} else if (messageContentDto.getEventType().equals("NewFileUpload")) {
								// 视频上传完成
								EventUploadFileDateDto fileDateDto = JsonUtils.jsonToObject(json,
										EventUploadFileDateDto.class);

								boolean canHandle = this.doCheckIsCancelHandle(fileDateDto.getFileId());// 判断是否有权限操作
								if (!canHandle) {
									continue;
								}
								uploadFileIds.add(fileDateDto.getFileId());// 添加转码成功后的文件Id
								msgHandles.add(messageDto.getMsgHandle());// 待确认的消息ID
							}
						} else {
							msgHandles.add(messageDto.getMsgHandle());// 待确认的消息ID
						}

					}
				}
				// 确认消息已消费
				this.confirmEvent(msgHandles);
			}
		}
		if (!transcodeFileIds.isEmpty()) {
			resultMap.put("transcode", new ArrayList<>(transcodeFileIds));
		}
		if (!uploadFileIds.isEmpty()) {
			resultMap.put("uploadFile", new ArrayList<>(uploadFileIds));
		}
		logger.info("事件通知待处理文件ID为：" + JsonUtils.objectToJson(resultMap));

		return resultMap;

	}

	private Map<String, Object> confirmEvent(List<String> msgHandles) throws Exception {
		if (msgHandles == null || msgHandles.isEmpty()) {
			return null;
		}
		logger.info("消息确认msgHandles为：" + JsonUtils.objectToJson(msgHandles));
		TreeMap<String, Object> params = new TreeMap<String, Object>();
		if (msgHandles != null && !msgHandles.isEmpty()) {
			for (int i = 0; i < msgHandles.size(); i++) {
				String msgHandleKey = "msgHandle." + i;
				params.put(msgHandleKey, msgHandles.get(i));
			}
		}
		Map<String, Object> result = null;
		String response = moduleCenter.call(TencentConstant.MODULE_CONFIRM_EVENT, params);
		result = JsonUtils.jsonToObject(response, Map.class);
		return result;
	}

	private boolean doCheckIsCancelHandle(String fileId) throws Exception {
		Result<BaseVideo> result = videoService.getByFileId(fileId);
		if (result.getResult() != null) {
			return true;
		}
		return false;
	}

	@Override
	public VideoDetailDto getInfo(String fileId) throws Exception {
		TreeMap<String, Object> params = new TreeMap<String, Object>();

		params.put(TencentConstant.KEY_FILEID, fileId);

		String response = moduleCenter.call(TencentConstant.MODULE_GET_VIDEO_INFO, params);

		VideoDetailDto result = JsonUtils.jsonToObject(response, VideoDetailDto.class);
		logger.info("调用产品云获取视频信息，视频ID为：" + fileId + ",数据：" + JsonUtils.objectToJson(result));
		return result;

	}

	@Override
	public VodTaskDto convertVodFile(String fileId) throws Exception {

		TreeMap<String, Object> params = new TreeMap<String, Object>();
		params.put(TencentConstant.KEY_FILEID, fileId);
		params.put(TencentConstant.KEY_IS_SCREEN_SHOT, 0);
		params.put(TencentConstant.KEY_IS_WATER_MARK, 0);

		String response = moduleCenter.call(TencentConstant.MODULE_CONVERT_VOD_FILE, params);

		VodTaskDto result = JsonUtils.jsonToObject(response, VodTaskDto.class);
		logger.info("调用产品云进行转码处理，视频ID为：" + fileId + ",返回数据：" + JsonUtils.objectToJson(result));
		return result;

	}

	@Override
	public VodBaseDto delete(String fileId) throws Exception {

		TreeMap<String, Object> params = new TreeMap<String, Object>();

		params.put(TencentConstant.KEY_FILEID, fileId);
		params.put(TencentConstant.KEY_IS_FLUSH_CDN, 1);
		params.put(TencentConstant.KEY_PRIORITY, 0);

		String response = moduleCenter.call(TencentConstant.MODULE_DELETE_VIDEO, params);

		VodBaseDto result = JsonUtils.jsonToObject(response, VideoDetailDto.class);
		logger.info("调用腾讯云删除视频文件，文件ID为：" + fileId + ",返回结果：" + JsonUtils.objectToJson(result));
		return result;

	}

	@Override
	public ClassAddDto addClass(String className) throws Exception {

		TreeMap<String, Object> params = new TreeMap<String, Object>();

		params.put(TencentConstant.KEY_CLASSID_NAME, className);

		String response = moduleCenter.call(TencentConstant.MODULE_GET_CREATE_CLASS, params);

		ClassAddDto result = JsonUtils.jsonToObject(response, ClassAddDto.class);

		return result;
	}

	@Override
	public VodBaseDto updateClass(Integer classId, String className) throws Exception {

		TreeMap<String, Object> params = new TreeMap<String, Object>();

		params.put(TencentConstant.KEY_CLASSID, classId);
		params.put(TencentConstant.KEY_CLASSID_NAME, className);

		String response = moduleCenter.call(TencentConstant.MODULE_GET_MODIFY_CLASS, params);

		VodBaseDto result = JsonUtils.jsonToObject(response, VodBaseDto.class);

		return result;

	}

}
