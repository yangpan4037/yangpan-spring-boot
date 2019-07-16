package site.yangpan.rabbitmq.consumer.headersExchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Headers类型交换机配置
 * 注意：
 * headers交换机的匹配规则是完全匹配，即参数必须完成一致
 * Created by yangpan on 2019-07-16 00:10.
 */
@Configuration
public class HeadersExchangeConfig {

    @Value("${yangpan.queue.three}")
    private String queue;

    @Value("${yangpan.exchange.three}")
    private String exchange;

    /**
     * headers类型队列
     * @return
     */
    @Bean
    public Queue headersQueue() {
        return new Queue(queue);
    }

    /**
     * headers类型交换机
     * @return
     */
    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(exchange);
    }

    /**
     * 绑定headers类型队列和交换机
     * @param headersQueue
     * @param headersExchange
     * @return
     */
    @Bean
    public Binding bindingHeadesExchange(Queue headersQueue, HeadersExchange headersExchange) {
        Map<String,Object> headerValues = new HashMap<>();
        headerValues.put("name", "yangpan");
        return BindingBuilder.bind(headersQueue).to(headersExchange).whereAll(headerValues).match();
    }
}
