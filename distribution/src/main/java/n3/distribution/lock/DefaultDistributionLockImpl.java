package n3.distribution.lock;

import n3.distribution.lock.sync.LockResource;
import n3.distribution.lock.sync.ResourceSync;

/**分布式锁默认实现类
 * @author N3 on 2017/6/12.
 */
public class DefaultDistributionLockImpl implements DistributionLock {

    DefaultDistributionLockImpl(Setter setter) {
        this.expireTime = setter.expireTime <= 0 ? LockConstant.defaultExpireTime : setter.expireTime;
        this.sync = setter.sync;
    }

    private final int expireTime;
    private ResourceSync sync;

    @Override
    public boolean tryLock(String key) {
        return sync.tryAcquire(key, new LockResource(expireTime, getLockResourceValue(key)));
    }

    @Override
    public void releaseLock(String key) {
        sync.tryRelease(key);
    }

    protected String getLockResourceValue(String key) {
        return String.valueOf(System.currentTimeMillis());
    }
}
