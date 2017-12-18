package com.yundao.tenant.service.product.productnotice.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.FileDto;
import com.yundao.tenant.dto.common.FailListDto;
import com.yundao.tenant.dto.common.PassListDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.productnotice.ProductNoticePageReqDto;
import com.yundao.tenant.dto.productnotice.ProductNoticeReqDto;
import com.yundao.tenant.enums.ExamineGroupEnum;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.enums.productnotice.NoticeSendEnum;
import com.yundao.tenant.enums.productnotice.NoticeSendStatusEnum;
import com.yundao.tenant.enums.productnotice.NoticeStatusEnum;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeAttachMapper;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeExamineMapper;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeMapper;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeTypeMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationMapper;
import com.yundao.tenant.mapper.product.productnotice.ProductNoticeMapper;
import com.yundao.tenant.mapper.product.productnoticeattach.ProductNoticeAttachMapper;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductExample;
import com.yundao.tenant.model.base.product.BaseProductNotice;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttach;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttachExample;
import com.yundao.tenant.model.base.product.BaseProductNoticeExamine;
import com.yundao.tenant.model.base.product.BaseProductNoticeExamineExample;
import com.yundao.tenant.model.base.product.BaseProductNoticeExample;
import com.yundao.tenant.model.base.product.BaseProductNoticeExample.Criteria;
import com.yundao.tenant.model.base.product.BaseProductNoticeType;
import com.yundao.tenant.model.base.product.BaseProductNoticeTypeExample;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationExample;
import com.yundao.tenant.model.productnotice.ProductNoticeModel;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.product.productnotice.ProductNoticeAudit;
import com.yundao.tenant.service.product.productnotice.ProductNoticeService;
import com.yundao.tenant.service.resource.ResourceService;
import com.yundao.tenant.util.ArgsUtils;
import com.yundao.tenant.util.CamelUtil;
import com.yundao.tenant.util.LocalBeanUtils;

@Service
public class ProductNoticeServiceImpl extends AbstractService implements ProductNoticeService{

    private static Log log = LogFactory.getLog(ProductNoticeServiceImpl.class);

    @Autowired
    private BaseProductNoticeMapper baseProductNoticeMapper;

    @Autowired
    private BaseProductMapper baseProductMapper;

    @Autowired
    private BaseProductNoticeTypeMapper baseProductNoticeTypeMapper;

    @Autowired
    private BaseProductNoticeAttachMapper baseProductNoticeAttachMapper;

    @Autowired
    private ProductNoticeMapper productNoticeMapper;

    @Autowired
    private ProductNoticeAttachMapper productNoticeAttachMapper;

    @Autowired
    private BaseProductNoticeExamineMapper baseProductNoticeExamineMapper;

    @Autowired
    private MsgMessageService msgMessageService;

    @Autowired
    private BaseDeclarationMapper baseDeclarationMapper;

    private String defaultSortName = "create_date";
    private String defaultSort = "desc";

    @Autowired
    private ResourceService resourceService;
    
    @Autowired
    private ProductNoticeAudit productNoticeAudit;

    public Result<Integer> add(ProductNoticeReqDto dto) throws Exception{
        //如果选择了定时发送就需要输入定时发送时间
        if(dto.getIsTimingSend() != null && dto.getIsTimingSend() == 1){
            if(dto.getSendTime() == null){
                throw new BaseException(GJLCodeConstant.CODE_1210014);
            }else if(DateUtils.getDistanceTimes(dto.getSendTime(),new Date()) < 0){
                throw new BaseException(GJLCodeConstant.CODE_1210030);
            }
        }
        validata(dto);
        BaseProductNotice productNotice = new BaseProductNotice();
        BeanUtils.copyProperties(dto,productNotice);
        productNotice.setCreateDate(new Date());
        productNotice.setId(null);
        productNotice.setStatus(NoticeStatusEnum.STATUS_1.getStatus());
        productNotice.setTenantId(super.getHeaderTenantId());
        productNotice.setCreateUserId(super.getHeaderUserId());
        int count = baseProductNoticeMapper.insertSelective(productNotice);
        //新增附件
        if(dto.getFilesList() != null && !dto.getFilesList().isEmpty()){
            List<FileDto> fileDtos = dto.getFilesList();
            for (FileDto fileDto : fileDtos){
               addNoticeAttache(fileDto,productNotice.getId());
            }
        }
        return Result.newSuccessResult(count);
    }

