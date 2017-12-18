package com.yundao.tenant.dto.resource;

import com.yundao.core.enums.NumberEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限资源DTO
 *
 * @author jan
 * @create 2017-06-21 AM8:45
 **/
public class MenuResDto implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * 资源id
     */
    private Long id;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 编码
     */
    private String code;

    /**
     * 地址
     */
    private String url;

    /**
     * 地址
     */
    private String path;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 是否选中 1：是；0：否
     */
    private Integer check;

    /**
     * 是否显示 1:是否；0：否
     */
    private Integer display;

    /**
     * 是否显示
     */
    private Integer isDeplay;

    /**
     * 排序，越小越前
     */
    private Integer sequence;

    private List<MenuResDto> childs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        if (this.check == null)
            this.check = NumberEnum.ZERO.getValue();
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

    public List<MenuResDto> getChilds() {
        if (this.childs == null)
            this.childs = new ArrayList<>();
        return this.childs;
    }

    public void setChilds(List<MenuResDto> childs) {
        this.childs = childs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getIsDeplay() {
        return isDeplay;
    }

    public void setIsDeplay(Integer isDeplay) {
        this.isDeplay = isDeplay;
    }
}
