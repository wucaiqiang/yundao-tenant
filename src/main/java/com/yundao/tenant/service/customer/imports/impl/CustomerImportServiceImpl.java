package com.yundao.tenant.service.customer.imports.impl;

import com.yundao.core.code.Result;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.ThreadUtils;
import com.yundao.tenant.dto.area.RegionDto;
import com.yundao.tenant.dto.customer.imports.*;
import com.yundao.tenant.enums.customer.CustomerBelongTypeEnum;
import com.yundao.tenant.enums.customer.CustomerSourceType;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.mapper.customer.imports.CustomerImportMapper;
import com.yundao.tenant.model.base.customer.*;
import com.yundao.tenant.service.customer.imports.CustomerImportService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.region.ProvinceCityService;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.util.HeaderUserThreadLocal;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 客户批量导入服务接口实现
 *
 * @author jan
 * @create 2017-08-31 PM3:45
 **/
@Service
public class CustomerImportServiceImpl extends AbstractService implements CustomerImportService {

    private static Log log = LogFactory.getLog(CustomerImportServiceImpl.class);

    @Autowired
    private CustomerImportMapper customerImportMapper;

    @Autowired
    private MsgMessageService msgMessageService;

    @Autowired
    private ProvinceCityService provinceCityService;

    @Override
    public Result<List<String>> getExistList(String mobiles) throws BaseException {
        String logPrefix = "批量导入客户||获取已存在客户||";
        if (BooleanUtils.isEmpty(mobiles))
            return Result.newSuccessResult(new ArrayList<>(1));
        List<String> mobileList = SymbolStrUtils.toList(mobiles);
        log.info("%s 入参手机号个数 %s", logPrefix, mobileList.size());
        List<String> encryptList = new ArrayList<>(mobileList.size());
        for (String mobile : mobileList) {
            encryptList.add(BaseContactUtils.encrypt(mobile));
        }

        List<CustomerIdAndMobileDto> dtos = customerImportMapper.selectExistMobiles(encryptList);
        List<String> dtoMobiles = LambdaMap.toSingleList(dtos, CustomerIdAndMobileDto::getMobile);
        List<String> existMobiles = new ArrayList<>();
        for (String mobile : dtoMobiles) {
            existMobiles.add(BaseContactUtils.decrypt(mobile));
        }
        log.info("%s result %s", logPrefix, JsonUtils.objectToJson(existMobiles));
        return Result.newSuccessResult(existMobiles);
    }

    @Override
    public Result<Boolean> doImportFormOpensea(List<CustomerImportDto> dtos) throws BaseException {
        String logPrefix = "批量导入客户||从公海导入客户||";
        encryptAndInitial(dtos);
        if (!BooleanUtils.isEmpty(dtos)) {
            for (CustomerImportDto dto : dtos) {
                dto.setBelongType(CustomerBelongTypeEnum.OPENSEA.getValue());
            }
        }
        insertBatchCustomer(dtos);
        updateCustomerNumber();
        insertBatchCustomerDetail(dtos);
        insertBatchCredentials(dtos);
        insertBatchBanks(dtos);
        insertBatchTags(dtos);
        insertFeed(dtos);
        log.info("%s操作完成", logPrefix);
        return Result.newSuccessResult(true);
    }


    @Override
    public Result<Boolean> doImportV2(List<CustomerImportDto> dtos) throws BaseException {
        String logPrefix = "批量导入客户||从客户页面导入||";
        encryptAndInitial(dtos);
        if (!BooleanUtils.isEmpty(dtos)) {
            for (CustomerImportDto dto : dtos) {
                dto.setBelongType(CustomerBelongTypeEnum.PRIVATE.getValue());
            }
        }
        insertBatchCustomer(dtos);
        updateCustomerNumber();
        insertBatchCustomerDetail(dtos);
        insertBatchUserCustomer(dtos);
        insertBatchCredentials(dtos);
        insertBatchBanks(dtos);
        insertBatchTags(dtos);
        insertFeed(dtos);
        log.info("%s操作完成", logPrefix);
        return Result.newSuccessResult(true);
    }

    /**
     * 字段加密和初始化
     */
    private void encryptAndInitial(List<CustomerImportDto> dtos) {
        //客户联系方式加密入库
        for (CustomerImportDto dto : dtos) {
            if (BooleanUtils.isNotEmpty(dto.getMobile()))
                dto.setMobile(BaseContactUtils.encrypt(dto.getMobile()));
            if (BooleanUtils.isNotEmpty(dto.getEmail()))
                dto.setEmail(BaseContactUtils.encrypt(dto.getEmail()));
            if (BooleanUtils.isNotEmpty(dto.getWechat()))
                dto.setWechat(BaseContactUtils.encrypt(dto.getWechat()));
            if (BooleanUtils.isNotEmpty(dto.getQq()))
                dto.setQq(BaseContactUtils.encrypt(dto.getQq()));
        }
        for (CustomerImportDto dto : dtos) {
            super.initialModel(dto);
        }
    }

