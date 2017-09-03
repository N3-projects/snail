package n3;

import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import n3.distribution.lock.sync.LockResource;
import n3.distribution.lock.sync.command.CommandRegistry;
import n3.distribution.lock.sync.command.RedisCommand;

import java.util.Set;

import static org.testng.Assert.assertTrue;

/**
 * @author N3 on 2017/6/17.
 */
public class RedisCommandTest {

    @Test
    public void testJedisApi() {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.137.23");

        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            /// ... do stuff here ... for example
//            jedis.set("foo", "bar");
//            String foobar = jedis.get("foo");
            jedis.zadd("sose", 0, "car");
            jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
            jedis.set("lockkey", "1", "NX" , "PX", 20000L);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        /// ... when closing your application:
        pool.destroy();
    }

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
}
