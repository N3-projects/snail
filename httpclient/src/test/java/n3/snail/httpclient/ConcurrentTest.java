package n3.snail.httpclient;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author N3 on 2017/3/5.
 */
public class ConcurrentTest {

    @Test(threadPoolSize = 5, invocationCount = 5000)
    public void testPost() {
        Map<String, String> map = new HashMap<>();
        map.put("username", "tiam");
        HttpClientUtil.executePost("https://epay.163.com/i.htm", map);
    }

    @Test
    public void testGet() {

    }
}
