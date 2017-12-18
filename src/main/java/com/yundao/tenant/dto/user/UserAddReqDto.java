package com.yundao.tenant.dto.user;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.model.base.BaseUserAccount;
import com.yundao.tenant.model.base.BaseUserDepartment;
import com.yundao.tenant.model.base.BaseUserDetail;
import com.yundao.tenant.model.base.BaseUserStaff;

import io.swagger.annotations.ApiModelProperty;

/**
 * 添加用户请求参数dto
 *
 * @author 欧阳利
 *         2017年6月22日
 */
public class UserAddReqDto {

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    @NotNull(message = "{" + CodeConstant.CODE_1200006 + "}")
    private Long departmentId;


    /**
     * 用户名
     */
//    @ApiModelProperty(value = "用户名")
//    @Length(min = 6, max = 20, message = "{" + CodeConstant.CODE_1200009 + "}")
//    private String username;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    @Length(min = 1, max = 20, message = "{" + CodeConstant.CODE_1200010 + "}")
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Length(min = 1, max = 11, message = "{" + CodeConstant.CODE_1200011 + "}")
    private String mobile;

    /**
     * 邮箱
     */
//    @ApiModelProperty(value = "邮箱")
//    @Length(min = 1, max = 11, message = "{" + CodeConstant.CODE_1200012 + "}")
//    private String email;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 角色id集合
     */
    @ApiModelProperty(value = "角色id集合,多个角色使用逗号分割开")
    @NotNull(message = "{" + CodeConstant.CODE_1200036 + "}")
    private List<Long> roleIds;

    /**
     * 工号
     */
    @ApiModelProperty(value = "工号")
    @Length(min = 1, max = 20, message = "{" + CodeConstant.CODE_1200013 + "}",isBlank = true)
    private String jobNumber;

    /**
     * 系统集合
     */
    @ApiModelProperty(value = "系统集合code, 多个系统code使用逗号分割开")
    private List<String> systemCodes;

    /**
     * 领导id
     */
    @ApiModelProperty(value = "领导id")
    private Long leaderId;
    
    /**
     * 对象转换
     *
     * @param qeqDto
     * @return
     */
    public static BaseUserAccount getBaseUserAccount(UserAddReqDto userReqDto) {
        BaseUserAccount userAccount = new BaseUserAccount();
        //userAccount.setTenantId(userReqDto.getTenantId());
        //userAccount.setUsername(userReqDto.getUsername());
        //userAccount.setPassword(userReqDto.getPassword());
        userAccount.setMobile(userReqDto.getMobile());
        return userAccount;
    }

    public static BaseUserDepartment getBaseUserDepartment(UserAddReqDto userReqDto) {
        BaseUserDepartment userDepartment = new BaseUserDepartment();
        //userDepartment.setTenantId(userReqDto.getTenantId());
        userDepartment.setDepartmentId(userReqDto.getDepartmentId());
        return userDepartment;
    }


    public static BaseUserStaff getBaseUserStaff(UserAddReqDto userReqDto) {
        BaseUserStaff baseUserStaff = new BaseUserStaff();
        baseUserStaff.setJobNumber(userReqDto.jobNumber);
        baseUserStaff.setLeaderId(userReqDto.getLeaderId());
        //baseUserStaff.setTenantId(userReqDto.getTenantId());
        return baseUserStaff;
    }


    public static BaseUserDetail getBaseUserDetail(UserAddReqDto userReqDto) {
        BaseUserDetail baseUserDetail = new BaseUserDetail();
        //baseUserDetail.setTenantId(userReqDto.getTenantId());
        baseUserDetail.setRealName(userReqDto.getRealName());
        return baseUserDetail;
    }

    public Long getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}

	public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }




    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public List<String> getSystemCodes() {
        return systemCodes;
    }

    public void setSystemCodes(List<String> systemCodes) {
        this.systemCodes = systemCodes;
    }


}
