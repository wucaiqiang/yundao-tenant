
package com.yundao.tenant.service.tencent;

import java.util.List;
import java.util.Map;

import com.yundao.tenant.dto.tencent.ClassAddDto;
import com.yundao.tenant.dto.tencent.VideoDetailDto;
import com.yundao.tenant.dto.tencent.VodBaseDto;
import com.yundao.tenant.dto.tencent.VodTaskDto;

/**
 * Function: Reason: Date: 2017年11月3日 下午3:11:26
 * 
 * @author wucq
 * @version
 */
public interface TencentService {
	public ClassAddDto addClass(String className) throws Exception;

	public VodBaseDto updateClass(Integer classId, String className) throws Exception;

	public VideoDetailDto getInfo(String fileId) throws Exception;
	public VodTaskDto convertVodFile(String fileId) throws Exception;
	public VodBaseDto delete(String fileId) throws Exception;
	/**
	 * 拉取转码成功后的通知消息信息
	 * getPullEvent:
	 * @author: wucq
	 * @return 文件ID集合
	 * @throws Exception
	 * @description:
	 */
	public Map<String, List<String>> getPullEvent() throws Exception;
	public void clearPullEvent() throws Exception;
}
