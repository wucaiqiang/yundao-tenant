
package com.yundao.tenant.dto.tencent;

/**
 * Function: Reason: Date: 2017年11月3日 下午3:32:59
 * 
 * @author wucq
 * @version
 */
public class VideoDetailDto extends VodBaseDto {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 包括视频名称、大小、时长、封面图片等；
	 */
	private VideoBasicInfo basicInfo;
	/**
	 * 包括视频流信息、音频流信息等；
	 */
	private VideoMetaData metaData;
	/**
	 * 包括该视频转码生成的各种码率的视频的地址、规格、码率、分辨率等；
	 */
	private VideoTransCodeInfo transcodeInfo;
	public VideoBasicInfo getBasicInfo() {
	
		return basicInfo;
	}
	public void setBasicInfo(VideoBasicInfo basicInfo) {
	
		this.basicInfo = basicInfo;
	}
	public VideoMetaData getMetaData() {
	
		return metaData;
	}
	public void setMetaData(VideoMetaData metaData) {
	
		this.metaData = metaData;
	}
	public VideoTransCodeInfo getTranscodeInfo() {
	
		return transcodeInfo;
	}
	public void setTranscodeInfo(VideoTransCodeInfo transcodeInfo) {
	
		this.transcodeInfo = transcodeInfo;
	}

}
