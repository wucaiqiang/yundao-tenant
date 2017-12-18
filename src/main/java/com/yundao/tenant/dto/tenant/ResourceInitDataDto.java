package com.yundao.tenant.dto.tenant;

public class ResourceInitDataDto {
    /**
	 * 编码
	 */
    private String code;

    /**
	 * 系统编码
	 */
    private String systemCode;

    /**
	 * 父id
	 */
    private Long parentId;

    /**
	 * 名字
	 */
    private String name;

    /**
	 * 链接
	 */
    private String url;

    /**
	 * 是否菜单，0：否，1：是
	 */
    private Integer isMenu;

    /**
	 * 描述
	 */
    private String description;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 主键
	 */
	private Long tenantId;


	/**
	 * 是否启用 0 否 1是，默认1
	 */
	private Integer isEnabled;

	/**
	 * 是否删除 0 否  1是 ，默认0
	 */
	private Integer isDelete;
	
	/**
	 * 是否显示
	 */
	private Integer isDeplay;

	public Integer getIsDeplay() {
	
		return isDeplay;
	}

	public void setIsDeplay(Integer isDeplay) {
	
		this.isDeplay = isDeplay;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}


	public Integer getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
}
