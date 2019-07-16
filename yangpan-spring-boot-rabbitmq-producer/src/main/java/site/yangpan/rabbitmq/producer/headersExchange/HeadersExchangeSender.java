package site.yangpan.rabbitmq.producer.headersExchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;

/**
 * HeadersExchange发送
 * 注意：
 * headers交换机的匹配规则是完全匹配，即参数必须完成一致
 * Created by yangpan on 2019-07-16 00:22.
 */
@Component
public class HeadersExchangeSender {

    @Value("${yangpan.queue.three}")
    private String queue;

    @Value("${yangpan.exchange.three}")
    private String exchange;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void headerSend(String msg){
        System.out.println("生产者向队列”"+queue+"“发送消息: "+msg);
        Map<String,Object> head = new HashMap<>();
        head.put("name", "yangpan");
        rabbitTemplate.convertAndSend(exchange, queue, getMessage(head, msg));
    }

    private Message getMessage(Map<String, Object> head, Object msg){
        MessageProperties messageProperties = new MessageProperties();
        for (Map.Entry<String, Object> entry : head.entrySet()) {
            messageProperties.setHeader(entry.getKey(), entry.getValue());
        }
        MessageConverter messageConverter = new SimpleMessageConverter();
        return messageConverter.toMessage(msg, messageProperties);
    }


}
