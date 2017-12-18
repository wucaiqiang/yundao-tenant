package com.yundao.tenant.service.resource.impl;

import com.yundao.core.code.Result;
import com.yundao.core.enums.NumberEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.resource.AuthResDto;
import com.yundao.tenant.dto.resource.MenuResDto;
import com.yundao.tenant.dto.resource.ResourceResDto;
import com.yundao.tenant.dto.resource.UserResDto;
import com.yundao.tenant.dto.user.UserInfoDto;
import com.yundao.tenant.enums.ExamineGroupEnum;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.mapper.base.BaseResourceMapper;
import com.yundao.tenant.mapper.base.BaseRoleResourceMapper;
import com.yundao.tenant.mapper.base.BaseUserRoleMapper;
import com.yundao.tenant.mapper.resource.ResourceMapper;
import com.yundao.tenant.model.base.*;
import com.yundao.tenant.service.resource.ResourceCacheService;
import com.yundao.tenant.service.resource.ResourceService;
import com.yundao.tenant.service.role.RoleService;
import com.yundao.tenant.service.role.resource.RoleResourceService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.service.workflow.WorkFlowGroupUserService;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 权限资源服务实现类
 *
 * @author jan
 * @create 2017-06-23 PM4:25
 **/
@Service
public class ResourceServiceImpl extends AbstractService implements ResourceService {

    private static Log log = LogFactory.getLog(ResourceServiceImpl.class);

    @Autowired
    private BaseResourceMapper baseResourceMapper;

    @Autowired
    private BaseUserRoleMapper baseUserRoleMapper;

    @Autowired
    private BaseRoleResourceMapper baseRoleResourceMapper;

    @Autowired
    private RoleResourceService roleResourceService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    WorkFlowGroupUserService workFlowGroupUserService;

    @Autowired
    private ResourceCacheService resourceCacheService;

