package site.yangpan.rabbitmq.consumer.directExchange;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DirectExchange配置类
 * Created by yangpan on 2019-07-15 22:27.
 */
@Configuration
public class DirectExchangeConfig {

    @Value("${yangpan.queue.one}")
    private String queue;

    @Bean
    public Queue directExchangeQueue() {
        return new Queue(queue);
    }
}
