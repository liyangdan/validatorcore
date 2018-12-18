package com.zcy.validator.constarintvalidation;

import com.zcy.validator.constraints.IsMobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 约束验证器
 * ConstraintValidator定义了两个泛型参数, 第一个是这个校验器所服务到标注类型(在我们的例子中即IsMobile)
 * 第二个这个校验器所支持到被校验元素到类型 (即String).
 *
 * @author liyangdan
 * @date 2018/12/4 9:21 PM
 */

public class IsMobileValiadator implements ConstraintValidator<IsMobile, String> {
    static int count;
    private static final Pattern MOBILE_PATTERN = Pattern.compile("1\\d{10}");

    /**
     * 申明一个required 默认的值为false
     */

    public boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {

        //初始化:拿到IsMobile中的required中的值
        // 方法传进来一个所要验证的标注类型的实例
        required = constraintAnnotation.requried();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        count++;
        System.out.println("IsMobileValiadator执行count次数： " + count);
        //替换掉自定义属性
//        context.disableDefaultConstraintViolation();
//        context.buildConstraintViolationWithTemplate("bt自定义错误信息")
//                .addConstraintViolation();
        return Integer.parseInt(value) < 10 ? true : false;

    }


    public static boolean isMobile(String mobile){
        return MOBILE_PATTERN.matcher(mobile).matches();
    }

}
