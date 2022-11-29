package site.shenxiu.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import site.shenxiu.gateway.handler.ValidateCaptchaHandler;

import javax.annotation.Resource;

/**
 * 路由配置信息
 *
 */
@Configuration
public class RouterFunctionConfiguration {

    @Resource
    private ValidateCaptchaHandler validateCaptchaHandler;

    @SuppressWarnings("rawtypes")
    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions.route(
                RequestPredicates.GET("/captcha").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                validateCaptchaHandler);
    }
}
