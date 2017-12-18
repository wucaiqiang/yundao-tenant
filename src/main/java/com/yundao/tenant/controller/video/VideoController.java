package com.yundao.tenant.controller.video;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.tencent.VideoDetailDto;
import com.yundao.tenant.dto.video.VideoAddReqDto;
import com.yundao.tenant.dto.video.VideoDto;
import com.yundao.tenant.dto.video.VideoQueryDto;
import com.yundao.tenant.dto.video.VideoReqDto;
import com.yundao.tenant.dto.video.VideoUpdateReqDto;
import com.yundao.tenant.enums.video.VideoCategoryEnum;
import com.yundao.tenant.service.video.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/video/")
@ResponseBody
@Api("视频管理")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@RequestMapping(value = "get_page", method = RequestMethod.GET)
	@ApiOperation(value = "分页查询视频信息")
	public Result<PaginationSupport<VideoDto>> getRoadshowPage(@ModelAttribute VideoReqDto dto) throws Exception {
		if (dto.getCategory() == null) {
			// 默认查询路演
			dto.setCategory(VideoCategoryEnum.ROADSHOW.getValue());
		}
		return videoService.getPage(dto);
	}

	@RequestMapping(value = "gets_by_name", method = RequestMethod.GET)
	@ApiOperation(value = "根据名称查询")
	public Result<List<VideoDto>> getsByName(@ModelAttribute VideoQueryDto queryDto) throws Exception {
		if (queryDto.getCategory() == null) {
			// 默认查询路演
			queryDto.setCategory(VideoCategoryEnum.ROADSHOW.getValue());
		}
		return videoService.getsByName(queryDto);
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "新增", notes = "根据Video对象创建")
	public Result<Long> add(@Validated @ModelAttribute VideoAddReqDto reqDto, BindingResult bindingResult)
			throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return videoService.addSimple(reqDto);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ApiOperation(value = "编辑信息")
	public Result<Long> update(@Validated @ModelAttribute VideoUpdateReqDto reqDto, BindingResult bindingResult)
			throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return videoService.update(reqDto);
	}

	@RequestMapping(value = "get_upload_signature", method = RequestMethod.GET)
	@ApiOperation(value = "请求上传文件签名")
	public Result<String> getUploadSignature() throws Exception {
		return videoService.doGetUploadSignature();
	}

	// @RequestMapping(value = "get_transcode_msg", method = RequestMethod.GET)
	// @ApiOperation(value = "获取腾讯云通知的消息,定时任务正则：0/20 * * * * ?")
	// public Result<Boolean> getTranscodeMsg() throws Exception {
	// return videoService.doGetTranscodeMsg();
	// }

	@RequestMapping(value = "file_handle", method = RequestMethod.POST)
	@ApiOperation(value = "文件处理")
	public Result<Boolean> fileHandle(@RequestParam String fileHandleDtos) throws Exception {
		if (StringUtils.isBlank(fileHandleDtos)) {
			throw new BaseException(Code1200000.CODE_1200177);
		}
		return videoService.doFileHandle(fileHandleDtos);
	}

	@RequestMapping(value = "convert", method = RequestMethod.POST)
	@ApiOperation(value = "获取腾讯云进行转码")
	public Result<PermissionResultDto> convertVodFile(@RequestParam String ids) throws Exception {
		return videoService.doConvertVodFile(ids);
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ApiOperation(value = "获取详细信息")
	public Result<VideoDto> get(@RequestParam Long id) throws Exception {
		return videoService.get(id);
	}

	@RequestMapping(value = "get_tencent_data", method = RequestMethod.GET)
	@ApiOperation(value = "调用腾讯云获取视频信息")
	public Result<VideoDetailDto> getTencentDate(@RequestParam String fileId) throws Exception {
		return videoService.getTencentDate(fileId);
	}

	@RequestMapping(value = "clear_event_data", method = RequestMethod.GET)
	@ApiOperation(value = "清空事件消息")
	public void clearEventDate() throws Exception {
		videoService.clearEventDate();
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ApiOperation(value = "批量删除信息")
	public Result<PermissionResultDto> delete(@RequestParam String ids) throws Exception {
		return videoService.delete(ids);
	}

}
