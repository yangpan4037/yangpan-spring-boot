package site.yangpan.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 异步定时任务
 * 例如：
 * 第一个定时任务间歇1秒执行，执行需要10秒，
 * 第二个定时任务间隔2秒执行，执行需要1秒，
 * 我们知道程序肯定先加载第一个定时任务，后加载第二个定时任务
 * 那么第二个定时任务并不会在第一个执行完才执行，他可能比第一个先执行完，就好像他们是并行的，就像多线程一样。
 * Created by yangpan on 2019-06-28 17:15.
 */
@Component
@Configuration
@EnableAsync
@EnableScheduling
public class AsyncScheduleTask {

    @Async
    @Scheduled(fixedDelay = 1000)  //间隔1秒
    public void first() throws InterruptedException {
        System.out.println("第一个线程定时任务开始执行： " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        System.out.println();
        Thread.sleep(1000 * 10);
    }

    @Async
    @Scheduled(fixedDelay = 2000)
    public void second() {
        System.out.println("第二个线程定时任务开始执行 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        System.out.println();
    }

}
