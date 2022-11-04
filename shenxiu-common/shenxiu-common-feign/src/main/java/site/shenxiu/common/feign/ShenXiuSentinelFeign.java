package site.shenxiu.common.feign;

import com.alibaba.cloud.sentinel.feign.SentinelContractHolder;
import feign.Contract;
import feign.Feign;
import feign.InvocationHandlerFactory;
import feign.Target;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClientFactoryBean;
import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Allows Feign interfaces to return HystrixCommand or rx.Observable or rx.Single objects. Also
 * decorates normal Feign methods with circuit breakers, but calls {@link}
 * directly.
 * 自定义熔断器
 *
 * @author ShenXiu
 * @version 2022/11/4 11:15
 */
public final class ShenXiuSentinelFeign {
    private ShenXiuSentinelFeign() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends feign.Feign.Builder implements ApplicationContextAware {
        private Contract contract = new Contract.Default();
        private ApplicationContext applicationContext;
        private FeignContext feignContext;

        public Builder() {
        }

        @Override
        public Builder invocationHandlerFactory(InvocationHandlerFactory invocationHandlerFactory) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Builder contract(Contract contract) {
            this.contract = contract;
            return this;
        }

        @Override
        public <T> T target(Target<T> target) {
            // 自定义熔断器
            return (T) this.target(target, new ShenXiuGlobalFallbackFactory(target));
        }

        /**
         * @see #target fallbackFactory(Class, String, FallbackFactory)
         */
        public <T> T target(Target<T> target, FallbackFactory<? extends T> fallbackFactory) {
            return build(fallbackFactory).newInstance(target);
        }

        public Feign build(final FallbackFactory<?> defaultFallbackFactory) {
            super.invocationHandlerFactory(new InvocationHandlerFactory() {
                @Override
                public InvocationHandler create(Target target, Map<Method, MethodHandler> dispatch) {
                    GenericApplicationContext gctx = (GenericApplicationContext) ShenXiuSentinelFeign.Builder.this.applicationContext;
                    BeanDefinition def = gctx.getBeanDefinition(target.type().getName());
                    FeignClientFactoryBean feignClientFactoryBean = (FeignClientFactoryBean) def.getAttribute("feignClientsRegistrarFactoryBean");
                    Class fallback = feignClientFactoryBean.getFallback();
                    Class fallbackFactory = feignClientFactoryBean.getFallbackFactory();
                    String beanName = feignClientFactoryBean.getContextId();
                    if (!StringUtils.hasText(beanName)) {
                        beanName = (String) ShenXiuSentinelFeign.Builder.this.getFieldValue(feignClientFactoryBean, "name");
                    }

                    if (Void.TYPE != fallback) {
                        Object fallbackInstance = this.getFromContext(beanName, "fallback", fallback, target.type());
                        return new ShenXiuSentinelInvocationHandler(target, dispatch, new FallbackFactory.Default(fallbackInstance));
                    } else if (Void.TYPE != fallbackFactory) {
                        FallbackFactory fallbackFactoryInstance = (FallbackFactory) this.getFromContext(beanName, "fallbackFactory", fallbackFactory, FallbackFactory.class);
                        return new ShenXiuSentinelInvocationHandler(target, dispatch, fallbackFactoryInstance);
                    } else {
                        return new ShenXiuSentinelInvocationHandler(target, dispatch, defaultFallbackFactory);
                    }
                }

                private Object getFromContext(String name, String type, Class fallbackType, Class targetType) {
                    Object fallbackInstance = ShenXiuSentinelFeign.Builder.this.feignContext.getInstance(name, fallbackType);
                    if (fallbackInstance == null) {
                        throw new IllegalStateException(String.format("No %s instance of type %s found for feign client %s", type, fallbackType, name));
                    } else if (!targetType.isAssignableFrom(fallbackType)) {
                        throw new IllegalStateException(String.format("Incompatible %s instance. Fallback/fallbackFactory of type %s is not assignable to %s for feign client %s", type, fallbackType, targetType, name));
                    } else {
                        return fallbackInstance;
                    }
                }
            });
            super.contract(new SentinelContractHolder(this.contract));
            return super.build();
        }

        private Object getFieldValue(Object instance, String fieldName) {
            Field field = ReflectionUtils.findField(instance.getClass(), fieldName);
            field.setAccessible(true);

            try {
                return field.get(instance);
            } catch (IllegalAccessException var5) {
                return null;
            }
        }

        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
            this.feignContext = (FeignContext) this.applicationContext.getBean(FeignContext.class);
        }
    }
}
