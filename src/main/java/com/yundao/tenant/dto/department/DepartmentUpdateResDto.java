package com.yundao.tenant.dto.department;

import java.io.Serializable;

public class DepartmentUpdateResDto implements Serializable {

    public DepartmentUpdateResDto(long id) {
        this.id = id;
    }

    /**
	 * id
	 */
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}