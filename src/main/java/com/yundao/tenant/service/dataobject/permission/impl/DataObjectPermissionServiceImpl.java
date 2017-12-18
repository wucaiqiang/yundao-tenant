package com.yundao.tenant.service.dataobject.permission.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.permission.*;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.service.dataobject.permission.DataObjectPermissionService;
import com.yundao.tenant.service.permission.PermissionListService;
import com.yundao.tenant.service.permission.PermissionService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import com.yundao.tenant.util.request.RequestHeaderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据权限服务接口
 *
 * @author jan
 * @create 2017-08-05 PM1:36
 **/
@Service
public class DataObjectPermissionServiceImpl implements DataObjectPermissionService {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PermissionListService permissionListService;

    @Autowired
    private UserService userService;

    @Override
    public Integer get(String dataObjectCode, Integer operation) throws BaseException {
        return permissionService.get(dataObjectCode, operation, RequestHeaderUtils.getTenantId(), RequestHeaderUtils.getUserId());
    }

    @Override
    public Boolean check(String dataObjectCode, Integer operation, Long ownerId) throws BaseException {
        return permissionService.check(dataObjectCode, operation, ownerId, RequestHeaderUtils.getTenantId(), RequestHeaderUtils.getUserId());
    }

    @Override
    public List<PermissionListResDto> checkList(String dataObjectCode, Integer operation, List<Long> ownerIds) throws BaseException {
        return permissionListService.checkList(dataObjectCode, operation, ownerIds, RequestHeaderUtils.getTenantId(), RequestHeaderUtils.getUserId());
    }

    @Override
    public List<PermissionListResDto> checkList(Integer operation, String jsonReqDto) throws BaseException {
        List<PermissionListReqDto> dtos = JsonUtils.jsonToObject(jsonReqDto, new
                BaseTypeReference<List<PermissionListReqDto>>() {
                });
        return permissionListService.checkList(operation, dtos, RequestHeaderUtils.getTenantId(), RequestHeaderUtils.getUserId());
    }

    @Override
    public List<DataPermissionResDto> checkMultiCode(String jsonReqDto) throws BaseException {
        Long userId = RequestHeaderUtils.getUserId();
        //反序列化请求参数
        List<PermissionMultiCodeReqDto> reqDtos = JsonUtils.jsonToObject(jsonReqDto, new
                BaseTypeReference<List<PermissionMultiCodeReqDto>>() {
                });
        //查询多个数据对象的操作权限
        List<UserPermissionDto> permissionDtos = permissionListService.getUserPermissionByCodes(LambdaMap.toSingleList(reqDtos, m -> m.getDataObjectCode()), RequestHeaderUtils.getTenantId(), userId);

        //查询当前操作人同部门用户id
        List<Long> sameDepUsers = userService.getSameDepUsers(userId);
        List<DataPermissionResDto> resultDtos = new ArrayList<>(reqDtos.size());
        for (PermissionMultiCodeReqDto reqDto : reqDtos) {
            DataPermissionResDto dto = new DataPermissionResDto();
            UserPermissionDto permissionDto = LambdaFilter.firstOrDefault(permissionDtos, m -> m.getDataObjectCode().equals(reqDto.getDataObjectCode()));
            dto.setDataObjectCode(reqDto.getDataObjectCode());
            dto.setReadPermission(this.checkUserPermission(sameDepUsers, permissionDto.getReadPermission(), reqDto
                    .getOwnerIds()));
            dto.setEditPermission(this.checkUserPermission(sameDepUsers, permissionDto.getEditPermission(), reqDto
                    .getOwnerIds()));
            dto.setDeletePermission(this.checkUserPermission(sameDepUsers, permissionDto.getDeletePermission(), reqDto
                    .getOwnerIds()));
            resultDtos.add(dto);
        }
        return resultDtos;
    }

    @Override
    public DataPermissionResDto checkOnlyCode(PermissionMultiCodeReqDto codeReqDto) throws BaseException {
        List<String> codes = new ArrayList<>();
        codes.add(codeReqDto.getDataObjectCode());
        List<UserPermissionDto> permissionDtos = permissionListService.getUserPermissionByCodes(codes, RequestHeaderUtils.getTenantId(), RequestHeaderUtils.getUserId());
        DataPermissionResDto dto = new DataPermissionResDto();
        UserPermissionDto permissionDto = LambdaFilter.firstOrDefault(permissionDtos, m -> m.getDataObjectCode().equals(codeReqDto.getDataObjectCode()));
        dto.setDataObjectCode(codeReqDto.getDataObjectCode());
        List<Long> sameDepUsers = userService.getSameDepUsers(RequestHeaderUtils.getUserId());
        dto.setReadPermission(this.checkUserPermission(sameDepUsers, permissionDto.getReadPermission(), codeReqDto
                .getOwnerIds()));
        dto.setEditPermission(this.checkUserPermission(sameDepUsers, permissionDto.getEditPermission(), codeReqDto
                .getOwnerIds()));
        dto.setDeletePermission(this.checkUserPermission(sameDepUsers, permissionDto.getDeletePermission(), codeReqDto
                .getOwnerIds()));
        return dto;
    }


    private Boolean checkUserPermission(List<Long> sameDepUsers, Integer permission, List<Long> ownerIds) {
        Long userId = RequestHeaderUtils.getUserId();
        if (DataObjectPermissionEnum.PUBLIC.getValue().equals(permission))
            return true;
        if (DataObjectPermissionEnum.NONE.getValue().equals(permission))
            return false;
        if (DataObjectPermissionEnum.PERSONAL.getValue().equals(permission))
            return ownerIds.contains(userId);
        if (DataObjectPermissionEnum.DEPARTMENT.getValue().equals(permission)) {
            if (ownerIds.contains(userId))
                return true;
            if(sameDepUsers.contains(userId))
                return true;
        }
        return false;
    }


}
