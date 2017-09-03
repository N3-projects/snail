package n3.snail.hystrix.quickstart.module;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author n3 on 2016/12/26.
 */
public class HystrixSupport {

    private static AtomicBoolean avaiable = new AtomicBoolean(false);
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static boolean isHystrixAvaiable() {
        return avaiable.get();
    }

    public static void reload() {
//        avaiable.
    }
}
