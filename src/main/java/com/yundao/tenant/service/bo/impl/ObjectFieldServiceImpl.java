package com.yundao.tenant.service.bo.impl;

import com.yundao.core.base.model.BaseModel;
import com.yundao.core.code.Result;
import com.yundao.core.enums.NumberEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.bo.*;
import com.yundao.tenant.dto.common.FailListDto;
import com.yundao.tenant.dto.common.IdNameDto;
import com.yundao.tenant.dto.common.PassListDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.role.RoleDetailResDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.bo.AccessEnum;
import com.yundao.tenant.enums.bo.FieldTypeEnum;
import com.yundao.tenant.enums.bo.MandatoryEnum;
import com.yundao.tenant.enums.bo.ShareEnum;
import com.yundao.tenant.mapper.base.*;
import com.yundao.tenant.mapper.bo.ObjectFieldMapper;
import com.yundao.tenant.model.base.*;
import com.yundao.tenant.service.bo.BusinessObjectService;
import com.yundao.tenant.service.bo.FieldTypeService;
import com.yundao.tenant.service.bo.ObjectFieldService;
import com.yundao.tenant.service.field.FieldService;
import com.yundao.tenant.service.fieldgroup.FieldGroupService;
import com.yundao.tenant.service.role.RoleService;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务对象字段服务实现
 *
 * @author jan
 * @create 2017-07-04 AM10:24
 **/
@Service
public class ObjectFieldServiceImpl extends AbstractService implements ObjectFieldService {

    private static Log log = LogFactory.getLog(ObjectFieldServiceImpl.class);

    @Autowired
    private ObjectFieldMapper objectFieldMapper;

    @Autowired
    private BaseObjectFieldMapper baseObjectFieldMapper;

    @Autowired
    private BaseFieldRoleMapper baseFieldRoleMapper;

    @Autowired
    private BaseNumberConfigMapper baseNumberConfigMapper;

    @Autowired
    private BaseFieldConfigMapper baseFieldConfigMapper;

    @Autowired
    private BaseFieldGroupMapper baseFieldGroupMapper;

    @Autowired
    private BaseFieldGroupRelMapper baseFieldGroupRelMapper;

    @Autowired
    private BaseSelectConfigMapper baseSelectConfigMapper;

    @Autowired
    private BaseBusinessObjectMapper baseBusinessObjectMapper;

    @Autowired
    private BaseFieldTypeMapper baseFieldTypeMapper;

    @Autowired
    private BaseFieldMapper baseFieldMapper;

    @Autowired
    private FieldGroupService fieldGroupService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private FieldTypeService fieldTypeService;

    @Autowired
    private BusinessObjectService businessObjectService;

    @Autowired
    private FieldService fieldService;

    private String ID = "id";

    private String sort = "asc";

    @Override
    public PaginationSupport<ObjectFieldPageResDto> getPage(ObjectFieldPageReqDto dto) throws BaseException {
        log.begin(dto);
        BaseBusinessObject businessObject = businessObjectService.getBusinessObjectByCode(dto.getBoCode());
        if (businessObject == null)
            throw new BaseException(CodeConstant.CODE_1200027);
        dto.setBoId(businessObject.getId());
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);

        if (BooleanUtils.isNotEmpty(dto.getTypeText())) {
            BaseFieldTypeExample ftExample = new BaseFieldTypeExample();
            ftExample.createCriteria().andNameLike("%" + dto.getTypeText() + "%");
            List<BaseFieldType> fieldTypes = baseFieldTypeMapper.selectByExample(ftExample);
            if (BooleanUtils.isEmpty(fieldTypes))
                paramMap.put("typeIds", "-1");
            else
                paramMap.put("typeIds", SymbolStrUtils.longToStr(LambdaMap.toSingleList(fieldTypes, m -> m.getId())));
        }

