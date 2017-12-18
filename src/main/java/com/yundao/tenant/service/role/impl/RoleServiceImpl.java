package com.yundao.tenant.service.role.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.common.IdNameDto;
import com.yundao.tenant.dto.dataobject.DataObjectReqDto;
import com.yundao.tenant.dto.role.RoleDetailResDto;
import com.yundao.tenant.dto.role.RoleReqDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.access.OperationPermissionEnum;
import com.yundao.tenant.mapper.base.*;
import com.yundao.tenant.model.base.*;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.dataobject.DataObjectService;
import com.yundao.tenant.service.role.RoleService;
import com.yundao.tenant.service.user.UserRoleService;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 角色服务实现类
 *
 * @author jan
 * @create 2017-06-22 PM4:02
 **/
@Service
public class RoleServiceImpl extends AbstractService implements RoleService {

    private static Log log = LogFactory.getLog(RoleServiceImpl.class);

    @Autowired
    private BaseRoleMapper baseRoleMapper;

    @Autowired
    private BaseUserRoleMapper baseUserRoleMapper;

    @Autowired
    private BaseRoleResourceMapper baseRoleResourceMapper;

    @Autowired
    private BaseUserStaffMapper baseUserStaffMapper;

    @Autowired
    private BaseDataObjectInitMapper baseDataObjectInitMapper;

    @Autowired
    private BaseDataObjectAccessMapper baseDataObjectAccessMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private DataObjectService dataObjectService;

    @Override
    public Result<Long> insert(RoleReqDto dto) throws BaseException {
        log.begin(dto);
        if (this.checkExistName(dto.getName(), null))
            throw new BaseException(CodeConstant.CODE_1220018);
        BaseRole role = super.initialModel(new BaseRole());
        BeanUtils.copyProperties(dto, role);
        role.setTenantId(super.getHeaderTenantId());
        role.setParentId(0L);
        role.setSequence(9999);
        role.setIsSystem(YesOrNoEnum.NO.getValue());
        baseRoleMapper.insertSelective(role);
        log.info("add user id:%s", role.getId());

        //同时初始化数据权限
        this.doInitialDataPermission(role.getId());

        log.end();
        return Result.newSuccessResult(role.getId());
    }

    @Override
    public Result<Long> update(RoleReqDto dto) throws BaseException {
        log.begin(dto);
        if (this.checkExistName(dto.getName(), dto.getId()))
            throw new BaseException(CodeConstant.CODE_1220018);
        BaseRole role = baseRoleMapper.selectByPrimaryKey(dto.getId());
        this.checkEntityNotNull(role);
        BeanUtils.copyProperties(dto, role);
        super.updateModel(role);
        int result = baseRoleMapper.updateByPrimaryKeySelective(role);
        log.info("update user result:%s", result);
        log.end();
        return Result.newSuccessResult(dto.getId());
    }

