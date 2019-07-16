package site.yangpan.rabbitmq.producer.topicExchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * TopicExchange发送
 * 注意：
 * 1、TopicExchange交换机支持使用通配符*、#
 * 2、*号只能向后多匹配一层路径。
 * 3、#号可以向后匹配多层路径。
 * Created by yangpan on 2019-07-15 23:18.
 */
@Component
public class TopicExchangeSender {

    @Value("${yangpan.queue.two}")
    private String queue;

    @Value("${yangpan.exchange.two}")
    private String exchange;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void topicSendOne(String msg){
        System.out.println("生产者向队列”"+queue+".a“发送消息: "+msg);
        rabbitTemplate.convertAndSend(exchange, queue+".a", msg);
    }

    public void topicSendTwo(String msg){
        System.out.println("生产者向队列”"+queue+".a.b“发送消息: "+msg);
        rabbitTemplate.convertAndSend(exchange, queue+".a.b", msg);
    }

}
