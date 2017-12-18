package com.yundao.tenant.mapper.roadshow;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnReqDto;
import com.yundao.tenant.dto.roadshowcolumn.RoadshowColumnResDto;

/**
 * 文章
 *
 * @author jan
 * @create 2017-10-19 11:35
 **/
public interface RoadshowColumnMapper {
    /**
     * 获取分页
     */
    List<RoadshowColumnResDto> selectPage(RoadshowColumnReqDto reqDto) throws BaseException;
    int selectCount(RoadshowColumnReqDto reqDto) throws BaseException;
    List<RoadshowColumnResDto> selectListByNames(@Param("nameList") List<String> nameList) throws BaseException;
}
