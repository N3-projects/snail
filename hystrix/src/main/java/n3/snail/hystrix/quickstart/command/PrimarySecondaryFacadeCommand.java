package n3.snail.hystrix.quickstart.command;

import com.netflix.hystrix.*;

/**
 * @author n3 on 2016/12/8.
 */
public class PrimarySecondaryFacadeCommand extends HystrixCommand<String> {

    protected PrimarySecondaryFacadeCommand(String group) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(group))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(
                                HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(30)));    //默认10
    }

    @Override
    protected String run() throws Exception {
        if (isPrimaryCommandAvailable()) {
            return executePrimaryCommand();
        } else {
            return executeSecondaryCommand();
        }
    }

    private boolean isPrimaryCommandAvailable() {
        HystrixCircuitBreaker circuitBreaker = HystrixCircuitBreaker.Factory
                .getInstance(HystrixCommandKey.Factory.asKey(AdvancedCommand.COMMAND_KEY));
        return !circuitBreaker.isOpen();
    }

    private String executePrimaryCommand() {
        return new AdvancedCommand().execute();
    }

    private String executeSecondaryCommand() {
        return new HelloWorldCommand("Secondary").execute();
    }
}