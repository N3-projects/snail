package n3.snail.distribution.lock.sync;

import n3.snail.distribution.lock.sync.command.CommandRegistry;
import n3.snail.distribution.lock.sync.command.MemcachedCommand;

/**依赖memcached实现的资源同步器
 * @author N3 on 2017/6/12.
 */
public class MemcachedResourceSync implements ResourceSync {

    private MemcachedCommand command;

    public MemcachedResourceSync() {
        this.command = CommandRegistry.getInstance().getMemcachedCommand();
    }

    @Override
    public boolean tryAcquire(String key, LockResource lockResource) {
        return command.add(key, lockResource);
    }

    @Override
    public boolean tryRelease(String key) {
        return command.delete(key);
    }
}
