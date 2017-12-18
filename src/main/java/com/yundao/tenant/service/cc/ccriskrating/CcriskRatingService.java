

package com.yundao.tenant.service.cc.ccriskrating;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.tenant.model.base.cc.BaseCcRiskRating;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月12日 上午11:38:17 
 * @author   wucq
 * @version   
 */
public interface CcriskRatingService {
	public Result<List<BaseCcRiskRating>> getList() throws Exception ;
}

