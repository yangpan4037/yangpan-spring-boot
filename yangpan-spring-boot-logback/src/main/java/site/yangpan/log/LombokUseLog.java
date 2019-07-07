package site.yangpan.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * lombok方式
 * 1、引入lombok依赖
 * 2、在需要打印日志的类上添加使用@Slf4j，然后使用log变量
 * 注意；在idea中使用lombok的@Slf4j注解log变量无效，需要安装lombok插件
 * Created by yangpan on 2019-07-07 19:03.
 */
@Slf4j
@Configuration
@EnableScheduling
public class LombokUseLog {

    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() {
        //定义测试参数，然后通过占位符打印日志参数
        String name="yangpan";
        Date date = new Date();
        log.trace("{} {} 打印trace日志", name, date);
        log.debug("{} {} 打印debug日志", name, date);
        log.info("{} {} 打印info日志", name, date);
        log.warn("{} {} 打印warn日志", name, date);
        log.error("第222个节点{} {} 打印error日志", name, date);
    }

}
