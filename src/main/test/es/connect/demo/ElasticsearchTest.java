package es.connect.demo;

import org.elasticsearch.action.ListenableActionFuture;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticsearchTest {
    private Logger logger = LoggerFactory.getLogger(ElasticsearchTest.class);
    private static final String ES_HOST = "111.230.22.79";
    private static final int ES_PORT = 9300;
    private TransportClient client = null;
    @Before
    public void connect() throws UnknownHostException {
        client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ES_HOST), ES_PORT));
        logger.info("连接信息:" + client.toString());
    }
    @After
    public void closeConnecct(){
        if (null != client){
            client.close();
            logger.info("es客户端已经关闭。");
        }
    }

    /**
     * 查询prepareGet()   API
     */
    @Test
    public void getInfo(){
        GetRequestBuilder builder = client.prepareGet("test_index", "test_type", "1");
        GetResponse response = builder.get();
        logger.info("获取到信息：" + response.getSourceAsString() );
    }

    /**
     * 保存
     */
    @Test
    public void saveInfo(){

    }
}
