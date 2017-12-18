package com.yundao.tenant.department;

import com.yundao.tenant.AbstractTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jan
 * @create 2017-09-12 AM11:09
 **/
public class DepartmentTestController extends AbstractTest {

    @Test
    public void deleteTest() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("id",2);
        post("/department/delete",map);
    }
}
