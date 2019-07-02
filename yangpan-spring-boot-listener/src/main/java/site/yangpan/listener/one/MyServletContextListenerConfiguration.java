package site.yangpan.listener.one;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过ServletListenerRegistrationBean将自定义监听器添加到spring管理
 * Created by yangpan on 2019-07-01 15:31.
 */
@Configuration
public class MyServletContextListenerConfiguration {

    @Bean
    public ServletListenerRegistrationBean registrationBean(){
        ServletListenerRegistrationBean register = new ServletListenerRegistrationBean();
        register.setListener(new MyServletContextListener());
        return register;
    }
}
