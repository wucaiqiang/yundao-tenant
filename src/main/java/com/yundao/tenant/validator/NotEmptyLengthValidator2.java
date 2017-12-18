package com.yundao.tenant.validator;

import com.yundao.tenant.constant.code.CodeConstant;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author jan
 * @create 2017-07-19 PM8:41
 **/
public class NotEmptyLengthValidator2 implements ConstraintValidator<NotEmptyLength2, Object> {

    private String message;
    private int max;
    private String objectName;

    @Override
    public void initialize(NotEmptyLength2 obj) {
        this.max = obj.max();
        this.objectName = obj.objectName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null || value.toString().trim().length() == 0) {
            this.message = "{" + CodeConstant.CODE_1220017 + "}";
            this.objectName = this.objectName + "不能为空";
            return false;
        }
        if (value.toString().trim().length() > this.max) {
            this.message = "{" + CodeConstant.CODE_1200000 + "}";
            this.objectName = this.objectName + "长度不能大于" + this.max;
            return false;
        }
        return true;
    }
}
