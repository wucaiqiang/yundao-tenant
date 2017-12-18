
package com.yundao.tenant.dto.common;

import java.io.Serializable;

/**
 * Function: Reason: Date: 2017年8月10日 下午7:45:02
 * 
 * @author wucq
 * @version
 */
public class FileBaseDto implements Serializable {
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String url;
	private Integer seqencing;
	public Integer getId() {
	
		return id;
	}
	public void setId(Integer id) {
	
		this.id = id;
	}
	public String getUrl() {
	
		return url;
	}
	public void setUrl(String url) {
	
		this.url = url;
	}
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public Integer getSeqencing() {
	
		return seqencing;
	}
	public void setSeqencing(Integer seqencing) {
	
		this.seqencing = seqencing;
	}
	
}
