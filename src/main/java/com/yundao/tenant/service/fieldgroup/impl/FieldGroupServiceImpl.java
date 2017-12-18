package com.yundao.tenant.service.fieldgroup.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.yundao.tenant.dto.common.PassListDto;
import com.yundao.tenant.dto.fieldgroup.FieldGroupInfoReqDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.common.FailListDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.fieldgroup.FieldGroupReqDto;
import com.yundao.tenant.mapper.base.BaseFieldGroupMapper;
import com.yundao.tenant.mapper.base.BaseFieldGroupRelMapper;
import com.yundao.tenant.mapper.base.BaseObjectFieldMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.fieldgroup.FieldGroupMapper;
import com.yundao.tenant.model.base.BaseBusinessObject;
import com.yundao.tenant.model.base.BaseFieldGroup;
import com.yundao.tenant.model.base.BaseFieldGroupExample;
import com.yundao.tenant.model.base.BaseFieldGroupRel;
import com.yundao.tenant.model.base.BaseFieldGroupRelExample;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.bo.BusinessObjectService;
import com.yundao.tenant.service.fieldgroup.FieldGroupService;
import com.yundao.tenant.util.CamelUtil;
import com.yundao.tenant.util.lambda.LambdaMap;

@Service
public class FieldGroupServiceImpl extends AbstractService implements FieldGroupService {

    private static Log log = LogFactory.getLog(FieldGroupServiceImpl.class);

    @Autowired
    private BaseFieldGroupMapper baseFieldGroupMapper;

    @Autowired
    private FieldGroupMapper fieldGroupMapper;

    @Autowired
    private BaseFieldGroupRelMapper baseFieldGroupRelMapper;

    @Autowired
    private BaseObjectFieldMapper baseObjectFieldMapper;

    @Autowired
    private BusinessObjectService businessObjectService;

    @Autowired
    private BaseProductMapper baseProductMapper;

    public Result<Long> add(FieldGroupReqDto dto) throws Exception {
        BaseFieldGroup model = new BaseFieldGroup();
        BeanUtils.copyProperties(dto, model);

        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        validateData(model, dto.getBoCode());
        baseFieldGroupMapper.insertSelective(model);
        //添加关联关系
        String fieldGroupRelIds = dto.getFieldGroupRelIds();
        addFieldGroupRel(model.getId(), fieldGroupRelIds);
        return Result.newSuccessResult(model.getId());
    }

    private void addFieldGroupRel(Long fieldGroupId, String fieldGroupRelIds) {
        if (BooleanUtils.isNotEmpty(fieldGroupRelIds)) {
            //新增关联关系
            String[] fieldIds = handleRelIds(fieldGroupRelIds);
            Long tenantId = super.getHeaderTenantId();
            for (int i = 0;i < fieldIds.length;i++) {
                String fieldId = fieldIds[i];
                BaseFieldGroupRel groupRel = new BaseFieldGroupRel(Long.valueOf(fieldId), fieldGroupId, new Date(), tenantId,i+1);
                baseFieldGroupRelMapper.insertSelective(groupRel);
            }
        }
    }

    /**
     * 排除相同的。
     * @param fieldGroupRelIds
     * @return
     */
    private String[] handleRelIds(String fieldGroupRelIds) {
        String[] fieldIds = fieldGroupRelIds.split(",");
        Map<String,Object> params = new HashMap<>(fieldIds.length);
        StringBuilder resultIds = new StringBuilder();
        for (String fieldId : fieldIds) {
            if(!params.containsKey(fieldId)){
                resultIds.append(",").append(fieldId);
                params.put(fieldId,fieldId);
            }
        }
        return resultIds.substring(1).split(",");
    }

    private void validateData(BaseFieldGroup model, String boCode) throws BaseException {
        BaseFieldGroup baseFieldGroup = fieldGroupMapper.valdateData(model);
        if (baseFieldGroup != null) {
            throw new BaseException(CodeConstant.CODE_1200029);
        }
        BaseBusinessObject baseBusinessObject = businessObjectService.getBusinessObjectByCode(boCode);
        if (baseBusinessObject == null) {
            throw new BaseException(GJLCodeConstant.CODE_1210000);
        }
        model.setBusinessObjectId(baseBusinessObject.getId());
    }

