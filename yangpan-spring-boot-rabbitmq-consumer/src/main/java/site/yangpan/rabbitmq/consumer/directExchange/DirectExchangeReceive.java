package site.yangpan.rabbitmq.consumer.directExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * DirectExchange接收
 * Created by yangpan on 2019-07-15 22:29.
 */
@Component
public class DirectExchangeReceive {

    @Value("${yangpan.queue.one}")
    private String queue;

    @RabbitHandler
    @RabbitListener(queues = "${yangpan.queue.one}")
    public void aaaa(String msg) {
        System.out.println("消费者接收到队列“"+queue+"”的消息: "+msg);
    }
}
