package site.yangpan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ExceptionController
 * Created by yangpan on 2019-06-23 20:54.
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/zeroException")
    @ResponseBody
    public int zeroException(){
        return 1 / 0;
    }

    @RequestMapping("/nullException")
    @ResponseBody
    public int nullException(){
        Integer number = null;
        return number / 1;
    }

}
