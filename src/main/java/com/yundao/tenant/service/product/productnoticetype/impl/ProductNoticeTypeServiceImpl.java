package com.yundao.tenant.service.product.productnoticetype.impl;

import java.util.List;
import java.util.Date;

import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.UUIDUtils;
import com.yundao.tenant.constant.CommonConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.core.code.Result;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeMapper;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeTypeMapper;
import com.yundao.tenant.model.base.product.*;
import com.yundao.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.yundao.tenant.mapper.product.productnoticetype.ProductNoticeTypeMapper;
import com.yundao.tenant.service.product.productnoticetype.ProductNoticeTypeService;

@Service
public class ProductNoticeTypeServiceImpl extends AbstractService implements ProductNoticeTypeService{

    @Autowired
    private BaseProductNoticeTypeMapper baseProductNoticeTypeMapper;

    @Autowired
    private ProductNoticeTypeMapper productNoticeTypeMapper;

    @Autowired
    private BaseProductNoticeMapper baseProductNoticeMapper;

    private static Integer IS_PERMIT_DELETE = 0;

    public Result<Long> add(BaseProductNoticeType productNoticeType) throws Exception{
        if(BooleanUtils.isEmpty(productNoticeType.getCode())){
            productNoticeType.setCode(UUIDUtils.getUUID());
        }
        //判断是不是重复的公告类型
        BaseProductNoticeTypeExample typeExample = new BaseProductNoticeTypeExample();
        typeExample.createCriteria().andNameEqualTo(productNoticeType.getName());
        BaseProductNoticeType noticeType = baseProductNoticeTypeMapper.selectOne(typeExample);
        if(noticeType != null){
            throw new BaseException(GJLCodeConstant.CODE_1210090);
        }
        BaseProductNoticeTypeExample typeExampleTemp = new BaseProductNoticeTypeExample();
        typeExampleTemp.or().andNameEqualTo(productNoticeType.getName());
        noticeType = baseProductNoticeTypeMapper.selectOne(typeExampleTemp);
        //如果已经存在但是状态为已删除，就修改为未删除。否则新增。
        if(noticeType != null){
            noticeType.setIsDelete(com.yundao.core.constant.CommonConstant.ZERO);
            baseProductNoticeTypeMapper.updateByPrimaryKeySelective(noticeType);
        }else {
            productNoticeType.setCreateDate(new Date());
            productNoticeType.setId(null);
            baseProductNoticeTypeMapper.insertSelective(productNoticeType);
        }
        return Result.newSuccessResult(productNoticeType.getId());
    }

    public Result<Integer> update(BaseProductNoticeType productNoticeType) throws Exception{
        productNoticeType.setUpdateDate(new Date());
        int count = baseProductNoticeTypeMapper.updateByPrimaryKeySelective(productNoticeType);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        //当前公告类型是否已经被使用
        BaseProductNoticeExample noticeExample = new BaseProductNoticeExample();
        noticeExample.createCriteria().andNoticeTypeIdEqualTo(id);
        List<BaseProductNotice> notices = baseProductNoticeMapper.selectByExample(noticeExample);
        if(notices != null && !notices.isEmpty()){
            throw new BaseException(GJLCodeConstant.CODE_1210016);
        }

        BaseProductNoticeType productNoticeType = baseProductNoticeTypeMapper.selectByPrimaryKey(id);
        if(productNoticeType.getIsPermitDelete().equals(IS_PERMIT_DELETE)){
            throw new BaseException(GJLCodeConstant.CODE_1210075);
        }
        int count = baseProductNoticeTypeMapper.deleteByPrimaryKey(productNoticeType.getId());
        return Result.newSuccessResult(count);
    }

    public Result<BaseProductNoticeType> get(Long id) throws Exception{
       BaseProductNoticeType model = baseProductNoticeTypeMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseProductNoticeType>> getPage(BaseProductNoticeType baseProductNoticeType, AbstractBasePageDto pageDto) throws Exception{
		BaseProductNoticeTypeExample baseProductNoticeTypeExample = new BaseProductNoticeTypeExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseProductNoticeTypeExample.Criteria criteria = baseProductNoticeTypeExample.createCriteria();
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
		baseProductNoticeTypeExample.setOrderByClause(orderByClause);
		List<BaseProductNoticeType> list = baseProductNoticeTypeMapper.selectByExample(baseProductNoticeTypeExample);
		int totalCount = baseProductNoticeTypeMapper.countByExample(baseProductNoticeTypeExample);
		PaginationSupport<BaseProductNoticeType> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

    @Override
    public Result<List<BaseProductNoticeType>> getAll() throws Exception {
        BaseProductNoticeTypeExample typeExample = new BaseProductNoticeTypeExample();
        typeExample.createCriteria();
        return Result.newSuccessResult(baseProductNoticeTypeMapper.selectByExample(typeExample));
    }

}