    private void validata(ProductNoticeReqDto dto) throws BaseException {
        Long productId = dto.getProductId();
        BaseProduct product = baseProductMapper.selectByPrimaryKey(productId);
        if(product == null){
            throw new BaseException(GJLCodeConstant.CODE_1210027);
        }
        Long noticeTypeId = dto.getNoticeTypeId();
        BaseProductNoticeType productNoticeType = baseProductNoticeTypeMapper.selectByPrimaryKey(noticeTypeId);
        if(productNoticeType ==  null){
            throw new BaseException(GJLCodeConstant.CODE_1210028);
        }
        if(dto.getFilesList() != null && dto.getFilesList().size() > 5){
            throw new BaseException(GJLCodeConstant.CODE_1210015);
        }
    }

    private void addNoticeAttache(FileDto fileDto,Long noticeId) {
        BaseProductNoticeAttach productNoticeAttach = new BaseProductNoticeAttach();
        productNoticeAttach.setNoticeId(noticeId);
        productNoticeAttach.setSourceName(fileDto.getFileName());
        productNoticeAttach.setUrl(fileDto.getFileUrl());
        productNoticeAttach.setType(fileDto.getFileType());
        productNoticeAttach.setCreateUserId(super.getHeaderUserId());
        productNoticeAttach.setCreateDate(new Date());
        baseProductNoticeAttachMapper.insertSelective(productNoticeAttach);
    }

    public Result<Integer> update(ProductNoticeReqDto dto) throws Exception{
        validata(dto);
        //公告id不存在
        BaseProductNotice notice = baseProductNoticeMapper.selectByPrimaryKey(dto.getId());
        if(notice == null){
            throw new BaseException(GJLCodeConstant.CODE_1210031);
        }
        if(!notice.getStatus().equals(NoticeStatusEnum.STATUS_1.getStatus()) && !notice.getStatus().equals(NoticeStatusEnum.STATUS_4.getStatus()) && !notice.getStatus().equals(NoticeStatusEnum.STATUS_5.getStatus())){
            throw new BaseException(GJLCodeConstant.CODE_1210029);
        }

        BaseProductNotice productNotice = new BaseProductNotice();
        BeanUtils.copyProperties(dto,productNotice);
        productNotice.setUpdateDate(new Date());
        productNotice.setUpdateUserId(super.getHeaderUserId());
        int count = baseProductNoticeMapper.updateByPrimaryKeySelective(productNotice);
        //如果附件发生改变就编辑
        BaseProductNoticeAttachExample example = new BaseProductNoticeAttachExample();
        example.createCriteria().andNoticeIdEqualTo(dto.getId());
        if(dto.getFilesList() == null || dto.getFilesList().isEmpty()){
            productNoticeAttachMapper.deleteByNoticeId(dto.getId(),super.getHeaderUserId(),new Date());
        }else{
            List<BaseProductNoticeAttach> attaches = baseProductNoticeAttachMapper.selectByExample(example);

            //获取新增的对象
            for(FileDto fileDto : dto.getFilesList()){
                boolean isAdd = true;
                for (BaseProductNoticeAttach attach : attaches){
                    if(fileDto.getFileUrl().equals(attach.getUrl())){
                        isAdd = false;
                    }
                }
                if(isAdd){
                    addNoticeAttache(fileDto,dto.getId());
                }
            }

            //获取删除对象
            for (BaseProductNoticeAttach attach : attaches){
                boolean isDel = true;
                for(FileDto fileDto : dto.getFilesList()){
                    if(fileDto.getFileUrl().equals(attach.getUrl())){
                        isDel = false;
                    }
                }
                if(isDel){
                    baseProductNoticeAttachMapper.deleteByPrimaryKey(attach.getId());
                }
            }

        }
        return Result.newSuccessResult(count);
    }

