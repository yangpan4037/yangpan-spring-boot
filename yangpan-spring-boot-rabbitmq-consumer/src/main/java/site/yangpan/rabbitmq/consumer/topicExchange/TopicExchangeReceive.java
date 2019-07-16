package site.yangpan.rabbitmq.consumer.topicExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * TopicExchange接收
 * 注意：
 * 1、TopicExchange交换机支持使用通配符*、#
 * 2、*号只能向后多匹配一层路径。
 * 3、#号可以向后匹配多层路径。
 * Created by yangpan on 2019-07-15 23:15.
 */
@Component
public class TopicExchangeReceive {

    @Value("${yangpan.queue.two}")
    private String queue;

    @RabbitHandler
    @RabbitListener(queues = "${yangpan.queue.two}")
    public void receive(String msg) {
        System.out.println("消费者接收到队列“"+queue+".#”的消息: "+msg);
    }
}
