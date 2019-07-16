package site.yangpan.rabbitmq.producer.directExchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * DirectExchange发送
 * Created by yangpan on 2019-07-15 22:31.
 */
@Component
public class DirectExchangeSender {

    @Value("${yangpan.queue.one}")
    private String queue;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg){
        System.out.println("生产者向队列”"+queue+"“发送消息: "+msg);
        rabbitTemplate.convertAndSend(queue, msg);
    }
}
