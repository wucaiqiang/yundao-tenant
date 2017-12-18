package com.yundao.tenant.dto.common;

/**
 * 通过结果集
 *
 * @author jan
 * @create 2017-07-13 AM11:18
 **/
public class PassListDto {

    /**
     * 对象的id
     */
    private Long id;

    /**
     * 对象的名称
     */
    private String name;

    public PassListDto() {
    }

    public PassListDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
