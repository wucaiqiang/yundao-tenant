

package com.yundao.tenant.service.sale.declaration.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.video.VideoAddReqDto;
import com.yundao.tenant.enums.sale.declaration.DeclarationVideoTypeEnum;
import com.yundao.tenant.enums.video.VideoCategoryEnum;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationVideoMapper;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationVideo;
import com.yundao.tenant.model.base.sale.BaseDeclarationVideoExample;
import com.yundao.tenant.model.base.video.BaseVideo;
import com.yundao.tenant.model.sale.DeclarationVideoDto;
import com.yundao.tenant.service.sale.declaration.DeclarationVideoService;
import com.yundao.tenant.service.video.VideoService;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月29日 下午5:56:36 
 * @author   欧阳利
 * @version   
 */
@Service
public class DeclarationVideoServiceImpl extends AbstractService implements DeclarationVideoService {

	@Autowired
	BaseDeclarationVideoMapper baseDeclarationVideoMapper;
	@Autowired
	private VideoService videoService;
	
	@Override
	public Result<Integer> updateComplianceRecord(String compliance, BaseDeclaration declaration)throws BaseException {
 		// 对象转换
		List<DeclarationVideoDto> currentList = null;
		if (BooleanUtils.isNotEmpty(compliance)) {
			currentList = JsonUtils.jsonToObject(compliance,
					new BaseTypeReference<List<DeclarationVideoDto>>() {
					});
		}
		// 如果当期合规双录为空就清空所有合规双录
		if(BooleanUtils.isEmpty(currentList)){
			BaseDeclarationVideoExample example = new BaseDeclarationVideoExample();
			example.createCriteria().andDeclarationIdEqualTo(declaration.getId());
			baseDeclarationVideoMapper.deleteByExample(example);
			return Result.newSuccessResult(0);
		}
		// 查询老的合规双录视频
		BaseDeclarationVideoExample selectExample = new BaseDeclarationVideoExample();
		selectExample.createCriteria().andDeclarationIdEqualTo(declaration.getId());
		List<BaseDeclarationVideo> oldList = baseDeclarationVideoMapper.selectByExample(selectExample);
		
		// 查询存在合规双录视频
		List<String> fieldIds = new ArrayList<String>();
		for(DeclarationVideoDto dto : currentList){
			fieldIds.add(dto.getFileId());
		}
		List<BaseVideo> videoList = videoService.getBaseVideos(fieldIds);
		
		// 删除不存在的合规双录
		deleteComplianceRecord(oldList,videoList );
		
        // 添加合规双录
		addComplianceRecord(currentList,videoList, declaration);
		
		return Result.newSuccessResult(1);
	}

	/**
	 * 删除不存在的合规双录
	 * deleteComplianceRecord:
	 * @author: 欧阳利
	 * @param oldList
	 * @param videoList
	 * @throws BaseException
	 * @description:
	 */
	private void deleteComplianceRecord(List<BaseDeclarationVideo> oldList,List<BaseVideo> videoList )throws BaseException{
		if(!BooleanUtils.isEmpty(oldList)){
			for(BaseDeclarationVideo old : oldList){
				if(old.getVideoId() == null){
					continue;
				}
				boolean isExist = false;
				for(BaseVideo dto : videoList){
					if(old.getVideoId().equals(dto.getId())){
						isExist = true;
					}
				}
				
				if(!isExist){
					BaseDeclarationVideoExample example = new BaseDeclarationVideoExample();
					example.createCriteria().andIdEqualTo(old.getId());
					baseDeclarationVideoMapper.deleteByExample(example);
					// 删除视频
					videoService.delete(old.getVideoId().toString());
				}
			}
		}
	}
	
	
	
	/**
	 * 添加合规双录
	 * addComplianceRecord:
	 * @author: 欧阳利
	 * @param currentList
	 * @param videoList
	 * @param declaration
	 * @throws BaseException
	 * @description:
	 */
	private void addComplianceRecord(List<DeclarationVideoDto> currentList,List<BaseVideo> videoList, BaseDeclaration declaration)throws BaseException {
		for(DeclarationVideoDto dto : currentList){
			boolean isExist = false;
			for(BaseVideo video : videoList){
				if(dto.getFileId().equals(video.getRefId())){
					isExist = true;
				}
			}
			
			
			if(!isExist){
				VideoAddReqDto videoAddReqDto = new VideoAddReqDto();
				BeanUtils.copyProperties(dto, videoAddReqDto);
				videoAddReqDto.setCategory(VideoCategoryEnum.COMPLIANCE.getValue());
				Long videoId = videoService.addSimple(videoAddReqDto).getResult();
				
				BaseDeclarationVideo record = new BaseDeclarationVideo();
				record.setDeclarationId(declaration.getId());
				record.setVideoId(videoId);
				record.setTenantId(this.getHeaderTenantId());
				record.setIsDelete(0);
				record.setType(DeclarationVideoTypeEnum.COMPLIANCE_RECORD.getValue());
				record.setCreateDate(new Date());
				record.setCreateUserId(this.getHeaderUserId());
				baseDeclarationVideoMapper.insert(record);
			}
		}
	}
	
	

	@Override
	public List<Long> getComplianceRecordVideoId(Long declarationId) {
		if(declarationId == null){
			return null;
		}
		BaseDeclarationVideoExample example = new BaseDeclarationVideoExample();
		example.createCriteria().andDeclarationIdEqualTo(declarationId).andTypeEqualTo(DeclarationVideoTypeEnum.COMPLIANCE_RECORD.getValue());
		List<BaseDeclarationVideo> list = baseDeclarationVideoMapper.selectByExample(example);
		if(BooleanUtils.isEmpty(list)){
			return null;
		}
		List<Long> videoIds = new ArrayList<Long>();
		for(BaseDeclarationVideo base : list){
			if(base.getVideoId() != null){
				videoIds.add(base.getVideoId());
			}
		}
		return videoIds;
	}

}

