package site.yangpan.rabbitmq.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.rabbitmq.producer.directExchange.DirectExchangeSender;
import site.yangpan.rabbitmq.producer.fanoutExchange.FanoutExchangeSender;
import site.yangpan.rabbitmq.producer.headersExchange.HeadersExchangeSender;
import site.yangpan.rabbitmq.producer.topicExchange.TopicExchangeSender;

/**
 * 生产者发送消息controller
 * Created by yangpan on 2019-07-15 22:39.
 */
@RestController
@RequestMapping("/producer")
public class ProducerSenderController {

    @Autowired
    private DirectExchangeSender directExchangeSender;

    @Autowired
    private TopicExchangeSender topicExchangeSender;

    @Autowired
    private HeadersExchangeSender headersExchangeSender;

    @Autowired
    private FanoutExchangeSender fanoutExchangeSender;

    @GetMapping("/directExchangeSender/{message}")
    public String directExchangeSender(@PathVariable("message") String message){
        directExchangeSender.topicSend(message);
        return "发送成功！";
    }

    @GetMapping("/topicExchangeSender/{message}")
    public String topicExchangeSender(@PathVariable("message") String message){
        topicExchangeSender.topicSendOne(message);
        topicExchangeSender.topicSendTwo(message);
        return "发送成功！";
    }

    @GetMapping("/headersExchangeSender/{message}")
    public String headersExchangeSender(@PathVariable("message") String message){
        headersExchangeSender.headerSend(message);
        return "发送成功！";
    }

    @GetMapping("/fanoutExchangeSender/{message}")
    public String fanoutExchangeSender(@PathVariable("message") String message){
        fanoutExchangeSender.fanoutSend(message);
        return "发送成功！";
    }
}
