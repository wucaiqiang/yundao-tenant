package com.yundao.tenant.dto.dataobject;

/**
 * 数据对象请求dto
 *
 * @author jan
 * @create 2017-07-15 AM11:35
 **/
public class DataObjectReqDto {

    /**
     * 数据对象id
     */
    private Long id;

    /**
     * 读取
     */
    private Integer read;

    /**
     * 更新
     */
    private Integer update;

    /**
     * 删除
     */
    private Integer delete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getUpdate() {
        return update;
    }

    public void setUpdate(Integer update) {
        this.update = update;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }
}
