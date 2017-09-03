package n3.snail.hystrix.quickstart.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.exception.HystrixBadRequestException;

/**
 * HystrixCommand降级处理样例
 *
 * @author n3 on 2016/11/27.
 */
public class FallbackCommand extends HystrixCommand<Integer> {

    private final int value;

    public FallbackCommand(int value) {
        //最少配置:指定命令组名(CommandGroup)
        super(HystrixCommandGroupKey.Factory.asKey("FallbackGroup"));
        this.value = value;
    }

    @Override
    protected Integer run() {
        if (value % 3 == 0) {
            //执行fallback
            throw new RuntimeException("system exception");
        }
        if (value % 5 == 0) {
            //不会执行fallback
            throw new HystrixBadRequestException("BadRequestException");
        }
        return Math.abs(value);
    }

    @Override
    protected Integer getFallback() {
        System.out.println("fallback!");
        return -1;
    }
}

