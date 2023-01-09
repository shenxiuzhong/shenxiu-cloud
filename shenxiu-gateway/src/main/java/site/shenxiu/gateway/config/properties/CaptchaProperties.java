package site.shenxiu.gateway.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import site.shenxiu.gateway.enums.CaptchaCategory;
import site.shenxiu.gateway.enums.CaptchaType;

/**
 * 验证码属性配置
 *
 * @author shenxiu
 * @version 2022/11/28 16:14
 */
@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "shenxiu.security.captcha")
public class CaptchaProperties {
    /**
     * 验证码类型
     */
    private CaptchaType type;

    /**
     * 验证码类别
     */
    private CaptchaCategory category;

    /**
     * 数字验证码位数
     */
    private Integer numberLength;

    /**
     * 字符验证码长度
     */
    private Integer charLength;

    /**
     * 验证码开关
     */
    private Boolean enabled;

}
