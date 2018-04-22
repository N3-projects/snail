package n3.snail.distribution.cache.redis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * JedisPool只能访问非集群模式的redis服务，如果访问了redis cluster中的节点，会报错：
 * redis.clients.jedis.exceptions.JedisMovedDataException: MOVED 12182 192.168.137.96:7005
 * @author hzyemao
 * @version 1.0 , 2017/11/27
 */
public class JedisWithPool {

    private static Logger log = LogManager.getLogger(JedisWithPool.class);

    public static void main(String[] args) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        String host = "192.168.137.96";
        int port = 7001;
        int timeout = 5000;    //connectionTimeout和soTimeout都是这个值，单位：毫秒，默认2000
        String password = "loktarogar";
        JedisPool pool = new JedisPool(poolConfig, host, port, timeout, password);

        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            /// ... do stuff here ... for example
            String key = "foo";
            String value = "bar";
            log.info("set to redis: " + key + "=" + value);
            jedis.set(key, "bar");

            String cacheValue = jedis.get(key);
            log.info("get from redis: " + key + "=" + cacheValue);

            log.info("delete key : " + key);
            jedis.del(key);
            log.info("get from redis: " + key + "=" + jedis.get(key));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        /// ... when closing your application:
        pool.destroy();
    }
}
