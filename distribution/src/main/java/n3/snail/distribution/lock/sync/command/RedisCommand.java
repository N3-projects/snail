package n3.snail.distribution.lock.sync.command;

import n3.snail.distribution.lock.sync.LockResource;

/**redis命令接口
 * @author N3 on 2017/6/17.
 */
public interface RedisCommand {

    boolean setNx(String key, LockResource lockResource);

    boolean del(String key);
}
