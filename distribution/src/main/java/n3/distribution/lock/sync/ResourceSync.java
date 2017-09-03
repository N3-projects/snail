package n3.distribution.lock.sync;

import n3.distribution.lock.SynchronizerType;

import java.util.concurrent.ConcurrentHashMap;

/**分布式锁的资源同步器，负责具体锁资源的抢占和释放，一般是中间件或数据库等。
 * @author N3 on 2017/6/12.
 */
public interface ResourceSync {

    boolean tryAcquire(String key, LockResource lockResource);

    boolean tryRelease(String key);

    class Factory {

        private static ConcurrentHashMap<SynchronizerType, ResourceSync> resourceSyncs = new ConcurrentHashMap<>();

        public static ResourceSync getInstance(SynchronizerType synchronizerType) {
            switch (synchronizerType) {
                case MEMCACHED: {
                    break;
                }
                default: {
                    throw new UnsupportedOperationException("please choose SynchronizerType.MEMCACHED");
                }
            }
            ResourceSync resourceSync = resourceSyncs.get(synchronizerType);
            if (resourceSync != null) {
                return resourceSync;
            }
            ResourceSync exist = resourceSyncs.putIfAbsent(synchronizerType, new MemcachedResourceSync());
            if (exist == null) {
                return resourceSyncs.get(synchronizerType);
            } else {
                return exist;
            }
        }
    }

}
