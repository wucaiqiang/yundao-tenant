package com.yundao.tenant.service.permission.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.dto.permission.PermissionDetailResDto;
import com.yundao.tenant.dto.permission.PermissionListReqDto;
import com.yundao.tenant.dto.permission.PermissionListResDto;
import com.yundao.tenant.dto.permission.UserPermissionDto;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.service.permission.BasePermissionService;
import com.yundao.tenant.service.permission.PermissionListService;
import com.yundao.tenant.service.permission.PermissionService;
import com.yundao.tenant.service.permission.UserPermissionService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jan
 * @create 2017-08-05 PM11:46
 **/
@Service
public class PermissionListServiceImpl extends BasePermissionService implements PermissionListService {

    private static Log log = LogFactory.getLog(PermissionListServiceImpl.class);

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserPermissionService userPermissionService;

    @Autowired
    private UserService userService;

    @Override
    public List<PermissionListResDto> checkList(String dataObjectCode, Integer operation, List<Long> ownerIds, Long tenantId, Long userId) throws BaseException {
        log.info(dataObjectCode, operation, ownerIds, userId);
        this.CheckArgsNotNull(dataObjectCode, operation, userId);
        Integer permission = permissionService.get(dataObjectCode, operation, tenantId, userId);
        List<PermissionListResDto> results = new ArrayList<>(1);
        this.processPermission(results, permission, dataObjectCode, ownerIds, userId);
        return results;
    }

    @Override
    public List<PermissionListResDto> checkList(Integer operation, List<PermissionListReqDto> dtos, Long tenantId, Long
            userId) throws
            BaseException {
        List<String> codes = LambdaMap.toSingleList(dtos, m -> m.getDataObjectCode());
        List<PermissionListResDto> results = new ArrayList<>(dtos.size());
        List<UserPermissionDto> userPermissionDtos = this.getUserPermission(codes, tenantId, userId);
        for (PermissionListReqDto reqDto : dtos) {
            UserPermissionDto userPermissionDto = LambdaFilter.firstOrDefault(userPermissionDtos, m -> m.getDataObjectCode().equals(reqDto.getDataObjectCode()));
            Integer permission = this.getpermissionByOperation(userPermissionDto, operation);
            this.processPermission(results, permission, reqDto.getDataObjectCode(), reqDto.getOwnerIds(), userId);
        }
        return results;
    }

    public List<UserPermissionDto> getUserPermissionByCodes(List<String> dataObjectCodes, Long tenantId, Long userId) throws BaseException {
        return this.getUserPermission(dataObjectCodes, tenantId, userId);

    }

    private void processPermission(List<PermissionListResDto> results, Integer permission, String dataObjectCode, List<Long> ownerIds, Long userId) throws BaseException {
        PermissionListResDto dto = new PermissionListResDto();
        dto.setDataObjectCode(dataObjectCode);
        boolean isPublicPermission = false;
        if (DataObjectPermissionEnum.PUBLIC.getValue().equals(permission)) {
            resutnResult(ownerIds, dto, true);
            isPublicPermission = true;
        } else if (DataObjectPermissionEnum.NONE.getValue().equals(permission)) {
            resutnResult(ownerIds, dto, false);
        } else if (DataObjectPermissionEnum.PERSONAL.getValue().equals(permission)) {
            for (Long ownerId : ownerIds) {
                PermissionDetailResDto detail = new PermissionDetailResDto();
                detail.setIsPass(userId.equals(ownerId));
                detail.setOwnerId(ownerId);
                dto.getPermissions().add(detail);
            }
        } else if (DataObjectPermissionEnum.DEPARTMENT.getValue().equals(permission)) {
            List<Long> userIds = userService.getSameDepUsers(userId);
            for (Long ownerId : ownerIds) {
                PermissionDetailResDto detail = new PermissionDetailResDto();
                detail.setIsPass(userIds.contains(ownerId));
                detail.setOwnerId(ownerId);
                dto.getPermissions().add(detail);
            }
        } else {
            resutnResult(ownerIds, dto, false);
        }
        PermissionDetailResDto detail = new PermissionDetailResDto();
        detail.setIsPass(isPublicPermission);
        detail.setOwnerId(null);
        dto.getPermissions().add(detail);
        results.add(dto);
    }

    private void resutnResult(List<Long> ownerIds, PermissionListResDto dto, Boolean isPass) {
        for (Long ownerId : ownerIds) {
            PermissionDetailResDto detail = new PermissionDetailResDto();
            detail.setIsPass(isPass);
            detail.setOwnerId(ownerId);
            dto.getPermissions().add(detail);
        }
    }


    private List<UserPermissionDto> getUserPermission(List<String> codes, Long tenantId, Long userId) throws
            BaseException {
        List<UserPermissionDto> dtos = LambdaFilter.toList(userPermissionService.gets(tenantId), m -> userId.equals(m.getUserId()) && codes.contains(m.getDataObjectCode()));
        return dtos;
    }

}
