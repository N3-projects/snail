package n3.snail.hystrix.quickstart.command;

import com.netflix.hystrix.*;

/**
 * @author n3 on 2016/12/4.
 */
public class AdvancedCommand extends HystrixCommand<String> {

    public static final String COMMAND_KEY = "Hellscream";

    public AdvancedCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey(COMMAND_KEY))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(
                                HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(30)));

    }

    @Override
    protected String run() throws Exception {
        return "Advanced Result";
    }

}
