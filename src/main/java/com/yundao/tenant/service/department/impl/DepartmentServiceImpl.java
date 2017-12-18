package com.yundao.tenant.service.department.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.HierarchyCodeUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.common.IdNameDto;
import com.yundao.tenant.dto.department.DepartmentAddReqDto;
import com.yundao.tenant.dto.department.DepartmentDetailResDto;
import com.yundao.tenant.dto.department.DepartmentListResDto;
import com.yundao.tenant.dto.department.DepartmentUpdateReqDto;
import com.yundao.tenant.dto.department.DepartmentUserDto;
import com.yundao.tenant.dto.department.DepartmentUserListResDto;
import com.yundao.tenant.dto.department.DepartmentUserSimpleResDto;
import com.yundao.tenant.dto.tenant.TenantDto;
import com.yundao.tenant.dto.user.UserSimpleInfoDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.mapper.base.BaseDepartmentMapper;
import com.yundao.tenant.mapper.base.BaseUserDepartmentMapper;
import com.yundao.tenant.mapper.base.BaseUserStaffMapper;
import com.yundao.tenant.mapper.department.DepartmentMapper;
import com.yundao.tenant.mapper.user.UserMapper;
import com.yundao.tenant.model.base.BaseDepartment;
import com.yundao.tenant.model.base.BaseDepartmentExample;
import com.yundao.tenant.model.base.BaseUserDepartment;
import com.yundao.tenant.model.base.BaseUserDepartmentExample;
import com.yundao.tenant.model.base.BaseUserStaff;
import com.yundao.tenant.model.base.BaseUserStaffExample;
import com.yundao.tenant.service.department.DepartmentService;
import com.yundao.tenant.service.role.RoleService;
import com.yundao.tenant.service.user.TenantService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;

/**
 * @author jans
 * @create 2017-06-18 PM7:39
 **/
@Service
public class DepartmentServiceImpl extends AbstractService implements DepartmentService {

	private static Log log = LogFactory.getLog(DepartmentServiceImpl.class);

	@Autowired
	private BaseDepartmentMapper baseDepartmentMapper;

	@Autowired
	private BaseUserDepartmentMapper baseUserDepartmentMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BaseUserStaffMapper baseUserStaffMapper;

	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private TenantService tenantService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	@Override
	public Result<Long> insert(DepartmentAddReqDto dto) throws BaseException {
		log.begin(dto);
		if (dto.getParentId() < CommonConstant.ROOT_ID)
			dto.setParentId(CommonConstant.ROOT_ID);
		BaseDepartmentExample baseDepartmentExample = new BaseDepartmentExample();
		// 同级，最新的节点
		baseDepartmentExample.createCriteria().andParentIdEqualTo(dto.getParentId());
		baseDepartmentExample.setOrderByClause("code DESC");
		BaseDepartment latelyBrother = departmentMapper.selectChildMaxCodeDepartment(dto.getParentId());
		String latelyBrotherCode = latelyBrother == null ? null : latelyBrother.getCode();
		// 父级
		BaseDepartment parent = baseDepartmentMapper.selectByPrimaryKey(dto.getParentId());
		String parentCode = parent == null ? null : parent.getCode();
		String code = HierarchyCodeUtils.getCode(latelyBrotherCode, dto.getParentId(), parentCode);

		BaseDepartment model = new BaseDepartment();
		super.initialModel(model);
		model.setCode(code);
		model.setParentId(dto.getParentId());
		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		baseDepartmentMapper.insertSelective(model);
		log.end();
		return Result.newSuccessResult(model.getId());
	}

