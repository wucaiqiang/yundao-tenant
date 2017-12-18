package com.yundao.tenant.service.shareinfo.impl;

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
import com.yundao.tenant.dto.shareinfo.ShareInfoReqDto;
import com.yundao.tenant.mapper.base.BaseShareInfoMapper;
import com.yundao.tenant.model.base.BaseShareInfo;
import com.yundao.tenant.model.base.BaseShareInfoExample;
import com.yundao.tenant.service.shareinfo.ShareInfoService;

@Service
public class ShareInfoServiceImpl extends AbstractService implements ShareInfoService{

    @Autowired
    private BaseShareInfoMapper baseShareInfoMapper;
    
    public Result<Integer> add(ShareInfoReqDto reqDto) throws Exception{
        BaseShareInfo model = new BaseShareInfo();
        BeanUtils.copyProperties(reqDto,model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseShareInfoMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(ShareInfoReqDto reqDto) throws Exception{
        BaseShareInfo model = new BaseShareInfo();
        BeanUtils.copyProperties(reqDto,model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseShareInfoMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseShareInfo shareInfo = new BaseShareInfo();
        shareInfo.setId(id);
        shareInfo.setUpdateDate(new Date());
        shareInfo.setUpdateUserId(super.getHeaderUserId());
        int count = baseShareInfoMapper.updateByPrimaryKeySelective(shareInfo);
        return Result.newSuccessResult(count);
    }

    public Result<BaseShareInfo> get(Long id) throws Exception{
       BaseShareInfo model = baseShareInfoMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseShareInfo>> getPage(ShareInfoReqDto shareInfoReqDto, AbstractBasePageDto pageDto) throws Exception{
		BaseShareInfoExample baseShareInfoExample = new BaseShareInfoExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseShareInfoExample.Criteria criteria = baseShareInfoExample.createCriteria();
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
		baseShareInfoExample.setOrderByClause(orderByClause);
		List<BaseShareInfo> list = baseShareInfoMapper.selectByExample(baseShareInfoExample);
		int totalCount = baseShareInfoMapper.countByExample(baseShareInfoExample);
		PaginationSupport<BaseShareInfo> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

}
