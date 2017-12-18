package com.yundao.tenant.service.msg.msgfeed.impl;

import java.util.*;

import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.TemplateUtils;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.msg.msgfeed.MsgFeedResDto;
import com.yundao.tenant.mapper.base.msg.BaseMsgFeedMapper;
import com.yundao.tenant.mapper.base.msg.BaseMsgTemplateMapper;
import com.yundao.tenant.mapper.msg.msgfeed.MsgFeedMapper;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.msg.BaseMsgFeed;
import com.yundao.tenant.model.base.msg.BaseMsgTemplate;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateExample;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.msg.msgfeed.MsgFeedService;
import com.yundao.tenant.dto.msg.msgfeed.MsgFeedReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.model.base.msg.BaseMsgFeedExample;
import com.yundao.core.utils.Limit;
import com.yundao.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MsgFeedServiceImpl extends AbstractService implements MsgFeedService{

    @Autowired
    private BaseMsgFeedMapper baseMsgFeedMapper;

    @Autowired
    private MsgFeedMapper msgFeedMapper;

    @Autowired
    private BaseMsgTemplateMapper baseMsgTemplateMapper;

    @Autowired
    private DictionaryService dictionaryService;

    public Result<Integer> add(MsgFeedReqDto reqDto) throws Exception{
        BaseMsgFeed model = new BaseMsgFeed();
        BeanUtils.copyProperties(reqDto,model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseMsgFeedMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(MsgFeedReqDto reqDto) throws Exception{
        BaseMsgFeed model = new BaseMsgFeed();
        BeanUtils.copyProperties(reqDto,model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseMsgFeedMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseMsgFeed msgFeed = new BaseMsgFeed();
        msgFeed.setId(id);
        msgFeed.setUpdateDate(new Date());
        msgFeed.setUpdateUserId(super.getHeaderUserId());
        int count = baseMsgFeedMapper.updateByPrimaryKeySelective(msgFeed);
        return Result.newSuccessResult(count);
    }

    public Result<BaseMsgFeed> get(Long id) throws Exception{
       BaseMsgFeed model = baseMsgFeedMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseMsgFeed>> getPage(MsgFeedReqDto msgFeedReqDto, AbstractBasePageDto pageDto) throws Exception{
		BaseMsgFeedExample baseMsgFeedExample = new BaseMsgFeedExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseMsgFeedExample.Criteria criteria = baseMsgFeedExample.createCriteria();
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
		baseMsgFeedExample.setOrderByClause(orderByClause);
		List<BaseMsgFeed> list = baseMsgFeedMapper.selectByExample(baseMsgFeedExample);
		int totalCount = baseMsgFeedMapper.countByExample(baseMsgFeedExample);
		PaginationSupport<BaseMsgFeed> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

    @Override
    public Result<PaginationSupport<MsgFeedResDto>> getCustomerPage(Long customerId,Integer firstType, BasePageDto pageDto) throws BaseException {
        BaseMsgFeedExample baseMsgFeedExample = new BaseMsgFeedExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
        BaseMsgFeedExample.Criteria criteria = baseMsgFeedExample.createCriteria();
        criteria.andCustomerIdEqualTo(customerId);
        if(firstType != null){
            criteria.andFirstTypeEqualTo(firstType);
        }
        String orderByClause="create_date desc,id desc ";
        baseMsgFeedExample.setOrderByClause(orderByClause);
        List<BaseMsgFeed> list = baseMsgFeedMapper.selectByExample(baseMsgFeedExample);
        int totalCount = baseMsgFeedMapper.countByExample(baseMsgFeedExample);
        PaginationSupport<MsgFeedResDto> result = pageDto.getPaginationSupport();
        result.setDatas(setFeedContent(list));
        result.setTotalCount(totalCount);
        return Result.newSuccessResult(result);
    }

    public List<MsgFeedResDto> setFeedContent(List<BaseMsgFeed> feeds) throws BaseException {
        if(feeds == null || feeds.isEmpty()){
            return null;
        }
        //获取所有的模板
        List<Long> templateIds = new ArrayList<>();
        feeds.forEach(m -> templateIds.add(m.getTemplateId()));
        BaseMsgTemplateExample templateExample = new BaseMsgTemplateExample();
        templateExample.createCriteria().andIdIn(templateIds);
        List<BaseMsgTemplate> msgFeeds = baseMsgTemplateMapper.selectByExample(templateExample);
        Map<Long,BaseMsgTemplate> templateMap = new HashMap<>();
        msgFeeds.forEach(m -> templateMap.put(m.getId(),m));
        List<MsgFeedResDto> result = new ArrayList<>();
        //封装模板的数据
        for (BaseMsgFeed feed : feeds) {
            MsgFeedResDto resDto = new MsgFeedResDto();
            BeanUtils.copyProperties(feed,resDto);
            Map<String,Object> params = JsonUtils.jsonToObject(feed.getParams(),Map.class);
            BaseMsgTemplate template = templateMap.get(feed.getTemplateId());
            if(BooleanUtils.isNotEmpty(template.getFeedContent())) {
                resDto.setFeedContent(TemplateUtils.parse(template.getFeedContent(), params));
            }
            if(BooleanUtils.isNotEmpty(template.getMessageContent())) {
                resDto.setMessageContent(TemplateUtils.parse(template.getMessageContent(), params));
            }
            if(BooleanUtils.isNotEmpty(template.getAppContent())) {
                resDto.setAppContent(TemplateUtils.parse(template.getAppContent(), params));
            }
            if(BooleanUtils.isNotEmpty(template.getIndexContent())) {
                resDto.setIndexContent(TemplateUtils.parse(template.getIndexContent(), params));
            }
            if(BooleanUtils.isNotEmpty(template.getAppAction())){
                resDto.setAppAction(TemplateUtils.parse(template.getAppAction(), params));
            }
            if(BooleanUtils.isNotEmpty(template.getPcAction())){
                resDto.setPcAction(TemplateUtils.parse(template.getPcAction(), params));
            }
            resDto.setTypeText(dictionaryService.toText(DicCode.MSG_FEED_TYPE,feed.getType() + com.yundao.tenant.constant.CommonConstant.BLANK));
            resDto.setTitle(template.getTitle());
            resDto.setRemark(template.getRemark());
            result.add(resDto);
        }
        return result;
    }
}
