package com.yundao.tenant.service.dictionary;

import com.yundao.core.dto.dictionary.DictionariesDto;
import com.yundao.core.exception.BaseException;

import java.util.List;

/**
 * 数据字典服务接口
 *
 * @author jan
 * @create 2017-07-16 AM11:30
 **/
public interface DictionaryService {

    /**
     * 根据code获取数据字典，多个以逗号隔开
     *
     * @param codes 多个数据字典编码
     */
    List<DictionariesDto> gets(String codes) throws BaseException;

    /**
     * 根据code获取数据字典排序的首个，
     *
     * @param codes 多个数据字典编码
     */
    DictionariesDto get(String codes, Integer number) throws BaseException;

    /**
     * 获取文本
     *
     * @param code  数据字典编码
     * @param value 值
     */
    String toText(String code, Integer value) throws BaseException;

    /**
     * 获取文本
     *
     * @param code  数据字典编码
     * @param value 值
     */
    String toText(String code, String value) throws BaseException;

    /**
     * 从新加载缓存
     */
    void reload() throws BaseException;
}
