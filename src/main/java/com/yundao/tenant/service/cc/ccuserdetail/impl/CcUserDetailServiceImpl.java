package com.yundao.tenant.service.cc.ccuserdetail.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.cc.ccuserdetail.CcUserDetailReqDto;
import com.yundao.tenant.dto.cc.ccuserdetail.CcUserInfoDto;
import com.yundao.tenant.mapper.base.cc.BaseCcRiskRatingMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcUserDetailMapper;
import com.yundao.tenant.mapper.cc.ccuserdetail.CcUserDetailMapper;
import com.yundao.tenant.model.base.cc.BaseCcRiskRating;
import com.yundao.tenant.model.base.cc.BaseCcRiskRatingExample;
import com.yundao.tenant.model.base.cc.BaseCcUserDetail;
import com.yundao.tenant.model.base.cc.BaseCcUserDetailExample;
import com.yundao.tenant.service.cc.ccuserdetail.CcUserDetailService;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.util.MobileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CcUserDetailServiceImpl extends AbstractService implements CcUserDetailService {

    private static Log log = LogFactory.getLog(CcUserDetailServiceImpl.class);

    @Autowired
    private BaseCcUserDetailMapper baseCcUserDetailMapper;

    @Autowired
    private BaseCcRiskRatingMapper baseCcRiskRatingMapper;

    @Autowired
    private CcUserDetailMapper ccUserDetailMapper;

    public Result<Integer> add(CcUserDetailReqDto reqDto) throws Exception {
        BaseCcUserDetail model = new BaseCcUserDetail();
        BeanUtils.copyProperties(reqDto, model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseCcUserDetailMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(CcUserDetailReqDto reqDto) throws Exception {
        BaseCcUserDetail model = new BaseCcUserDetail();
        BeanUtils.copyProperties(reqDto, model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseCcUserDetailMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception {
        BaseCcUserDetail ccUserDetail = new BaseCcUserDetail();
        ccUserDetail.setId(id);
        ccUserDetail.setUpdateDate(new Date());
        ccUserDetail.setUpdateUserId(super.getHeaderUserId());
        int count = baseCcUserDetailMapper.updateByPrimaryKeySelective(ccUserDetail);
        return Result.newSuccessResult(count);
    }

    public Result<BaseCcUserDetail> get(Long id) throws Exception {
        BaseCcUserDetail model = baseCcUserDetailMapper.selectByPrimaryKey(id);
        return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseCcUserDetail>> getPage(CcUserDetailReqDto ccUserDetailReqDto, AbstractBasePageDto pageDto) throws Exception {
        BaseCcUserDetailExample baseCcUserDetailExample = new BaseCcUserDetailExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
        BaseCcUserDetailExample.Criteria criteria = baseCcUserDetailExample.createCriteria();
        String orderByClause = "create_date desc";
        if (StringUtils.isNotBlank(pageDto.getOrderColumn())) {
            StringBuilder orderBuider = new StringBuilder();
            orderBuider.append(pageDto.getOrderColumn()).append(" ");
            if (StringUtils.isNotBlank(pageDto.getSort())) {
                orderBuider.append(pageDto.getSort());
            } else {
                orderBuider.append("desc");
            }
            orderByClause = orderBuider.toString();
        }
        baseCcUserDetailExample.setOrderByClause(orderByClause);
        List<BaseCcUserDetail> list = baseCcUserDetailMapper.selectByExample(baseCcUserDetailExample);
        int totalCount = baseCcUserDetailMapper.countByExample(baseCcUserDetailExample);
        PaginationSupport<BaseCcUserDetail> result = pageDto.getPaginationSupport();
        result.setDatas(list);
        result.setTotalCount(totalCount);
        return Result.newSuccessResult(result);
    }

    @Override
    public Result<CcUserInfoDto> getInfo() throws BaseException {
        String logPrefix = "用户详情||获取理财用户的信息||";
        Long userId = super.getHeaderUserId();
        log.info("%s userId %s", logPrefix, userId);

        //获取用户信息
        CcUserInfoDto userInfo = ccUserDetailMapper.selectUserInfo(userId);
        if (userInfo == null)
            throw new BaseException(CodeConstant.CODE_1200018);

        userInfo.setMobile(BaseContactUtils.decrypt(userInfo.getMobile()));
        userInfo.setMobile(MobileUtil.encrypt(userInfo.getMobile()));
        //根据用户的分数，获取评估等级
        if (userInfo.getId() != null) {
            userInfo.setEvaluating(true);
            Integer grade = userInfo.getGrade() == null ? 0 : userInfo.getGrade();

            BaseCcRiskRatingExample riskExample = new BaseCcRiskRatingExample();
            riskExample.createCriteria().andGradeMaxGreaterThanOrEqualTo(grade)
                    .andGradeMinLessThanOrEqualTo(grade);
            BaseCcRiskRating riskRating = baseCcRiskRatingMapper.selectOne(riskExample);
            log.info("%s riskRating %s", logPrefix, JsonUtils.objectToJson(riskRating));
            if (riskRating == null)
                userInfo.setRiskRatingText("--");
            else
                userInfo.setRiskRatingText(riskRating.getLabel());
        } else {
            userInfo.setEvaluating(false);
        }
        log.info("%s 完成");
        return Result.newSuccessResult(userInfo);
    }

}