    @Override
    public BaseRole get(Long id) throws BaseException {
        return baseRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result<RoleDetailResDto> getById(Long id) throws BaseException {
        log.begin(id);
        if (id == null)
            throw new BaseException(CodeConstant.CODE_1200000);
        BaseRole role = this.get(id);
        this.checkEntityNotNull(role);
        RoleDetailResDto dto = new RoleDetailResDto();
        BeanUtils.copyProperties(role, dto);
        log.end();
        return Result.newSuccessResult(dto);
    }

    @Override
    public List<IdNameDto> getByUserId(Long userId) throws BaseException {
        log.begin(userId);
        BaseUserRoleExample userRoleExample = new BaseUserRoleExample();
        userRoleExample.createCriteria().andUserAccountIdEqualTo(userId);
        List<BaseUserRole> userRoles = baseUserRoleMapper.selectByExample(userRoleExample);
        if (BooleanUtils.isEmpty(userRoles))
            return null;
        BaseRoleExample roleExample = new BaseRoleExample();
        roleExample.createCriteria().andIdIn(LambdaMap.toSingleList(userRoles, BaseUserRole::getRoleId));
        List<BaseRole> roles = baseRoleMapper.selectByExample(roleExample);
        log.info("roles:%s", JsonUtils.objectToJson(roles));
        log.end();
        return LocalBeanUtils.copyPropertiesList(roles, IdNameDto.class);

    }

    @Override
    public Result<List<RoleDetailResDto>> gets() throws BaseException {
        BaseRoleExample roleExample = new BaseRoleExample();
        roleExample.createCriteria().andTenantIdEqualTo(super.getHeaderTenantId());
        roleExample.setOrderByClause("sequence ASC");
        List<BaseRole> roles = baseRoleMapper.selectByExample(roleExample);
        return Result.newSuccessResult(LocalBeanUtils.copyPropertiesList(roles, RoleDetailResDto.class));
    }

    @Override
    public Result<List<Long>> getsByUserId() throws BaseException {
        List<Long> roleIds = userRoleService.selectRoleIdsByUserId(this.getHeaderUserId());
        return Result.newSuccessResult(roleIds);
    }

    @Override
    public Result<Boolean> delete(Long id) throws BaseException {
        log.begin(id);
        if (!this.deletionCheck(id))
            throw new BaseException(CodeConstant.CODE_1200008);
        BaseRole role = baseRoleMapper.selectByPrimaryKey(id);
        this.checkEntityNotNull(role);
        log.info("user:%s", JsonUtils.objectToJson(role));
        if (role.getIsSystem().equals(YesOrNoEnum.YES.getValue()))
            throw new BaseException(CodeConstant.CODE_1220027);
        // 将角色资源表关联数据设置为删除
        BaseRoleResourceExample rrExample = new BaseRoleResourceExample();
        rrExample.createCriteria().andRoleIdEqualTo(id);
        List<BaseRoleResource> roleResources = baseRoleResourceMapper.selectByExample(rrExample);
        log.info("roleResources:%s", JsonUtils.objectToJson(roleResources));
        if (BooleanUtils.isNotEmpty(roleResources)) {
            for (BaseRoleResource roleResource : roleResources) {
                roleResource.setIsDelete(1);
                baseRoleResourceMapper.updateByPrimaryKeySelective(roleResource);
            }
        }
        role.setIsDelete(1);
        baseRoleMapper.updateByPrimaryKeySelective(role);
        this.removeDimissionUser(id);
        //同时删除 数据权限
        this.deleteDataPermission(id);
        //同时删除 资源
        this.deleteReousrce(id);
        log.end();
        return Result.newSuccessResult();
    }

    @Override
    public void checkNotNullAndTerminal(Long id) throws BaseException {
        log.begin(id);
        BaseRole role = baseRoleMapper.selectByPrimaryKey(id);
        if (role == null)
            throw new BaseException(CodeConstant.CODE_1200003);
    }

    @Override
    public void checkNotNullAndTerminal(BaseRole role) throws BaseException {
        if (role == null)
            throw new BaseException(CodeConstant.CODE_1200003);
    }


    /**
     * 检查角色是否存在
     */
    @Override
    public boolean checkRolesExist(List<Long> roleIds) throws BaseException {
        if (BooleanUtils.isEmpty(roleIds)) {
            return true;
        }
        BaseRoleExample example = new BaseRoleExample();
        example.createCriteria().andIdIn(roleIds);
        List<BaseRole> list = baseRoleMapper.selectByExample(example);
        for (Long roleId : roleIds) {
            boolean isExist = false;
            for (BaseRole role : list) {
                if (roleId.equals(role.getId())) {
                    isExist = true;
                }
            }
            if (!isExist) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断角色是否是否
     *
     * @param model 角色实体
     * @throws BaseException 异常信息
     */
    private void checkEntityNotNull(BaseRole model) throws BaseException {
        if (model == null)
            throw new BaseException(CodeConstant.CODE_1200003);
    }

    /**
     * 检查是否可以删除
     *
     * @param id 角色id
     * @return 检查结果
     * @throws BaseException 异常信息
     */
    private Boolean deletionCheck(Long id) throws BaseException {
        // 确保该角色下没有关联用户才可删除
        BaseUserRoleExample urExample = new BaseUserRoleExample();
        urExample.createCriteria().andRoleIdEqualTo(id);
        List<BaseUserRole> userRoles = baseUserRoleMapper.selectByExample(urExample);
        if (BooleanUtils.isEmpty(userRoles))
            return true;
        // 检查该角色下是否存在非离职用户
        BaseUserStaffExample usExample = new BaseUserStaffExample();
        usExample.createCriteria().andUserAccountIdIn(LambdaMap.toSingleList(userRoles, m -> m.getUserAccountId()))
                .andIsDimissionEqualTo(YesOrNoEnum.NO.getValue());
        int count = baseUserStaffMapper.countByExample(usExample);
        return count <= 0;
    }

    /**
     * 移除角色与离职用户的关联
     *
     * @param id 角色id
     */
    private void removeDimissionUser(Long id) throws BaseException {
        log.begin(id);
        BaseUserRoleExample urExample = new BaseUserRoleExample();
        urExample.createCriteria().andRoleIdEqualTo(id);
        List<BaseUserRole> userRoles = baseUserRoleMapper.selectByExample(urExample);
        if (BooleanUtils.isEmpty(userRoles))
            return;
        // 获取该角色下离职用户
        BaseUserStaffExample usExample = new BaseUserStaffExample();
        usExample.createCriteria().andUserAccountIdIn(LambdaMap.toSingleList(userRoles, m -> m.getUserAccountId()))
                .andIsDimissionEqualTo(YesOrNoEnum.YES.getValue());
        List<BaseUserStaff> userStaffs = baseUserStaffMapper.selectByExample(usExample);
        if (BooleanUtils.isEmpty(userStaffs))
            return;
        // 移除角色与离职用户的关联
        for (BaseUserStaff userStaff : userStaffs) {
            BaseUserRole userRole = LambdaFilter.firstOrDefault(userRoles,
                    m -> m.getUserAccountId().equals(userStaff.getUserAccountId()));
            super.updateModel(userRole);
            userRole.setIsDelete(DeleteEnum.DELETED.getValue());
            baseUserRoleMapper.updateByPrimaryKeySelective(userRole);
        }
        log.end();
    }

    /**
     * 检查角色名是否已存在
     *
     * @param name   角色名称
     * @param selfId 如果是修改操作，修改的角色id，添加操作传入NULL
     */
    private Boolean checkExistName(String name, Long selfId) throws BaseException {
        BaseRoleExample example = new BaseRoleExample();
        BaseRoleExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        if (selfId != null)
            criteria.andIdNotEqualTo(selfId);
        int count = baseRoleMapper.countByExample(example);
        return count > 0;
    }

    /**
     * 添加角色时，初始化数据对象
     *
     * @param roleId 角色id
     */
    private void doInitialDataPermission(Long roleId) throws BaseException {
        log.begin(roleId);
        //获取初始化的数据权限
        BaseDataObjectInitExample doInitExample = new BaseDataObjectInitExample();
        doInitExample.createCriteria().andIsCheckEqualTo(YesOrNoEnum.YES.getValue());
        List<BaseDataObjectInit> doInitDatas = baseDataObjectInitMapper.selectByExample(doInitExample);
        log.info("doInitDatas:%s", JsonUtils.objectToJson(doInitDatas));
        List<DataObjectReqDto> reqDtos = new ArrayList<>();

        Map<Long, List<BaseDataObjectInit>> initialGroupby = doInitDatas.stream().collect(Collectors.groupingBy(g -> g.getDataObjectId()));
        for (Map.Entry<Long, List<BaseDataObjectInit>> entry : initialGroupby.entrySet()) {
            DataObjectReqDto reqDto = new DataObjectReqDto();
            List<BaseDataObjectInit> dataObjectInits = entry.getValue();
            BaseDataObjectInit readDo = LambdaFilter.firstOrDefault(dataObjectInits, m -> OperationPermissionEnum.READ.getValue().equals(m.getOperation()));
            BaseDataObjectInit editDo = LambdaFilter.firstOrDefault(dataObjectInits, m -> OperationPermissionEnum.EDIT.getValue().equals(m.getOperation()));
            BaseDataObjectInit deleteDo = LambdaFilter.firstOrDefault(dataObjectInits, m -> OperationPermissionEnum.DELETE.getValue().equals(m.getOperation()));
            if (readDo != null)
                reqDto.setRead(readDo.getPermission());
            if (editDo != null)
                reqDto.setUpdate(editDo.getPermission());
            if (deleteDo != null)
                reqDto.setDelete(deleteDo.getPermission());
            reqDto.setId(entry.getKey());
            reqDtos.add(reqDto);
        }
        log.end();
        dataObjectService.update(roleId, reqDtos);
    }

    /**
     * 删除角色，同时删除对应的数据权限
     *
     * @param roleId 角色id
     */
    private void deleteDataPermission(Long roleId) throws BaseException {
        log.begin(roleId);
        BaseDataObjectAccessExample doaExample = new BaseDataObjectAccessExample();
        doaExample.createCriteria().andRoleIdEqualTo(roleId);
        List<BaseDataObjectAccess> datas = baseDataObjectAccessMapper.selectByExample(doaExample);
        log.info("dataObjectAcesses:%s", JsonUtils.objectToJson(datas));
        if (BooleanUtils.isEmpty(datas))
            return;
        for (BaseDataObjectAccess data : datas) {
            data.setIsDelete(DeleteEnum.DELETED.getValue());
            baseDataObjectAccessMapper.updateByPrimaryKeySelective(data);
        }
        log.end();
    }

    /**
     * 删除角色，同时删除对应的资源
     *
     * @param roleId 角色id
     */
    private void deleteReousrce(Long roleId) throws BaseException {
        log.begin(roleId);
        BaseRoleResourceExample example = new BaseRoleResourceExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<BaseRoleResource> roleResources = baseRoleResourceMapper.selectByExample(example);
        log.info("roleResources:%s", JsonUtils.objectToJson(roleResources));
        if (BooleanUtils.isEmpty(roleResources))
            return;
        for (BaseRoleResource roleResource : roleResources) {
            roleResource.setIsDelete(DeleteEnum.DELETED.getValue());
            baseRoleResourceMapper.updateByPrimaryKeySelective(roleResource);
        }
        log.end();
    }


}
