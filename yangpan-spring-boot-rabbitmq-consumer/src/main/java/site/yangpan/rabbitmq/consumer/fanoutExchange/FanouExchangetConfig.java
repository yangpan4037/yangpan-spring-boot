package site.yangpan.rabbitmq.consumer.fanoutExchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanou交换机配置
 * FanoutExchange交换机是转发消息到所有绑定队列（广播模式，和routingKey没有关系）
 * Created by yangpan on 2019-07-16 22:09.
 */
@Configuration
public class FanouExchangetConfig {

    @Value("${yangpan.queue.four}")
    private String queue;

    @Value("${yangpan.exchange.four}")
    private String exchange;

    /**
     * fanout类型队列
     * @return
     */
    @Bean
    public Queue fanoutQueue() {
        return new Queue(queue);
    }

    /**
     * fanout类型交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchange);
    }

    /**
     * 绑定foanout类型队列和交换机
     * @param fanoutQueue
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingFanoutExchange(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);

    }

}