    /**
     * 批量插入客户
     */
    private void insertBatchCustomer(List<CustomerImportDto> dtos) throws BaseException {
        String logPrefix = "批量导入客户||导入客户||";
        customerImportMapper.insertBatch(dtos);
        log.info("%s批量插入客户完成 条数 %s", logPrefix, dtos.size());
    }

    /**
     * 更新客户编号
     */
    private void updateCustomerNumber() throws BaseException {
        customerImportMapper.updateCustomerNumber();
    }

    /**
     * 批量插入客户详情
     */
    private void insertBatchCustomerDetail(List<CustomerImportDto> dtos) throws BaseException {
        String logPrefix = "批量导入客户||导入客户||";
        List<String> mobiles = LambdaMap.toSingleList(dtos, CustomerImportDto::getMobile);

        //从客户表获取本次导入已插入的数据，根据手机号码标出id，批量插入客户详情
        List<CustomerIdAndMobileDto> customerIdAndMobileDtos = customerImportMapper.selectExistMobiles(mobiles);
        for (CustomerImportDto dto : dtos) {
            CustomerIdAndMobileDto idAndMobileDto = LambdaFilter.firstOrDefault(customerIdAndMobileDtos, m -> m.getMobile().equals(dto.getMobile()));
            if (idAndMobileDto != null)
                dto.setId(idAndMobileDto.getId());
        }

        List<RegionDto> regionDtos = provinceCityService.gets(super.getHeaderTenantId());
        for (CustomerImportDto dto : dtos) {
            if (BooleanUtils.isNotEmpty(regionDtos)) {
                //省 转换
                if (BooleanUtils.isNotEmpty(dto.getProvince())) {
                    RegionDto p = LambdaFilter.firstOrDefault(regionDtos, m -> m.getLabel().contains(dto.getProvince
                            ()));
                    dto.setProvince(p != null ? p.getValue() : null);
                }
                //城市 转换
                if (BooleanUtils.isNotEmpty(dto.getCity())) {
                    RegionDto p = LambdaFilter.firstOrDefault(regionDtos, m -> m.getLabel().contains(dto.getCity()
                    ));
                    dto.setCity(p != null ? p.getValue() : null);
                }
            }
        }

        customerImportMapper.insertBatchDetail(dtos);
        log.info("%s批量插入客户详情完成 条数 %s", logPrefix, dtos.size());
    }

    /**
     * 批量插入分配数据
     */
    private void insertBatchUserCustomer(List<CustomerImportDto> dtos) throws BaseException {
        String logPrefix = "批量导入客户||导入客户||";
        List<BaseUserCustomer> userCustomers = new ArrayList<>();
        List<BaseCustomerTransfer> logs = new ArrayList<>();
        Long userId = super.getHeaderUserId();
        String userRealName = super.getRealName();
        Date now = new Date();
        for (CustomerImportDto dto : dtos) {
            BaseUserCustomer userCustomer = new BaseUserCustomer();
            super.initialModel(userCustomer);
            userCustomer.setCustomerId(dto.getId());
            userCustomer.setUserId(userId);
            userCustomer.setDistributionUserId(userId);
            userCustomer.setDistributionDate(now);
            userCustomer.setSourceType(CustomerSourceType.SELF_BUILT.getValue());
            userCustomers.add(userCustomer);

            BaseCustomerTransfer log = new BaseCustomerTransfer();
            super.initialModel(log);
            log.setAfterUser(userRealName);
            log.setAfterUserId(userId);
            log.setCustomerId(dto.getId());
            log.setRemark("批量客户导入");
            log.setTransferDate(now);
            logs.add(log);
        }
        customerImportMapper.insertBatchUserCustomer(userCustomers);
        log.info("%s批量插入分配数据完成 条数 %s", logPrefix, userCustomers.size());
        customerImportMapper.insertBatchDistributionLog(logs);
        log.info("%s批量插入分配日志完成 条数 %s", logPrefix, logs.size());
    }

