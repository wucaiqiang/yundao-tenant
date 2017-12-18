package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseFieldType extends BaseModel implements Serializable {
    /**
	 * 名字
	 */
    private String name;

    /**
	 * 编码
	 */
    private String code;

    /**
	 * 描述
	 */
    private String description;

    /**
	 * 演示图片
	 */
    private String demoPicture;

    /**
	 * 类型，0：多选，1：单选，2：文本域，3：文本，4：数字，5：日期，6：图片，7：日期区间
	 */
    private Integer type;

    /**
	 * 是否可搜索，0：否，1：是
	 */
    private Integer isSearch;

    /**
	 * 是否共用，0：否，1：是
	 */
    private Integer isShare;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDemoPicture() {
        return demoPicture;
    }

    public void setDemoPicture(String demoPicture) {
        this.demoPicture = demoPicture;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsSearch() {
        return isSearch;
    }

    public void setIsSearch(Integer isSearch) {
        this.isSearch = isSearch;
    }

    public Integer getIsShare() {
        return isShare;
    }

    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}