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
        logger.debug("***********");
    }
}
