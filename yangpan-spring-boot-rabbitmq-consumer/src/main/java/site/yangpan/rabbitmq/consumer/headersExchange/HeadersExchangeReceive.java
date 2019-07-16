package site.yangpan.rabbitmq.consumer.headersExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * HeadersExchangeReceive
 * 注意：
 * headers交换机的匹配规则是完全匹配，即参数必须完成一致
 * Created by yangpan on 2019-07-16 00:20.
 */
@Component
public class HeadersExchangeReceive {

    @Value("${yangpan.queue.three}")
    private String queue;

    @RabbitHandler
    @RabbitListener(queues = "${yangpan.queue.three}")
    public void creditBank(String msg) {
        System.out.println("消费者接收到队列“"+queue+"”的消息: "+msg);
    }
}
