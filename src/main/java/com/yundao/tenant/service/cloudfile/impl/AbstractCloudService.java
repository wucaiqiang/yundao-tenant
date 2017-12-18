package com.yundao.tenant.service.cloudfile.impl;

import com.yundao.core.code.Result;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.config.system.SystemFileConfig;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.enums.NumberEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.utils.ThreadUtils;
import com.yundao.tenant.enums.cloud.SystemEnum;
import com.yundao.tenant.service.cloudfile.CloudService;
import org.apache.commons.lang.math.NumberUtils;

/**
 * 抽象云文件服务类
 * 
 * @author wupengfei wupf86@126.com
 *
 */
public abstract class AbstractCloudService implements CloudService {

	private static Log log = LogFactory.getLog(AbstractCloudService.class);

	@Override
	public Result<String> upload(byte[] bytes, String fileName, Integer isAsync) throws BaseException {
		try {
			String result = null;
			final long begin = System.currentTimeMillis();

			// 获取异步的大小
			long asyncSize = NumberUtils.toLong(SystemFileConfig.getValue(SystemEnum.ASYNC_SIZE.getKey()));
			long fileSize = bytes.length;
			boolean isPicture = this.isPicture(fileName);
			log.info("fileSize=" + fileSize + ",fileName=" + fileName + ",isAsync=" + isAsync + ",isPicture="
					+ isPicture);
			if (isAsync == null && fileSize >= asyncSize && !isPicture
					|| isAsync != null && isAsync == NumberEnum.ONE.getValue()) {
				final String newFileName = fileName;
				final byte[] newByte = bytes;
				ThreadUtils.execute(new Runnable() {
					@Override
					public void run() {
						log.info("开始异步上传到云系统fileName=" + newFileName);
						AbstractCloudService.this.doUpload(newByte, newFileName);
						log.info("异步上传文件成功consumeTime=" + (System.currentTimeMillis() - begin));
					}
				});
			}
			else {
				log.info("开始上传到云系统，fileName=" + fileName);
				result = this.doUpload(bytes, fileName);
				log.info("上传文件成功consumeTime=" + (System.currentTimeMillis() - begin));
			}
			return Result.newSuccessResult(result);
		}
		catch (Exception e) {
			log.error("上传文件时异常", e);
			throw new BaseException(CommonCode.COMMON_1046);
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param bytes
	 * @param fileName
	 * @return
	 */
	public abstract String doUpload(byte[] bytes, String fileName);

	/**
	 * 是否图片
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean isPicture(String fileName) {
		boolean result = false;
		int index = fileName.lastIndexOf(".");
		if (index != -1) {
			String ext = fileName.substring(index + 1);
			String[] exts = ConfigUtils.getValue(SystemEnum.PICTURE_EXT.getKey())
					.split(CommonConstant.COMMA_SEMICOLON);
			for (String each : exts) {
				if (each.equalsIgnoreCase(ext)) {
					return true;
				}
			}
		}
		return result;
	}
}
