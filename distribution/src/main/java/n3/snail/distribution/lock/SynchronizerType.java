package n3.snail.distribution.lock;

/**资源同步器枚举
 * @author N3 on 2017/6/11.
 */
public enum SynchronizerType {

    DATABASE,
    ZOOKEEPER,
    REDIS,
    MEMCACHED;
}
