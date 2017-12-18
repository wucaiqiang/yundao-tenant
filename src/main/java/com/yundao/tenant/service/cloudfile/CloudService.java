package com.yundao.tenant.service.cloudfile;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;

/**
 * 云文件服务接口
 * 
 * @author wupengfei wupf86@126.com
 *
 */
public interface CloudService {

	/**
	 * 上传文件，成功后返回云链接
	 * 
	 * @param bytes
	 * @param fileName
	 * @param isAsync
	 * @return
	 * @throws BaseException
	 */
	public Result<String> upload(byte[] bytes, String fileName, Integer isAsync) throws BaseException;

	/**
	 * 获取云链接
	 * 
	 * @return
	 */
	public Result<String> getUrl();

}
