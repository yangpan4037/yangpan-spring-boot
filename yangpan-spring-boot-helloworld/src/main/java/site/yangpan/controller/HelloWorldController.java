package site.yangpan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController
 * Created by yangpan on 2019-06-23 19:51.
 * 注解@RestController相当于@ResponseBody 和 @Controller的组合
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(){
        return "hello，欢迎使用spring boot！";
    }
}
