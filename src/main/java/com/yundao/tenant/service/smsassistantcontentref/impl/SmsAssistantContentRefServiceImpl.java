package com.yundao.tenant.service.smsassistantcontentref.impl;

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
import com.yundao.tenant.dto.smsassistantcontentref.SmsAssistantContentRefReqDto;
import com.yundao.tenant.mapper.base.BaseSmsAssistantContentRefMapper;
import com.yundao.tenant.model.base.BaseSmsAssistantContentRef;
import com.yundao.tenant.model.base.BaseSmsAssistantContentRefExample;
import com.yundao.tenant.service.smsassistantcontentref.SmsAssistantContentRefService;

@Service
public class SmsAssistantContentRefServiceImpl extends AbstractService implements SmsAssistantContentRefService{

    @Autowired
    private BaseSmsAssistantContentRefMapper baseSmsAssistantContentRefMapper;
    public Result<Integer> add(SmsAssistantContentRefReqDto reqDto) throws Exception{
        BaseSmsAssistantContentRef model = new BaseSmsAssistantContentRef();
        BeanUtils.copyProperties(reqDto,model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseSmsAssistantContentRefMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(SmsAssistantContentRefReqDto reqDto) throws Exception{
        BaseSmsAssistantContentRef model = new BaseSmsAssistantContentRef();
        BeanUtils.copyProperties(reqDto,model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseSmsAssistantContentRefMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseSmsAssistantContentRef smsAssistantContentRef = new BaseSmsAssistantContentRef();
        smsAssistantContentRef.setId(id);
        smsAssistantContentRef.setUpdateDate(new Date());
        smsAssistantContentRef.setUpdateUserId(super.getHeaderUserId());
        int count = baseSmsAssistantContentRefMapper.updateByPrimaryKeySelective(smsAssistantContentRef);
        return Result.newSuccessResult(count);
    }

    public Result<BaseSmsAssistantContentRef> get(Long id) throws Exception{
       BaseSmsAssistantContentRef model = baseSmsAssistantContentRefMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseSmsAssistantContentRef>> getPage(SmsAssistantContentRefReqDto smsAssistantContentRefReqDto, AbstractBasePageDto pageDto) throws Exception{
		BaseSmsAssistantContentRefExample baseSmsAssistantContentRefExample = new BaseSmsAssistantContentRefExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseSmsAssistantContentRefExample.Criteria criteria = baseSmsAssistantContentRefExample.createCriteria();
		String orderByClause="create_date desc";
		if(StringUtils.isNotBlank(pageDto.getOrderColumn())){
		  StringBuilder orderBuider=new StringBuilder();
		  orderBuider.append(pageDto.getOrderColumn()).append(" ");
		  if(StringUtils.isNotBlank(pageDto.getSort())){
			orderBuider.append(pageDto.getSort());
		  }else{
			orderBuider.append("desc");
		  }
		  orderByClause=orderBuider.toString();
		}
		baseSmsAssistantContentRefExample.setOrderByClause(orderByClause);
		List<BaseSmsAssistantContentRef> list = baseSmsAssistantContentRefMapper.selectByExample(baseSmsAssistantContentRefExample);
		int totalCount = baseSmsAssistantContentRefMapper.countByExample(baseSmsAssistantContentRefExample);
		PaginationSupport<BaseSmsAssistantContentRef> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

}
