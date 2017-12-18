package com.yundao.tenant.dto.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * id&name dto
 *
 * @author jan
 * @create 2017-07-05 PM5:53
 **/
public class IdNameDto {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * name
     */
    @ApiModelProperty(value = "name")
    private String name;

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
}
