package com.yundao.tenant.service.videotranscode;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.videotranscode.VideoTranscodeReqDto;
import com.yundao.tenant.model.base.video.BaseVideoTranscode;

public interface VideoTranscodeService {

	public Result<Integer> add(VideoTranscodeReqDto reqDto) throws Exception;

	public Result<Integer> update(VideoTranscodeReqDto reqDto) throws Exception;

	public Result<Integer> delete(Long id) throws Exception;

	public Result<BaseVideoTranscode> get(Long id) throws Exception;

	public Result<List<BaseVideoTranscode>> getByVideoId(Long videoId) throws Exception;

	public Result<PaginationSupport<BaseVideoTranscode>> getPage(VideoTranscodeReqDto videoTranscodeReqDto,
			AbstractBasePageDto pageDto) throws Exception;

}
