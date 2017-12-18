

package com.yundao.tenant.service.customercenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customercenter.MyIndexDto;
import com.yundao.tenant.dto.customercenter.sale.DeclarationH5ReqDto;
import com.yundao.tenant.dto.customercenter.sale.DeclarationH5ResDto;
import com.yundao.tenant.dto.customercenter.sale.ReservationH5ReqDto;
import com.yundao.tenant.dto.customercenter.sale.ReservationH5ResDto;
import com.yundao.tenant.dto.product.add.ProductIncomeRuleDto;
import com.yundao.tenant.dto.question.RiskEvaluationResDto;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.mapper.base.cc.BaseCcUserAccountMapper;
import com.yundao.tenant.mapper.customercenter.SaleH5Mapper;
import com.yundao.tenant.mapper.product.ProductIncomeRuleMapper;
import com.yundao.tenant.model.base.cc.BaseCcUserAccount;
import com.yundao.tenant.service.customercenter.SaleH5Service;
import com.yundao.tenant.service.question.QuestionService;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.util.SymbolStrUtils;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月8日 下午4:02:17 
 * @author   欧阳利
 * @version   
 */
@Service
public class SaleH5ServiceImpl implements SaleH5Service {

	@Autowired
	SaleH5Mapper saleH5Mapper;
	
    @Autowired
    ProductIncomeRuleMapper productIncomeRuleMapper;
    
    @Autowired
    QuestionService questionService;
    
    @Autowired
    BaseCcUserAccountMapper baseCcUserAccountMapper;
	
	@Override
	public Result<PaginationSupport<DeclarationH5ResDto>> getMyDeclaration(DeclarationH5ReqDto dto)
			throws BaseException {
		PaginationSupport<DeclarationH5ResDto> result = dto.getPaginationSupport();
		
		int totalCount = saleH5Mapper.getMyDeclarationCount(dto);
		if(totalCount > 0){
			List<DeclarationH5ResDto> datas = saleH5Mapper.getMyDeclarations(dto);
			result.setDatas(datas);
			
			for(DeclarationH5ResDto resDto : datas){
				resDto.setProductIssuedStatusText(ProductIssuedStatusEnum.getEnumName(resDto.getProductIssuedStatus()));
			}
		}
		
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	/**
	 * 查询我的预约
	 */
	@Override
	public Result<PaginationSupport<ReservationH5ResDto>> getMyReservation(ReservationH5ReqDto dto)
			throws BaseException {
		PaginationSupport<ReservationH5ResDto> result = dto.getPaginationSupport();
		
		int totalCount = saleH5Mapper.getMyReservationCount(dto);
		if(totalCount > 0){
			List<ReservationH5ResDto> datas = saleH5Mapper.getMyReservations(dto);
			result.setDatas(datas);
			
            List<Long> productIds = new ArrayList<Long>();
            for(ReservationH5ResDto resDto : datas){
            	productIds.add(resDto.getId());
            }
           
            //设置收益
            List<ProductIncomeRuleDto> incomeList = productIncomeRuleMapper.selectList(SymbolStrUtils.longToStr(productIds));
            if (!BooleanUtils.isEmpty(incomeList)) {
                for (ProductIncomeRuleDto rule : incomeList) {
                    if (rule.getProductId() == null) {
                        continue;
                    }
                    for(ReservationH5ResDto productDto : datas){
                    	if (productDto.getId().equals(rule.getProductId())) {
                            List<ProductIncomeRuleDto> incomes = productDto.getPrIncomeRuleDtos();
                            if (incomes == null) {
                                incomes = new ArrayList<>();
                                productDto.setPrIncomeRuleDtos(incomes);
                            }
                            incomes.add(rule);
                        }
                    }
                    
                }
            }
			
		}
		
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);

	}
	
	
	
	/**
	 * 获取投资者的首页信息
	 * getMyIndex:
	 * @author: 欧阳利
	 * @param userId
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<MyIndexDto> getMyIndex(Long userId) throws BaseException{
		if(userId == null ){
			return Result.newFailureResult(CodeConstant.CODE_1200124);
		}
		
		BaseCcUserAccount userAccount = baseCcUserAccountMapper.selectByPrimaryKey(userId);
		if(userAccount == null ){
			return Result.newFailureResult(CodeConstant.CODE_1200128);
		}
		
		Result<RiskEvaluationResDto> result = questionService.getRiskEvaluation(userId);
		RiskEvaluationResDto resDto = null; 
		if(!result.getSuccess()){
			if(CodeConstant.CODE_1200123 != result.getCode()){
				return Result.newFailureResult(result.getCode());
			}
			 resDto = new RiskEvaluationResDto(); 
		}else{
			resDto = result.getResult();
		}
		MyIndexDto dto = new MyIndexDto();
		BeanUtils.copyProperties(resDto, dto);
		dto.setMobile(BaseContactUtils.decrypt(userAccount.getMobile()));
		return Result.newSuccessResult(dto);
	}

}

