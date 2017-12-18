package com.yundao.tenant.service.dictionary.impl;

import com.yundao.core.cache.redis.JedisUtils;
import com.yundao.core.dto.dictionary.DictionariesDto;
import com.yundao.core.enums.NumberEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.cache.CacheKey;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.dto.select.SelectConfigDto;
import com.yundao.tenant.mapper.base.BaseBusinessObjectMapper;
import com.yundao.tenant.mapper.base.BaseDictionaryMapper;
import com.yundao.tenant.mapper.base.BaseFieldGroupMapper;
import com.yundao.tenant.mapper.base.BaseFieldTypeMapper;
import com.yundao.tenant.model.base.*;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.select.SelectConfigService;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据字典服务实现类
 *
 * @author jan
 * @create 2017-07-16 AM11:35
 **/
@Service
public class DictionaryServiceImpl extends AbstractService implements DictionaryService {

    private static Log log = LogFactory.getLog(DictionaryServiceImpl.class);


    @Autowired
    private SelectConfigService selectConfigService;

    @Autowired
    private BaseFieldTypeMapper baseFieldTypeMapper;

    @Autowired
    private BaseFieldGroupMapper baseFieldGroupMapper;

    @Autowired
    private BaseBusinessObjectMapper baseBusinessObjectMapper;

    @Autowired
    private BaseDictionaryMapper baseDictionaryMapper;

    @Override
    public List<DictionariesDto> gets(String codes) throws BaseException {
        log.begin(codes);
        List<DictionariesDto> allDics = this.getFromCache();
        List<DictionariesDto> result = new ArrayList<>();
        List<String> codeList = SymbolStrUtils.toList(codes);
        for (String item : codeList) {
            DictionariesDto dic = null;
            for (DictionariesDto t : allDics) {
                if (item.equals(t.getValue())) {
                    dic = t;
                    break;
                }
            }

            if (dic != null)
                result.add(dic);
        }
        return result;
    }

    @Override
    public DictionariesDto get(String code, Integer number) throws BaseException {
        if (number == null)
            number = 0;
        List<DictionariesDto> DictionariesDtos = gets(code);
        if (DictionariesDtos == null || DictionariesDtos.isEmpty()) {
            return null;
        }
        return DictionariesDtos.get(0).getSelections().get(number);
    }

    @Override
    public String toText(String code, Integer value) throws BaseException {
        return this.toText(code, value != null ? value.toString() : null);
    }


    @Override
    public String toText(String code, String value) throws BaseException {
        if (BooleanUtils.isBlank(code) || BooleanUtils.isBlank(value)) {
            return null;
        }
        List<DictionariesDto> allDics = this.getFromCache();
        DictionariesDto dictionary = LambdaFilter.firstOrDefault(allDics, m -> code.equals(m.getValue()));
        if (dictionary == null) {
            log.info("dictionary 为空，code：%s", code);
            return null;
        }
        List<DictionariesDto> selections = dictionary.getSelections();
        DictionariesDto child = LambdaFilter.firstOrDefault(selections, m -> value.equals(m.getValue()));
        if (child == null)
            return null;
        return child.getLabel();
    }

    @Override
    public void reload() throws BaseException {
        log.info("重新加载数据字典缓存 开始");
        JedisUtils.remove(CacheKey.getDictionaries(super.getHeaderTenantId()));
        this.addToCache(super.getHeaderTenantId());
        log.info("重新加载数据字段缓存 成功");
    }


    /**
     * 从缓存获取
     */
    private List<DictionariesDto> getFromCache() throws BaseException {
        log.begin();
        Long tenantId = super.getHeaderTenantId();
        Object cacheObj = JedisUtils.getObject(CacheKey.getDictionaries(tenantId));
        if (cacheObj != null) {
            log.info("数据字典从缓存获取成功");
            return (List<DictionariesDto>) cacheObj;
        }
        return this.addToCache(tenantId);
    }

    /**
     * 加入缓存
     *
     * @param tenantId 租户id
     */
    private List<DictionariesDto> addToCache(Long tenantId) throws BaseException {
        List<DictionariesDto> DictionariesDtos = this.getFromDB();
        JedisUtils.setObject(CacheKey.getDictionaries(tenantId), DictionariesDtos);
        return DictionariesDtos;
    }

    /**
     * 从DB获取
     */
    private List<DictionariesDto> getFromDB() throws BaseException {
        log.info("从DB获取数据字典");
        List<DictionariesDto> DictionariesDtos = new ArrayList<>();
        DictionariesDtos.addAll(this.getSelectConfig());
        DictionariesDtos.addAll(this.getFieldType());
        DictionariesDtos.addAll(this.getFieldGroup());
        DictionariesDtos.addAll(this.getDictionary());
        return DictionariesDtos;
    }

