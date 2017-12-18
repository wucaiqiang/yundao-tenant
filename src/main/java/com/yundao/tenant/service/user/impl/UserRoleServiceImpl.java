package com.yundao.tenant.service.user.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.user.role.UserRoleDto;
import com.yundao.tenant.dto.user.role.UserRoleInsertOrUpdateDto;
import com.yundao.tenant.dto.user.role.UserRolePageReqDto;
import com.yundao.tenant.dto.user.role.UserRolePageResDto;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.enums.ExamineGroupEnum;
import com.yundao.tenant.mapper.base.BaseUserRoleMapper;
import com.yundao.tenant.mapper.resource.ResourceMapper;
import com.yundao.tenant.mapper.user.UserMapper;
import com.yundao.tenant.mapper.user.UserRoleMapper;
import com.yundao.tenant.model.base.BaseUserRole;
import com.yundao.tenant.model.base.BaseUserRoleExample;
import com.yundao.tenant.service.user.UserRoleService;
import com.yundao.tenant.service.workflow.WorkFlowGroupUserService;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户角色管理
 *
 * @author 欧阳利
 *         2017年6月22日
 */
@Service
public class UserRoleServiceImpl extends AbstractService implements UserRoleService {

    @Autowired
    BaseUserRoleMapper baseUserRoleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    ResourceMapper resourceMapper;

    @Autowired
    WorkFlowGroupUserService workFlowGroupUserService;

    /**
     * 添加用户的角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    public Integer insertUserRole(UserRoleInsertOrUpdateDto dto) throws BaseException {
        Integer count = insertUserRoleRef(dto);
        // 修改后拥有的资源
        List<String> newResourceCodes = resourceMapper.getResourceCodes(dto.getUserId(), ExamineGroupEnum.getAllResourceCodeAll());

        // 通知工作流
        workFlowGroupUserService.addUserRole(dto.getUserId(), newResourceCodes);
        return count;
    }


    /**
     * 添加用户的角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    private Integer insertUserRoleRef(UserRoleInsertOrUpdateDto dto) {
        if (BooleanUtils.isEmpty(dto.getRoleIds())) {
            return 0;
        }
        for (Long roleId : dto.getRoleIds()) {
            BaseUserRole userRole = new BaseUserRole();
            userRole.setCreateDate(new Date());
            userRole.setCreateUserId(dto.getCreateUserId());
            userRole.setRoleId(roleId);
            userRole.setUserAccountId(dto.getUserId());
            userRole.setIsDelete(0);
            userRole.setIsEnabled(EnabledEnum.ENABLED.getValue());
            userRole.setTenantId(dto.getTenantId());
            baseUserRoleMapper.insert(userRole);
        }
        return dto.getRoleIds().size();
    }


    /**
     * 修改用户的角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    public Integer updateUserRole(UserRoleInsertOrUpdateDto dto) throws BaseException {
        // 修改拥有的资源
        List<String> oldResourceCodes = resourceMapper.getResourceCodes(dto.getUserId(), ExamineGroupEnum.getAllResourceCodeAll());

        // 删除现在的所有角色
        BaseUserRoleExample example = new BaseUserRoleExample();
        example.createCriteria().andUserAccountIdEqualTo(dto.getUserId());
        baseUserRoleMapper.deleteByExample(example);

        // 添加新角色
        dto.setCreateUserId(dto.getUpdateUserId());
        Integer count = insertUserRoleRef(dto);

        // 修改后拥有的资源
        List<String> newResourceCodes = resourceMapper.getResourceCodes(dto.getUserId(), ExamineGroupEnum.getAllResourceCodeAll());

        // 通知工作流
        workFlowGroupUserService.updateUserRole(dto.getUserId(), oldResourceCodes, newResourceCodes);
        return count;
    }

    @Override
    public Result<PaginationSupport<UserRolePageResDto>> getUserRolePage(UserRolePageReqDto dto) throws BaseException {
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        PaginationSupport<UserRolePageResDto> page = PaginationSupport.newDefault(paramMap);
        List<UserRolePageResDto> dtos = userMapper.getUserRolePage(paramMap);
        int count = userMapper.getUserRolePageCount(paramMap);
        page.setDatas(dtos);
        page.setTotalCount(count);
        return Result.newSuccessResult(page);
    }


    /**
     * 查询用户角色信息
     *
     * @param userId
     * @return
     */
    public List<UserRoleDto> selectUserRoles(List<Long> userIds) {
        if (BooleanUtils.isEmpty(userIds)) {
            return null;
        }
        return userRoleMapper.selectUserRoles(userIds);
    }

    /**
     * 通过用户id查询角色id集合
     *
     * @param userId
     * @return
     */
    public List<Long> selectRoleIdsByUserId(Long userId) {
        List<Long> roleIds = new ArrayList<Long>();
        if (userId == null) {
            return roleIds;
        }
        BaseUserRoleExample example = new BaseUserRoleExample();
        example.createCriteria().andUserAccountIdEqualTo(userId);
        List<BaseUserRole> list = baseUserRoleMapper.selectByExample(example);
        if (BooleanUtils.isEmpty(list)) {
            return roleIds;
        }
        for (BaseUserRole model : list) {
            if (!roleIds.contains(model.getRoleId())) {
                roleIds.add(model.getRoleId());
            }
        }
        return roleIds;
    }


    /**
     * 用户角色id查询在职用户id
     *
     * @param userId
     * @return
     */
    public List<Long> selectUserIdsByRoleId(Long roleId) {
        if (roleId == null) {
            return null;
        }
        return userRoleMapper.selectUserIdsByRoleId(roleId);
    }

    @Override
    public List<Long> getUserIdByRole(Long roleId) throws BaseException {
        BaseUserRoleExample urExample = new BaseUserRoleExample();
        urExample.createCriteria().andRoleIdEqualTo(roleId);
        List<BaseUserRole> userRoles = baseUserRoleMapper.selectByExample(urExample);
        List<Long> ids = new ArrayList<>();
        if (BooleanUtils.isEmpty(userRoles))
            return ids;
        return LambdaMap.toSingleList(userRoles, m -> m.getUserAccountId());
    }
}
