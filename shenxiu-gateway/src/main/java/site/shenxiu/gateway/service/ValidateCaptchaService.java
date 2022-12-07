package site.shenxiu.gateway.service;

import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.gateway.exception.CaptchaException;

import java.util.Map;

/**
 * 验证码处理
 *
 * @author ruoyi
 */
public interface ValidateCaptchaService {
    /**
     * 生成验证码
     * @return 响应
     * @throws CaptchaException 验证异常
     */
    ResEntity<Map<String, Object>> createCaptcha() throws CaptchaException;

    /**
     * 校验验证码
     * @param code 验证码
     * @param uuid 编号
     * @throws CaptchaException 验证码异常
     */
    void checkCaptcha(String code, String uuid) throws CaptchaException;
}
