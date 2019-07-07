package site.yangpan.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 传统方式
 * 1.通过private static Logger log = LoggerFactory.getLogger(TraditionalUseLog.class);
 * 2.直接使用log.info();
 * Created by yangpan on 2019-07-07 18:39.
 */
@Component
@Configuration
@EnableScheduling
public class TraditionalUseLog {

    private static Logger log = LoggerFactory.getLogger(TraditionalUseLog.class);

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
