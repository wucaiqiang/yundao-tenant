package com.yundao.tenant.service.dataobject.impl;

import com.yundao.core.enums.NumberEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.common.LabelValueDto;
import com.yundao.tenant.dto.dataobject.DataObjectDetailResDto;
import com.yundao.tenant.dto.dataobject.DataObjectReqDto;
import com.yundao.tenant.dto.dataobject.DataObjectSelectionDto;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.enums.access.OperationPermissionEnum;
import com.yundao.tenant.mapper.base.BaseDataObjectAccessMapper;
import com.yundao.tenant.mapper.base.BaseDataObjectInitMapper;
import com.yundao.tenant.mapper.base.BaseDataObjectMapper;
import com.yundao.tenant.model.base.*;
import com.yundao.tenant.service.dataobject.DataObjectService;
import com.yundao.tenant.service.permission.UserPermissionService;
import com.yundao.tenant.service.role.RoleService;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 数据对象服务实现类
 *
 * @author jan
 * @create 2017-07-15 AM9:39
 **/
@Service
public class DataObjectServiceImpl extends AbstractService implements DataObjectService {

    private static Log log = LogFactory.getLog(DataObjectServiceImpl.class);

    @Autowired
    private BaseDataObjectMapper baseDataObjectMapper;

    @Autowired
    private BaseDataObjectInitMapper baseDataObjectInitMapper;

    @Autowired
    private BaseDataObjectAccessMapper baseDataObjectAccessMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserPermissionService userPermissionService;

    @Override
    public List<DataObjectDetailResDto> gets() throws BaseException {
        String logPrefix = "数据对象||获取所有||";
        log.info("%s 开始", logPrefix);

        List<DataObjectDetailResDto> dtos = new ArrayList<>();

        BaseDataObjectExample dataObectExample = new BaseDataObjectExample();
        dataObectExample.createCriteria();
        dataObectExample.setOrderByClause("sequence ASC");
        List<BaseDataObject> dataObjects = baseDataObjectMapper.selectByExample(dataObectExample);
        log.info("%s dataObjects %s", logPrefix, JsonUtils.objectToJson(dataObjects));
        if (BooleanUtils.isEmpty(dataObjects))
            return dtos;
        List<Long> ids = LambdaMap.toSingleList(dataObjects, m -> m.getId());

        BaseDataObjectInitExample example = new BaseDataObjectInitExample();
        example.createCriteria().andDataObjectIdIn(ids);
        List<BaseDataObjectInit> initDatas = baseDataObjectInitMapper.selectByExample(example);

        for (BaseDataObject dataObject : dataObjects) {
            DataObjectDetailResDto dto = new DataObjectDetailResDto();
            dto.setId(dataObject.getId());
            dto.setCode(dataObject.getCode());
            dto.setName(dataObject.getName());
            dto.setRead(this.getOperationData(initDatas, dataObject.getId(), OperationPermissionEnum.READ.getValue()));
            dto.setUpdate(this.getOperationData(initDatas, dataObject.getId(), OperationPermissionEnum.EDIT.getValue()));
            dto.setDelete(this.getOperationData(initDatas, dataObject.getId(), OperationPermissionEnum.DELETE.getValue()));
            dtos.add(dto);
        }
        log.end();
        return dtos;
    }

    @Override
    public Long update(Long roleId, List<DataObjectReqDto> dtos) throws BaseException {
        log.begin();

        roleService.checkNotNullAndTerminal(roleId);

        BaseDataObjectAccessExample dataObjectAccessExample = new BaseDataObjectAccessExample();
        dataObjectAccessExample.createCriteria().andRoleIdEqualTo(roleId).andDataObjectIdIn(LambdaMap.toSingleList
                (dtos, m -> m.getId()));
        List<BaseDataObjectAccess> dataObjectAccess = baseDataObjectAccessMapper.selectByExample(dataObjectAccessExample);
        for (DataObjectReqDto data : dtos) {
            BaseDataObjectAccess doa = LambdaFilter.firstOrDefault(dataObjectAccess, m -> m
                    .getDataObjectId().equals(data.getId()));
            if (doa == null) {
                //如果没有，添加
                doa = new BaseDataObjectAccess();
                super.initialModel(doa);
                doa.setRoleId(roleId);
                doa.setDataObjectId(data.getId());
                doa.setReadPermission(data.getRead());
                doa.setEditPermission(data.getUpdate());
                doa.setDeletePermission(data.getDelete());
                baseDataObjectAccessMapper.insertSelective(doa);
            } else {
                super.updateModel(doa);
                doa.setReadPermission(data.getRead());
                doa.setEditPermission(data.getUpdate());
                doa.setDeletePermission(data.getDelete());
                baseDataObjectAccessMapper.updateByPrimaryKeySelective(doa);
            }
        }

        //更新用户角色的数据权限
        userPermissionService.clear(super.getHeaderTenantId());
        log.end();
        return roleId;
    }

