

package com.yundao.tenant.dto.platform;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月20日 下午2:05:40 
 * @author   欧阳利
 * @version   
 */
public class PlatformDto {
    private Long id;
    
    private String name;

	private String code;

	private String url;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

