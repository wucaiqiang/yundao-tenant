package com.yundao.tenant.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.tenant.DepartmentInitDataDto;
import com.yundao.tenant.dto.tenant.ResourceInitDataDto;
import com.yundao.tenant.dto.tenant.RoleInitDataDto;
import com.yundao.tenant.dto.tenant.RoleResourceInitDataDto;
import com.yundao.tenant.dto.tenant.TenantInitDataDto;
import com.yundao.tenant.mapper.base.BaseDepartmentMapper;
import com.yundao.tenant.mapper.base.BaseResourceMapper;
import com.yundao.tenant.mapper.base.BaseRoleMapper;
import com.yundao.tenant.mapper.base.BaseRoleResourceMapper;
import com.yundao.tenant.mapper.base.BaseUserAccountMapper;
import com.yundao.tenant.model.base.BaseDepartment;
import com.yundao.tenant.model.base.BaseDepartmentExample;
import com.yundao.tenant.model.base.BaseResource;
import com.yundao.tenant.model.base.BaseResourceExample;
import com.yundao.tenant.model.base.BaseRole;
import com.yundao.tenant.model.base.BaseRoleExample;
import com.yundao.tenant.model.base.BaseRoleResource;
import com.yundao.tenant.model.base.BaseRoleResourceExample;
import com.yundao.tenant.model.base.BaseUserAccountExample;
import com.yundao.tenant.service.user.TenantInitService;
import com.yundao.tenant.util.HttpUtils;

/**
 * 系统初始化管理
 * 
 * @author 欧阳利 2017年6月26日
 */
@Service
public class TenantInitServiceImpl extends AbstractService implements TenantInitService {
	private static Log log = LogFactory.getLog(TenantInitServiceImpl.class);
	@Autowired
	private BaseDepartmentMapper baseDepartmentMapper;
	@Autowired
	private BaseRoleResourceMapper baseRoleResourceMapper;
	@Autowired
	private BaseRoleMapper baseRoleMapper;
	@Autowired
	private BaseResourceMapper baseResourceMapper;
	@Autowired
	private BaseUserAccountMapper baseUserAccountMapper;
	/**
	 * 初始化系统
	 */
	@Override
	public void doTenantInit(TenantInitDataDto tenantInitDataDto, Long tenantId) throws BaseException {
		log.info("初始化租户："+tenantId);
		// 初始化部门
		departmentInit(tenantInitDataDto.getDepartmentDtos(), tenantId);
		// 初始化资源
		resourceInit(tenantInitDataDto.getResourceModelList(), tenantId);
		// 初始化角色
		roleInit(tenantInitDataDto.getRoleModelList(), tenantId);
		// 初始化角色资源
		roleResourceInit(tenantInitDataDto.getRoleResourceModelList(), tenantId);
	}

	/**
	 * 检查租户表是否存在
	 * 
	 * @param tenantId
	 * @return
	 */
	public boolean checkDBTableExist(Long tenantId) throws BaseException {
		return true;
	}

