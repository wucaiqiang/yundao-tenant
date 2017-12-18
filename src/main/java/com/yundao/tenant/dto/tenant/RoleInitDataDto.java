package com.yundao.tenant.dto.tenant;

public class RoleInitDataDto {
	   /**
		 * 父id
		 */
	    private Long parentId;

	    /**
		 * 系统编码
		 */
	    private String systemCode;

	    /**
		 * 名字
		 */
	    private String name;

	    /**
		 * 描述
		 */
	    private String description;

	    /**
		 * 是否共用，0：否，1：是
		 */
	    private Integer isShare;

	    /**
		 * 是否可删除，0：否，1：是
		 */
	    private Integer isCanDelete;

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
		 * 是否是系统 0 否  1是 
		 */
		private Integer isSystem;
		
		public Integer getIsSystem() {
			return isSystem;
		}

		public void setIsSystem(Integer isSystem) {
			this.isSystem = isSystem;
		}

		public Long getParentId() {
			return parentId;
		}

		public void setParentId(Long parentId) {
			this.parentId = parentId;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getIsShare() {
			return isShare;
		}

		public void setIsShare(Integer isShare) {
			this.isShare = isShare;
		}

		public Integer getIsCanDelete() {
			return isCanDelete;
		}

		public void setIsCanDelete(Integer isCanDelete) {
			this.isCanDelete = isCanDelete;
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
