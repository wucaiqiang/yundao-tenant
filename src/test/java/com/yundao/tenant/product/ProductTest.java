package com.yundao.tenant.product;

import com.yundao.tenant.AbstractTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 产品单元测试
 *
 * @author jan
 * @create 2017-10-12 16:45
 **/
public class ProductTest extends AbstractTest {

    @Test
    public void getProductSelectionForReceiptTest() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("name","一百");
        get("/product/get_select_option_for_receipt",map);
    }
}