	@Override
	public DepartmentDetailResDto get(Long id) throws BaseException {
		log.begin(id);
		BaseDepartment dep = baseDepartmentMapper.selectByPrimaryKey(id);
		if (dep == null)
			throw new BaseException(CodeConstant.CODE_1200004);
		DepartmentDetailResDto dto = new DepartmentDetailResDto();
		BeanUtils.copyProperties(dep, dto);
		// 获取父级部门
		Long parentId = dep.getParentId();
		if (parentId != null) {
			BaseDepartment parentDep = baseDepartmentMapper.selectByPrimaryKey(parentId);
			if (parentDep != null)
				dto.setParentName(parentDep.getName());
		}
		return dto;

	}

	@Override
	public DepartmentUserListResDto getDepartmentAndUsers() throws BaseException {
		List<DepartmentUserSimpleResDto> departmenets = departmentMapper.selectDepartmentAndUsers();
		if (BooleanUtils.isEmpty(departmenets))
			return null;

		Map<Long, DepartmentUserListResDto> treeMap = new HashMap<>();
		TenantDto tenant = tenantService.get();
		if (tenant == null) {
			throw new BaseException(CodeConstant.CODE_1200137);
		}
		List<UserSimpleInfoDto> users=userService.getUserNotBelongToDepartment();
		// 新建一个根节点
		DepartmentUserListResDto root = new DepartmentUserListResDto();
		root.setId(CommonConstant.ROOT_ID);
		root.setName(tenant.getName());
		root.setUsers(users);//
		treeMap.put(root.getId(), root);

		departmenets.forEach((v) -> {
			DepartmentUserListResDto dto = null;
			if (treeMap.containsKey(v.getDepartmentId())) {
				dto = treeMap.get(v.getDepartmentId());
			} else {
				dto = new DepartmentUserListResDto();
				dto.setId(v.getDepartmentId());
				dto.setCode(v.getCode());
				dto.setDescription(v.getDescription());
				dto.setName(v.getName());
				dto.setParentId(v.getParentId());
				treeMap.put(v.getDepartmentId(), dto);
			}
			if(v.getUserId() !=null){
				UserSimpleInfoDto user = new UserSimpleInfoDto();
				user.setId(v.getUserId());
				user.setMobile(v.getMobile());
				user.setRealName(v.getRealName());
				user.setAvatar(v.getAvatar());
				user.setDepartmentName(v.getName());
				List<IdNameDto> idNameDtos;
				try {
					idNameDtos = roleService.getByUserId(v.getUserId());
					if (idNameDtos != null && !idNameDtos.isEmpty()) {
						StringBuilder nameBuilder = new StringBuilder();
						for (IdNameDto idNameDto : idNameDtos) {
							if (nameBuilder.length() > 0) {
								nameBuilder.append(",");
							}
							nameBuilder.append(idNameDto.getName());
						}
						user.setRoleNames(nameBuilder.toString());
					}
				} catch (Exception e) {
					log.error("获取用户角色出现异常，异常信息为：", e);
				}
				dto.getUsers().add(user);
			}
			
		});
		//部门层级归类
		for (Map.Entry<Long, DepartmentUserListResDto> entry : treeMap.entrySet()) {
			DepartmentUserListResDto department = entry.getValue();
			DepartmentUserListResDto parent = treeMap.get(department.getParentId());
			if (parent != null) {
				parent.getChilds().add(department);
			}

		}
		//设置部门人数
		for (Map.Entry<Long, DepartmentUserListResDto> entry : treeMap.entrySet()) {
			DepartmentUserListResDto department = entry.getValue();
			if (department != null) {
				department.setUserNum(this.getChildNum(department));
			}

		}
		
		return root;

	}

