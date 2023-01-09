package site.shenxiu.common.feign;

import com.alibaba.csp.sentinel.SphU;
import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * 自定义Feign熔断自动装配配置
 * <p> 替换SentinelFeign
 * @author shenxiu
 * @version 2022/11/4 11:13
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({ SphU.class, Feign.class })
public class ShenXiuSentinelFeignAutoConfiguration {

    @Bean
    @Primary
    @Scope("prototype")
    @ConditionalOnProperty(name = "feign.sentinel.enabled")
    public Feign.Builder feignSentinelBuilder() {
        return ShenXiuSentinelFeign.builder();
    }
}
