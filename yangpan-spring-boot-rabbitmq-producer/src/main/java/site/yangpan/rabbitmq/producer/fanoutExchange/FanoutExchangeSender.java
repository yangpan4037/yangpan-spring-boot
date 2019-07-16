package site.yangpan.rabbitmq.producer.fanoutExchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Fanout交换机发送
 * FanoutExchange交换机是转发消息到所有绑定队列（广播模式，和routingKey没有关系）
 * Created by yangpan on 2019-07-16 22:18.
 */
@Component
public class FanoutExchangeSender {

    @Value("${yangpan.queue.four}")
    private String queue;

    @Value("${yangpan.exchange.four}")
    private String exchange;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void fanoutSend(String msg){
        System.out.println("生产者向队列”"+queue+"“发送消息: "+msg);
        rabbitTemplate.convertAndSend(exchange, queue, msg);
    }
}
