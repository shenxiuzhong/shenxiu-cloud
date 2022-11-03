package site.shenxiu.common.feign;


import com.sun.istack.internal.Nullable;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Feign熔断代理Fallback
 * 全局的fallback处理器
 *
 * @author zxx
 * @date2022/8/15 11:57
 */
@Slf4j
public class ShenxiuFeignFallback<T> implements MethodInterceptor {
    private Class<T> targetType;
    private String targetName;
    private Throwable cause;

    public ShenxiuFeignFallback(Class<T> targetType, String targetName, Throwable cause) {
        this.targetType = targetType;
        this.targetName = targetName;
        this.cause = cause;
    }

    @Nullable
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        FeignException exception = (FeignException) cause;
        log.error("FeignFallback:[{}.{}] serviceId:[{}] message:[{}]", targetType.getName(), method.getName(),
                targetName, exception.contentUTF8());
        //FeignException，直接返回
        if(cause instanceof FeignException){
            //告警代码实现 ......
            //此处只是示例,具体可以返回带有业务错误数据的对象
            return R.fail(HttpStatus.SYSTEM_INNER_ERROR,cause.getMessage());
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
        ShenxiuFeignFallback<?> that = (ShenxiuFeignFallback<?>) o;
        return targetType.equals(that.targetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetType);
    }
}
