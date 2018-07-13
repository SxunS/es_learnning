package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class MQProducer {
    private static Logger log = LoggerFactory.getLogger(MQProducer.class);
    private AmqpTemplate amqpTemplate;

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    @Autowired
    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(Object message){
        log.info("即将发送消息：=================》》》》  " + message);
        amqpTemplate.convertAndSend(message);
    }
}
