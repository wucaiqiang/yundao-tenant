package com.yundao.tenant.dto.user.role;

import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;

/**
 * 用户关联角色分页请求
 *
 * @author jan
 * @create 2017-06-26 AM8:38
 **/
public class UserRolePageReqDto extends AbstractBasePageDto {

    /**
     * 角色id
     */
    @Number(message = "{" + CodeConstant.CODE_1200007 + "}", isBlank = false)
    private Long roleId;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 汇报上级
     */
    private String leaderName;

    /**
     * 工号
     */
    private String jobNumber;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
