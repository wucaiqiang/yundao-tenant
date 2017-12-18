package com.yundao.tenant.service.cloudfile.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.yundao.core.code.Result;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.utils.FileUtils;
import com.yundao.tenant.enums.cloud.CloudConfigEnum;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

/**
 * 阿里云文件服务实现类
 * 
 * @author wupengfei wupf86@126.com
 *
 */
@Service
public class AliyunServiceImpl extends AbstractCloudService {

	private static Log log = LogFactory.getLog(AliyunServiceImpl.class);
	@Override
	public String doUpload(byte[] bytes, String fileName) {
		String result = null;
		final String username = ConfigUtils.getValue(CloudConfigEnum.ALIYUN_USERNAME.getKey());
		final String password = ConfigUtils.getValue(CloudConfigEnum.ALIYUN_PASSWORD.getKey());
		final String endpoint = ConfigUtils.getValue(CloudConfigEnum.ALIYUN_ENDPOINT.getKey());
		final String bucketName = ConfigUtils.getValue(CloudConfigEnum.ALIYUN_BUCKET_NAME.getKey());

		OSSClient client = new OSSClient(endpoint, username, password);
		try {
			PutObjectResult putObjectResult = client.putObject(bucketName, fileName, new ByteArrayInputStream(bytes));
			log.info("上传云系返回的结果" + putObjectResult.getETag());
			result = FileUtils.getRealPath(ConfigUtils.getValue(CloudConfigEnum.ALIYUN_URL.getKey()), fileName);
		}
		finally {
			client.shutdown();
		}
		return result;
	}

	@Override
	public Result<String> getUrl() {
		String result = ConfigUtils.getValue(CloudConfigEnum.ALIYUN_URL.getKey());
		return Result.newSuccessResult(result);
	}

}
