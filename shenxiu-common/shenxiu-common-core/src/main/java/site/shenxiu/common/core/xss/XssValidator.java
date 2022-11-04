package site.shenxiu.common.core.xss;

import cn.hutool.core.util.ReUtil;
import site.shenxiu.common.core.constant.HtmlConstants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义xss校验注解实现
 * 
 * @author ShenXiu
 * @version 2022/11/1 13:30
 */
public class XssValidator implements ConstraintValidator<Xss, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return !ReUtil.contains(HtmlConstants.MARK_REGEX, value);
    }
}