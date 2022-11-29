package site.shenxiu.gateway.exception;

import site.shenxiu.common.core.exception.BusinessException;

/**
 * 验证码错误异常类
 * @author ShenXiu
 * @version 2022/11/29 16:38
 */
public class CaptchaException extends BusinessException {
    private static final long serialVersionUID = 1L;

    public CaptchaException(String msg) {
        super(msg);
    }
}
