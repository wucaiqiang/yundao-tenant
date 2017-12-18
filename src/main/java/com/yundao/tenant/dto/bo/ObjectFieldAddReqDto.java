package com.yundao.tenant.dto.bo;

import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 业务对象字段添加请求dto
 *
 * @author jan
 * @create 2017-07-06 PM4:18
 **/
public class ObjectFieldAddReqDto {

    /**
     * 要素名称
     */
    @ApiModelProperty(value = "要素名称")
    @Length(min = 1, max = 32, message = "{" + CodeConstant.CODE_1220001 + "}")
    private String name;

    /**
     * 业务对象编码
     */
    @NotNull(message = "{" + CodeConstant.CODE_1200030 + "}")
    @ApiModelProperty(value = "业务对象编码")
    private String boCode;

    /**
     * 业务对象字段类型编码
     */
    @ApiModelProperty(value = "类型编码")
    private String fieldTypeCode;

    /**
     * 是否必填，0：否；1：是
     */
    @ApiModelProperty(value = "是否必填，0：否；1：是")
    @NotNull(message = "{" + CodeConstant.CODE_1220003 + "}")
    private Integer isMandatory;


    /**
     * 是否通用，0：否；1：是
     */
    @ApiModelProperty(value = "是否通用，0：否；1：是")
    @NotNull(message = "{" + CodeConstant.CODE_1220004 + "}")
    private Integer isShare;


    /**
     * 是否启用，0：否；1：是
     */
    @ApiModelProperty(value = "是否启用，0：否；1：是")
    @NotNull(message = "{" + CodeConstant.CODE_1220005 + "}")
    private Integer isEnabled;


    /**
     * 权限限制
     */
    @ApiModelProperty(value = "权限限制，0：全部可见；1：部分可见")
    @NotNull(message = "{" + CodeConstant.CODE_1220007 + "}")
    private Integer access;

    /**
     * 选中的角色id
     */
    @ApiModelProperty(value = "选中的角色id,多个逗号分隔")
    private String roleIds;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sequence;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位；数值、数值区间需要传值")
    private String unit;

    @ApiModelProperty(value = "无需前端传值")
    private String selections;

    @ApiModelProperty(value = "下拉选项、单选、多选需要传值", dataType = "value,text,sequence")
    private List<SelectionDto> selectionsBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldTypeCode() {
        return fieldTypeCode;
    }

    public void setFieldTypeCode(String fieldTypeCode) {
        this.fieldTypeCode = fieldTypeCode;
    }

    public Integer getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Integer isMandatory) {
        this.isMandatory = isMandatory;
    }

    public Integer getIsShare() {
        return isShare;
    }

    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBoCode() {
        return boCode;
    }

    public void setBoCode(String boCode) {
        this.boCode = boCode;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public List<SelectionDto> getSelectionsBean() {
        return selectionsBean;
    }

    public void setSelectionsBean(List<SelectionDto> selectionsBean) {
        this.selectionsBean = selectionsBean;
    }

    public String getSelections() {
        return selections;
    }

    public void setSelections(String selections) {
        if (this.selectionsBean == null && BooleanUtils.isNotEmpty(selections)) {
            this.selectionsBean = JsonUtils.jsonToObject(selections, new BaseTypeReference<List<SelectionDto>>() {
            });
        }
        this.selections = selections;
    }
}
