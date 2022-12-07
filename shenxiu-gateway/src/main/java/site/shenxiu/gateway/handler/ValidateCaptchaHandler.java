package site.shenxiu.gateway.handler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.gateway.exception.CaptchaException;
import site.shenxiu.gateway.service.ValidateCaptchaService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 验证码获取
 *
 * @author ruoyi
 */
@Component
public class ValidateCaptchaHandler implements HandlerFunction<ServerResponse> {

    @Resource
    private ValidateCaptchaService validateCaptchaService;

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        ResEntity<Map<String, Object>> ajax;
        try {
            ajax = validateCaptchaService.createCaptcha();
        } catch (CaptchaException e) {
            return Mono.error(e);
        }
        return ServerResponse.status(HttpStatus.OK).body(BodyInserters.fromValue(ajax));
    }
}