        PaginationSupport<ObjectFieldPageResDto> page = PaginationSupport.newDefault(paramMap);
        List<ObjectFieldPageResDto> dtos = objectFieldMapper.selectPage(paramMap);
        this.setText(dtos);
        int count = objectFieldMapper.selectPageCount(paramMap);
        page.setDatas(dtos);
        page.setTotalCount(count);
        log.end();
        return page;
    }

    @Override
    public Result<ObjectFieldDetailResDto> get(Long id) throws BaseException {
        log.begin(id);
        BaseObjectField objectField = baseObjectFieldMapper.selectByPrimaryKey(id);
        if (objectField == null)
            throw new BaseException(CodeConstant.CODE_1200028);
        ObjectFieldDetailResDto dto = new ObjectFieldDetailResDto();
        BeanUtils.copyProperties(objectField, dto);

        BaseField baseField = baseFieldMapper.selectByPrimaryKey(objectField.getFieldId());
        if (baseField != null) {
            dto.setName(baseField.getName());
        }

        BaseFieldType fieldType = baseFieldTypeMapper.selectByPrimaryKey(objectField.getFieldTypeId());
        if (fieldType != null)
            dto.setFieldTypeCode(fieldType.getCode());

        //获取关联的分组
        List<BaseFieldGroup> fieldGroups = fieldGroupService.getFieldRelList(objectField.getId());
        if (BooleanUtils.isNotEmpty(fieldGroups)) {
            dto.setFieldGroups(LocalBeanUtils.copyPropertiesList(fieldGroups, IdNameDto.class));
        }

        //选项数据
        if (FieldTypeEnum.isSelection(fieldType.getCode())) {
            BaseSelectConfigExample selectConfigExample = new BaseSelectConfigExample();
            selectConfigExample.createCriteria().andObjectFieldIdEqualTo(objectField.getId());
            selectConfigExample.setOrderByClause("sequence ASC");
            List<BaseSelectConfig> selects = baseSelectConfigMapper.selectByExample(selectConfigExample);
            log.info("selects:%s", JsonUtils.objectToJson(selects));
            if (BooleanUtils.isNotEmpty(selects)) {
                List<SelectionDto> selectDtos = new ArrayList<>();
                for (BaseSelectConfig select : selects) {
                    SelectionDto sd = new SelectionDto();
                    sd.setId(select.getId());
                    sd.setLabel(select.getLabel());
                    sd.setSequence(select.getSequence());
                    sd.setIsSystem(select.getIsSystem());
                    selectDtos.add(sd);
                }
                dto.setSelections(selectDtos);
            }
        } else if (FieldTypeEnum.isNumber(fieldType.getCode())) {
            BaseNumberConfigExample numberConfigExample = new BaseNumberConfigExample();
            numberConfigExample.createCriteria().andObjectFieldIdEqualTo(objectField.getId());
            BaseNumberConfig numberConfig = baseNumberConfigMapper.selectOne(numberConfigExample);
            log.info("numberConfig:%s", JsonUtils.objectToJson(numberConfig));
            if (numberConfig != null)
                dto.setUnit(numberConfig.getUnit());
        }

        //查看该元素的权限限制
        BaseFieldRoleExample baseFieldRoleExample = new BaseFieldRoleExample();
        baseFieldRoleExample.createCriteria().andObjectFieldIdEqualTo(objectField.getId());
        List<BaseFieldRole> fieldRoles = baseFieldRoleMapper.selectByExample(baseFieldRoleExample);
        log.info("fieldRoles:%s", JsonUtils.objectToJson(fieldRoles));
        if (BooleanUtils.isEmpty(fieldRoles)) {
            dto.setAccess(AccessEnum.ALL.getValue());
            return Result.newSuccessResult(dto);
        }
        dto.setAccess(AccessEnum.PART.getValue());

        //获取租户所有角色
        List<RoleDetailResDto> roles = roleService.gets().getResult();
        log.info("roles:%s", JsonUtils.objectToJson(roles));
        if (BooleanUtils.isEmpty(roles))
            return Result.newSuccessResult(dto);
        dto.setRoles(roles);
        //获取该元素可见的角色
        List<IdNameDto> selectedRoles = LocalBeanUtils.copyPropertiesList(fieldRoles, IdNameDto.class);
        log.info("selectedRoles:%s", JsonUtils.objectToJson(selectedRoles));
        dto.setSelectedRoles(selectedRoles);

        return Result.newSuccessResult(dto);
    }

    @Override
    public Result<List<ObjectFieldSimpleResDto>> getByBoCode(String boCode) throws BaseException {
        log.begin(boCode);
        BaseBusinessObject businessObject = businessObjectService.getBusinessObjectByCode(boCode);
        if (businessObject == null)
            throw new BaseException(CodeConstant.CODE_1200027);
        BaseObjectFieldExample baseObjectFieldExample = new BaseObjectFieldExample();
        baseObjectFieldExample.createCriteria().andBusinessObjectIdEqualTo(businessObject.getId()).andIsEnabledEqualTo(EnabledEnum.ENABLED.getValue());
        List<BaseObjectField> objectFields = baseObjectFieldMapper.selectByExample(baseObjectFieldExample);
        log.info("objectFields:%s", JsonUtils.objectToJson(objectFields));
        if (BooleanUtils.isEmpty(objectFields))
            return Result.newSuccessResult(new ArrayList<ObjectFieldSimpleResDto>());
        List<ObjectFieldSimpleResDto> dtos = LocalBeanUtils.copyPropertiesList(objectFields, ObjectFieldSimpleResDto.class);

        List<BaseField> fields = fieldService.getsByIds(LambdaMap.toSingleList(objectFields, BaseObjectField::getFieldId));
        dtos.forEach(m -> {
            BaseField field = LambdaFilter.firstOrDefault(fields, n -> m.getFieldId().equals(n.getId()));
            if (field != null) {
                m.setCode(field.getCode());
                m.setName(field.getName());
            }
        });
        log.end();
        return Result.newSuccessResult(dtos);
    }

    @Override
    public Result<Long> add(ObjectFieldAddReqDto dto) throws BaseException {
        log.begin(dto);
        this.checkArgsForAdd(dto);
        if (!this.checkNameForAdd(dto.getName()))
            throw new BaseException(CodeConstant.CODE_1220021);
        //获取业务对象
        BaseBusinessObject businessObject = businessObjectService.getBusinessObjectByCode(dto.getBoCode());
        //设置业务对象字段的值
        BaseObjectField field = this.setValue(dto, businessObject.getId());
        //同时添加字段
        Long fieldId = fieldService.add(dto.getName(), dto.getBoCode());
        field.setFieldId(fieldId);
        baseObjectFieldMapper.insertSelective(field);
        //通用
        if (ShareEnum.SHARE.getValue().equals(dto.getIsShare())) {
            this.updateShareFields(field.getId(), businessObject.getId());
        }

        if (AccessEnum.PART.getValue().equals(dto.getAccess())) {
            this.addFieldRole(field.getId(), dto.getRoleIds());
        }

        if (FieldTypeEnum.isSelection(dto.getFieldTypeCode())) {
            //选项
            this.addSelectionKind(field.getId(), dto.getSelectionsBean());
        } else if (FieldTypeEnum.isNumber(dto.getFieldTypeCode())) {
            //数值和数值区间
            this.addNumberKind(field.getId(), dto.getUnit());
        } else {
            //其他
            this.addDefaultKind(field.getId(), dto);
        }
        log.end();
        return Result.newSuccessResult(field.getId());
    }

    @Override
    public Result<Long> update(ObjectFieldUpdateReqDto dto) throws BaseException {
        log.begin(dto);
        BaseObjectField oriField = baseObjectFieldMapper.selectByPrimaryKey(dto.getId());
        if (oriField == null)
            throw new BaseException(CodeConstant.CODE_1220022);
        Integer oriIsShare = oriField.getIsShare();
        if (!this.checkNameForUpdate(dto.getName(), dto.getId()))
            throw new BaseException(CodeConstant.CODE_1220021);
        //获取业务对象
        BaseBusinessObject businessObject = baseBusinessObjectMapper.selectByPrimaryKey(oriField.getBusinessObjectId());

        BaseFieldType fieldType = baseFieldTypeMapper.selectByPrimaryKey(oriField.getFieldTypeId());
        //是否系统预置和通用
        boolean isSystemAndCommon = false;
        if (YesOrNoEnum.YES.getValue().equals(oriField.getIsSystem()) && YesOrNoEnum.YES.getValue().equals(oriField
                .getIsShare())) {
            isSystemAndCommon = true;
        }
        //非系统预置和通用，可以更新以下值
        if (!isSystemAndCommon) {
            //修改名称
            fieldService.updateName(oriField.getFieldId(), dto.getName());
            oriField.setIsShare(dto.getIsShare());
            //修改单位
            if (FieldTypeEnum.isNumber(fieldType.getCode())) {
                this.updateNumberKind(oriField.getId(), dto.getUnit());
            }
            //修改选项
            if (FieldTypeEnum.isSelection(fieldType.getCode()) && BooleanUtils.isNotEmpty(dto.getSelectionsBean())) {
                this.updateSelectionFieldConfig(oriField.getId(), dto.getSelectionsBean());
            }

            //修改了“是否通用”
            if (!oriIsShare.equals(dto.getIsShare())) {
                //非通用-》通用
                if (ShareEnum.SHARE.getValue().equals(dto.getIsShare())) {
                    this.updateShareFields(oriField.getId(), businessObject.getId());
                }

                if (ShareEnum.RELEVANCE.getValue().equals(dto.getIsShare())) {
                    this.updateUnShareFields(oriField.getId());
                }
            }
        }

        //“权限限制”
        if (AccessEnum.PART.getValue().equals(dto.getAccess()))
            this.addFieldRole(oriField.getId(), dto.getRoleIds());
        if (AccessEnum.ALL.getValue().equals(dto.getAccess()))
            this.updateFieldRole(oriField.getId());

        oriField.setSequence(dto.getSequence());
        oriField.setIsEnabled(dto.getIsEnabled());
        oriField.setIsMandatory(dto.getIsMandatory());
        oriField.setAccess(dto.getAccess());
        this.addSelectionFiedlConfig(oriField.getId(), dto.getSelectionsBean());
        baseObjectFieldMapper.updateByPrimaryKeySelective(oriField);
        log.end();
        return Result.newSuccessResult(dto.getId());
    }

    /**
     * 删除
     *
     * @param ids 多个id逗号分隔
     */
    @Override
    public Result<PermissionResultDto> delete(String ids, String boCode) throws BaseException {
        log.begin(ids);
        List<Long> lIds = SymbolStrUtils.toLong(ids);
        PermissionResultDto permissionResultDto = new PermissionResultDto();
        //业务对象字段
        BaseBusinessObject bo = businessObjectService.getBusinessObjectByCode(boCode);
        List<ObjectFieldListDto> objectFields = objectFieldMapper.selectListByIds(lIds, bo.getId());

        log.info("objectFields:%s", JsonUtils.objectToJson(objectFields));
        if (BooleanUtils.isEmpty(objectFields))
            throw new BaseException(CodeConstant.CODE_1200028);

        //分组关系
        BaseFieldGroupRelExample fieldGroupRelExample = new BaseFieldGroupRelExample();
        fieldGroupRelExample.createCriteria().andObjectFieldIdIn(lIds);
        List<BaseFieldGroupRel> fieldGroupRels = baseFieldGroupRelMapper.selectByExample(fieldGroupRelExample);
        log.info("fieldGroupRels:%s", JsonUtils.objectToJson(fieldGroupRels));
        //字段与角色关系
        BaseFieldRoleExample fieldRoleExample = new BaseFieldRoleExample();
        fieldRoleExample.createCriteria().andObjectFieldIdIn(lIds);
        List<BaseFieldRole> fieldRoles = baseFieldRoleMapper.selectByExample(fieldRoleExample);
        log.info("fieldRoles:%s", fieldRoles);
        for (BaseObjectField objectField : objectFields) {
            //预置的通用要素不可删除
            if (objectField.getIsSystem().equals(YesOrNoEnum.YES.getValue()) && objectField.getIsShare().equals(YesOrNoEnum.YES.getValue())) {
                FailListDto fail = new FailListDto();
                fail.setId(objectField.getId());
                fail.setName(objectField.getName());
                fail.setCode(CodeConstant.CODE_1220010);
                permissionResultDto.getFailList().add(fail);
            } else {
                PassListDto pass = new PassListDto();
                pass.setId(objectField.getId());
                pass.setName(objectField.getName());
                permissionResultDto.getPassList().add(pass);
            }
        }
        if (!permissionResultDto.isSuccess())
            return Result.newSuccessResult(permissionResultDto);

        for (BaseObjectField objectField : objectFields) {
            //删除对象字段
            objectField.setIsDelete(DeleteEnum.DELETED.getValue());
            super.updateModel(objectField);
            baseObjectFieldMapper.updateByPrimaryKeySelective(objectField);
            //删除与分组的关系
            if (BooleanUtils.isNotEmpty(fieldGroupRels)) {
                BaseFieldGroupRel fieldGroupRel = LambdaFilter.firstOrDefault(fieldGroupRels, m -> m.getObjectFieldId().equals(objectField.getId()));
                if (fieldGroupRel != null) {
                    fieldGroupRel.setIsDelete(DeleteEnum.DELETED.getValue());
                    super.updateModel(fieldGroupRel);
                    baseFieldGroupRelMapper.updateByPrimaryKeySelective(fieldGroupRel);
                }
            }
            //删除与角色的关系
            if (BooleanUtils.isNotEmpty(fieldRoles)) {
                BaseFieldRole fieldRole = LambdaFilter.firstOrDefault(fieldRoles, m -> m.getObjectFieldId().equals(objectField.getId()));
                if (fieldRole != null) {
                    fieldRole.setIsDelete(DeleteEnum.DELETED.getValue());
                    super.updateModel(fieldRole);
                    baseFieldRoleMapper.updateByPrimaryKeySelective(fieldRole);
                }
            }
        }
        log.end();
        return Result.newSuccessResult(null);
    }

    @Override
    public Result<List<ObjectFieldPageResDto>> getFieldList(String boCode) throws BaseException {
        log.begin(boCode);
        BaseBusinessObject businessObject = businessObjectService.getBusinessObjectByCode(boCode);
        if (businessObject == null)
            throw new BaseException(CodeConstant.CODE_1200027);
        Map<String, Object> params = new HashMap<>(1);
        params.put("boId", businessObject.getId());
        params.put("orderColumn", ID);
        params.put("sort", sort);
        return this.gets(params);
    }

    @Override
    public Result<List<ObjectFieldPageResDto>> gets(Map<String, Object> params) throws BaseException {
        log.begin(params);
        List<ObjectFieldPageResDto> fields = objectFieldMapper.selectList(params);
        this.setText(fields);
        return Result.newSuccessResult(fields);
    }

    @Override
    public Result<List<ObjectFieldPageResDto>> getByIds(List<Long> ids) throws BaseException {
        log.begin(ids);
        if (BooleanUtils.isEmpty(ids))
            return Result.newSuccessResult(new ArrayList<>());
        return Result.newSuccessResult(objectFieldMapper.selectByIds(ids));
    }

    /**
     * 设置值
     *
     * @param dto  业务对象字段实体数据
     * @param boId 业务对象 id
     */
    private BaseObjectField setValue(ObjectFieldAddReqDto dto, Long boId) throws BaseException {

        BaseObjectField field = new BaseObjectField();
        super.initialModel(field);
        BeanUtils.copyProperties(dto, field);
        BaseFieldType fieldType = fieldTypeService.getByCode(dto.getFieldTypeCode());
        field.setFieldTypeId(fieldType.getId());
        field.setBusinessObjectId(boId);
        field.setIsFix(NumberEnum.ZERO.getValue());
        field.setDisplayType(NumberEnum.ZERO.getValue());
        field.setIsSystem(NumberEnum.ZERO.getValue());
        field.setIsInit(NumberEnum.ZERO.getValue());
        field.setSequence(dto.getSequence());
        field.setAccess(dto.getAccess());
        return field;
    }

    /**
     * 设置文本
     */
    @Override
    public void setText(List<ObjectFieldPageResDto> dtos) throws BaseException {
        for (ObjectFieldPageResDto item : dtos) {
            item.setIsMandatoryText(MandatoryEnum.getEnumName(item.getIsMandatory()));
            item.setIsShareText(ShareEnum.getEnumName(item.getIsShare()));
            item.setIsEnabledText(EnabledEnum.getEnumName(item.getIsEnabled()));
            item.setAccessText(AccessEnum.getEnumName(item.getAccess()));
            item.setIsSystemText(YesOrNoEnum.getEnumName(item.getIsSystem()));
        }
    }

    @Override
    public Result<List<ObjectFieldPageResDto>> getByIdsOrder(List<Long> objectFieldIds) {
        log.begin(objectFieldIds);
        if (BooleanUtils.isEmpty(objectFieldIds))
            return Result.newSuccessResult(new ArrayList<>());
        return Result.newSuccessResult(objectFieldMapper.selectByIdsOrder(objectFieldIds));
    }

    /**
     * 添加操作检验参数
     */
    private void checkArgsForAdd(ObjectFieldAddReqDto dto) throws BaseException {
        log.begin(dto);
        if (FieldTypeEnum.isNumber(dto.getFieldTypeCode())) {
            //数值和数值区间类型，单位不能为空
            if (BooleanUtils.isEmpty(dto.getUnit()))
                throw new BaseException(CodeConstant.CODE_1220002);
        }
        if (AccessEnum.PART.getValue().equals(dto.getAccess())) {
            //选择部分可见，需要选择角色
            if (BooleanUtils.isEmpty(dto.getRoleIds()))
                throw new BaseException(CodeConstant.CODE_1220008);
        }
        if (FieldTypeEnum.isSelection(dto.getFieldTypeCode())) {
            if (BooleanUtils.isEmpty(dto.getSelectionsBean()))
                throw new BaseException(CodeConstant.CODE_1220009);
        }
        log.end();
    }

    /**
     * 检查名名称是否存在
     *
     * @param name 名称
     */
    private boolean checkNameForAdd(String name) throws BaseException {
        log.begin(name);
        List<ObjectFieldPageResDto> datas = objectFieldMapper.selectByName(name, null);
        log.info("datas:%s", JsonUtils.objectToJson(datas));
        return BooleanUtils.isEmpty(datas);
    }

    /**
     * 检查名名称是否存在
     *
     * @param name 名称
     */
    private boolean checkNameForUpdate(String name, Long id) throws BaseException {
        log.begin(name, id);
        List<ObjectFieldPageResDto> datas = objectFieldMapper.selectByName(name, id);
        log.info("datas:%s", JsonUtils.objectToJson(datas));
        return BooleanUtils.isEmpty(datas);
    }

    /**
     * 数值、数值区间类业务对象添加
     *
     * @param fieldId 对象字段id
     * @param unit    单位
     */
    private void addNumberKind(Long fieldId, String unit) throws BaseException {
        BaseNumberConfig numberConf = new BaseNumberConfig();
        super.initialModel(numberConf);
        numberConf.setObjectFieldId(fieldId);
        numberConf.setUnit(unit);
        numberConf.setDecimalLength(4);
        //TODO 少了个最小值
        baseNumberConfigMapper.insertSelective(numberConf);
    }

    /**
     * 数值、数值区间类业务对象修改
     *
     * @param fieldId 对象字段id
     * @param unit    单位
     */
    private void updateNumberKind(Long fieldId, String unit) throws BaseException {
        log.begin(fieldId, unit);
        BaseNumberConfigExample numberConfigExample = new BaseNumberConfigExample();
        numberConfigExample.createCriteria().andObjectFieldIdEqualTo(fieldId);
        BaseNumberConfig numberConfig = baseNumberConfigMapper.selectOne(numberConfigExample);
        log.info("numberConfig:%s", JsonUtils.objectToJson(numberConfig));
        if (!numberConfig.getUnit().equals(unit)) {
            super.updateModel(numberConfig);
            numberConfig.setUnit(unit);
            baseNumberConfigMapper.updateByPrimaryKeySelective(numberConfig);
        }
        log.end();
    }

    /**
     * 选项类业务对象字段添加
     *
     * @param fieldId    对象字段id
     * @param selections 选项配置列表
     */
    private void addSelectionKind(Long fieldId, List<SelectionDto> selections) throws BaseException {
        log.begin(fieldId, selections);
        int index = 0;
        BaseSelectConfigExample selectConfigExample = new BaseSelectConfigExample();
        selectConfigExample.createCriteria().andObjectFieldIdEqualTo(fieldId);
        selectConfigExample.setOrderByClause("value Desc");
        BaseSelectConfig topOne = baseSelectConfigMapper.selectOne(selectConfigExample);
        if (topOne != null)
            index = topOne.getValue() + 1;
        for (SelectionDto selection : selections) {
            BaseSelectConfig selectConfig = new BaseSelectConfig();
            super.initialModel(selectConfig);
            selectConfig.setObjectFieldId(fieldId);
            selectConfig.setValue(index);
            selectConfig.setLabel(selection.getLabel());
            selectConfig.setSequence(selection.getSequence());
            selectConfig.setIsSystem(YesOrNoEnum.NO.getValue());
            baseSelectConfigMapper.insertSelective(selectConfig);
            index++;
        }
        log.end();
    }

    /**
     * 默认业务对象字段类添加
     *
     * @param fieldId 对象字段id
     * @param dto     业务对象字段实体数据
     */
    private void addDefaultKind(Long fieldId, ObjectFieldAddReqDto dto) throws BaseException {
        BaseFieldConfig fieldConf = new BaseFieldConfig();
        super.initialModel(fieldConf);
        fieldConf.setObjectFieldId(fieldId);
        fieldConf.setMaxLength(200);
        fieldConf.setMinLength(MandatoryEnum.REQUIRED.getValue().equals(dto.getIsMandatory()) ? 1 : 0);

        baseFieldConfigMapper.insertSelective(fieldConf);
    }

    /**
     * 如果“是否通用”项选择-“公用”，需要关联到所有对应的业务对象分组
     *
     * @param fieldid 业务对象字段id
     */
    private void updateShareFields(Long fieldid, Long boId) throws BaseException {
        log.begin(fieldid);
        //先查询出所有的业务对象分组
        BaseFieldGroupExample fieldGroupExample = new BaseFieldGroupExample();
        fieldGroupExample.createCriteria().andBusinessObjectIdEqualTo(boId);
        List<BaseFieldGroup> groups = baseFieldGroupMapper.selectByExample(fieldGroupExample);
        log.info("groups:%s", JsonUtils.objectToJson(groups));

        if (BooleanUtils.isEmpty(groups))
            return;

        BaseFieldGroupRelExample fieldGroupRelExample = new BaseFieldGroupRelExample();
        fieldGroupRelExample.createCriteria().andFieldGroupIdIn(LambdaMap.toSingleList(groups, BaseModel::getId)).andObjectFieldIdEqualTo(fieldid);
        List<BaseFieldGroupRel> oriRels = baseFieldGroupRelMapper.selectByExample(fieldGroupRelExample);

        for (BaseFieldGroup group : groups) {
            if (LambdaFilter.firstOrDefault(oriRels, m -> m.getFieldGroupId().equals(group.getId())) != null)
                continue;
            BaseFieldGroupRel rel = new BaseFieldGroupRel();
            super.initialModel(rel);
            rel.setFieldGroupId(group.getId());
            rel.setObjectFieldId(fieldid);
            rel.setSequence(NumberEnum.ONE.getValue());
            baseFieldGroupRelMapper.insertSelective(rel);
        }
        log.end();
    }

    /**
     * 当“通用”修改为“非通用”是，需要删除掉字段和分组的关系
     *
     * @param fieldid 业务字段id
     */
    private void updateUnShareFields(Long fieldid) throws BaseException {
        log.begin(fieldid);
        BaseFieldGroupRelExample fieldGroupRelExample = new BaseFieldGroupRelExample();
        fieldGroupRelExample.createCriteria().andObjectFieldIdEqualTo(fieldid);
        List<BaseFieldGroupRel> oriRels = baseFieldGroupRelMapper.selectByExample(fieldGroupRelExample);
        for (BaseFieldGroupRel oriRel : oriRels) {
            oriRel.setIsDelete(DeleteEnum.DELETED.getValue());
            super.updateModel(oriRel);
            baseFieldGroupRelMapper.updateByPrimaryKeySelective(oriRel);
        }
        log.end();
    }

    /**
     * 如果选择“部分可见”，需要关联角色
     *
     * @param fieldId    业务对象字段id
     * @param roleIdsStr 角色id多个逗号分隔
     */
    private void addFieldRole(Long fieldId, String roleIdsStr) throws BaseException {
        log.begin(fieldId, roleIdsStr);
        if (BooleanUtils.isEmpty(roleIdsStr))
            throw new BaseException(CodeConstant.CODE_1220008);
        List<String> idsStr = SymbolStrUtils.toList(roleIdsStr);
        List<Long> roleIds = new ArrayList<>();
        idsStr.forEach(m -> roleIds.add(Long.valueOf(m)));

        BaseFieldRoleExample baseFieldRoleExample = new BaseFieldRoleExample();
        baseFieldRoleExample.createCriteria().andObjectFieldIdEqualTo(fieldId);
        List<BaseFieldRole> fieldRoles = baseFieldRoleMapper.selectByExample(baseFieldRoleExample);
        log.info("fieldRoles:%s", JsonUtils.objectToJson(fieldRoles));
        //需要删除的
        List<BaseFieldRole> needDelete = new ArrayList<>();
        for (BaseFieldRole fieldRole : fieldRoles) {
            Long roleId = LambdaFilter.firstOrDefault(roleIds, m -> m.equals(fieldRole.getRoleId()));
            if (roleId == null)
                needDelete.add(fieldRole);
        }
        if (BooleanUtils.isNotEmpty(needDelete))
            this.deleteFieldRole(needDelete);
        //需要添加的

        for (Long roleId : roleIds) {
            if (LambdaFilter.firstOrDefault(fieldRoles, m -> m.getRoleId().equals(roleId)) != null)
                continue;
            BaseFieldRole fieldRole = new BaseFieldRole();
            super.initialModel(fieldRole);
            fieldRole.setObjectFieldId(fieldId);
            fieldRole.setRoleId(roleId);
            fieldRole.setIsRoleReadonly(YesOrNoEnum.NO.getValue());
            fieldRole.setIsRoleAccess(YesOrNoEnum.YES.getValue());
            baseFieldRoleMapper.insertSelective(fieldRole);
        }
        log.end();
    }

    /**
     * 从“部分可见”-》“全部可见”，将字段角色删除
     *
     * @param fieldId 业务对象字段id
     */
    private void updateFieldRole(Long fieldId) throws BaseException {
        log.begin(fieldId);
        BaseFieldRoleExample baseFieldRoleExample = new BaseFieldRoleExample();
        baseFieldRoleExample.createCriteria().andObjectFieldIdEqualTo(fieldId);
        List<BaseFieldRole> fieldRoles = baseFieldRoleMapper.selectByExample(baseFieldRoleExample);
        this.deleteFieldRole(fieldRoles);
    }

    /**
     * 删除字段与角色关系
     */
    private void deleteFieldRole(List<BaseFieldRole> fieldRoles) throws BaseException {
        log.info("fieldRoles:%s", JsonUtils.objectToJson(fieldRoles));
        for (BaseFieldRole fieldRole : fieldRoles) {
            fieldRole.setIsDelete(DeleteEnum.DELETED.getValue());
            super.updateModel(fieldRole);
            baseFieldRoleMapper.updateByPrimaryKeySelective(fieldRole);
        }
        log.end();
    }

    /**
     * 追加选项类配置
     *
     * @param fieldId    业务对象字段id
     * @param selections 选项配置列表
     */
    private void addSelectionFiedlConfig(Long fieldId, List<SelectionDto> selections) throws BaseException {
        log.begin(fieldId, selections);
        if (BooleanUtils.isEmpty(selections))
            return;
        List<SelectionDto> needAddDtos = LambdaFilter.toList(selections, m -> m.getId() == null);
        log.info("needAddDtos:%s", JsonUtils.objectToJson(needAddDtos));
        if (BooleanUtils.isEmpty(needAddDtos))
            return;
        this.addSelectionKind(fieldId, needAddDtos);
    }

    /**
     * 更新选项类配置
     *
     * @param fieldId    业务对象字段id
     * @param selections 选项配置列表
     */
    private void updateSelectionFieldConfig(Long fieldId, List<SelectionDto> selections) throws BaseException {
        log.begin(fieldId, selections);
        BaseSelectConfigExample baseSelectConfigExample = new BaseSelectConfigExample();
        baseSelectConfigExample.createCriteria().andObjectFieldIdEqualTo(fieldId);
        List<BaseSelectConfig> oriSelectConfigs = baseSelectConfigMapper.selectByExample(baseSelectConfigExample);

        for (BaseSelectConfig oriConf : oriSelectConfigs) {
            SelectionDto newConf = LambdaFilter.firstOrDefault(selections, m -> m.getId().equals(oriConf.getId()));
            if (newConf != null) {
                oriConf.setSequence(newConf.getSequence());
                oriConf.setLabel(newConf.getLabel());
            } else {
                //如果不存在了，表示已删除
                oriConf.setIsDelete(DeleteEnum.DELETED.getValue());
            }
            baseSelectConfigMapper.updateByPrimaryKeySelective(oriConf);
        }
        log.end();
    }

}
