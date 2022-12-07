package site.shenxiu.common.feign;


import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import site.shenxiu.common.core.constant.HttpStatus;
import site.shenxiu.common.core.domain.ResEntity;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Feign熔断代理Fallback
 * 全局的fallback处理器
 *
 * @author zxx
 * @version 2022/8/15 11:57
 */
@Slf4j
public class ShenXiuFeignFallback<T> implements MethodInterceptor {
    private Class<T> targetType;
    private String targetName;
    private Throwable cause;

    public ShenXiuFeignFallback(Class<T> targetType, String targetName, Throwable cause) {
        this.targetType = targetType;
        this.targetName = targetName;
        this.cause = cause;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        FeignException exception = (FeignException) cause;
        log.error("FeignFallback:[{}.{}] serviceId:[{}] message:[{}]", targetType.getName(), method.getName(),
                targetName, exception.contentUTF8());
        //FeignException，直接返回
        if(cause instanceof FeignException){
            //告警代码实现 ......
            //此处只是示例,具体可以返回带有业务错误数据的对象

            return ResEntity.fail(HttpStatus.ERROR,cause.getMessage());
        }else{
            //非feign异常

            // 抛出异常解决
            throw cause;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShenXiuFeignFallback<?> that = (ShenXiuFeignFallback<?>) o;
        return targetType.equals(that.targetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetType);
    }
}
