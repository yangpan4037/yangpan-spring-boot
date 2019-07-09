package site.yangpan.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * ThymeleafController
 * Created by yangpan on 2019-07-09 21:40.
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    /**
     * 返回的hello代表的路径是src/main/resources/templates/hello.html
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
