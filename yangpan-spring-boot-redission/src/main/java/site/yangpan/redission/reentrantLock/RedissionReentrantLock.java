package site.yangpan.redission.reentrantLock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基于Redis的Redisson分布式可重入锁RLock
 * Java对象实现了java.util.concurrent.locks.Lock接口。
 * 同时还提供了异步（Async）、反射式（Reactive）和RxJava2标准的接口。
 * Created by yangpan on 2020-08-29 19:40.
 */
@Controller
@RestController
@RequestMapping("/redissionReentrantLock")
public class RedissionReentrantLock {

    private Integer stock = 100;

    @Autowired
    private RedissonClient redissonClient;


    @GetMapping("/test")
    public void test(){
        //使用线程池模拟并发，看分布式锁有没有问题
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for(int i=0;i<=1000;i++){
            executorService.execute(() -> {
                try {
                    Thread.sleep(3000);
                    //调用加锁方法
                    reduceStockRessionLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 加锁情况
     */
    private void reduceStockRessionLock() {
        //获取锁（可重入锁）
        RLock lock = redissonClient.getLock("anyLock");

        //加锁
        lock.lock();

        //业务操作
        if(stock > 0){
            stock--;
            System.out.println("当前库存剩余：" + stock);
        }

        //释放锁
        lock.unlock();
    }

    /**
     * 不加锁情况
     */
    private void reduceStock() throws InterruptedException {
        //业务操作
        if(stock > 0){
            stock--;
            System.out.println("当前库存剩余：" + stock);
        }
    }

}
