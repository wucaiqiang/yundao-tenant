package com.yundao.tenant.service.msg.msgtemplatetyperef.impl;

import java.util.List;
import java.util.Date;
import com.yundao.tenant.mapper.base.msg.BaseMsgTemplateTypeRefMapper;
import com.yundao.tenant.mapper.msg.msgtemplatetyperef.MsgTemplateTypeRefMapper;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeRef;
import com.yundao.tenant.service.msg.msgtemplatetyperef.MsgTemplateTypeRefService;
import com.yundao.tenant.dto.msg.msgtemplatetyperef.MsgTemplateTypeRefReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.constant.CommonConstant;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeRefExample;
import com.yundao.core.utils.Limit;
import com.yundao.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MsgTemplateTypeRefServiceImpl extends AbstractService implements MsgTemplateTypeRefService{

    @Autowired
    private BaseMsgTemplateTypeRefMapper baseMsgTemplateTypeRefMapper;

    @Autowired
    private MsgTemplateTypeRefMapper msgTemplateTypeRefMapper;

    public Result<Integer> add(MsgTemplateTypeRefReqDto reqDto) throws Exception{
        BaseMsgTemplateTypeRef model = new BaseMsgTemplateTypeRef();
        BeanUtils.copyProperties(reqDto,model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseMsgTemplateTypeRefMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(MsgTemplateTypeRefReqDto reqDto) throws Exception{
        BaseMsgTemplateTypeRef model = new BaseMsgTemplateTypeRef();
        BeanUtils.copyProperties(reqDto,model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseMsgTemplateTypeRefMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseMsgTemplateTypeRef msgTemplateTypeRef = new BaseMsgTemplateTypeRef();
        msgTemplateTypeRef.setId(id);
        msgTemplateTypeRef.setUpdateDate(new Date());
        msgTemplateTypeRef.setUpdateUserId(super.getHeaderUserId());
        int count = baseMsgTemplateTypeRefMapper.updateByPrimaryKeySelective(msgTemplateTypeRef);
        return Result.newSuccessResult(count);
    }

    public Result<BaseMsgTemplateTypeRef> get(Long id) throws Exception{
       BaseMsgTemplateTypeRef model = baseMsgTemplateTypeRefMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseMsgTemplateTypeRef>> getPage(MsgTemplateTypeRefReqDto msgTemplateTypeRefReqDto, AbstractBasePageDto pageDto) throws Exception{
		BaseMsgTemplateTypeRefExample baseMsgTemplateTypeRefExample = new BaseMsgTemplateTypeRefExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseMsgTemplateTypeRefExample.Criteria criteria = baseMsgTemplateTypeRefExample.createCriteria();
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
		baseMsgTemplateTypeRefExample.setOrderByClause(orderByClause);
		List<BaseMsgTemplateTypeRef> list = baseMsgTemplateTypeRefMapper.selectByExample(baseMsgTemplateTypeRefExample);
		int totalCount = baseMsgTemplateTypeRefMapper.countByExample(baseMsgTemplateTypeRefExample);
		PaginationSupport<BaseMsgTemplateTypeRef> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

}