    /**
     * 批量插入客户证件
     */
    private void insertBatchCredentials(List<CustomerImportDto> dtos) throws BaseException {
        String logPrefix = "批量导入客户||导入证件||";
        List<CustomerImportDto> needProcess = LambdaFilter.toList(dtos, m -> BooleanUtils.isNotBlank(m.getCredentialsType()) || BooleanUtils.isNotBlank(m.getCredentialsNumber()));
        log.info("%s 需要处理的条数=%s", logPrefix, needProcess.size());
        if (BooleanUtils.isEmpty(needProcess))
            return;
        List<BaseCustomerCredentials> credentials = new ArrayList<>();
        for (CustomerImportDto customer : needProcess) {
            BaseCustomerCredentials credential = new BaseCustomerCredentials();
            super.initialModel(credential);
            if (BooleanUtils.isNotBlank(customer.getCredentialsType())) {
                credential.setType(Long.valueOf(customer.getCredentialsType()));
            }
            credential.setNumber(customer.getCredentialsNumber());
            credential.setUpdateUserId(customer.getId());
            credentials.add(credential);
        }
        customerImportMapper.insertBatchCredentials(credentials);

        List<ImportCredentialDto> credentialFromDB = customerImportMapper.selectInsertedCredential(super.getHeaderUserId());
        if (BooleanUtils.isEmpty(credentialFromDB)) {
            log.info("%s credentialFromDB为空", logPrefix);
            return;
        }

        List<BaseCustomerCredentialsRel> rels = new ArrayList<>();
        for (ImportCredentialDto importCredentialDto : credentialFromDB) {
            CustomerImportDto customerImportDto = LambdaFilter.firstOrDefault(needProcess, m -> m.getId().equals
                    (importCredentialDto.getCustomerId()));
            if (customerImportDto == null) {
                log.info("%s 没有找到对应的证件 customerId=%s", logPrefix, importCredentialDto.getCustomerId());
                continue;
            }
            BaseCustomerCredentialsRel rel = new BaseCustomerCredentialsRel();
            super.initialModel(rel);
            rel.setCredentialsId(importCredentialDto.getId());
            rel.setCustomerId(customerImportDto.getId());
            rels.add(rel);
        }

        customerImportMapper.updateRestoreCredentials(LambdaMap.toSingleList(credentialFromDB, ImportCredentialDto::getId));

        if (BooleanUtils.isEmpty(rels)) {
            log.info("%s rels为空", logPrefix);
            return;
        }
        customerImportMapper.insertBatchCredentialsRel(rels);
        log.info("%s 完成", logPrefix);
    }

    /**
     * 批量插入银行卡
     */
    private void insertBatchBanks(List<CustomerImportDto> dtos) throws BaseException {
        String logPrefix = "批量导入客户||导入客户银行卡||";
        List<CustomerImportDto> needProcess = LambdaFilter.toList(dtos, m -> BooleanUtils.isNotBlank(m.getBankAccount()) || BooleanUtils.isNotBlank(m.getBankName()));
        log.info("%s 需要处理的条数=%s", logPrefix, needProcess.size());
        if (BooleanUtils.isEmpty(needProcess))
            return;
        List<BaseCustomerBank> banks = new ArrayList<>();
        for (CustomerImportDto customer : needProcess) {
            BaseCustomerBank bank = new BaseCustomerBank();
            super.initialModel(bank);
            bank.setAccount(customer.getBankAccount());
            bank.setBankName(customer.getBankName());
            //将客户id，临时保存在updateuserId字段，方便查找，下面会还原
            bank.setUpdateUserId(customer.getId());
            banks.add(bank);
        }
        customerImportMapper.insertBatchBanks(banks);

        List<ImportBankDto> bankFromDB = customerImportMapper.selectInsertedBanks(super.getHeaderUserId());
        log.info("%s bankFromDB=%s", logPrefix, JsonUtils.objectToJson(bankFromDB));
        if (BooleanUtils.isEmpty(bankFromDB)) {
            log.info("%s bankFromDB为空", logPrefix);
            return;
        }

        List<BaseCustomerBankRel> rels = new ArrayList<>();
        for (ImportBankDto importBankDto : bankFromDB) {
            CustomerImportDto customerImportDto = LambdaFilter.firstOrDefault(needProcess, m -> m.getId().equals
                    (importBankDto.getCustomerId()));
            if (customerImportDto == null) {
                log.info("%s 没有找到对应的银行卡 customerId=%s", logPrefix, importBankDto.getCustomerId());
                continue;
            }
            BaseCustomerBankRel rel = new BaseCustomerBankRel();
            super.initialModel(rel);
            rel.setBankId(importBankDto.getId());
            rel.setCustomerId(customerImportDto.getId());
            rels.add(rel);
        }
        log.info("%s rels=%s", logPrefix, JsonUtils.objectToJson(rels));

        customerImportMapper.updateRestoreBank(LambdaMap.toSingleList(bankFromDB, ImportBankDto::getId));

        if (BooleanUtils.isEmpty(rels)) {
            log.info("%s rels为空", logPrefix);
            return;
        }
        customerImportMapper.insertBatchBankRel(rels);
        log.info("%s 完成", logPrefix);
    }

