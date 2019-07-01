package site.yangpan.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 可以注册拦截器的配置器
 * Created by yangpan on 2019-07-01 11:26.
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 注册添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册添加我们自定义的拦截器
        registry.addInterceptor(new MyInterceptor())
                //添加需要拦截的路径
                .addPathPatterns("/interceptor/**")
                //添加不拦截的路径
                .excludePathPatterns("excludeInterceptor/**");
    }

}
