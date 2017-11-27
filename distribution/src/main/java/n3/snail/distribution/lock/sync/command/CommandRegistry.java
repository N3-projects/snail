package n3.snail.distribution.lock.sync.command;

import java.util.concurrent.atomic.AtomicReference;

/**资源命令注册器，用来注册自定义的客户端命令
 * @author N3 on 2017/6/12.
 */
public final class CommandRegistry {

    private final AtomicReference<MemcachedCommand> memcachedCommand = new AtomicReference<>();
    private final AtomicReference<RedisCommand> redisCommand = new AtomicReference<>();

    private static class Holder {
        private static final CommandRegistry instance = new CommandRegistry();
    }

    public static CommandRegistry getInstance() {
        return Holder.instance;
    }

    private CommandRegistry() {

    }

    public void registMemcachedCommand(MemcachedCommand command) {
        if (!memcachedCommand.compareAndSet(null, command)) {
            throw new IllegalStateException("Another command was already registered");
        }
    }

    public void registRedisCommand(RedisCommand command) {
        if (!redisCommand.compareAndSet(null, command)) {
            throw new IllegalStateException("Another command was already registered");
        }
    }

    public MemcachedCommand getMemcachedCommand() {
        MemcachedCommand exist = this.memcachedCommand.get();
        if (exist != null) {
            return exist;
        }
        MemcachedCommand internalCommand = new InternalMemcachedCommand();
        memcachedCommand.compareAndSet(null, internalCommand);
        return memcachedCommand.get();
    }

    public RedisCommand getRedisCommand() {
        RedisCommand exist = this.redisCommand.get();
        if (exist != null) {
            return exist;
        }
        RedisCommand internalCommand = new InternalRedisCommand();
        redisCommand.compareAndSet(null, internalCommand);
        return redisCommand.get();
    }
}
