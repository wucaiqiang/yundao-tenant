package com.yundao.tenant.dto.tenant;

public class TenantDto {
  
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 名字
	 */
    private String name;

    /**
	 * 编码
	 */
    private String code;

    /**
	 * 类型
	 */
    private Integer type;

    /**
	 * 地址
	 */
    private String address;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}