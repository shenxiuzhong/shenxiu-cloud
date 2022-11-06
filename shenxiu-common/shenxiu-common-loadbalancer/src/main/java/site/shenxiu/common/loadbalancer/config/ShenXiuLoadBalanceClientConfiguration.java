package site.shenxiu.common.loadbalancer.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import site.shenxiu.common.loadbalancer.core.ShenXiuLoadBalancerHost;
import site.shenxiu.common.loadbalancer.core.ShenXiuLoadBalancer;

/**
 * 自定义负载均衡客户端配置
 *
 * @author ShenXiu
 * @version 2022/11/6 21:03
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
public class ShenXiuLoadBalanceClientConfiguration {

    @Bean
    @ConditionalOnBean(LoadBalancerClientFactory.class)
    @ConditionalOnProperty(name = "shenxiu.loadbalance.enabled")
    public ReactorLoadBalancer<ServiceInstance> shenXiuLoadBalancer(Environment environment,
                                                                    LoadBalancerClientFactory loadBalancerClientFactory,
                                                                    ShenXiuLoadBalancerHost shenXiuLoadBalancerHost) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new ShenXiuLoadBalancer(
                loadBalancerClientFactory.getLazyProvider(name,
                        ServiceInstanceListSupplier.class),
                name, shenXiuLoadBalancerHost);
    }
}
