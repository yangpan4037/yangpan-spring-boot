package site.yangpan.environment.aware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.environment.aware.config.MyEnvironmentAware;

/**
 * EnvironmentAwareController
 * Created by yangpan on 2019-06-27 16:32.
 */
@RestController
@RequestMapping("/environmentAware")
public class EnvironmentAwareController {

    @Autowired
    private MyEnvironmentAware myEnvironmentAware;

    @GetMapping("/java")
    public String javaPath(){
        return "系统JAVA_HOME：" + myEnvironmentAware.getJavaPath();
    }
}