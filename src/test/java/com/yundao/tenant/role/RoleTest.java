package com.yundao.tenant.role;

import com.yundao.core.utils.DesUtils;
import com.yundao.core.validator.length.Length;
import com.yundao.tenant.AbstractTest;
import com.yundao.tenant.dto.customer.customer.CustomerReqDto;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author jan
 * @create 2017-08-01 PM9:53j
 **/
public class RoleTest extends AbstractTest {

    @Test
    public void updateRoleResource() throws Exception {

   /*     System.out.printf(DesUtils.encrypt("jdbc:mysql://yundaords.mysql.rds.aliyuncs.com:3306/wm_tenant_shenfa?useUnicode=true") + "          ");
        System.out.printf(DesUtils.encrypt("shenfa_fund_1102") + "          ");*/
        System.out.printf(DesUtils.decrypt("a2b3e911831c959c26401c9d6a9a9eba") + "          ");

       /* System.out.printf(DesUtils.decrypt("A51FDA7AA0A59A9A7A8AFF6DF1C18B555AA1C9163F8D06552776DF542CC47AD0AE5576F749DC21FB8CDCB83420670D383D4EBAA4A73C80FC857AD357952BA75953CB57666C36FB391E8D0A9F58FDBEC8FBC89884E81501F7C3707691B0B2E618")+"          " );
        System.out.printf(DesUtils.decrypt("133C0052AB35AA97B35E5B2087AB9760FE9CCAB727F0CA9D"));*/


    }

    @Test
    public void annotationText() throws Exception {
        try {
        /*    // 此处要用反射将字段中的注解解析出来
            Class<CustomerReqDto> clz = CustomerReqDto.class;
            // 判断类上是否有次注解
            boolean clzHasAnno = clz.isAnnotationPresent(Length.class);
            if (clzHasAnno) {
                // 获取类上的注解
                FieldTypeAnnotation annotation = clz.getAnnotation(FieldTypeAnnotation.class);
                // 输出注解上的属性
                int age = annotation.age();
                String[] hobby = annotation.hobby();
                String type = annotation.type();
                System.out.println(clz.getName() + " age = " + age + ", hobby = " + Arrays.asList(hobby).toString() + " type = " + type);
            }

            AnnotationValidator*/


            Field field = CustomerReqDto.class.getDeclaredField("name");//获取成员变量value
            field.setAccessible(true);//将value设置成可访问的
            if (field.isAnnotationPresent(Length.class)) {//判断成员变量是否有注解
                Length myAnnotation = field.getAnnotation(Length.class);//获取定义在成员变量中的注解MyAnnotation
                int value = myAnnotation.max();//获取定义在MyBean的MyAnnotation里面属性值
                CustomerReqDto myBean = new CustomerReqDto();
                field.set(myBean, "CustomerReqDtoCustomerReqDtoCustomerReqDtoCustomerReqDtoCustomerReqDto");


//                field.setInt(myBean, value);//将注解的值20可以赋给成员变量value
                System.out.println(myBean);//验证结果
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
