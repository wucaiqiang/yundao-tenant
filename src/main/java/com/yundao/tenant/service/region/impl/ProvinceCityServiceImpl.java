package com.yundao.tenant.service.region.impl;

import com.yundao.core.cache.redis.JedisUtils;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.cache.CacheKey;
import com.yundao.tenant.dto.area.RegionDto;
import com.yundao.tenant.mapper.base.BaseDictionaryMapper;
import com.yundao.tenant.model.base.BaseDictionary;
import com.yundao.tenant.model.base.BaseDictionaryExample;
import com.yundao.tenant.service.region.ProvinceCityService;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 省市服务服务实现
 *
 * @author jan
 * @create 2017-08-20 PM3:54
 **/
@Service
public class ProvinceCityServiceImpl implements ProvinceCityService {

    private static Log log = LogFactory.getLog(ProvinceCityServiceImpl.class);

    String CACHE_KEY = CacheKey.SYS_CODE + "com.yundao.tenant.service.region.impl.ProvinceCityServiceImpl.gets[1]";

    @Autowired
    private BaseDictionaryMapper baseDictionaryMapper;

    @Override
    public List<RegionDto> gets(Long tenantId) throws BaseException {
        return this.doGet(tenantId);
    }

    @Override
    public List<RegionDto> reload(Long tenantId) throws BaseException {
        JedisUtils.remove(CACHE_KEY);
        return this.doGet(tenantId);
    }


    private List<RegionDto> doGet(Long tenantId) throws BaseException {
        log.begin(tenantId);

        Object object = JedisUtils.getObject(CACHE_KEY);
        if (object != null)
            return (List<RegionDto>) object;
        log.info("从DB获取");
        ArrayList<BaseDictionary> areas = new ArrayList<>();
        BaseDictionaryExample example = new BaseDictionaryExample();
        example.createCriteria().andValueEqualTo("dic_area");
        //国家
        BaseDictionary china = baseDictionaryMapper.selectOne(example);
        areas.add(china);

        //省份
        example = new BaseDictionaryExample();
        example.createCriteria().andParentIdEqualTo(china.getId());
        List<BaseDictionary> provinces = baseDictionaryMapper.selectByExample(example);
        areas.addAll(provinces);

        //城市
        example = new BaseDictionaryExample();
        example.createCriteria().andParentIdIn(LambdaMap.toSingleList(provinces, BaseDictionary::getId));
        List<BaseDictionary> cities = baseDictionaryMapper.selectByExample(example);
        areas.addAll(cities);

        List<RegionDto> dtos = new ArrayList<>(areas.size());
        for (BaseDictionary area : areas) {
            RegionDto dto = new RegionDto();
            dto.setId(area.getId());
            dto.setLabel(area.getLabel());
            dto.setValue(area.getValue());
            dtos.add(dto);
        }
        JedisUtils.setObject(CACHE_KEY, dtos);
        log.end();
        return dtos;
    }
}