    /**
     * 查询拥有该资源的在职用户 getUserIds:
     *
     * @param resourceCode
     * @return
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    public List<Long> getUserIds(String resourceCode) throws BaseException {
        List<String> resCodes = new ArrayList<String>();
        resCodes.add(resourceCode);
        List<UserResDto> newUserResDtos = resourceMapper.getUserResDtos(resCodes);

        if (BooleanUtils.isEmpty(newUserResDtos)) {
            return null;
        }
        List<Long> userIds = new ArrayList<Long>();
        for (UserResDto dto : newUserResDtos) {
            userIds.add(dto.getUserId());
        }
        return userIds;
    }


    @Override
    public Result<List<MenuResDto>> getsByRoleId(Long roleId) throws BaseException {
        log.begin(roleId);
        roleService.checkNotNullAndTerminal(roleId);
        // 查询租户所有的资源列表
        BaseResourceExample example = new BaseResourceExample();
        //TODO 临时删除 “我的客户”，“全部客户”，v1.2版本之后要处理
        String tempIds = "23,43,44,71,24,46,47,48,50,70";
        List<Long> tempDelList = SymbolStrUtils.toLong(tempIds);
        example.createCriteria().andIdNotIn(tempDelList);
        List<BaseResource> baseResources = baseResourceMapper.selectByExample(example);
        ArrayList<MenuResDto> resources = new ArrayList<>();
        for (BaseResource item : baseResources) {
            MenuResDto dto = new MenuResDto();
            BeanUtils.copyProperties(item, dto);
            dto.setPath(item.getUrl());
            resources.add(dto);
        }
        // 勾选该角色拥有的资源
        this.checkRoleResource(resources, roleId);
        // 转换成树形结构
        List<MenuResDto> sourceTree = this.convertResourceTree(resources);
        // 排序
        List<MenuResDto> dtos = sort(sourceTree);
        log.end();
        return Result.newSuccessResult(dtos);
    }

    @Override
    public Result<Integer> updateRoleResource(String resourcesIds, Long roleId) throws BaseException {
        log.begin(resourcesIds, roleId);
        List<UserResDto> oldUserResDtos = resourceMapper.getUserResDtos(ExamineGroupEnum.getAllResourceCodeAll());
        BaseRole role = roleService.get(roleId);
        roleService.checkNotNullAndTerminal(role);

        //如果是超级管理员角色，“系统管理”菜单不能被删除
        if (role.getIsSystem().equals(YesOrNoEnum.YES.getValue())) {
            List<Long> systemMgrResourceIdIds = resourceMapper.selectSystemMgrResourceId();
            if (BooleanUtils.isNotEmpty(systemMgrResourceIdIds)) {
                List<Long> ids = SymbolStrUtils.toLong(resourcesIds);
                if (BooleanUtils.isNotEmpty(ids))
                    ids.addAll(systemMgrResourceIdIds);
                else
                    ids = systemMgrResourceIdIds;
                resourcesIds = SymbolStrUtils.longToStr(ids);
            }
        }

        List<BaseResource> resources = new ArrayList<>();

        if (BooleanUtils.isNotEmpty(resourcesIds)) {
            log.info("resourcesIds not null");
            List<Long> ids = SymbolStrUtils.toLong(resourcesIds);
            ids = new ArrayList<>(new HashSet<>(ids));
            BaseResourceExample nerExample = new BaseResourceExample();
            nerExample.createCriteria().andIdIn(ids);
            // 查看是否有不存在的资源
            int resourceCount = baseResourceMapper.countByExample(nerExample);
            if (resourceCount != ids.size())
                throw new BaseException(CodeConstant.CODE_1220037);

            BaseResourceExample resourceExample = new BaseResourceExample();
            resourceExample.createCriteria().andIdIn(ids);
            // 本次操作，为该角色勾选的所有资源
            resources = baseResourceMapper.selectByExample(resourceExample);
        }

        // 该角色原有的资源
        List<BaseRoleResource> roleResourceRels = roleResourceService.getByRoleId(roleId);
        // 本次操作需要为角色增加的资源
        List<BaseRoleResource> addList = new ArrayList<>();
        for (BaseResource resource : resources) {
            BaseRoleResource roleResource = LambdaFilter.firstOrDefault(roleResourceRels,
                    m -> m.getResourceId().equals(resource.getId()));
            if (roleResource == null) {
                // 表示为角色添加了该资源
                roleResource = super.initialModel(new BaseRoleResource());
                roleResource.setResourceId(resource.getId());
                roleResource.setRoleId(roleId);
                roleResource.setSequence(NumberEnum.ZERO.getValue());
                addList.add(roleResource);
            }
        }
        roleResourceService.insert(addList);
        if (BooleanUtils.isEmpty(resources))
            log.info("resources为空，将移除该角色所有资源");

        // 本次操作需要为角色删除的资源
        List<BaseRoleResource> delList = new ArrayList<>();
        for (BaseRoleResource roleResourceRel : roleResourceRels) {
            BaseResource reousrce = null;
            if (BooleanUtils.isNotEmpty(resources))
                reousrce = LambdaFilter.firstOrDefault(resources,
                        m -> m.getId().equals(roleResourceRel.getResourceId()));
            if (reousrce == null) {
                // 表示该资源已经被删除
                delList.add(roleResourceRel);
            }
        }
        roleResourceService.delete(delList);

        Long tenantId = super.getHeaderTenantId();
        resourceCacheService.removeRoleCache(tenantId, roleId);
        resourceCacheService.removeBaseResourceCache(tenantId);

        // 通知工作流
        workFlowGroupUserService.updateRole(oldUserResDtos);
        return Result.newSuccessResult();
    }

    @Override
    public ResourceResDto getUserMenu(Long userId) throws BaseException {
        ResourceResDto result = new ResourceResDto();
        // 查看用户的角色
        BaseUserRoleExample urExample = new BaseUserRoleExample();
        urExample.createCriteria().andUserAccountIdEqualTo(userId);
        List<BaseUserRole> baseUserRoles = baseUserRoleMapper.selectByExample(urExample);
        if (BooleanUtils.isEmpty(baseUserRoles)) {
            log.info("用户：%s 不属于任何角色");
            return result;
        }
        // 查看角色的资源
        List<BaseRoleResource> roleResources = roleResourceService
                .getByRoleIds(LambdaMap.toSingleList(baseUserRoles, BaseUserRole::getRoleId));
        if (BooleanUtils.isEmpty(roleResources)) {
            log.info("用户：%s  没有任何资源", userId);
            return result;
        }

        BaseResourceExample example = new BaseResourceExample();
        example.createCriteria()
                .andIdIn(roleResources.stream().map(BaseRoleResource::getResourceId).collect(Collectors.toList()));
        List<BaseResource> baseResources = baseResourceMapper.selectByExample(example);

        // 找出所有需要显示的菜单
        List<BaseResource> baseMenu = LambdaFilter.toList(baseResources, m -> m.getIsMenu().equals(NumberEnum.ONE.getValue()));
        log.info("baseMenu:%s", JsonUtils.objectToJson(baseMenu));
        if (BooleanUtils.isNotEmpty(baseMenu)) {
            List<MenuResDto> menu = LocalBeanUtils.copyPropertiesList(baseMenu, MenuResDto.class);
            for (MenuResDto menuResDto : menu) {
                menuResDto.setPath(menuResDto.getUrl());
                menuResDto.setDisplay(menuResDto.getIsDeplay() == null ? NumberEnum.ONE.getValue() : menuResDto.getIsDeplay());
            }
            menu.forEach(m -> m.setPath(m.getUrl()));
            // 转换成树形结构
            result.setMenu(this.convertResourceTree(menu));
        }

        // 找出所有功能
        List<BaseResource> baseAuth = LambdaFilter.toList(baseResources,
                m -> m.getIsMenu().equals(NumberEnum.ZERO.getValue()));
        log.info("baseAuth:%s", JsonUtils.objectToJson(baseAuth));
        if (BooleanUtils.isNotEmpty(baseAuth)) {
            List<AuthResDto> auth = LocalBeanUtils.copyPropertiesList(baseAuth, AuthResDto.class);
            auth.forEach(m -> m.setPath(m.getUrl()));
            result.setAuth(auth);
        }
        // 排序
        result.setMenu(sort(result.getMenu()));
        return result;
    }

    @Override
    public List<BaseResource> getUserResources(Long userId) throws BaseException {
        String logPrefix = "资源||获取我的资源||";
        List<BaseResource> emptyList = new ArrayList<>(1);
        log.begin(userId);

        UserInfoDto userInfo = userService.getUserInfo(userId);
        userService.checkNotNullAndTerminal(userId);
        if (userInfo.getIsDimission().equals(YesOrNoEnum.YES.getValue())) {
            log.info("%s用户已离职CODE_1200022", logPrefix);
            return emptyList;
        }

        // 获取用户的所有角色
        BaseUserRoleExample userRoleExample = new BaseUserRoleExample();
        userRoleExample.createCriteria().andUserAccountIdEqualTo(userId);
        List<BaseUserRole> userRoles = baseUserRoleMapper.selectByExample(userRoleExample);
        log.info("userRoles:%s", JsonUtils.objectToJson(userRoles));
        if (BooleanUtils.isEmpty(userRoles)) {
            log.info("%s该用户还没有设置角色CODE_1220025", logPrefix);
            return emptyList;
        }

        // 根据角色获取资源
        BaseRoleResourceExample roleResourceExample = new BaseRoleResourceExample();
        roleResourceExample.createCriteria().andRoleIdIn(LambdaMap.toSingleList(userRoles, m -> m.getRoleId()));
        List<BaseRoleResource> roleResources = baseRoleResourceMapper.selectByExample(roleResourceExample);
        log.info("roleResource:%s", JsonUtils.objectToJson(roleResources));
        if (BooleanUtils.isEmpty(roleResources)) {
            log.info("%s该用户没有任何资源CODE_1220026", logPrefix);
            return emptyList;
        }

        BaseResourceExample example = new BaseResourceExample();
        example.createCriteria().andIdIn(LambdaMap.toSingleList(roleResources, m -> m.getResourceId()));
        List<BaseResource> baseResources = baseResourceMapper.selectByExample(example);
        log.end();
        return baseResources;

    }

    @Override
    public List<MenuResDto> gets() throws BaseException {
        // 查询租户所有的资源列表
        BaseResourceExample example = new BaseResourceExample();
        example.createCriteria();
        List<BaseResource> baseResources = baseResourceMapper.selectByExample(example);
        List<MenuResDto> menuResDtos = LocalBeanUtils.copyPropertiesList(baseResources, MenuResDto.class);
        menuResDtos.forEach(m -> m.setPath(m.getUrl()));
        this.convertResourceTree(menuResDtos);
        // 排序
        List<MenuResDto> dtos = sort(menuResDtos);
        return dtos;
    }

    @Override
    public Result<List<String>> getUserUrls(Long userId) throws BaseException {
        List<BaseResource> resources = this.getUserResources(userId);
        return Result.newSuccessResult(LambdaMap.toSingleList(resources, m -> m.getUrl()));
    }

    /**
     * 获取当前用户的功能权限
     *
     * @return
     * @throws BaseException
     */
    @Override
    public Result<List<AuthResDto>> getCurrentUserAuths() throws BaseException {
        Long userId = this.getHeaderUserId();
        List<AuthResDto> list = resourceMapper.getUserAuths(userId);
        return Result.newSuccessResult(list);
    }


