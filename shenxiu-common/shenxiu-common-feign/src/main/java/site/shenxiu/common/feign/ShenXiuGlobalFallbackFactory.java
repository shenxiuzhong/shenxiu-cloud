package site.shenxiu.common.feign;


import feign.Target;
import lombok.AllArgsConstructor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * 全局熔断降级处理 全局熔断FallbackFactory实现类
 *
 * @author zxx
 * @version 2022/8/15 10:48
 */
@AllArgsConstructor
public class ShenXiuGlobalFallbackFactory<T> implements FallbackFactory<T> {

    /**
     * 被代理目标对象
     */
    private Target<T> target;

    @Override
    public T create(Throwable cause) {
        // 获取@FeignClient注解的接口类型
        Class<T> targetType = target.type();
        String targetName = target.name();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetType);
        enhancer.setUseCache(true);
        enhancer.setCallback(new ShenXiuFeignFallback<>(targetType, targetName, cause));
        return (T) enhancer.create();
    }
}
