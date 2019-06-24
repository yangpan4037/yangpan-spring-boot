package site.yangpan.properties.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件的属性转换为实体类
 * Created by yangpan on 2019-06-24 15:16.
 */
@ConfigurationProperties(prefix = "yangpan")
public class MyConfigBean {

    private String name;
    private Integer age;
    private String number;
    private String email;
    private String address;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MyConfigBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
