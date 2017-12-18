package com.yundao.tenant.service.video;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.tencent.VideoDetailDto;
import com.yundao.tenant.dto.video.VideoAddReqDto;
import com.yundao.tenant.dto.video.VideoDto;
import com.yundao.tenant.dto.video.VideoQueryDto;
import com.yundao.tenant.dto.video.VideoReqDto;
import com.yundao.tenant.dto.video.VideoUpdateReqDto;
import com.yundao.tenant.model.base.video.BaseVideo;

public interface VideoService {

	public Result<Long> addSimple(VideoAddReqDto reqDto) throws BaseException;

	public Result<Long> update(VideoUpdateReqDto reqDto) throws Exception;

	public Result<PermissionResultDto> delete(String ids) throws BaseException;

	public Result<VideoDto> get(Long id) throws BaseException;

	public Result<VideoDetailDto> getTencentDate(String id) throws Exception;

	public void clearEventDate() throws Exception;

	public Result<BaseVideo> getByFileId(String fileId) throws Exception;

	public Result<String> doGetUploadSignature() throws Exception;

	public Result<Boolean> doGetTranscodeMsg() throws Exception;
	public Result<Boolean> doFileHandle(String fileHandleDtos) throws Exception;

	public Result<PermissionResultDto> doConvertVodFile(String ids) throws Exception;

	public Result<PaginationSupport<VideoDto>> getPage(VideoReqDto videoReqDto) throws Exception;

	public Result<List<VideoDto>> getsByName(VideoQueryDto queryDto) throws Exception;
	
	public List<VideoDto> getVideoList(List<Long> videoIds)throws BaseException;
	
	/**
	 * 通过文件id 查询视频信息
	 */
	public List<BaseVideo> getBaseVideos(List<String> fieldIds)throws BaseException;

}
