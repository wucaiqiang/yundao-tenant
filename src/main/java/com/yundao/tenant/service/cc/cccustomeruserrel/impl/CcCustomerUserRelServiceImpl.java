package com.yundao.tenant.service.cc.cccustomeruserrel.impl;

import java.util.List;
import java.util.Date;
import com.yundao.tenant.mapper.base.cc.BaseCcCustomerUserRelMapper;
import com.yundao.tenant.mapper.cc.cccustomeruserrel.CcCustomerUserRelMapper;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.cc.BaseCcCustomerUserRel;
import com.yundao.tenant.service.cc.cccustomeruserrel.CcCustomerUserRelService;
import com.yundao.tenant.dto.cc.cccustomeruserrel.CcCustomerUserRelReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.cc.BaseCcCustomerUserRelExample;
import com.yundao.core.utils.Limit;
import com.yundao.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CcCustomerUserRelServiceImpl extends AbstractService implements CcCustomerUserRelService{

    @Autowired
    private BaseCcCustomerUserRelMapper baseCcCustomerUserRelMapper;

    @Autowired
    private CcCustomerUserRelMapper ccCustomerUserRelMapper;

    /**
     * 通过客户id查询对应的用户id(投资者id)
     * getUserIdByCustomerId:
     * @author: 欧阳利
     * @param customerId
     * @return
     * @throws BaseException
     * @description:
     */
    public Long getUserIdByCustomerId(Long customerId) throws BaseException{
    	BaseCcCustomerUserRelExample example = new BaseCcCustomerUserRelExample();
    	example.createCriteria().andCustomerIdEqualTo(customerId);
    	BaseCcCustomerUserRel base = baseCcCustomerUserRelMapper.selectOne(example);
    	if(base != null){
    		return base.getUserAccountId();
    	}
    	return null;
    }
    
    public Long getCustomerIdByUserId(Long UserId) throws BaseException{
    	BaseCcCustomerUserRelExample example = new BaseCcCustomerUserRelExample();
    	example.createCriteria().andUserAccountIdEqualTo(UserId);
    	BaseCcCustomerUserRel base = baseCcCustomerUserRelMapper.selectOne(example);
    	if(base != null){
    		return base.getCustomerId();
    	}
    	return null;
    }
    
    
    public Result<Integer> add(CcCustomerUserRelReqDto reqDto) throws Exception{
        BaseCcCustomerUserRel model = new BaseCcCustomerUserRel();
        BeanUtils.copyProperties(reqDto,model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseCcCustomerUserRelMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(CcCustomerUserRelReqDto reqDto) throws Exception{
        BaseCcCustomerUserRel model = new BaseCcCustomerUserRel();
        BeanUtils.copyProperties(reqDto,model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseCcCustomerUserRelMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseCcCustomerUserRel ccCustomerUserRel = new BaseCcCustomerUserRel();
        ccCustomerUserRel.setId(id);
        ccCustomerUserRel.setUpdateDate(new Date());
        ccCustomerUserRel.setUpdateUserId(super.getHeaderUserId());
        int count = baseCcCustomerUserRelMapper.updateByPrimaryKeySelective(ccCustomerUserRel);
        return Result.newSuccessResult(count);
    }

    public Result<BaseCcCustomerUserRel> get(Long id) throws Exception{
       BaseCcCustomerUserRel model = baseCcCustomerUserRelMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseCcCustomerUserRel>> getPage(CcCustomerUserRelReqDto ccCustomerUserRelReqDto, AbstractBasePageDto pageDto) throws Exception{
		BaseCcCustomerUserRelExample baseCcCustomerUserRelExample = new BaseCcCustomerUserRelExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseCcCustomerUserRelExample.Criteria criteria = baseCcCustomerUserRelExample.createCriteria();
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
		baseCcCustomerUserRelExample.setOrderByClause(orderByClause);
		List<BaseCcCustomerUserRel> list = baseCcCustomerUserRelMapper.selectByExample(baseCcCustomerUserRelExample);
		int totalCount = baseCcCustomerUserRelMapper.countByExample(baseCcCustomerUserRelExample);
		PaginationSupport<BaseCcCustomerUserRel> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

}
