package com.yundao.tenant.service.region;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.area.RegionDto;

import java.util.List;

/**
 * 省市服务接口
 *
 * @author jan
 * @create 2017-08-20 PM3:53
 **/
public interface ProvinceCityService {


    /**
     * 获取省市数据
     *
     * @param tenantId 租户id
     */
    List<RegionDto> gets(Long tenantId) throws BaseException;

    /**
     * 重新加载数据
     *
     * @param tenantId 租户id
     */
    List<RegionDto> reload(Long tenantId) throws BaseException;

}
