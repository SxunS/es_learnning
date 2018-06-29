package reptile.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;

public class ReptileDemo {
    private Logger logger = LoggerFactory.getLogger(ReptileDemo.class);
    @Test
    public void testStart() throws IOException {
        String targetUrl = "https://www.jd.com/";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(targetUrl);
        CloseableHttpResponse response = client.execute(httpGet);
        try {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                String mimeType = contentType.getMimeType();
                byte[] bytes = EntityUtils.toByteArray(entity);
                String s = new String(bytes);
                logger.info("charset: " + charset);
                logger.info("mimeType: " + mimeType);
                logger.info("info: " + s);
            }
        } finally {
            response.close();
            client.close();
        }
    }
}
