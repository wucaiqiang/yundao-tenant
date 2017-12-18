package com.yundao.tenant.service.region.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.area.RegionDto;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.region.RegionService;
import com.yundao.tenant.util.lambda.LambdaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 区域服务实现
 *
 * @author jan
 * @create 2017-08-09 PM3:35
 **/
@Service
public class RegionServiceImpl extends AbstractService implements RegionService {

    @Autowired
    private ProvinceCityServiceImpl provinceCityService;

    @Override
    public String toText(String code) throws BaseException {
        if (BooleanUtils.isBlank(code)) {
            return null;
        }
        List<RegionDto> dtos = provinceCityService.gets(super.getHeaderTenantId());
        RegionDto area = LambdaFilter.firstOrDefault(dtos, m -> m.getValue().equals(code));
        if (area == null)
            return null;
        return area.getLabel();
    }

}