    private CustomerImportDto getMatchForCredential(List<CustomerImportDto> dtos, ImportCredentialDto importCredentialDto) {
        for (CustomerImportDto dto : dtos) {
            if (importCredentialDto.getType() != null) {
                if (!importCredentialDto.getType().toString().equals(dto.getCredentialsType()))
                    continue;
            } else {
                if (!BooleanUtils.isNotBlank(dto.getCredentialsType()))
                    continue;
            }
            if (BooleanUtils.isNotBlank(importCredentialDto.getNumber())) {
                if (!importCredentialDto.getNumber().equals(dto.getCredentialsNumber()))
                    continue;
            } else {
                if (!BooleanUtils.isNotBlank(dto.getCredentialsNumber()))
                    continue;
            }
            return dto;
        }
        return null;
    }

    private void insertBatchTags(List<CustomerImportDto> dtos) throws BaseException {
        String logPrefix = "批量导入客户||导入标签||";
        List<CustomerImportDto> tagNotEmptys = LambdaFilter.toList(dtos, m -> BooleanUtils.isNotBlank(m.getTag()));
        if (BooleanUtils.isEmpty(tagNotEmptys)) {
            log.info("%s 所有客户标签为空", logPrefix);
            return;
        }

        List<String> tagNames = new ArrayList<>();
        for (CustomerImportDto dto : dtos) {
            if (BooleanUtils.isBlank(dto.getTag()))
                continue;
            String[] tagArray = dto.getTag().split(",");
            for (String s : tagArray) {
                if (!tagNames.contains(s))
                    tagNames.add(s);
            }
        }

        //获取已在数据库存在的标签
        List<ImportExistTagDto> importExistTagDtos = customerImportMapper.selectExistTags(tagNames);
        //合并
        List<ImportExistTagDto> tags = new ArrayList<>();
        List<BaseTag> needInsertList = new ArrayList<>();
        for (String tagName : tagNames) {
            ImportExistTagDto tagDto = LambdaFilter.firstOrDefault(importExistTagDtos, m -> m.getName().equals(tagName));
            if (tagDto != null) {
                tags.add(tagDto);
            } else {
                ImportExistTagDto tag = new ImportExistTagDto();
                tag.setName(tagName);
                tags.add(tag);
                BaseTag baseTag = new BaseTag();
                super.initialModel(baseTag);
                baseTag.setName(tagName);
                needInsertList.add(baseTag);
            }
        }
        if (BooleanUtils.isNotEmpty(needInsertList)) {
            //批量插入标签
            customerImportMapper.insertBatchTags(needInsertList);

            //将新添加的标签，赋上id
            List<ImportExistTagDto> tagsFromDB = customerImportMapper.selectExistTags(LambdaMap.toSingleList(needInsertList, BaseTag::getName));
            for (ImportExistTagDto item : LambdaFilter.toList(tags, m -> m.getId() == null)) {
                ImportExistTagDto tag = LambdaFilter.firstOrDefault(tagsFromDB, m -> m.getName().equals(item.getName()));
                if (tag != null)
                    item.setId(tag.getId());
            }
        }

        List<BaseCustomerTag> rels = new ArrayList<>();
        for (CustomerImportDto tagNotEmpty : tagNotEmptys) {
            String[] tagArray = tagNotEmpty.getTag().split(",");
            for (String s : tagArray) {
                ImportExistTagDto tag = LambdaFilter.firstOrDefault(tags, m -> m.getName().equals(s));
                if (null == tag)
                    continue;

                BaseCustomerTag baseCustomerTag = new BaseCustomerTag();
                super.initialModel(baseCustomerTag);
                baseCustomerTag.setCustomerId(tagNotEmpty.getId());
                baseCustomerTag.setTagId(tag.getId());
                rels.add(baseCustomerTag);
            }
        }

        customerImportMapper.insertBatchTagRel(rels);
        log.info("%s 完成", logPrefix);
    }

    /**
     * 上报动态
     */
    private void insertFeed(List<CustomerImportDto> dtos) throws BaseException {
        String logPrefix = "批量导入客户||导入客户||";
        String userRealName = super.getHeaderUser().getRealName();
        log.info("%s 异步执行上报动态开始", logPrefix);
        HeaderUser user = super.getHeaderUser();
        ThreadUtils.execute(() -> {
            HeaderUserThreadLocal.set(user);
            Map<String, Object> params = new HashMap<>(2);
            params.put("createUserName", userRealName);
            params.put("customerIds", SymbolStrUtils.longToStr(LambdaMap.toSingleList(dtos, m -> m.getId())));
            try {
                msgMessageService.processSendMessage(MsgMessageCodeEnum.ADD_CUSTOMER.getCode(), params);
            } catch (Exception ex) {
                log.error("%s 上报动态异常：%s", logPrefix, ex.toString());
            }
            log.info("%s插入动态完成", logPrefix);
        });
    }

}
