package site.shenxiu.gateway.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.shenxiu.gateway.config.properties.IgnoreProperties;

/**
 * Sa-Token 权限认证 全局配置类
 *
 * @author ShenXiu
 * @version 2022/11/29 15:45
 */
@Configuration
public class ShenXiuSaTokenConfiguration {
    /**
     * 注册 [Sa-Token全局过滤器]
     * @param ignoreProperties 忽略配置
     * @return SaReactorFilter
     */
    @Bean
    public SaReactorFilter getSaReactorFilter(IgnoreProperties ignoreProperties) {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")
                .setExcludeList(ignoreProperties.getWhites())
                .addExclude("/favicon.ico", "/actuator/**")
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 登录校验 -- 拦截所有路由
                    SaRouter.match("/**")
                            .check(r -> {
                                // 检查是否登录 是否有token
                                StpUtil.checkLogin();

                                // 有效率影响 用于临时测试
                                // if (log.isDebugEnabled()) {
                                //     log.debug("剩余有效时间: {}", StpUtil.getTokenTimeout());
                                //     log.debug("临时有效时间: {}", StpUtil.getTokenActivityTimeout());
                                // }
                            });
                }).setError(e -> SaResult.error("认证失败，无法访问系统资源"));
    }
}
