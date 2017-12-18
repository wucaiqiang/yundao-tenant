package com.yundao.tenant.model.base.msg;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseMsgTemplateType extends BaseModel implements Serializable {
    /**
	 * 动态类型名称
	 */
    private String name;

    /**
	 * 1、动态 2、消息
	 */
    private Integer type;

    /**
	 * 对应消息：1、代办   2、消息
  对应动态
:1、服务轨迹   2、客户行为
	 */
    private Integer firstType;

    /**
	 * 消息二级是：1、客户 ，2、产品 ，3、待回访，4、待跟进，5、待审核，6、待确认，7、交易    动态的二级类型  1、客户行为  2、客户  3、交易
	 */
    private Integer twoType;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFirstType() {
        return firstType;
    }

    public void setFirstType(Integer firstType) {
        this.firstType = firstType;
    }

    public Integer getTwoType() {
        return twoType;
    }

    public void setTwoType(Integer twoType) {
        this.twoType = twoType;
    }
}