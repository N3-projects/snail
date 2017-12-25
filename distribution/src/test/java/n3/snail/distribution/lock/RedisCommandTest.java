package n3.snail.distribution.lock;

import org.testng.annotations.Test;
import redis.clients.jedis.*;
import n3.snail.distribution.lock.sync.LockResource;
import n3.snail.distribution.lock.sync.command.CommandRegistry;
import n3.snail.distribution.lock.sync.command.RedisCommand;

import java.util.Set;

import static org.testng.Assert.assertTrue;

/**
 * @author N3 on 2017/6/17.
 */
public class RedisCommandTest {

    @Test
    public void testRedisCommand() {
        RedisCommand redisCommand = CommandRegistry.getInstance().getRedisCommand();

        String key = "test";
        LockResource lockResource = new LockResource(30, "123456");

        boolean setSuc = redisCommand.setNx(key, lockResource);
        assertTrue(setSuc);
        boolean delSuc = redisCommand.del(key);
        assertTrue(delSuc);
    }

    @Test
    public void testJedisCluster() {
        JedisCluster jc = new JedisCluster(new HostAndPort("127.0.0.1", 7001));
        jc.hset(new byte[1], null, null);
    }
}
