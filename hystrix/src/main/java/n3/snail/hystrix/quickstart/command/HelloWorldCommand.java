package n3.snail.hystrix.quickstart.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**HystrixCommand简单实现样例
 * @author n3 on 2016/11/27.
 */
public class HelloWorldCommand extends HystrixCommand<String> {

    private final String name;

    public HelloWorldCommand(String name) {
        //最少配置:指定命令组名(CommandGroup)
        super(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        // 依赖逻辑封装在run()方法中
        System.out.println("run !");
        return "Hello " + name + " thread:" + Thread.currentThread().getName();
    }

}

