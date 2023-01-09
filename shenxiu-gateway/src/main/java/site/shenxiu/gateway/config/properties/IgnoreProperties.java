package site.shenxiu.gateway.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 忽略文件属性配置
 *
 * @author shenxiu
 * @version 2022/11/28 16:33
 */
@Data
@NoArgsConstructor
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "shenxiu.security.ignore")
public class IgnoreProperties {

    /**
     * 白名单配置，网关不校验此处的白名单
     */
    private List<String> whites = new ArrayList<>();
}
