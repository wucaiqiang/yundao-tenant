package com.yundao.tenant.service.fieldgrouprel;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.bo.ObjectFieldPageResDto;
import com.yundao.tenant.model.base.BaseFieldGroupRel;

import java.util.List;


public interface FieldGroupRelService {


    public Result<Integer> add(BaseFieldGroupRel fieldGroupRel) throws Exception;


    public Result<Integer> update(BaseFieldGroupRel fieldGroupRel) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseFieldGroupRel> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseFieldGroupRel>> getPage(BaseFieldGroupRel baseFieldGroupRel, AbstractBasePageDto pageDto) throws Exception;

    Result<List<ObjectFieldPageResDto>> getGroups(Long groupId) throws BaseException;
}
