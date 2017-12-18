package com.yundao.tenant.service.msg.msgtemplatetype.impl;

import java.util.List;
import java.util.Date;
import com.yundao.tenant.mapper.base.msg.BaseMsgTemplateTypeMapper;
import com.yundao.tenant.mapper.msg.msgtemplatetype.MsgTemplateTypeMapper;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateType;
import com.yundao.tenant.service.msg.msgtemplatetype.MsgTemplateTypeService;
import com.yundao.tenant.dto.msg.msgtemplatetype.MsgTemplateTypeReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.constant.CommonConstant;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeExample;
import com.yundao.core.utils.Limit;
import com.yundao.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MsgTemplateTypeServiceImpl extends AbstractService implements MsgTemplateTypeService{

    @Autowired
    private BaseMsgTemplateTypeMapper baseMsgTemplateTypeMapper;

    @Autowired
    private MsgTemplateTypeMapper msgTemplateTypeMapper;

    public Result<Integer> add(MsgTemplateTypeReqDto reqDto) throws Exception{
        BaseMsgTemplateType model = new BaseMsgTemplateType();
        BeanUtils.copyProperties(reqDto,model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseMsgTemplateTypeMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(MsgTemplateTypeReqDto reqDto) throws Exception{
        BaseMsgTemplateType model = new BaseMsgTemplateType();
        BeanUtils.copyProperties(reqDto,model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseMsgTemplateTypeMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseMsgTemplateType msgTemplateType = new BaseMsgTemplateType();
        msgTemplateType.setId(id);
        msgTemplateType.setUpdateDate(new Date());
        msgTemplateType.setUpdateUserId(super.getHeaderUserId());
        int count = baseMsgTemplateTypeMapper.updateByPrimaryKeySelective(msgTemplateType);
        return Result.newSuccessResult(count);
    }

    public Result<BaseMsgTemplateType> get(Long id) throws Exception{
       BaseMsgTemplateType model = baseMsgTemplateTypeMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseMsgTemplateType>> getPage(MsgTemplateTypeReqDto msgTemplateTypeReqDto, AbstractBasePageDto pageDto) throws Exception{
		BaseMsgTemplateTypeExample baseMsgTemplateTypeExample = new BaseMsgTemplateTypeExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseMsgTemplateTypeExample.Criteria criteria = baseMsgTemplateTypeExample.createCriteria();
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
		baseMsgTemplateTypeExample.setOrderByClause(orderByClause);
		List<BaseMsgTemplateType> list = baseMsgTemplateTypeMapper.selectByExample(baseMsgTemplateTypeExample);
		int totalCount = baseMsgTemplateTypeMapper.countByExample(baseMsgTemplateTypeExample);
		PaginationSupport<BaseMsgTemplateType> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

}
