package site.yangpan.properties.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * 读取自定配置文件
 * Created by yangpan on 2019-06-24 15:36.
 */
@ConfigurationProperties(prefix = "yangpan")
@PropertySource("classpath:config/yangpan.properties")
public class MyProperties {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
