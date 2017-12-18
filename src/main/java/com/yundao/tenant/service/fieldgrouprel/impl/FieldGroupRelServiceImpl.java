package com.yundao.tenant.service.fieldgrouprel.impl;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.bo.ObjectFieldPageResDto;
import com.yundao.tenant.mapper.base.BaseFieldGroupRelMapper;
import com.yundao.tenant.mapper.base.BaseObjectFieldMapper;
import com.yundao.tenant.mapper.fieldgrouprel.FieldGroupRelMapper;
import com.yundao.tenant.model.base.BaseFieldGroupRel;
import com.yundao.tenant.model.base.BaseFieldGroupRelExample;
import com.yundao.tenant.model.base.BaseObjectFieldExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.bo.ObjectFieldService;
import com.yundao.tenant.service.fieldgrouprel.FieldGroupRelService;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FieldGroupRelServiceImpl extends AbstractService implements FieldGroupRelService {

    @Autowired
    private BaseFieldGroupRelMapper baseFieldGroupRelMapper;

    @Autowired
    private FieldGroupRelMapper fieldGroupRelMapper;

    @Autowired
    private BaseObjectFieldMapper baseObjectFieldMapper;

    @Autowired
    private ObjectFieldService objectFieldService;

    public Result<Integer> add(BaseFieldGroupRel fieldGroupRel) throws Exception {
        fieldGroupRel.setCreateDate(new Date());
        fieldGroupRel.setId(null);
        int count = baseFieldGroupRelMapper.insertSelective(fieldGroupRel);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(BaseFieldGroupRel fieldGroupRel) throws Exception {
        fieldGroupRel.setUpdateDate(new Date());
        int count = baseFieldGroupRelMapper.updateByPrimaryKeySelective(fieldGroupRel);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception {
        BaseFieldGroupRel fieldGroupRel = new BaseFieldGroupRel();
        fieldGroupRel.setId(id);
        fieldGroupRel.setIsDelete(CommonConstant.ONE);
        int count = baseFieldGroupRelMapper.updateByPrimaryKeySelective(fieldGroupRel);
        return Result.newSuccessResult(count);
    }

    public Result<BaseFieldGroupRel> get(Long id) throws Exception {
        BaseFieldGroupRel model = baseFieldGroupRelMapper.selectByPrimaryKey(id);
        return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseFieldGroupRel>> getPage(BaseFieldGroupRel baseFieldGroupRel, AbstractBasePageDto pageDto) throws Exception {
        BaseFieldGroupRelExample baseFieldGroupRelExample = new BaseFieldGroupRelExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
        BaseFieldGroupRelExample.Criteria criteria = baseFieldGroupRelExample.createCriteria();
        String orderByClause = "create_date desc";
        if (StringUtils.isNotBlank(pageDto.getOrderColumn())) {
            StringBuilder orderBuider = new StringBuilder();
            orderBuider.append(pageDto.getOrderColumn()).append(" ");
            if (StringUtils.isNotBlank(pageDto.getSort())) {
                orderBuider.append(pageDto.getSort());
            } else {
                orderBuider.append("desc");
            }
            orderByClause = orderBuider.toString();
        }
        baseFieldGroupRelExample.setOrderByClause(orderByClause);
        List<BaseFieldGroupRel> list = baseFieldGroupRelMapper.selectByExample(baseFieldGroupRelExample);
        int totalCount = baseFieldGroupRelMapper.countByExample(baseFieldGroupRelExample);
        PaginationSupport<BaseFieldGroupRel> result = pageDto.getPaginationSupport();
        result.setDatas(list);
        result.setTotalCount(totalCount);
        return Result.newSuccessResult(result);
    }

    @Override
    public Result<List<ObjectFieldPageResDto>> getGroups(Long groupId) throws BaseException {
        BaseFieldGroupRelExample example = new BaseFieldGroupRelExample();
        BaseFieldGroupRelExample.Criteria criteria = example.createCriteria();
        criteria.andFieldGroupIdEqualTo(groupId);
        example.setOrderByClause("sequence asc");
        List<BaseFieldGroupRel> fieldGroupRels = baseFieldGroupRelMapper.selectByExample(example);
        List<Long> objectFieldIds = LambdaMap.toSingleList(fieldGroupRels, m -> m.getObjectFieldId());
        Result<List<ObjectFieldPageResDto>> result = objectFieldService.getByIdsOrder(objectFieldIds);
        objectFieldService.setText(result.getResult());
        return result;
    }

}