	/**
	 * 检查数据库是否初始化
	 * 
	 * @param tenantId
	 * @return
	 */
	public boolean checkDBFinishInit(Long tenantId) throws BaseException {
		BaseUserAccountExample department = new BaseUserAccountExample();
		int count = baseUserAccountMapper.countByExample(department);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 获取租户初始化数据
	 * 
	 * @param tenantId
	 */
	public Result<TenantInitDataDto> getInitData(Long tenantId) throws BaseException {
//		String url = ScmUrlConstant.GET_TENANT_DEPARTMENT_INIT_DATA;
//		url =ScmUrlConstant.GET_TENANT_ROLE_INIT_DATA;
		Map<String, Object> methodParams = new HashMap<String, Object>();
		methodParams.put("tenantId", tenantId);
		Result<List<DepartmentInitDataDto>> departmentInitResult =HttpUtils.get(ScmUrlConstant.GET_TENANT_DEPARTMENT_INIT_DATA,
				methodParams,new BaseTypeReference<Result<List<DepartmentInitDataDto>>>() {});
		
//		if (BooleanUtils.isEmpty(departmentInitResult.getResult()) ) {
//			return Result.newFailureResult(CodeConstant.CODE_1200025, "初始化数据不完整!", null);
//		}
		Result<TenantInitDataDto> dtoResult =HttpUtils.get(ScmUrlConstant.GET_TENANT_ROLE_INIT_DATA,
				methodParams,new BaseTypeReference<Result<TenantInitDataDto>>() {});
		if (dtoResult.getResult() == null 
				|| BooleanUtils.isEmpty(dtoResult.getResult().getResourceModelList())
				|| BooleanUtils.isEmpty(dtoResult.getResult().getRoleModelList())
				|| BooleanUtils.isEmpty(dtoResult.getResult().getRoleResourceModelList())) {
			return Result.newFailureResult(CodeConstant.CODE_1200025, "初始化数据不完整!", null);
		}
		dtoResult.getResult().setDepartmentDtos(departmentInitResult.getResult());
		return dtoResult;
	}

	/**
	 * 初始化部门
	 * 
	 * @param tenantId
	 */
	private void departmentInit(List<DepartmentInitDataDto> departmentDtos, Long tenantId) {
		// 删除所有的部门
		BaseDepartmentExample example = new BaseDepartmentExample();
		baseDepartmentMapper.deleteByExample(example);
		
		// 添加部门
		if (BooleanUtils.isEmpty(departmentDtos)) {
			return;
		}
		for (DepartmentInitDataDto dto : departmentDtos) {
			BaseDepartment department = new BaseDepartment();
			BeanUtils.copyProperties(dto, department);
			department.setTenantId(tenantId);
			department.setCreateUserId(-1l);
			department.setCreateDate(new Date());
			department.setIsDelete(0);
			baseDepartmentMapper.insert(department);
		}

	}

	/**
	 * 初始化资源
	 * 
	 * @param tenantId
	 */
	private void resourceInit(List<ResourceInitDataDto> resourceDtos, Long tenantId) {
		BaseResourceExample example = new BaseResourceExample();
		baseResourceMapper.deleteByExample(example);
		
		if (BooleanUtils.isEmpty(resourceDtos)) {
			return;
		}
		for (ResourceInitDataDto dto : resourceDtos) {
			BaseResource resource = new BaseResource();
			BeanUtils.copyProperties(dto, resource);
			resource.setTenantId(tenantId);
			resource.setCreateUserId(-1l);
			resource.setCreateDate(new Date());
			resource.setIsDelete(0);
			baseResourceMapper.insert(resource);
		}
	}

	/**
	 * 初始化角色
	 * 
	 * @param tenantId
	 */
	private void roleInit(List<RoleInitDataDto> roleDtos, Long tenantId) {
		BaseRoleExample example = new BaseRoleExample();
		baseRoleMapper.deleteByExample(example);
		
		if (BooleanUtils.isEmpty(roleDtos)) {
			return;
		}
		for (RoleInitDataDto dto : roleDtos) {
			BaseRole role = new BaseRole();
			BeanUtils.copyProperties(dto, role);
			role.setTenantId(tenantId);
			role.setCreateUserId(-1l);
			role.setCreateDate(new Date());
			role.setIsDelete(0);
			baseRoleMapper.insert(role);
		}
	}

	/**
	 * 初始化角色资源
	 * 
	 * @param tenantId
	 */
	private void roleResourceInit(List<RoleResourceInitDataDto> roleResourceDtos, Long tenantId) {
		BaseRoleResourceExample example = new BaseRoleResourceExample();
		baseRoleResourceMapper.deleteByExample(example);
		
		if (BooleanUtils.isEmpty(roleResourceDtos)) {
			return;
		}

		for (RoleResourceInitDataDto dto : roleResourceDtos) {
			BaseRoleResource roleResource = new BaseRoleResource();
			BeanUtils.copyProperties(dto, roleResource);
			roleResource.setTenantId(tenantId);
			roleResource.setCreateUserId(-1l);
			roleResource.setCreateDate(new Date());
			roleResource.setIsDelete(0);
			baseRoleResourceMapper.insert(roleResource);
		}
	}
}
