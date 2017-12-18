package com.yundao.tenant.constant.url;

import com.yundao.core.utils.ConfigUtils;
import com.yundao.tenant.enums.UrlEnum;

/**
 * 调用 公共管理系统的URL地址常量
 *
 * @author jan
 * @create 2017-06-21 PM8:02
 **/
public interface ScmUrlConstant {

    /**
     * HOST地址
     */
    String BASE_URL = ConfigUtils.getValue(UrlEnum.SCM_URL.getKey());

    /**
     * 获取租户数据源
     */
    String GET_DATA_SOURCE = BASE_URL + "/datasource/get_tenant";

    /**
     * 获取租户部门初始化数据
     */
    String GET_TENANT_DEPARTMENT_INIT_DATA = BASE_URL + "/tenantinitdepartment/get_tenant_department";


    /**
     * 获取租户角色初始化数据
     */
    String GET_TENANT_ROLE_INIT_DATA = BASE_URL + "/tenantinitrole/get_tenant_role";


    /**
     * 获取租户角色初始化数据
     */
    String GET_TENANT = BASE_URL + "/tenant/get";

    /**
     * 检查手机号码是否存在
     */
    String CHECK_MOBILE_EXIST = BASE_URL + "/tenant/user/check_mobile_exist";

    /**
     * 检查用户名和密码
     */
    String CHECK_USER_PASSWORD = BASE_URL + "/tenant/user/check_user_password";
    String USER_LOGIN = BASE_URL + "/user/login";
    String USER_LOGINOUT = BASE_URL + "/user/logout";
    /**
     * 修改用户密码
     */
    String USER_UPDATE_PASSWORD = BASE_URL + "/user/update_password";
    
    String ADD_USERACCOUNT_ADD = BASE_URL + "/tenant/user/add";
    String VIDEO_TENANT_ADD = BASE_URL + "/videotenant/add";

    /**
     * 修改密码
     */
    String RETRIEVE_USER_PASSWORD = BASE_URL + "/tenant/user/retrieve_password";
    /**
     * 获取租户密钥对
     */
    String KEY_PAIR_GET_BY_TENANT_ID = BASE_URL + "/keypair/get_by_tenant_id";
    
    /**
     * 删除用户和租户的关联
     */
    String DELETE_TENANT_USER_REF =  BASE_URL + "/tenant/user/delete/user_tenant";

    String GET_DOMAIN_BYTP =  BASE_URL + "/domainname/get_domain_bytp";

    /**
     * 获取租户的限制员工数
     */
    String GET_LIMIT_EMPLOYEE_COUNT =  BASE_URL + "/tenant/get_limit_employee_count";

}
