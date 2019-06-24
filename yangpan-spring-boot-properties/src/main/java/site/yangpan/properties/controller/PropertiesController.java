package site.yangpan.properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.properties.config.MyConfigBean;
import site.yangpan.properties.config.MyProperties;

/**
 * PropertiesController
 * Created by yangpan on 2019-06-24 15:03.
 */
@RestController
@RequestMapping("/properties")
public class PropertiesController {

    @Value("${yangpan.name}")
    private String name;

    @Value("${yangpan.age}")
    private int age;

    @Autowired
    private MyConfigBean myConfigBean;

    @Autowired
    private MyProperties myProperties;

    /**
     * 测试通过@Value("${xxx}")读取属性
     * @return
     */
    @GetMapping("/info")
    public String info(){
        return name + "今年" + age;
    }

    /**
     * 测试属性转化成实体
     * @return
     */
    @GetMapping("/bean")
    public String bean(){
        return myConfigBean.toString();
    }


    /**
     * 测试自定义配置文件
     * @return
     */
    @GetMapping("/custom")
    public String custom(){
        return myProperties.toString();
    }


}
