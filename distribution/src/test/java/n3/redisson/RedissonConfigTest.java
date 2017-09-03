package n3.redisson;

import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.testng.annotations.Test;

/**
 * @author N3 on 2017/6/19.
 */
public class RedissonConfigTest {

    @Test
    public void test() {
        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers();
//        clusterServersConfig.

    }
}
