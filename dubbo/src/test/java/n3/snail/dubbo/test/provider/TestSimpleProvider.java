package n3.snail.dubbo.test.provider;

import com.alibaba.dubbo.config.annotation.Reference;
import n3.snail.dubbo.provider.SimpleProvider;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/3
 */
@ContextConfiguration(locations = { "classpath:dubbo-provider-test.xml" })
public class TestSimpleProvider extends AbstractTestNGSpringContextTests {

    @Reference(url="dubbo://127.0.0.1:22522/n3.snail.dubbo.provider.SimpleProvider?serialization=n3ProtobufSerialization", version="1.0.0", timeout=900000)
//    @Reference(registry = "zkRegistry", version="1.0.0", timeout=900000)
    private SimpleProvider simpleProvider;

    @Test
    public void testPing() {
        String response = simpleProvider.ping();
        assertEquals(response, "pong");
    }
}
