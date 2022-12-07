package site.shenxiu.common.idempotent.config;

import org.springframework.context.annotation.Configuration;

/**
 * 幂等功能配置
 *
 * @author Lion Li
 */
@Configuration(proxyBeanMethods = false)
//@AutoConfigureAfter(RedisConfiguration.class)
public class IdempotentAutoConfiguration {

//	@Bean
//	public RepeatSubmitAspect repeatSubmitAspect() {
//		return new RepeatSubmitAspect();
//	}

}
