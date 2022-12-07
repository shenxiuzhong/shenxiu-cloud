package site.shenxiu.common.web.handler;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.common.core.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 全局异常处理
 * @author ShenXiu
 * @version 2022/12/1 16:53
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 请求方式不支持异常
     * @param e 请求方式异常
     * @param request 请求
     * @return 错误响应
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResEntity<Void> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                               HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
        return ResEntity.fail(e.getMessage());
    }

    /**
     * 业务异常
     * @param e 请求方式异常
     * @param request 请求
     * @return 错误响应
     */
    @ExceptionHandler(BusinessException.class)
    public ResEntity<Void> handleServiceException(BusinessException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        log.error(e.getMessage(), e);
        Integer code = e.getCode();
        return ObjectUtil.isNotNull(code) ? ResEntity.fail(code, e.getMessage()) : ResEntity.fail(e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     * @param e 请求方式异常
     * @param request 请求
     * @return 错误响应
     */
    @ExceptionHandler(RuntimeException.class)
    public ResEntity<Void> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return ResEntity.fail(e.getMessage());
    }

    /**
     * 系统异常
     * @param e 请求方式异常
     * @param request 请求
     * @return 错误响应
     */
    @ExceptionHandler(Exception.class)
    public ResEntity<Void> handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return ResEntity.fail(e.getMessage());
    }

    /**
     * 自定义验证异常
     * @param e 请求方式异常
     * @return 错误响应
     */
    @ExceptionHandler(BindException.class)
    public ResEntity<Void> handleBindException(BindException e) {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return ResEntity.fail(message);
    }

    /**
     * 自定义验证异常
     * @param e 请求方式异常
     * @return 错误响应
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResEntity<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return ResEntity.fail(message);
    }
}
