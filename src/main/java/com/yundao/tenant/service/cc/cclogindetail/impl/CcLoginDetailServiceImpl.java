package com.yundao.tenant.service.cc.cclogindetail.impl;

import java.util.List;
import java.util.Date;
import com.yundao.tenant.mapper.base.cc.BaseCcLoginDetailMapper;
import com.yundao.tenant.mapper.cc.cclogindetail.CcLoginDetailMapper;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.cc.BaseCcLoginDetail;
import com.yundao.tenant.service.cc.cclogindetail.CcLoginDetailService;
import com.yundao.tenant.dto.cc.cclogindetail.CcLoginDetailReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.constant.CommonConstant;
import com.yundao.tenant.model.base.cc.BaseCcLoginDetailExample;
import com.yundao.core.utils.Limit;
import com.yundao.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CcLoginDetailServiceImpl extends AbstractService implements CcLoginDetailService{

    @Autowired
    private BaseCcLoginDetailMapper baseCcLoginDetailMapper;

    @Autowired
    private CcLoginDetailMapper ccLoginDetailMapper;

    public Result<Integer> add(CcLoginDetailReqDto reqDto) throws Exception{
        BaseCcLoginDetail model = new BaseCcLoginDetail();
        BeanUtils.copyProperties(reqDto,model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseCcLoginDetailMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(CcLoginDetailReqDto reqDto) throws Exception{
        BaseCcLoginDetail model = new BaseCcLoginDetail();
        BeanUtils.copyProperties(reqDto,model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseCcLoginDetailMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseCcLoginDetail ccLoginDetail = new BaseCcLoginDetail();
        ccLoginDetail.setId(id);
        ccLoginDetail.setUpdateDate(new Date());
        ccLoginDetail.setUpdateUserId(super.getHeaderUserId());
        int count = baseCcLoginDetailMapper.updateByPrimaryKeySelective(ccLoginDetail);
        return Result.newSuccessResult(count);
    }

    public Result<BaseCcLoginDetail> get(Long id) throws Exception{
       BaseCcLoginDetail model = baseCcLoginDetailMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseCcLoginDetail>> getPage(CcLoginDetailReqDto ccLoginDetailReqDto, AbstractBasePageDto pageDto) throws Exception{
		BaseCcLoginDetailExample baseCcLoginDetailExample = new BaseCcLoginDetailExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseCcLoginDetailExample.Criteria criteria = baseCcLoginDetailExample.createCriteria();
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
		baseCcLoginDetailExample.setOrderByClause(orderByClause);
		List<BaseCcLoginDetail> list = baseCcLoginDetailMapper.selectByExample(baseCcLoginDetailExample);
		int totalCount = baseCcLoginDetailMapper.countByExample(baseCcLoginDetailExample);
		PaginationSupport<BaseCcLoginDetail> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

}
