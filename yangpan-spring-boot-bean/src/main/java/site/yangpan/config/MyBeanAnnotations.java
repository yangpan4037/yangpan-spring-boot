package site.yangpan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.yangpan.bean.Pig;

/**
 * 通过注解方式注册Bean
 * Created by yangpan on 2019-06-26 15:41.
 */
@Configuration
public class MyBeanAnnotations {

    @Bean(name="pig")
    public Pig registerPigBean(){
        Pig pig = new Pig();
        pig.setName("佩奇");
        return pig;
    }

}
