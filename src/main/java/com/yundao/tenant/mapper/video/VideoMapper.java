package com.yundao.tenant.mapper.video;

import java.util.List;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.video.VideoReqDto;
import com.yundao.tenant.model.base.video.BaseVideo;

/**
 * 文章
 *
 * @author jan
 * @create 2017-10-19 11:35
 **/
public interface VideoMapper {
    /**
     * 获取分页
     */
    List<BaseVideo> selectPage(VideoReqDto reqDto) throws BaseException;
    int selectCount(VideoReqDto reqDto) throws BaseException;
}
