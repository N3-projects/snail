package n3;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import n3.distribution.lock.DistributionLock;
import n3.distribution.lock.SynchronizerType;

/**
 * @author N3 on 2017/6/12.
 */
public class DistributionLockTest {

    @Test
    public void testnewInstance() {

        DistributionLock lock = null;

        lock = DistributionLock.newInstance();
//        lock = DistributionLock.newInstance(DistributionLock.Setter.withSynchronizerType(SynchronizerType.MEMCACHED));
        assertNotNull(lock);
        assertEquals(lock.getClass().getName(), "n3.distribution.lock.MemcachedDistributionLock");
    }

    @Test
    public void testMemcachedLock_sync() {

        DistributionLock lock = DistributionLock.newInstance(DistributionLock.Setter.withSynchronizerType(SynchronizerType.MEMCACHED));
        assertNotNull(lock);
        assertEquals(lock.getClass().getName(), "n3.distribution.lock.MemcachedDistributionLock");

        String key = "lock";
        boolean oper1 = lock.tryLock(key);
        boolean oper2 = lock.tryLock(key);

        System.out.println(oper1);
        System.out.println(oper2);
    }

    @Test(threadPoolSize = 50, invocationCount = 50, successPercentage=2)
    public void testMemcachedLock_concurrent() {
        DistributionLock lock = DistributionLock.newInstance(DistributionLock.Setter.withSynchronizerType(SynchronizerType.MEMCACHED));
        assertNotNull(lock);

        String key = "lock";
        boolean oper = lock.tryLock(key);

        assertTrue(oper);
    }
}
