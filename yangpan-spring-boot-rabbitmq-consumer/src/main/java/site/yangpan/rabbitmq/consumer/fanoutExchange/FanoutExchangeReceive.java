package site.yangpan.rabbitmq.consumer.fanoutExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Fanout交换机接收
 * FanoutExchange交换机是转发消息到所有绑定队列（广播模式，和routingKey没有关系）
 * Created by yangpan on 2019-07-16 22:16.
 */
@Component
public class FanoutExchangeReceive {

    @Value("${yangpan.queue.four}")
    private String queue;

    @RabbitHandler
    @RabbitListener(queues = "${yangpan.queue.four}")
    public void fanoutReceive(String msg) {
        System.out.println("消费者接收到队列“"+queue+"”的消息: "+msg);
    }
}
