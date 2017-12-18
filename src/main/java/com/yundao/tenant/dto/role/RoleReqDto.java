package com.yundao.tenant.dto.role;

import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;

import javax.validation.constraints.NotNull;

/**
 * 添加或更新角色
 *
 * @author jan
 * @create 2017-06-22 PM3:00
 **/
public class RoleReqDto {

    /**
     * 角色id
     */
    @NotNull(message = "{" + CodeConstant.CODE_1200000 + "}", groups = {Update.class})
    private Long id;

    /**
     * 角色名称
     */
    @Length(min = 1, max = 32, message = "{" + CodeConstant.CODE_1200002 + "}", groups = {Insert.class, Update.class})
    private String name;

    /**
     * 描述
     */
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
