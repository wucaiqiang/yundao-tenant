package com.yundao.tenant.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.exception.BaseException;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.UUIDUtils;
import com.yundao.tenant.constant.ImagesConstant;
import com.yundao.tenant.constant.code.Code1230000;
import com.yundao.tenant.dto.tenant.TenantDto;
import com.yundao.tenant.dto.user.UserCardResDto;
import com.yundao.tenant.dto.user.role.UserRoleDto;
import com.yundao.tenant.dto.user.role.department.UserDepartmentDto;
import com.yundao.tenant.mapper.base.BaseUserAccountMapper;
import com.yundao.tenant.mapper.base.BaseUserDetailMapper;
import com.yundao.tenant.model.base.BaseUserAccount;
import com.yundao.tenant.model.base.BaseUserDetail;
import com.yundao.tenant.model.base.BaseUserDetailExample;
import com.yundao.tenant.service.user.TenantService;
import com.yundao.tenant.service.user.UserDepartmentService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.user.UserRoleService;

/**
 * 用户详情管理
 * 
 * @author 欧阳利 2017年6月22日
 */
@Service
public class UserDetailServiceImpl extends AbstractService implements UserDetailService {

	@Autowired
	BaseUserDetailMapper baseUserDetailMapper;
	@Autowired
	private TenantService tenantService;
	@Autowired
	private BaseUserAccountMapper baseUserAccountMapper;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private UserDepartmentService userDepartmentService;

	/**
	 * 添加用户详情
	 * 
	 * @param userDetail
	 * @return
	 */
	public Integer insertUserDetail(BaseUserDetail userDetail, Long createUserId) {
		userDetail.setCreateUserId(createUserId);
		userDetail.setCreateDate(new Date());
		userDetail.setIsDelete(0);
		return baseUserDetailMapper.insert(userDetail);
	}

	@Override
	public Long updateCardIntroduce(String cardIntroduce) throws BaseException {
		BaseUserDetailExample example = new BaseUserDetailExample();
		example.createCriteria().andUserAccountIdEqualTo(this.getHeaderUserId());
		BaseUserDetail base = baseUserDetailMapper.selectOne(example);
		if (base == null) {
			base = new BaseUserDetail();
			base.setCardIntroduce(cardIntroduce);
			base.setUserAccountId(this.getHeaderUserId());
			base.setTenantId(this.getHeaderTenantId());
			this.insertUserDetail(base, this.getHeaderUserId());
		} else {

			base.setCardIntroduce(cardIntroduce);
			this.updateUserDetailAllProperties(base);
		}

		return base.getId();
	}

	@Override
	public Long updateCardIntroduceAndHeaderBit(String cardIntroduce, String headerBit) throws BaseException {

		BaseUserDetailExample example = new BaseUserDetailExample();
		example.createCriteria().andUserAccountIdEqualTo(this.getHeaderUserId());
		BaseUserDetail base = baseUserDetailMapper.selectOne(example);
		if (base == null) {
			base = new BaseUserDetail();
			base.setCardIntroduce(cardIntroduce);
			base.setCardHeaderBit(headerBit);
			base.setUserAccountId(this.getHeaderUserId());
			base.setTenantId(this.getHeaderTenantId());
			this.insertUserDetail(base, this.getHeaderUserId());
		} else {
			base.setCardHeaderBit(headerBit);
			base.setCardIntroduce(cardIntroduce);
			this.updateUserDetailAllProperties(base);
		}

		return base.getId();

	}

	@Override
	public BaseUserDetail getByUUID(String uuid) throws BaseException {

		BaseUserDetailExample example = new BaseUserDetailExample();
		example.createCriteria().andCardUuidEqualTo(uuid);// uuid查询
		BaseUserDetail userDetail = baseUserDetailMapper.selectOne(example);

		return userDetail;

	}

	@Override
	public UserCardResDto getCardByUUID(String uuid) throws BaseException {
		if (StringUtils.isBlank(uuid)) {
			throw new BaseException(CommonCode.COMMON_1000);
		}
		BaseUserDetailExample example = new BaseUserDetailExample();
		example.createCriteria().andCardUuidEqualTo(uuid);// uuid查询
		BaseUserDetail userDetail = baseUserDetailMapper.selectOne(example);
		if (userDetail == null) {
			throw new BaseException(CommonCode.COMMON_1000);
		}

		UserCardResDto dto = new UserCardResDto();
		BeanUtils.copyProperties(userDetail, dto);
		if (StringUtils.isBlank(dto.getAvatar())) {
			String avatarUrl = ImagesConstant.USER_AVATAR;// 头像图片
			// 设置默认头像
			dto.setAvatar(avatarUrl);
		}
		BaseUserAccount userAccount = baseUserAccountMapper.selectByPrimaryKey(userDetail.getUserAccountId());
		if (userAccount != null) {
			dto.setMobile(userAccount.getMobile());
			dto.setEmail(userAccount.getEmail());
		}
		List<Long> userIds = new ArrayList<>();
		userIds.add(userAccount.getId());
		List<UserRoleDto> roleDtos = userRoleService.selectUserRoles(userIds);// 用户角色
		if (roleDtos != null && !roleDtos.isEmpty()) {
			dto.setRoles(roleDtos);
		}
		// 设置租户信息
		TenantDto tenantDto = tenantService.get();
		if (tenantDto != null) {
			dto.setTenantName(tenantDto.getName());
		}
		// 设置部门信息
		List<UserDepartmentDto> departmentDtos = userDepartmentService.selectUserDepartments(userIds);
		if (departmentDtos != null && !departmentDtos.isEmpty()) {
			UserDepartmentDto departmentDto = departmentDtos.get(0);
			dto.setDepartmentName(departmentDto.getDepartmentName());
		}
		return dto;

	}