    @Override
    public Result<List<BaseResource>> getsByUserId() throws BaseException {

        Long userId = super.getHeaderUserId();
        // 查看用户的角色
        BaseUserRoleExample urExample = new BaseUserRoleExample();
        urExample.createCriteria().andUserAccountIdEqualTo(userId);
        List<BaseUserRole> baseUserRoles = baseUserRoleMapper.selectByExample(urExample);
        if (BooleanUtils.isEmpty(baseUserRoles)) {
            log.info("用户：%s 不属于任何角色");
            return Result.newSuccessResult(null);
        }
        // 查看角色的资源
        List<BaseRoleResource> roleResources = roleResourceService
                .getByRoleIds(LambdaMap.toSingleList(baseUserRoles, m -> m.getRoleId()));
        if (BooleanUtils.isEmpty(roleResources)) {
            log.info("用户：%s  没有任何资源", userId);
            return Result.newSuccessResult(null);
        }

        BaseResourceExample example = new BaseResourceExample();
        example.createCriteria()
                .andIdIn(roleResources.stream().map(BaseRoleResource::getResourceId).collect(Collectors.toList()));
        List<BaseResource> baseResources = baseResourceMapper.selectByExample(example);

        return Result.newSuccessResult(baseResources);

    }

    @Override
    public List<UserResDto> getUserByCode(String code) throws BaseException {
        List<String> codes = new ArrayList<>(1);
        codes.add(code);
        return resourceMapper.getUserResDtos(codes);
    }