    public Result<PermissionResultDto> delete(String ids) throws Exception{
        String[] arrays = ids.split(",");
        List<Long> idList = Arrays.asList(arrays).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        BaseProductNoticeExample example = new BaseProductNoticeExample();
        example.createCriteria().andIdIn(idList);
        List<BaseProductNotice> productNotices = baseProductNoticeMapper.selectByExample(example);
        List<FailListDto> resultList = new ArrayList<FailListDto>();
        List<PassListDto> passList = new ArrayList<>();
        for (BaseProductNotice notice : productNotices){
            if(!notice.getStatus().equals(NoticeStatusEnum.STATUS_1.getStatus()) && !notice.getStatus().equals(NoticeStatusEnum.STATUS_4.getStatus()) && !notice.getStatus().equals(NoticeStatusEnum.STATUS_5.getStatus())){
                resultList.add(new FailListDto(GJLCodeConstant.CODE_1210002, "待审批和已发布的公告不可删除", notice.getId(), notice.getTitle()));
                continue;
            }
            passList.add(new PassListDto(notice.getId(),notice.getTitle()));
            notice.setIsDelete(CommonConstant.ONE);
            baseProductNoticeMapper.updateByPrimaryKeySelective(notice);
        }
        if(productNotices != null && productNotices.size() < idList.size()) {
            idList.forEach(m -> {
                Boolean isId = false;
                    for(BaseProductNotice product: productNotices){
                    if (product.getId().equals(m)) {
                        isId = true;
                    }
                }
                if(!isId){
                    resultList.add(new FailListDto(GJLCodeConstant.CODE_1210032,"没有找到公告id：" + m,m,"失败提示"));
                }
            });
        }
        if(resultList.size() > 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return Result.newSuccessResult(new PermissionResultDto(resultList,passList));
    }

    public Result<BaseProductNotice> get(Long id) throws BaseException{
       BaseProductNotice model = baseProductNoticeMapper.selectByPrimaryKey(id);
       List<BaseProductNotice> list = new ArrayList<>();
       if(model == null){
           throw new BaseException(GJLCodeConstant.CODE_1210017);
       }
       list.add(model);
        List<ProductNoticeModel> models = setDataExpand(list);
       return Result.newSuccessResult(models.get(0));
    }

    @Override
    public Result<PaginationSupport<ProductNoticeModel>> getPage(ProductNoticePageReqDto baseProductNotice, AbstractBasePageDto pageDto) throws Exception {
        Map<String,Object> params = LocalBeanUtils.toMap(baseProductNotice);
        if(BooleanUtils.isEmpty(pageDto.getOrderColumn())){
            pageDto.setOrderColumn(defaultSortName);
            pageDto.setSort(defaultSort);
        }else {
            pageDto.setOrderColumn(CamelUtil.toline(pageDto.getOrderColumn()));
        }
        if(BooleanUtils.isEmpty(pageDto.getSort())){
            pageDto.setSort(defaultSort);
        }
        params.putAll(LocalBeanUtils.toMap(pageDto));
        if(BooleanUtils.isNotEmpty(baseProductNotice.getNoticeTypeIds())){
            String noticeTypeIds = baseProductNotice.getNoticeTypeIds();
            params.put("noticeTypeIds",noticeTypeIds.replace(",","','"));
        }
        //如果筛选是我发起的。
        if(baseProductNotice.getType() != null && baseProductNotice.getType() == 1){
            params.put("createUserId",super.getHeaderUserId());
        }
        PaginationSupport<ProductNoticeModel> pager = PaginationSupport.newDefault(params);
        int totalCount = productNoticeMapper.selectPageCount(params);
        List<ProductNoticeModel> list = productNoticeMapper.selectPageInfo(params);
        List<ProductNoticeModel> noticeModels = setDataExpandPage(list);
        pager.setDatas(noticeModels);
        pager.setTotalCount(totalCount);
        return Result.newSuccessResult(pager);
    }

    @Override
	public Result<List<ProductNoticeModel>> getList(Long productId,Integer isSend) throws Exception {
    	BaseProductNoticeExample example=new BaseProductNoticeExample();
    	Criteria criteria =example.createCriteria();
    	criteria.andProductIdEqualTo(productId);
    	criteria.andIsSendEqualTo(isSend);//只获取已发送的产品
    	example.setOrderByClause("send_time desc");
    	List<BaseProductNotice> productNotices=baseProductNoticeMapper.selectByExample(example);
    	List<ProductNoticeModel> noticeModels=new ArrayList<>();
    	if(productNotices !=null && !productNotices.isEmpty()){
    		for(BaseProductNotice notice:productNotices){
    			ProductNoticeModel model=new ProductNoticeModel();
    			BeanUtils.copyProperties(notice, model);
    			BaseProductNoticeType noticeType=baseProductNoticeTypeMapper.selectByPrimaryKey(notice.getNoticeTypeId());  
    			if(noticeType !=null){
    				model.setNoticeTypeName(noticeType.getName());
    			}
    			noticeModels.add(model);
    		}
    	}
		return Result.newSuccessResult(noticeModels);
		
	}

	public Result<PaginationSupport<ProductNoticeModel>> getPageOld(ProductNoticePageReqDto baseProductNotice, AbstractBasePageDto pageDto) throws Exception{
		BaseProductNoticeExample baseProductNoticeExample = new BaseProductNoticeExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseProductNoticeExample.Criteria criteria = baseProductNoticeExample.createCriteria();
		//设置参数状态参数
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
		baseProductNoticeExample.setOrderByClause(orderByClause);
		List<BaseProductNotice> list = baseProductNoticeMapper.selectByExample(baseProductNoticeExample);
		int totalCount = baseProductNoticeMapper.countByExample(baseProductNoticeExample);
		PaginationSupport<ProductNoticeModel> result = pageDto.getPaginationSupport();
        List<ProductNoticeModel> noticeModels = setDataExpand(list);
		result.setDatas(noticeModels);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

    @Override
    public Result<Integer> processFlow(Long id, Integer status, String reason) throws BaseException {
        BaseProductNotice notice = baseProductNoticeMapper.selectByPrimaryKey(id);
        if(notice == null){
            throw new BaseException(GJLCodeConstant.CODE_1210003);
        }
        NoticeStatusEnum noticeStatusEnum = NoticeStatusEnum.getNoticeStatusEnum(notice.getStatus());
        if(noticeStatusEnum == null){
            throw new BaseException(GJLCodeConstant.CODE_1210004);
        }
        if(NoticeStatusEnum.STATUS_4.getStatus().equals(status) && BooleanUtils.isEmpty(reason)){
            throw new BaseException(GJLCodeConstant.CODE_1210006);
        }
        boolean isNext = false;
        String nextStatus = noticeStatusEnum.getNextStatus();
        if(BooleanUtils.isNotEmpty(nextStatus)) {
            String[] netxStatus = noticeStatusEnum.getNextStatus().split(",");
            for (int i = 0; i < netxStatus.length; i++) {
                if (status.equals(Integer.valueOf(netxStatus[i]))) {
                    isNext = true;
                    break;
                }
            }
        }
        if(!isNext){
            throw new BaseException(GJLCodeConstant.CODE_1210005);
        }
        boolean isSendMessage = false;
        notice.setStatus(status);
        notice.setReason(reason);
        if(NoticeStatusEnum.STATUS_3.getStatus().equals(status) || NoticeStatusEnum.STATUS_4.getStatus().equals(status)){
        	notice.setAuditDate(new Date());
        	notice.setAuditUserId(this.getHeaderUserId());
        }
        if(NoticeStatusEnum.STATUS_3.getStatus().equals(status)){
            //设置立即发布
            Date date = new Date();
            if(notice.getIsTimingSend() == NoticeSendEnum.SEND_0.getStatus() || (notice.getIsTimingSend() == NoticeSendEnum.SEND_1.getStatus() && DateUtils.getDistanceTimes(notice.getSendTime(),date) < 0)){
                notice.setIsSend(CommonConstant.ONE);
                notice.setSendTime(new Date());
                isSendMessage = true;
            }
        }
        if(status.equals(NoticeStatusEnum.STATUS_2.getStatus())){
        	notice.setApplyDate(new Date());
        	notice.setApplyUserId(this.getHeaderUserId());
        }
        Integer count = baseProductNoticeMapper.updateByPrimaryKeySelective(notice);
        if(status.equals(NoticeStatusEnum.STATUS_2.getStatus())){
            //默认是申请审核，如果状态是驳回之后的申请，就发送另外一个审核。
            String code = MsgMessageCodeEnum.PRODUCT_NOTICE_AUDIT.getCode();
            if(noticeStatusEnum.getStatus().equals(NoticeStatusEnum.STATUS_4.getStatus())){
                code = MsgMessageCodeEnum.PRODUCT_NOTICE_AGAIN_AUDIT.getCode();
            }
            //发送审核消息
            sendToMessage(notice,code);
        }
        // 任务处理
        productNoticeAudit.doTaskApplyAndAudit(notice.getId(), status, reason);

        //如果是立即发布的公告
        if(isSendMessage){
            BaseProduct product = baseProductMapper.selectByPrimaryKey(notice.getProductId());
            sendNoticeMsg(notice,product);
        }

        return Result.newSuccessResult(count);
    }

    private void sendToMessage(BaseProductNotice notice,String code) throws BaseException {
        List<Long> userIdList = resourceService.getUserIds(ExamineGroupEnum.PRODUCT_NOTICE_GROUP.getResourceCode());
        if(userIdList == null || userIdList.isEmpty()){
            throw new BaseException(GJLCodeConstant.CODE_1210088);
        }
        String userIds = StringUtils.join(userIdList, com.yundao.tenant.constant.CommonConstant.COMMA);
        //类型名称
        BaseProductNoticeTypeExample typeExample = new BaseProductNoticeTypeExample();
        typeExample.createCriteria().andIdEqualTo(notice.getNoticeTypeId());
        BaseProductNoticeType noticeType = baseProductNoticeTypeMapper.selectOne(typeExample);

        //产品名称
        BaseProduct product = baseProductMapper.selectByPrimaryKey(notice.getProductId());
        //发送消息
        Map<String,Object> params = new HashMap<>();
        params.put("title",notice.getTitle());
        params.put("userIds",userIds);
        params.put("typeName",noticeType == null ? null : noticeType.getName());
        params.put("productName",product == null ? null : product.getName());
        params.put("realName",super.getHeaderUser().getRealName());
        msgMessageService.processSendMessage(code,params);
    }

    @Override
    public Result<Long> processQrtzNotice() throws Exception {
        //获取所有产品公告为定时发布，并且状态为审核，时间<当前时间的公告，进行发布，并修改发布状态
        BaseProductNoticeExample example = new BaseProductNoticeExample();
        example.createCriteria().andIsSendEqualTo(NoticeSendStatusEnum.SEND_0.getStatus())
        .andIsTimingSendEqualTo(NoticeSendEnum.SEND_1.getStatus())
        .andSendTimeLessThanOrEqualTo(new Date())
        .andStatusEqualTo(NoticeStatusEnum.STATUS_3.getStatus());
        List<BaseProductNotice> notices = baseProductNoticeMapper.selectByExample(example);
        if(notices != null && !notices.isEmpty()){
            //查询对应的产品
            List<Long> productIds = new ArrayList<>();
            notices.forEach(m -> {
                if(!productIds.contains(m.getProductId())){
                  productIds.add(m.getProductId());
            }});
            BaseProductExample productExample = new BaseProductExample();
            productExample.createCriteria().andIdIn(productIds);
            List<BaseProduct> products = baseProductMapper.selectByExample(productExample);

            for (BaseProductNotice notice : notices) {
                //获取产品信息
                BaseProduct baseProduct = null;
                for (BaseProduct product : products) {
                    if(product.getId().equals(notice.getProductId())){
                        baseProduct = product;
                        break;
                    }
                }
                if (sendNoticeMsg(notice, baseProduct)) continue;
                //修改状态
                notice.setIsSend(NoticeSendStatusEnum.SEND_1.getStatus());
                notice.setSendTime(new Date());
                baseProductNoticeMapper.updateByPrimaryKeySelective(notice);
            }
        }
        return Result.newSuccessResult();
    }

    private boolean sendNoticeMsg(BaseProductNotice notice, BaseProduct baseProduct) throws BaseException {
        Set<Long> userIdSet = new HashSet<>();
        BaseDeclarationExample declarationExample = new BaseDeclarationExample();
        declarationExample.createCriteria().andProductIdEqualTo(baseProduct.getId());
        List<BaseDeclaration> declarations = baseDeclarationMapper.selectByExample(declarationExample);
        for (BaseDeclaration declaration : declarations) {
            if(!userIdSet.contains(declaration.getUserId())){
                userIdSet.add(declaration.getUserId());
            }
        }

        //获取产品助理和产品对接人
        if(baseProduct.getReceiverId() != null){
            userIdSet.add(baseProduct.getReceiverId());
        }
        if(baseProduct.getAssistantId() != null) {
            userIdSet.add(baseProduct.getAssistantId());
        }

        StringBuilder userIds = new StringBuilder();
        for (Long userId : userIdSet) {
            userIds.append(com.yundao.tenant.constant.CommonConstant.COMMA).append(userId);
        }

        if(userIdSet.isEmpty()){
            log.error("############################没有找到需要发送的人：公告id" + notice.getId());
            return true;
        }
        String productName = baseProduct.getName();
        BaseProductNoticeType noticeType = baseProductNoticeTypeMapper.selectByPrimaryKey(notice.getNoticeTypeId());
        String typeName = noticeType.getName();
        Map<String,Object> params = ArgsUtils.toMap(notice);
        params.put("typeName",typeName);
        params.put("userIds",userIds.substring(1));
        params.put("productName",productName);
        msgMessageService.processSendMessage(MsgMessageCodeEnum.SEND_NOTICE.getCode(),params);
        return false;
    }

    @Override
    public Result<List<BaseProductNotice>> getIds(String ids) {
        String[] idArr = ids.split(com.yundao.tenant.constant.CommonConstant.COMMA);
        List<Long> idList = new ArrayList<>(idArr.length);
        for (String id : idArr) {
            idList.add(Long.valueOf(id));
        }
        BaseProductNoticeExample example = new BaseProductNoticeExample();
        example.createCriteria().andIdIn(idList);
        List<BaseProductNotice> notices = baseProductNoticeMapper.selectByExample(example);
        return Result.newSuccessResult(notices);
    }

    /**
     * 修改审核历史纪录
     * @param notice
     */
    private void updateNoticeExamine(BaseProductNotice notice) {
        BaseProductNoticeExamineExample examineExample = new BaseProductNoticeExamineExample();
        examineExample.createCriteria().andNoticeIdEqualTo(notice.getId());
        String orderByClause="id desc";
        examineExample.setOrderByClause(orderByClause);
        examineExample.setLimit(Limit.buildLimit(1,1));
        List<BaseProductNoticeExamine> baseProductNoticeExamines = baseProductNoticeExamineMapper.selectByExample(examineExample);
        BaseProductNoticeExamine baseProductNoticeExamine = baseProductNoticeExamines.get(0);
        baseProductNoticeExamine.setStatus(notice.getStatus());
        baseProductNoticeExamine.setUpdateUser(super.getHeaderUser().getRealName());
        baseProductNoticeExamine.setUpdateUserId(super.getHeaderUserId());
        baseProductNoticeExamine.setUpdateDate(new Date());
        if(notice.getStatus().equals(NoticeStatusEnum.STATUS_4.getStatus())){
            baseProductNoticeExamine.setReason(notice.getReason());
        }
        baseProductNoticeExamineMapper.updateByPrimaryKey(baseProductNoticeExamine);

    }

    /**
     * 添加审核历史纪录
     * @param notice
     */
    private void addNoticeExamine(BaseProductNotice notice) {
        BaseProductNoticeExamine examine = new BaseProductNoticeExamine();
        BeanUtils.copyProperties(notice,examine);
        examine.setId(null);
        examine.setCreateUserId(super.getHeaderUserId());
        examine.setCreateUser(super.getHeaderUser().getRealName());
        examine.setNoticeId(notice.getId());
        //产品名称
        examine.setProductName(baseProductMapper.selectByPrimaryKey(notice.getProductId()).getName());
        //产品公告类型名称
        examine.setNoticeType(baseProductNoticeTypeMapper.selectByPrimaryKey(notice.getNoticeTypeId()).getName());
        examine.setNoticeTypeId(notice.getNoticeTypeId());
        baseProductNoticeExamineMapper.insertSelective(examine);
    }

    
    private List<ProductNoticeModel> setDataExpandPage(List<ProductNoticeModel> list) {
        if(list == null || list.isEmpty()){
            return null;
        }
        List<ProductNoticeModel> models = new ArrayList<ProductNoticeModel>();
        List<Long> noticeIds = new ArrayList<Long>();
        List<Long> typeIds = new ArrayList<Long>();
        List<Long> productIds = new ArrayList<Long>();
        //获取所有的ids，和构建返回的内容
        list.forEach(n -> {noticeIds.add(n.getId());typeIds.add(n.getNoticeTypeId());productIds.add(n.getProductId());
        ProductNoticeModel noticeModel = new ProductNoticeModel();BeanUtils.copyProperties(n,noticeModel);models.add(noticeModel);});
        BaseProductExample productExample = new BaseProductExample();
        productExample.createCriteria().andIdIn(productIds);
        List<BaseProduct> products = baseProductMapper.selectByExample(productExample);
        //设置产品名称
        if (products != null && !products.isEmpty()) {
            models.forEach(model -> {
                products.forEach(product -> {
                    if (model.getProductId().equals(product.getId())) {
                        model.setProductName(product.getName());
                    }
                });
            });
        }
        //获取所有对应的公告类型，所有对应的产品，所有定义的附件
        BaseProductNoticeAttachExample attachExample = new BaseProductNoticeAttachExample();
        attachExample.createCriteria().andNoticeIdIn(noticeIds);
        List<BaseProductNoticeAttach> attaches = baseProductNoticeAttachMapper.selectByExample(attachExample);
        BaseProductNoticeTypeExample typeExample = new BaseProductNoticeTypeExample();
        typeExample.createCriteria().andIdIn(typeIds);
        List<BaseProductNoticeType> noticeTypes = baseProductNoticeTypeMapper.selectByExample(typeExample);
        //设置附件
        if(attaches != null && !attaches.isEmpty()){
            models.forEach(model -> {
                List<BaseProductNoticeAttach> baseProductNoticeAttaches = new ArrayList<BaseProductNoticeAttach>();
                attaches.forEach(attache -> {
                if(model.getId().equals(attache.getNoticeId())){
                    baseProductNoticeAttaches.add(attache);

                }
                });
                model.setBaseProductNoticeAttach(baseProductNoticeAttaches);
                });
        }
        //设置节点类型
        if(noticeTypes != null && !noticeIds.isEmpty()){
            models.forEach(model -> {noticeTypes.forEach(noticeType -> {
                if(model.getNoticeTypeId().equals(noticeType.getId())){
                    model.setNoticeTypeName(noticeType.getName());
                }
            });});
        }
        return models;
    }
    
    
    
    private List<ProductNoticeModel> setDataExpand(List<BaseProductNotice> list) {
        if(list == null || list.isEmpty()){
            return null;
        }
        List<ProductNoticeModel> models = new ArrayList<ProductNoticeModel>();
        List<Long> noticeIds = new ArrayList<Long>();
        List<Long> typeIds = new ArrayList<Long>();
        List<Long> productIds = new ArrayList<Long>();
        //获取所有的ids，和构建返回的内容
        list.forEach(n -> {noticeIds.add(n.getId());typeIds.add(n.getNoticeTypeId());productIds.add(n.getProductId());
        ProductNoticeModel noticeModel = new ProductNoticeModel();BeanUtils.copyProperties(n,noticeModel);models.add(noticeModel);});
        BaseProductExample productExample = new BaseProductExample();
        productExample.createCriteria().andIdIn(productIds);
        List<BaseProduct> products = baseProductMapper.selectByExample(productExample);
        //设置产品名称
        if (products != null && !products.isEmpty()) {
            models.forEach(model -> {
                products.forEach(product -> {
                    if (model.getProductId().equals(product.getId())) {
                        model.setProductName(product.getName());
                    }
                });
            });
        }
        //获取所有对应的公告类型，所有对应的产品，所有定义的附件
        BaseProductNoticeAttachExample attachExample = new BaseProductNoticeAttachExample();
        attachExample.createCriteria().andNoticeIdIn(noticeIds);
        List<BaseProductNoticeAttach> attaches = baseProductNoticeAttachMapper.selectByExample(attachExample);
        BaseProductNoticeTypeExample typeExample = new BaseProductNoticeTypeExample();
        typeExample.createCriteria().andIdIn(typeIds);
        List<BaseProductNoticeType> noticeTypes = baseProductNoticeTypeMapper.selectByExample(typeExample);
        //设置附件
        if(attaches != null && !attaches.isEmpty()){
            models.forEach(model -> {
                List<BaseProductNoticeAttach> baseProductNoticeAttaches = new ArrayList<BaseProductNoticeAttach>();
                attaches.forEach(attache -> {
                if(model.getId().equals(attache.getNoticeId())){
                    baseProductNoticeAttaches.add(attache);

                }
                });
                model.setBaseProductNoticeAttach(baseProductNoticeAttaches);
                });
        }
        //设置节点类型
        if(noticeTypes != null && !noticeIds.isEmpty()){
            models.forEach(model -> {noticeTypes.forEach(noticeType -> {
                if(model.getNoticeTypeId().equals(noticeType.getId())){
                    model.setNoticeTypeName(noticeType.getName());
                }
            });});
        }
        return models;
    }
}