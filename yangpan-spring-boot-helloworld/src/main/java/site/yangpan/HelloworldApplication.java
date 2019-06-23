package site.yangpan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication注解让spring boot自动给程序进行必要的配置；
 * 它等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan三个注解。
 */
@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }

}
