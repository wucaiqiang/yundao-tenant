package com.yundao.tenant.customer;

import com.yundao.core.utils.DesUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.AbstractTest;
import com.yundao.tenant.dto.customer.customer.NameIdDto;
import org.junit.Test;

import java.util.*;

/**
 * @author jan
 * @create 2017-08-01 PM9:53
 **/
public class CustomerTest extends AbstractTest {

    @Test
    public void test() {

    	
    	System.out.println(System.currentTimeMillis());
    }
    @Test
    public void update_info() throws Exception {

        String str = DesUtils.encrypt("yundao_qa");
        System.out.printf(str);
/*
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        List<FileBaseDto> list=new ArrayList<>();
        FileBaseDto baseDto=new FileBaseDto();
        baseDto.setName("aaaa");
        baseDto.setUrl("wwwwww");
        list.add(baseDto);
        map.put("assets", JsonUtils.objectToJson(list));
        post("/customer/update_info", map);*/
    }

    @Test
    public void updateForApp() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("customerId", "10005");
        map.put("gender", "1");
        map.put("customerName", "www");
        map.put("customerLevel", "1");
        map.put("from", "2");
        List<NameIdDto> tags = new ArrayList<>();
        NameIdDto nameIdDto = new NameIdDto();
        nameIdDto.setName("啊");
        nameIdDto.setId("1");
        NameIdDto nameIdDto2 = new NameIdDto();
        nameIdDto2.setName("波");
        nameIdDto2.setId("2");
        tags.add(nameIdDto);
        tags.add(nameIdDto2);
        map.put("tags", JsonUtils.objectToJson(tags));

        List<String> urList = new ArrayList<>();
        urList.add("http://files.zcmall.com/web.pd/default/e1230bb3f9bc46b381a7db9d7801a393.doc");
        urList.add("http://wwwww.url");
        map.put("assetsCertificateUrlList", JsonUtils.objectToJson(urList));

        List<String> investList = new ArrayList<>();
        investList.add("1");
        investList.add("2");
        map.put("investLike", JsonUtils.objectToJson(investList));

        map.put("birthday", String.valueOf(System.currentTimeMillis()));
        System.out.println(JsonUtils.objectToJson(map));
        post("/customer/app/update", map);
    }

    @Test
    public void date_test() throws Exception {
        Date date = new Date();//取时间

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(date);

        calendar.add(Calendar.MINUTE, 15);//把日期往后增加一天.整数往后推,负数往前移动

        System.out.printf(calendar.getTime().toString());
    }
}
