package site.yangpan.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import site.yangpan.repository.CronRepository;

import java.time.LocalDateTime;

/**
 * 动态定时任务，间歇时间读取数据库
 * Created by yangpan on 2019-06-28 16:49.
 */
@Component
@Configuration
@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Autowired
    private CronRepository cronRepository;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
                //这里写定时任务的内容
                System.err.println("动态定时任务开始执行: " + LocalDateTime.now());
            }, triggerContext -> {
                //这里从数据库读取定时任务间歇时间
                String cron = cronRepository.findById("404bbc9e-9984-11e9-9f47-54e1ad02df37").get().getCornContent();
                return new CronTrigger(cron).nextExecutionTime(triggerContext);
            }
        );
    }

}
