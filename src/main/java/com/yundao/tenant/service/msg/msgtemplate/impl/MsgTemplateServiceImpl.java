package com.yundao.tenant.service.msg.msgtemplate.impl;

import java.util.List;
import java.util.Date;
import com.yundao.tenant.mapper.base.msg.BaseMsgTemplateMapper;
import com.yundao.tenant.mapper.msg.msgtemplate.MsgTemplateMapper;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.msg.BaseMsgTemplate;
import com.yundao.tenant.service.msg.msgtemplate.MsgTemplateService;
import com.yundao.tenant.dto.msg.msgtemplate.MsgTemplateReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.constant.CommonConstant;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateExample;
import com.yundao.core.utils.Limit;
import com.yundao.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MsgTemplateServiceImpl extends AbstractService implements MsgTemplateService{

    @Autowired
    private BaseMsgTemplateMapper baseMsgTemplateMapper;

    @Autowired
    private MsgTemplateMapper msgTemplateMapper;

    public Result<Integer> add(MsgTemplateReqDto reqDto) throws Exception{
        BaseMsgTemplate model = new BaseMsgTemplate();
        BeanUtils.copyProperties(reqDto,model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseMsgTemplateMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(MsgTemplateReqDto reqDto) throws Exception{
        BaseMsgTemplate model = new BaseMsgTemplate();
        BeanUtils.copyProperties(reqDto,model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseMsgTemplateMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseMsgTemplate msgTemplate = new BaseMsgTemplate();
        msgTemplate.setId(id);
        msgTemplate.setUpdateDate(new Date());
        msgTemplate.setUpdateUserId(super.getHeaderUserId());
        int count = baseMsgTemplateMapper.updateByPrimaryKeySelective(msgTemplate);
        return Result.newSuccessResult(count);
    }

    public Result<BaseMsgTemplate> get(Long id) throws Exception{
       BaseMsgTemplate model = baseMsgTemplateMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseMsgTemplate>> getPage(MsgTemplateReqDto msgTemplateReqDto, AbstractBasePageDto pageDto) throws Exception{
		BaseMsgTemplateExample baseMsgTemplateExample = new BaseMsgTemplateExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseMsgTemplateExample.Criteria criteria = baseMsgTemplateExample.createCriteria();
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
		baseMsgTemplateExample.setOrderByClause(orderByClause);
		List<BaseMsgTemplate> list = baseMsgTemplateMapper.selectByExample(baseMsgTemplateExample);
		int totalCount = baseMsgTemplateMapper.countByExample(baseMsgTemplateExample);
		PaginationSupport<BaseMsgTemplate> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

}
