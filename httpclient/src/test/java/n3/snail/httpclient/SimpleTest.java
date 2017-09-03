package n3.snail.httpclient;

import org.testng.annotations.Test;

/**
 * @author N3 on 2017/3/5.
 */
public class SimpleTest {

    @Test
    public void testPost() {
        HttpClientUtil.executePost("http://127.0.0.1:8080/test", null);
        HttpClientUtil.executePost("http://127.0.0.1:8080/test", null);
    }

    @Test
    public void testGet() {

    }
}
