package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;


public class MQConsumer implements MessageListener {
    private static Logger log = LoggerFactory.getLogger(MQConsumer.class);

    @Override
    public void onMessage(Message message) {
        log.info("接收到消息：" +  message);
    }
}
