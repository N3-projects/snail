package n3.distribution.lock.sync.command;

import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;
import n3.distribution.lock.LockConstant;
import n3.distribution.lock.sync.LockResource;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author N3 on 2017/6/12.
 */
/* package access */class InternalMemcachedCommand implements MemcachedCommand {

    private static MemcachedClient memcachedClient;

    static {
        try {
            InetSocketAddress socketAddress = new InetSocketAddress("192.168.137.23", 11211);
            memcachedClient = new MemcachedClient(socketAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(String key, LockResource lockResource) {
        OperationFuture<Boolean> add = memcachedClient.add(key, lockResource.getExpireTime(), lockResource.getValue());
        try {
            return add.get(LockConstant.defaultConnectTimeout, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String key) {
        OperationFuture<Boolean> delete = memcachedClient.delete(key);
        try {
            return delete.get(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        ConnectionFactoryBuilder builder = new ConnectionFactoryBuilder();
        builder.setHashAlg(null);
        InetSocketAddress socketAddress = new InetSocketAddress("192.168.137.23", 11211);
        try {
            memcachedClient = new MemcachedClient(builder.build(), Collections.singletonList(socketAddress));
        } catch (IOException e) {
            e.printStackTrace();
        }
        memcachedClient.set(null, 0, null, null);
    }
}
