package com.yundao.tenant.service.cloudfile.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.io.ByteStreams;
import com.yundao.core.code.Result;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.enums.NumberEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.CloseableUtils;
import com.yundao.core.utils.FileUtils;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.config.CloudFileConfig;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.constant.url.BaseUrlConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.cloudfile.CloudFileUploadReqDto;
import com.yundao.tenant.enums.cloud.CloudConfigEnum;
import com.yundao.tenant.enums.cloud.CloudTypeEnum;
import com.yundao.tenant.mapper.base.BaseCloudFileMapper;
import com.yundao.tenant.mapper.cloudfile.CloudFileMapper;
import com.yundao.tenant.model.base.BaseCloudFile;
import com.yundao.tenant.model.base.BaseCloudFileExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.cloudfile.CloudFileService;
import com.yundao.tenant.service.cloudfile.CloudService;
import com.yundao.tenant.util.FolderUtils;
import com.yundao.tenant.util.HttpUtils;

@Service
public class CloudFileServiceImpl extends AbstractService implements CloudFileService{

    private static Log log = LogFactory.getLog(CloudFileServiceImpl.class);

    @Autowired
    private BaseCloudFileMapper baseCloudFileMapper;

    @Autowired
    private CloudFileMapper cloudFileMapper;

    public Result<Integer> add(BaseCloudFile cloudFile) throws Exception{
        cloudFile.setCreateDate(new Date());
        cloudFile.setId(null);
        int count = baseCloudFileMapper.insertSelective(cloudFile);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(BaseCloudFile cloudFile) throws Exception{
        cloudFile.setUpdateDate(new Date());
        int count = baseCloudFileMapper.updateByPrimaryKeySelective(cloudFile);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseCloudFile cloudFile = new BaseCloudFile();
        cloudFile.setId(id);
        cloudFile.setIsDelete(CommonConstant.ONE);
        int count = baseCloudFileMapper.updateByPrimaryKeySelective(cloudFile);
        return Result.newSuccessResult(count);
    }

    public Result<BaseCloudFile> get(Long id) throws Exception{
    	if(id == null){
    		return Result.newSuccessResult(null);
    	}
    	Map<String, Object> methodParams = new HashMap<String, Object>();
		methodParams.put("id", id);
    	Result<BaseCloudFile> result =HttpUtils.get(BaseUrlConstant.GET_CLOUD_FILE_BY_ID,
				methodParams,new BaseTypeReference<Result<BaseCloudFile>>() {});
       return result;
    }

    public Result<PaginationSupport<BaseCloudFile>> getPage(BaseCloudFile baseCloudFile, AbstractBasePageDto pageDto) throws Exception{
		BaseCloudFileExample baseCloudFileExample = new BaseCloudFileExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseCloudFileExample.Criteria criteria = baseCloudFileExample.createCriteria();
		String orderByClause="create_date desc";
		if(StringUtils.isNotBlank(pageDto.getOrderColumn())){
		  StringBuilder orderBuider=new StringBuilder();
		  orderBuider.append(pageDto.getOrderColumn()).append(" ");
		  if(StringUtils.isNotBlank(pageDto.getSort())){
			orderBuider.append(pageDto.getSort());
		  }else{
			orderBuider.append("desc");
		  }
		  orderByClause=orderBuider.toString();
		}
		baseCloudFileExample.setOrderByClause(orderByClause);
		List<BaseCloudFile> list = baseCloudFileMapper.selectByExample(baseCloudFileExample);
		int totalCount = baseCloudFileMapper.countByExample(baseCloudFileExample);
		PaginationSupport<BaseCloudFile> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

    @Override
    public Result<BaseCloudFile> add(InputStream is, String fileName, CloudFileUploadReqDto reqDto) throws Exception {
        try {
            // 校验数据
            if (is == null || BooleanUtils.isBlank(fileName)) {
                throw new BaseException(CommonCode.COMMON_1000);
            }
            // 上传文件到云
            byte[] byteArray = ByteStreams.toByteArray(is);
            String newName = fileName;
            if (reqDto.getUploadType() == null || reqDto.getUploadType() == NumberEnum.ONE.getValue()) {
                newName = FileUtils.generateFileName(fileName);
            }

            if (reqDto.getCloudType() == null) {
                reqDto.setCloudType(NumberUtils.toInt(CloudFileConfig.getValue(CloudConfigEnum.CLOUD_TYPE)));
            }

            // 生成云链接
            CloudService cloudService = getCloudService(reqDto.getCloudType());
            String realPath = getRealPath(reqDto.getFolder(), newName);
            String cloudUrl = getCloudUrl(cloudService, realPath);

            long begin = System.currentTimeMillis();
            cloudService.upload(byteArray, realPath, reqDto.getIsAsync());
            log.info("上传云系统consumeTime=" + (System.currentTimeMillis() - begin));

            // 保存云文件数据
            begin = System.currentTimeMillis();
            BaseCloudFile cloud = this.insertCloud(reqDto.getCloudType(), cloudUrl,fileName);
            log.info("保存云数据consumeTime=" + (System.currentTimeMillis() - begin));

            log.end();
            return Result.newSuccessResult(cloud);
        }
        finally {
            CloseableUtils.close(is);
        }
    }

    /**
     * 保存到云文件数据
     *
     * @param cloudType
     * @param cloudUrl
     */
    private BaseCloudFile insertCloud(int cloudType, String cloudUrl,String originalName) {
        BaseCloudFile cloud = new BaseCloudFile();
        cloud.setType(cloudType);
        cloud.setUrl(cloudUrl);
        cloud.setOriginalName(originalName);
        cloud.setCreateDate(new Date());
        baseCloudFileMapper.insertSelective(cloud);
        return cloud;
    }

    /**
     * 获取云枚举
     *
     * @param cloudType
     * @return
     * @throws BaseException
     */
    public static CloudService getCloudService(Integer cloudType) throws BaseException {
        CloudTypeEnum cloudTypeEnum = CloudTypeEnum.getCloudTypeEnum(cloudType);
        CloudService result = null;
        if (cloudTypeEnum == null || (result = cloudTypeEnum.getCloudService()) == null) {
            throw new BaseException(GJLCodeConstant.CODE_1210000);
        }
        return result;
    }

    public static String getRealPath(String folder, String fileName) {
        String result = null;
        if (BooleanUtils.isBlank(folder)) {
            folder = FolderUtils.generateFolder(folder);
        }
        result = FileUtils.getRealPath(folder, fileName);
        return result;
    }

    public static String getCloudUrl(CloudService cloudService, String realPath) {
        String url = cloudService.getUrl().getResult();
        return FileUtils.getRealPath(url, realPath);
    }
}
