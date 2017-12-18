package com.yundao.tenant.dto.common;

import com.yundao.core.utils.BooleanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据权限操作结果集
 *
 * @author jan
 * @create 2017-07-09 PM4:27
 **/
public class PermissionResultDto {

    private List<FailListDto> failList;


    /**
     * 允许操作的结果集
     */
    private List<PassListDto> passList;


    /**
     * 是否成功，即没有任何失败信息
     *
     * @return
     */
    public Boolean isSuccess() {
        return BooleanUtils.isEmpty(this.failList);
    }

    public List<FailListDto> getFailList() {
        if (this.failList == null)
            this.failList = new ArrayList<>();
        return failList;
    }

    public void setFailList(List<FailListDto> failList) {
        this.failList = failList;
    }

    public PermissionResultDto(List<FailListDto> failList) {
        this.failList = failList;
    }

    public PermissionResultDto(List<FailListDto> failList, List<PassListDto> passList) {
        this.failList = failList;
        this.passList = passList;
    }

    public PermissionResultDto() {
    }

    public List<PassListDto> getPassList() {
        if (this.passList == null)
            this.passList = new ArrayList<>();
        return this.passList;
    }

    public void setPassList(List<PassListDto> passList) {
        this.passList = passList;
    }
}