	/**
	 * 递归查询当前部门及下属部分人工总数 getChildNum:
	 * 
	 * @author: wucq
	 * @param parent
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	private int getChildNum(DepartmentUserListResDto parent) throws BaseException {
		if (parent == null) {
			return 0;
		}
		int count = 0;
		if (parent.getUsers() != null) {
			count = parent.getUsers().size();
		}
		List<DepartmentUserListResDto> childs = parent.getChilds();
		if (childs != null && !childs.isEmpty()) {
			for (DepartmentUserListResDto child : childs) {
				count += this.getChildNum(child);
			}
		}
		return count;
	}

	@Override
	public List<DepartmentListResDto> gets() throws BaseException {
		log.begin();
		BaseDepartmentExample baseDepartmentExample = new BaseDepartmentExample();
		baseDepartmentExample.createCriteria();
		List<BaseDepartment> departmenets = baseDepartmentMapper.selectByExample(baseDepartmentExample);

		if (BooleanUtils.isEmpty(departmenets))
			return new ArrayList<>();
		Map<Long, DepartmentListResDto> treeMap = new HashMap<>();
		List<DepartmentListResDto> dtos = LocalBeanUtils.copyPropertiesList(departmenets, DepartmentListResDto.class);
		dtos.forEach(m -> treeMap.put(m.getId(), m));
		// 新建一个根节点
		DepartmentListResDto root = new DepartmentListResDto();
		root.setId(CommonConstant.ROOT_ID);
		treeMap.put(root.getId(), root);
		for (Map.Entry<Long, DepartmentListResDto> entry : treeMap.entrySet()) {
			DepartmentListResDto department = entry.getValue();
			DepartmentListResDto parent = treeMap.get(department.getParentId());
			if (parent != null)
				parent.getChilds().add(department);
		}
		log.end();
		return root.getChilds();
	}

	@Override
	public Result<Long> update(DepartmentUpdateReqDto dto) throws BaseException {
		log.begin(dto);
		if (dto.getId().equals(dto.getParentId()))
			throw new BaseException(CommonCode.COMMON_1007);
		if (dto.getParentId() < CommonConstant.ROOT_ID)
			dto.setParentId(CommonConstant.ROOT_ID);
		BaseDepartment model = baseDepartmentMapper.selectByPrimaryKey(dto.getId());
		if (model == null) {
			throw new BaseException(CodeConstant.CODE_1200004);
		}
		super.updateModel(model);
		model.setDescription(dto.getDescription());
		model.setName(dto.getName());
		String oldCode = model.getCode();
		// 修改了上级部门
		if (!dto.getParentId().equals(model.getParentId())) {
			BaseDepartmentExample dmExample = new BaseDepartmentExample();
			// 同级，最新的节点
			dmExample.createCriteria().andParentIdEqualTo(dto.getParentId());
			dmExample.setOrderByClause("code DESC");
			BaseDepartment latelyBrother = departmentMapper.selectChildMaxCodeDepartment(dto.getParentId());
			String latelyBrotherCode = latelyBrother == null ? null : latelyBrother.getCode();
			// 父级
			BaseDepartment parent = baseDepartmentMapper.selectByPrimaryKey(dto.getParentId());
			String parentCode = parent == null ? null : parent.getCode();
			String code = HierarchyCodeUtils.getCode(latelyBrotherCode, dto.getParentId(), parentCode);
			model.setCode(code);

			// 修改所有子部门的code
			updateAllChildDepartmentCode(oldCode, code);
		}
		model.setParentId(dto.getParentId());

		baseDepartmentMapper.updateByPrimaryKeySelective(model);
		log.end();
		return Result.newSuccessResult(model.getId());
	}

	private void updateAllChildDepartmentCode(String oldCode, String newCode) {
		List<BaseDepartment> list = departmentMapper.selectAllChilds(oldCode);
		if (BooleanUtils.isEmpty(list)) {
			return;
		}
		for (BaseDepartment base : list) {
			BaseDepartment record = new BaseDepartment();
			record.setId(base.getId());
			record.setCode(newCode + base.getCode().substring(oldCode.length()));
			baseDepartmentMapper.updateByPrimaryKeySelective(record);
		}
	}

	@Override
	public Result<Long> delete(long id) throws BaseException {
		BaseDepartment model = baseDepartmentMapper.selectByPrimaryKey(id);
		if (model == null) {
			throw new BaseException(CodeConstant.CODE_1200004);
		}

		List<Long> userIdList = userMapper.selectSameDepUsers(model.getCode());

		if (BooleanUtils.isNotEmpty(userIdList)) {
			BaseUserStaffExample usExample = new BaseUserStaffExample();
			usExample.createCriteria().andUserAccountIdIn(userIdList);
			List<BaseUserStaff> userStaffs = baseUserStaffMapper.selectByExample(usExample);

			List<BaseUserStaff> unEnables = LambdaFilter.toList(userStaffs,
					m -> YesOrNoEnum.YES.getValue().equals(m.getIsEnabled()));
			if (BooleanUtils.isNotEmpty(unEnables))
				throw new BaseException(CodeConstant.CODE_1220102);

			removeUnEnableUserForDelDep(model.getId(), userStaffs);
		}

		super.updateModel(model);
		model.setIsDelete(DeleteEnum.DELETED.getValue());
		baseDepartmentMapper.updateByPrimaryKey(model);
		return Result.newSuccessResult(model.getId());
	}

	/**
	 * 移除该部门停用用户
	 *
	 * @param depId
	 *            部门id
	 * @param userStaffs
	 *            用户集合
	 */
	private void removeUnEnableUserForDelDep(Long depId, List<BaseUserStaff> userStaffs) {
		List<BaseUserStaff> dimissionList = LambdaFilter.toList(userStaffs,
				m -> YesOrNoEnum.NO.getValue().equals(m.getIsEnabled()));
		if (BooleanUtils.isNotEmpty(dimissionList)) {
			// 如存在停用用户，踢出该部门
			BaseUserDepartmentExample udExample = new BaseUserDepartmentExample();
			udExample.createCriteria()
					.andUserAccountIdIn(LambdaMap.toSingleList(dimissionList, m -> m.getUserAccountId()))
					.andDepartmentIdEqualTo(depId);
			List<BaseUserDepartment> userDepartmentList = baseUserDepartmentMapper.selectByExample(udExample);
			if (BooleanUtils.isNotEmpty(userDepartmentList)) {
				for (BaseUserDepartment userDepartment : userDepartmentList) {
					baseUserDepartmentMapper.deleteByPrimaryKey(userDepartment.getId());
				}
			}
		}
	}