    public Result<Integer> update(FieldGroupReqDto dto) throws Exception {
        BaseBusinessObject baseBusinessObject = businessObjectService.getBusinessObjectByCode(dto.getBoCode());
        if (baseBusinessObject == null) {
            throw new BaseException(GJLCodeConstant.CODE_1210000);
        }
        BaseFieldGroup fieldGroup = new BaseFieldGroup();
        BeanUtils.copyProperties(dto, fieldGroup);
        fieldGroup.setBusinessObjectId(baseBusinessObject.getId());
        fieldGroup.setUpdateDate(new Date());
        fieldGroup.setUpdateUserId(super.getHeaderUserId());
        validateData(fieldGroup, dto.getBoCode());
        int count = baseFieldGroupMapper.updateByPrimaryKeySelective(fieldGroup);
        updateFieldGroupRel(fieldGroup.getId(), dto.getFieldGroupRelIds());
        return Result.newSuccessResult(count);
    }

    public void updateFieldGroupRel(Long fieldGroupId, String fieldGroupRelIds) {
        //删除所有已有的关联关系.
        BaseFieldGroupRelExample example = new BaseFieldGroupRelExample();
        example.createCriteria().andFieldGroupIdEqualTo(fieldGroupId);
        baseFieldGroupRelMapper.deleteByExample(example);
        //添加新的关联关系
        addFieldGroupRel(fieldGroupId,fieldGroupRelIds);
    }

    @Override
    public Result<Integer> updateInfo(FieldGroupInfoReqDto dto) throws BaseException {
        BaseBusinessObject baseBusinessObject = businessObjectService.getBusinessObjectByCode(dto.getBoCode());
        if (baseBusinessObject == null) {
            throw new BaseException(GJLCodeConstant.CODE_1210000);
        }
        BaseFieldGroup fieldGroup = new BaseFieldGroup();
        BeanUtils.copyProperties(dto, fieldGroup);
        fieldGroup.setBusinessObjectId(baseBusinessObject.getId());
        fieldGroup.setUpdateDate(new Date());
        fieldGroup.setUpdateUserId(super.getHeaderUserId());
        validateData(fieldGroup, dto.getBoCode());
        int count = baseFieldGroupMapper.updateByPrimaryKeySelective(fieldGroup);
        return Result.newSuccessResult(count);
    }

//    private void updateFieldGroupRel(Long fieldGroupId, String fieldGroupRelIds) {
//        List<BaseObjectField> objectFields = new ArrayList<BaseObjectField>();
//        if (BooleanUtils.isNotEmpty(fieldGroupRelIds)) {
//            BaseObjectFieldExample objectFieldExample = new BaseObjectFieldExample();
//            String[] groupRelIds = fieldGroupRelIds.split(",");
//            List<Long> ids = new ArrayList<>(groupRelIds.length);
//            for (String idStr : groupRelIds) {
//                if (BooleanUtils.isNotEmpty(idStr))
//                    ids.add(NumberUtils.toLong(idStr));
//            }
//            objectFieldExample.createCriteria().andIdIn(ids);
//            objectFields = baseObjectFieldMapper.selectByExample(objectFieldExample);
//        }
//        //已经存在的数据
//        BaseFieldGroupRelExample fieldGroupRelExample = new BaseFieldGroupRelExample();
//        fieldGroupRelExample.createCriteria().andFieldGroupIdEqualTo(fieldGroupId);
//        List<BaseFieldGroupRel> fieldGroupRells = baseFieldGroupRelMapper.selectByExample(fieldGroupRelExample);
//
//        //获取已经存在业务对象字段
//        BaseObjectFieldExample example = new BaseObjectFieldExample();
//        example.createCriteria().andIdIn(LambdaMap.toSingleList(fieldGroupRells, BaseFieldGroupRel::getObjectFieldId));
//        List<BaseObjectField> objectFieldOlds = baseObjectFieldMapper.selectByExample(example);
//        //处理新增的数据
//        Long tenantId = super.getHeaderTenantId();
//        for (BaseObjectField objectField : objectFields) {
//            BaseFieldGroupRel fieldGroupRel = LambdaFilter.firstOrDefault(fieldGroupRells, m -> m.getObjectFieldId().equals(objectField.getId()));
//            if (fieldGroupRel == null) {
//                fieldGroupRel = new BaseFieldGroupRel(objectField.getId(), fieldGroupId, new Date(), tenantId);
//                baseFieldGroupRelMapper.insertSelective(fieldGroupRel);
//            }
//        }
//
//        //处理删除的数据
//        for (BaseFieldGroupRel fieldGroupRel : fieldGroupRells) {
//            BaseObjectField objectField = null;
//            if (BooleanUtils.isNotEmpty(objectFields)) {
//                objectField = LambdaFilter.firstOrDefault(objectFields, m -> m.getId().equals(fieldGroupRel.getObjectFieldId()));
//            }
//            BaseObjectField oldField = LambdaFilter.firstOrDefault(objectFieldOlds,m -> m.getId().equals(fieldGroupRel.getObjectFieldId()));
//            if (objectField == null && oldField.getIsShare() != 1) {
//                //表示该资源已经被删除
//                baseFieldGroupRelMapper.deleteByPrimaryKey(fieldGroupRel.getId());
//            }
//        }
//    }

