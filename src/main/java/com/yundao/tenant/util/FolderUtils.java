package com.yundao.tenant.util;

import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.utils.FileUtils;
import com.yundao.tenant.enums.cloud.CloudConfigEnum;
import com.yundao.tenant.config.CloudFileConfig;
import org.apache.commons.lang.math.NumberUtils;

/**
 * 目录工具类
 *
 * @author wupengfei wupf86@126.com
 *
 */
public abstract class FolderUtils {

	/**
	 * 生成新的目录名，规则是：系统标识（如果配置）+folder（如果为空则置为默认目录）
	 * 
	 * @param folder
	 * @return
	 */
	public static String generateFolder(String folder) {
		String result = "";

		// 是否需要增加系统标识
		int isAdd = NumberUtils.toInt(ConfigUtils.getValue(CloudConfigEnum.IS_ADD_SYSTEM_ID.getKey()));
		if (isAdd == 1) {
			result = ThreadLocalUtils.getRequestCommonParams().getId();
		}

		// 若为空则置为默认目录
		if (BooleanUtils.isBlank(folder)) {
			folder = CloudFileConfig.getValue(CloudConfigEnum.DEFAULT_FOLDER);
		}

		return FileUtils.getRealPath(result, folder);
	}

}
