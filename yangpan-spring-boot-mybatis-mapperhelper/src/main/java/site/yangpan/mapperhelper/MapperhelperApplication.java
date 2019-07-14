package site.yangpan.mapperhelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"site.yangpan.mapperhelper.mapper"})//注意这个注解是tk包下面的
public class MapperhelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapperhelperApplication.class, args);
    }

}
