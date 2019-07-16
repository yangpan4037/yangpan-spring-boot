package site.yangpan.rabbitmq.consumer.topicExchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TopicExchange配置类
 * 注意：
 * 1、TopicExchange交换机支持使用通配符*、#
 * 2、*号只能向后多匹配一层路径。
 * 3、#号可以向后匹配多层路径。
 * Created by yangpan on 2019-07-15 23:40.
 */
@Configuration
public class TopicExchangeConfig {

    @Value("${yangpan.queue.two}")
    private String queue;

    @Value("${yangpan.exchange.two}")
    private String exchange;

    /**
     * topic类型队列
     * @return
     */
    @Bean
    public Queue topicQueue() {
        return new Queue(queue);
    }

    /**
     * topic类型交换机
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchange);
    }

    /**
     * 绑定topic队列和topic交换机
     * @param topicQueue
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding bindingTopicExchange(Queue topicQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(queue+".#");
    }
}
