package n3.distribution.lock.sync.command;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import n3.distribution.lock.sync.LockResource;

/**
 * @author N3 on 2017/6/17.
 */
public class InternalRedisCommand implements RedisCommand {

    private static JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.137.23");

    @Override
    public boolean setNx(String key, LockResource lockResource) {
        Jedis jedis = pool.getResource();
        String ok = jedis.set(key, lockResource.getValue(), "NX" , "PX", 20000L);
        return ok !=null && "OK".equals(ok);
    }

    @Override
    public boolean del(String key) {
        Jedis jedis = pool.getResource();
        Long del = jedis.del(key);
        return del == 1;
    }
}
