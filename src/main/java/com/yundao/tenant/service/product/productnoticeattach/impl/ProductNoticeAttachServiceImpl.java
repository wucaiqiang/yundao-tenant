package com.yundao.tenant.service.product.productnoticeattach.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeAttachMapper;
import com.yundao.tenant.mapper.product.productnoticeattach.ProductNoticeAttachMapper;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttach;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttachExample;
import com.yundao.tenant.service.product.productnoticeattach.ProductNoticeAttachService;

@Service
public class ProductNoticeAttachServiceImpl extends AbstractService implements ProductNoticeAttachService{

    @Autowired
    private BaseProductNoticeAttachMapper baseProductNoticeAttachMapper;

    @Autowired
    private ProductNoticeAttachMapper productNoticeAttachMapper;

    public Result<Integer> add(BaseProductNoticeAttach productNoticeAttach) throws Exception{
        productNoticeAttach.setCreateDate(new Date());
        productNoticeAttach.setId(null);
        int count = baseProductNoticeAttachMapper.insertSelective(productNoticeAttach);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(BaseProductNoticeAttach productNoticeAttach) throws Exception{
        productNoticeAttach.setUpdateDate(new Date());
        int count = baseProductNoticeAttachMapper.updateByPrimaryKeySelective(productNoticeAttach);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseProductNoticeAttach productNoticeAttach = new BaseProductNoticeAttach();
        productNoticeAttach.setId(id);
        productNoticeAttach.setIsDelete(CommonConstant.ONE);
        int count = baseProductNoticeAttachMapper.updateByPrimaryKeySelective(productNoticeAttach);
        return Result.newSuccessResult(count);
    }

    public Result<BaseProductNoticeAttach> get(Long id) throws Exception{
       BaseProductNoticeAttach model = baseProductNoticeAttachMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseProductNoticeAttach>> getPage(BaseProductNoticeAttach baseProductNoticeAttach, AbstractBasePageDto pageDto) throws Exception{
		BaseProductNoticeAttachExample baseProductNoticeAttachExample = new BaseProductNoticeAttachExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseProductNoticeAttachExample.Criteria criteria = baseProductNoticeAttachExample.createCriteria();
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
		baseProductNoticeAttachExample.setOrderByClause(orderByClause);
		List<BaseProductNoticeAttach> list = baseProductNoticeAttachMapper.selectByExample(baseProductNoticeAttachExample);
		int totalCount = baseProductNoticeAttachMapper.countByExample(baseProductNoticeAttachExample);
		PaginationSupport<BaseProductNoticeAttach> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }
    
    
    /**
     * 通过公告id查询附件集合
     * gets:
     * @author: 欧阳利
     * @param noticeId
     * @return
     * @throws Exception
     * @description:
     */
    public List<BaseProductNoticeAttach> gets(Long noticeId)throws Exception{
    	BaseProductNoticeAttachExample example = new BaseProductNoticeAttachExample();
    	example.createCriteria().andNoticeIdEqualTo(noticeId);
    	return baseProductNoticeAttachMapper.selectByExample(example);
    }

}