    public Result<PermissionResultDto> delete(String ids) throws Exception {
        String[] arrays = ids.split(",");
        List<Long> idsList = Arrays.asList(arrays).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        BaseFieldGroupExample fieldGroupExample = new BaseFieldGroupExample();
        fieldGroupExample.createCriteria().andIdIn(idsList);
        List<BaseFieldGroup> baseFieldGroups = baseFieldGroupMapper.selectByExample(fieldGroupExample);
        List<FailListDto> resultList = null;
        List<PassListDto> passList = null;
        if (baseFieldGroups != null) {
            resultList = new ArrayList<FailListDto>();
            passList = new ArrayList<PassListDto>();
        }
        for (BaseFieldGroup fieldGroup : baseFieldGroups) {
            //是否有产品
            BaseProductExample productExample = new BaseProductExample();
            productExample.createCriteria().andTypeIdEqualTo(fieldGroup.getId());
            List<BaseProduct> products = baseProductMapper.selectByExample(productExample);
            if (products != null && !products.isEmpty()) {
                //有产品不能删除
                resultList.add(new FailListDto(GJLCodeConstant.CODE_1210002, "类型下有产品，不能进行删除", fieldGroup.getId(), fieldGroup.getName()));
            }else{
                PassListDto passListDto = new PassListDto();
                passListDto.setId(fieldGroup.getId());
                passListDto.setName(fieldGroup.getName());
                passList.add(passListDto);
            }
        }
        if(resultList == null || resultList.isEmpty()){
            for (BaseFieldGroup fieldGroup : baseFieldGroups) {
                fieldGroup.setIsDelete(CommonConstant.ONE);
                fieldGroup.setUpdateDate(new Date());
                fieldGroup.setUpdateUserId(super.getHeaderUserId());
                baseFieldGroupMapper.updateByPrimaryKeySelective(fieldGroup);
            }
        }
        return Result.newSuccessResult(new PermissionResultDto(resultList,passList));
    }

