package site.yangpan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {

    /**
     * 第一种方式
     * 将RestTemplate注册成Bean
     * @return
     */
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    /**
     * 第二种方式
     * 通过RestTemplateBuilder将RestTemplate注册成Bean
     * @param restTemplateBuilder
     * @return
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);
    }

}
