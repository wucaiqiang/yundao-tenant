package com.yundao.tenant.mapper.customer.imports;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customer.imports.*;
import com.yundao.tenant.model.base.customer.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户导入
 *
 * @author jan
 * @create 2017-08-31 PM3:46
 **/
public interface CustomerImportMapper {

    /**
     * 获取已存在的手机号码
     */
    List<CustomerIdAndMobileDto> selectExistMobiles(@Param("mobiles") List<String> mobiles) throws BaseException;

    /**
     * 获取已存在的标签
     */
    List<ImportExistTagDto> selectExistTags(@Param("tags") List<String> tags) throws BaseException;

    /**
     * 批量插入客户
     */
    int insertBatch(@Param("customers") List<CustomerImportDto> customers) throws BaseException;

    /**
     * 批量插入客户详情
     */
    int insertBatchDetail(@Param("customers") List<CustomerImportDto> customers) throws BaseException;

    /**
     * 批量插入客户分配信息
     */
    int insertBatchUserCustomer(@Param("userCustomers") List<BaseUserCustomer> userCustomers) throws BaseException;

    /**
     * 批量插入客户分配日志
     */
    int insertBatchDistributionLog(@Param("logs") List<BaseCustomerTransfer> logs) throws BaseException;

    /**
     * 批量插入客户证件
     */
    int insertBatchCredentials(@Param("credentials") List<BaseCustomerCredentials> credentials) throws BaseException;

    /**
     * 批量插入客户证件关联关系
     */
    int insertBatchCredentialsRel(@Param("rels") List<BaseCustomerCredentialsRel> rels) throws BaseException;

    /**
     * 批量插入客户银行卡
     */
    int insertBatchBanks(@Param("banks") List<BaseCustomerBank> credentials) throws BaseException;

    /**
     * 批量插入客户银行卡关系
     */
    int insertBatchBankRel(@Param("rels") List<BaseCustomerBankRel> rels) throws BaseException;

    /**
     * 批量插入标签
     */
    int insertBatchTags(@Param("tags") List<BaseTag> tags) throws BaseException;

    /**
     * 批量插入标签与客户关系
     */
    int insertBatchTagRel(@Param("rels") List<BaseCustomerTag> rels) throws BaseException;

    /**
     * 获取刚被插入的客户证件
     */
    List<ImportCredentialDto> selectInsertedCredential(@Param("userId") Long userId) throws BaseException;

    /**
     * 获取刚被插入的客户银行卡
     */
    List<ImportBankDto> selectInsertedBanks(@Param("userId") Long userId) throws BaseException;

    /**
     * 更新客户编号
     */
    void updateCustomerNumber() throws BaseException;

    /**
     * 还原银行卡表的updateUserId字段
     */
    void updateRestoreBank(@Param("ids") List<Long> ids) throws BaseException;

    /**
     * 还原证件表的updateUserId字段
     */
    void updateRestoreCredentials(@Param("ids") List<Long> ids) throws BaseException;

}
