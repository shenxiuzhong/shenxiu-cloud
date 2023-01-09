package site.shenxiu.common.loadbalancer.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡自动配置
 * 
 * @author shenxiu 
 * @version 2022/11/6 21:10
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties
@LoadBalancerClients(defaultConfiguration = ShenXiuLoadBalanceClientConfiguration.class)
public class ShenXiuLoadBalanceAutoConfiguration {
}
