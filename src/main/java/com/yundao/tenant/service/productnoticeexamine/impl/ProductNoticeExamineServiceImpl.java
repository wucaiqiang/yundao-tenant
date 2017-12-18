package com.yundao.tenant.service.productnoticeexamine.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeExaminePageReqDto;
import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeExamineResDto;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeAttachMapper;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeExamineMapper;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeMapper;
import com.yundao.tenant.mapper.productnoticeexamine.ProductNoticeExamineMapper;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttach;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttachExample;
import com.yundao.tenant.model.base.product.BaseProductNoticeExamine;
import com.yundao.tenant.model.base.product.BaseProductNoticeExample;
import com.yundao.tenant.service.productnoticeexamine.ProductNoticeExamineService;
import com.yundao.tenant.util.CamelUtil;

@Service
public class ProductNoticeExamineServiceImpl extends AbstractService implements ProductNoticeExamineService{

    @Autowired
    private BaseProductNoticeExamineMapper baseProductNoticeExamineMapper;

    @Autowired
    private ProductNoticeExamineMapper productNoticeExamineMapper;

    @Autowired
    private BaseProductNoticeAttachMapper baseProductNoticeAttachMapper;
    
    @Autowired
    private BaseProductNoticeMapper baseProductNoticeMapper;
    

    public Result<Integer> add(BaseProductNoticeExamine productNoticeExamine) throws Exception{
        productNoticeExamine.setCreateDate(new Date());
        productNoticeExamine.setId(null);
        int count = baseProductNoticeExamineMapper.insertSelective(productNoticeExamine);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(BaseProductNoticeExamine productNoticeExamine) throws Exception{
        productNoticeExamine.setUpdateDate(new Date());
        int count = baseProductNoticeExamineMapper.updateByPrimaryKeySelective(productNoticeExamine);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseProductNoticeExamine productNoticeExamine = new BaseProductNoticeExamine();
        productNoticeExamine.setId(id);
        productNoticeExamine.setIsDelete(CommonConstant.ONE);
        int count = baseProductNoticeExamineMapper.updateByPrimaryKeySelective(productNoticeExamine);
        return Result.newSuccessResult(count);
    }

    public Result<BaseProductNoticeExamine> get(Long id) throws Exception{
       BaseProductNoticeExamine model = baseProductNoticeExamineMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    /**
     * 产品公告审核列表
     * getPage:
     * @author: 欧阳利
     * @param baseProductNoticeExamine
     * @return
     * @throws Exception
     * @description:
     */
    public Result<PaginationSupport<ProductNoticeExamineResDto>> getPage(ProductNoticeExaminePageReqDto baseProductNoticeExamine) throws Exception{

    	PaginationSupport<ProductNoticeExamineResDto> result = baseProductNoticeExamine.getPaginationSupport();
    	
    	List<ProductNoticeExamineResDto> list =  productNoticeExamineMapper.getAuditPage(baseProductNoticeExamine);
    	int totalCount =  productNoticeExamineMapper.getAuditCount(baseProductNoticeExamine);
    	
		result.setDatas(setDataAttache(list));
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

    private List<ProductNoticeExamineResDto> setDataAttache(List<ProductNoticeExamineResDto> list) {
        if(list == null || list.isEmpty()){
            return null;
        }
        List<Long> noticeIds = new ArrayList<Long>();
        list.forEach(n -> noticeIds.add(n.getNoticeId()));
        BaseProductNoticeAttachExample attachExample = new BaseProductNoticeAttachExample();
        attachExample.createCriteria().andNoticeIdIn(noticeIds);
        List<BaseProductNoticeAttach> attaches = baseProductNoticeAttachMapper.selectByExample(attachExample);
        List<ProductNoticeExamineResDto> resDtos = new ArrayList<>();
        //设置附件
        list.forEach(model -> {
            ProductNoticeExamineResDto resDto = new ProductNoticeExamineResDto();
            BeanUtils.copyProperties(model,resDto);
            if(attaches != null && !attaches.isEmpty()) {
                List<BaseProductNoticeAttach> baseProductNoticeAttaches = new ArrayList<BaseProductNoticeAttach>();
                attaches.forEach(attache -> {
                    if (model.getNoticeId().equals(attache.getNoticeId())) {
                        baseProductNoticeAttaches.add(attache);

                    }
                });
                resDto.setBaseProductNoticeAttach(baseProductNoticeAttaches);
            }
            resDtos.add(resDto);
        });
        return resDtos;
    }

}
