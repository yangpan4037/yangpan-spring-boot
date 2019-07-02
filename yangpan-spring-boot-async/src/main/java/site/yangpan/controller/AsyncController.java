package site.yangpan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.service.AsyncService;

/**
 * 测试异步方法Controller
 * Created by yangpan on 2019-07-02 11:50.
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    /**
     * 测试调用异步方法
     * @return
     * @throws Exception
     */
    @GetMapping("/test")
    public String test() throws Exception {
        String result = asyncService.test();
        if(null == result) result="controller 接口方法执行完毕，service 异步方法没有执行完毕。。";
        System.out.println("controller 接口方法执行完毕。。。");
        return result;
    }

}
