package n3.snail.dubbo.test.boot;

import n3.snail.dubbo.boot.ApplicationBootstrap;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author N3 on 2017/9/2.
 */
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class TestBootstrap extends AbstractTestNGSpringContextTests {

    @Test
    public void testBootstrap() {
        ApplicationBootstrap.start(new String[0]);
    }
}
