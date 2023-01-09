package site.shenxiu.gateway.utils;

import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.alibaba.nacos.shaded.com.google.gson.GsonBuilder;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;
import site.shenxiu.common.core.constant.HttpStatus;
import site.shenxiu.common.core.domain.ResEntity;

import java.nio.charset.StandardCharsets;

/**
 * WebFlux工具类
 *
 * @author shenxiu
 * @version 2022/11/28 17:33
 */
public class WebFluxUtils {


    /**
     * 设置webflux模型成功响应
     *
     * @param response ServerHttpResponse
     * @param msg      消息
     * @return 响应信息
     */
    public static Mono<Void> success(ServerHttpResponse response, Object msg) {
        return webFluxResponseWriter(response, HttpStatus.SUCCESS, msg);
    }

    /**
     * 设置webflux模型失败响应
     *
     * @param response ServerHttpResponse
     * @param msg      消息内容
     * @return 响应信息
     */
    public static Mono<Void> fail(ServerHttpResponse response, Object msg) {
        return webFluxResponseWriter(response, HttpStatus.ERROR, msg);
    }

    /**
     * 设置webflux模型响应
     *
     * @param response   ServerHttpResponse
     * @param statusCode http状态码
     * @param msg        消息内容
     * @return 响应信息
     */
    public static Mono<Void> webFluxResponseWriter(ServerHttpResponse response, Integer statusCode, Object msg) {
        return webFluxResponseWriter(response, MediaType.APPLICATION_JSON_VALUE, statusCode, msg);
    }

    /**
     * 设置webflux模型响应
     *
     * @param response    ServerHttpResponse
     * @param contentType content-type
     * @param statusCode  http状态码
     * @param msg         消息内容
     * @return 响应信息
     */
    public static Mono<Void> webFluxResponseWriter(ServerHttpResponse response, String contentType, Integer statusCode, Object msg) {
        response.setRawStatusCode(statusCode);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, contentType);
        ResEntity<?> result = ResEntity.fail(statusCode, msg.toString());
        Gson gson = new GsonBuilder().create();
        DataBuffer dataBuffer = response.bufferFactory().wrap(gson.toJson(result).getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(dataBuffer));
    }
}
