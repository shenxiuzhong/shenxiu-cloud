package site.shenxiu.common.loadbalancer.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.shenxiu.common.loadbalancer.core.ShenXiuLoadBalancerHost;

/**
 * 自定义负载均衡自动配置
 * 
 * @author ShenXiu 
 * @version 2022/11/6 21:10
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties
@LoadBalancerClients(defaultConfiguration = ShenXiuLoadBalanceClientConfiguration.class)
public class ShenXiuLoadBalanceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ShenXiuLoadBalancerHost shenXiuLoadBalancerHost() {
        return new ShenXiuLoadBalancerHost();
    }
}
