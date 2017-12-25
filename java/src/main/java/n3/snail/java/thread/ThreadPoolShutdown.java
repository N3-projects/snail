package n3.snail.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author N3 on 2017/11/9.
 */
public class ThreadPoolShutdown {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        threadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("************");
                boolean b = true;
                while(b) {

                }
                System.out.println("done");
                return null;
            }
        });
        System.out.println(threadPool.getActiveCount());
        threadPool.shutdown();
    }
}