    @Override
    public List<BaseResource> getAll() throws BaseException {
        BaseResourceExample example = new BaseResourceExample();
        example.createCriteria().andUrlIsNotNull().andUrlNotEqualTo("");
        return baseResourceMapper.selectByExample(example);
    }

    /**
     * 排序
     */
    private List<MenuResDto> sort(List<MenuResDto> menuResDtos) {
        List<MenuResDto> dtos = new ArrayList<>();
        List<MenuResDto> parentList = LambdaFilter.toList(menuResDtos, m -> m.getParentId() == 0);
        parentList.sort(Comparator.comparing(MenuResDto::getSequence));
        for (MenuResDto parant : parentList) {
            MenuResDto menuResDto = LambdaFilter.firstOrDefault(menuResDtos, m -> m.getId().equals(parant.getId()));
            dtos.add(menuResDto);
        }
        for (MenuResDto dto : dtos) {
            List<MenuResDto> childs = dto.getChilds();
            if (BooleanUtils.isEmpty(childs))
                continue;
            childs.sort(Comparator.comparing(MenuResDto::getSequence));
            for (MenuResDto child : childs) {
                List<MenuResDto> grandChilds = child.getChilds();
                if (BooleanUtils.isEmpty(grandChilds))
                    continue;
                grandChilds.sort(Comparator.comparing(MenuResDto::getSequence));
                child.setChilds(grandChilds);
            }
            dto.setChilds(childs);
        }
        return dtos;
    }

    /**
     * 转换成树形结构
     *
     * @param resources 资源列表
     * @return 操作结果
     */
    private List<MenuResDto> convertResourceTree(List<MenuResDto> resources) throws BaseException {
        // 新建一个根资源
        MenuResDto root = new MenuResDto();
        root.setId(0L);
        Map<Long, MenuResDto> resourceMap = new HashMap<>(resources.size());
        resources.forEach(m -> resourceMap.put(m.getId(), m));
        // 将新建的根资源与其他资源放一起
        resourceMap.put(root.getId(), root);
        for (Map.Entry<Long, MenuResDto> entry : resourceMap.entrySet()) {
            MenuResDto dto = entry.getValue();
            // 找到父级资源，并加入到他的子资源列表
            MenuResDto parent = resourceMap.get(dto.getParentId());
            if (parent != null)
                parent.getChilds().add(dto);
        }
        return root.getChilds();
    }

    /**
     * 勾选该角色拥有的资源
     *
     * @param sourceTree 资源列表
     * @param roleId     角色id
     */
    private void checkRoleResource(List<MenuResDto> sourceTree, Long roleId) throws BaseException {
        // 获取角色资源关系
        List<BaseRoleResource> roleResources = roleResourceService.getByRoleId(roleId);
        if (BooleanUtils.isEmpty(roleResources)) {
            log.info("该角色没有任何资源 roleId:%s", roleId);
            return;
        }
        for (BaseRoleResource item : roleResources) {
            MenuResDto resource = LambdaFilter.firstOrDefault(sourceTree, m -> m.getId().equals(item.getResourceId()));
            if (resource != null)
                resource.setCheck(NumberEnum.ONE.getValue());
        }
    }
}
