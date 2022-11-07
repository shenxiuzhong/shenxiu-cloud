package site.shenxiu.common.loadbalancer.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 负载均衡host属性获取
 * @author ShenXiu
 * @version 2022/11/6 21:30
 */
@Slf4j
@Component
public class ShenXiuLoadBalancerInstance {
    /**
     * 本地host地址
     */
    @Value("shenxiu.loadbalance.host")
    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 获取服务host
     * 未配置时自动获取服务地址
     */
    public String getHost() {
        if (this.host == null || this.host.trim().length() < 1) {
            this.host = "127.0.0.1";
        } else {
            try {
                // 如需自定义ip可修改此处
                String address = InetAddress.getLocalHost().getHostAddress();
                if (address != null) {
                    this.host = address;
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        log.debug("[LoadBalancer] - 本机IP地址: {}", this.host);
        return this.host;
    }
}
