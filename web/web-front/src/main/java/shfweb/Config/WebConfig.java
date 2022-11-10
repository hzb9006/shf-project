package shfweb.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import shfweb.interceptor.LoginInterceptor;

@Configuration// 指明这是一个配置类
public class WebConfig implements WebMvcConfigurer {// 实现mvc配置的接口

    // 重写方法，添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        如果访问的url中含有auth，则会执行我们拦截器里的方法
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**/auth/**");
    }
}
