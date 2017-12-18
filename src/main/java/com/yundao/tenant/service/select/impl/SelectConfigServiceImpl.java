package com.yundao.tenant.service.select.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.select.SelectConfigDto;
import com.yundao.tenant.mapper.base.BaseSelectConfigMapper;
import com.yundao.tenant.mapper.select.SelectConfigMapper;
import com.yundao.tenant.model.base.BaseSelectConfig;
import com.yundao.tenant.model.base.BaseSelectConfigExample;
import com.yundao.tenant.model.base.BaseSelectConfigExample.Criteria;
import com.yundao.tenant.service.select.SelectConfigService;


/**
 * @author jan
 * @create 2017-07-16 PM6:01
 **/
@Service
public class SelectConfigServiceImpl implements SelectConfigService {

    @Autowired
    private SelectConfigMapper selectConfigMapper;
    @Autowired
    private BaseSelectConfigMapper baseSelectConfigMapper;

    @Override
    public List<SelectConfigDto> gets() throws BaseException {
        return selectConfigMapper.selectList();
    }

	@Override
	public SelectConfigDto getByFieldCodeAndValue(String fieldCode, Integer value) throws BaseException {
		 List<SelectConfigDto> dtos=selectConfigMapper.selectByFieldCodeAndValue(fieldCode,value);
		 if(dtos !=null && !dtos.isEmpty()){
			 return dtos.get(0);
		 }
		return null;
		
	}

	@Override
	public BaseSelectConfig getByFieldIdAndValue(Long fieldId, Integer value) throws BaseException {
		BaseSelectConfigExample example=new BaseSelectConfigExample();
		Criteria criteria=example.createCriteria();
		criteria.andObjectFieldIdEqualTo(fieldId);
		criteria.andValueEqualTo(value);
		return baseSelectConfigMapper.selectOne(example);
		
		
	}

    
}
