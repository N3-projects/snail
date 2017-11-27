package n3.snail.distribution.lock.sync.command;

import n3.snail.distribution.lock.sync.LockResource;

/**
 * @author N3 on 2017/6/12.
 */
public interface MemcachedCommand {

    public boolean add(String key, LockResource lockResource);

    public boolean delete(String key);
}
