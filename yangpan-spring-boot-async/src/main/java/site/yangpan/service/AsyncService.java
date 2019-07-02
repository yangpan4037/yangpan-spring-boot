package site.yangpan.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 测试异步方法Service
 * Created by yangpan on 2019-07-02 16:44.
 */
@Service
public class AsyncService {

    @Async
    public String test() throws Exception{
        Thread.sleep(3000);
        System.out.println("service 异步方法执行完毕。。。");
        return "异步方法返回结果。";
    }
}
