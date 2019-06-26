package site.yangpan.xml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yangpan.bean.MyBean;

/**
 * 测试使用XML配置Bean的Controller
 * Created by yangpan on 2019-06-26 16:47.
 */
@RestController
@RequestMapping("/xmlBean")
public class XmlBeanController {

    @Autowired
    private MyBean myBean;

    @GetMapping("/test")
    public String test(){
        return myBean.hello();
    }
}
