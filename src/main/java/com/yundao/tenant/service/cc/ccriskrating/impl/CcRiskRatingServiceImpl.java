

package com.yundao.tenant.service.cc.ccriskrating.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.mapper.base.cc.BaseCcRiskRatingMapper;
import com.yundao.tenant.model.base.cc.BaseCcRiskRating;
import com.yundao.tenant.model.base.cc.BaseCcRiskRatingExample;
import com.yundao.tenant.service.cc.ccriskrating.CcriskRatingService;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月12日 上午11:39:20 
 * @author   wucq
 * @version   
 */
@Service
public class CcRiskRatingServiceImpl extends AbstractService implements CcriskRatingService {
	@Autowired
    private BaseCcRiskRatingMapper BaseCcRiskRatingMapper;
    
	@Override
	public Result<List<BaseCcRiskRating>> getList() throws Exception {
		BaseCcRiskRatingExample example=new BaseCcRiskRatingExample();
		example.createCriteria().andIsDeleteEqualTo(0);
		List<BaseCcRiskRating> baseCcRiskRatings=BaseCcRiskRatingMapper.selectByExample(example);
		return Result.newSuccessResult(baseCcRiskRatings);
		
	}

}

