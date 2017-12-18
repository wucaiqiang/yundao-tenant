package com.yundao.tenant.dto.customer.imports;

/**
 * 已存在的标签
 *
 * @author jan
 * @create 2017-11-29 10:42
 **/
public class ImportExistTagDto {

    private Long id;

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
