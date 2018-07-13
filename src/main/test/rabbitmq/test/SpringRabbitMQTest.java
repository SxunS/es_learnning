package rabbitmq.test;

import demo.MQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-rabbitmq.xml"})
public class SpringRabbitMQTest {

    @Autowired
    private MQProducer mQProducer;

    @Test
    public void test() throws InterruptedException {
        String message = "mqProducer 发送消息次数： ";
        for (int i = 0; i < 100; i++){
            mQProducer.sendMessage(message + i);
            Thread.sleep(1000);
        }
    }

}