    public Result<BaseFieldGroup> get(Long id) throws Exception {
        BaseFieldGroup model = baseFieldGroupMapper.selectByPrimaryKey(id);
        return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseFieldGroup>> getPage(FieldGroupReqDto dto, AbstractBasePageDto pageDto) throws Exception {
        BaseFieldGroupExample baseFieldGroupExample = new BaseFieldGroupExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
        BaseFieldGroupExample.Criteria criteria = baseFieldGroupExample.createCriteria();
        if (BooleanUtils.isNotEmpty(dto.getBoCode())) {
            BaseBusinessObject baseBusinessObject = businessObjectService.getBusinessObjectByCode(dto.getBoCode());
            if (baseBusinessObject == null) {
                throw new BaseException(GJLCodeConstant.CODE_1210000);
            }
            criteria.andBusinessObjectIdEqualTo(baseBusinessObject.getId());
        }
        //设置参数
        if(BooleanUtils.isNotEmpty(dto.getCreateDateBegin())){
		    criteria.andCreateDateGreaterThanOrEqualTo(DateUtils.parse(dto.getCreateDateBegin(),DateUtils.YYYY_MM_DD));
        }
        if(BooleanUtils.isNotEmpty(dto.getCreateDateEnd())){
            criteria.andCreateDateLessThan(DateUtils.parse(dto.getCreateDateEnd(),DateUtils.YYYY_MM_DD_HH_MM_SS));
        }
        if(BooleanUtils.isNotEmpty(dto.getName())){
            criteria.andNameLike("%" + dto.getName() + "%");
        }
        if(dto.getIsEnabled() != null) {
            criteria.andIsEnabledEqualTo(dto.getIsEnabled());
        }
		String orderByClause="create_date desc";
		if(StringUtils.isNotBlank(pageDto.getOrderColumn())){
		  StringBuilder orderBuider=new StringBuilder();
		  orderBuider.append(CamelUtil.toline(pageDto.getOrderColumn())).append(" ");
		  if(StringUtils.isNotBlank(pageDto.getSort())){
			orderBuider.append(pageDto.getSort());
		  }else{
			orderBuider.append("desc");
		  }
		  orderByClause=orderBuider.toString();
		}
		baseFieldGroupExample.setOrderByClause(orderByClause);
		List<BaseFieldGroup> list = baseFieldGroupMapper.selectByExample(baseFieldGroupExample);
		int totalCount = baseFieldGroupMapper.countByExample(baseFieldGroupExample);
		PaginationSupport<BaseFieldGroup> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

    /**
     * 获取某个字段所关联的分组
     *
     * @param fieldId 字段id
     */
    @Override
    public List<BaseFieldGroup> getFieldRelList(Long fieldId) throws BaseException {
        log.begin(fieldId);
        BaseFieldGroupRelExample fgrExample = new BaseFieldGroupRelExample();
        fgrExample.createCriteria().andObjectFieldIdEqualTo(fieldId);
        List<BaseFieldGroupRel> rels = baseFieldGroupRelMapper.selectByExample(fgrExample);
        log.info("rels:%s", JsonUtils.objectToJson(rels));
        if (BooleanUtils.isEmpty(rels))
            return null;
        BaseFieldGroupExample fgExample = new BaseFieldGroupExample();
        fgExample.createCriteria().andIdIn(LambdaMap.toSingleList(rels, m -> m.getFieldGroupId()));
        log.end();
        return baseFieldGroupMapper.selectByExample(fgExample);
    }

    @Override
    public List<BaseFieldGroup> getByName(String name) throws BaseException {
        log.begin(name);
        BaseFieldGroupExample example = new BaseFieldGroupExample();
        example.createCriteria().andNameLike("%" + name + "%");
        return baseFieldGroupMapper.selectByExample(example);
    }
    
    
    /**
     * 通过businessCode查询字段组信息
     * @param code
     * @return
     * @throws BaseException
     */
    @Override
    public List<BaseFieldGroup> getByBusinessCode(String code) throws BaseException{
    	BaseBusinessObject baseBusinessObject = businessObjectService.getBusinessObjectByCode(code);
    	if(baseBusinessObject == null){
    		return null;
    	}
    	BaseFieldGroupExample example = new BaseFieldGroupExample();
    	example.createCriteria().andBusinessObjectIdEqualTo(baseBusinessObject.getId());
    	List<BaseFieldGroup> list = baseFieldGroupMapper.selectByExample(example);
    	return list;
    }

    
    /**
     * 检查fieldGroupid是否存在
     * @param fieldGroupId
     * @return
     * @throws BaseException
     */
    public boolean checkFieldGroupExist(Long fieldGroupId) throws BaseException{
    	if(fieldGroupId == null){
    		return false;
    	}
    	BaseFieldGroupExample example = new BaseFieldGroupExample();
    	example.createCriteria().andIdEqualTo(fieldGroupId);
    	List<BaseFieldGroup> list = baseFieldGroupMapper.selectByExample(example);
    	return !BooleanUtils.isEmpty(list);
    }
    
    /**
     * 通过id查询名称
     * @param id
     * @return
     * @throws BaseException
     */
    public String getNameById(Long id) throws BaseException{
    	if(id == null){
    		return null;
    	}
     	BaseFieldGroupExample example = new BaseFieldGroupExample();
    	example.createCriteria().andIdEqualTo(id);
    	BaseFieldGroup baseFieldGroup = baseFieldGroupMapper.selectOne(example);
    	if(baseFieldGroup == null){
    		return null;
    	}
    	return baseFieldGroup.getName();
    }

    @Override
    public Result<List<BaseFieldGroup>> getIds(String ids) throws BaseException {
        String[] idArr = ids.split(com.yundao.tenant.constant.CommonConstant.COMMA);
        List<Long> idList = new ArrayList<>(idArr.length);
        for (String id : idArr) {
            idList.add(Long.valueOf(id));
        }
        BaseFieldGroupExample fieldGroupExample = new BaseFieldGroupExample();
        fieldGroupExample.createCriteria().andIdIn(idList);
        List<BaseFieldGroup> fieldGroups = baseFieldGroupMapper.selectByExample(fieldGroupExample);
        return Result.newSuccessResult(fieldGroups);
    }
}
