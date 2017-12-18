package com.yundao.tenant.mapper.bo;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.bo.ObjectFieldListDto;
import com.yundao.tenant.dto.bo.ObjectFieldPageResDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ObjectFieldMapper {

    /**
     * 获取分页数据
     *
     * @param parmas 查询参数
     * @return 分页结果
     */
    List<ObjectFieldPageResDto> selectPage(Map<String, Object> parmas) throws BaseException;

    /**
     * 获取分页数据总条数
     *
     * @param parmas 查询参数
     * @return 总条数
     */
    int selectPageCount(Map<String, Object> parmas) throws BaseException;

    /**
     * 获取列表数据
     */
    List<ObjectFieldPageResDto> selectList(Map<String, Object> parmas) throws BaseException;

    /**
     * 根据多个id获取列表数据
     */
    List<ObjectFieldPageResDto> selectByIds(@Param("ids") List<Long> ids) throws BaseException;

    /**
     * 根据名称获取
     *
     * @param name     名称
     * @param ignoreId 需要忽略的id
     */
    List<ObjectFieldPageResDto> selectByName(@Param("name") String name, @Param("ignoreId") Long ignoreId) throws
            BaseException;

    /**
     * 获取列表
     *
     * @param ids  id集合
     * @param boId 业务对象id
     */
    List<ObjectFieldListDto> selectListByIds(@Param("ids") List<Long> ids, @Param("boId") Long boId) throws BaseException;

    /**
     * 查询id，并按id进行排序
     * @param objectFieldIds
     * @return
     */
    List<ObjectFieldPageResDto> selectByIdsOrder(@Param("ids")List<Long> objectFieldIds);
}
