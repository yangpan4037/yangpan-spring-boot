package site.yangpan.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 测试freemarker的controller
 * Created by yangpan on 2019-07-10 17:01.
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    /**
     * 返回的hello代表的路径是src/main/resources/templates/hello.ftl
     * @param model
     * @return
     */
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","yangpan");
        model.addAttribute("birthday", new Date());
        model.addAttribute("likes", new String[]{"看书", "上网", "玩游戏"});
        return "hello";
    }
}
