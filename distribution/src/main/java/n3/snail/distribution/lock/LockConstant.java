package n3.snail.distribution.lock;

/**相关常量设置
 * @author N3 on 2017/6/12.
 */
public class LockConstant {

    public static SynchronizerType defaultSync = SynchronizerType.MEMCACHED;
    public static int defaultExpireTime = 30;
    public static int defaultConnectTimeout = 2;

    public static void setDefaultSync(SynchronizerType defaultSync) {
        LockConstant.defaultSync = defaultSync;
    }

    public static void setDefaultExpireTime(int defaultExpireTime) {
        LockConstant.defaultExpireTime = defaultExpireTime;
    }

    public static void setDefaultConnectTimeout(int defaultConnectTimeout) {
        LockConstant.defaultConnectTimeout = defaultConnectTimeout;
    }
}