	@Override
	public UserCardResDto doAndGetCardByUserId() throws BaseException {
		BaseUserAccount userAccount = baseUserAccountMapper.selectByPrimaryKey(this.getHeaderUserId());// 帐号信息
		if (userAccount == null) {
			throw new BaseException(Code1230000.CODE_1230006);
		}
		UserCardResDto dto = new UserCardResDto();
		dto.setMobile(userAccount.getMobile());
		dto.setEmail(userAccount.getEmail());

		BaseUserDetailExample example = new BaseUserDetailExample();
		example.createCriteria().andUserAccountIdEqualTo(this.getHeaderUserId());
		BaseUserDetail userDetail = baseUserDetailMapper.selectOne(example);
		if (userDetail != null) {
			BeanUtils.copyProperties(userDetail, dto);

			String cardUUID = userDetail.getCardUuid();

			if (StringUtils.isBlank(cardUUID)) {

				cardUUID = UUIDUtils.getUUID();

				BaseUserDetail updateRecode = new BaseUserDetail();
				updateRecode.setId(userDetail.getId());
				updateRecode.setCardUuid(cardUUID);
				baseUserDetailMapper.updateByPrimaryKeySelective(updateRecode);

			}
			dto.setCardUuid(cardUUID);
		}

		if (dto.getAvatar() == null) {
			String avatarUrl = ImagesConstant.USER_AVATAR;// 头像图片
			// 设置默认头像
			dto.setAvatar(avatarUrl);
		}

		List<Long> userIds = new ArrayList<>();
		userIds.add(userAccount.getId());
		List<UserRoleDto> roleDtos = userRoleService.selectUserRoles(userIds);// 用户角色
		if (roleDtos != null && !roleDtos.isEmpty()) {
			dto.setRoles(roleDtos);
		}
		TenantDto tenantDto = tenantService.get();// 租户信息
		if (tenantDto != null) {
			dto.setTenantName(tenantDto.getName());
		}
		// 设置部门信息
		List<UserDepartmentDto> departmentDtos = userDepartmentService.selectUserDepartments(userIds);
		if (departmentDtos != null && !departmentDtos.isEmpty()) {
			UserDepartmentDto departmentDto = departmentDtos.get(0);
			dto.setDepartmentName(departmentDto.getDepartmentName());
		}

		return dto;

	}

	/**
	 * 添加用户详情
	 * 
	 * @param userDetail
	 * @return
	 */
	public Integer updateUserDetail(BaseUserDetail userDetail) {
		BaseUserDetailExample example = new BaseUserDetailExample();
		userDetail.setUpdateUserId(this.getHeaderUserId());
		userDetail.setUpdateDate(new Date());
		example.createCriteria().andUserAccountIdEqualTo(userDetail.getUserAccountId());
		return baseUserDetailMapper.updateByExampleSelective(userDetail, example);
	}

	public Integer updateUserDetailAllProperties(BaseUserDetail userDetail) {
		BaseUserDetailExample example = new BaseUserDetailExample();
		userDetail.setUpdateUserId(this.getHeaderUserId());
		userDetail.setUpdateDate(new Date());
		example.createCriteria().andUserAccountIdEqualTo(userDetail.getUserAccountId());
		return baseUserDetailMapper.updateByExample(userDetail, example);
	}
	/**
	 * 获取用户列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<BaseUserDetail> getUserDetail(List<Long> userIds) {
		if (BooleanUtils.isEmpty(userIds)) {
			return null;
		}
		BaseUserDetailExample example = new BaseUserDetailExample();
		example.createCriteria().andUserAccountIdIn(userIds);
		return baseUserDetailMapper.selectByExample(example);
	}

	/**
	 * 获取用户的姓名
	 * 
	 * @param userId
	 * @return
	 */
	public String getUserRealName(Long userId) {
		if (userId == null) {
			return null;
		}
		BaseUserDetailExample example = new BaseUserDetailExample();
		example.createCriteria().andUserAccountIdEqualTo(userId);
		BaseUserDetail base = baseUserDetailMapper.selectOne(example);
		if (base == null) {
			return null;
		}
		return base.getRealName();
	}
}
