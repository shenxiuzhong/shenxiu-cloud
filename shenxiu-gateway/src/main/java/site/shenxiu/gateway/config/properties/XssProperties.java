package site.shenxiu.gateway.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Xss跨站脚本配置
 *
 * @author ShenXiu
 * @version 2022/11/28 14:30
 */

@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "shenxiu.security.xss")
public class XssProperties {
    /**
     * Xss开关
     */
    private Boolean enabled;

    /**
     * 排除站点
     */
    private List<String> excludeSites = new ArrayList<>();

}
