package com.yundao.tenant.util;

import com.yundao.tenant.dto.role.RoleDetailResDto;
import com.yundao.tenant.dto.user.role.UserRolePageReqDto;
import com.yundao.tenant.model.base.BaseRole;
import org.apache.tomcat.jni.Local;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Bean工具类 单元测试
 *
 * @author jan
 * @create 2017-06-15 PM7:56
 **/
public class LocalBeanUtilsTest {

    @Test
    public void copyPropertiesList() throws Exception {
        List<BaseRole> roles = new ArrayList<>();
        BaseRole r1 = new BaseRole();
        r1.setId(1L);
        r1.setName("ONE");
        roles.add(r1);

        BaseRole r2 = new BaseRole();
        r2.setId(2L);
        r2.setName("TWO");
        roles.add(r2);

        List<RoleDetailResDto> details = LocalBeanUtils.copyPropertiesList(roles, RoleDetailResDto.class);
        Assert.assertEquals(2,details.size());
    }

    @Test
    public void toMap() throws Exception {
        UserRolePageReqDto dto = new UserRolePageReqDto();
        dto.setRoleId(1L);
        dto.setCurrentPage(1);
        dto.setPageSize(10);

        Map<String, Object> map = LocalBeanUtils.toMap(dto);
        Assert.assertEquals(1L, map.get("roleId"));
        Assert.assertEquals(1, map.get("currentPage"));
        Assert.assertEquals(10, map.get("pageSize"));

        Map<String, Object> nullMap = LocalBeanUtils.toMap(null);
        Assert.assertEquals(null, nullMap);
    }

}