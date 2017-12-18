package com.yundao.tenant.service.videotranscode.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.videotranscode.VideoTranscodeReqDto;
import com.yundao.tenant.mapper.base.video.BaseVideoTranscodeMapper;
import com.yundao.tenant.model.base.video.BaseVideoTranscode;
import com.yundao.tenant.model.base.video.BaseVideoTranscodeExample;
import com.yundao.tenant.service.videotranscode.VideoTranscodeService;

@Service
public class VideoTranscodeServiceImpl extends AbstractService implements VideoTranscodeService {

	@Autowired
	private BaseVideoTranscodeMapper baseVideoTranscodeMapper;

	public Result<Integer> add(VideoTranscodeReqDto reqDto) throws Exception {
		BaseVideoTranscode model = new BaseVideoTranscode();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setId(null);
		int count = baseVideoTranscodeMapper.insertSelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> update(VideoTranscodeReqDto reqDto) throws Exception {
		BaseVideoTranscode model = new BaseVideoTranscode();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseVideoTranscodeMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseVideoTranscode videoTranscode = new BaseVideoTranscode();
		videoTranscode.setId(id);
		videoTranscode.setUpdateDate(new Date());
		videoTranscode.setUpdateUserId(super.getHeaderUserId());
		int count = baseVideoTranscodeMapper.updateByPrimaryKeySelective(videoTranscode);
		return Result.newSuccessResult(count);
	}

	@Override
	public Result<List<BaseVideoTranscode>> getByVideoId(Long videoId) throws Exception {
		BaseVideoTranscodeExample example = new BaseVideoTranscodeExample();
		example.createCriteria().andVideoIdEqualTo(videoId);
		List<BaseVideoTranscode> transcodes = baseVideoTranscodeMapper.selectByExample(example);
		return Result.newSuccessResult(transcodes);

	}

	public Result<BaseVideoTranscode> get(Long id) throws Exception {
		BaseVideoTranscode model = baseVideoTranscodeMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(model);
	}

	public Result<PaginationSupport<BaseVideoTranscode>> getPage(VideoTranscodeReqDto videoTranscodeReqDto,
			AbstractBasePageDto pageDto) throws Exception {
		BaseVideoTranscodeExample baseVideoTranscodeExample = new BaseVideoTranscodeExample()
				.setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseVideoTranscodeExample.Criteria criteria = baseVideoTranscodeExample.createCriteria();
		String orderByClause = "create_date desc";
		if (StringUtils.isNotBlank(pageDto.getOrderColumn())) {
			StringBuilder orderBuider = new StringBuilder();
			orderBuider.append(pageDto.getOrderColumn()).append(" ");
			if (StringUtils.isNotBlank(pageDto.getSort())) {
				orderBuider.append(pageDto.getSort());
			} else {
				orderBuider.append("desc");
			}
			orderByClause = orderBuider.toString();
		}
		baseVideoTranscodeExample.setOrderByClause(orderByClause);
		List<BaseVideoTranscode> list = baseVideoTranscodeMapper.selectByExample(baseVideoTranscodeExample);
		int totalCount = baseVideoTranscodeMapper.countByExample(baseVideoTranscodeExample);
		PaginationSupport<BaseVideoTranscode> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

}
