package n3.snail.hystrix.quickstart;

import n3.snail.hystrix.quickstart.command.HelloWorldCommand;
import org.testng.annotations.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;

/**Hystrix入门使用参考样例
 * @author n3 on 2016/11/27.
 */
public class HelloWorldDemo {

    @Test
    public void testSimpleExecute() {
        HelloWorldCommand command = new HelloWorldCommand("Synchronous-hystrix");
        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
        String result = command.execute();
        System.out.println("result=" + result);

        //重复调用对应异常信息:HelloWorldCommand command executed multiple times - this is not permitted.
        //Caused by: This instance can only be executed once. Please instantiate a new instance.
        //command.execute();

        command = new HelloWorldCommand("Asynchronous-hystrix");
        //异步调用,可自由控制获取结果时机,
        Future<String> future = command.queue();
        //get操作不能超过command定义的超时时间,默认:1秒
        try {
            result = future.get(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("result=" + result);
        System.out.println("mainThread=" + Thread.currentThread().getName());
        /* 运行结果: run()方法在不同的线程下执行
        result=Hello Synchronous-hystrix thread:hystrix-HelloWorldGroup-1
        result=Hello Asynchronous-hystrix thread:hystrix-HelloWorldGroup-2
        mainThread=main
        */
        LockSupport.park();
    }

    @Test
    public void testObservable() throws Exception {
        HelloWorldCommand command = new HelloWorldCommand("Observable-hystrix");
        //注册观察者事件拦截
        Observable<String> fs = command.observe();
        //注册结果回调事件
        fs.subscribe(new Action1<String>() {
            @Override
            public void call(String result) {
                //result参数为HelloWorldCommand返回的结果
                //用户在这里对结果进行次处理.
                System.out.println("handle result here. result=" + result);
            }
        });

        //注册完整执行生命周期事件
        fs.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                // onNext/onError完成之后最后回调
                System.out.println("execute onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                // 当产生异常时回调
                System.out.println("onError " + e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onNext(String result) {
                // 获取结果后回调
                System.out.println("onNext: " + result);
            }
        });
        /* 运行结果
        handle result here. result=Hello Hello World thread:hystrix-ExampleGroup-3
        onNext: Hello observe-hystrix thread:hystrix-HelloWorldGroup-3
        execute onCompleted
        */
        LockSupport.park();
    }
}
