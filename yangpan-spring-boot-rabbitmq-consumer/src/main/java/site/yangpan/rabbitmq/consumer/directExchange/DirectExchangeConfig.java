package site.yangpan.rabbitmq.consumer.directExchange;

import org.springframework.amqp.core.*;
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

    @Value("${yangpan.exchange.one}")
    private String exchange;

    /**
     * direct类型队列
     * @return
     */
    @Bean
    public Queue directQueue() {
        return new Queue(queue);
    }

    /**
     * direct类型交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    /**
     * 绑定direct类型队列和交换机
     * @param directQueue
     * @param directExchange
     * @return
     */
    @Bean
    public Binding bindingDirectExchange(Queue directQueue, FanoutExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange);

    }

}
