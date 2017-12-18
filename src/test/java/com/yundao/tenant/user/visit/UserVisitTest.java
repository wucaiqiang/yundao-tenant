package com.yundao.tenant.user.visit;

import com.yundao.tenant.AbstractTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jan
 * @create 2017-09-08 PM5:04
 **/
public class UserVisitTest extends AbstractTest {

    @Test
    public void getDetailTest() throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("leadsId",1);
        get("/user/visit/get_detail_for_leads", params);

    }

}
