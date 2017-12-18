
package com.yundao.tenant.dto.tencent;

/**
 * Function: Reason: Date: 2017年11月3日 下午3:32:59
 * 
 * @author wucq
 * @version
 */
public class ClassAddDto extends VodBaseDto {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 新生成的分类id，最上层分类的id为-1
	 */
	private String newClassId;

	public String getNewClassId() {

		return newClassId;
	}

	public void setNewClassId(String newClassId) {

		this.newClassId = newClassId;
	}

}
