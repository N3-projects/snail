package n3.snail.distribution.lock;

import n3.snail.distribution.lock.sync.ResourceSync;

/**分布式锁公共接口
 * @author N3 on 2017/6/11.
 */
public interface DistributionLock {

    boolean tryLock(String key);

    void releaseLock(String key);

    static DistributionLock newInstance() {
        return newInstance(new Setter(SynchronizerType.MEMCACHED));
    }

    static DistributionLock newInstance(Setter setter) {
        return new DefaultDistributionLockImpl(setter);
    }

    class Setter {

        public static Setter withSynchronizerType(SynchronizerType sync) {
            return new Setter(sync);
        }

        private Setter(SynchronizerType synchronizerType) {
            this.sync = ResourceSync.Factory.getInstance(synchronizerType);
        }

        ResourceSync sync;
        int expireTime;

        public void andExpireTime(int expireTime) {
            this.expireTime = expireTime;
        }
    }
}
