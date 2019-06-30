package site.yangpan.filter.one;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器第一种实现方法：实现Filter接口，然后通过FilterRegistrationBean注册成Bean
 * Created by yangpan on 2019-06-30 22:04.
 */
@Configuration
public class FirstFilterConfiguration {

    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new FirstFilter());
        registration.addUrlPatterns("/firstFilter");
        registration.setName("firstFilter");
        registration.setOrder(1);
        return registration;
    }

}
