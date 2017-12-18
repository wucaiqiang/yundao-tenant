
package com.yundao.tenant.dto.video;

import java.io.Serializable;

/**
 * Function: Reason: Date: 2017年11月6日 下午9:04:04
 * 
 * @author wucq
 * @version
 */
public class VideoQueryDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 视频名称
	 */
	private String name;
	/**
	 * 视频分类 1:路演 2：合规双录
	 */
	private Integer category;
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public Integer getCategory() {
	
		return category;
	}
	public void setCategory(Integer category) {
	
		this.category = category;
	}
	

}