	/**
	 * 查询某个部门下面的所有子部门
	 *
	 * @param departmentId
	 * @return
	 */
	public List<Long> getAllChildsByDepartmentId(Long departmentId) throws BaseException {
		List<Long> departmentIds = new ArrayList<Long>();
		if (departmentId < 0) {
			return departmentIds;
		}
		// 查询这部门的code
		String code = null;
		BaseDepartment department = baseDepartmentMapper.selectByPrimaryKey(departmentId);
		if (department != null) {
			code = department.getCode();
		} else if (departmentId == 0) {
			code = "";
		}
		BaseDepartmentExample example = new BaseDepartmentExample();
		example.createCriteria().andCodeLike(code + "%");
		List<BaseDepartment> list = baseDepartmentMapper.selectByExample(example);
		if (!BooleanUtils.isEmpty(list)) {
			for (BaseDepartment model : list) {
				departmentIds.add(model.getId());
			}
		}
		return departmentIds;
	}

	/**
	 * 检查部门名称是否重复
	 *
	 * @param parentId
	 * @param name
	 * @return
	 * @throws BaseException
	 */
	public Result<Boolean> checkDepartmentNameExist(Long parentId, String name) throws BaseException {
		if (BooleanUtils.isBlank(name)) {
			return null;
		}
		BaseDepartmentExample example = new BaseDepartmentExample();
		example.createCriteria().andParentIdEqualTo(parentId).andNameEqualTo(name.trim());
		List<BaseDepartment> list = baseDepartmentMapper.selectByExample(example);
		return Result.newSuccessResult(!BooleanUtils.isEmpty(list));
	}

