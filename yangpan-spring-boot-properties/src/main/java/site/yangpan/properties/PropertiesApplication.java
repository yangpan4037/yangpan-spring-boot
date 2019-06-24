package site.yangpan.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import site.yangpan.properties.config.MyConfigBean;
import site.yangpan.properties.config.MyProperties;

@SpringBootApplication
@EnableConfigurationProperties({MyConfigBean.class, MyProperties.class})
public class PropertiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertiesApplication.class, args);
    }

}
