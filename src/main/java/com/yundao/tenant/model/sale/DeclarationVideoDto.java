
package com.yundao.tenant.model.sale;

/**
 * Function: Reason: Date: 2017年11月29日 下午7:04:46
 * 
 * @author 欧阳利
 * @version
 */
public class DeclarationVideoDto {
	private String fileId;

	private String name;

	private Long size;
	/**
	 * 源文件地址
	 */
	private String sourceUrl;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Long getSize() {

		return size;
	}

	public void setSize(Long size) {

		this.size = size;
	}

	public String getFileId() {

		return fileId;
	}

	public void setFileId(String fileId) {

		this.fileId = fileId;
	}

	public String getSourceUrl() {
	
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
	
		this.sourceUrl = sourceUrl;
	}
	
}