    /**
     * 业务对象选项数据
     */
    private List<DictionariesDto> getSelectConfig() throws BaseException {
        log.begin();
        List<SelectConfigDto> selectConfigs = selectConfigService.gets();

        Map<String, List<SelectConfigDto>> map = selectConfigs.stream().collect(Collectors.groupingBy
                (SelectConfigDto::getObjectFieldCode));

        List<DictionariesDto> dtos = new ArrayList<>();
        for (Map.Entry<String, List<SelectConfigDto>> entry : map.entrySet()) {
            DictionariesDto parent = new DictionariesDto();
            parent.setValue(entry.getKey());
            for (SelectConfigDto dto : entry.getValue()) {
                DictionariesDto child = new DictionariesDto();
                child.setValue(dto.getValue().toString());
                child.setLabel(dto.getLabel());
                parent.getSelections().add(child);
            }
            dtos.add(parent);
        }
        log.end();
        return dtos;
    }

    /**
     * 业务对象字段类型
     */
    private List<DictionariesDto> getFieldType() throws BaseException {
        log.begin();
        BaseFieldTypeExample example = new BaseFieldTypeExample();
        example.createCriteria();
        List<BaseFieldType> fieldTypes = baseFieldTypeMapper.selectByExample(example);
        List<DictionariesDto> DictionariesDtos = new ArrayList<>();
        DictionariesDto dic = new DictionariesDto();
        dic.setValue(DicCode.FIELD_TYPE);
        for (BaseFieldType fieldType : fieldTypes) {
            DictionariesDto lvDto = new DictionariesDto();
            lvDto.setValue(fieldType.getId().toString());
            lvDto.setLabel(fieldType.getName());
            dic.getSelections().add(lvDto);
        }
        DictionariesDtos.add(dic);
        log.end();
        return DictionariesDtos;
    }

    /**
     * 字段分组
     */
    private List<DictionariesDto> getFieldGroup() throws BaseException {
        log.begin();
        //业务对象
        BaseBusinessObjectExample boExample = new BaseBusinessObjectExample();
        boExample.createCriteria();
        List<BaseBusinessObject> bos = baseBusinessObjectMapper.selectByExample(boExample);
        //字段分组
        BaseFieldGroupExample example = new BaseFieldGroupExample();
        example.createCriteria();
        List<BaseFieldGroup> fieldGroups = baseFieldGroupMapper.selectByExample(example);
        List<DictionariesDto> DictionariesDtos = new ArrayList<>();
        for (BaseBusinessObject bo : bos) {
            DictionariesDto dic = new DictionariesDto();
            dic.setValue(bo.getCode() + DicCode.BUSINESS_TYPE);
            List<BaseFieldGroup> groups = LambdaFilter.toList(fieldGroups, m -> bo.getId().equals(m.getBusinessObjectId
                    ()));
            if (BooleanUtils.isNotEmpty(groups)) {
                for (BaseFieldGroup group : groups) {
                    DictionariesDto lvDto = new DictionariesDto();
                    lvDto.setValue(group.getId().toString());
                    lvDto.setLabel(group.getName());
                    dic.getSelections().add(lvDto);
                }
            }
            DictionariesDtos.add(dic);
        }
        log.end();
        return DictionariesDtos;
    }

    private List<DictionariesDto> getDictionary() throws BaseException {
        log.begin();
        //TODO 需要优化
        BaseDictionaryExample example = new BaseDictionaryExample();
        example.createCriteria().andIdGreaterThan(90000L);
        List<BaseDictionary> dictionaries = baseDictionaryMapper.selectByExample(example);
        List<BaseDictionary> baseParents = LambdaFilter.toList(dictionaries, m -> m.getParentId().intValue() == NumberEnum.ZERO
                .getValue());
        List<DictionariesDto> parents = LocalBeanUtils.copyPropertiesList(baseParents, DictionariesDto.class);
        for (BaseDictionary dictionary : dictionaries) {
            if (dictionary.getParentId() > 0) {
                BaseDictionary baseParent = LambdaFilter.firstOrDefault(baseParents, m -> m.getId().equals(dictionary
                        .getParentId()));
                if (baseParent == null)
                    continue;
                DictionariesDto parent = LambdaFilter.firstOrDefault(parents, m -> m.getValue().equals(baseParent.getValue()));
                if (parent == null)
                    continue;
                DictionariesDto child = new DictionariesDto();
                child.setLabel(dictionary.getLabel());
                child.setValue(dictionary.getValue());
                child.setSequence(dictionary.getSequence() == null ? Integer.MAX_VALUE : dictionary.getSequence());
                parent.getSelections().add(child);
            }
        }

        this.sort(parents);

        return parents;
    }

    private void sort(List<DictionariesDto> parents) {
        for (DictionariesDto parent : parents) {
            List<DictionariesDto> childs = parent.getSelections();
            if (BooleanUtils.isEmpty(childs))
                continue;
            childs.sort(Comparator.comparing(DictionariesDto::getSequence));
            parent.setSelections(childs);
        }
    }
}
