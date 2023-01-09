package site.shenxiu.common.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * feign拦截器, 在feign请求发出之前，加入一些操作
 * 
 * @author shenxiu 
 * @version 2022/11/4 11:19
 */
@Component
public class ShenXiuFeignInterceptor implements RequestInterceptor {
    // 为 Feign 的 RCP调用 添加请求头Id-Token
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //requestTemplate.header(SaIdUtil.ID_TOKEN, SaIdUtil.getToken());
    }
}