    @Override
    public List<DataObjectDetailResDto> getByRoleId(Long roleId) throws BaseException {
        String logPrefix = "数据对象||获取角色对应的数据权限||";
        log.info("%s roleid %s", logPrefix, roleId);
        roleService.checkNotNullAndTerminal(roleId);
        //获取原始的数据
        List<DataObjectDetailResDto> dtos = this.gets();
        log.info("%s dtos %s", logPrefix, JsonUtils.objectToJson(dtos));
        if (BooleanUtils.isEmpty(dtos))
            return new ArrayList<>();

        List<Long> ids = LambdaMap.toSingleList(dtos, DataObjectDetailResDto::getId);

        //初始化的数据
        BaseDataObjectInitExample example = new BaseDataObjectInitExample();
        example.createCriteria().andDataObjectIdIn(ids);
        List<BaseDataObjectInit> initDatas = baseDataObjectInitMapper.selectByExample(example);
        //全部设置为无权限
        dtos.forEach(m -> {
            m.getRead().setInitValue(this.getLowPermission(initDatas, m.getId(), OperationPermissionEnum.READ.getValue()));
            m.getUpdate().setInitValue(this.getLowPermission(initDatas, m.getId(), OperationPermissionEnum.EDIT.getValue
                    ()));
            m.getDelete().setInitValue(this.getLowPermission(initDatas, m.getId(), OperationPermissionEnum.DELETE.getValue
                    ()));
        });

        //获取角色的数据对象权限
        BaseDataObjectAccessExample dataObjectAccessExample = new BaseDataObjectAccessExample();
        dataObjectAccessExample.createCriteria().andRoleIdEqualTo(roleId).andDataObjectIdIn(ids);
        List<BaseDataObjectAccess> roleAccess = baseDataObjectAccessMapper.selectByExample(dataObjectAccessExample);


        for (BaseDataObjectAccess access : roleAccess) {
            DataObjectDetailResDto dto = LambdaFilter.firstOrDefault(dtos, m -> m.getId().equals(access.getDataObjectId
                    ()));
            if (dto == null) {
                log.info("getByRoleId：" + JsonUtils.objectToJson(access));
            } else {
                dto.getRead().setInitValue(access.getReadPermission());
                dto.getUpdate().setInitValue(access.getEditPermission());
                dto.getDelete().setInitValue(access.getDeletePermission());
            }
        }
        return dtos;
    }

    /**
     * 根据操作类型和数据对象id 获取权限选项
     *
     * @param initDatas    初始化数据
     * @param dataObjectId 数据对象id
     * @param operation    操作类型
     */
    private DataObjectSelectionDto getOperationData(List<BaseDataObjectInit> initDatas, Long dataObjectId, Integer operation) throws
            BaseException {
        DataObjectSelectionDto dto = new DataObjectSelectionDto();
        List<BaseDataObjectInit> dataObjectInitDatas = LambdaFilter.toList(initDatas, m -> m.getDataObjectId().equals(dataObjectId) && m.getOperation().equals(operation));
        dataObjectInitDatas.sort(Comparator.comparing(BaseDataObjectInit::getSequence));
        for (BaseDataObjectInit dataObjectInitData : dataObjectInitDatas) {
            LabelValueDto lv = new LabelValueDto();
            if (YesOrNoEnum.YES.getValue().equals(dataObjectInitData.getIsCheck()))
                dto.setInitValue(dataObjectInitData.getPermission());
            lv.setValue(dataObjectInitData.getPermission().toString());
            lv.setLabel(DataObjectPermissionEnum.getEnumName(dataObjectInitData.getPermission()));
            dto.getChilds().add(lv);
        }

        return dto;
    }

    /**
     * 获取同一数据对象同一操作下，最低的权限值
     *
     * @param initDatas    初始化数据对象权限数据
     * @param dataObjectId 数据对象id
     * @param operation    操作类型
     */
    private Integer getLowPermission(List<BaseDataObjectInit> initDatas, Long dataObjectId, Integer operation) {
        log.begin();
        List<BaseDataObjectInit> dataObjectInits = LambdaFilter.toList(initDatas, m -> m.getDataObjectId().equals(dataObjectId) && m.getOperation().equals(operation));
        if (BooleanUtils.isEmpty(dataObjectInits))
            return NumberEnum.ZERO.getValue();
        dataObjectInits.sort(Comparator.comparing(BaseDataObjectInit::getPermission));
        return dataObjectInits.get(0).getPermission();
    }

}