	/**
	 * 检查部门名称是否重复
	 *
	 * @param parentId
	 * @param name
	 * @param departmentId
	 * @return
	 * @throws BaseException
	 */
	public Result<Boolean> checkDepartmentNameExist(Long parentId, String name, Long departmentId)
			throws BaseException {
		BaseDepartmentExample example = new BaseDepartmentExample();
		example.createCriteria().andParentIdEqualTo(parentId).andNameEqualTo(name.trim());
		List<BaseDepartment> list = baseDepartmentMapper.selectByExample(example);
		if (BooleanUtils.isEmpty(list)) {
			return Result.newSuccessResult(false);
		}
		for (BaseDepartment base : list) {
			if (!base.getId().equals(departmentId)) {
				return Result.newSuccessResult(true);
			}
		}
		return Result.newSuccessResult(false);
	}

	/**
	 * 检查部门是否存在
	 *
	 * @param departmentId
	 * @return
	 * @throws BaseException
	 */
	public Boolean checkDepartmentExist(Long departmentId) throws BaseException {
		if (departmentId == 0) {
			return true;
		}
		BaseDepartmentExample example = new BaseDepartmentExample();
		example.createCriteria().andIdEqualTo(departmentId);
		List<BaseDepartment> list = baseDepartmentMapper.selectByExample(example);
		return !BooleanUtils.isEmpty(list);
	}

	@Override
	public BaseDepartment getByUserId(Long userId) throws BaseException {
		BaseUserDepartmentExample udpExample = new BaseUserDepartmentExample();
		udpExample.createCriteria().andUserAccountIdEqualTo(userId);
		BaseUserDepartment baseUserDepartment = baseUserDepartmentMapper.selectOne(udpExample);
		if (baseUserDepartment == null)
			return null;
		return baseDepartmentMapper.selectByPrimaryKey(baseUserDepartment.getDepartmentId());
	}

	/**
	 * 查询当前用户所在的部门 getCurrentUserDepartment:
	 *
	 * @return
	 * @throws BaseException
	 * @author: 欧阳利
	 * @description:
	 */
	public Result<BaseDepartment> getCurrentUserDepartment() throws BaseException {
		BaseDepartment department = getByUserId(this.getHeaderUserId());
		return Result.newSuccessResult(department);
	}

	/**
	 * 通过部门id查询部门信息 getBaseDepartment:
	 *
	 * @param id
	 * @return
	 * @throws BaseException
	 * @author: 欧阳利
	 * @description:
	 */
	public Result<BaseDepartment> getBaseDepartment(Long id) throws BaseException {
		if (id == null) {
			return Result.newSuccessResult(null);
		}
		BaseDepartment department = baseDepartmentMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(department);
	}

	@Override
	public List<DepartmentUserDto> getByUserIds(List<Long> userIds) throws BaseException {
		List<Long> notNullIds = new ArrayList<>();
		for (Long userId : userIds) {
			if (userId != null)
				notNullIds.add(userId);
		}
		if (BooleanUtils.isEmpty(notNullIds))
			return new ArrayList<>();
		return departmentMapper.selectUserDeaprtment(notNullIds);
	}

	/**
	 * 查询部门的直接部门 getDirectChilDepartment:
	 * 
	 * @author: 欧阳利
	 * @param departmentId
	 * @return
	 * @description:
	 */
	public List<BaseDepartment> getDirectChilDepartment(Long departmentId) {
		List<BaseDepartment> childDepartments = null;
		if (departmentId == null || departmentId == 0) {
			BaseDepartmentExample example = new BaseDepartmentExample();
			example.createCriteria().andParentIdEqualTo(0l);
			childDepartments = baseDepartmentMapper.selectByExample(example);
		} else {
			BaseDepartmentExample example = new BaseDepartmentExample();
			example.createCriteria().andParentIdEqualTo(departmentId);
			childDepartments = baseDepartmentMapper.selectByExample(example);
		}
		return childDepartments;
	}
}
