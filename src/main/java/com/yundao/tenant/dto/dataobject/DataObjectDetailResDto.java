package com.yundao.tenant.dto.dataobject;

import io.swagger.annotations.ApiModelProperty;

/**
 * 数据对象详情dto
 *
 * @author jan
 * @create 2017-07-14 PM8:37
 **/
public class DataObjectDetailResDto {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 编码
     */
    @ApiModelProperty(value = "编码")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 读取
     */
    @ApiModelProperty(value = "读取操作相关权限")
    private DataObjectSelectionDto read;
    /**
     * 修改
     */
    @ApiModelProperty(value = "修改操作相关权限")
    private DataObjectSelectionDto update;
    /**
     * 删除
     */
    @ApiModelProperty(value = "删除操作相关权限")
    private DataObjectSelectionDto delete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataObjectSelectionDto getRead() {
        return read;
    }

    public void setRead(DataObjectSelectionDto read) {
        this.read = read;
    }

    public DataObjectSelectionDto getUpdate() {
        return update;
    }

    public void setUpdate(DataObjectSelectionDto update) {
        this.update = update;
    }

    public DataObjectSelectionDto getDelete() {
        return delete;
    }

    public void setDelete(DataObjectSelectionDto delete) {
        this.delete = delete;
    }
}
