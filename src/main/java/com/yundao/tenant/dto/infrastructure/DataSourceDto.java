package com.yundao.tenant.dto.infrastructure;

/**
 * 数据源传输对象
 *
 * @author jan
 * @create 2017-06-22 AM9:27
 **/
public class DataSourceDto {

    /**
     * id
     */
    private Integer id;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 系统编码
     */
    private String systemCode;

    /**
     * 名字
     */
    private String name;

    /**
     * 驱动名
     */
    private String driverClassName;

    /**
     * 数据库连接
     */
    private String url;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
