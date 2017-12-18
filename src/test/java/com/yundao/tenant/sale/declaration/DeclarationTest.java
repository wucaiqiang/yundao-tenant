package com.yundao.tenant.sale.declaration;

import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.AbstractTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jan
 * @create 2017-08-01 PM9:53
 **/
public class DeclarationTest extends AbstractTest {

    @Test
    public void updateForApp() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", "10019");
        map.put("renGouAmount", "22.22");
        map.put("giveAmountDate", System.currentTimeMillis());
        map.put("certificateType", "1");
        map.put("certificateNumber", "99999");
        map.put("identityFrontCardUrl", "http://file.yundaojinfu.com/9535ad596c7a4b4fa035c88514e25c6a.png");
        map.put("identityBackCardUrl", "http://file.yundaojinfu.com/9535ad596c7a4b4fa035c88514e25c6a.png");
        List<String> urList = new ArrayList<>();
        urList.add("http://files.zcmall.com/web.pd/default/e1230bb3f9bc46b381a7db9d7801a393.doc");
        urList.add("http://wwwww12.url");
        map.put("assetsCertificateUrlList", JsonUtils.objectToJson(urList));

        List<String> urList1 = new ArrayList<>();
        urList1.add("http://files.zcmall.com/web.pd/default/e1230bb3f9bc46b381a7db9d7801a393.doc");
        urList1.add("http://wwwww12.url");
        map.put("giveAmountCertificateUrlList", JsonUtils.objectToJson(urList1));

        List<String> urList2 = new ArrayList<>();
        urList2.add("http://files.zcmall.com/web.pd/default/e1230bb3f9bc46b381a7db9d7801a393.doc");
        urList2.add("http://wwwww12.url");
        map.put("contractAttachUrlList", JsonUtils.objectToJson(urList2));


        List<String> urList3 = new ArrayList<>();
        urList3.add("http://files.zcmall.com/web.pd/default/e1230bb3f9bc46b381a7db9d7801a393.doc");
        urList3.add("http://wwwww12.url");
        map.put("investorBaseInfoFormUrlList", JsonUtils.objectToJson(urList3));


        List<String> urList4 = new ArrayList<>();
        urList4.add("http://files.zcmall.com/web.pd/default/e1230bb3f9bc46b381a7db9d7801a393.doc");
        urList4.add("http://wwwww12.url");
        map.put("investorRiskConfirmationUrlList", JsonUtils.objectToJson(urList4));

        List<String> urList5 = new ArrayList<>();
        urList5.add("http://files.zcmall.com/web.pd/default/e1230bb3f9bc46b381a7db9d7801a393.doc");
        urList5.add("http://wwwww12.url");
        map.put("riskToleranceQuestionnaireUrlList", JsonUtils.objectToJson(urList5));

        List<String> urList6 = new ArrayList<>();
        urList6.add("http://files.zcmall.com/web.pd/default/e1230bb3f9bc46b381a7db9d7801a393.doc");
        urList6.add("http://wwwww12.url");
        map.put("fundCallbackUrlList", JsonUtils.objectToJson(urList3));

        List<String> urList7 = new ArrayList<>();
        urList7.add("http://files.zcmall.com/web.pd/default/e1230bb3f9bc46b381a7db9d7801a393.doc");
        urList7.add("http://wwwww12.url");
        map.put("otherContractUrlList", JsonUtils.objectToJson(urList7));
        /*map.put("renGouAmount", "22.22");
        map.put("renGouAmount", "22.22");
        map.put("renGouAmount", "22.22");
        map.put("renGouAmount", "22.22");
        map.put("renGouAmount", "22.22");
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

        List<String> investList = new ArrayList<>();
        investList.add("1");
        investList.add("2");
        map.put("investLike", JsonUtils.objectToJson(investList));

        map.put("birthday", String.valueOf(System.currentTimeMillis()));*/
        System.out.println(JsonUtils.objectToJson(map));
        post("/declaration/app/update", map);
    }

    @Test
    public void getPageForProductDetailTest() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("productId",3);
        get("/declaration/get_page_for_pro_detail",map);
    }
}
