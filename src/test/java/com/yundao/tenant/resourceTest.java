package com.yundao.tenant;

import org.junit.Test;

import com.yundao.tenant.util.MobileUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jan
 * @create 2017-06-21 AM8:38
 **/
public class resourceTest extends AbstractTest {
	@Test
	public void testa() {
		System.out.println(MobileUtil.veriyMobile("1360000000"));
	}

    @Test
    public void get_Test() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("resourceIds", "21,36,37,8,9,10,17,11,13,19,14,20,22,23,43,44,71,73,74,75,76,26,27,55,28,56");
        params.put("roleId", "2");
        post("/resource/update_by_role_id", params);
        System.out.printf("");

    }

    @Test
    public void removeByUser_Test() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("tenantId", "1");
        params.put("userId", "-1");
        get("/resource/remove_by_user", params);
        System.out.printf("");

    }


}
