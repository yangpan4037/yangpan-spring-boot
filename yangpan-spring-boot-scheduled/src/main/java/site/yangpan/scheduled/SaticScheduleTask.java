package site.yangpan.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 静态定时任务
 * Created by yangpan on 2019-06-28 16:42.
 */
@Component
@Configuration
@EnableScheduling
public class SaticScheduleTask {

    /**
     * cron是一种表达式
     * 也可以指定直接这样：@Scheduled(fixedRate=5000)表示间歇5秒
     * @Scheduled还支持简单的延时操作，例如 fixedDelay ，fixedRate 填写相应的毫秒数即可。
     */
    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() {
        System.err.println("静态定时任务开始执行: " + LocalDateTime.now());
    }

}
