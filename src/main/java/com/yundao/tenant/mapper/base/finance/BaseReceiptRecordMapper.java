package com.yundao.tenant.mapper.base.finance;

import com.yundao.tenant.model.base.finance.BaseReceiptRecord;
import com.yundao.tenant.model.base.finance.BaseReceiptRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseReceiptRecordMapper {
    int countByExample(BaseReceiptRecordExample example);

    int deleteByExample(BaseReceiptRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseReceiptRecord record);

    int insertSelective(BaseReceiptRecord record);

    List<BaseReceiptRecord> selectByExample(BaseReceiptRecordExample example);

    BaseReceiptRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseReceiptRecord record, @Param("example") BaseReceiptRecordExample example);

    BaseReceiptRecord selectOne(BaseReceiptRecordExample example);

    int updateByExample(@Param("record") BaseReceiptRecord record, @Param("example") BaseReceiptRecordExample example);

    int updateByPrimaryKeySelective(BaseReceiptRecord record);

    int updateByPrimaryKey(BaseReceiptRecord record);
}